package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public final class d {

    public static class a extends com.tencent.mm.sdk.e.a {
        public String cJg;
        public String cUi;
        public WXMediaMessage nhM;

        public final int getType() {
            return 4;
        }

        public final void t(Bundle bundle) {
            Bundle b = com.tencent.mm.sdk.modelmsg.WXMediaMessage.a.b(this.nhM);
            super.t(b);
            bundle.putString("_wxapi_showmessage_req_lang", this.cUi);
            bundle.putString("_wxapi_showmessage_req_country", this.cJg);
            bundle.putAll(b);
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.cUi = bundle.getString("_wxapi_showmessage_req_lang");
            this.cJg = bundle.getString("_wxapi_showmessage_req_country");
            this.nhM = com.tencent.mm.sdk.modelmsg.WXMediaMessage.a.T(bundle);
        }
    }

    public static class b extends com.tencent.mm.sdk.e.b {
        public b(Bundle bundle) {
            u(bundle);
        }

        public final int getType() {
            return 4;
        }
    }
}
