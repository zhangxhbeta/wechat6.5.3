package com.tencent.mm.plugin.sight.encode.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;

public final class h implements a {
    protected View iXn;
    protected View iXo;
    protected View iXp;
    private ah iXq;

    public final void e(ViewGroup viewGroup) {
        this.iXq = new ah(this, false);
        this.iXn = viewGroup.findViewById(2131756306);
        this.iXo = viewGroup.findViewById(2131756308);
        this.iXp = viewGroup.findViewById(2131756307);
        hide();
    }

    public final void aPU() {
        pE(0);
        if (this.iXo.getVisibility() != 8) {
            this.iXo.setVisibility(8);
        }
        if (this.iXp.getVisibility() != 8) {
            this.iXp.setVisibility(8);
        }
    }

    public final void aPV() {
        pE(8);
        if (this.iXo.getVisibility() != 0) {
            this.iXo.setVisibility(0);
        }
        if (this.iXp.getVisibility() != 8) {
            this.iXp.setVisibility(8);
        }
    }

    public final void aPW() {
        pE(8);
        if (this.iXo.getVisibility() != 8) {
            this.iXo.setVisibility(8);
        }
        if (this.iXp.getVisibility() != 0) {
            this.iXp.setVisibility(0);
        }
    }

    private void pE(int i) {
        if (this.iXn.getVisibility() != i) {
            if (i == 0) {
                this.iXq.ea(3000);
            } else {
                this.iXq.QI();
            }
            this.iXn.setVisibility(i);
        }
    }

    public final void hide() {
        pE(8);
        this.iXo.setVisibility(8);
        this.iXp.setVisibility(8);
    }

    public final boolean oU() {
        if (this.iXn != null) {
            this.iXn.setVisibility(8);
        }
        return false;
    }
}
