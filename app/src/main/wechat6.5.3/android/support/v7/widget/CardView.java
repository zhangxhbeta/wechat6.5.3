package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.support.v7.b.a.c;
import android.support.v7.b.a.d;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout implements o {
    private static final int[] UH = new int[]{16842801};
    public static final q UI;
    private boolean UJ;
    private int UK;
    private int UL;
    private final Rect UM = new Rect();
    private final Rect UN = new Rect();
    private boolean hQ;

    static {
        if (VERSION.SDK_INT >= 21) {
            UI = new n();
        } else if (VERSION.SDK_INT >= 17) {
            UI = new r();
        } else {
            UI = new p();
        }
        UI.eJ();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public final boolean eH() {
        return this.hQ;
    }

    protected void onMeasure(int i, int i2) {
        if (UI instanceof n) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) UI.a(this)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) UI.b(this)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.Nq, i, c.Np);
        if (obtainStyledAttributes.hasValue(d.Nt)) {
            color = obtainStyledAttributes.getColor(d.Nt, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(UH);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(a.Nl) : getResources().getColor(a.Nk);
        }
        float dimension = obtainStyledAttributes.getDimension(d.Nu, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.Nv, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.Nw, 0.0f);
        this.hQ = obtainStyledAttributes.getBoolean(d.Ny, false);
        this.UJ = obtainStyledAttributes.getBoolean(d.Nx, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.Nz, 0);
        this.UM.left = obtainStyledAttributes.getDimensionPixelSize(d.NB, dimensionPixelSize);
        this.UM.top = obtainStyledAttributes.getDimensionPixelSize(d.ND, dimensionPixelSize);
        this.UM.right = obtainStyledAttributes.getDimensionPixelSize(d.NC, dimensionPixelSize);
        this.UM.bottom = obtainStyledAttributes.getDimensionPixelSize(d.NA, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.UK = obtainStyledAttributes.getDimensionPixelSize(d.Ns, 0);
        this.UL = obtainStyledAttributes.getDimensionPixelSize(d.Nr, 0);
        obtainStyledAttributes.recycle();
        UI.a(this, context, color, dimension, dimension2, dimension3);
    }

    public void setMinimumWidth(int i) {
        this.UK = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.UL = i;
        super.setMinimumHeight(i);
    }

    public final void x(int i, int i2) {
        if (i > this.UK) {
            super.setMinimumWidth(i);
        }
        if (i2 > this.UL) {
            super.setMinimumHeight(i2);
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        this.UN.set(i, i2, i3, i4);
        super.setPadding(this.UM.left + i, this.UM.top + i2, this.UM.right + i3, this.UM.bottom + i4);
    }

    public void setCardElevation(float f) {
        UI.a((o) this, f);
    }

    public float getCardElevation() {
        return UI.d(this);
    }

    public final boolean eI() {
        return this.UJ;
    }
}
