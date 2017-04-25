package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.app.l;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.hp.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class a extends com.tencent.tinker.lib.a.a {
    private final int gDZ;

    public a(Context context) {
        super(context);
        this.gDZ = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.gDZ, new Object[0]);
    }

    public final int uE(String str) {
        boolean z = false;
        File file = new File(str);
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[]{str, Long.valueOf(SharePatchFileUtil.O(file))});
        int uE = super.uE(str);
        if (uE == 0) {
            uE = this.gDZ < 45 ? -9 : !f.bZ(83886080) ? -6 : 0;
        }
        if (uE == 0) {
            String Q = SharePatchFileUtil.Q(file);
            com.tencent.tinker.lib.d.a gh = com.tencent.tinker.lib.d.a.gh(this.context);
            if (gh.pFS) {
                d dVar = gh.pFR;
                if (dVar != null && Q.equals(dVar.pFW)) {
                    uE = -7;
                }
            }
            if (uE == 0) {
                Properties U = ShareTinkerInternals.U(file);
                if (U == null) {
                    uE = -10;
                } else {
                    String property = U.getProperty("patch.basepack.client.ver");
                    com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:" + property, new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(BaseBuildInfo.cmV)) {
                        uE = -11;
                    }
                }
                if (uE == 0) {
                    e cd = e.cd(this.context);
                    if (!cd.gEd) {
                        com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
                    } else if (!cd.gEe.exists()) {
                        com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
                    } else if (Q == null) {
                        com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
                    } else {
                        a v = a.v(cd.gEe);
                        if (Q.equals(v.aZy) && be.getInt(v.gEh, 0) >= 4) {
                            com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", new Object[]{Integer.valueOf(be.getInt(v.gEh, 0))});
                            SharePatchFileUtil.P(cd.gEf);
                            boolean z2 = false;
                            uE = uE == 0 ? 0 : -13;
                        }
                    }
                    uE = 1;
                    if (uE == 0) {
                    }
                }
            }
        }
        if (uE == 0 && ShareTinkerInternals.bPb() && l.a(new Throwable().getStackTrace())) {
            uE = -12;
        }
        if (uE == 0) {
            z = true;
        }
        b.dw(z);
        return uE;
    }
}
