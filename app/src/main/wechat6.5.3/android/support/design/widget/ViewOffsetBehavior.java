package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private z lF;
    private int lG = 0;
    private int lH = 0;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        d(coordinatorLayout, v, i);
        if (this.lF == null) {
            this.lF = new z(v);
        }
        this.lF.aC();
        if (this.lG != 0) {
            this.lF.f(this.lG);
            this.lG = 0;
        }
        if (this.lH != 0) {
            z zVar = this.lF;
            int i2 = this.lH;
            if (zVar.lL != i2) {
                zVar.lL = i2;
                zVar.aD();
            }
            this.lH = 0;
        }
        return true;
    }

    protected void d(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.d(v, i);
    }

    public boolean f(int i) {
        if (this.lF != null) {
            return this.lF.f(i);
        }
        this.lG = i;
        return false;
    }

    public int L() {
        return this.lF != null ? this.lF.lK : 0;
    }
}
