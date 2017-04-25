package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h extends a {
    public h(MMActivity mMActivity) {
        super(mMActivity);
    }

    protected final void acd() {
        super.acd();
    }

    public final boolean acn() {
        ArrayList pV = b.pV(this.eBg.ZA());
        if ((!this.eIB.eBT || this.eIB.exT == 4) && !TextUtils.isEmpty(this.eBg.ZB())) {
            return true;
        }
        if (this.eIB.eBT && pV != null && pV.size() > 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.eBg.ZB()) || !aco()) {
            return false;
        }
        return true;
    }

    public final boolean aco() {
        return this.eIB.exT == 3;
    }

    public final boolean acp() {
        return false;
    }

    public final boolean acr() {
        return this.eMj;
    }

    public final boolean acu() {
        return false;
    }

    public final boolean acv() {
        return this.eMj && super.acv();
    }

    public final boolean acz() {
        return false;
    }

    public final boolean acA() {
        return false;
    }

    public final boolean acs() {
        return false;
    }

    public final boolean acB() {
        if (super.acB() || acC()) {
            return true;
        }
        if (this.eBg.Zb() && this.eMj) {
            return true;
        }
        return false;
    }

    public final boolean acC() {
        return !this.eMj && this.eBg.Zv().mlk == 1;
    }
}
