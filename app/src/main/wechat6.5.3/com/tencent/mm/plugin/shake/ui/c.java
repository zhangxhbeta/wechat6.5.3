package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;

final class c {
    ah aSW = new ah(new a(this) {
        final /* synthetic */ c iQH;

        {
            this.iQH = r1;
        }

        public final boolean oU() {
            this.iQH.aOv();
            return false;
        }
    }, false);
    View view;

    public c(View view) {
        this.view = view;
    }

    public final void aOv() {
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
    }
}
