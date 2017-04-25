package com.tencent.mm.ui.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.ui.snackbar.b.c;
import java.util.LinkedList;
import java.util.Queue;

class SnackContainer extends FrameLayout {
    private final Runnable fEo = new Runnable(this) {
        final /* synthetic */ SnackContainer oQj;

        {
            this.oQj = r1;
        }

        public final void run() {
            if (this.oQj.getVisibility() == 0) {
                this.oQj.startAnimation(this.oQj.oQh);
            }
        }
    };
    Queue<a> oQg = new LinkedList();
    private AnimationSet oQh;
    private float oQi;
    private AnimationSet ouJ;

    private static class a {
        final TextView gXa;
        final View oQl;
        final TextView oQm;
        final Snack oQn;
        final c oQo;

        private a(Snack snack, View view, c cVar) {
            this.oQl = view;
            this.gXa = (TextView) view.findViewById(2131759228);
            this.oQm = (TextView) view.findViewById(2131759227);
            this.oQn = snack;
            this.oQo = cVar;
        }
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        viewGroup.addView(this, new LayoutParams(-1, -1));
        setVisibility(8);
        setId(2131759225);
        init();
    }

    private void init() {
        this.ouJ = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.ouJ.setInterpolator(new DecelerateInterpolator(1.5f));
        this.ouJ.addAnimation(translateAnimation);
        this.ouJ.addAnimation(alphaAnimation);
        this.oQh = new AnimationSet(false);
        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.oQh.addAnimation(translateAnimation);
        this.oQh.addAnimation(alphaAnimation);
        this.oQh.setDuration(300);
        this.oQh.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ SnackContainer oQj;

            {
                this.oQj = r1;
            }

            public final void onAnimationStart(Animation animation) {
                if (!this.oQj.isEmpty() && ((a) this.oQj.oQg.peek()).oQo != null) {
                    a.kc(false);
                    ((a) this.oQj.oQg.peek()).oQo.blD();
                }
            }

            public final void onAnimationEnd(Animation animation) {
                this.oQj.removeAllViews();
                if (!this.oQj.oQg.isEmpty()) {
                    SnackContainer.a((a) this.oQj.oQg.poll());
                }
                if (this.oQj.isEmpty()) {
                    this.oQj.setVisibility(8);
                } else {
                    this.oQj.a((a) this.oQj.oQg.peek(), false);
                }
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ouJ.cancel();
        this.oQh.cancel();
        removeCallbacks(this.fEo);
        this.oQg.clear();
    }

    public final boolean isEmpty() {
        return this.oQg.isEmpty();
    }

    public final boolean isShowing() {
        return !this.oQg.isEmpty();
    }

    public final void hide() {
        removeCallbacks(this.fEo);
        this.fEo.run();
    }

    final void a(final a aVar, boolean z) {
        setVisibility(0);
        if (aVar.oQo != null) {
            a.kc(true);
            aVar.oQo.aEU();
        }
        addView(aVar.oQl);
        aVar.oQm.setText(aVar.oQn.mMessage);
        if (aVar.oQn.oPS != null) {
            aVar.gXa.setVisibility(0);
            aVar.gXa.setText(aVar.oQn.oPS);
        } else {
            aVar.gXa.setVisibility(8);
        }
        this.ouJ.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968622);
        loadAnimation.setDuration(500);
        startAnimation(this.ouJ);
        loadAnimation.setStartOffset(200);
        aVar.gXa.startAnimation(loadAnimation);
        aVar.oQm.startAnimation(loadAnimation);
        if (aVar.oQn.oPV > (short) 0) {
            postDelayed(this.fEo, (long) aVar.oQn.oPV);
        }
        aVar.oQl.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnackContainer oQj;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float y = motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case 4:
                        this.oQj.removeCallbacks(this.oQj.fEo);
                        SnackContainer.a(aVar);
                        this.oQj.startAnimation(this.oQj.oQh);
                        if (!this.oQj.oQg.isEmpty()) {
                            this.oQj.oQg.clear();
                            break;
                        }
                        break;
                }
                this.oQj.oQi = y;
                return true;
            }
        });
    }

    private static void a(a aVar) {
        if (aVar.oQo != null) {
            a.kc(false);
            aVar.oQo.onHide();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if ((i == 0 && a.aQa()) || 8 == i) {
            removeAllViews();
            if (!this.oQg.isEmpty()) {
                a((a) this.oQg.poll());
            }
            if (isEmpty()) {
                setVisibility(8);
            } else {
                a((a) this.oQg.peek(), false);
            }
            a.kc(false);
        }
    }
}
