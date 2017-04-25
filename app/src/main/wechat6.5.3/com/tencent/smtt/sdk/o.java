package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.i;
import com.tencent.smtt.utils.p;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

final class o {
    private static o pwK;
    int esS;
    private Context mContext;
    long pwL;
    String pwM;
    String pwN;
    int pwO;
    int pwP;
    int pwQ;
    int pwR;
    String pwS;
    int pwT;
    int pwU;
    long pwV;
    long pwW;
    int pwX;
    private String pwY;
    String pwZ;
    long pxa;

    public enum a {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2);
        
        int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static class b {
        private final String pxg;
        private final String pxh;

        public b(String str, String str2) {
            this.pxg = str;
            this.pxh = str2;
        }

        public final void bNt() {
            FileOutputStream fileOutputStream;
            ZipOutputStream zipOutputStream;
            RandomAccessFile randomAccessFile;
            int parseInt;
            int read;
            Throwable th;
            BufferedInputStream bufferedInputStream;
            Throwable th2;
            ZipOutputStream zipOutputStream2;
            FileOutputStream fileOutputStream2;
            RandomAccessFile randomAccessFile2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.pxh);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.pxg;
                        FileInputStream fileInputStream;
                        BufferedInputStream bufferedInputStream2;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bufferedInputStream2 = new BufferedInputStream(fileInputStream, 2048);
                            } catch (Exception e) {
                                bufferedInputStream2 = null;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                randomAccessFile = new RandomAccessFile(new File(this.pxh), "rw");
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & WebView.NORMAL_MODE_ALPHA) & read);
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e4) {
                                }
                                zipOutputStream.close();
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th = th3;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                throw th;
                            }
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                                while (true) {
                                    int read2 = bufferedInputStream2.read(bArr, 0, 2048);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read2);
                                }
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e7) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                }
                            } catch (Exception e9) {
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                randomAccessFile = new RandomAccessFile(new File(this.pxh), "rw");
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & WebView.NORMAL_MODE_ALPHA) & read);
                                }
                                randomAccessFile.close();
                                zipOutputStream.close();
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                th2 = th4;
                                bufferedInputStream = bufferedInputStream2;
                                th = th2;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e10) {
                            bufferedInputStream2 = null;
                            fileInputStream = null;
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            randomAccessFile = new RandomAccessFile(new File(this.pxh), "rw");
                            parseInt = Integer.parseInt("00001000", 2);
                            randomAccessFile.seek(7);
                            read = randomAccessFile.read();
                            if ((read & parseInt) > 0) {
                                randomAccessFile.seek(7);
                                randomAccessFile.write(((parseInt ^ -1) & WebView.NORMAL_MODE_ALPHA) & read);
                            }
                            randomAccessFile.close();
                            zipOutputStream.close();
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = null;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                        try {
                            randomAccessFile = new RandomAccessFile(new File(this.pxh), "rw");
                            try {
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & WebView.NORMAL_MODE_ALPHA) & read);
                                }
                                randomAccessFile.close();
                            } catch (Exception e11) {
                                randomAccessFile2 = randomAccessFile;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e12) {
                                    }
                                }
                                zipOutputStream.close();
                                fileOutputStream.close();
                            } catch (Throwable th42) {
                                th2 = th42;
                                randomAccessFile2 = randomAccessFile;
                                th = th2;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e13) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e14) {
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            zipOutputStream.close();
                            fileOutputStream.close();
                        } catch (Throwable th6) {
                            th = th6;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            throw th;
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e15) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e16) {
                        }
                    } catch (Exception e17) {
                        zipOutputStream2 = zipOutputStream;
                        fileOutputStream2 = fileOutputStream;
                    } catch (Throwable th7) {
                        th = th7;
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e18) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e20) {
                    fileOutputStream2 = fileOutputStream;
                    if (zipOutputStream2 != null) {
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e21) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e22) {
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    zipOutputStream = null;
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e23) {
                fileOutputStream2 = null;
                if (zipOutputStream2 != null) {
                    zipOutputStream2.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th9) {
                th = th9;
                zipOutputStream = null;
                fileOutputStream = null;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    private o(Context context) {
        this.mContext = context.getApplicationContext();
        bMM();
    }

    private static String Qo(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        return stringBuilder.append(str).append("|").toString();
    }

    private static String ao(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
        }
        return str;
    }

    private JSONArray bNp() {
        String string = bNs().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            return new JSONArray(string);
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private static String eH(long j) {
        return j + "|";
    }

    public static synchronized o fx(Context context) {
        o oVar;
        synchronized (o.class) {
            if (pwK == null) {
                pwK = new o(context);
            }
            oVar = pwK;
        }
        return oVar;
    }

    private static String yO(int i) {
        return i + "|";
    }

    public final void Qm(String str) {
        setErrorCode(MMGIFException.D_GIF_ERR_DATA_TOO_BIG);
        this.pwY = str;
    }

    public final void Qn(String str) {
        if (str != null) {
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.pwZ = str;
        }
    }

    public final void a(int i, Throwable th) {
        String str;
        o oVar;
        if (th == null) {
            str = SQLiteDatabase.KeyEmpty;
            oVar = this;
        } else {
            str = Log.getStackTraceString(th);
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
                oVar = this;
            } else {
                oVar = this;
            }
        }
        oVar.pwZ = str;
        aA(i, this.pwZ);
    }

    public final void a(a aVar) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(yO(aVar.value));
        stringBuilder.append(Qo(c.V(this.mContext)));
        stringBuilder.append(Qo(com.tencent.smtt.utils.o.gb(this.mContext)));
        stringBuilder.append(yO(m.bNm().fn(this.mContext)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(Qo(str));
        str = this.mContext.getPackageName();
        stringBuilder.append(Qo(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(Qo(c.bu(this.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
        } else {
            stringBuilder.append(yO(c.getAppVersionCode(this.mContext)));
        }
        stringBuilder.append(Qo(ao(this.pwL)));
        stringBuilder.append(Qo(this.pwM));
        stringBuilder.append(Qo(this.pwN));
        stringBuilder.append(yO(this.pwO));
        stringBuilder.append(yO(this.pwP));
        stringBuilder.append(yO(this.pwQ));
        stringBuilder.append(yO(this.pwR));
        stringBuilder.append(Qo(this.pwS));
        stringBuilder.append(yO(this.pwT));
        stringBuilder.append(yO(this.pwU));
        stringBuilder.append(eH(this.pxa));
        stringBuilder.append(eH(this.pwV));
        stringBuilder.append(eH(this.pwW));
        stringBuilder.append(yO(this.pwX));
        stringBuilder.append(yO(this.esS));
        stringBuilder.append(Qo(this.pwY));
        stringBuilder.append(Qo(this.pwZ));
        stringBuilder.append(yO(i.fb(this.mContext).pwc.getInt("tbs_download_version", 0)));
        stringBuilder.append(Qo(c.fW(this.mContext)));
        stringBuilder.append(Qo("2.6.0.1061_36901"));
        stringBuilder.append(false);
        SharedPreferences bNs = bNs();
        JSONArray bNp = bNp();
        bNp.put(stringBuilder.toString());
        Editor edit = bNs.edit();
        edit.putString("tbs_download_upload", bNp.toString());
        edit.commit();
        bMM();
        new Thread(new Runnable(this) {
            final /* synthetic */ o pxb;

            {
                this.pxb = r1;
            }

            public final void run() {
                this.pxb.bNr();
            }
        }).start();
    }

    public final void aA(int i, String str) {
        if (!(i == 200 || i == 220 || i == 221)) {
            TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + i, true);
        }
        setErrorCode(i);
        this.pwL = System.currentTimeMillis();
        Qn(str);
        QbSdk.puW.hq(i);
        a(a.TYPE_INSTALL);
    }

    final void bMM() {
        this.pwL = 0;
        this.pwM = null;
        this.pwN = null;
        this.pwO = 0;
        this.pwP = 0;
        this.pwQ = 0;
        this.pwR = 2;
        this.pwS = "unknown";
        this.pwT = 0;
        this.pwU = 2;
        this.pwV = 0;
        this.pwW = 0;
        this.pwX = 1;
        this.esS = 0;
        this.pwY = null;
        this.pwZ = null;
        this.pxa = 0;
    }

    public final void bNq() {
        File file;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        File file2;
        FileInputStream fileInputStream2;
        com.tencent.smtt.utils.f.a anonymousClass2;
        HttpURLConnection l;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (com.tencent.smtt.utils.b.fS(this.mContext) == 3) {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath != null) {
                i.bNW();
                String bNX = i.bNX();
                String V = c.V(this.mContext);
                String fW = c.fW(this.mContext);
                byte[] bytes = V.getBytes();
                byte[] bytes2 = fW.getBytes();
                try {
                    bytes = i.bNW().by(bytes);
                    bytes2 = i.bNW().by(bytes2);
                } catch (Exception e) {
                }
                String bytesToHex = i.bytesToHex(bytes);
                String str = p.ge(this.mContext).pzB + bytesToHex + "&aid=" + i.bytesToHex(bytes2);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Charset", "UTF-8");
                hashMap.put("QUA2", com.tencent.smtt.utils.o.gb(this.mContext));
                try {
                    File file3 = new File(e.pyS);
                    new b(tbsLogFilePath, e.pyS + "/tbslog_temp.zip").bNt();
                    file = new File(e.pyS, "tbslog_temp.zip");
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e2) {
                        byteArrayOutputStream = null;
                        file2 = file;
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (file2 != null) {
                            file2.delete();
                            bytes2 = null;
                        } else {
                            bytes2 = null;
                        }
                        bytesToHex = str + "&ek=" + bNX;
                        anonymousClass2 = new com.tencent.smtt.utils.f.a(this) {
                            final /* synthetic */ o pxb;

                            {
                                this.pxb = r1;
                            }

                            public final void yN(int i) {
                                TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i);
                            }
                        };
                        if (bytes2 == null) {
                            l = f.l(bytesToHex, hashMap);
                            if (l == null) {
                                f.a(l, bytes2);
                                f.a(l, anonymousClass2, false);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                    try {
                        bytes2 = new byte[8192];
                        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream.read(bytes2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream3.write(bytes2, 0, read);
                            } catch (Exception e7) {
                                byteArrayOutputStream = byteArrayOutputStream3;
                                file2 = file;
                                fileInputStream2 = fileInputStream;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                            }
                        }
                        byteArrayOutputStream3.flush();
                        bytes2 = i.bNW().by(byteArrayOutputStream3.toByteArray());
                        try {
                            fileInputStream.close();
                        } catch (Exception e8) {
                        }
                        try {
                            byteArrayOutputStream3.close();
                        } catch (Exception e9) {
                        }
                        file.delete();
                    } catch (Exception e10) {
                        byteArrayOutputStream = null;
                        file2 = file;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (file2 != null) {
                            bytes2 = null;
                        } else {
                            file2.delete();
                            bytes2 = null;
                        }
                        bytesToHex = str + "&ek=" + bNX;
                        anonymousClass2 = /* anonymous class already generated */;
                        if (bytes2 == null) {
                            l = f.l(bytesToHex, hashMap);
                            if (l == null) {
                                f.a(l, bytes2);
                                f.a(l, anonymousClass2, false);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    byteArrayOutputStream = null;
                    file2 = null;
                    fileInputStream2 = null;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (file2 != null) {
                        file2.delete();
                        bytes2 = null;
                    } else {
                        bytes2 = null;
                    }
                    bytesToHex = str + "&ek=" + bNX;
                    anonymousClass2 = /* anonymous class already generated */;
                    if (bytes2 == null) {
                        l = f.l(bytesToHex, hashMap);
                        if (l == null) {
                            f.a(l, bytes2);
                            f.a(l, anonymousClass2, false);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    file = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
                bytesToHex = str + "&ek=" + bNX;
                anonymousClass2 = /* anonymous class already generated */;
                if (bytes2 == null) {
                    l = f.l(bytesToHex, hashMap);
                    if (l == null) {
                        f.a(l, bytes2);
                        f.a(l, anonymousClass2, false);
                    }
                }
            }
        }
    }

    public final void bNr() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] Run in UIThread, Report delay");
            return;
        }
        synchronized (this) {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray bNp = bNp();
            if (bNp.length() == 0) {
                TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
                return;
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + bNp);
            try {
                TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + f.a(p.ge(this.mContext).pzz, bNp.toString().getBytes("utf-8"), new com.tencent.smtt.utils.f.a(this) {
                    final /* synthetic */ o pxb;

                    {
                        this.pxb = r1;
                    }

                    public final void yN(int i) {
                        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                        if (i < SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD) {
                            Editor edit = this.pxb.bNs().edit();
                            edit.remove("tbs_download_upload");
                            edit.commit();
                        }
                    }
                }, true) + " testcase: -1");
            } catch (Throwable th) {
            }
        }
    }

    final SharedPreferences bNs() {
        return this.mContext.getSharedPreferences("tbs_download_stat", 4);
    }

    public final void setErrorCode(int i) {
        if (!(i == 100 || i == MMGIFException.D_GIF_ERR_CLOSE_FAILED || i == 120 || i == MMGIFException.D_GIF_ERR_NOT_READABLE || i >= 400)) {
            TbsLog.i("TbsDownload", "error occured, errorCode:" + i, true);
        }
        if (i == MMGIFException.D_GIF_ERR_NOT_READABLE) {
            TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
        }
        this.esS = i;
    }
}
