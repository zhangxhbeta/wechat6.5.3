package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.c;
import android.support.design.a.g;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.a.b;
import android.support.v4.view.am;
import android.support.v4.view.y;
import android.support.v4.widget.Space;
import android.support.v7.widget.w;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout {
    private u eI;
    private final f gG;
    private EditText kL;
    boolean kM;
    CharSequence kN;
    private Paint kO;
    private LinearLayout kP;
    private int kQ;
    private boolean kR;
    private TextView kS;
    private int kT;
    private boolean kU;
    private CharSequence kV;
    private boolean kW;
    private TextView kX;
    private int kY;
    private int kZ;
    private int la;
    private boolean lb;
    private ColorStateList lc;
    private ColorStateList ld;
    private boolean le;
    private boolean lf;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence li;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.li = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.li, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.li + "}";
        }
    }

    private class a extends android.support.v4.view.a {
        final /* synthetic */ TextInputLayout lg;

        private a(TextInputLayout textInputLayout) {
            this.lg = textInputLayout;
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence charSequence = this.lg.gG.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                accessibilityEvent.getText().add(charSequence);
            }
        }

        public final void a(View view, b bVar) {
            super.a(view, bVar);
            bVar.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence charSequence = this.lg.gG.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                bVar.setText(charSequence);
            }
            if (this.lg.kL != null) {
                b.yS.f(bVar.yT, this.lg.kL);
            }
            charSequence = this.lg.kS != null ? this.lg.kS.getText() : null;
            if (!TextUtils.isEmpty(charSequence)) {
                b.yS.j(bVar.yT, true);
                b.yS.a(bVar.yT, charSequence);
            }
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.gG = new f(this);
        t.g(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.gG.a(a.es);
        f fVar = this.gG;
        fVar.gm = new AccelerateInterpolator();
        fVar.Q();
        this.gG.n(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.dq, i, h.aU);
        this.kM = obtainStyledAttributes.getBoolean(i.dA, true);
        setHint(obtainStyledAttributes.getText(i.dr));
        this.le = obtainStyledAttributes.getBoolean(i.dz, true);
        if (obtainStyledAttributes.hasValue(i.ds)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i.ds);
            this.ld = colorStateList;
            this.lc = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(i.dB, -1) != -1) {
            this.gG.o(obtainStyledAttributes.getResourceId(i.dB, 0));
            this.ld = ColorStateList.valueOf(this.gG.fR);
            if (this.kL != null) {
                k(false);
                this.kL.setLayoutParams(b(this.kL.getLayoutParams()));
                this.kL.requestLayout();
            }
        }
        this.kT = obtainStyledAttributes.getResourceId(i.dy, 0);
        boolean z = obtainStyledAttributes.getBoolean(i.dx, false);
        boolean z2 = obtainStyledAttributes.getBoolean(i.dt, false);
        int i2 = obtainStyledAttributes.getInt(i.du, -1);
        if (this.kY != i2) {
            if (i2 > 0) {
                this.kY = i2;
            } else {
                this.kY = -1;
            }
            if (this.kW) {
                B(this.kL == null ? 0 : this.kL.getText().length());
            }
        }
        this.kZ = obtainStyledAttributes.getResourceId(i.dw, 0);
        this.la = obtainStyledAttributes.getResourceId(i.dv, 0);
        obtainStyledAttributes.recycle();
        l(z);
        if (this.kW != z2) {
            if (z2) {
                this.kX = new TextView(getContext());
                this.kX.setMaxLines(1);
                try {
                    this.kX.setTextAppearance(getContext(), this.kZ);
                } catch (Exception e) {
                    this.kX.setTextAppearance(getContext(), h.aI);
                    this.kX.setTextColor(android.support.v4.content.a.b(getContext(), c.af));
                }
                a(this.kX, -1);
                if (this.kL == null) {
                    B(0);
                } else {
                    B(this.kL.getText().length());
                }
            } else {
                a(this.kX);
                this.kX = null;
            }
            this.kW = z2;
        }
        if (y.F(this) == 0) {
            y.h(this, 1);
        }
        y.a((View) this, new a());
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (this.kL != null) {
                throw new IllegalArgumentException("We already have an EditText, can only have one");
            }
            this.kL = editText;
            f fVar = this.gG;
            Typeface typeface = this.kL.getTypeface();
            fVar.fZ = typeface;
            fVar.fY = typeface;
            fVar.Q();
            fVar = this.gG;
            float textSize = this.kL.getTextSize();
            if (fVar.fO != textSize) {
                fVar.fO = textSize;
                fVar.Q();
            }
            int gravity = this.kL.getGravity();
            this.gG.n((8388615 & gravity) | 48);
            this.gG.m(gravity);
            this.kL.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ TextInputLayout lg;

                {
                    this.lg = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    this.lg.k(true);
                    if (this.lg.kW) {
                        this.lg.B(editable.length());
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.lc == null) {
                this.lc = this.kL.getHintTextColors();
            }
            if (this.kM && TextUtils.isEmpty(this.kN)) {
                setHint(this.kL.getHint());
                this.kL.setHint(null);
            }
            if (this.kX != null) {
                B(this.kL.getText().length());
            }
            if (this.kP != null) {
                aw();
            }
            k(false);
            super.addView(view, 0, b(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private LinearLayout.LayoutParams b(LayoutParams layoutParams) {
        layoutParams = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.kM) {
            if (this.kO == null) {
                this.kO = new Paint();
            }
            Paint paint = this.kO;
            f fVar = this.gG;
            paint.setTypeface(fVar.fY != null ? fVar.fY : Typeface.DEFAULT);
            this.kO.setTextSize(this.gG.fP);
            layoutParams.topMargin = (int) (-this.kO.ascent());
        } else {
            layoutParams.topMargin = 0;
        }
        return layoutParams;
    }

    private void k(boolean z) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = (this.kL == null || TextUtils.isEmpty(this.kL.getText())) ? null : 1;
        for (int i : getDrawableState()) {
            if (i == 16842908) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (TextUtils.isEmpty(getError())) {
            obj2 = null;
        }
        if (this.lc != null) {
            f fVar = this.gG;
            int defaultColor = this.lc.getDefaultColor();
            if (fVar.fQ != defaultColor) {
                fVar.fQ = defaultColor;
                fVar.Q();
            }
        }
        if (this.lb && this.kX != null) {
            this.gG.l(this.kX.getCurrentTextColor());
        } else if (obj != null && this.ld != null) {
            this.gG.l(this.ld.getDefaultColor());
        } else if (this.lc != null) {
            this.gG.l(this.lc.getDefaultColor());
        }
        if (obj3 == null && obj == null && r1 == null) {
            if (this.eI != null && this.eI.lk.isRunning()) {
                this.eI.lk.cancel();
            }
            if (z && this.le) {
                m(0.0f);
                return;
            } else {
                this.gG.e(0.0f);
                return;
            }
        }
        if (this.eI != null && this.eI.lk.isRunning()) {
            this.eI.lk.cancel();
        }
        if (z && this.le) {
            m(1.0f);
        } else {
            this.gG.e(1.0f);
        }
    }

    private void setHint(CharSequence charSequence) {
        if (this.kM) {
            this.kN = charSequence;
            this.gG.setText(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void a(TextView textView, int i) {
        if (this.kP == null) {
            this.kP = new LinearLayout(getContext());
            this.kP.setOrientation(0);
            addView(this.kP, -1, -2);
            this.kP.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.kL != null) {
                aw();
            }
        }
        this.kP.setVisibility(0);
        this.kP.addView(textView, i);
        this.kQ++;
    }

    private void aw() {
        y.c(this.kP, y.O(this.kL), 0, y.P(this.kL), this.kL.getPaddingBottom());
    }

    private void a(TextView textView) {
        if (this.kP != null) {
            this.kP.removeView(textView);
            int i = this.kQ - 1;
            this.kQ = i;
            if (i == 0) {
                this.kP.setVisibility(8);
            }
        }
    }

    private void l(boolean z) {
        if (this.kR != z) {
            if (this.kS != null) {
                y.U(this.kS).cancel();
            }
            if (z) {
                this.kS = new TextView(getContext());
                try {
                    this.kS.setTextAppearance(getContext(), this.kT);
                } catch (Exception e) {
                    this.kS.setTextAppearance(getContext(), h.aI);
                    this.kS.setTextColor(android.support.v4.content.a.b(getContext(), c.af));
                }
                this.kS.setVisibility(4);
                y.N(this.kS);
                a(this.kS, 0);
            } else {
                this.kU = false;
                ax();
                a(this.kS);
                this.kS = null;
            }
            this.kR = z;
        }
    }

    private void B(int i) {
        boolean z = this.lb;
        if (this.kY == -1) {
            this.kX.setText(String.valueOf(i));
            this.lb = false;
        } else {
            this.lb = i > this.kY;
            if (z != this.lb) {
                this.kX.setTextAppearance(getContext(), this.lb ? this.la : this.kZ);
            }
            this.kX.setText(getContext().getString(g.aH, new Object[]{Integer.valueOf(i), Integer.valueOf(this.kY)}));
        }
        if (this.kL != null && z != this.lb) {
            k(false);
            ax();
        }
    }

    private void ax() {
        Drawable background;
        int i = VERSION.SDK_INT;
        if (i == 21 && i == 22) {
            background = this.kL.getBackground();
            if (!(background == null || this.lf)) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    DrawableContainer drawableContainer = (DrawableContainer) background;
                    ConstantState constantState = newDrawable.getConstantState();
                    this.lf = VERSION.SDK_INT >= 9 ? i.a(drawableContainer, constantState) : i.b(drawableContainer, constantState);
                }
                if (!this.lf) {
                    this.kL.setBackgroundDrawable(newDrawable);
                    this.lf = true;
                }
            }
        }
        background = this.kL.getBackground();
        if (background != null) {
            if (w.o(background)) {
                background = background.mutate();
            }
            if (this.kU && this.kS != null) {
                background.setColorFilter(android.support.v7.widget.h.a(this.kS.getCurrentTextColor(), Mode.SRC_IN));
            } else if (!this.lb || this.kX == null) {
                background.clearColorFilter();
                this.kL.refreshDrawableState();
            } else {
                background.setColorFilter(android.support.v7.widget.h.a(this.kX.getCurrentTextColor(), Mode.SRC_IN));
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.kU) {
            savedState.li = getError();
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            final CharSequence charSequence = savedState.li;
            if (!TextUtils.equals(this.kV, charSequence)) {
                boolean z;
                this.kV = charSequence;
                if (!this.kR) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        l(true);
                    }
                }
                boolean ai = y.ai(this);
                if (TextUtils.isEmpty(charSequence)) {
                    z = false;
                } else {
                    z = true;
                }
                this.kU = z;
                if (this.kU) {
                    this.kS.setText(charSequence);
                    this.kS.setVisibility(0);
                    if (ai) {
                        if (y.G(this.kS) == 1.0f) {
                            y.d(this.kS, 0.0f);
                        }
                        y.U(this.kS).p(1.0f).c(200).b(a.eu).a(new am(this) {
                            final /* synthetic */ TextInputLayout lg;

                            {
                                this.lg = r1;
                            }

                            public final void p(View view) {
                                view.setVisibility(0);
                            }
                        }).start();
                    }
                } else if (this.kS.getVisibility() == 0) {
                    if (ai) {
                        y.U(this.kS).p(0.0f).c(200).b(a.et).a(new am(this) {
                            final /* synthetic */ TextInputLayout lg;

                            public final void q(View view) {
                                this.lg.kS.setText(charSequence);
                                view.setVisibility(4);
                            }
                        }).start();
                    } else {
                        this.kS.setVisibility(4);
                    }
                }
                ax();
                k(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private CharSequence getError() {
        return this.kR ? this.kV : null;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.kM) {
            this.gG.draw(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.kM && this.kL != null) {
            int left = this.kL.getLeft() + this.kL.getCompoundPaddingLeft();
            int right = this.kL.getRight() - this.kL.getCompoundPaddingRight();
            this.gG.a(left, this.kL.getTop() + this.kL.getCompoundPaddingTop(), right, this.kL.getBottom() - this.kL.getCompoundPaddingBottom());
            this.gG.b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.gG.Q();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        k(y.ai(this));
    }

    private void m(float f) {
        if (this.gG.fI != f) {
            if (this.eI == null) {
                this.eI = aa.az();
                this.eI.setInterpolator(a.er);
                this.eI.setDuration(200);
                this.eI.a(new c(this) {
                    final /* synthetic */ TextInputLayout lg;

                    {
                        this.lg = r1;
                    }

                    public final void a(u uVar) {
                        this.lg.gG.e(uVar.lk.aB());
                    }
                });
            }
            this.eI.e(this.gG.fI, f);
            this.eI.lk.start();
        }
    }
}
