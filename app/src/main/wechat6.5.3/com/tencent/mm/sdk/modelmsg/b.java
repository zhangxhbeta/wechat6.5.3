package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public final class b {

    public static class a extends com.tencent.mm.sdk.e.a {
        public String cCl;
        public String mEw;

        public a(Bundle bundle) {
            u(bundle);
        }

        public final int getType() {
            return 1;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.mEw = bundle.getString("_wxapi_sendauth_req_scope");
            this.cCl = bundle.getString("_wxapi_sendauth_req_state");
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.mEw);
            bundle.putString("_wxapi_sendauth_req_state", this.cCl);
        }
    }

    public static class b extends com.tencent.mm.sdk.e.b {
        public String cCl;
        public String cJg;
        public String cUi;
        public String code;
        public String url;

        public final int getType() {
            return 1;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.code = bundle.getString("_wxapi_sendauth_resp_token");
            this.cCl = bundle.getString("_wxapi_sendauth_resp_state");
            this.url = bundle.getString("_wxapi_sendauth_resp_url");
            this.cUi = bundle.getString("_wxapi_sendauth_resp_lang");
            this.cJg = bundle.getString("_wxapi_sendauth_resp_country");
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putString("_wxapi_sendauth_resp_token", this.code);
            bundle.putString("_wxapi_sendauth_resp_state", this.cCl);
            bundle.putString("_wxapi_sendauth_resp_url", this.url);
            bundle.putString("_wxapi_sendauth_resp_lang", this.cUi);
            bundle.putString("_wxapi_sendauth_resp_country", this.cJg);
        }
    }
}
