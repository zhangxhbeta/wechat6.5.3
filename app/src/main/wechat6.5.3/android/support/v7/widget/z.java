package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.o.a;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class z extends o {
    protected final DecelerateInterpolator Dt = new DecelerateInterpolator();
    protected final LinearInterpolator WT = new LinearInterpolator();
    protected PointF WU;
    private final float WV;
    protected int WW = 0;
    protected int WX = 0;

    public abstract PointF aS(int i);

    public z(Context context) {
        this.WV = 25.0f / ((float) context.getResources().getDisplayMetrics().densityDpi);
    }

    protected final void a(View view, a aVar) {
        int i = 1;
        int i2 = 0;
        int i3 = (this.WU == null || this.WU.x == 0.0f) ? 0 : this.WU.x > 0.0f ? 1 : -1;
        h hVar = this.XX;
        if (hVar == null || !hVar.eV()) {
            i3 = 0;
        } else {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i3 = e(h.bh(view) - layoutParams.leftMargin, layoutParams.rightMargin + h.bj(view), hVar.getPaddingLeft(), hVar.Zx - hVar.getPaddingRight(), i3);
        }
        if (this.WU == null || this.WU.y == 0.0f) {
            i = 0;
        } else if (this.WU.y <= 0.0f) {
            i = -1;
        }
        h hVar2 = this.XX;
        if (hVar2 != null && hVar2.eW()) {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i2 = e(h.bi(view) - layoutParams.topMargin, layoutParams.bottomMargin + h.bk(view), hVar2.getPaddingTop(), hVar2.QW - hVar2.getPaddingBottom(), i);
        }
        int ceil = (int) Math.ceil(((double) aV((int) Math.sqrt((double) ((i3 * i3) + (i2 * i2))))) / 0.3356d);
        if (ceil > 0) {
            aVar.a(-i3, -i2, ceil, this.Dt);
        }
    }

    protected final void a(int i, int i2, a aVar) {
        if (this.Zq.Ym.getChildCount() == 0) {
            stop();
            return;
        }
        this.WW = J(this.WW, i);
        this.WX = J(this.WX, i2);
        if (this.WW == 0 && this.WX == 0) {
            PointF aS = aS(this.ZM);
            if (aS == null || (aS.x == 0.0f && aS.y == 0.0f)) {
                aVar.ZT = this.ZM;
                stop();
                return;
            }
            double sqrt = Math.sqrt((double) ((aS.x * aS.x) + (aS.y * aS.y)));
            aS.x = (float) (((double) aS.x) / sqrt);
            aS.y = (float) (((double) aS.y) / sqrt);
            this.WU = aS;
            this.WW = (int) (aS.x * 10000.0f);
            this.WX = (int) (aS.y * 10000.0f);
            aVar.a((int) (((float) this.WW) * 1.2f), (int) (((float) this.WX) * 1.2f), (int) (((float) aV(10000)) * 1.2f), this.WT);
        }
    }

    protected final void onStop() {
        this.WX = 0;
        this.WW = 0;
        this.WU = null;
    }

    public int aV(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.WV));
    }

    private static int J(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private static int e(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }
}
