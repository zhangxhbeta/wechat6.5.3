package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.voiceprint.ui.a.a;
import com.tencent.mm.sdk.platformtools.v;

public class VoiceTipInfoView extends LinearLayout {
    TextView eXB;
    public ProgressBar fpm;
    TextView kpT;
    boolean kqt = false;
    private boolean kqu = false;
    private TextView kqv;
    private boolean kqw = false;
    private float kqx = 0.0f;

    public VoiceTipInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(2130904591, this, true);
        this.fpm = (ProgressBar) inflate.findViewById(2131759601);
        bbj();
        this.eXB = (TextView) inflate.findViewById(2131759656);
        this.kpT = (TextView) inflate.findViewById(2131759657);
        this.kqv = (TextView) inflate.findViewById(2131759675);
        reset();
    }

    public final void reset() {
        this.kpT.setTextSize(0, getContext().getResources().getDimension(2131493604));
        this.kqx = this.kpT.getTextSize();
        this.kpT.clearAnimation();
        v.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[]{Float.valueOf(this.kqx)});
    }

    public final void bbi() {
        v.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
        this.fpm.setVisibility(0);
    }

    public final void bbj() {
        v.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
        this.fpm.setVisibility(8);
    }

    public final void CM(String str) {
        this.kpT.setText(str);
        this.kpT.setVisibility(0);
    }

    public final void ry(int i) {
        this.eXB.setText(i);
        this.eXB.setVisibility(0);
    }

    public final void bbk() {
        v.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(this.eXB.getVisibility()), Boolean.valueOf(this.kqt)});
        if ((this.eXB.getVisibility() == 4 || this.eXB.getVisibility() == 8) && !this.kqt) {
            this.eXB.clearAnimation();
            this.kqt = true;
            View view = this.eXB;
            Context context = getContext();
            a anonymousClass2 = new a(this) {
                final /* synthetic */ VoiceTipInfoView kqy;

                {
                    this.kqy = r1;
                }

                public final void bba() {
                }

                public final void bbb() {
                    this.kqy.eXB.setVisibility(0);
                    this.kqy.kqt = false;
                }
            };
            Animation loadAnimation = AnimationUtils.loadAnimation(context, 2130968622);
            loadAnimation.setDuration(300);
            loadAnimation.setFillAfter(true);
            loadAnimation.setRepeatCount(0);
            loadAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass4(anonymousClass2));
            view.startAnimation(loadAnimation);
            return;
        }
        v.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
        this.eXB.clearAnimation();
        this.eXB.setVisibility(0);
        this.eXB.invalidate();
    }

    public final void bbl() {
        this.kpT.setVisibility(8);
    }

    public final void bbm() {
        if (this.kqv.getVisibility() != 4 || this.kqw) {
            this.kqv.clearAnimation();
            this.kqv.setVisibility(0);
            return;
        }
        this.kqv.clearAnimation();
        this.kqw = true;
        View view = this.kqv;
        getContext();
        a anonymousClass4 = new a(this) {
            final /* synthetic */ VoiceTipInfoView kqy;

            {
                this.kqy = r1;
            }

            public final void bba() {
            }

            public final void bbb() {
                this.kqy.kqv.setVisibility(0);
                this.kqy.kqw = false;
            }
        };
        Animation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass5(anonymousClass4));
        view.startAnimation(translateAnimation);
    }

    public final void bbn() {
        if (this.kqv.getVisibility() != 0 || this.kqw) {
            this.kqv.clearAnimation();
            this.kqv.setVisibility(4);
            return;
        }
        this.kqv.clearAnimation();
        this.kqw = true;
        a.a(this.kqv, getContext(), new a(this) {
            final /* synthetic */ VoiceTipInfoView kqy;

            {
                this.kqy = r1;
            }

            public final void bba() {
            }

            public final void bbb() {
                this.kqy.kqv.setVisibility(4);
                this.kqy.kqw = false;
            }
        });
    }

    public final void rz(int i) {
        this.kqv.setText(i);
    }
}
