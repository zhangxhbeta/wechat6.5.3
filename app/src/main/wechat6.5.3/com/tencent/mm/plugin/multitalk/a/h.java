package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import com.tencent.mm.ah.a;

public final class h {
    public boolean hzL;
    private boolean hzM;

    public final void z(Activity activity) {
        if (!this.hzL) {
            this.hzL = true;
            a.a(activity, 2131233945, null);
        }
    }

    public final void A(Activity activity) {
        if (!this.hzM) {
            this.hzM = true;
            a.a(activity, 2131235931, null);
        }
    }

    public final void reset() {
        this.hzM = false;
        this.hzL = false;
    }
}
