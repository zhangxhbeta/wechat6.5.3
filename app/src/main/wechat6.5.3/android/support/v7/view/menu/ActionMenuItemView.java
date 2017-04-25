package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements android.support.v7.view.menu.m.a, android.support.v7.widget.ActionMenuView.a, OnClickListener, OnLongClickListener {
    public android.support.v7.view.menu.f.b OO;
    private android.support.v7.widget.ListPopupWindow.b OP;
    public b OQ;
    private boolean OR;
    private boolean OS;
    private int OT;
    private int OU;
    private int OV;
    private h dQ;
    private Drawable jP;
    private CharSequence up;

    public static abstract class b {
        public abstract ListPopupWindow dt();
    }

    private class a extends android.support.v7.widget.ListPopupWindow.b {
        final /* synthetic */ ActionMenuItemView OW;

        public a(ActionMenuItemView actionMenuItemView) {
            this.OW = actionMenuItemView;
            super(actionMenuItemView);
        }

        public final ListPopupWindow dt() {
            if (this.OW.OQ != null) {
                return this.OW.OQ.dt();
            }
            return null;
        }

        protected final boolean du() {
            if (this.OW.OO == null || !this.OW.OO.f(this.OW.dQ)) {
                return false;
            }
            ListPopupWindow dt = dt();
            if (dt == null || !dt.Xa.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.OR = resources.getBoolean(android.support.v7.a.a.b.HV);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.aX, i, 0);
        this.OT = obtainStyledAttributes.getDimensionPixelSize(k.Kz, 0);
        obtainStyledAttributes.recycle();
        this.OV = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.OU = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.OR = getContext().getResources().getBoolean(android.support.v7.a.a.b.HV);
        dq();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.OU = i;
        super.setPadding(i, i2, i3, i4);
    }

    public final h C() {
        return this.dQ;
    }

    public final void a(h hVar) {
        this.dQ = hVar;
        Drawable icon = hVar.getIcon();
        this.jP = icon;
        if (icon != null) {
            float f;
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            if (intrinsicWidth > this.OV) {
                f = ((float) this.OV) / ((float) intrinsicWidth);
                intrinsicWidth = this.OV;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.OV) {
                f = ((float) this.OV) / ((float) intrinsicHeight);
                intrinsicHeight = this.OV;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            icon.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(icon, null, null, null);
        dq();
        this.up = hVar.a((android.support.v7.view.menu.m.a) this);
        setContentDescription(this.up);
        dq();
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.OP == null) {
            this.OP = new a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dQ.hasSubMenu() && this.OP != null && this.OP.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.OO != null) {
            this.OO.f(this.dQ);
        }
    }

    public final boolean D() {
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dq() {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r0 = r5.up;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r5.jP;
        if (r3 == 0) goto L_0x0023;
    L_0x000f:
        r3 = r5.dQ;
        r3 = r3.PV;
        r3 = r3 & 4;
        r4 = 4;
        if (r3 != r4) goto L_0x002f;
    L_0x0018:
        r3 = r1;
    L_0x0019:
        if (r3 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r5.OR;
        if (r3 != 0) goto L_0x0023;
    L_0x001f:
        r3 = r5.OS;
        if (r3 == 0) goto L_0x0024;
    L_0x0023:
        r2 = r1;
    L_0x0024:
        r0 = r0 & r2;
        if (r0 == 0) goto L_0x0031;
    L_0x0027:
        r0 = r5.up;
    L_0x0029:
        r5.setText(r0);
        return;
    L_0x002d:
        r0 = r2;
        goto L_0x000b;
    L_0x002f:
        r3 = r2;
        goto L_0x0019;
    L_0x0031:
        r0 = 0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.ActionMenuItemView.dq():void");
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean dr() {
        return hasText() && this.dQ.getIcon() == null;
    }

    public final boolean ds() {
        return hasText();
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (y.I(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.dQ.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.OU >= 0) {
            super.setPadding(this.OU, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.OT) : this.OT;
        if (mode != 1073741824 && this.OT > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!hasText && this.jP != null) {
            super.setPadding((getMeasuredWidth() - this.jP.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
