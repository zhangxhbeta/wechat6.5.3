package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.e;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private final Rect hc = new Rect();
    private final Rect hd = new Rect();
    int iH = 0;
    int iI;

    abstract View c(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View c = c(coordinatorLayout.n(view));
            if (c != null) {
                if (y.Z(c) && !y.Z(view)) {
                    y.a(view, true);
                    if (y.Z(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (y.ai(c)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.a(view, i, i2, MeasureSpec.makeMeasureSpec(g(c) + (size - c.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    protected final void d(CoordinatorLayout coordinatorLayout, View view, int i) {
        View c = c(coordinatorLayout.n(view));
        if (c != null) {
            d dVar = (d) view.getLayoutParams();
            Rect rect = this.hc;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, c.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + c.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            Rect rect2 = this.hd;
            int i2 = dVar.gravity;
            if (i2 == 0) {
                i2 = 8388659;
            }
            e.apply(i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            i2 = o(c);
            view.layout(rect2.left, rect2.top - i2, rect2.right, rect2.bottom - i2);
            this.iH = rect2.top - c.getBottom();
            return;
        }
        super.d(coordinatorLayout, view, i);
        this.iH = 0;
    }

    float f(View view) {
        return 1.0f;
    }

    final int o(View view) {
        return this.iI == 0 ? 0 : n.a(Math.round(f(view) * ((float) this.iI)), 0, this.iI);
    }

    int g(View view) {
        return view.getMeasuredHeight();
    }
}
