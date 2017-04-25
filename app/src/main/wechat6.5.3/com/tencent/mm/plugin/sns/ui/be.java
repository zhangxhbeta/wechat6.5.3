package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.awa;

public final class be {
    LinearLayout jMA;
    LinearLayout jMB;
    SnsCommentShowAbLayout jZj = null;
    int jcr = -1;
    FrameLayout joW;
    private as jpB;
    Context mContext;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View jZk;
        final /* synthetic */ be jZl;
        final /* synthetic */ View yO;

        AnonymousClass1(be beVar, View view, View view2) {
            this.jZl = beVar;
            this.yO = view;
            this.jZk = view2;
        }

        public final void run() {
            be.a(this.jZl, this.yO, this.jZk);
        }
    }

    class a {
        final /* synthetic */ be jZl;
        View jby = null;
        String jpq;

        public a(be beVar, String str, View view) {
            this.jZl = beVar;
            this.jpq = str;
            this.jby = view;
        }
    }

    static /* synthetic */ void a(be beVar, View view, View view2) {
        c cVar = (c) view.getTag();
        k Bq = ad.aSE().Bq(cVar.bap);
        if (Bq != null) {
            com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(740);
            awa n = ah.n(Bq);
            gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(Bq.field_userName).gk(n == null ? 0 : n.mTi).gk(n == null ? 0 : n.mTl);
            gh.JF();
        }
        view2.setVisibility(0);
        view2.startAnimation(beVar.jpB.jMy);
        beVar.jMA = (LinearLayout) view2.findViewById(2131759315);
        beVar.jMA.setOnClickListener(beVar.jpB.joV.kbB);
        beVar.jMA.setOnTouchListener(beVar.jpB.jFF);
        beVar.jMB = (LinearLayout) view2.findViewById(2131759310);
        beVar.jMB.setOnClickListener(beVar.jpB.joV.kbC);
        beVar.jMB.setOnTouchListener(beVar.jpB.jFF);
        beVar.jMB.setTag(cVar);
        beVar.jMA.setTag(cVar);
        ImageView imageView = (ImageView) beVar.jMB.findViewById(2131759311);
        ImageView imageView2 = (ImageView) beVar.jMA.findViewById(2131759314);
        TextView textView = (TextView) beVar.jMB.findViewById(2131759312);
        TextView textView2 = (TextView) beVar.jMA.findViewById(2131759317);
        if (s.BN(cVar.boC)) {
            beVar.jMA.setEnabled(false);
            beVar.jMB.setEnabled(false);
            textView2.setTextColor(beVar.mContext.getResources().getColor(2131690026));
            if (cVar.eKg == 11) {
                imageView.setImageResource(2131165575);
                imageView2.setImageResource(2131165580);
            } else {
                imageView.setImageResource(2131165578);
                imageView2.setImageResource(2131165582);
            }
            textView.setText(beVar.mContext.getString(2131235460));
            textView.setTextColor(beVar.mContext.getResources().getColor(2131690026));
        } else {
            beVar.jMA.setEnabled(true);
            if (cVar.eKg == 11) {
                imageView.setImageResource(2130838512);
                imageView2.setImageResource(2130838513);
                textView.setTextColor(beVar.mContext.getResources().getColor(2131690033));
                textView2.setTextColor(beVar.mContext.getResources().getColor(2131690033));
            } else {
                imageView.setImageResource(2130838276);
                textView.setTextColor(beVar.mContext.getResources().getColor(2131690127));
                textView2.setTextColor(beVar.mContext.getResources().getColor(2131690127));
            }
            beVar.jMB.setEnabled(true);
            if (cVar.kac == 0) {
                textView.setText(beVar.mContext.getString(2131235460));
            } else {
                textView.setText(beVar.mContext.getString(2131235422));
            }
        }
        if (cVar.eKg == 11) {
            beVar.jMB.setBackgroundResource(2130838595);
            beVar.jMA.setBackgroundResource(2130838596);
        }
    }

    public be(Context context, as asVar, FrameLayout frameLayout) {
        this.mContext = context;
        this.jpB = asVar;
        this.joW = frameLayout;
    }

    final void cl(final View view) {
        view.clearAnimation();
        view.startAnimation(this.jpB.jMz);
        this.jpB.jMz.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ be jZl;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (view != null) {
                    view.setVisibility(8);
                    this.jZl.aVG();
                }
            }
        });
    }

    public final boolean aVG() {
        if (this.jZj == null) {
            return false;
        }
        this.joW.removeView(this.jZj);
        this.jZj = null;
        return true;
    }
}
