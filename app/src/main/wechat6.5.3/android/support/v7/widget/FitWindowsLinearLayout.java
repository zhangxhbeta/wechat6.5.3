package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.x.a;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements x {
    private a VK;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(a aVar) {
        this.VK = aVar;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.VK != null) {
            this.VK.d(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
