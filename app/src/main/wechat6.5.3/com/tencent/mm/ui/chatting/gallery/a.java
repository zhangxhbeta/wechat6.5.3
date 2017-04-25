package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.at;

public abstract class a {
    protected b ozG;

    public a(b bVar) {
        this.ozG = bVar;
    }

    public void detach() {
        this.ozG = null;
    }

    public boolean a(j jVar, at atVar, int i) {
        return false;
    }

    public final j xq(int i) {
        if (this.ozG == null) {
            return null;
        }
        View wA = this.ozG.wA(i);
        return wA == null ? null : (j) wA.getTag();
    }

    public final void xr(int i) {
        if (this.ozG != null) {
            View wA = this.ozG.wA(i);
            if (wA != null && wA.getTag() != null) {
                a((j) wA.getTag(), this.ozG.xs(i), i);
            }
        }
    }

    protected void onPause() {
    }
}
