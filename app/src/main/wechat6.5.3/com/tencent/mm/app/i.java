package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.Intent;
import android.os.ConditionVariable;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.z;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i implements c, d {
    public static final long aQZ = be.Ni();
    private static final String aRh;
    private static final String aRi;
    private static String aRj = SQLiteDatabase.KeyEmpty;
    private static final String aRk = ("version:" + com.tencent.mm.protocal.d.lWh);
    private ag aRa = null;
    private a aRb;
    private volatile long aRc = 0;
    HashSet<String> aRd;
    String aRe;
    String aRf;
    ConditionVariable aRg;
    volatile b aRl;

    private class a extends FileObserver {
        final /* synthetic */ i aRn;

        a(i iVar, String str) {
            this.aRn = iVar;
            super(str, 712);
        }

        public final void onEvent(int i, String str) {
            Object obj = null;
            if (System.currentTimeMillis() - this.aRn.aRc < 120000) {
                obj = 1;
            }
            if (obj == null) {
                synchronized (this.aRn.aRd) {
                    switch (i) {
                        case 8:
                            v.i("MicroMsg.MMCrashReporter", "Detected trace file changed: " + str);
                            this.aRn.aRg.open();
                            if (this.aRn.aRl == null) {
                                this.aRn.aRl = new b();
                                e.a(this.aRn.aRl, "MMCrashReporter_parseANRTrace");
                                break;
                            }
                            break;
                        case FileUtils.S_IXUSR /*64*/:
                        case 512:
                            this.aRn.aRd.remove(str);
                            break;
                        case FileUtils.S_IWUSR /*128*/:
                            break;
                    }
                    this.aRn.aRd.add(str);
                }
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ i aRn;

        private b(i iVar) {
            this.aRn = iVar;
        }

        private static ProcessErrorStateInfo os() {
            List<ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) aa.getContext().getSystemService("activity")).getProcessesInErrorState();
            if (processesInErrorState == null) {
                return null;
            }
            for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                    return processErrorStateInfo;
                }
            }
            return null;
        }

        public final void run() {
            ArrayList arrayList;
            long currentTimeMillis = System.currentTimeMillis();
            v.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
            ProcessErrorStateInfo processErrorStateInfo = null;
            while (this.aRn.aRg.block(10000)) {
                this.aRn.aRg.close();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                processErrorStateInfo = os();
                if (processErrorStateInfo != null) {
                    break;
                }
            }
            if (processErrorStateInfo == null) {
                processErrorStateInfo = os();
                if (processErrorStateInfo == null) {
                    v.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                    this.aRn.aRl = null;
                    return;
                }
            }
            ProcessErrorStateInfo processErrorStateInfo2 = processErrorStateInfo;
            v.i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo2.processName + " @ " + processErrorStateInfo2.pid);
            synchronized (this.aRn.aRd) {
                String str;
                arrayList = new ArrayList(this.aRn.aRd.size());
                int lastIndexOf = this.aRn.aRf.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    str = this.aRn.aRf.substring(0, lastIndexOf) + '_' + processErrorStateInfo2.processName + this.aRn.aRf.substring(lastIndexOf);
                    if (this.aRn.aRd.remove(str)) {
                        arrayList.add(str);
                    }
                }
                if (this.aRn.aRd.remove(this.aRn.aRf)) {
                    arrayList.add(this.aRn.aRf);
                }
                arrayList.addAll(this.aRn.aRd);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str = i.a(this.aRn.aRe + '/' + ((String) it.next()), processErrorStateInfo2.pid, currentTimeMillis, processErrorStateInfo2);
                if (str != null) {
                    v.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", r0);
                    this.aRn.g(str, processErrorStateInfo2.pid);
                    break;
                }
                v.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", r0);
            }
            v.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
            this.aRn.aRl = null;
        }
    }

    static {
        String rK = p.rK();
        aRh = rK;
        aRi = o.getString(rK.hashCode());
    }

    private static String oq() {
        String A = ai.cse.A("login_weixin_username", SQLiteDatabase.KeyEmpty);
        if (be.kS(A)) {
            return ai.cse.A("login_user_name", "never_login_crash");
        }
        return A;
    }

    public static boolean bk(String str) {
        Object obj = null;
        aRj = str;
        if (j.ai.bmA() == null) {
            Object cls;
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Throwable e) {
                v.a("MicroMsg.MMCrashReporter", e, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = obj;
            }
            try {
                obj = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, aa.getContext().getClassLoader());
            } catch (Throwable e2) {
                v.a("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            v.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + aRj);
            v.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + obj + " thisProcName: " + aRj);
            Class du = com.tencent.mm.ay.c.du("sandbox", ".SubCoreSandBox");
            v.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + du + " thisProcName: " + aRj);
            if (du != null) {
                try {
                    af afVar = (af) du.newInstance();
                    j.ai.a(afVar);
                    v.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + afVar + " thisProcName: " + aRj);
                } catch (Throwable e3) {
                    v.a("MicroMsg.MMCrashReporter", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        c cVar;
        try {
            cVar = (c) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            cVar.ag(aa.getContext());
            ai.cse.A("last_login_uin", aRi);
            com.tencent.mm.sdk.b.b.a(cVar);
            AnonymousClass1 anonymousClass1 = new Object() {
            };
            return true;
        } catch (Exception e4) {
            v.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            cVar = new i();
            cVar.ag(aa.getContext());
            com.tencent.mm.sdk.b.b.a(cVar);
            String str2 = z.get("ro.product.cpu.abi");
            if (str2 == null || str2.length() == 0 || !(str2.equals("x86") || str2.equals("x86-64"))) {
                k.b("wechatCrashForJni", i.class.getClassLoader());
                CrashMonitorForJni.setClientVersionMsg(aRk);
            }
            bs.fZ(com.tencent.mm.compatible.util.e.cng);
            return false;
        }
    }

    public static void a(ag.c cVar) {
        ag.a(cVar);
    }

    private static void bl(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, 896).lastIndexOf("\n");
                if (-1 == lastIndexOf) {
                    break;
                }
                v.e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Throwable e) {
                v.a("MicroMsg.MMCrashReporter", e, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        v.e("MicroMsg.MMCrashReporter", str);
    }

    public final void ag(final Context context) {
        Throwable e;
        BufferedReader bufferedReader;
        ag.a((d) this);
        if (aRj.endsWith(":push")) {
            String str;
            try {
                str = z.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.aRe = file.getParent();
            if (this.aRe == null || this.aRe.length() == 0) {
                this.aRe = "/";
            }
            this.aRf = file.getName();
            this.aRg = new ConditionVariable();
            v.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: " + str);
            this.aRd = new HashSet();
            this.aRb = new a(this, this.aRe);
            this.aRb.startWatching();
            File[] listFiles = new File(context.getFilesDir(), "crash").listFiles(new FilenameFilter(this) {
                String aRm = context.getPackageName();
                final /* synthetic */ i aRn;

                public final boolean accept(File file, String str) {
                    return str.startsWith(this.aRm);
                }
            });
            if (listFiles != null) {
                StringBuilder stringBuilder = new StringBuilder(16384);
                Pattern compile = Pattern.compile("^signal (\\d+) \\([A-Z]+\\), code ");
                for (File file2 : listFiles) {
                    int i = -1;
                    v.i("MicroMsg.MMCrashReporter", "Uploading previous crash: " + file2);
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file2));
                        try {
                            stringBuilder.setLength(0);
                            while (true) {
                                Object readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i < 0) {
                                    Matcher matcher = compile.matcher(readLine);
                                    if (matcher.matches()) {
                                        i = be.getInt(matcher.group(1), 0);
                                    }
                                }
                                stringBuilder.append(readLine).append('\n');
                            }
                            if (stringBuilder.toString().startsWith(aRk)) {
                                String substring = stringBuilder.toString().substring(stringBuilder.toString().indexOf(aRk) + aRk.length());
                                if (substring != null && substring.trim().length() > 0) {
                                    a(i, substring, true);
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            try {
                                v.a("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                file2.delete();
                            } catch (Throwable th) {
                                e2 = th;
                            }
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        bufferedReader = null;
                        v.a("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        file2.delete();
                    } catch (Throwable th2) {
                        e2 = th2;
                        bufferedReader = null;
                    }
                    file2.delete();
                }
                return;
            }
            return;
        }
        return;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e7) {
            }
        }
        throw e2;
        throw e2;
    }

    public final void r(String str, String str2) {
        if (j.ai.bmA() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", oq());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            j.ai.bmA().o(aa.getContext(), intent);
        }
    }

    public final void a(com.tencent.mm.sdk.b.a aVar) {
        ag.a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.sdk.platformtools.ag r8, java.lang.String r9, java.lang.Throwable r10) {
        /*
        r7 = this;
        r6 = 0;
        r2 = "";
        r0 = r10 instanceof junit.framework.AssertionFailedError;
        if (r0 == 0) goto L_0x0072;
    L_0x0008:
        r3 = r10.getMessage();
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r0 != 0) goto L_0x0072;
    L_0x0012:
        r0 = r8.niV;
        r0 = r0.entrySet();
        r4 = r0.iterator();
        if (r4 == 0) goto L_0x006e;
    L_0x001e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x006e;
    L_0x0024:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 != 0) goto L_0x001e;
    L_0x0036:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x001e;
    L_0x003c:
        r1 = r3.startsWith(r1);
        if (r1 == 0) goto L_0x001e;
    L_0x0042:
        r0 = r0.getValue();
        r0 = (com.tencent.mm.sdk.platformtools.ag.b) r0;
        r0 = r0.AC();
    L_0x004c:
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 != 0) goto L_0x0072;
    L_0x0052:
        com.tencent.mm.app.l.b(r10);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = bm(r0);
        r0 = r1.append(r0);
        r0 = r0.append(r9);
        r0 = r0.toString();
        c(r0, r6, r6);
        return;
    L_0x006e:
        r0 = "";
        goto L_0x004c;
    L_0x0072:
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.i.a(com.tencent.mm.sdk.platformtools.ag, java.lang.String, java.lang.Throwable):void");
    }

    private static void c(String str, int i, boolean z) {
        com.tencent.recovery.b.bMv();
        bl(str);
        com.tencent.mm.bc.c.brO();
        g.iuh.a(11338, true, true, Integer.valueOf(2));
        g.iuh.a(25, 0, 1, true);
        if (aa.getProcessName().endsWith(":push")) {
            g.iuh.a(25, 2, 1, true);
        } else if (aa.getProcessName().endsWith(":tools")) {
            g.iuh.a(25, 3, 1, true);
        } else if (aa.getProcessName().endsWith(":exdevice")) {
            g.iuh.a(25, 4, 1, true);
        } else if (aa.bto()) {
            g.iuh.a(25, 1, 1, true);
        }
        g gVar = g.iuh;
        g.aKD();
        if (d.ae(aa.getContext()) == 1) {
            str = str.substring(0, d.af(aa.getContext()));
        }
        d.d(aa.getContext(), aa.getProcessName(), z ? "jni" : "java");
        if (i > 0 && str.length() > i) {
            str = str.substring(0, i);
        }
        if (j.ai.bmA() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", oq());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            j.ai.bmA().o(aa.getContext(), intent);
        }
    }

    public final void h(int i, String str) {
        a(i, str, false);
    }

    private static void a(int i, String str, boolean z) {
        String str2 = null;
        if (i == 6) {
            try {
                String or = or();
                if (or != null) {
                    str2 = a(or, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.MMCrashReporter", e, "Failed reporting JNI crash.", new Object[0]);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(1024);
        stringBuilder.append("#[jin_crash]sig=").append(i).append('\n');
        stringBuilder.append("#crash.previous=").append(z).append('\n');
        stringBuilder.append(bm(SQLiteDatabase.KeyEmpty));
        stringBuilder.append(str).append('\n');
        if (str2 != null) {
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str2);
        }
        c(stringBuilder.toString(), i == 6 ? 0 : 8192, true);
        v.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!z) {
            v.appenderClose();
        }
    }

    private static String or() {
        String str;
        try {
            str = z.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Throwable e) {
            v.a("MicroMsg.MMCrashReporter", e, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String processName = aa.getProcessName();
            if (processName == null || processName.length() == 0) {
                processName = "com.tencent.mm";
            }
            processName = str.substring(0, lastIndexOf) + '_' + processName + str.substring(lastIndexOf);
            if (new File(processName).isFile()) {
                return processName;
            }
        }
        return !new File(str).isFile() ? null : str;
    }

    static String a(String str, int i, long j, ProcessErrorStateInfo processErrorStateInfo) {
        BufferedReader bufferedReader;
        Throwable e;
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder(4096);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2 = "----- pid " + i + " at ";
        if (processErrorStateInfo != null) {
            stringBuilder.append(processErrorStateInfo.longMsg).append('\n');
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    switch (obj) {
                        case null:
                            if (!readLine.startsWith(str2)) {
                                break;
                            }
                            int length = str2.length();
                            long time = simpleDateFormat.parse(readLine.substring(length, length + 19)).getTime() - j;
                            if (time >= -60000 && time <= 60000) {
                                obj = 1;
                                break;
                            }
                        case 1:
                            stringBuilder.append(readLine).append('\n');
                            if (!readLine.startsWith("DALVIK THREADS")) {
                                if (!readLine.startsWith("-----")) {
                                    break;
                                }
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                }
                                return null;
                            }
                            obj = 2;
                            break;
                        case 2:
                            try {
                                if (!readLine.startsWith("----- end ")) {
                                    stringBuilder.append(readLine).append('\n');
                                    break;
                                }
                                String stringBuilder2 = stringBuilder.toString();
                                try {
                                    bufferedReader.close();
                                    return stringBuilder2;
                                } catch (IOException e3) {
                                    return stringBuilder2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                break;
                            }
                        default:
                            break;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            try {
                v.a("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    final void g(String str, int i) {
        com.tencent.recovery.b.bMw();
        com.tencent.mm.bc.c.brO();
        g.iuh.a(11339, true, true, Integer.valueOf(5000), Integer.valueOf(0));
        g.iuh.a(26, 0, 1, true);
        bl(str);
        g gVar = g.iuh;
        g.aKD();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aRc >= 120000) {
            this.aRc = currentTimeMillis;
            d.d(aa.getContext(), aa.getProcessName(), "anr");
            StringBuilder stringBuilder = new StringBuilder(4096);
            stringBuilder.append(bm(SQLiteDatabase.KeyEmpty));
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str);
            if (j.ai.bmA() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", ai.cse.A("login_user_name", "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                j.ai.bmA().o(aa.getContext(), intent);
            }
        }
    }

    private static String bm(String str) {
        String crashExtraMessage;
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IRUSR);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = aa.getContext();
        stringBuilderPrinter.println("#client.version=" + com.tencent.mm.protocal.d.lWh);
        stringBuilderPrinter.println("#client.verhistory=" + bs.Af());
        stringBuilderPrinter.println("#client.imei=" + p.rJ());
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.cmU);
        stringBuilderPrinter.println("#accinfo.uin=" + ai.cse.A("last_login_uin", aRi));
        stringBuilderPrinter.println("#accinfo.dev=" + aRh);
        stringBuilderPrinter.println("#accinfo.runtime=" + (be.Ni() - aQZ) + "(" + be.ma(aRj) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.cmX + ":" + com.tencent.mm.sdk.platformtools.e.cmY + ":" + f.aPW);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        stringBuilderPrinter.println("#qbmin.ver=" + QbSdk.getMiniQBVersion(context));
        if (aRj.contains(":tools") || aRj.contains(":appbrand")) {
            crashExtraMessage = WebView.getCrashExtraMessage(context);
            if (crashExtraMessage != null && crashExtraMessage.length() > 0) {
                if (crashExtraMessage.length() > 8192) {
                    crashExtraMessage = crashExtraMessage.substring(crashExtraMessage.length() - 8192);
                }
                stringBuilderPrinter.println("#qbrowser.crashmsg=" + Base64.encodeToString(crashExtraMessage.getBytes(), 2));
                v.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", crashExtraMessage);
            }
        }
        stringBuilderPrinter.println("#accinfo.env=" + (com.tencent.mm.sdk.b.b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + com.tencent.mm.sdk.b.b.nhm);
        String str2 = SQLiteDatabase.KeyEmpty;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.cni);
            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
            crashExtraMessage = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.cni, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            v.e("MicroMsg.MMCrashReporter", "check data size failed :%s", e.getMessage());
            crashExtraMessage = str2;
        }
        stringBuilderPrinter.println("#accinfo.data=" + crashExtraMessage);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        if (!be.kS(str)) {
            stringBuilderPrinter.println("#" + str);
        }
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }
}
