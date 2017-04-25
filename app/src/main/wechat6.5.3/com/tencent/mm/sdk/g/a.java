package com.tencent.mm.sdk.g;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.r;

public final class a extends com.tencent.mm.sdk.e.a {
    public String appId;
    public String bkj;
    public String bkk;
    public String bkl;
    public String bkm;
    public String fZW;
    public a kXA;
    public String kXw;
    public String nhN;
    public String nhO;

    public static class a {
        public String nhP;
        public int nhQ = -1;

        public final void u(Bundle bundle) {
            this.nhP = r.c(bundle, "_wxapi_payoptions_callback_classname");
            this.nhQ = r.a(bundle, "_wxapi_payoptions_callback_flags", -1);
        }
    }

    public final void t(Bundle bundle) {
        super.t(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.bkj);
        bundle.putString("_wxapi_payreq_prepayid", this.kXw);
        bundle.putString("_wxapi_payreq_noncestr", this.bkl);
        bundle.putString("_wxapi_payreq_timestamp", this.bkm);
        bundle.putString("_wxapi_payreq_packagevalue", this.nhN);
        bundle.putString("_wxapi_payreq_sign", this.fZW);
        bundle.putString("_wxapi_payreq_extdata", this.nhO);
        bundle.putString("_wxapi_payreq_sign_type", this.bkk);
        if (this.kXA != null) {
            a aVar = this.kXA;
            bundle.putString("_wxapi_payoptions_callback_classname", aVar.nhP);
            bundle.putInt("_wxapi_payoptions_callback_flags", aVar.nhQ);
        }
    }

    public final void u(Bundle bundle) {
        super.u(bundle);
        this.appId = r.c(bundle, "_wxapi_payreq_appid");
        this.bkj = r.c(bundle, "_wxapi_payreq_partnerid");
        this.kXw = r.c(bundle, "_wxapi_payreq_prepayid");
        this.bkl = r.c(bundle, "_wxapi_payreq_noncestr");
        this.bkm = r.c(bundle, "_wxapi_payreq_timestamp");
        this.nhN = r.c(bundle, "_wxapi_payreq_packagevalue");
        this.fZW = r.c(bundle, "_wxapi_payreq_sign");
        this.nhO = r.c(bundle, "_wxapi_payreq_extdata");
        this.bkk = r.c(bundle, "_wxapi_payreq_sign_type");
        this.kXA = new a();
        this.kXA.u(bundle);
    }

    public final int getType() {
        return 5;
    }
}
