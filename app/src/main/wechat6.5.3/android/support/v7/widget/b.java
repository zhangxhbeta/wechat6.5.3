package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class b extends Drawable {
    final ActionBarContainer QN;

    public b(ActionBarContainer actionBarContainer) {
        this.QN = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.QN.QU) {
            if (this.QN.Pj != null) {
                this.QN.Pj.draw(canvas);
            }
            if (this.QN.QS != null && this.QN.QV) {
                this.QN.QS.draw(canvas);
            }
        } else if (this.QN.QT != null) {
            this.QN.QT.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
