package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    private static c kcj = new c();
    public int kcf = 0;
    private a kck = null;
    private a kcl = null;

    public static c aYt() {
        return kcj;
    }

    public final a aYs() {
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), (int) (15.0f * com.tencent.mm.bd.a.ds(aa.getContext())));
        if (this.kck == null || ((int) this.kck.cmK) != fromDPToPix) {
            this.kck = b.vT().eD(19).eE(aa.getContext().getResources().getColor(2131689909)).H((float) fromDPToPix).cmt;
        }
        return this.kck;
    }

    public final a aYu() {
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), (int) (15.0f * com.tencent.mm.bd.a.ds(aa.getContext())));
        if (this.kcl == null || ((int) this.kcl.cmK) != fromDPToPix) {
            b H = b.vT().eD(19).eE(aa.getContext().getResources().getColor(2131689909)).H((float) fromDPToPix);
            H.cmt.maxLines = 6;
            this.kcl = H.cmt;
        }
        return this.kcl;
    }

    public final int aYv() {
        if (this.kcf <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int dimension = (int) (aa.getResources().getDimension(2131493168) + aa.getResources().getDimension(2131493168));
            int dimension2 = (int) aa.getResources().getDimension(2131493579);
            int dimension3 = (int) aa.getResources().getDimension(2131493168);
            this.kcf = (i - dimension2) - dimension;
            v.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.kcf + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        return this.kcf;
    }

    public static float getTextSize() {
        return (float) com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), (int) (15.0f * com.tencent.mm.bd.a.ds(aa.getContext())));
    }
}
