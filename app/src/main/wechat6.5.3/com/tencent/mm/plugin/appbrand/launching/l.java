package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.netscene.g;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.protocal.c.kb;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class l {
    private final String aZy;
    private final String appId;

    enum a {
        Ok,
        Fail,
        Timeout,
        CgiFail,
        ResponseInvalid,
        AwaitFail;

        public static a hf(int i) {
            if (i < 0) {
                return null;
            }
            for (a aVar : values()) {
                if (aVar.ordinal() == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    l(String str, String str2) {
        this.appId = str;
        this.aZy = str2;
    }

    public final int QH() {
        String str = this.appId;
        String str2 = this.aZy;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        kb kbVar = new kb();
        kbVar.bmJ = str;
        kbVar.mmy = str2;
        aVar.czn = kbVar;
        aVar.czo = new kc();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.czm = 1124;
        com.tencent.mm.v.a.a b = g.b(aVar.Bv());
        if (b.errType == 0 && b.errCode == 0) {
            try {
                kc kcVar = (kc) b.bra;
                if (kcVar.mmz == null) {
                    v.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[]{this.appId});
                    return a.ResponseInvalid.ordinal();
                }
                v.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[]{this.appId, Integer.valueOf(kcVar.mmz.fvC), Boolean.valueOf(kcVar.mmA), kcVar.mmB, kcVar.mmC});
                if (kcVar.mmz.fvC != 0) {
                    return kcVar.mmz.fvC;
                }
                if (!(!kcVar.mmA || be.kS(kcVar.mmC) || be.kS(kcVar.mmB))) {
                    com.tencent.mm.plugin.appbrand.a.a.dzP.a(this.appId, 2, kcVar.mmB, kcVar.mmC, 0, 0);
                    AppBrandTaskManager.ab(this.appId, 2);
                }
                return a.Ok.ordinal();
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[]{this.appId});
                return a.ResponseInvalid.ordinal();
            }
        }
        v.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[]{this.appId, Integer.valueOf(b.errType), Integer.valueOf(b.errCode), b.biS});
        return a.CgiFail.ordinal();
    }
}
