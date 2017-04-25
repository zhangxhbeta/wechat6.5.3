package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v4.view.al;
import android.support.v4.view.n;
import android.support.v4.view.y;
import android.support.v7.a.a.g;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
    protected final a QC = new a(this);
    protected final Context QD;
    protected ActionMenuView QE;
    protected ActionMenuPresenter QF;
    protected int QG;
    protected ah QH;
    private boolean QI;
    private boolean QJ;

    protected class a implements al {
        private boolean QK = false;
        int QL;
        final /* synthetic */ a QM;

        protected a(a aVar) {
            this.QM = aVar;
        }

        public final a a(ah ahVar, int i) {
            this.QM.QH = ahVar;
            this.QL = i;
            return this;
        }

        public final void p(View view) {
            super.setVisibility(0);
            this.QK = false;
        }

        public final void q(View view) {
            if (!this.QK) {
                this.QM.QH = null;
                super.setVisibility(this.QL);
            }
        }

        public final void ar(View view) {
            this.QK = true;
        }
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.QD = context;
        } else {
            this.QD = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        aw(obtainStyledAttributes.getLayoutDimension(k.Kp, 0));
        obtainStyledAttributes.recycle();
        if (this.QF != null) {
            ActionMenuPresenter actionMenuPresenter = this.QF;
            if (!actionMenuPresenter.RN) {
                actionMenuPresenter.RM = actionMenuPresenter.mContext.getResources().getInteger(g.JH);
            }
            if (actionMenuPresenter.dV != null) {
                actionMenuPresenter.dV.h(true);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = n.d(motionEvent);
        if (d == 0) {
            this.QI = false;
        }
        if (!this.QI) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.QI = true;
            }
        }
        if (d == 1 || d == 3) {
            this.QI = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = n.d(motionEvent);
        if (d == 9) {
            this.QJ = false;
        }
        if (!this.QJ) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.QJ = true;
            }
        }
        if (d == 10 || d == 3) {
            this.QJ = false;
        }
        return true;
    }

    public void aw(int i) {
        this.QG = i;
        requestLayout();
    }

    public ah b(int i, long j) {
        if (this.QH != null) {
            this.QH.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                y.d(this, 0.0f);
            }
            ah p = y.U(this).p(1.0f);
            p.c(j);
            p.a(this.QC.a(p, i));
            return p;
        }
        p = y.U(this).p(0.0f);
        p.c(j);
        p.a(this.QC.a(p, i));
        return p;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.QH != null) {
                this.QH.cancel();
            }
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        if (this.QF != null) {
            return this.QF.showOverflowMenu();
        }
        return false;
    }

    protected static int g(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    protected static int c(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
