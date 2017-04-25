package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public final class c {

    public static class a extends com.tencent.mm.sdk.e.a {
        public WXMediaMessage nhM;
        public int scene;

        public a(Bundle bundle) {
            u(bundle);
        }

        public final int getType() {
            return 2;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.nhM = com.tencent.mm.sdk.modelmsg.WXMediaMessage.a.T(bundle);
            this.scene = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putAll(com.tencent.mm.sdk.modelmsg.WXMediaMessage.a.b(this.nhM));
            bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
        }
    }

    public static class b extends com.tencent.mm.sdk.e.b {
        public final int getType() {
            return 2;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
        }
    }
}
