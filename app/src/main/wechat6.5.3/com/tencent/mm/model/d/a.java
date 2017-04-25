package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.al.m;
import com.tencent.mm.al.t;
import com.tencent.mm.bh.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.aa;
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
import java.util.LinkedList;
import java.util.Locale;

public class a implements a {
    private static final String aRh;
    private static final String aRi;
    public static String aRj = SQLiteDatabase.KeyEmpty;
    private static a cwk;
    private static final String cwl = (e.cni + "/tencent/MicroMsg/Handler/");
    public static final String cwm = (cwl + "Handler.trace");
    private static final long cwq = Looper.getMainLooper().getThread().getId();
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    private SharedPreferences cnm;
    private int cwA;
    private Long[] cwB;
    public long cwC;
    private String cwD;
    private LinkedList<a> cwE;
    long[] cwn;
    private long cwo;
    private volatile boolean cwp;
    private long cwr;
    private long cws;
    private long cwt;
    private long cwu;
    private long cwv;
    private long cww;
    private long cwx;
    private int cwy;
    private int cwz;

    static class a implements Comparable<a> {
        long cwH;
        String info;

        a() {
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (((a) obj).cwH - this.cwH);
        }
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        if (f.sj()) {
            File file;
            try {
                file = new File(cwl);
                if (!file.exists()) {
                    file.mkdirs();
                }
                aVar.a(new File(cwl, "Handler.trace"), false);
            } catch (Exception e2) {
            }
            file = new File(str);
            if (file.length() > aVar.cwu) {
                v.e("MicroMsg.HandlerTraceManager", "summer log file invaild foramt, recreate");
                aVar.a(file, true);
            }
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(d.bp(str2.getBytes()));
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        v.a("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        aVar.j(new File(cwm));
                        return;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e7) {
                e = e7;
                randomAccessFile = null;
                v.a("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                aVar.j(new File(cwm));
                return;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e;
            }
            aVar.j(new File(cwm));
            return;
        }
        v.i("MicroMsg.HandlerTraceManager", "summer sdcard is not Available, appendToFile fail ");
    }

    static {
        String rK = p.rK();
        aRh = rK;
        aRi = o.getString(rK.hashCode());
    }

    private a() {
        this.cwn = new long[]{0, 0, 0};
        this.cwo = 0;
        this.cwp = false;
        this.cwr = 8000;
        this.cws = 800;
        this.cwt = 25600;
        this.cwu = 35840;
        this.cwv = 86400000;
        this.cww = 180000;
        this.cwx = 5000;
        this.cwy = 120;
        this.cwz = 50;
        this.cwA = 1800000;
        this.cnm = aa.btk();
        this.cwB = new Long[18];
        this.cwC = 0;
        this.cwD = SQLiteDatabase.KeyEmpty;
        this.cwE = new LinkedList();
        this.cwr = this.cnm.getLong("handler_debug_log_time", 8000);
        this.cws = this.cnm.getLong("handler_debug_log_time_main", 800);
        this.cwt = this.cnm.getLong("handler_trace_file_full_size", 25600);
        this.cwu = this.cnm.getLong("handler_log_file_max_size", 35840);
        this.cwv = this.cnm.getLong("handler_upload_time_interval", 86400000);
        Arrays.fill(this.cwB, Long.valueOf(0));
    }

    public static a Aw() {
        if (cwk == null) {
            synchronized (a.class) {
                if (cwk == null) {
                    cwk = new a();
                }
            }
        }
        return cwk;
    }

    private void j(File file) {
        boolean z = true;
        if (file.exists()) {
            this.cwp = file.length() > this.cwt;
            if (this.cwp) {
                long j = this.cnm.getLong("handler_trace_log_file_full_time", 0);
                String str = "MicroMsg.HandlerTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (j == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                v.i(str, str2, objArr);
                if (j == 0) {
                    this.cnm.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
                    return;
                }
                return;
            }
            return;
        }
        this.cwp = false;
    }

    final String Ax() {
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
            v.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", e.getMessage());
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        printStream.println("#logfile.fulllast :" + (this.cnm.getLong("handler_trace_log_file_full_time", 0) - this.cnm.getLong("handler_trace_log_file_create_time", 0)));
        if (this.cwn[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.cwn[0] + " data size=" + this.cwn[1] + " code size=" + this.cwn[2]);
        }
        m[] fU = t.HS().fU(21);
        if (fU == null || fU.length == 0 || fU[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + fU[0].id + " version=" + fU[0].version);
        }
        printStream.println("#handler.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static String gl(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(d.bp(bArr));
                try {
                    fileInputStream2.close();
                    return str2;
                } catch (Exception e) {
                    return str2;
                }
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private void a(File file, boolean z) {
        v.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            j(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            v.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
        }
        Editor edit = this.cnm.edit();
        edit.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
        edit.putLong("handler_trace_log_file_full_time", 0).commit();
        j(file);
    }

    public final void Ay() {
        v.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
        this.cwr = this.cnm.getLong("handler_debug_log_time", 8000);
        this.cws = this.cnm.getLong("handler_debug_log_time_main", 800);
        this.cwt = this.cnm.getLong("handler_trace_file_full_size", 25600);
        this.cwu = this.cnm.getLong("handler_log_file_max_size", 35840);
        this.cwv = this.cnm.getLong("handler_upload_time_interval", 86400000);
        this.cww = this.cnm.getLong("handler_worker_assert_time", 180000);
        this.cwx = this.cnm.getLong("handler_worker_warn_time", 5000);
        this.cwy = (int) this.cnm.getLong("handler_worker_warn_task_max_size", 120);
        this.cwz = (int) this.cnm.getLong("handler_worker_warn_task_keep_size", 50);
        this.cwA = (int) this.cnm.getLong("handler_worker_warn_task_keep_size", 1800000);
        j(new File(cwm));
    }
}
