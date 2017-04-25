package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.n;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
    private static final int[] dM = new int[]{16842912};
    private final h Ts;
    private int YO;
    private Drawable acZ;
    private Drawable ada;
    private int adb;
    private int adc;
    private int add;
    private boolean ade;
    private CharSequence adf;
    private CharSequence adg;
    private boolean adh;
    private int adi;
    private float adj;
    private float adk;
    private float adl;
    private int adm;
    private int adn;
    private int ado;
    private int adp;
    private int adq;
    private int adr;
    private int ads;
    private ColorStateList adt;
    private Layout adu;
    private Layout adv;
    private TransformationMethod adw;
    private a adx;
    private final Rect ep;
    private VelocityTracker fj;
    private TextPaint gl;
    private int iD;

    private class a extends Animation {
        final float adA;
        final float adB;
        final float adC;
        final /* synthetic */ SwitchCompat adz;

        private a(SwitchCompat switchCompat, float f, float f2) {
            this.adz = switchCompat;
            this.adA = f;
            this.adB = f2;
            this.adC = f2 - f;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            this.adz.D(this.adA + (this.adC * f));
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fj = VelocityTracker.obtain();
        this.ep = new Rect();
        this.gl = new TextPaint(1);
        this.gl.density = getResources().getDisplayMetrics().density;
        ap a = ap.a(context, attributeSet, k.cM, i);
        this.acZ = a.getDrawable(k.Mt);
        if (this.acZ != null) {
            this.acZ.setCallback(this);
        }
        this.ada = a.getDrawable(k.MA);
        if (this.ada != null) {
            this.ada.setCallback(this);
        }
        this.adf = a.getText(k.Ms);
        this.adg = a.getText(k.Mr);
        this.adh = a.getBoolean(k.Mu, true);
        this.adb = a.getDimensionPixelSize(k.Mz, 0);
        this.adc = a.getDimensionPixelSize(k.Mw, 0);
        this.add = a.getDimensionPixelSize(k.Mx, 0);
        this.ade = a.getBoolean(k.Mv, false);
        int resourceId = a.getResourceId(k.My, 0);
        if (resourceId != 0) {
            Typeface typeface;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, k.dj);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(k.do);
            if (colorStateList != null) {
                this.adt = colorStateList;
            } else {
                this.adt = getTextColors();
            }
            resourceId = obtainStyledAttributes.getDimensionPixelSize(k.dp, 0);
            if (!(resourceId == 0 || ((float) resourceId) == this.gl.getTextSize())) {
                this.gl.setTextSize((float) resourceId);
                requestLayout();
            }
            resourceId = obtainStyledAttributes.getInt(k.MC, -1);
            int i2 = obtainStyledAttributes.getInt(k.MB, -1);
            switch (resourceId) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i2 > 0) {
                typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                setSwitchTypeface(typeface);
                i2 &= (typeface != null ? typeface.getStyle() : 0) ^ -1;
                this.gl.setFakeBoldText((i2 & 1) != 0);
                this.gl.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                this.gl.setFakeBoldText(false);
                this.gl.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(k.MD, false)) {
                this.adw = new android.support.v7.e.a(getContext());
            } else {
                this.adw = null;
            }
            obtainStyledAttributes.recycle();
        }
        this.Ts = h.eD();
        a.adM.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.iD = viewConfiguration.getScaledTouchSlop();
        this.YO = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void setSwitchTypeface(Typeface typeface) {
        if (this.gl.getTypeface() != typeface) {
            this.gl.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.adh) {
            if (this.adu == null) {
                this.adu = i(this.adf);
            }
            if (this.adv == null) {
                this.adv = i(this.adg);
            }
        }
        Rect rect = this.ep;
        if (this.acZ != null) {
            this.acZ.getPadding(rect);
            intrinsicWidth = (this.acZ.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.acZ.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.adh) {
            max = Math.max(this.adu.getWidth(), this.adv.getWidth()) + (this.adb * 2);
        } else {
            max = 0;
        }
        this.ado = Math.max(max, intrinsicWidth);
        if (this.ada != null) {
            this.ada.getPadding(rect);
            i3 = this.ada.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        max = rect.right;
        if (this.acZ != null) {
            rect = w.m(this.acZ);
            intrinsicWidth = Math.max(intrinsicWidth, rect.left);
            max = Math.max(max, rect.right);
        }
        intrinsicWidth = Math.max(this.adc, (intrinsicWidth + (this.ado * 2)) + max);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.adm = intrinsicWidth;
        this.adn = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(y.L(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.adf : this.adg;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout i(CharSequence charSequence) {
        CharSequence transformation;
        if (this.adw != null) {
            transformation = this.adw.getTransformation(charSequence, this);
        } else {
            transformation = charSequence;
        }
        return new StaticLayout(transformation, this.gl, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.gl)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 1.0f;
        int i = 0;
        this.fj.addMovement(motionEvent);
        float x;
        switch (n.d(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                f = motionEvent.getY();
                if (isEnabled()) {
                    if (this.acZ != null) {
                        int thumbOffset = getThumbOffset();
                        this.acZ.getPadding(this.ep);
                        int i2 = this.adq - this.iD;
                        thumbOffset = (thumbOffset + this.adp) - this.iD;
                        int i3 = (((this.ado + thumbOffset) + this.ep.left) + this.ep.right) + this.iD;
                        int i4 = this.ads + this.iD;
                        if (x > ((float) thumbOffset) && x < ((float) i3) && f > ((float) i2) && f < ((float) i4)) {
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        this.adi = 1;
                        this.adj = x;
                        this.adk = f;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.adi != 2) {
                    this.adi = 0;
                    this.fj.clear();
                    break;
                }
                boolean z;
                this.adi = 0;
                if (motionEvent.getAction() == 1 && isEnabled()) {
                    z = true;
                } else {
                    z = false;
                }
                boolean isChecked = isChecked();
                if (z) {
                    this.fj.computeCurrentVelocity(1000);
                    x = this.fj.getXVelocity();
                    z = Math.abs(x) > ((float) this.YO) ? as.bu(this) ? x < 0.0f : x > 0.0f : gV();
                } else {
                    z = isChecked;
                }
                if (z != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.adi) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        f = motionEvent.getY();
                        if (Math.abs(x - this.adj) > ((float) this.iD) || Math.abs(f - this.adk) > ((float) this.iD)) {
                            this.adi = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.adj = x;
                            this.adk = f;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int gW = gW();
                        float f2 = x2 - this.adj;
                        x = gW != 0 ? f2 / ((float) gW) : f2 > 0.0f ? 1.0f : -1.0f;
                        if (as.bu(this)) {
                            x = -x;
                        }
                        x += this.adl;
                        if (x < 0.0f) {
                            f = 0.0f;
                        } else if (x <= 1.0f) {
                            f = x;
                        }
                        if (f == this.adl) {
                            return true;
                        }
                        this.adj = x2;
                        D(f);
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void gU() {
        if (this.adx != null) {
            clearAnimation();
            this.adx = null;
        }
    }

    private boolean gV() {
        return this.adl > 0.5f;
    }

    private void D(float f) {
        this.adl = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        float f = 1.0f;
        super.setChecked(z);
        final boolean isChecked = isChecked();
        if (getWindowToken() != null && y.ai(this) && isShown()) {
            if (this.adx != null) {
                gU();
            }
            float f2 = this.adl;
            if (!isChecked) {
                f = 0.0f;
            }
            this.adx = new a(f2, f);
            this.adx.setDuration(250);
            this.adx.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ SwitchCompat adz;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (this.adz.adx == animation) {
                        this.adz.D(isChecked ? 1.0f : 0.0f);
                        this.adz.adx = null;
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            startAnimation(this.adx);
            return;
        }
        gU();
        if (!isChecked) {
            f = 0.0f;
        }
        D(f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.acZ != null) {
            Rect rect = this.ep;
            if (this.ada != null) {
                this.ada.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect m = w.m(this.acZ);
            max = Math.max(0, m.left - rect.left);
            i5 = Math.max(0, m.right - rect.right);
        } else {
            max = 0;
        }
        if (as.bu(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.adm + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.adm);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.adn / 2);
                paddingLeft = this.adn + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.adn;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.adn + paddingTop;
                break;
        }
        this.adp = i5;
        this.adq = paddingTop;
        this.ads = paddingLeft;
        this.adr = max;
    }

    public void draw(Canvas canvas) {
        Rect m;
        int i;
        Rect rect = this.ep;
        int i2 = this.adp;
        int i3 = this.adq;
        int i4 = this.adr;
        int i5 = this.ads;
        int thumbOffset = i2 + getThumbOffset();
        if (this.acZ != null) {
            m = w.m(this.acZ);
        } else {
            m = w.VI;
        }
        if (this.ada != null) {
            this.ada.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (m != null) {
                if (m.left > rect.left) {
                    i2 += m.left - rect.left;
                }
                if (m.top > rect.top) {
                    thumbOffset = (m.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (m.right > rect.right) {
                    i4 -= m.right - rect.right;
                }
                i = m.bottom > rect.bottom ? i5 - (m.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.ada.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.acZ != null) {
            this.acZ.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.ado) + rect.right;
            this.acZ.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.b.a.a.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.ep;
        Drawable drawable = this.ada;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.adq + rect.top;
        int i2 = this.ads - rect.bottom;
        Drawable drawable2 = this.acZ;
        if (drawable != null) {
            if (!this.ade || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect m = w.m(drawable2);
                drawable2.copyBounds(rect);
                rect.left += m.left;
                rect.right -= m.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = gV() ? this.adu : this.adv;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.adt != null) {
                this.gl.setColor(this.adt.getColorForState(drawableState, 0));
            }
            this.gl.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!as.bu(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.adm;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.add;
    }

    public int getCompoundPaddingRight() {
        if (as.bu(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.adm;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.add;
    }

    private int getThumbOffset() {
        float f;
        if (as.bu(this)) {
            f = 1.0f - this.adl;
        } else {
            f = this.adl;
        }
        return (int) ((f * ((float) gW())) + 0.5f);
    }

    private int gW() {
        if (this.ada == null) {
            return 0;
        }
        Rect m;
        Rect rect = this.ep;
        this.ada.getPadding(rect);
        if (this.acZ != null) {
            m = w.m(this.acZ);
        } else {
            m = w.VI;
        }
        return ((((this.adm - this.ado) - rect.left) - rect.right) - m.left) - m.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, dM);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.acZ != null) {
            this.acZ.setState(drawableState);
        }
        if (this.ada != null) {
            this.ada.setState(drawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.acZ != null) {
            android.support.v4.b.a.a.a(this.acZ, f, f2);
        }
        if (this.ada != null) {
            android.support.v4.b.a.a.a(this.ada, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.acZ || drawable == this.ada;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.acZ != null) {
                this.acZ.jumpToCurrentState();
            }
            if (this.ada != null) {
                this.ada.jumpToCurrentState();
            }
            gU();
            D(isChecked() ? 1.0f : 0.0f);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.adf : this.adg;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }
}
