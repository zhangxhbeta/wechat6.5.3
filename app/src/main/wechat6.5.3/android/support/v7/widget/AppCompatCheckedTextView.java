package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] Pf = new int[]{16843016};
    private h Ts;
    private l Tu;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.o(context), attributeSet, i);
        this.Tu = l.d(this);
        this.Tu.a(attributeSet, i);
        this.Tu.eF();
        this.Ts = h.eD();
        ap a = ap.a(getContext(), attributeSet, Pf, i);
        setCheckMarkDrawable(a.getDrawable(0));
        a.adM.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.Ts != null) {
            setCheckMarkDrawable(this.Ts.a(getContext(), i, false));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Tu != null) {
            this.Tu.g(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Tu != null) {
            this.Tu.eF();
        }
    }
}
