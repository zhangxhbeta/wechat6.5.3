package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ad;

public class ExdeviceRankListHeaderView extends RelativeLayout {
    private TextView fEk;
    OnClickListener fEl;
    private Animation fEm;
    private Animation fEn;
    private Runnable fEo;
    boolean fEp;
    private Context mContext;

    static /* synthetic */ void b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        ad.B(exdeviceRankListHeaderView.fEo);
        if (exdeviceRankListHeaderView.fEk.getVisibility() == 4) {
            exdeviceRankListHeaderView.fEm.reset();
            exdeviceRankListHeaderView.fEk.startAnimation(exdeviceRankListHeaderView.fEm);
            return;
        }
        exdeviceRankListHeaderView.fEn.reset();
        exdeviceRankListHeaderView.fEk.startAnimation(exdeviceRankListHeaderView.fEn);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.fEp = true;
        bF(context);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        this.fEp = true;
        bF(context);
    }

    private void bF(Context context) {
        this.mContext = context;
        this.fEk = (TextView) LayoutInflater.from(this.mContext).inflate(2130903572, this, true).findViewById(2131756859);
        this.fEk.setVisibility(4);
        this.fEm = AnimationUtils.loadAnimation(this.mContext, 2130968576);
        this.fEn = AnimationUtils.loadAnimation(this.mContext, 2130968577);
        this.fEo = new Runnable(this) {
            final /* synthetic */ ExdeviceRankListHeaderView fEq;

            {
                this.fEq = r1;
            }

            public final void run() {
                this.fEq.fEk.startAnimation(this.fEq.fEn);
            }
        };
        this.fEm.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView fEq;

            {
                this.fEq = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.fEq.fEk.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.fEq.fEn.reset();
                ad.g(this.fEq.fEo, 4000);
            }
        });
        this.fEn.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView fEq;

            {
                this.fEq = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.fEq.fEk.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.fEq.fEk.setVisibility(4);
            }
        });
        this.fEm.setFillAfter(true);
        this.fEm.setFillEnabled(true);
        this.fEn.setFillAfter(true);
        this.fEn.setFillAfter(true);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView fEq;

            {
                this.fEq = r1;
            }

            public final void onClick(View view) {
                if (this.fEq.fEp) {
                    ExdeviceRankListHeaderView.b(this.fEq);
                }
                if (this.fEq.fEl != null) {
                    this.fEq.fEl.onClick(this.fEq);
                }
            }
        });
    }
}
