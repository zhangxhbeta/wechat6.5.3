package com.tencent.mm.sdk.f;

import android.os.Bundle;
import com.tencent.mm.sdk.e.b;

public final class d {

    public static class a extends b {
        public String beZ;

        public final int getType() {
            return 15;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.beZ = bundle.getString("_wxapi_join_chatroom_ext_msg");
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.beZ);
        }
    }
}
