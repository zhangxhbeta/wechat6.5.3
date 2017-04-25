package com.tencent.mm.bh;

import android.os.Debug;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements EventListener {
    static ac cnC = new ac() {
        public final void handleMessage(Message message) {
            v.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", Integer.valueOf(message.what));
            if (message.what == 0) {
                c.nyV.b((a) message.obj);
            } else if (message.what != 1) {
                c.nyV.a((a) message.obj);
            } else if (c.nyV.nzb != null) {
                b bVar = (b) c.nyV.nzb.get();
                if (bVar != null) {
                    bVar.byr();
                }
            }
            super.handleMessage(message);
        }
    };
    public static c nyV;
    private static int nyW = 5242880;
    public static final String nyY = (h.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    private volatile boolean cZr;
    private volatile boolean nyX;
    private LinkedBlockingQueue<a> nyZ;
    ExecutorService nza;
    public WeakReference<b> nzb;

    public static final class a {
        int bqE;
        String className;
        int nze;
        int nzf;
        String savePath;

        public a(String str, int i, int i2, int i3) {
            this.className = str;
            this.bqE = i;
            this.nze = i2;
            this.nzf = i3;
            StringBuilder stringBuilder = new StringBuilder();
            if (be.kS(str)) {
                stringBuilder.append(c.nyY).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
            } else {
                StringBuilder append = stringBuilder.append(c.nyY).append(str).append("_");
                String str2 = SQLiteDatabase.KeyEmpty;
                switch (i) {
                    case 1:
                        str2 = "onResume";
                        break;
                    case 2:
                        str2 = "onPause";
                        break;
                    case 3:
                        str2 = "onCreate";
                        break;
                    case 4:
                        str2 = "onScrool";
                        break;
                    case 5:
                        str2 = "all";
                        break;
                }
                append.append(str2).append(".trace");
            }
            v.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", stringBuilder.toString(), Integer.valueOf(i2));
            this.savePath = stringBuilder.toString();
        }
    }

    public interface b {
        void byr();
    }

    public static c byp() {
        if (nyV == null) {
            nyV = new c();
        }
        return nyV;
    }

    private void a(a aVar) {
        if (!this.nyX) {
            if (h.sj()) {
                byq();
                try {
                    File file = new File(nyY);
                    if (aVar.bqE != 6 && file.exists()) {
                        v.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                        A(file);
                    }
                    file.mkdirs();
                    Debug.startMethodTracing(aVar.savePath, aVar.nze <= 0 ? nyW : (aVar.nze * 1024) * 1024);
                    this.nyX = true;
                } catch (Throwable e) {
                    v.a("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable e2) {
                    this.nyX = false;
                    v.a("MicroMsg.TraceDebugManager", e2, "TRACE startMethodTracing ERROR", new Object[0]);
                }
                if (aVar.bqE == 6) {
                    v.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                    return;
                } else if (this.nyX) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = aVar;
                    if (be.kS(aVar.className) || aVar.bqE == 5) {
                        cnC.sendMessageDelayed(obtain, 15000);
                        return;
                    } else {
                        cnC.sendMessageDelayed(obtain, 10000);
                        return;
                    }
                } else {
                    return;
                }
            }
            v.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
        }
    }

    private static void byq() {
        cnC.removeMessages(0);
        cnC.removeMessages(2);
        cnC.removeMessages(1);
    }

    private static void A(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File A : listFiles) {
                A(A);
            }
            file.delete();
        }
    }

    public final boolean b(final a aVar) {
        byq();
        if (!this.nyX || this.cZr) {
            v.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", Boolean.valueOf(this.nyX), Boolean.valueOf(this.cZr));
            return false;
        } else if (h.sj()) {
            this.nza.execute(new Runnable(this) {
                final /* synthetic */ c nzd;

                public final void run() {
                    try {
                        Debug.stopMethodTracing();
                        String str = aVar.savePath;
                        int i = aVar.nzf;
                        if (aVar.savePath == null) {
                            this.nzd.nyX = false;
                            return;
                        }
                        File file = new File(str);
                        File file2 = new File(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
                        long currentTimeMillis = System.currentTimeMillis();
                        file.renameTo(file2);
                        file.delete();
                        v.i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
                        Process.setThreadPriority(10);
                        if (aVar.bqE == 6) {
                            Collection arrayList = new ArrayList();
                            arrayList.add(file2);
                            try {
                                p.a(arrayList, new File(file2.getAbsolutePath() + ".zip"));
                                c.cnC.sendEmptyMessage(1);
                                this.nzd.nyX = false;
                                return;
                            } catch (Throwable e) {
                                v.e("MicroMsg.TraceDebugManager", "exception:%s", be.e(e));
                                v.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
                                this.nzd.nyX = false;
                                return;
                            }
                        }
                        if (this.nzd.nyZ == null || this.nzd.nyZ.size() == 0) {
                            str = c.c(file2, true);
                            if (!be.kS(str)) {
                                c cVar = this.nzd;
                                if (i == 1 || (i == 3 && ak.isWifi(aa.getContext()))) {
                                    cVar.NU(str);
                                }
                            }
                        }
                        this.nzd.nyX = false;
                    } catch (Throwable e2) {
                        v.a("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
                    } catch (Throwable th) {
                        this.nzd.nyX = false;
                    }
                }
            });
            return true;
        } else {
            v.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            return false;
        }
    }

    private static String c(File file, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            v.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                v.e("MicroMsg.TraceDebugManager", " get file list failed");
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(file);
        }
        File file2 = new File(nyY + be.Ni() + ".zip");
        try {
            p.a(arrayList, file2);
            for (int i = 0; i < arrayList.size(); i++) {
                ((File) arrayList.get(i)).delete();
            }
            if (file2.length() <= 3145728) {
                return file2.getAbsolutePath();
            }
            v.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", Long.valueOf(file2.length()));
            return null;
        } catch (Throwable e) {
            v.e("MicroMsg.TraceDebugManager", "exception:%s", be.e(e));
            v.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
            return null;
        }
    }

    private c() {
    }

    public final void bX(String str, int i) {
        if (this.nyZ != null && this.nyZ.size() > 0) {
            v.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", Boolean.valueOf(this.cZr), Boolean.valueOf(this.nyX), str, Integer.valueOf(i));
            if (!this.cZr && !this.nyX) {
                Iterator it = this.nyZ.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.className == null) {
                        a(null);
                        this.nyZ.remove(aVar);
                        return;
                    } else if (aVar.className.equals(str) && aVar.bqE == i) {
                        a(aVar);
                        this.nyZ.remove(aVar);
                        return;
                    }
                }
            }
        }
    }

    final void NU(String str) {
        if (str != null) {
            this.cZr = true;
            if (be.kS(str)) {
                v.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", str);
            } else if (h.sj()) {
                File file = new File(str);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        str = c(file, true);
                    }
                    if (str != null && new File(str).length() >= 131072) {
                        v.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", Boolean.valueOf(com.tencent.mm.platformtools.p.a(str, k.xF(), true, false)));
                        if (com.tencent.mm.platformtools.p.a(str, k.xF(), true, false)) {
                            e.e(new File(nyY));
                        }
                    }
                } else {
                    v.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
                }
            } else {
                v.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
            }
            this.cZr = false;
        }
    }

    public final void c(a aVar) {
        if (aVar.bqE > 0) {
            if (this.nza == null) {
                this.nza = Executors.newSingleThreadExecutor();
            }
            if (this.cZr || this.nyX) {
                v.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", Boolean.valueOf(this.cZr), Boolean.valueOf(this.nyX));
                return;
            }
            cnC.removeMessages(0);
            if (aVar.nzf == 4 || aVar.nzf == 5) {
                final int i = aVar.nzf;
                this.nza.execute(new Runnable(this) {
                    final /* synthetic */ c nzd;

                    public final void run() {
                        this.nzd.NU(i == 4 ? "/data/anr/" : c.nyY);
                    }
                });
            } else if (aVar.bqE == 6 || aVar.bqE == 5) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = aVar;
                if (aVar.bqE == 5) {
                    cnC.sendMessage(obtain);
                } else {
                    cnC.sendMessageDelayed(obtain, 500);
                }
            } else {
                if (this.nyZ == null) {
                    this.nyZ = new LinkedBlockingQueue();
                }
                this.nyZ.clear();
                this.nyZ.add(aVar);
            }
            v.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", aVar.className, Integer.valueOf(aVar.bqE), Integer.valueOf(aVar.nzf));
        }
    }
}
