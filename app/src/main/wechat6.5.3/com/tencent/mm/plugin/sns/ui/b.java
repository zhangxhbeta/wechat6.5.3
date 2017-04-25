package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;

public final class b {
    private com.tencent.mm.plugin.sns.f.b jDd;
    Button jDe;
    private int jcr = -1;
    private com.tencent.mm.plugin.sns.ui.b.b joV;
    private FrameLayout joW;
    AbsoluteLayout joX = null;
    protected Animation joY;
    protected Animation joZ;
    boolean jpa = false;
    private Context mContext;

    class a {
        final /* synthetic */ b jDf;
        View jby = null;
        String jpq;

        public a(b bVar, String str, View view) {
            this.jDf = bVar;
            this.jpq = str;
            this.jby = view;
        }
    }

    static /* synthetic */ void a(b bVar, View view, View view2) {
        com.tencent.mm.plugin.sns.data.b bVar2 = (com.tencent.mm.plugin.sns.data.b) view.getTag();
        view2.setVisibility(0);
        bVar.jpa = true;
        bVar.joY.setAnimationListener(new AnimationListener(bVar) {
            final /* synthetic */ b jDf;

            {
                this.jDf = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jDf.jpa = true;
            }

            public final void onAnimationEnd(Animation animation) {
                this.jDf.jpa = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(bVar.joY);
        bVar.jDe = (Button) view2.findViewById(2131755297);
        bVar.jDe.setOnClickListener(bVar.joV.kbG);
        bVar.jDe.setOnTouchListener(be.buq());
        bVar.jDe.setTag(bVar2);
    }

    public b(Context context, com.tencent.mm.plugin.sns.ui.b.b bVar, FrameLayout frameLayout, com.tencent.mm.plugin.sns.f.b bVar2) {
        this.mContext = context;
        this.jDd = bVar2;
        this.joV = bVar;
        this.joW = frameLayout;
        this.joY = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.joY = AnimationUtils.loadAnimation(context, 2130968611);
        this.joZ = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.joZ = AnimationUtils.loadAnimation(context, 2130968612);
    }

    public final boolean ce(final View view) {
        if (ad.aSw().aTo() && this.jDd != null) {
            int cd = this.jDd.cd(view);
            if (cd == 0 || cd == 1) {
                return true;
            }
            v.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.jpa) {
            return false;
        }
        if (this.joX != null) {
            if (this.joX.getTag() instanceof a) {
                final View view2 = ((a) this.joX.getTag()).jby;
                this.jpa = true;
                view2.startAnimation(this.joZ);
                this.joZ.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b jDf;

                    public final void onAnimationStart(Animation animation) {
                        this.jDf.jpa = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            this.jDf.aTn();
                        }
                        this.jDf.jpa = false;
                    }
                });
            } else {
                aTn();
            }
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return false;
        } else {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            String str = bVar.bap;
            this.joX = new AbsoluteLayout(this.mContext);
            this.joX.setId(2131755095);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.joW.addView(this.joX);
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 150.0f);
            int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 17.0f);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 40.0f);
            final View inflate = q.em(this.mContext).inflate(2130903083, null);
            TextView textView = (TextView) inflate.findViewById(2131755296);
            String dJ = u.dJ(aa.getContext());
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.jdF.jYM;
            if (bVar2 != null) {
                CharSequence charSequence = "";
                if ("zh_CN".equals(dJ)) {
                    charSequence = bVar2.juF;
                } else if ("zh_TW".equals(dJ) || "zh_HK".equals(dJ)) {
                    charSequence = bVar2.juH;
                } else if ("en".equals(dJ)) {
                    charSequence = bVar2.juG;
                }
                if (!be.kS(charSequence)) {
                    textView.setText(charSequence);
                }
            }
            Rect rect = new Rect();
            int da = e.da(this.mContext);
            int[] aYm = bVar.jdF.aYm();
            v.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + aYm[0] + "  " + aYm[1] + " height: " + da);
            this.jcr = e.db(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(-2, -2, aYm[0] - a, ((aYm[1] - this.jcr) - da) + a2);
            this.joX.setTag(new a(this, str, inflate));
            this.joX.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.jpa = true;
            new ac().post(new Runnable(this) {
                final /* synthetic */ b jDf;

                public final void run() {
                    b.a(this.jDf, view, inflate);
                }
            });
            return true;
        }
    }

    public final boolean aTn() {
        if (this.jDd != null && ad.aSw().aTo()) {
            this.jDd.aTn();
        }
        if (this.joX != null) {
            this.joW.removeView(this.joX);
            this.joX = null;
            return true;
        }
        this.jpa = false;
        return false;
    }
}
