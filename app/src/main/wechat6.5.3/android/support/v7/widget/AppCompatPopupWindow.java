package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.m;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class AppCompatPopupWindow extends PopupWindow {
    private static final boolean TV = (VERSION.SDK_INT < 21);
    private boolean TW;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ap a = ap.a(context, attributeSet, k.cz, i);
        if (a.hasValue(k.LU)) {
            boolean z = a.getBoolean(k.LU, false);
            if (TV) {
                this.TW = z;
            } else {
                m.a((PopupWindow) this, z);
            }
        }
        setBackgroundDrawable(a.getDrawable(k.LT));
        a.adM.recycle();
        if (VERSION.SDK_INT < 14) {
            try {
                final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
                declaredField.setAccessible(true);
                Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField2.setAccessible(true);
                final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(this);
                declaredField2.set(this, new OnScrollChangedListener() {
                    public final void onScrollChanged() {
                        try {
                            WeakReference weakReference = (WeakReference) declaredField.get(this);
                            if (weakReference != null && weakReference.get() != null) {
                                onScrollChangedListener.onScrollChanged();
                            }
                        } catch (IllegalAccessException e) {
                        }
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (TV && this.TW) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (TV && this.TW) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (TV && this.TW) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }
}
