package com.tencent.mm.plugin.sns.ui.widget;

import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.sdk.platformtools.aa;

public final class a {
    private static a kcg = new a();
    private com.tencent.mm.kiss.widget.textview.a.a kce = null;
    public int kcf = 0;

    public static a aYr() {
        return kcg;
    }

    public final com.tencent.mm.kiss.widget.textview.a.a aYs() {
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), (int) (14.0f * com.tencent.mm.bd.a.ds(aa.getContext())));
        if (this.kce == null || ((int) this.kce.cmK) != fromDPToPix) {
            this.kce = b.vT().H((float) fromDPToPix).eE(aa.getContext().getResources().getColor(2131690023)).eD(16).cmt;
        }
        return this.kce;
    }
}
