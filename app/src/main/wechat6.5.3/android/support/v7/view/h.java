package android.support.v7.view;

import android.support.v4.view.ah;
import android.support.v4.view.al;
import android.support.v4.view.am;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    private long Ov = -1;
    al Ow;
    boolean Ox;
    private final am Oy = new am(this) {
        private int OA = 0;
        final /* synthetic */ h OB;
        private boolean Oz = false;

        {
            this.OB = r2;
        }

        public final void p(View view) {
            if (!this.Oz) {
                this.Oz = true;
                if (this.OB.Ow != null) {
                    this.OB.Ow.p(null);
                }
            }
        }

        public final void q(View view) {
            int i = this.OA + 1;
            this.OA = i;
            if (i == this.OB.mb.size()) {
                if (this.OB.Ow != null) {
                    this.OB.Ow.q(null);
                }
                this.OA = 0;
                this.Oz = false;
                this.OB.Ox = false;
            }
        }
    };
    private Interpolator mInterpolator;
    final ArrayList<ah> mb = new ArrayList();

    public final h g(ah ahVar) {
        if (!this.Ox) {
            this.mb.add(ahVar);
        }
        return this;
    }

    public final h a(ah ahVar, ah ahVar2) {
        this.mb.add(ahVar);
        View view = (View) ahVar.yD.get();
        ahVar2.d(view != null ? ah.yH.aq(view) : 0);
        this.mb.add(ahVar2);
        return this;
    }

    public final void start() {
        if (!this.Ox) {
            Iterator it = this.mb.iterator();
            while (it.hasNext()) {
                ah ahVar = (ah) it.next();
                if (this.Ov >= 0) {
                    ahVar.c(this.Ov);
                }
                if (this.mInterpolator != null) {
                    ahVar.b(this.mInterpolator);
                }
                if (this.Ow != null) {
                    ahVar.a(this.Oy);
                }
                ahVar.start();
            }
            this.Ox = true;
        }
    }

    public final void cancel() {
        if (this.Ox) {
            Iterator it = this.mb.iterator();
            while (it.hasNext()) {
                ((ah) it.next()).cancel();
            }
            this.Ox = false;
        }
    }

    public final h dp() {
        if (!this.Ox) {
            this.Ov = 250;
        }
        return this;
    }

    public final h c(Interpolator interpolator) {
        if (!this.Ox) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public final h b(al alVar) {
        if (!this.Ox) {
            this.Ow = alVar;
        }
        return this;
    }
}
