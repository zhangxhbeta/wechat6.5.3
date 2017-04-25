package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;

public final class b {
    int Rg = 0;
    int dQw = 0;
    c jaU;
    NotInterestMenu jaZ;
    ViewGroup jba;
    com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b jbb = new com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b(this) {
        final /* synthetic */ b jbp;

        {
            this.jbp = r1;
        }

        public final void aQO() {
            this.jbp.aQP();
        }
    };
    Animation jbc = null;
    Animation jbd = null;
    private Animation jbe = null;
    private Animation jbf = null;
    int jbg = 0;
    int jbh = 0;
    int jbi = 0;
    int jbj = 0;
    int jbk = 0;
    boolean jbl = false;
    AbsoluteLayout jbm = null;
    boolean jbn = false;
    boolean jbo = false;
    int mScreenHeight = 0;

    public b(ViewGroup viewGroup) {
        this.jba = viewGroup;
        this.jbc = AnimationUtils.loadAnimation(aa.getContext(), 2130968611);
        this.jbc.setFillAfter(true);
        this.jbc.setDuration(100);
        this.jbc.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b jbp;

            {
                this.jbp = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jbp.jbn = true;
            }

            public final void onAnimationEnd(Animation animation) {
                if (this.jbp.jaZ != null) {
                    this.jbp.jaZ.setVisibility(0);
                }
                this.jbp.jbn = false;
                this.jbp.jbl = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.jbd = AnimationUtils.loadAnimation(aa.getContext(), 2130968614);
        this.jbd.setFillAfter(true);
        this.jbd.setDuration(100);
        this.jbd.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b jbp;

            {
                this.jbp = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jbp.jbn = true;
            }

            public final void onAnimationEnd(Animation animation) {
                if (this.jbp.jaZ != null) {
                    this.jbp.jaZ.setVisibility(0);
                }
                this.jbp.jbn = false;
                this.jbp.jbl = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.jbe = AnimationUtils.loadAnimation(aa.getContext(), 2130968612);
        this.jbe.setFillAfter(true);
        this.jbe.setDuration(100);
        this.jbe.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b jbp;

            {
                this.jbp = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jbp.jbn = true;
            }

            public final void onAnimationEnd(Animation animation) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jbq;

                    {
                        this.jbq = r1;
                    }

                    public final void run() {
                        this.jbq.jbp.aQP();
                    }
                });
                this.jbp.jbn = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.jbf = AnimationUtils.loadAnimation(aa.getContext(), 2130968613);
        this.jbf.setFillAfter(true);
        this.jbf.setDuration(100);
        this.jbf.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b jbp;

            {
                this.jbp = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jbp.jbn = true;
            }

            public final void onAnimationEnd(Animation animation) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 jbr;

                    {
                        this.jbr = r1;
                    }

                    public final void run() {
                        this.jbr.jbp.aQP();
                    }
                });
                this.jbp.jbn = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public final void aQP() {
        if (this.jbm != null && this.jba != null && this.jaZ != null) {
            this.jbm.removeView(this.jaZ);
            this.jba.removeView(this.jbm);
            this.jbm = null;
            this.jaZ = null;
            this.jbl = false;
        }
    }
}
