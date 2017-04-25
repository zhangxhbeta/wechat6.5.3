package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;

public class MMSightRecordButton extends FrameLayout {
    private static final int hvR = ViewConfiguration.getTapTimeout();
    private static final float hvS = (((float) aa.getContext().getResources().getDimensionPixelSize(2131493535)) / ((float) aa.getContext().getResources().getDimensionPixelSize(2131493534)));
    private boolean aZw = true;
    private ac cnC = new ac(Looper.getMainLooper());
    private float euH = -1.0f;
    private long hvT = -1;
    private View hvU;
    private View hvV;
    View hvW;
    MMSightCircularProgressBar hvX;
    private boolean hvY = false;
    private boolean hvZ = false;
    private boolean hwa = false;
    private ViewPropertyAnimator hwb;
    private ViewPropertyAnimator hwc;
    private ViewPropertyAnimator hwd;
    private ViewPropertyAnimator hwe;
    private boolean hwf = false;
    d hwg;
    b hwh;
    c hwi;
    a hwj;
    private Drawable hwk;
    private Drawable hwl;
    private boolean hwm = false;
    private boolean hwn = false;
    private Runnable hwo = new Runnable(this) {
        final /* synthetic */ MMSightRecordButton hwr;

        {
            this.hwr = r1;
        }

        public final void run() {
            v.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(this.hwr.hvY), Boolean.valueOf(this.hwr.hvZ)});
            if (!this.hwr.hvY) {
                this.hwr.hvZ = true;
                if (this.hwr.hwh != null) {
                    this.hwr.hwh.aBz();
                }
            }
        }
    };
    private Runnable hwp = new Runnable(this) {
        final /* synthetic */ MMSightRecordButton hwr;

        {
            this.hwr = r1;
        }

        public final void run() {
            v.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[]{Boolean.valueOf(this.hwr.hwf)});
            if (this.hwr.hwf) {
                MMSightRecordButton.f(this.hwr);
            }
        }
    };

    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ MMSightRecordButton hwr;
        final /* synthetic */ AnimatorListenerAdapter hwt = null;

        AnonymousClass2(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
            this.hwr = mMSightRecordButton;
        }

        public final void onAnimationStart(Animator animator) {
            this.hwr.hwa = true;
            if (this.hwt != null) {
                this.hwt.onAnimationStart(animator);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.hwr.hwa = false;
            if (this.hwt != null) {
                this.hwt.onAnimationEnd(animator);
            }
        }
    }

    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ MMSightRecordButton hwr;
        final /* synthetic */ AnimatorListenerAdapter hwt = null;

        AnonymousClass3(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
            this.hwr = mMSightRecordButton;
        }

        public final void onAnimationStart(Animator animator) {
            this.hwr.hwa = true;
            if (this.hwt != null) {
                this.hwt.onAnimationStart(animator);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.hwr.hwa = false;
            if (this.hwt != null) {
                this.hwt.onAnimationEnd(animator);
            }
        }
    }

    public interface a {
        void aBx();
    }

    public interface b {
        void aBA();

        void aBy();

        void aBz();
    }

    public interface c {
        void nf(int i);

        void ng(int i);
    }

    public interface d {
        void aBB();
    }

    class AnonymousClass1 implements com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a {
        final /* synthetic */ com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a hwq;
        final /* synthetic */ MMSightRecordButton hwr;

        AnonymousClass1(MMSightRecordButton mMSightRecordButton, com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a aVar) {
            this.hwr = mMSightRecordButton;
            this.hwq = aVar;
        }

        public final void aBv() {
            v.j("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
            this.hwr.aBw();
            this.hwr.a(new AnimatorListenerAdapter(this) {
                final /* synthetic */ AnonymousClass1 hws;

                {
                    this.hws = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    v.j("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
                    if (this.hws.hwq != null) {
                        this.hws.hwq.aBv();
                    }
                }
            });
        }
    }

    static /* synthetic */ void f(MMSightRecordButton mMSightRecordButton) {
        mMSightRecordButton.hwa = true;
        if (mMSightRecordButton.hwb != null) {
            mMSightRecordButton.hwb.cancel();
            mMSightRecordButton.hwb = null;
        }
        mMSightRecordButton.hwb = mMSightRecordButton.hvU.animate().scaleX(0.67f).scaleY(0.67f);
        mMSightRecordButton.hwb.setListener(new AnonymousClass2(mMSightRecordButton, null)).setDuration(150).start();
        if (mMSightRecordButton.hwc != null) {
            mMSightRecordButton.hwc.cancel();
            mMSightRecordButton.hwc = null;
        }
        mMSightRecordButton.hwc = mMSightRecordButton.hvV.animate().scaleX(hvS).scaleY(hvS);
        mMSightRecordButton.hwc.setListener(new AnonymousClass3(mMSightRecordButton, null)).setDuration(150).start();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        v.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[]{Integer.valueOf(500), Integer.valueOf(hvR)});
        this.hwk = getContext().getResources().getDrawable(2130838701);
        this.hwl = getContext().getResources().getDrawable(2130838702);
        q.em(getContext()).inflate(2130904084, this, true);
        this.hvU = findViewById(2131758304);
        this.hvV = findViewById(2131758303);
        this.hvW = findViewById(2131755518);
        this.hvX = (MMSightCircularProgressBar) findViewById(2131758305);
        this.hvU.setBackgroundDrawable(this.hwk);
        this.hvV.setBackgroundDrawable(this.hwl);
        this.aZw = true;
    }

    public final void eu(boolean z) {
        v.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[]{Boolean.valueOf(z)});
        this.aZw = z;
    }

    public final void aBw() {
        MMSightCircularProgressBar mMSightCircularProgressBar = this.hvX;
        mMSightCircularProgressBar.hvN = null;
        mMSightCircularProgressBar.hvJ = 0;
        mMSightCircularProgressBar.hvK = 0;
        mMSightCircularProgressBar.duration = 0;
        mMSightCircularProgressBar.bhY = false;
        if (mMSightCircularProgressBar.pPH != null) {
            a aVar = mMSightCircularProgressBar.pPH;
            aVar.bhY = false;
            aVar.pPM = 0;
            mMSightCircularProgressBar.pPH = null;
        }
        this.hvX.setVisibility(8);
    }

    private void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        this.hwa = true;
        if (this.hwd != null) {
            this.hwd.cancel();
            this.hwd = null;
        }
        this.hwd = this.hvU.animate().scaleX(1.0f).scaleY(1.0f);
        this.hwd.setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ MMSightRecordButton hwr;

            public final void onAnimationStart(Animator animator) {
                this.hwr.hwa = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                this.hwr.hwa = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
        if (this.hwe != null) {
            this.hwe.cancel();
            this.hwe = null;
        }
        this.hwe = this.hvV.animate().scaleX(1.0f).scaleY(1.0f);
        this.hwe.setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ MMSightRecordButton hwr;

            public final void onAnimationStart(Animator animator) {
                this.hwr.hwa = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                this.hwr.hwa = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
    }

    public void setVisibility(final int i) {
        v.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[]{Boolean.valueOf(this.hwa)});
        if (this.hwa) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ MMSightRecordButton hwr;

                public final void run() {
                    super.setVisibility(i);
                }
            }, 150);
        } else {
            super.setVisibility(i);
        }
    }

    public final void reset() {
        setClipChildren(false);
        this.aZw = true;
        this.hvU.setScaleX(1.0f);
        this.hvU.setScaleY(1.0f);
        this.hvV.setScaleX(1.0f);
        this.hvV.setScaleY(1.0f);
        this.hvW.setVisibility(8);
        aBw();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aZw) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hwf = true;
                    this.hvT = System.currentTimeMillis();
                    this.hvY = false;
                    this.hvZ = false;
                    this.euH = motionEvent.getRawY();
                    if (this.hwh != null) {
                        this.hwh.aBy();
                    }
                    this.cnC.postDelayed(this.hwo, 550);
                    this.cnC.postDelayed(this.hwp, 250);
                    this.hwn = true;
                    this.hwm = true;
                    break;
                case 1:
                case 3:
                    this.hwf = false;
                    this.cnC.removeCallbacks(this.hwp, Integer.valueOf(hvR));
                    this.cnC.removeCallbacks(this.hwo);
                    if (!(this.hwb == null || this.hwc == null)) {
                        this.hwb.cancel();
                        this.hwc.cancel();
                    }
                    final long currentTimeMillis = System.currentTimeMillis() - this.hvT;
                    v.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[]{Boolean.valueOf(this.hvZ), Boolean.valueOf(this.hvY), Long.valueOf(this.hvT), Long.valueOf(currentTimeMillis)});
                    aBw();
                    a(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ MMSightRecordButton hwr;

                        public final void onAnimationEnd(Animator animator) {
                            if (this.hwr.hvT > 0 && currentTimeMillis <= 500) {
                                v.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(this.hwr.hvY), Boolean.valueOf(this.hwr.hvZ)});
                                this.hwr.hvY = true;
                                if (!this.hwr.hvZ && this.hwr.hwg != null) {
                                    this.hwr.hwg.aBB();
                                }
                            } else if (this.hwr.hvZ) {
                                v.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
                                if (this.hwr.hwh != null) {
                                    this.hwr.hwh.aBA();
                                }
                            } else {
                                v.i("MicroMsg.MMSightRecordButton", "error action up");
                                if (this.hwr.hwj != null) {
                                    this.hwr.hwj.aBx();
                                }
                            }
                        }
                    });
                    break;
                case 2:
                    v.d("MicroMsg.MMSightRecordButton", "move, x: %s, y: %s, top: %s", new Object[]{Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()), Integer.valueOf(getTop())});
                    float rawY = motionEvent.getRawY();
                    if (rawY < ((float) getTop()) && this.hvZ) {
                        if (this.euH > 0.0f) {
                            float abs = Math.abs(rawY - this.euH);
                            int min;
                            c cVar;
                            if (rawY >= this.euH || abs < 10.0f) {
                                if (rawY > this.euH && abs >= 10.0f) {
                                    v.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.hwn)});
                                    min = Math.min(min, 3);
                                    if (this.hwi != null) {
                                        cVar = this.hwi;
                                        if (this.hwn) {
                                            min = 1;
                                        }
                                        cVar.ng(min);
                                    }
                                    this.hwn = false;
                                    this.euH = rawY;
                                    break;
                                }
                            }
                            v.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.hwm)});
                            min = Math.min(min, 3);
                            if (this.hwi != null) {
                                cVar = this.hwi;
                                if (this.hwm) {
                                    min = 1;
                                }
                                cVar.nf(min);
                            }
                            this.euH = rawY;
                            this.hwm = false;
                            break;
                        }
                        this.euH = motionEvent.getRawY();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        v.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
        return true;
    }
}
