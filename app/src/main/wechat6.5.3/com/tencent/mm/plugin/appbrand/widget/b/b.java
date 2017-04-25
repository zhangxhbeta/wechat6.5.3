package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.input.d;

public abstract class b {
    public a dZe;

    public abstract View Qz();

    public final a Tn() {
        if (this.dZe != null) {
            return this.dZe;
        }
        if (Qz() == null) {
            return null;
        }
        View bF = d.bF(Qz());
        if (bF == null) {
            return null;
        }
        a bK = a.bK(bF);
        if (bK == null) {
            bK = new a(Qz().getContext());
            bF.g(bK, true);
        }
        this.dZe = bK;
        return bK;
    }
}
