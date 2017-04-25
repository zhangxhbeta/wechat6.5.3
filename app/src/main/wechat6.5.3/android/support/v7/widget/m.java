package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class m extends l {
    private static final int[] UC = new int[]{16843666, 16843667};
    private an UD;
    private an UE;

    m(TextView textView) {
        super(textView);
    }

    final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.Ux.getContext();
        h eD = h.eD();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, UC, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.UD = l.a(context, eD, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.UE = l.a(context, eD, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    final void eF() {
        super.eF();
        if (this.UD != null || this.UE != null) {
            Drawable[] compoundDrawablesRelative = this.Ux.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.UD);
            a(compoundDrawablesRelative[2], this.UE);
        }
    }
}
