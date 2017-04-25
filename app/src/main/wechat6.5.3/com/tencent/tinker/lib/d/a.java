package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.tinker.lib.a.b;
import com.tencent.tinker.lib.c.c;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import java.io.File;

public class a {
    private static a pFH;
    private static boolean pFI = false;
    final Context context;
    public final File pFJ;
    public final b pFK;
    public final c pFL;
    public final d pFM;
    public final File pFN;
    final File pFO;
    public final boolean pFP;
    public final boolean pFQ;
    public d pFR;
    public boolean pFS;
    public int tinkerFlags;
    final boolean tinkerLoadVerifyFlag;

    public static class a {
        private final Context context;
        private File pFJ;
        public b pFK;
        public c pFL;
        public d pFM;
        private File pFN;
        private File pFO;
        private final boolean pFT;
        private final boolean pFU;
        public Boolean pFV;
        private int status = -1;

        public a(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context;
            this.pFT = com.tencent.tinker.lib.e.b.gv(context);
            this.pFU = com.tencent.tinker.lib.e.b.gl(context);
            this.pFJ = SharePatchFileUtil.go(context);
            if (this.pFJ == null) {
                com.tencent.tinker.lib.e.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.pFN = SharePatchFileUtil.Qx(this.pFJ.getAbsolutePath());
            this.pFO = SharePatchFileUtil.Qy(this.pFJ.getAbsolutePath());
            com.tencent.tinker.lib.e.a.w("Tinker.Tinker", "tinker patch directory: %s", new Object[]{this.pFJ});
        }

        public final a zx(int i) {
            if (this.status != -1) {
                throw new TinkerRuntimeException("tinkerFlag is already set.");
            }
            this.status = i;
            return this;
        }

        public final a bOZ() {
            if (this.status == -1) {
                this.status = 7;
            }
            if (this.pFL == null) {
                this.pFL = new com.tencent.tinker.lib.c.a(this.context);
            }
            if (this.pFM == null) {
                this.pFM = new com.tencent.tinker.lib.c.b(this.context);
            }
            if (this.pFK == null) {
                this.pFK = new com.tencent.tinker.lib.a.a(this.context);
            }
            if (this.pFV == null) {
                this.pFV = Boolean.valueOf(false);
            }
            return new a(this.context, this.status, this.pFL, this.pFM, this.pFK, this.pFJ, this.pFN, this.pFO, this.pFT, this.pFU, this.pFV.booleanValue());
        }
    }

    private a(Context context, int i, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.pFS = false;
        this.context = context;
        this.pFK = bVar;
        this.pFL = cVar;
        this.pFM = dVar;
        this.tinkerFlags = i;
        this.pFJ = file;
        this.pFN = file2;
        this.pFO = file3;
        this.pFP = z;
        this.tinkerLoadVerifyFlag = z3;
        this.pFQ = z2;
    }

    public static a gh(Context context) {
        if (pFI) {
            if (pFH == null) {
                synchronized (a.class) {
                    if (pFH == null) {
                        pFH = new a(context).bOZ();
                    }
                }
            }
            return pFH;
        }
        throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }

