package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;

public abstract class d {
    public MMActivity piR;
    public f piS;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public abstract boolean j(Object... objArr);

    public d(MMActivity mMActivity, f fVar) {
        this.piR = mMActivity;
        this.piS = fVar;
    }

    public CharSequence nK(int i) {
        return null;
    }

    public boolean o(Object... objArr) {
        return false;
    }

    public boolean p(Object... objArr) {
        return false;
    }
}
