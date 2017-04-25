package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.e;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public final class y {
    private static y pyg;
    private static FileLock pyj = null;
    boolean pvf;
    z pyh;
    private boolean pyi;

    private y() {
    }

    public static FileLock bNI() {
        return pyj;
    }

    public static synchronized y bNJ() {
        y yVar;
        synchronized (y.class) {
            if (pyg == null) {
                pyg = new y();
            }
            yVar = pyg;
        }
        return yVar;
    }

    public final synchronized void b(Context context, l lVar) {
        Object obj = null;
        synchronized (this) {
            Object obj2;
            if (lVar != null) {
                lVar.a("x5_core_engine_init_sync", (byte) 2);
            }
            c kx = c.kx(true);
            kx.a(context, lVar);
            StringBuilder stringBuilder = new StringBuilder();
            if (lVar != null) {
                lVar.a("init_x5_core", (byte) 1);
            }
            if (kx.pve) {
                if (!this.pvf) {
                    if (lVar != null) {
                        lVar.pwr = true;
                    }
                    this.pyh = new z(kx.bMI().pxC);
                    try {
                        this.pyi = this.pyh.bNM();
                        if (!this.pyi) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj2 = null;
                    } catch (NoSuchMethodException e) {
                        this.pyi = true;
                        obj2 = null;
                    } catch (Throwable th) {
                        obj2 = th;
                        this.pyi = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj2));
                    }
                    if (this.pyi) {
                        CookieManager.getInstance().bMD();
                    }
                }
                obj2 = null;
            } else {
                this.pyi = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj2 = null;
            }
            if (!this.pyi) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (kx.pve && obj2 == null) {
                    try {
                        DexLoader dexLoader = kx.bMI().pxC;
                        if (dexLoader != null) {
                            obj = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj instanceof Throwable) {
                            Throwable th2 = (Throwable) obj;
                            stringBuilder.append("#" + th2.getMessage() + "; cause: " + th2.getCause() + "; th: " + th2);
                        }
                        if (obj instanceof String) {
                            stringBuilder.append("failure detail:" + obj);
                        }
                    } catch (Throwable th3) {
                    }
                    if (stringBuilder.toString().contains("isPreloadX5Disabled:-10000")) {
                        g.bMS().a(context, 408, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    } else {
                        g.bMS().a(context, 407, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    }
                } else if (kx.pve) {
                    g.bMS().a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + obj2));
                } else {
                    g.bMS().a(context, 410, new Throwable("mCanUseX5=false, available false, reason: " + obj2));
                }
            } else if (pyj == null) {
                fK(context);
            }
            this.pvf = true;
            if (lVar != null) {
                lVar.a("init_x5_core", (byte) 2);
            }
        }
    }

    public final boolean bNK() {
        return QbSdk.puB ? false : this.pyi;
    }

    public final z bNL() {
        return QbSdk.puB ? null : this.pyh;
    }

    public final synchronized FileLock fK(Context context) {
        FileLock fileLock;
        if (pyj != null) {
            fileLock = pyj;
        } else {
            FileOutputStream b = e.b(context, true, "tbs_rename_lock.txt");
            if (b != null) {
                pyj = e.a(b);
            }
            fileLock = pyj;
        }
        return fileLock;
    }
}
