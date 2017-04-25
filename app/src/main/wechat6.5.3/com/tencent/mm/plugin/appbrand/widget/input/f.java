package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.widget.a.b;
import com.tencent.mm.sdk.platformtools.aa;

public final class f implements com.tencent.mm.plugin.appbrand.widget.a.a, b {
    private int dXX = 0;
    private final Rect dXY = new Rect();
    private boolean dXZ = false;
    private View dYa;
    public a dYb;

    interface a {
        void bH(boolean z);

        int getHeight();

        void hF(int i);

        void hG(int i);
    }

    private void getWindowVisibleDisplayFrame(Rect rect) {
        if (this.dYa != null) {
            this.dYa.getWindowVisibleDisplayFrame(rect);
        }
    }

    private Context getContext() {
        return this.dYa == null ? aa.getContext() : this.dYa.getContext();
    }

    private int Tc() {
        if ((this.dYa == null ? null : this.dYa.getRootView()) == null) {
            return 0;
        }
        Rect rect = this.dXY;
        getWindowVisibleDisplayFrame(rect);
        return getContext().getResources().getDisplayMetrics().heightPixels - rect.top;
    }

    public final void bH(View view) {
        boolean n;
        Object obj = 1;
        this.dYa = view;
        Rect rect = this.dXY;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.dXX == 0) {
            this.dXX = height;
        } else {
            int Tc = Tc() - height;
            if (Tc > 0) {
                if (j.aD(getContext()) != Tc) {
                    n = j.n(getContext(), Tc);
                } else {
                    n = false;
                }
                if (!(!n || this.dYb == null || this.dYb.getHeight() == Tc)) {
                    this.dYb.hF(Tc);
                }
            }
        }
        if (Tc() > height) {
            n = true;
        } else {
            n = false;
        }
        if (this.dXZ == n) {
            obj = null;
        }
        if (!(obj == null || this.dYb == null)) {
            this.dYb.bH(n);
        }
        this.dXZ = n;
        this.dXX = height;
        this.dYa = null;
    }

    public final void hE(int i) {
        if (this.dYb != null) {
            this.dYb.hG(i);
        }
    }
}
