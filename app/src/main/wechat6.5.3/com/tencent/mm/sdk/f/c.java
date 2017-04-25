package com.tencent.mm.sdk.f;

import android.os.Bundle;
import com.tencent.mm.sdk.e.b;

public final class c {

    public static class a extends b {
        public String beZ;

        public final int getType() {
            return 14;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.beZ = bundle.getString("_wxapi_create_chatroom_ext_msg");
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.beZ);
        }
    }
}
