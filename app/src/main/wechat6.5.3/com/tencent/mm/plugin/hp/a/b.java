package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class b {
    private static long gDY = 0;

    public static void atz() {
        g.iuh.a(338, 9, 1, false);
    }

    public static void du(boolean z) {
        v.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
        if (z) {
            g.iuh.a(338, 20, 1, false);
        }
        g.iuh.a(338, 0, 1, false);
        gDY = be.Nj();
    }

    public static void dv(boolean z) {
        long az = be.az(gDY);
        v.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[]{Long.valueOf(az)});
        if (z) {
            g.iuh.a(338, 40, 1, false);
        }
        if (az < 0) {
            v.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
        } else if (az <= 5000) {
            g.iuh.I(338, 1, 43);
        } else if (az <= 60000) {
            g.iuh.I(338, 1, 44);
        } else if (az <= 180000) {
            g.iuh.I(338, 1, 45);
        } else {
            g.iuh.I(338, 1, 46);
        }
    }

    public static void atA() {
        v.i("Tinker.HotPatchReportHelper", "hp_report download failed");
        g.iuh.a(338, 42, 1, false);
        g.iuh.a(338, 41, 1, false);
    }

    public static void dw(boolean z) {
        v.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
        g.iuh.I(338, 2, 71);
        if (z) {
            g.iuh.a(338, 7, 1, false);
        }
    }

    public static void lO(int i) {
        v.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
        switch (i) {
            case -13:
                g.iuh.a(338, 84, 1, false);
                return;
            case -12:
                g.iuh.a(338, 83, 1, false);
                return;
            case -11:
                g.iuh.a(338, 82, 1, false);
                return;
            case EncrptType.HASHED_PASSWORD /*-10*/:
                g.iuh.a(338, 81, 1, false);
                return;
            case -9:
                g.iuh.a(338, 79, 1, false);
                return;
            case -8:
                g.iuh.a(338, 80, 1, false);
                return;
            case -7:
                g.iuh.a(338, 78, 1, false);
                return;
            case -6:
                g.iuh.a(338, 77, 1, false);
                return;
            case -5:
                g.iuh.a(338, 76, 1, false);
                return;
            case -4:
                g.iuh.a(338, 74, 1, false);
                return;
            case -3:
                g.iuh.a(338, 73, 1, false);
                return;
            case ai.CTRL_INDEX /*-2*/:
                g.iuh.a(338, 75, 1, false);
                return;
            case -1:
                g.iuh.a(338, 72, 1, false);
                return;
            default:
                return;
        }
    }

    public static void y(Intent intent) {
        KVCommCrossProcessReceiver.cv(0);
        v.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
        if (intent == null) {
            g.iuh.I(338, 6, 127);
        } else if (ShareIntentUtil.g(intent, "patch_path_extra") == null) {
            g.iuh.I(338, 6, 128);
        } else {
            g.iuh.a(338, 6, 1, false);
            KVCommCrossProcessReceiver.cv(500);
        }
    }

    public static void f(long j, boolean z) {
        if (z) {
            g.iuh.a(338, 3, 1, false);
        }
        if (z) {
            g.iuh.a(338, 101, 1, false);
        } else {
            g.iuh.a(338, 103, 1, false);
        }
        v.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            v.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
        } else if (j <= 5000) {
            if (z) {
                g.iuh.a(338, 117, 1, false);
            } else {
                g.iuh.a(338, 122, 1, false);
            }
        } else if (j <= 10000) {
            if (z) {
                g.iuh.a(338, 118, 1, false);
            } else {
                g.iuh.a(338, 123, 1, false);
            }
        } else if (j <= 30000) {
            if (z) {
                g.iuh.a(338, 119, 1, false);
            } else {
                g.iuh.a(338, 124, 1, false);
            }
        } else if (j > 60000) {
            if (j >= 3600000) {
                g.iuh.a(338, 133, 1, false);
            }
            if (z) {
                g.iuh.a(338, 121, 1, false);
            } else {
                g.iuh.a(338, 126, 1, false);
            }
        } else if (z) {
            g.iuh.a(338, 120, 1, false);
        } else {
            g.iuh.a(338, 125, 1, false);
        }
    }

    public static void lP(int i) {
        v.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -8:
                g.iuh.I(338, 107, 131);
                return;
            case -7:
                g.iuh.I(338, 107, 113);
                return;
            case -6:
                g.iuh.I(338, 107, 112);
                return;
            case -5:
                g.iuh.I(338, 107, 111);
                return;
            case -4:
                g.iuh.I(338, 107, 110);
                return;
            case -3:
                g.iuh.I(338, 107, 109);
                return;
            case ai.CTRL_INDEX /*-2*/:
                g.iuh.I(338, 107, 129);
                return;
            case -1:
                g.iuh.I(338, 107, ba.CTRL_INDEX);
                return;
            default:
                return;
        }
    }

    public static void c(Throwable th) {
        g.iuh.a(338, 104, 1, false);
        f.a(aa.getContext(), aa.getProcessName(), "Tinker Exception:apply tinker occur exception " + ag.f(th), th);
    }

    public static void d(Throwable th) {
        g.iuh.a(338, 105, 1, false);
        f.a(aa.getContext(), aa.getProcessName(), "Tinker Exception:apply tinker occur exception " + ag.f(th), th);
    }

    public static void atB() {
        g.iuh.a(338, 106, 1, false);
    }

    public static void atC() {
        g.iuh.a(338, 116, 1, false);
    }

    public static void lQ(int i) {
        switch (i) {
            case 1:
                g.iuh.a(338, 130, 1, false);
                return;
            case 3:
                g.iuh.a(338, 114, 1, false);
                return;
            case 5:
                g.iuh.a(338, 115, 1, false);
                return;
            case 6:
                g.iuh.a(338, 132, 1, false);
                return;
            default:
                return;
        }
    }

    public static void g(long j, boolean z) {
        g.iuh.a(338, 4, 1, false);
        if (z) {
            v.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[]{Long.valueOf(j)});
            if (j < 0) {
                v.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
                return;
            } else if (j <= 500) {
                g.iuh.a(338, 177, 1, false);
                return;
            } else if (j <= 1000) {
                g.iuh.a(338, 178, 1, false);
                return;
            } else if (j <= 3000) {
                g.iuh.a(338, 179, 1, false);
                return;
            } else if (j <= 5000) {
                g.iuh.a(338, 180, 1, false);
                return;
            } else {
                g.iuh.a(338, 181, 1, false);
                return;
            }
        }
        g.iuh.a(338, 159, 1, false);
    }

    public static void a(Throwable th, int i) {
        boolean z = false;
        switch (i) {
            case -4:
                g.iuh.a(338, 188, 1, false);
                break;
            case -3:
                if (!th.getMessage().contains("checkResInstall failed")) {
                    g.iuh.a(338, 184, 1, false);
                    break;
                }
                g.iuh.a(338, 190, 1, false);
                z = true;
                break;
            case ai.CTRL_INDEX /*-2*/:
                if (!th.getMessage().contains("checkDexInstall failed")) {
                    g.iuh.a(338, 161, 1, false);
                    v.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + th.getMessage());
                    break;
                }
                g.iuh.a(338, 189, 1, false);
                v.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + th.getMessage());
                z = true;
                break;
            case -1:
                g.iuh.a(338, 160, 1, false);
                break;
        }
        if (!z) {
            String f = ag.f(th);
            if (i == -4) {
                Context context = aa.getContext();
                String gr = SharePatchFileUtil.gr(context);
                if (!ShareTinkerInternals.kS(gr)) {
                    f = "tinker checkSafeModeCount fail:\n" + gr;
                    SharePatchFileUtil.P(SharePatchFileUtil.gq(context));
                }
            }
            f.a(aa.getContext(), aa.getProcessName(), "Tinker Exception:load tinker occur exception " + f, th);
        }
    }

    public static void g(boolean z, int i) {
        v.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        if (z) {
            g.iuh.a(338, 170, 1, false);
        }
        switch (i) {
            case -8:
                g.iuh.I(338, 169, 186);
                return;
            case -7:
                g.iuh.I(338, 169, 176);
                return;
            case -6:
                g.iuh.I(338, 169, 175);
                return;
            case -5:
                g.iuh.I(338, 169, 174);
                return;
            case -4:
                g.iuh.I(338, 169, 173);
                return;
            case -3:
                g.iuh.I(338, 169, 172);
                return;
            case ai.CTRL_INDEX /*-2*/:
                g.iuh.I(338, 107, 182);
                return;
            case -1:
                g.iuh.I(338, 169, 171);
                return;
            default:
                return;
        }
    }

    public static void lR(int i) {
        switch (i) {
            case 1:
                g.iuh.a(338, 166, 1, false);
                return;
            case 2:
                g.iuh.a(338, 167, 1, false);
                return;
            case 3:
                g.iuh.a(338, 164, 1, false);
                return;
            case 4:
                g.iuh.a(338, 183, 1, false);
                return;
            case 5:
                g.iuh.a(338, 165, 1, false);
                return;
            case 6:
                g.iuh.a(338, 187, 1, false);
                return;
            default:
                return;
        }
    }

    public static void lS(int i) {
        switch (i) {
            case 3:
                g.iuh.a(338, 162, 1, false);
                return;
            case 5:
                g.iuh.a(338, 163, 1, false);
                return;
            case 6:
                g.iuh.a(338, 185, 1, false);
                return;
            default:
                return;
        }
    }

    public static void atD() {
        g.iuh.a(338, 168, 1, false);
    }

    public static void atE() {
        g.iuh.a(338, 5, 1, false);
    }
}
