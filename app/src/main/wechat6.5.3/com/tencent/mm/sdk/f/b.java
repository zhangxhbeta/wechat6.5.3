package com.tencent.mm.sdk.f;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.v;

public final class b {

    public static class a extends com.tencent.mm.sdk.e.b {
        public String nhL;

        public a(Bundle bundle) {
            u(bundle);
        }

        public final int getType() {
            return 16;
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.nhL);
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string == null || string.length() <= 0) {
                v.i("MicroMsg.ChooseCardFromWXCardPackage", "cardItemList is empty!");
            } else {
                this.nhL = string;
            }
        }
    }
}
