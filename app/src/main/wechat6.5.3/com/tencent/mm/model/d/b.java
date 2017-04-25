package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.al.m;
import com.tencent.mm.al.t;
import com.tencent.mm.bg.g;
import com.tencent.mm.bh.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b implements a {
    private static final String aRh;
    private static final String aRi;
    private static b cwI;
    public static final String cwJ = (e.cni + "/tencent/MicroMsg/SQLTrace/");
    public static List<String> cwS = Arrays.asList(new String[]{"IndexMicroMsg.db"});
    private SharedPreferences cnm = aa.btk();
    public long cwK;
    public long cwL;
    public long cwM;
    public long cwN;
    long cwO;
    private long cwP;
    private long cwQ;
    private long cwR;
    long[] cwn = new long[]{0, 0, 0};
    private long cwo = 0;
    public volatile boolean cwp = false;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b cwT;
        final /* synthetic */ String cwU;

        public AnonymousClass3(b bVar, String str) {
            this.cwT = bVar;
            this.cwU = str;
        }

        public final void run() {
            RandomAccessFile randomAccessFile;
            Throwable e;
            b bVar = this.cwT;
            String str = b.cwJ + "MMSQL.trace";
            String str2 = this.cwU + "\n";
            if (f.sj()) {
                File file;
                try {
                    file = new File(b.cwJ);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    bVar.a(new File(b.cwJ, "MMSQL.trace"), false);
                } catch (Exception e2) {
                    v.e("MicroMsg.SQLTraceManager", "init dir fail");
                }
                file = new File(str);
                if (file.length() > bVar.cwO) {
                    v.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
                    bVar.a(file, true);
                }
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek(randomAccessFile.length());
                        randomAccessFile.write(d.bp(str2.getBytes()));
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e3) {
                            v.a("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                        }
                    } catch (IOException e4) {
                        e3 = e4;
                        try {
                            v.a("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable e32) {
                                    v.a("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            bVar.j(new File(b.cwJ + "MMSQL.trace"));
                            return;
                        } catch (Throwable th) {
                            e32 = th;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable e5) {
                                    v.a("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            throw e32;
                        }
                    }
                } catch (IOException e6) {
                    e32 = e6;
                    randomAccessFile = null;
                    v.a("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    bVar.j(new File(b.cwJ + "MMSQL.trace"));
                    return;
                } catch (Throwable th2) {
                    e32 = th2;
                    randomAccessFile = null;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw e32;
                }
                bVar.j(new File(b.cwJ + "MMSQL.trace"));
                return;
            }
            v.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
        }
    }

    static {
        String rK = p.rK();
        aRh = rK;
        aRi = o.getString(rK.hashCode());
    }

    public static b AD() {
        if (cwI == null) {
            cwI = new b();
        }
        return cwI;
    }

    public b() {
        AE();
    }

    private void AE() {
        this.cwK = this.cnm.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.cwL = this.cnm.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.cwM = this.cnm.getLong("sql_trace_child_thread_interval_time", 1500);
        long aL = aL(aa.getContext());
        if (aL > 0) {
            this.cwK += aL;
            this.cwL += aL;
            this.cwM += aL;
            v.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", Long.valueOf(aL));
        }
        this.cwN = this.cnm.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.cwR = this.cnm.getLong("sql_trace_file_full_size", 30720);
        this.cwO = this.cnm.getLong("sql_trace_log_file_max_size", 35840);
        this.cwP = this.cnm.getLong("sql_trace_upload_file_min_size", 10240);
        this.cwQ = this.cnm.getLong("sql_upload_time_interval", 21600000);
        j(new File(cwJ, "MMSQL.trace"));
        v.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", Long.valueOf(this.cwK), Long.valueOf(this.cwL), Long.valueOf(this.cwM), Long.valueOf(this.cwN), Long.valueOf(this.cwR), Long.valueOf(this.cwO), Long.valueOf(this.cwP), Long.valueOf(this.cwQ));
    }

    public static void gn(String str) {
        PreferenceManager.getDefaultSharedPreferences(aa.getContext()).edit().putInt(str, PreferenceManager.getDefaultSharedPreferences(aa.getContext()).getInt(str, 0) + 1).commit();
        v.i("MicroMsg.SQLTraceManager", "Database corrupted: %s, crash count: %d", str, Integer.valueOf(r1));
    }

    public static void setup() {
        if (aa.niD) {
            v.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: " + com.tencent.mm.loader.stub.b.deleteFile(cwJ + "MMSQL.trace"));
        }
    }

    void j(File file) {
        boolean z = true;
        if (file.exists()) {
            this.cwp = file.length() > this.cwR;
            if (this.cwp) {
                long aK = aK(aa.getContext());
                String str = "MicroMsg.SQLTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (aK == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                v.i(str, str2, objArr);
                if (aK == 0) {
                    d(aa.getContext(), System.currentTimeMillis());
                    return;
                }
                return;
            }
            return;
        }
        this.cwp = false;
    }

    public static String gl(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable e;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(d.bp(bArr));
                try {
                    fileInputStream.close();
                    return str2;
                } catch (Throwable e2) {
                    v.a("MicroMsg.SQLTraceManager", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return str2;
                }
            } catch (IOException e3) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable e4) {
                        v.a("MicroMsg.SQLTraceManager", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e4 = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.SQLTraceManager", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                throw e4;
            }
        } catch (IOException e5) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e4;
        }
    }

    private static long a(String str, g gVar) {
        Cursor rawQuery = gVar.rawQuery("select count(*) from " + str, null);
        long j = 0;
        if (rawQuery.moveToFirst()) {
            j = rawQuery.getLong(0);
        }
        rawQuery.close();
        return j;
    }

    private String Ax() {
        String format;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + com.tencent.mm.protocal.d.lWh);
        printStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.cmU);
        printStream.println("#accinfo.uin=" + ai.cse.A("last_login_uin", aRi));
        printStream.println("#accinfo.dev=" + aRh);
        printStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.cmX + ":" + com.tencent.mm.sdk.platformtools.e.cmY + ":" + com.tencent.mm.sdk.platformtools.f.aPW);
        String str = SQLiteDatabase.KeyEmpty;
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.cni);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) aa.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.cni, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            v.e("MicroMsg.SQLTraceManager", "check data size failed :%s", e.getMessage());
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long aL = aL(aa.getContext());
        if (aL > 0) {
            printStream.println("#logfile.autoAdapteTime :" + aL);
        }
        if (aK(aa.getContext()) != 0) {
            long aK = aK(aa.getContext()) - aJ(aa.getContext());
            printStream.println("#logfile.fulllast :" + aK);
            if (aK > 0 && aK < 28800000) {
                PreferenceManager.getDefaultSharedPreferences(aa.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", aL + 100).commit();
                v.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", Long.valueOf(aL));
                AE();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - aJ(aa.getContext())));
        }
        m[] fU = t.HS().fU(21);
        if (fU == null || fU.length == 0 || fU[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + fU[0].id + " version=" + fU[0].version);
        }
        if (this.cwn[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.cwn[0] + " data size= " + this.cwn[1] + " code size =" + this.cwn[2]);
        }
        StringBuilder stringBuilder = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        ak.yW();
        printStream.println(stringBuilder.append(new File(c.xo()).length()).toString());
        stringBuilder = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder stringBuilder2 = new StringBuilder();
        ak.yW();
        printStream.println(stringBuilder.append(new File(stringBuilder2.append(c.xp()).append("SnsMicroMsg.db").toString()).length()).toString());
        ak.yW();
        a(c.wF(), printStream, Arrays.asList(new String[]{"message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"}));
        printStream.println("#sql.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static void a(g gVar, PrintStream printStream, List<String> list) {
        if (gVar == null || !gVar.isOpen()) {
            v.i("MicroMsg.SQLTraceManager", "db is not open!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor rawQuery = gVar.rawQuery("select name from sqlite_master where type='table' ", null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                printStream.println("#table : " + string + " count=" + a(string, gVar));
            }
            rawQuery.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + a(str, gVar));
            }
        }
        v.i("MicroMsg.SQLTraceManager", "dump all table count last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void a(String str, String str2, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(":").append(str2).append(" ");
    }

    public final void go(String str) {
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        Intent intent = new Intent();
        intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String A = ai.cse.A("login_weixin_username", SQLiteDatabase.KeyEmpty);
        if (be.kS(A)) {
            A = ai.cse.A("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, A);
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((Ax() + str).getBytes(), 2));
        aa.getContext().startService(intent);
    }

    void a(File file, boolean z) {
        v.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            j(file);
        }
        try {
            file.createNewFile();
            Context context = aa.getContext();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", System.currentTimeMillis()).commit();
            d(aa.getContext(), 0);
        } catch (IOException e) {
            v.e("MicroMsg.SQLTraceManager", "recreate log file fail");
        }
        j(file);
    }

    public static void c(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j).commit();
    }

    public static long aI(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
    }

    private static long aJ(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
    }

    private static void d(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j).commit();
    }

    private static long aK(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
    }

    private static long aL(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
    }

    public final void Ay() {
        v.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        AE();
    }
}
