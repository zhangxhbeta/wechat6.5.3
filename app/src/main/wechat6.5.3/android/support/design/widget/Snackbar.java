package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.am;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler jh = new Handler(Looper.getMainLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            Snackbar snackbar;
            switch (message.what) {
                case 0:
                    snackbar = (Snackbar) message.obj;
                    if (snackbar.jj.getParent() == null) {
                        LayoutParams layoutParams = snackbar.jj.getLayoutParams();
                        if (layoutParams instanceof d) {
                            Behavior aVar = new a(snackbar);
                            aVar.jK = s.c(0.0f, 0.1f, 1.0f);
                            aVar.jL = s.c(0.0f, 0.6f, 1.0f);
                            aVar.jI = 0;
                            aVar.jF = new android.support.design.widget.s.a(snackbar) {
                                final /* synthetic */ Snackbar jn;

                                {
                                    this.jn = r1;
                                }

                                public final void onDismiss(View view) {
                                    view.setVisibility(8);
                                    Snackbar.a(this.jn);
                                }

                                public final void w(int i) {
                                    switch (i) {
                                        case 0:
                                            q.aq().b(this.jn.jl);
                                            return;
                                        case 1:
                                        case 2:
                                            q.aq().a(this.jn.jl);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                            ((d) layoutParams).a(aVar);
                        }
                        snackbar.ji.addView(snackbar.jj);
                    }
                    snackbar.jj.jt = new a(snackbar) {
                        final /* synthetic */ Snackbar jn;

                        {
                            this.jn = r1;
                        }

                        public final void ao() {
                            if (q.aq().c(this.jn.jl)) {
                                Snackbar.jh.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 jo;

                                    {
                                        this.jo = r1;
                                    }

                                    public final void run() {
                                        this.jo.jn.al();
                                    }
                                });
                            }
                        }
                    };
                    if (!y.ai(snackbar.jj)) {
                        snackbar.jj.js = new b(snackbar) {
                            final /* synthetic */ Snackbar jn;

                            {
                                this.jn = r1;
                            }

                            public final void ap() {
                                this.jn.jj.js = null;
                                if (this.jn.am()) {
                                    this.jn.aj();
                                } else {
                                    this.jn.ak();
                                }
                            }
                        };
                    } else if (snackbar.am()) {
                        snackbar.aj();
                    } else {
                        snackbar.ak();
                    }
                    return true;
                case 1:
                    snackbar = (Snackbar) message.obj;
                    int i = message.arg1;
                    if (!snackbar.am() || snackbar.jj.getVisibility() != 0) {
                        snackbar.al();
                    } else if (VERSION.SDK_INT >= 14) {
                        y.U(snackbar.jj).r((float) snackbar.jj.getHeight()).b(a.es).c(250).a(new AnonymousClass8(snackbar, i)).start();
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snackbar.jj.getContext(), android.support.design.a.a.W);
                        loadAnimation.setInterpolator(a.es);
                        loadAnimation.setDuration(250);
                        loadAnimation.setAnimationListener(new AnonymousClass2(snackbar, i));
                        snackbar.jj.startAnimation(loadAnimation);
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final ViewGroup ji;
    final SnackbarLayout jj;
    private final AccessibilityManager jk;
    final a jl;

    class AnonymousClass2 implements AnimationListener {
        final /* synthetic */ int jm;
        final /* synthetic */ Snackbar jn;

        AnonymousClass2(Snackbar snackbar, int i) {
            this.jn = snackbar;
            this.jm = i;
        }

        public final void onAnimationEnd(Animation animation) {
            this.jn.al();
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public static class SnackbarLayout extends LinearLayout {
        private int iN;
        TextView jp;
        Button jq;
        private int jr;
        b js;
        a jt;

        interface a {
            void ao();
        }

        interface b {
            void ap();
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cH);
            this.iN = obtainStyledAttributes.getDimensionPixelSize(i.cI, -1);
            this.jr = obtainStyledAttributes.getDimensionPixelSize(i.cK, -1);
            if (obtainStyledAttributes.hasValue(i.cJ)) {
                y.g((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(i.cJ, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(f.ay, this);
            y.N(this);
            y.h(this, 1);
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.jp = (TextView) findViewById(e.au);
            this.jq = (Button) findViewById(e.at);
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.iN > 0 && getMeasuredWidth() > this.iN) {
                i = MeasureSpec.makeMeasureSpec(this.iN, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(android.support.design.a.d.an);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(android.support.design.a.d.am);
            int i3 = this.jp.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.jr <= 0 || this.jq.getMeasuredWidth() <= this.jr) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (b(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.js != null) {
                this.js.ap();
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.jt != null) {
                this.jt.ao();
            }
        }

        private boolean b(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.jp.getPaddingTop() == i2 && this.jp.getPaddingBottom() == i3) {
                return z;
            }
            View view = this.jp;
            if (y.ad(view)) {
                y.c(view, y.O(view), i2, y.P(view), i3);
            } else {
                view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
            }
            return true;
        }
    }

    class AnonymousClass8 extends am {
        final /* synthetic */ int jm;
        final /* synthetic */ Snackbar jn;

        AnonymousClass8(Snackbar snackbar, int i) {
            this.jn = snackbar;
            this.jm = i;
        }

        public final void p(View view) {
            SnackbarLayout c = this.jn.jj;
            y.d(c.jp, 1.0f);
            y.U(c.jp).p(0.0f).c(180).d(0).start();
            if (c.jq.getVisibility() == 0) {
                y.d(c.jq, 1.0f);
                y.U(c.jq).p(0.0f).c(180).d(0).start();
            }
        }

        public final void q(View view) {
            this.jn.al();
        }
    }

    final class a extends s<SnackbarLayout> {
        final /* synthetic */ Snackbar jn;

        a(Snackbar snackbar) {
            this.jn = snackbar;
        }

        public final boolean r(View view) {
            return view instanceof SnackbarLayout;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.b(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        q.aq().a(this.jn.jl);
                        break;
                    case 1:
                    case 3:
                        q.aq().b(this.jn.jl);
                        break;
                }
            }
            return super.a(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }

    static /* synthetic */ void a(Snackbar snackbar) {
        q aq = q.aq();
        a aVar = snackbar.jl;
        synchronized (aq.mLock) {
            if (aq.d(aVar)) {
                aq.a(aq.jv);
            } else if (aq.e(aVar)) {
                aq.a(aq.jw);
            }
        }
    }

    final void aj() {
        if (VERSION.SDK_INT >= 14) {
            y.c(this.jj, (float) this.jj.getHeight());
            y.U(this.jj).r(0.0f).b(a.es).c(250).a(new am(this) {
                final /* synthetic */ Snackbar jn;

                {
                    this.jn = r1;
                }

                public final void p(View view) {
                    SnackbarLayout c = this.jn.jj;
                    y.d(c.jp, 0.0f);
                    y.U(c.jp).p(1.0f).c(180).d(70).start();
                    if (c.jq.getVisibility() == 0) {
                        y.d(c.jq, 0.0f);
                        y.U(c.jq).p(1.0f).c(180).d(70).start();
                    }
                }

                public final void q(View view) {
                    this.jn.ak();
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.jj.getContext(), android.support.design.a.a.V);
        loadAnimation.setInterpolator(a.es);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ Snackbar jn;

            {
                this.jn = r1;
            }

            public final void onAnimationEnd(Animation animation) {
                this.jn.ak();
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.jj.startAnimation(loadAnimation);
    }

    final void ak() {
        q aq = q.aq();
        a aVar = this.jl;
        synchronized (aq.mLock) {
            if (aq.d(aVar)) {
                aq.b(aq.jv);
            }
        }
    }

    final void al() {
        q aq = q.aq();
        a aVar = this.jl;
        synchronized (aq.mLock) {
            if (aq.d(aVar)) {
                aq.jv = null;
                if (!(aq.jw == null || aq.jw == null)) {
                    aq.jv = aq.jw;
                    aq.jw = null;
                    if (((a) aq.jv.jy.get()) == null) {
                        aq.jv = null;
                    }
                }
            }
        }
        ViewParent parent = this.jj.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jj);
        }
    }

    final boolean am() {
        return !this.jk.isEnabled();
    }
}
