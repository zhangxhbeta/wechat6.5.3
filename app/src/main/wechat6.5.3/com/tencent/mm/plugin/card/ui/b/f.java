package com.tencent.mm.plugin.card.ui.b;

import android.view.View;
import com.tencent.mm.plugin.card.ui.l;

public abstract class f {
    l eMF;

    public abstract void NI();

    public final void a(l lVar) {
        this.eMF = lVar;
        NI();
    }

    public void destroy() {
        this.eMF = null;
    }

    public void update() {
    }

    public void acF() {
    }

    protected final View findViewById(int i) {
        return this.eMF.findViewById(i);
    }

    protected final String getString(int i) {
        return this.eMF.getString(i);
    }
}
