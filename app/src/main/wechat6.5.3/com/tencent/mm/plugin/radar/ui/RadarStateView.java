package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.radar.a.c.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class RadarStateView extends RelativeLayout {
    public d iiE = d.Stranger;
    boolean ijB = false;
    private Animation ijC = null;
    private Animation ijD = null;
    boolean ijI = true;
    ac ijJ = new ac(this) {
        final /* synthetic */ RadarStateView ijL;

        {
            this.ijL = r1;
        }

        public final void handleMessage(Message message) {
            this.ijL.aIT();
            this.ijL.aIU();
        }
    };
    private ImageView ijK = null;

    public RadarStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    final void aIT() {
        v.d("MicroMsg.RadarStateView", " state : " + this.iiE);
        if (this.ijI) {
            switch (this.iiE) {
                case Stranger:
                    setVisibility(8);
                    return;
                case Verifying:
                    setBackgroundResource(2131165858);
                    this.ijK.setImageResource(2131165862);
                    setVisibility(0);
                    return;
                case Added:
                    setBackgroundResource(2131165859);
                    this.ijK.setImageResource(2131165861);
                    setVisibility(0);
                    return;
                case NeedVerify:
                    setBackgroundResource(2131165859);
                    this.ijK.setImageResource(2131165860);
                    setVisibility(0);
                    return;
                default:
                    return;
            }
        }
        setVisibility(8);
    }

    final void init() {
        if (this.ijK == null) {
            this.ijK = new ImageView(getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, a.fromDPToPix(getContext(), 5), a.fromDPToPix(getContext(), 2));
            this.ijK.setLayoutParams(layoutParams);
            addView(this.ijK);
        }
        if (this.ijC == null) {
            this.ijC = AnimationUtils.loadAnimation(getContext(), 2130968652);
            this.ijC.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateView ijL;

                {
                    this.ijL = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (this.ijD == null) {
            this.ijD = AnimationUtils.loadAnimation(getContext(), 2130968651);
            this.ijD.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateView ijL;

                {
                    this.ijL = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.ijL.ijB = false;
                    this.ijL.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public final void aIU() {
        if (this.ijI) {
            init();
            aIT();
            this.ijB = true;
            startAnimation(this.ijC);
        }
    }

    public final void aIV() {
        if (this.ijI) {
            init();
            aIT();
            startAnimation(this.ijD);
        }
    }
}
