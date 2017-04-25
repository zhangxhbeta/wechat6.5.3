package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.base.h;

public final class a extends com.tencent.mm.ui.base.h.a {
    private boolean dQv = false;

    public a(Context context) {
        super(context);
        if (context instanceof Activity) {
            this.dQv = f.b(((Activity) context).getWindow());
        }
    }

    public final h RX() {
        h RX = super.RX();
        f.a(RX.getWindow(), this.dQv);
        return RX;
    }
}
