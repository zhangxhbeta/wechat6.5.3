package android.support.design.widget;

import android.support.v4.view.y;
import android.view.View;

final class z {
    private int lI;
    private int lJ;
    int lK;
    int lL;
    private final View mView;

    public z(View view) {
        this.mView = view;
    }

    public final void aC() {
        this.lI = this.mView.getTop();
        this.lJ = this.mView.getLeft();
        aD();
    }

    final void aD() {
        y.i(this.mView, this.lK - (this.mView.getTop() - this.lI));
        y.j(this.mView, this.lL - (this.mView.getLeft() - this.lJ));
    }

    public final boolean f(int i) {
        if (this.lK == i) {
            return false;
        }
        this.lK = i;
        aD();
        return true;
    }
}
