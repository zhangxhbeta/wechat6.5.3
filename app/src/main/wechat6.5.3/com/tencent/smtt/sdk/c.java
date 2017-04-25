package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.g.a;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

final class c {
    private static c pvd = null;
    private static int pvg = 0;
    private static int pvh = 0;
    static boolean pvi = false;
    private static int pvj = 3;
    private static String pvl = null;
    t pvc = null;
    boolean pve = false;
    boolean pvf = false;
    private File pvk = null;

    private c() {
    }

    static void Qh(String str) {
        pvl = str;
    }

    public static int bMJ() {
        return pvg;
    }

    static boolean bMK() {
        pvi = true;
        return true;
    }

    private int bML() {
        int i = 0;
        try {
            File file = new File(this.pvk, "count.prop");
            if (file.exists()) {
                InputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                i = Integer.valueOf(properties.getProperty(pvl, "1")).intValue();
            }
        } catch (Exception e) {
        }
        return i;
    }

    public static synchronized c kx(boolean z) {
        c cVar;
        synchronized (c.class) {
            if (pvd == null && z) {
                pvd = new c();
            }
            cVar = pvd;
        }
        return cVar;
    }

    public static boolean useSoftWare() {
        return QbSdk.useSoftWare();
    }

    static void yI(int i) {
        pvg = i;
    }

    private void yJ(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(pvl, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.pvk, "count.prop")), null);
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }

    public final synchronized void a(Context context, l lVar) {
        Object obj = null;
        synchronized (this) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INIT, null, new Object[0]);
            TbsLog.initIfNeed(context);
            pvh++;
            if (lVar != null) {
                lVar.pws = pvh == 1;
            }
            g bMS = g.bMS();
            if (bMS.pvR != null) {
                a aVar = bMS.pvR;
                Arrays.fill(aVar.pvW, 0);
                aVar.pvX = 0;
                aVar.pvY = 0;
            }
            bMS.pvS = false;
            if (lVar != null) {
                lVar.a("tbs_rename_task", (byte) 1);
            }
            m.bNm().t(context, pvh == 1);
            if (lVar != null) {
                lVar.a("tbs_rename_task", (byte) 2);
            }
            q.u(context, true);
            if (lVar != null) {
                lVar.a("can_load_x5", (byte) 1);
            }
            boolean n = QbSdk.n(context, false);
            if (lVar != null) {
                lVar.a("can_load_x5", (byte) 2);
            }
            boolean z = VERSION.SDK_INT >= 7;
            Object obj2 = (n && z) ? 1 : null;
            if (obj2 == null) {
                String str = "can_load_x5=" + n + "; is_compatible=" + z;
                TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + str);
                if (!(QbSdk.puB && this.pve)) {
                    this.pve = false;
                    g.bMS().a(context, 405, new Throwable(str));
                }
                this.pvk = m.ft(context);
                this.pvf = true;
            } else if (!this.pve) {
                try {
                    if (q.fz(context)) {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                        if (lVar != null) {
                            lVar.a("read_core_info", (byte) 1);
                        }
                        if (lVar != null) {
                            lVar.a("read_core_info", (byte) 2);
                        }
                        this.pve = false;
                        QbSdk.bo(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                    } else {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                        m.bNm();
                        File fr = m.fr(context);
                        if (pvg == 25436 || pvg == 25437) {
                            obj = 1;
                        }
                        Context applicationContext = obj != null ? context.getApplicationContext() : context;
                        if (fr == null) {
                            this.pve = false;
                            QbSdk.bo(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        } else {
                            this.pvc = new t(context, applicationContext, fr.getAbsolutePath(), fr.getAbsolutePath(), QbSdk.getDexLoaderFileList(context, applicationContext, fr.getAbsolutePath()), QbSdk.puI, lVar);
                            this.pve = true;
                            this.pvk = m.ft(context);
                            this.pvf = true;
                        }
                    }
                } catch (Throwable th) {
                    TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                    g.bMS().a(context, 327, th);
                    this.pve = false;
                    QbSdk.bo(context, "SDKEngine::useSystemWebView by exception: " + th);
                }
            }
        }
    }

    public final t bMI() {
        return this.pve ? this.pvc : null;
    }

    final boolean getTbsNeedReboot() {
        if (pvi) {
            if (pvl == null) {
                return false;
            }
            int bML = bML();
            if (bML == 0) {
                yJ(1);
            } else if (bML + 1 > pvj) {
                return false;
            } else {
                yJ(bML + 1);
            }
        }
        return pvi;
    }
}
