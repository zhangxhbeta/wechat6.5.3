package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class l {
    private static final int[] Uv = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] Uw = new int[]{a.textAllCaps};
    private an UA;
    private an UB;
    final TextView Ux;
    private an Uy;
    private an Uz;

    static l d(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new m(textView);
        }
        return new l(textView);
    }

    l(TextView textView) {
        this.Ux = textView;
    }

    void a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.Ux.getContext();
        h eD = h.eD();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Uv, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.Uy = a(context, eD, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.Uz = a(context, eD, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.UA = a(context, eD, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.UB = a(context, eD, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.Ux.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, k.dj);
                if (obtainStyledAttributes2.hasValue(k.MD)) {
                    z = obtainStyledAttributes2.getBoolean(k.MD, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, Uw, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                setAllCaps(z);
            }
        }
    }

    final void g(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, Uw);
        if (obtainStyledAttributes.hasValue(0)) {
            setAllCaps(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    private void setAllCaps(boolean z) {
        this.Ux.setTransformationMethod(z ? new android.support.v7.e.a(this.Ux.getContext()) : null);
    }

    void eF() {
        if (this.Uy != null || this.Uz != null || this.UA != null || this.UB != null) {
            Drawable[] compoundDrawables = this.Ux.getCompoundDrawables();
            a(compoundDrawables[0], this.Uy);
            a(compoundDrawables[1], this.Uz);
            a(compoundDrawables[2], this.UA);
            a(compoundDrawables[3], this.UB);
        }
    }

    final void a(Drawable drawable, an anVar) {
        if (drawable != null && anVar != null) {
            h.a(drawable, anVar, this.Ux.getDrawableState());
        }
    }

    protected static an a(Context context, h hVar, int i) {
        ColorStateList e = hVar.e(context, i);
        if (e == null) {
            return null;
        }
        an anVar = new an();
        anVar.adK = true;
        anVar.adI = e;
        return anVar;
    }
}
