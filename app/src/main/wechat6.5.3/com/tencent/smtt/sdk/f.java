package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.t;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

final class f {
    private static int pvs = 5;
    private static int pvt = 1;
    private static final String[] pvu = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.x5sdk.demo", "tbs_downloading_com.qzone"};
    boolean QK;
    private int dov;
    Context mContext;
    private String mDownloadUrl;
    private boolean mFinished;
    private int pvA = 20000;
    private boolean pvB;
    private int pvC;
    private HttpURLConnection pvD;
    private String pvE;
    private o pvF;
    private String pvG;
    private int pvH;
    private boolean pvI;
    private Handler pvJ;
    private Set<String> pvK;
    private int pvL = pvs;
    boolean pvM;
    String pvN;
    String[] pvO = null;
    int pvP = 0;
    private String pvv;
    private String pvw;
    File pvx;
    private long pvy;
    private int pvz = 30000;

    public f(Context context) {
        this.mContext = context.getApplicationContext();
        this.pvF = o.fx(this.mContext);
        this.pvK = new HashSet();
        this.pvE = "tbs_downloading_" + this.mContext.getPackageName();
        m.bNm();
        this.pvx = m.ft(this.mContext);
        if (this.pvx == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        bMM();
        this.pvG = null;
        this.pvH = -1;
    }

    private boolean J(boolean z, boolean z2) {
        long j = 0;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z);
        File file = new File(this.pvx, !z ? "x5.tbs" : "x5.tbs.temp");
        if (!file.exists()) {
            return false;
        }
        String string = i.fb(this.mContext).pwc.getString("tbs_apk_md5", null);
        String C = a.C(file);
        if (string == null || !string.equals(C)) {
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
            if (!z) {
                return false;
            }
            this.pvF.Qm("fileMd5 not match");
            return false;
        }
        boolean renameTo;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + C + ") successful!");
        if (z) {
            long j2;
            long j3 = i.fb(this.mContext).pwc.getLong("tbs_apkfilesize", 0);
            if (!file.exists()) {
                j2 = 0;
            } else if (j3 > 0) {
                j2 = file.length();
                if (j3 == j2) {
                    j = j2;
                }
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
            this.pvF.Qm("fileLength:" + j2 + ",contentLength:" + j3);
            return false;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
        int i = -1;
        if (z2) {
            i = a.b(this.mContext, file);
            int i2 = i.fb(this.mContext).pwc.getInt("tbs_download_version", 0);
            if (i2 != i) {
                TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                if (!z) {
                    return false;
                }
                this.pvF.Qm("fileVersion:" + i + ",configVersion:" + i2);
                return false;
            }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
        if (z2) {
            string = c.c(this.mContext, file);
            if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(string)) {
                TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                if (!z) {
                    return false;
                }
                this.pvF.Qm("signature:" + (string == null ? "null" : Integer.valueOf(string.length())));
                return false;
            }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
        if (z) {
            Throwable th;
            try {
                renameTo = file.renameTo(new File(this.pvx, "x5.tbs"));
                th = null;
            } catch (Throwable e) {
                th = e;
                renameTo = false;
            }
            if (!renameTo) {
                i(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, g(th), true);
                return false;
            }
        }
        renameTo = false;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + renameTo + ") successful!");
        return true;
    }

    public static void a(File file, Context context) {
        if (file.exists()) {
            try {
                File eX = eX(context);
                if (eX != null) {
                    File file2 = new File(eX, j.fe(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                    file2.delete();
                    e.f(file, file2);
                }
            } catch (Exception e) {
            }
        }
    }

    private static File aa(Context context, int i) {
        File file = new File(e.ae(context, i));
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return new File(file, j.fe(context) ? "x5.oversea.tbs.org" : "x5.tbs.org").exists() ? file : null;
    }

    private void bMM() {
        this.dov = 0;
        this.pvC = 0;
        this.pvy = -1;
        this.pvw = null;
        this.pvB = false;
        this.QK = false;
        this.mFinished = false;
        this.pvI = false;
    }

    private boolean bMN() {
        try {
            File file = new File(this.pvx, "x5.tbs");
            File eX = eX(this.mContext);
            if (eX != null) {
                File file2 = new File(eX, j.fe(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                file.delete();
                e.f(file2, file);
            }
            return true;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            return false;
        }
    }

    private boolean bMO() {
        if (this.pvO == null || this.pvP < 0 || this.pvP >= this.pvO.length) {
            return false;
        }
        String[] strArr = this.pvO;
        int i = this.pvP;
        this.pvP = i + 1;
        this.pvw = strArr[i];
        this.dov = 0;
        this.pvC = 0;
        this.pvy = -1;
        this.pvB = false;
        this.QK = false;
        this.mFinished = false;
        this.pvI = false;
        return true;
    }

    private long bMP() {
        File file = new File(this.pvx, "x5.tbs.temp");
        return file.exists() ? file.length() : 0;
    }

    private static boolean bMQ() {
        Closeable inputStream;
        Closeable inputStreamReader;
        Closeable bufferedReader;
        Throwable th;
        boolean z = false;
        Closeable closeable = null;
        try {
            inputStream = Runtime.getRuntime().exec("ping " + "www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains("TTL") || readLine.contains("ttl")) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = bufferedReader;
                        }
                    } while (i < 5);
                    g(inputStream);
                    g(inputStreamReader);
                    g(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    g(inputStream);
                    g(inputStreamReader);
                    g(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                g(inputStream);
                g(inputStreamReader);
                g(closeable);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            inputStream = null;
            g(inputStream);
            g(inputStreamReader);
            g(closeable);
            throw th;
        }
        return z;
    }

    private boolean bMR() {
        HttpURLConnection httpURLConnection;
        CharSequence charSequence;
        Object obj;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = b.fS(this.mContext) == 3;
        TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z3);
        if (z3) {
            String fT = b.fT(this.mContext);
            TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + fT);
            try {
                httpURLConnection = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.getInputStream();
                    int responseCode = httpURLConnection.getResponseCode();
                    TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    if (responseCode != 204) {
                        z = false;
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                            charSequence = fT;
                            z2 = z;
                        } catch (Exception e) {
                            obj = fT;
                            z2 = z;
                        }
                    } else {
                        obj = fT;
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    httpURLConnection2 = httpURLConnection;
                    th = th2;
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
        if (!(z2 || TextUtils.isEmpty(charSequence) || this.pvK.contains(charSequence))) {
            this.pvK.add(charSequence);
            if (this.pvJ == null) {
                this.pvJ = new Handler(this, k.bNl().getLooper()) {
                    final /* synthetic */ f pvQ;

                    public final void handleMessage(Message message) {
                        if (message.what == 150) {
                            this.pvQ.bMR();
                        }
                    }
                };
            }
            this.pvJ.sendMessageDelayed(this.pvJ.obtainMessage(150, charSequence), 120000);
        }
        if (z2 && this.pvK.contains(charSequence)) {
            this.pvK.remove(charSequence);
        }
        return z2;
    }

    private static String c(URL url) {
        String str = SQLiteDatabase.KeyEmpty;
        try {
            str = InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e) {
        } catch (Error e2) {
        }
        return str;
    }

    private void eG(long j) {
        long j2;
        this.dov++;
        if (j <= 0) {
            try {
                switch (this.dov) {
                    case 1:
                    case 2:
                        j2 = 20000 * ((long) this.dov);
                        break;
                    case 3:
                    case 4:
                        j2 = 100000;
                        break;
                    default:
                        j2 = 200000;
                        break;
                }
            } catch (Exception e) {
                return;
            }
        }
        j2 = j;
        Thread.sleep(j2);
    }

    @TargetApi(8)
    static File eX(Context context) {
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(e.ae(context, 4)) : null;
            if (file == null || file.exists() || file.isDirectory()) {
                return file;
            }
            file.mkdirs();
            return file;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    @TargetApi(8)
    static File eY(Context context) {
        try {
            if (VERSION.SDK_INT < 8) {
                return null;
            }
            File aa = aa(context, 4);
            if (aa == null) {
                aa = aa(context, 3);
            }
            if (aa == null) {
                aa = aa(context, 2);
            }
            return aa == null ? aa(context, 1) : aa;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    public static void eZ(Context context) {
        try {
            m.bNm();
            File ft = m.ft(context);
            new File(ft, "x5.tbs").delete();
            new File(ft, "x5.tbs.temp").delete();
            ft = eX(context);
            if (ft != null) {
                new File(ft, "x5.tbs.org").delete();
                new File(ft, "x5.oversea.tbs.org").delete();
            }
        } catch (Exception e) {
        }
    }

    private static String g(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    private static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private void i(int i, String str, boolean z) {
        if (z || this.dov > this.pvL) {
            this.pvF.setErrorCode(i);
            this.pvF.Qn(str);
        }
    }

    private void kA(boolean z) {
        t.gg(this.mContext);
        i fb = i.fb(this.mContext);
        fb.pwb.put("request_full_package", Boolean.valueOf(false));
        fb.pwb.put("tbs_needdownload", Boolean.valueOf(false));
        fb.pwb.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
        fb.commit();
        QbSdk.puW.hp(z ? 100 : 120);
        int i = fb.pwc.getInt("tbs_responsecode", 0);
        if (i == 3 || i > 10000) {
            File eX = eX(this.mContext);
            if (eX != null) {
                File file = new File(eX, j.fe(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                int b = a.b(this.mContext, file);
                File file2 = new File(this.pvx, "x5.tbs");
                String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
                int i2 = fb.pwc.getInt("tbs_download_version", 0);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", i);
                bundle.putInt("old_core_ver", b);
                bundle.putInt("new_core_ver", i2);
                bundle.putString("old_apk_location", file.getAbsolutePath());
                bundle.putString("new_apk_location", absolutePath);
                bundle.putString("diff_file_location", absolutePath);
                m.bNm().e(this.mContext, bundle);
                return;
            }
            clearCache();
            fb.pwb.put("tbs_needdownload", Boolean.valueOf(true));
            fb.commit();
            return;
        }
        int i3 = fb.pwc.getInt("tbs_download_version", 0);
        m.bNm();
        m.l(this.mContext, new File(this.pvx, "x5.tbs").getAbsolutePath(), i3);
        a(new File(this.pvx, "x5.tbs"), this.mContext);
    }

    private boolean kB(boolean z) {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + z);
        File file = z ? new File(this.pvx, "x5.tbs") : new File(this.pvx, "x5.tbs.temp");
        return file.exists() ? file.delete() : true;
    }

    public final void clearCache() {
        this.QK = true;
        kB(false);
        kB(true);
    }

    public final boolean ky(boolean z) {
        int i;
        int i2 = i.fb(this.mContext).pwc.getInt("use_backup_version", 0);
        int fl = m.bNm().fl(this.mContext);
        if (i2 == 0) {
            i2 = i.fb(this.mContext).pwc.getInt("tbs_download_version", 0);
            this.pvN = "by default key";
            i = i2;
        } else {
            this.pvN = "by new key";
            i = i2;
        }
        if (i == 0 || i == fl) {
            return false;
        }
        if (z) {
            boolean z2;
            File file;
            File file2;
            File yM = j.yM(i);
            if (yM != null && yM.exists()) {
                try {
                    e.f(yM, new File(e.ae(this.mContext, 4), j.fe(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                    z2 = true;
                } catch (Exception e) {
                }
                file = new File(e.ae(this.mContext, 4), j.fe(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                fl = i.fb(this.mContext).pwc.getInt("use_backup_version", 0);
                if (fl == 0) {
                    fl = i.fb(this.mContext).pwc.getInt("tbs_download_version", 0);
                }
                if (a.a(this.mContext, file, fl)) {
                    try {
                        file2 = new File(e.ae(this.mContext, 4), j.fe(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (Exception e2) {
                    }
                    if (!a.a(this.mContext, yM, i)) {
                        e.F(yM);
                    }
                } else if (bMN()) {
                    i.fb(this.mContext).pwb.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
                    i.fb(this.mContext).yK(-214);
                    kA(false);
                    if (z2) {
                        return true;
                    }
                    i(100, "use local backup apk in startDownload" + this.pvN, true);
                    this.pvF.a(o.a.TYPE_DOWNLOAD);
                    return true;
                }
            }
            z2 = false;
            if (j.fe(this.mContext)) {
            }
            file = new File(e.ae(this.mContext, 4), j.fe(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            fl = i.fb(this.mContext).pwc.getInt("use_backup_version", 0);
            if (fl == 0) {
                fl = i.fb(this.mContext).pwc.getInt("tbs_download_version", 0);
            }
            if (a.a(this.mContext, file, fl)) {
                if (j.fe(this.mContext)) {
                }
                file2 = new File(e.ae(this.mContext, 4), j.fe(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (file2.exists()) {
                    file2.delete();
                }
                if (a.a(this.mContext, yM, i)) {
                    e.F(yM);
                }
            } else if (bMN()) {
                i.fb(this.mContext).pwb.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
                i.fb(this.mContext).yK(-214);
                kA(false);
                if (z2) {
                    return true;
                }
                i(100, "use local backup apk in startDownload" + this.pvN, true);
                this.pvF.a(o.a.TYPE_DOWNLOAD);
                return true;
            }
        }
        if (J(false, z)) {
            i.fb(this.mContext).pwb.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
            i.fb(this.mContext).yK(-214);
            kA(false);
            return true;
        }
        if (!(kB(true) || kB(true))) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
            i.fb(this.mContext).yK(-301);
        }
        return false;
    }

    public final void kz(boolean r35) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r34 = this;
        r4 = com.tencent.smtt.sdk.m.bNm();
        r0 = r34;
        r5 = r0.mContext;
        r4 = r4.fg(r5);
        if (r4 == 0) goto L_0x0021;
    L_0x000e:
        if (r35 != 0) goto L_0x0021;
    L_0x0010:
        r4 = 0;
        com.tencent.smtt.sdk.j.pwk = r4;
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r5 = -322; // 0xfffffffffffffebe float:NaN double:NaN;
        r4.yK(r5);
    L_0x0020:
        return;
    L_0x0021:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwc;
        r5 = "tbs_responsecode";
        r6 = 0;
        r4 = r4.getInt(r5, r6);
        r5 = 1;
        if (r4 == r5) goto L_0x003c;
    L_0x0036:
        r5 = 2;
        if (r4 == r5) goto L_0x003c;
    L_0x0039:
        r5 = 4;
        if (r4 != r5) goto L_0x004a;
    L_0x003c:
        r4 = 1;
        r5 = r4;
    L_0x003e:
        r0 = r34;
        r4 = r0.ky(r5);
        if (r4 == 0) goto L_0x004d;
    L_0x0046:
        r4 = 0;
        com.tencent.smtt.sdk.j.pwk = r4;
        goto L_0x0020;
    L_0x004a:
        r4 = 0;
        r5 = r4;
        goto L_0x003e;
    L_0x004d:
        r0 = r35;
        r1 = r34;
        r1.pvM = r0;
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwc;
        r6 = "tbs_downloadurl";
        r7 = 0;
        r4 = r4.getString(r6, r7);
        r0 = r34;
        r0.mDownloadUrl = r4;
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwc;
        r6 = "tbs_downloadurl_list";
        r7 = 0;
        r4 = r4.getString(r6, r7);
        r6 = "TbsDownload";
        r7 = new java.lang.StringBuilder;
        r8 = "backupUrlStrings:";
        r7.<init>(r8);
        r7 = r7.append(r4);
        r7 = r7.toString();
        r8 = 1;
        com.tencent.smtt.utils.TbsLog.i(r6, r7, r8);
        r6 = 0;
        r0 = r34;
        r0.pvO = r6;
        r6 = 0;
        r0 = r34;
        r0.pvP = r6;
        if (r35 != 0) goto L_0x00bc;
    L_0x009e:
        if (r4 == 0) goto L_0x00bc;
    L_0x00a0:
        r6 = "";
        r7 = r4.trim();
        r6 = r6.equals(r7);
        if (r6 != 0) goto L_0x00bc;
    L_0x00ad:
        r6 = r4.trim();
        r7 = ";";
        r6 = r6.split(r7);
        r0 = r34;
        r0.pvO = r6;
    L_0x00bc:
        r6 = "TbsDownload";
        r7 = new java.lang.StringBuilder;
        r8 = "[TbsApkDownloader.startDownload] mDownloadUrl=";
        r7.<init>(r8);
        r0 = r34;
        r8 = r0.mDownloadUrl;
        r7 = r7.append(r8);
        r8 = " backupUrlStrings=";
        r7 = r7.append(r8);
        r4 = r7.append(r4);
        r7 = " mLocation=";
        r4 = r4.append(r7);
        r0 = r34;
        r7 = r0.pvw;
        r4 = r4.append(r7);
        r7 = " mCanceled=";
        r4 = r4.append(r7);
        r0 = r34;
        r7 = r0.QK;
        r4 = r4.append(r7);
        r7 = " mHttpRequest=";
        r4 = r4.append(r7);
        r0 = r34;
        r7 = r0.pvD;
        r4 = r4.append(r7);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r6, r4);
        r0 = r34;
        r4 = r0.mDownloadUrl;
        if (r4 != 0) goto L_0x0130;
    L_0x0114:
        r0 = r34;
        r4 = r0.pvw;
        if (r4 != 0) goto L_0x0130;
    L_0x011a:
        r4 = com.tencent.smtt.sdk.QbSdk.puW;
        r5 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r4.hp(r5);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r5 = -302; // 0xfffffffffffffed2 float:NaN double:NaN;
        r4.yK(r5);
        goto L_0x0020;
    L_0x0130:
        r0 = r34;
        r4 = r0.pvD;
        if (r4 == 0) goto L_0x0152;
    L_0x0136:
        r0 = r34;
        r4 = r0.QK;
        if (r4 != 0) goto L_0x0152;
    L_0x013c:
        r4 = com.tencent.smtt.sdk.QbSdk.puW;
        r5 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r4.hp(r5);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r5 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        r4.yK(r5);
        goto L_0x0020;
    L_0x0152:
        if (r35 != 0) goto L_0x0185;
    L_0x0154:
        r0 = r34;
        r4 = r0.pvK;
        r0 = r34;
        r6 = r0.mContext;
        r6 = com.tencent.smtt.utils.b.fT(r6);
        r4 = r4.contains(r6);
        if (r4 == 0) goto L_0x0185;
    L_0x0166:
        r4 = "TbsDownload";
        r5 = "[TbsApkDownloader.startDownload] WIFI Unavailable";
        com.tencent.smtt.utils.TbsLog.i(r4, r5);
        r4 = com.tencent.smtt.sdk.QbSdk.puW;
        r5 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r4.hp(r5);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r5 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r4.yK(r5);
        goto L_0x0020;
    L_0x0185:
        r34.bMM();
        r4 = "TbsDownload";
        r6 = "STEP 1/2 begin downloading...";
        r7 = 1;
        com.tencent.smtt.utils.TbsLog.i(r4, r6, r7);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r24 = r4.bMW();
        r4 = 0;
        r0 = r34;
        r6 = r0.mContext;
        r6 = com.tencent.smtt.sdk.i.fb(r6);
        r6 = r6.pwc;
        r7 = "tbs_downloadflow";
        r8 = 0;
        r6 = r6.getLong(r7, r8);
        if (r35 == 0) goto L_0x0328;
    L_0x01b4:
        r8 = pvt;
        r0 = r34;
        r0.pvL = r8;
        r8 = r4;
    L_0x01bb:
        r0 = r34;
        r4 = r0.dov;
        r0 = r34;
        r9 = r0.pvL;
        if (r4 > r9) goto L_0x01e3;
    L_0x01c5:
        r0 = r34;
        r4 = r0.pvC;
        r9 = 8;
        if (r4 <= r9) goto L_0x0331;
    L_0x01cd:
        r4 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r6 = 0;
        r7 = 1;
        r0 = r34;
        r0.i(r4, r6, r7);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r6 = -306; // 0xfffffffffffffece float:NaN double:NaN;
        r4.yK(r6);
    L_0x01e3:
        r0 = r34;
        r4 = r0.QK;
        if (r4 != 0) goto L_0x0260;
    L_0x01e9:
        r0 = r34;
        r4 = r0.mFinished;
        if (r4 == 0) goto L_0x0232;
    L_0x01ef:
        r0 = r34;
        r4 = r0.pvO;
        if (r4 != 0) goto L_0x01fe;
    L_0x01f5:
        if (r8 != 0) goto L_0x01fe;
    L_0x01f7:
        r4 = 1;
        r0 = r34;
        r8 = r0.J(r4, r5);
    L_0x01fe:
        r0 = r34;
        r6 = r0.pvF;
        if (r8 == 0) goto L_0x1033;
    L_0x0204:
        r4 = 1;
    L_0x0205:
        r6.pwR = r4;
        if (r5 != 0) goto L_0x1039;
    L_0x0209:
        r0 = r34;
        r5 = r0.pvF;
        if (r8 == 0) goto L_0x1036;
    L_0x020f:
        r4 = 1;
    L_0x0210:
        r5.pwP = r4;
    L_0x0212:
        if (r8 == 0) goto L_0x1042;
    L_0x0214:
        r4 = 1;
        r0 = r34;
        r0.kA(r4);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r5 = -317; // 0xfffffffffffffec3 float:NaN double:NaN;
        r4.yK(r5);
        r4 = 100;
        r5 = "success";
        r6 = 1;
        r0 = r34;
        r0.i(r4, r5, r6);
    L_0x0232:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        if (r8 == 0) goto L_0x1057;
    L_0x023c:
        r5 = r4.pwc;
        r6 = "tbs_download_success_retrytimes";
        r7 = 0;
        r5 = r5.getInt(r6, r7);
        r6 = r4.pwb;
        r7 = "tbs_download_success_retrytimes";
        r5 = r5 + 1;
        r5 = java.lang.Integer.valueOf(r5);
        r6.put(r7, r5);
    L_0x0254:
        r4.commit();
        r0 = r34;
        r5 = r0.pvF;
        if (r8 == 0) goto L_0x107e;
    L_0x025d:
        r4 = 1;
    L_0x025e:
        r5.pwU = r4;
    L_0x0260:
        r4 = "TbsDownload";
        r5 = "[TbsApkDownloader.closeHttpRequest]";
        com.tencent.smtt.utils.TbsLog.i(r4, r5);
        r0 = r34;
        r4 = r0.pvD;
        if (r4 == 0) goto L_0x0293;
    L_0x026f:
        r0 = r34;
        r4 = r0.QK;
        if (r4 != 0) goto L_0x0287;
    L_0x0275:
        r0 = r34;
        r4 = r0.pvF;
        r0 = r34;
        r5 = r0.pvD;
        r5 = r5.getURL();
        r5 = c(r5);
        r4.pwN = r5;
    L_0x0287:
        r0 = r34;	 Catch:{ Throwable -> 0x1081 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x1081 }
        r4.disconnect();	 Catch:{ Throwable -> 0x1081 }
    L_0x028e:
        r4 = 0;
        r0 = r34;
        r0.pvD = r4;
    L_0x0293:
        r0 = r34;
        r4 = r0.pvF;
        r5 = r4.esS;
        r0 = r34;
        r4 = r0.QK;
        if (r4 != 0) goto L_0x10af;
    L_0x029f:
        r0 = r34;
        r4 = r0.pvI;
        if (r4 == 0) goto L_0x10af;
    L_0x02a5:
        r0 = r34;
        r4 = r0.pvF;
        r6 = java.lang.System.currentTimeMillis();
        r4.pwL = r6;
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.utils.b.fR(r4);
        if (r4 != 0) goto L_0x02bc;
    L_0x02b9:
        r4 = "";
    L_0x02bc:
        r0 = r34;
        r6 = r0.mContext;
        r6 = com.tencent.smtt.utils.b.fS(r6);
        r0 = r34;
        r7 = r0.pvF;
        r7.pwS = r4;
        r0 = r34;
        r7 = r0.pvF;
        r7.pwT = r6;
        r0 = r34;
        r7 = r0.pvH;
        if (r6 != r7) goto L_0x02e0;
    L_0x02d6:
        r0 = r34;
        r6 = r0.pvG;
        r4 = r4.equals(r6);
        if (r4 != 0) goto L_0x02e7;
    L_0x02e0:
        r0 = r34;
        r4 = r0.pvF;
        r6 = 0;
        r4.pwX = r6;
    L_0x02e7:
        r0 = r34;
        r4 = r0.pvF;
        r4 = r4.esS;
        if (r4 == 0) goto L_0x02f9;
    L_0x02ef:
        r0 = r34;
        r4 = r0.pvF;
        r4 = r4.esS;
        r6 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        if (r4 != r6) goto L_0x0314;
    L_0x02f9:
        r0 = r34;
        r4 = r0.pvF;
        r4 = r4.pwU;
        if (r4 != 0) goto L_0x0314;
    L_0x0301:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.utils.b.isNetworkAvailable(r4);
        if (r4 != 0) goto L_0x109e;
    L_0x030b:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r6 = 0;
        r7 = 1;
        r0 = r34;
        r0.i(r4, r6, r7);
    L_0x0314:
        r0 = r34;
        r4 = r0.pvF;
        r6 = com.tencent.smtt.sdk.o.a.TYPE_DOWNLOAD;
        r4.a(r6);
        r4 = 100;
        if (r5 == r4) goto L_0x0020;
    L_0x0321:
        r4 = com.tencent.smtt.sdk.QbSdk.puW;
        r4.hp(r5);
        goto L_0x0020;
    L_0x0328:
        r8 = pvs;
        r0 = r34;
        r0.pvL = r8;
    L_0x032e:
        r8 = r4;
        goto L_0x01bb;
    L_0x0331:
        r16 = java.lang.System.currentTimeMillis();
        if (r35 != 0) goto L_0x043d;
    L_0x0337:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.pwc;	 Catch:{ Throwable -> 0x0652 }
        r9 = "tbs_downloadstarttime";	 Catch:{ Throwable -> 0x0652 }
        r10 = 0;	 Catch:{ Throwable -> 0x0652 }
        r10 = r4.getLong(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r10 = r16 - r10;	 Catch:{ Throwable -> 0x0652 }
        r12 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Throwable -> 0x0652 }
        r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r4 <= 0) goto L_0x03e0;	 Catch:{ Throwable -> 0x0652 }
    L_0x0353:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD";	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.pwb;	 Catch:{ Throwable -> 0x0652 }
        r9 = "tbs_downloadstarttime";	 Catch:{ Throwable -> 0x0652 }
        r10 = java.lang.Long.valueOf(r16);	 Catch:{ Throwable -> 0x0652 }
        r4.put(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.pwb;	 Catch:{ Throwable -> 0x0652 }
        r9 = "tbs_downloadflow";	 Catch:{ Throwable -> 0x0652 }
        r10 = 0;	 Catch:{ Throwable -> 0x0652 }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ Throwable -> 0x0652 }
        r4.put(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r4.commit();	 Catch:{ Throwable -> 0x0652 }
        r6 = 0;	 Catch:{ Throwable -> 0x0652 }
    L_0x0393:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.utils.e.fZ(r4);	 Catch:{ Throwable -> 0x0652 }
        if (r4 != 0) goto L_0x043d;	 Catch:{ Throwable -> 0x0652 }
    L_0x039d:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = "DownloadBegin FreeSpace too small";	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r4 = 105; // 0x69 float:1.47E-43 double:5.2E-322;	 Catch:{ Throwable -> 0x0652 }
        r9 = 0;	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -308; // 0xfffffffffffffecc float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x03bf:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x03e0:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r10 = "[TbsApkDownloader.startDownload] downloadFlow=";	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r6);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9);	 Catch:{ Throwable -> 0x0652 }
        r4 = (r6 > r24 ? 1 : (r6 == r24 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r4 < 0) goto L_0x0393;	 Catch:{ Throwable -> 0x0652 }
    L_0x03fa:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r4 = 112; // 0x70 float:1.57E-43 double:5.53E-322;	 Catch:{ Throwable -> 0x0652 }
        r9 = 0;	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -307; // 0xfffffffffffffecd float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x041c:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x043d:
        r4 = 1;
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvI = r4;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvw;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x062e;	 Catch:{ Throwable -> 0x0652 }
    L_0x0448:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvw;	 Catch:{ Throwable -> 0x0652 }
    L_0x044c:
        r9 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r11 = "try url:";	 Catch:{ Throwable -> 0x0652 }
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r4);	 Catch:{ Throwable -> 0x0652 }
        r11 = ",mRetryTimes:";	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r11 = r0.dov;	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0652 }
        r11 = 1;	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r9, r10, r11);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.pvv;	 Catch:{ Throwable -> 0x0652 }
        r9 = r4.equals(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r9 != 0) goto L_0x0486;	 Catch:{ Throwable -> 0x0652 }
    L_0x047c:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.pvF;	 Catch:{ Throwable -> 0x0652 }
        r10 = r9.pwM;	 Catch:{ Throwable -> 0x0652 }
        if (r10 != 0) goto L_0x0634;	 Catch:{ Throwable -> 0x0652 }
    L_0x0484:
        r9.pwM = r4;	 Catch:{ Throwable -> 0x0652 }
    L_0x0486:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvv = r4;	 Catch:{ Throwable -> 0x0652 }
        r9 = new java.net.URL;	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r4);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x049c;
    L_0x0495:
        r0 = r34;	 Catch:{ Throwable -> 0x06cd }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x06cd }
        r4.disconnect();	 Catch:{ Throwable -> 0x06cd }
    L_0x049c:
        r4 = r9.openConnection();	 Catch:{ Throwable -> 0x0652 }
        r4 = (java.net.HttpURLConnection) r4;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvD = r4;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "User-Agent";	 Catch:{ Throwable -> 0x0652 }
        r10 = com.tencent.smtt.sdk.j.bNg();	 Catch:{ Throwable -> 0x0652 }
        r4.setRequestProperty(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "Accept-Encoding";	 Catch:{ Throwable -> 0x0652 }
        r10 = "identity";	 Catch:{ Throwable -> 0x0652 }
        r4.setRequestProperty(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "GET";	 Catch:{ Throwable -> 0x0652 }
        r4.setRequestMethod(r9);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = 0;	 Catch:{ Throwable -> 0x0652 }
        r4.setInstanceFollowRedirects(r9);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.pvA;	 Catch:{ Throwable -> 0x0652 }
        r4.setConnectTimeout(r9);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.pvz;	 Catch:{ Throwable -> 0x0652 }
        r4.setReadTimeout(r9);	 Catch:{ Throwable -> 0x0652 }
        r12 = 0;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvB;	 Catch:{ Throwable -> 0x0652 }
        if (r4 != 0) goto L_0x054d;	 Catch:{ Throwable -> 0x0652 }
    L_0x04f1:
        r12 = r34.bMP();	 Catch:{ Throwable -> 0x0652 }
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r10 = "[TbsApkDownloader.startDownload] range=";	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r12);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r14 = 0;	 Catch:{ Throwable -> 0x0652 }
        r4 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r4 > 0) goto L_0x070d;	 Catch:{ Throwable -> 0x0652 }
    L_0x0515:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r10 = "STEP 1/2 begin downloading...current";	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r12);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "Range";	 Catch:{ Throwable -> 0x0652 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r11 = "bytes=";	 Catch:{ Throwable -> 0x0652 }
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r12);	 Catch:{ Throwable -> 0x0652 }
        r11 = "-";	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0652 }
        r4.setRequestProperty(r9, r10);	 Catch:{ Throwable -> 0x0652 }
    L_0x054d:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.pvF;	 Catch:{ Throwable -> 0x0652 }
        r10 = 0;	 Catch:{ Throwable -> 0x0652 }
        r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r4 != 0) goto L_0x075e;	 Catch:{ Throwable -> 0x0652 }
    L_0x0557:
        r4 = 0;	 Catch:{ Throwable -> 0x0652 }
    L_0x0558:
        r9.pwQ = r4;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.utils.b.fS(r4);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r9 = com.tencent.smtt.utils.b.fR(r9);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvG;	 Catch:{ Throwable -> 0x0652 }
        if (r10 != 0) goto L_0x0761;	 Catch:{ Throwable -> 0x0652 }
    L_0x0570:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvH;	 Catch:{ Throwable -> 0x0652 }
        r11 = -1;	 Catch:{ Throwable -> 0x0652 }
        if (r10 != r11) goto L_0x0761;	 Catch:{ Throwable -> 0x0652 }
    L_0x0577:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvG = r9;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvH = r4;	 Catch:{ Throwable -> 0x0652 }
    L_0x057f:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.dov;	 Catch:{ Throwable -> 0x0652 }
        if (r4 <= 0) goto L_0x0593;	 Catch:{ Throwable -> 0x0652 }
    L_0x0585:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "Referer";	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.mDownloadUrl;	 Catch:{ Throwable -> 0x0652 }
        r4.addRequestProperty(r9, r10);	 Catch:{ Throwable -> 0x0652 }
    L_0x0593:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.getResponseCode();	 Catch:{ Throwable -> 0x0652 }
        r9 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r11 = "[TbsApkDownloader.startDownload] responseCode=";	 Catch:{ Throwable -> 0x0652 }
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r4);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.pvF;	 Catch:{ Throwable -> 0x0652 }
        r9.pwO = r4;	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x05f8;	 Catch:{ Throwable -> 0x0652 }
    L_0x05b9:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r9 = com.tencent.smtt.sdk.j.fe(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r9 != 0) goto L_0x05f8;	 Catch:{ Throwable -> 0x0652 }
    L_0x05c3:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r9 = com.tencent.smtt.utils.b.fS(r9);	 Catch:{ Throwable -> 0x0652 }
        r10 = 3;	 Catch:{ Throwable -> 0x0652 }
        if (r9 == r10) goto L_0x05d4;	 Catch:{ Throwable -> 0x0652 }
    L_0x05ce:
        r9 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0652 }
        if (r9 == 0) goto L_0x05de;	 Catch:{ Throwable -> 0x0652 }
    L_0x05d4:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r9 = com.tencent.smtt.utils.b.fS(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r9 != 0) goto L_0x05f8;	 Catch:{ Throwable -> 0x0652 }
    L_0x05de:
        r9 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.QK = r9;	 Catch:{ Throwable -> 0x0652 }
        r9 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ Throwable -> 0x0652 }
        if (r9 == 0) goto L_0x05ee;	 Catch:{ Throwable -> 0x0652 }
    L_0x05e7:
        r9 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ Throwable -> 0x0652 }
        r10 = 111; // 0x6f float:1.56E-43 double:5.5E-322;	 Catch:{ Throwable -> 0x0652 }
        r9.hp(r10);	 Catch:{ Throwable -> 0x0652 }
    L_0x05ee:
        r9 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r10 = "Download is canceled due to NOT_WIFI error!";	 Catch:{ Throwable -> 0x0652 }
        r11 = 0;	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r9, r10, r11);	 Catch:{ Throwable -> 0x0652 }
    L_0x05f8:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.QK;	 Catch:{ Throwable -> 0x0652 }
        if (r9 == 0) goto L_0x0782;	 Catch:{ Throwable -> 0x0652 }
    L_0x05fe:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x060d:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x062e:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mDownloadUrl;	 Catch:{ Throwable -> 0x0652 }
        goto L_0x044c;	 Catch:{ Throwable -> 0x0652 }
    L_0x0634:
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r10.<init>();	 Catch:{ Throwable -> 0x0652 }
        r11 = r9.pwM;	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0652 }
        r11 = ";";	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r4);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0652 }
        r9.pwM = r10;	 Catch:{ Throwable -> 0x0652 }
        goto L_0x0486;
    L_0x0652:
        r4 = move-exception;
        r32 = r4;
        r4 = r8;
        r8 = r32;
    L_0x0658:
        r9 = r8 instanceof javax.net.ssl.SSLHandshakeException;	 Catch:{ all -> 0x06ea }
        if (r9 == 0) goto L_0x0fe9;	 Catch:{ all -> 0x06ea }
    L_0x065c:
        if (r35 != 0) goto L_0x0fe9;	 Catch:{ all -> 0x06ea }
    L_0x065e:
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r9 = r0.pvO;	 Catch:{ all -> 0x06ea }
        if (r9 == 0) goto L_0x0fe9;	 Catch:{ all -> 0x06ea }
    L_0x0664:
        r9 = r34.bMO();	 Catch:{ all -> 0x06ea }
        if (r9 == 0) goto L_0x0fe9;	 Catch:{ all -> 0x06ea }
    L_0x066a:
        r9 = "TbsDownload";	 Catch:{ all -> 0x06ea }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x06ea }
        r11 = "[startdownload]url:";	 Catch:{ all -> 0x06ea }
        r10.<init>(r11);	 Catch:{ all -> 0x06ea }
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r11 = r0.pvw;	 Catch:{ all -> 0x06ea }
        r10 = r10.append(r11);	 Catch:{ all -> 0x06ea }
        r11 = " download exception：";	 Catch:{ all -> 0x06ea }
        r10 = r10.append(r11);	 Catch:{ all -> 0x06ea }
        r8 = r8.toString();	 Catch:{ all -> 0x06ea }
        r8 = r10.append(r8);	 Catch:{ all -> 0x06ea }
        r8 = r8.toString();	 Catch:{ all -> 0x06ea }
        com.tencent.smtt.utils.TbsLog.e(r9, r8);	 Catch:{ all -> 0x06ea }
        r8 = 125; // 0x7d float:1.75E-43 double:6.2E-322;	 Catch:{ all -> 0x06ea }
        r9 = 0;	 Catch:{ all -> 0x06ea }
        r10 = 1;	 Catch:{ all -> 0x06ea }
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r0.i(r8, r9, r10);	 Catch:{ all -> 0x06ea }
    L_0x069c:
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r8 = r0.mContext;	 Catch:{ all -> 0x06ea }
        r8 = com.tencent.smtt.sdk.i.fb(r8);	 Catch:{ all -> 0x06ea }
        r9 = -316; // 0xfffffffffffffec4 float:NaN double:NaN;	 Catch:{ all -> 0x06ea }
        r8.yK(r9);	 Catch:{ all -> 0x06ea }
        if (r35 != 0) goto L_0x032e;
    L_0x06ab:
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8 = r8.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r8.put(r9, r10);
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8.commit();
        r8 = r4;
        goto L_0x01bb;
    L_0x06cd:
        r4 = move-exception;
        r10 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r12 = "[initHttpRequest] mHttpRequest.disconnect() Throwable:";	 Catch:{ Throwable -> 0x0652 }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0652 }
        r4 = r11.append(r4);	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.e(r10, r4);	 Catch:{ Throwable -> 0x0652 }
        goto L_0x049c;
    L_0x06ea:
        r4 = move-exception;
        if (r35 != 0) goto L_0x070c;
    L_0x06ed:
        r0 = r34;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.i.fb(r5);
        r5 = r5.pwb;
        r8 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r5.put(r8, r6);
        r0 = r34;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.i.fb(r5);
        r5.commit();
    L_0x070c:
        throw r4;
    L_0x070d:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r10 = "#1 STEP 1/2 begin downloading...current/total=";	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r12);	 Catch:{ Throwable -> 0x0652 }
        r10 = "/";	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "Range";	 Catch:{ Throwable -> 0x0652 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r11 = "bytes=";	 Catch:{ Throwable -> 0x0652 }
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r12);	 Catch:{ Throwable -> 0x0652 }
        r11 = "-";	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r14 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.append(r14);	 Catch:{ Throwable -> 0x0652 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0652 }
        r4.setRequestProperty(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        goto L_0x054d;	 Catch:{ Throwable -> 0x0652 }
    L_0x075e:
        r4 = 1;	 Catch:{ Throwable -> 0x0652 }
        goto L_0x0558;	 Catch:{ Throwable -> 0x0652 }
    L_0x0761:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvH;	 Catch:{ Throwable -> 0x0652 }
        if (r4 != r10) goto L_0x0771;	 Catch:{ Throwable -> 0x0652 }
    L_0x0767:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvG;	 Catch:{ Throwable -> 0x0652 }
        r10 = r9.equals(r10);	 Catch:{ Throwable -> 0x0652 }
        if (r10 != 0) goto L_0x057f;	 Catch:{ Throwable -> 0x0652 }
    L_0x0771:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvF;	 Catch:{ Throwable -> 0x0652 }
        r11 = 0;	 Catch:{ Throwable -> 0x0652 }
        r10.pwX = r11;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvG = r9;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvH = r4;	 Catch:{ Throwable -> 0x0652 }
        goto L_0x057f;	 Catch:{ Throwable -> 0x0652 }
    L_0x0782:
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == r9) goto L_0x078a;	 Catch:{ Throwable -> 0x0652 }
    L_0x0786:
        r9 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 != r9) goto L_0x0d1c;	 Catch:{ Throwable -> 0x0652 }
    L_0x078a:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.getContentLength();	 Catch:{ Throwable -> 0x0652 }
        r10 = (long) r4;	 Catch:{ Throwable -> 0x0652 }
        r10 = r10 + r12;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvy = r10;	 Catch:{ Throwable -> 0x0652 }
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r10 = "[TbsApkDownloader.startDownload] mContentLength=";	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvF;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r4.pwV = r10;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.pwc;	 Catch:{ Throwable -> 0x0652 }
        r9 = "tbs_apkfilesize";	 Catch:{ Throwable -> 0x0652 }
        r10 = 0;	 Catch:{ Throwable -> 0x0652 }
        r10 = r4.getLong(r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r14 = 0;	 Catch:{ Throwable -> 0x0652 }
        r4 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x08ba;	 Catch:{ Throwable -> 0x0652 }
    L_0x07d5:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r14 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r4 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x08ba;	 Catch:{ Throwable -> 0x0652 }
    L_0x07dd:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r12 = "DownloadBegin tbsApkFileSize=";	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r12);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0652 }
        r12 = "  but contentLength=";	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r12);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r12 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r12);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0652 }
        r12 = 1;	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r9, r12);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x08a1;	 Catch:{ Throwable -> 0x0652 }
    L_0x0805:
        r4 = r34.bMR();	 Catch:{ Throwable -> 0x0652 }
        if (r4 != 0) goto L_0x081b;	 Catch:{ Throwable -> 0x0652 }
    L_0x080b:
        r4 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x08a1;	 Catch:{ Throwable -> 0x0652 }
    L_0x0811:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.utils.b.isNetworkAvailable(r4);	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x08a1;	 Catch:{ Throwable -> 0x0652 }
    L_0x081b:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvO;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x084a;	 Catch:{ Throwable -> 0x0652 }
    L_0x0821:
        r4 = r34.bMO();	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x084a;
    L_0x0827:
        if (r35 != 0) goto L_0x01bb;
    L_0x0829:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r4.put(r9, r10);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01bb;
    L_0x084a:
        r4 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0652 }
        r12 = "tbsApkFileSize=";	 Catch:{ Throwable -> 0x0652 }
        r9.<init>(r12);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0652 }
        r10 = "  but contentLength=";	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0652 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -310; // 0xfffffffffffffeca float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
    L_0x087e:
        if (r35 != 0) goto L_0x01e3;
    L_0x0880:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x08a1:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r9 = "WifiNetworkUnAvailable";	 Catch:{ Throwable -> 0x0652 }
        r10 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        goto L_0x087e;	 Catch:{ Throwable -> 0x0652 }
    L_0x08ba:
        r11 = 0;	 Catch:{ Throwable -> 0x0652 }
        r10 = 0;	 Catch:{ Throwable -> 0x0652 }
        r9 = 0;	 Catch:{ Throwable -> 0x0652 }
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x0652 }
        r14 = "[TbsApkDownloader.startDownload] begin readResponse";	 Catch:{ Throwable -> 0x0652 }
        com.tencent.smtt.utils.TbsLog.i(r4, r14);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ IOException -> 0x0bd7, all -> 0x10b7 }
        r4 = r0.pvD;	 Catch:{ IOException -> 0x0bd7, all -> 0x10b7 }
        r18 = r4.getInputStream();	 Catch:{ IOException -> 0x0bd7, all -> 0x10b7 }
        if (r18 == 0) goto L_0x1107;
    L_0x08d0:
        r0 = r34;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r4 = r0.pvD;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r4 = r4.getContentEncoding();	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        if (r4 == 0) goto L_0x0964;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
    L_0x08da:
        r10 = "gzip";	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r10 = r4.contains(r10);	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        if (r10 == 0) goto L_0x0964;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
    L_0x08e3:
        r4 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r0 = r18;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r4.<init>(r0);	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r9 = r4;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
    L_0x08eb:
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r0 = new byte[r4];	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r26 = r0;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r19 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r4 = new java.io.File;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r0 = r34;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r10 = r0.pvx;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r14 = "x5.tbs.temp";	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r4.<init>(r10, r14);	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r10 = 1;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r0 = r19;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r0.<init>(r4, r10);	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x10d9, all -> 0x10c3 }
        r4 = 0;
        r20 = r12;
        r10 = r6;
        r6 = r12;
        r12 = r16;
    L_0x0910:
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r0.QK;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r16 = r0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r16 == 0) goto L_0x0983;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x0918:
        r6 = "TbsDownload";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = "STEP 1/2 begin downloading...Canceled!";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        com.tencent.smtt.utils.TbsLog.i(r6, r7, r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = com.tencent.smtt.sdk.i.fb(r6);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6.yK(r7);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r10;
        r32 = r4;
        r4 = r8;
        r8 = r32;
    L_0x0935:
        if (r8 == 0) goto L_0x0b97;
    L_0x0937:
        g(r19);	 Catch:{ Throwable -> 0x10b4 }
        g(r9);	 Catch:{ Throwable -> 0x10b4 }
        g(r18);	 Catch:{ Throwable -> 0x10b4 }
        if (r35 != 0) goto L_0x032e;
    L_0x0942:
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8 = r8.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r8.put(r9, r10);
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8.commit();
        r8 = r4;
        goto L_0x01bb;
    L_0x0964:
        if (r4 == 0) goto L_0x097f;
    L_0x0966:
        r10 = "deflate";	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r4 = r4.contains(r10);	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        if (r4 == 0) goto L_0x097f;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
    L_0x096f:
        r4 = new java.util.zip.InflaterInputStream;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r10 = new java.util.zip.Inflater;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r14 = 1;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r10.<init>(r14);	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r0 = r18;	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r4.<init>(r0, r10);	 Catch:{ IOException -> 0x10cf, all -> 0x10be }
        r9 = r4;
        goto L_0x08eb;
    L_0x097f:
        r9 = r18;
        goto L_0x08eb;
    L_0x0983:
        r16 = 0;
        r17 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = r26;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r1 = r16;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r2 = r17;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r27 = r9.read(r0, r1, r2);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r27 > 0) goto L_0x09e1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x0993:
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r0.pvO;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r6 == 0) goto L_0x09c0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x0999:
        r6 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r0.J(r6, r5);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r6 != 0) goto L_0x09c0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09a2:
        if (r35 != 0) goto L_0x09b2;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09a4:
        r6 = r34.bMO();	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r6 == 0) goto L_0x09b2;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09aa:
        r4 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r10;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r32 = r4;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r4 = r8;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r8 = r32;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        goto L_0x0935;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09b2:
        r6 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0.mFinished = r6;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r8 = 0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r10;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r32 = r4;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r4 = r8;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r8 = r32;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        goto L_0x0935;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09c0:
        r6 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0.mFinished = r6;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r0.pvO;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r6 == 0) goto L_0x09cc;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09cb:
        r8 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09cc:
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = com.tencent.smtt.sdk.i.fb(r6);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = -311; // 0xfffffffffffffec9 float:NaN double:NaN;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6.yK(r7);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r10;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r32 = r4;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r4 = r8;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r8 = r32;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        goto L_0x0935;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09e1:
        r16 = 0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r19;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r1 = r26;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r2 = r16;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r3 = r27;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0.write(r1, r2, r3);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r19.flush();	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r35 != 0) goto L_0x0aa0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09f3:
        r0 = r27;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = (long) r0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r16 = r0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r10 = r10 + r16;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r16 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1));	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r16 < 0) goto L_0x0a42;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x09fe:
        r6 = "TbsDownload";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        com.tencent.smtt.utils.TbsLog.i(r6, r7, r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = 112; // 0x70 float:1.57E-43 double:5.53E-322;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = "downloadFlow=";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7.<init>(r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.append(r10);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = " downloadMaxflow=";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.append(r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r24;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.append(r0);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.toString();	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0.i(r6, r7, r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = com.tencent.smtt.sdk.i.fb(r6);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = -307; // 0xfffffffffffffecd float:NaN double:NaN;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6.yK(r7);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r10;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r32 = r4;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r4 = r8;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r8 = r32;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        goto L_0x0935;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x0a42:
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r0.mContext;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r16 = r0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r16 = com.tencent.smtt.utils.e.fZ(r16);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        if (r16 != 0) goto L_0x0aa0;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
    L_0x0a4e:
        r6 = "TbsDownload";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = "DownloadEnd FreeSpace too small ";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        com.tencent.smtt.utils.TbsLog.i(r6, r7, r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = 105; // 0x69 float:1.47E-43 double:5.2E-322;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = "freespace=";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7.<init>(r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = com.tencent.smtt.utils.t.bOj();	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.append(r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = ",and minFreeSpace=";	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.append(r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = r0.mContext;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = com.tencent.smtt.sdk.i.fb(r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = r12.bMY();	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.append(r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = r7.toString();	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r12 = 1;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0.i(r6, r7, r12);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r0 = r34;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = com.tencent.smtt.sdk.i.fb(r6);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r7 = -308; // 0xfffffffffffffecc float:NaN double:NaN;	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6.yK(r7);	 Catch:{ IOException -> 0x10f3, all -> 0x10cb }
        r6 = r10;
        r32 = r4;
        r4 = r8;
        r8 = r32;
        goto L_0x0935;
    L_0x0aa0:
        r16 = r10;
        r0 = r27;
        r10 = (long) r0;
        r22 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r12 = r22 - r12;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r0.pvF;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r28 = r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r28;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r0.pwW;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r30 = r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r12 = r12 + r30;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r28;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0.pwW = r12;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r12 = r0.pvF;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r12.pxa;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r28 = r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r10 = r10 + r28;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r12.pxa = r10;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r27;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r10 = (long) r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r10 = r10 + r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = r12 - r14;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r28 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = (r20 > r28 ? 1 : (r20 == r28 ? 0 : -1));	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r20 <= 0) goto L_0x1103;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0ada:
        r14 = "TbsDownload";	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = "#2 STEP 1/2 begin downloading...current/total=";	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15.<init>(r0);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15 = r15.append(r10);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = "/";	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15 = r15.append(r0);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r0.pvy;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15 = r15.append(r0);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15 = r15.toString();	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = 1;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        com.tencent.smtt.utils.TbsLog.i(r14, r15, r0);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r14 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r14 == 0) goto L_0x0b27;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b0f:
        r14 = (double) r10;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r0.pvy;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = (double) r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = r0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r14 = r14 / r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r14 = r14 * r20;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r14 = (int) r14;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r15.hr(r14);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b27:
        if (r35 != 0) goto L_0x0b88;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b29:
        r14 = r10 - r6;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r20 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r14 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1));	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r14 <= 0) goto L_0x0b88;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b32:
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = com.tencent.smtt.sdk.j.fe(r6);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r6 != 0) goto L_0x0b87;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b3c:
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = com.tencent.smtt.utils.b.fS(r6);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r7 = 3;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r6 == r7) goto L_0x0b4d;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b47:
        r6 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r6 == 0) goto L_0x0b57;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b4d:
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = com.tencent.smtt.utils.b.fS(r6);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r6 != 0) goto L_0x0b87;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b57:
        r6 = 1;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0.QK = r6;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        if (r6 == 0) goto L_0x0b67;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b60:
        r6 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r7 = 111; // 0x6f float:1.56E-43 double:5.5E-322;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6.hp(r7);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
    L_0x0b67:
        r6 = "TbsDownload";	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r7 = "Download is paused due to NOT_WIFI error!";	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r10 = 0;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        com.tencent.smtt.utils.TbsLog.i(r6, r7, r10);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r0 = r34;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = r0.mContext;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = com.tencent.smtt.sdk.i.fb(r6);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r7 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6.yK(r7);	 Catch:{ IOException -> 0x10e5, all -> 0x10c6 }
        r6 = r16;
        r32 = r4;
        r4 = r8;
        r8 = r32;
        goto L_0x0935;
    L_0x0b87:
        r6 = r10;
    L_0x0b88:
        r32 = r12;
        r12 = r6;
        r6 = r32;
    L_0x0b8d:
        r14 = r6;
        r20 = r10;
        r6 = r12;
        r10 = r16;
        r12 = r22;
        goto L_0x0910;
    L_0x0b97:
        r8 = r4;
    L_0x0b98:
        g(r19);	 Catch:{ Throwable -> 0x0652 }
        g(r9);	 Catch:{ Throwable -> 0x0652 }
        g(r18);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mFinished;	 Catch:{ Throwable -> 0x0652 }
        if (r4 != 0) goto L_0x0bb4;	 Catch:{ Throwable -> 0x0652 }
    L_0x0ba7:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -319; // 0xfffffffffffffec1 float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
    L_0x0bb4:
        if (r35 != 0) goto L_0x01e3;
    L_0x0bb6:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0bd7:
        r4 = move-exception;
        r32 = r4;
        r4 = r8;
        r8 = r32;
    L_0x0bdd:
        r12 = r8 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0d08 }
        if (r12 != 0) goto L_0x0be5;	 Catch:{ all -> 0x0d08 }
    L_0x0be1:
        r12 = r8 instanceof java.net.SocketException;	 Catch:{ all -> 0x0d08 }
        if (r12 == 0) goto L_0x0c2c;	 Catch:{ all -> 0x0d08 }
    L_0x0be5:
        r12 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r0.pvz = r12;	 Catch:{ all -> 0x0d08 }
        r12 = 0;	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r0.eG(r12);	 Catch:{ all -> 0x0d08 }
        r12 = 103; // 0x67 float:1.44E-43 double:5.1E-322;	 Catch:{ all -> 0x0d08 }
        r8 = g(r8);	 Catch:{ all -> 0x0d08 }
        r13 = 0;	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r0.i(r12, r8, r13);	 Catch:{ all -> 0x0d08 }
        g(r11);	 Catch:{ Throwable -> 0x10b4 }
        g(r9);	 Catch:{ Throwable -> 0x10b4 }
        g(r10);	 Catch:{ Throwable -> 0x10b4 }
        if (r35 != 0) goto L_0x032e;
    L_0x0c0a:
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8 = r8.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r8.put(r9, r10);
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8.commit();
        r8 = r4;
        goto L_0x01bb;
    L_0x0c2c:
        if (r35 != 0) goto L_0x0ca5;
    L_0x0c2e:
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r12 = r0.mContext;	 Catch:{ all -> 0x0d08 }
        r12 = com.tencent.smtt.utils.e.fZ(r12);	 Catch:{ all -> 0x0d08 }
        if (r12 != 0) goto L_0x0ca5;	 Catch:{ all -> 0x0d08 }
    L_0x0c38:
        r8 = 105; // 0x69 float:1.47E-43 double:5.2E-322;	 Catch:{ all -> 0x0d08 }
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0d08 }
        r13 = "freespace=";	 Catch:{ all -> 0x0d08 }
        r12.<init>(r13);	 Catch:{ all -> 0x0d08 }
        r14 = com.tencent.smtt.utils.t.bOj();	 Catch:{ all -> 0x0d08 }
        r12 = r12.append(r14);	 Catch:{ all -> 0x0d08 }
        r13 = ",and minFreeSpace=";	 Catch:{ all -> 0x0d08 }
        r12 = r12.append(r13);	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r13 = r0.mContext;	 Catch:{ all -> 0x0d08 }
        r13 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ all -> 0x0d08 }
        r14 = r13.bMY();	 Catch:{ all -> 0x0d08 }
        r12 = r12.append(r14);	 Catch:{ all -> 0x0d08 }
        r12 = r12.toString();	 Catch:{ all -> 0x0d08 }
        r13 = 1;	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r0.i(r8, r12, r13);	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r8 = r0.mContext;	 Catch:{ all -> 0x0d08 }
        r8 = com.tencent.smtt.sdk.i.fb(r8);	 Catch:{ all -> 0x0d08 }
        r12 = -308; // 0xfffffffffffffecc float:NaN double:NaN;	 Catch:{ all -> 0x0d08 }
        r8.yK(r12);	 Catch:{ all -> 0x0d08 }
        g(r11);	 Catch:{ Throwable -> 0x10b4 }
        g(r9);	 Catch:{ Throwable -> 0x10b4 }
        g(r10);	 Catch:{ Throwable -> 0x10b4 }
        if (r35 != 0) goto L_0x1100;
    L_0x0c83:
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8 = r8.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r8.put(r9, r6);
        r0 = r34;
        r6 = r0.mContext;
        r6 = com.tencent.smtt.sdk.i.fb(r6);
        r6.commit();
        r8 = r4;
        goto L_0x01e3;
    L_0x0ca5:
        r12 = 0;
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r0.eG(r12);	 Catch:{ all -> 0x0d08 }
        r12 = 0;	 Catch:{ all -> 0x0d08 }
        r13 = new java.io.File;	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r14 = r0.pvx;	 Catch:{ all -> 0x0d08 }
        r15 = "x5.tbs.temp";	 Catch:{ all -> 0x0d08 }
        r13.<init>(r14, r15);	 Catch:{ all -> 0x0d08 }
        r13 = r13.exists();	 Catch:{ all -> 0x0d08 }
        if (r13 == 0) goto L_0x0cc0;	 Catch:{ all -> 0x0d08 }
    L_0x0cbf:
        r12 = 1;	 Catch:{ all -> 0x0d08 }
    L_0x0cc0:
        if (r12 != 0) goto L_0x0cfb;	 Catch:{ all -> 0x0d08 }
    L_0x0cc2:
        r12 = 106; // 0x6a float:1.49E-43 double:5.24E-322;	 Catch:{ all -> 0x0d08 }
        r8 = g(r8);	 Catch:{ all -> 0x0d08 }
        r13 = 0;	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r0.i(r12, r8, r13);	 Catch:{ all -> 0x0d08 }
    L_0x0cce:
        g(r11);	 Catch:{ Throwable -> 0x10b4 }
        g(r9);	 Catch:{ Throwable -> 0x10b4 }
        g(r10);	 Catch:{ Throwable -> 0x10b4 }
        if (r35 != 0) goto L_0x032e;
    L_0x0cd9:
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8 = r8.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r8.put(r9, r10);
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8.commit();
        r8 = r4;
        goto L_0x01bb;
    L_0x0cfb:
        r12 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r8 = g(r8);	 Catch:{ all -> 0x0d08 }
        r13 = 0;	 Catch:{ all -> 0x0d08 }
        r0 = r34;	 Catch:{ all -> 0x0d08 }
        r0.i(r12, r8, r13);	 Catch:{ all -> 0x0d08 }
        goto L_0x0cce;
    L_0x0d08:
        r8 = move-exception;
        r18 = r10;
        r19 = r11;
        r32 = r8;
        r8 = r4;
        r4 = r32;
    L_0x0d12:
        g(r19);	 Catch:{ Throwable -> 0x0652 }
        g(r9);	 Catch:{ Throwable -> 0x0652 }
        g(r18);	 Catch:{ Throwable -> 0x0652 }
        throw r4;	 Catch:{ Throwable -> 0x0652 }
    L_0x0d1c:
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 < r9) goto L_0x0d9f;	 Catch:{ Throwable -> 0x0652 }
    L_0x0d20:
        r9 = 307; // 0x133 float:4.3E-43 double:1.517E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 > r9) goto L_0x0d9f;	 Catch:{ Throwable -> 0x0652 }
    L_0x0d24:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "Location";	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.getHeaderField(r9);	 Catch:{ Throwable -> 0x0652 }
        r9 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0652 }
        if (r9 != 0) goto L_0x0d66;	 Catch:{ Throwable -> 0x0652 }
    L_0x0d35:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvw = r4;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvC;	 Catch:{ Throwable -> 0x0652 }
        r4 = r4 + 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvC = r4;	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01bb;
    L_0x0d45:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r4.put(r9, r10);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01bb;
    L_0x0d66:
        r4 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r9 = 0;
        r10 = 1;
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.i(r4, r9, r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -312; // 0xfffffffffffffec8 float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x0d7e:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0d9f:
        r9 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r10 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x0652 }
        r11 = 0;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.i(r9, r10, r11);	 Catch:{ Throwable -> 0x0652 }
        r9 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 != r9) goto L_0x0e1f;	 Catch:{ Throwable -> 0x0652 }
    L_0x0daf:
        r4 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.J(r4, r5);	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x0de9;	 Catch:{ Throwable -> 0x0652 }
    L_0x0db8:
        r8 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -214; // 0xffffffffffffff2a float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x0dc8:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0de9:
        r4 = 0;
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.kB(r4);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -313; // 0xfffffffffffffec7 float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x0dfe:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0e1f:
        r9 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r4 == r9) goto L_0x0e27;
    L_0x0e23:
        r9 = 406; // 0x196 float:5.69E-43 double:2.006E-321;
        if (r4 != r9) goto L_0x0e61;
    L_0x0e27:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvy;	 Catch:{ Throwable -> 0x0652 }
        r12 = -1;	 Catch:{ Throwable -> 0x0652 }
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r9 != 0) goto L_0x0e61;	 Catch:{ Throwable -> 0x0652 }
    L_0x0e31:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -314; // 0xfffffffffffffec6 float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x0e40:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0e61:
        r9 = 202; // 0xca float:2.83E-43 double:1.0E-321;
        if (r4 != r9) goto L_0x0e88;
    L_0x0e65:
        if (r35 != 0) goto L_0x01bb;
    L_0x0e67:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r4.put(r9, r10);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01bb;
    L_0x0e88:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.dov;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvL;	 Catch:{ Throwable -> 0x0652 }
        if (r9 >= r10) goto L_0x0f03;	 Catch:{ Throwable -> 0x0652 }
    L_0x0e92:
        r9 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 != r9) goto L_0x0f03;	 Catch:{ Throwable -> 0x0652 }
    L_0x0e96:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.pvD;	 Catch:{ Throwable -> 0x0652 }
        r9 = "Retry-After";	 Catch:{ Throwable -> 0x0652 }
        r4 = r4.getHeaderField(r9);	 Catch:{ Throwable -> 0x0652 }
        r10 = java.lang.Long.parseLong(r4);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.eG(r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.QK;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x0ee0;	 Catch:{ Throwable -> 0x0652 }
    L_0x0eb0:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x0ebf:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0ee0:
        if (r35 != 0) goto L_0x01bb;
    L_0x0ee2:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r4.put(r9, r10);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01bb;
    L_0x0f03:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.dov;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r10 = r0.pvL;	 Catch:{ Throwable -> 0x0652 }
        if (r9 >= r10) goto L_0x0f7d;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f0d:
        r9 = 408; // 0x198 float:5.72E-43 double:2.016E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == r9) goto L_0x0f1d;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f11:
        r9 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == r9) goto L_0x0f1d;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f15:
        r9 = 502; // 0x1f6 float:7.03E-43 double:2.48E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == r9) goto L_0x0f1d;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f19:
        r9 = 408; // 0x198 float:5.72E-43 double:2.016E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 != r9) goto L_0x0f7d;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f1d:
        r10 = 0;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.eG(r10);	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.QK;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == 0) goto L_0x0f5a;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f2a:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x0f39:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0f5a:
        if (r35 != 0) goto L_0x01bb;
    L_0x0f5c:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r4.put(r9, r10);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01bb;
    L_0x0f7d:
        r10 = r34.bMP();	 Catch:{ Throwable -> 0x0652 }
        r12 = 0;	 Catch:{ Throwable -> 0x0652 }
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));	 Catch:{ Throwable -> 0x0652 }
        if (r9 > 0) goto L_0x0fb9;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f87:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r9 = r0.pvB;	 Catch:{ Throwable -> 0x0652 }
        if (r9 != 0) goto L_0x0fb9;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f8d:
        r9 = 410; // 0x19a float:5.75E-43 double:2.026E-321;	 Catch:{ Throwable -> 0x0652 }
        if (r4 == r9) goto L_0x0fb9;	 Catch:{ Throwable -> 0x0652 }
    L_0x0f91:
        r4 = 1;	 Catch:{ Throwable -> 0x0652 }
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r0.pvB = r4;	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01bb;
    L_0x0f98:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r10 = java.lang.Long.valueOf(r6);
        r4.put(r9, r10);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01bb;
    L_0x0fb9:
        r0 = r34;	 Catch:{ Throwable -> 0x0652 }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x0652 }
        r4 = com.tencent.smtt.sdk.i.fb(r4);	 Catch:{ Throwable -> 0x0652 }
        r9 = -315; // 0xfffffffffffffec5 float:NaN double:NaN;	 Catch:{ Throwable -> 0x0652 }
        r4.yK(r9);	 Catch:{ Throwable -> 0x0652 }
        if (r35 != 0) goto L_0x01e3;
    L_0x0fc8:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4 = r4.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r4.put(r9, r6);
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r4.commit();
        goto L_0x01e3;
    L_0x0fe9:
        r10 = 0;
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r0.eG(r10);	 Catch:{ all -> 0x06ea }
        r9 = 107; // 0x6b float:1.5E-43 double:5.3E-322;	 Catch:{ all -> 0x06ea }
        r8 = g(r8);	 Catch:{ all -> 0x06ea }
        r10 = 0;	 Catch:{ all -> 0x06ea }
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r0.i(r9, r8, r10);	 Catch:{ all -> 0x06ea }
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r8 = r0.QK;	 Catch:{ all -> 0x06ea }
        if (r8 == 0) goto L_0x069c;	 Catch:{ all -> 0x06ea }
    L_0x1002:
        r0 = r34;	 Catch:{ all -> 0x06ea }
        r8 = r0.mContext;	 Catch:{ all -> 0x06ea }
        r8 = com.tencent.smtt.sdk.i.fb(r8);	 Catch:{ all -> 0x06ea }
        r9 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ all -> 0x06ea }
        r8.yK(r9);	 Catch:{ all -> 0x06ea }
        if (r35 != 0) goto L_0x1100;
    L_0x1011:
        r0 = r34;
        r8 = r0.mContext;
        r8 = com.tencent.smtt.sdk.i.fb(r8);
        r8 = r8.pwb;
        r9 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r6);
        r8.put(r9, r6);
        r0 = r34;
        r6 = r0.mContext;
        r6 = com.tencent.smtt.sdk.i.fb(r6);
        r6.commit();
        r8 = r4;
        goto L_0x01e3;
    L_0x1033:
        r4 = 0;
        goto L_0x0205;
    L_0x1036:
        r4 = 2;
        goto L_0x0210;
    L_0x1039:
        r0 = r34;
        r4 = r0.pvF;
        r5 = 0;
        r4.pwP = r5;
        goto L_0x0212;
    L_0x1042:
        r0 = r34;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.i.fb(r4);
        r5 = -318; // 0xfffffffffffffec2 float:NaN double:NaN;
        r4.yK(r5);
        r4 = 0;
        r0 = r34;
        r0.kB(r4);
        goto L_0x0232;
    L_0x1057:
        r5 = r4.pwc;
        r6 = "tbs_download_failed_retrytimes";
        r7 = 0;
        r5 = r5.getInt(r6, r7);
        r6 = r4.pwb;
        r7 = "tbs_download_failed_retrytimes";
        r5 = r5 + 1;
        r9 = java.lang.Integer.valueOf(r5);
        r6.put(r7, r9);
        r6 = r4.bNa();
        if (r5 != r6) goto L_0x0254;
    L_0x1075:
        r0 = r34;
        r5 = r0.pvF;
        r6 = 2;
        r5.pwQ = r6;
        goto L_0x0254;
    L_0x107e:
        r4 = 0;
        goto L_0x025e;
    L_0x1081:
        r4 = move-exception;
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;
        r7 = "[closeHttpRequest] mHttpRequest.disconnect() Throwable:";
        r6.<init>(r7);
        r4 = r4.toString();
        r4 = r6.append(r4);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.e(r5, r4);
        goto L_0x028e;
    L_0x109e:
        r4 = bMQ();
        if (r4 != 0) goto L_0x0314;
    L_0x10a4:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r6 = 0;
        r7 = 1;
        r0 = r34;
        r0.i(r4, r6, r7);
        goto L_0x0314;
    L_0x10af:
        r4 = 0;
        com.tencent.smtt.sdk.j.pwk = r4;
        goto L_0x0020;
    L_0x10b4:
        r8 = move-exception;
        goto L_0x0658;
    L_0x10b7:
        r4 = move-exception;
        r18 = r10;
        r19 = r11;
        goto L_0x0d12;
    L_0x10be:
        r4 = move-exception;
        r19 = r11;
        goto L_0x0d12;
    L_0x10c3:
        r4 = move-exception;
        goto L_0x0d12;
    L_0x10c6:
        r4 = move-exception;
        r6 = r16;
        goto L_0x0d12;
    L_0x10cb:
        r4 = move-exception;
        r6 = r10;
        goto L_0x0d12;
    L_0x10cf:
        r4 = move-exception;
        r10 = r18;
        r32 = r4;
        r4 = r8;
        r8 = r32;
        goto L_0x0bdd;
    L_0x10d9:
        r4 = move-exception;
        r10 = r18;
        r11 = r19;
        r32 = r4;
        r4 = r8;
        r8 = r32;
        goto L_0x0bdd;
    L_0x10e5:
        r4 = move-exception;
        r6 = r16;
        r10 = r18;
        r11 = r19;
        r32 = r4;
        r4 = r8;
        r8 = r32;
        goto L_0x0bdd;
    L_0x10f3:
        r4 = move-exception;
        r6 = r10;
        r10 = r18;
        r11 = r19;
        r32 = r4;
        r4 = r8;
        r8 = r32;
        goto L_0x0bdd;
    L_0x1100:
        r8 = r4;
        goto L_0x01e3;
    L_0x1103:
        r12 = r6;
        r6 = r14;
        goto L_0x0b8d;
    L_0x1107:
        r19 = r11;
        goto L_0x0b98;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.f.kz(boolean):void");
    }
}
