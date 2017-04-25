package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public final class a {

    public static class a extends com.tencent.mm.sdk.e.a {
        public String cJg;
        public String cUi;
        public String username;

        public final int getType() {
            return 3;
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", this.cUi);
            bundle.putString("_wxapi_getmessage_req_country", this.cJg);
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.cUi = bundle.getString("_wxapi_getmessage_req_lang");
            this.cJg = bundle.getString("_wxapi_getmessage_req_country");
        }
    }

    public static class b extends com.tencent.mm.sdk.e.b {
        public WXMediaMessage nhM;

        public b(Bundle bundle) {
            u(bundle);
        }

        public final int getType() {
            return 3;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.nhM = com.tencent.mm.sdk.modelmsg.WXMediaMessage.a.T(bundle);
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putAll(com.tencent.mm.sdk.modelmsg.WXMediaMessage.a.b(this.nhM));
        }
    }
}
