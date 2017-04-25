package android.support.v7.widget;

import android.graphics.Outline;

final class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public final void getOutline(Outline outline) {
        if (this.QN.QU) {
            if (this.QN.QT != null) {
                this.QN.QT.getOutline(outline);
            }
        } else if (this.QN.Pj != null) {
            this.QN.Pj.getOutline(outline);
        }
    }
}
