package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.ui.MMActivity;

public final class e extends a {
    public e(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean acm() {
        if (!this.eBg.Zc() || j.jl(this.eIB.exT) || !this.eBg.Zr() || this.eMj) {
            return true;
        }
        return false;
    }

    public final boolean acq() {
        return this.eBg.Zc() && !j.jl(this.eIB.exT) && this.eBg.Zr() && !this.eMj;
    }

    public final boolean acr() {
        return this.eMj;
    }

    public final boolean acu() {
        return super.acu() || (this.eBg.Zr() && !this.eMj && (acb() || acc()));
    }

    public final boolean acD() {
        return (!this.eBg.Zc() || this.eBg.Zv().mlf == null || !this.eBg.Zr() || this.eMj || acb() || acc()) ? false : true;
    }

    public final boolean acz() {
        return this.eBg.Zr() && super.acz();
    }

    public final boolean ace() {
        return (!super.ace() || !this.eBg.Zr() || this.eMj || acb() || acc()) ? false : true;
    }
}
