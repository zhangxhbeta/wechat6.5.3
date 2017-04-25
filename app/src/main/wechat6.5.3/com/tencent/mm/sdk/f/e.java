package com.tencent.mm.sdk.f;

import android.os.Bundle;
import com.tencent.mm.sdk.e.b;

public final class e {

    public static class a extends b {
        public String bfz;

        public final int getType() {
            return 12;
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            this.bfz = bundle.getString("_wxapi_open_webview_result");
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putString("_wxapi_open_webview_result", this.bfz);
        }
    }
}
