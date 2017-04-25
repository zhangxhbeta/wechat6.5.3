package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;

final class c {
    LinearLayout iNA;
    LinearLayout iNB;
    LinearLayout iNx;
    LinearLayout iNy;
    LinearLayout iNz;

    c() {
    }

    public final void zo(String str) {
        if (str.equals("downloading")) {
            this.iNx.setVisibility(0);
            this.iNy.setVisibility(8);
            this.iNz.setVisibility(8);
            this.iNA.setVisibility(8);
            this.iNB.setVisibility(8);
        } else if (str.equals("downloaded")) {
            this.iNx.setVisibility(8);
            this.iNy.setVisibility(0);
            this.iNz.setVisibility(8);
            this.iNA.setVisibility(8);
            this.iNB.setVisibility(8);
        } else if (str.equals("undownloaded")) {
            this.iNx.setVisibility(8);
            this.iNy.setVisibility(8);
            this.iNz.setVisibility(0);
            this.iNA.setVisibility(8);
            this.iNB.setVisibility(8);
        } else if (str.equals("using")) {
            this.iNx.setVisibility(8);
            this.iNy.setVisibility(8);
            this.iNz.setVisibility(8);
            this.iNA.setVisibility(0);
            this.iNB.setVisibility(8);
        } else if (str.equals("canceling")) {
            this.iNx.setVisibility(8);
            this.iNy.setVisibility(8);
            this.iNz.setVisibility(8);
            this.iNA.setVisibility(8);
            this.iNB.setVisibility(0);
        }
    }
}