    public static void a(a aVar) {
        if (pFH != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        pFH = aVar;
    }

    public final void a(Intent intent, Class<? extends AbstractResultService> cls, com.tencent.tinker.lib.b.a aVar) {
        pFI = true;
        TinkerPatchService.a(aVar, cls);
        if (!ShareTinkerInternals.zC(this.tinkerFlags)) {
            com.tencent.tinker.lib.e.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
        } else if (intent == null) {
            throw new TinkerRuntimeException("intentResult must not be null.");
        } else {
            String Qz;
            this.pFR = new d();
            d dVar = this.pFR;
            a gh = gh(this.context);
            dVar.pGh = ShareIntentUtil.ac(intent);
            com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d", new Object[]{Integer.valueOf(dVar.pGh)});
            dVar.fVN = ShareIntentUtil.ad(intent);
            String g = ShareIntentUtil.g(intent, "intent_patch_old_version");
            String g2 = ShareIntentUtil.g(intent, "intent_patch_new_version");
            File file = gh.pFJ;
            File file2 = gh.pFN;
            boolean z = gh.pFP;
            if (!(g == null || g2 == null)) {
                if (z) {
                    dVar.pFW = g2;
                } else {
                    dVar.pFW = g;
                }
                com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[]{g, g2, dVar.pFW});
                Qz = SharePatchFileUtil.Qz(dVar.pFW);
                if (!ShareTinkerInternals.kS(Qz)) {
                    dVar.pFY = new File(file.getAbsolutePath() + "/" + Qz);
                    dVar.pFZ = new File(dVar.pFY.getAbsolutePath(), SharePatchFileUtil.QA(dVar.pFW));
                    dVar.pGa = new File(dVar.pFY, "dex");
                    dVar.pGb = new File(dVar.pFY, "lib");
                    dVar.pGc = new File(dVar.pFY, "res");
                    dVar.pGd = new File(dVar.pGc, "resources.apk");
                }
                dVar.patchInfo = new SharePatchInfo(g, g2, Build.FINGERPRINT);
                dVar.pFX = !g.equals(g2);
            }
            Throwable ae = ShareIntentUtil.ae(intent);
            if (ae == null) {
                switch (dVar.pGh) {
                    case -10000:
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                        throw new TinkerRuntimeException("can't get the right intent return code");
                    case -23:
                        if (dVar.pGd != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[]{dVar.pGd.getAbsolutePath()});
                            gh.pFL.a(dVar.pGd, 6);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                        throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                    case -21:
                        if (dVar.pFY != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[]{dVar.pGd.getAbsolutePath()});
                            gh.pFL.a(dVar.pGd, 6, false);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                    case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                        if (dVar.pFY != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[]{dVar.pGc.getAbsolutePath()});
                            gh.pFL.a(dVar.pGc, 6, true);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                    case -18:
                        com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                        gh.pFL.a(g, g2, file2);
                        break;
                    case -17:
                        Qz = ShareIntentUtil.g(intent, "intent_patch_missing_lib_path");
                        if (Qz != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[]{Qz});
                            gh.pFL.a(new File(Qz), 5, false);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                    case -16:
                        if (dVar.pFY != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[]{dVar.pGb.getAbsolutePath()});
                            gh.pFL.a(dVar.pGb, 5, true);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                    case -13:
                        Qz = ShareIntentUtil.g(intent, "intent_patch_mismatch_dex_path");
                        if (Qz != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[]{Qz});
                            gh.pFL.a(new File(Qz), 3);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                    case -12:
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                        break;
                    case -11:
                        Qz = ShareIntentUtil.g(intent, "intent_patch_missing_dex_path");
                        if (Qz != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[]{Qz});
                            gh.pFL.a(new File(Qz), 4, false);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                    case EncrptType.HASHED_PASSWORD /*-10*/:
                        Qz = ShareIntentUtil.g(intent, "intent_patch_missing_dex_path");
                        if (Qz != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[]{Qz});
                            gh.pFL.a(new File(Qz), 3, false);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                    case -9:
                        if (dVar.pGa != null) {
                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[]{dVar.pGa.getAbsolutePath()});
                            gh.pFL.a(dVar.pGa, 3, true);
                            break;
                        }
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                    case -8:
                        com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                        if (dVar.pFZ != null) {
                            gh.pFL.b(dVar.pFZ, intent.getIntExtra("intent_patch_package_patch_check", -10000));
                            break;
                        }
                        throw new TinkerRuntimeException("error patch package check fail , but file is null");
                    case -7:
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[]{dVar.pFW});
                        if (dVar.pFZ != null) {
                            gh.pFL.a(dVar.pFZ, 1, false);
                            break;
                        }
                        throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                    case -6:
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[]{dVar.pFW});
                        gh.pFL.a(dVar.pFY, 1, true);
                        break;
                    case -5:
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                        break;
                    case -4:
                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                        gh.pFL.a(g, g2, file2);
                        break;
                    case -3:
                    case ai.CTRL_INDEX /*-2*/:
                        com.tencent.tinker.lib.e.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                        break;
                    case -1:
                        com.tencent.tinker.lib.e.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                        break;
                    case 0:
                        com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                        gh.pFS = true;
                        dVar.pGe = ShareIntentUtil.af(intent);
                        dVar.pGf = ShareIntentUtil.ag(intent);
                        dVar.pGg = ShareIntentUtil.ah(intent);
                        if (z && dVar.pFX) {
                            gh.pFL.a(g, g2, file, dVar.pFY.getName());
                            break;
                        }
                    default:
                        break;
                }
            }
            com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[]{Integer.valueOf(dVar.pGh)});
            int i = -1;
            switch (dVar.pGh) {
                case -24:
                    i = -4;
                    break;
                case -22:
                    i = -3;
                    break;
                case -19:
                    i = -1;
                    break;
                case -15:
                    i = -5;
                    break;
                case -14:
                    i = -2;
                    break;
            }
            gh.pFL.a(ae, i);
            this.pFL.a(this.pFJ, this.pFR.pGh, this.pFR.fVN);
            if (!this.pFS) {
                com.tencent.tinker.lib.e.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
            }
        }
    }

    public final void atH() {
        if (this.pFJ != null) {
            if (this.pFS) {
                com.tencent.tinker.lib.e.a.e("Tinker.Tinker", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
            }
            SharePatchFileUtil.e(this.pFJ);
        }
    }

    public final void L(File file) {
        if (this.pFJ != null && file != null && file.exists()) {
            String Qz = SharePatchFileUtil.Qz(SharePatchFileUtil.Q(file));
            if (this.pFJ != null && Qz != null) {
                SharePatchFileUtil.QC(this.pFJ.getAbsolutePath() + "/" + Qz);
            }
        }
    }
}
