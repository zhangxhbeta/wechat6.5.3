package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;

public class ExdeviceLikeView extends RelativeLayout {
    int fBQ;
    a fBR;
    private int fBS;
    TextView fBT;
    private ImageView fBU;
    private ProgressBar fBV;
    private Context mContext;

    public interface a {
        boolean akl();

        void gT(int i);
    }

    static /* synthetic */ void c(ExdeviceLikeView exdeviceLikeView) {
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, 2130968632);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.fBU.startAnimation(loadAnimation);
    }

    static /* synthetic */ int kx(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 2;
            default:
                v.w("MicroMsg.ExdeviceLikeView", "hy: state error");
                return 2;
        }
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.fBS = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(2130903555, this, true);
        this.fBT = (TextView) inflate.findViewById(2131756814);
        this.fBU = (ImageView) inflate.findViewById(2131756815);
        this.fBV = (ProgressBar) inflate.findViewById(2131756816);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceLikeView fBW;

            {
                this.fBW = r1;
            }

            public final void onClick(View view) {
                if (this.fBW.fBR == null || this.fBW.fBR.akl() || this.fBW.fBS != 0) {
                    v.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
                    return;
                }
                v.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
                this.fBW.kw(ExdeviceLikeView.kx(this.fBW.fBS));
                if (this.fBW.fBS == 1) {
                    ExdeviceLikeView.c(this.fBW);
                }
                if (this.fBW.fBR != null) {
                    this.fBW.fBR.gT(this.fBW.fBS);
                }
            }
        });
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void kw(int i) {
        this.fBS = i;
        if (this.fBS == 1) {
            this.fBV.setVisibility(8);
            this.fBT.setVisibility(0);
            this.fBU.setVisibility(0);
            this.fBU.setImageResource(2131165472);
        } else if (this.fBS == 0) {
            this.fBV.setVisibility(8);
            this.fBT.setVisibility(0);
            this.fBU.setVisibility(0);
            this.fBU.setImageResource(2131165473);
        } else if (this.fBS == 2) {
            this.fBT.setVisibility(8);
            this.fBV.setVisibility(0);
            this.fBU.setVisibility(8);
        } else {
            v.w("MicroMsg.ExdeviceLikeView", "hy: error state");
        }
    }
}
