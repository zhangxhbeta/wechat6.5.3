package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TalkRoomPopupNav extends LinearLayout {
    public View fTh;
    public LinearLayout nGc;
    public a obB;
    public LinearLayout obC;
    private LinearLayout obD;
    private ImageView obE;
    public ImageView obF;
    public ScaleAnimation obG;
    public Animation obH;
    public int obI = 0;
    public int obJ = 0;
    private ScaleAnimation obK;
    private Animation obL;
    public AlphaAnimation obM;
    public AlphaAnimation obN;

    public interface a {
        void bCZ();

        void bDa();
    }

    static /* synthetic */ void b(TalkRoomPopupNav talkRoomPopupNav) {
        if (talkRoomPopupNav.obK == null) {
            talkRoomPopupNav.obK = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.obJ) * 1.0f) / ((float) talkRoomPopupNav.obI), 1.0f);
            talkRoomPopupNav.obK.setDuration(300);
            talkRoomPopupNav.obK.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                final /* synthetic */ TalkRoomPopupNav obO;

                {
                    this.obO = r1;
                }

                public final void onAnimationStart(Animation animation) {
                    this.obO.obD.setVisibility(4);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.obO.obC.setVisibility(8);
                    this.obO.nGc.setClickable(true);
                }
            });
        }
        if (talkRoomPopupNav.obL == null) {
            talkRoomPopupNav.obL = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), 2130968623);
            talkRoomPopupNav.obL.setFillAfter(true);
            talkRoomPopupNav.obL.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                final /* synthetic */ TalkRoomPopupNav obO;

                {
                    this.obO = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.obO.obD.setVisibility(4);
                    this.obO.obC.setVisibility(4);
                }
            });
        }
        LayoutParams layoutParams = talkRoomPopupNav.fTh.getLayoutParams();
        layoutParams.height = talkRoomPopupNav.obI;
        talkRoomPopupNav.fTh.setLayoutParams(layoutParams);
        talkRoomPopupNav.fTh.startAnimation(talkRoomPopupNav.obK);
        talkRoomPopupNav.obC.startAnimation(talkRoomPopupNav.obL);
        talkRoomPopupNav.nGc.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), 2130968622));
        talkRoomPopupNav.nGc.setVisibility(0);
    }

    @TargetApi(11)
    public TalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    public TalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    public final void Ov(String str) {
        ((TextView) findViewById(2131759544)).setText(str);
    }

    public final void wD(int i) {
        if (this.fTh != null) {
            this.fTh.setBackgroundResource(i);
        }
    }

    public final void wE(int i) {
        if (this.obE != null) {
            this.obE.setImageResource(i);
        }
    }

    public final void wF(int i) {
        if (i < 0) {
            if (this.obF != null) {
                this.obF.setVisibility(8);
            }
        } else if (this.obF != null) {
            this.obF.setImageResource(i);
            this.obF.setVisibility(0);
        }
    }

    private void NI() {
        inflate(getContext(), 2130904538, this);
        this.nGc = (LinearLayout) findViewById(2131759541);
        this.obC = (LinearLayout) findViewById(2131759545);
        this.obD = (LinearLayout) findViewById(2131759547);
        this.fTh = findViewById(2131759540);
        this.obE = (ImageView) findViewById(2131759542);
        this.obF = (ImageView) findViewById(2131759543);
        this.obF.setVisibility(8);
        this.nGc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav obO;

            {
                this.obO = r1;
            }

            public final void onClick(View view) {
                if (this.obO.obB != null) {
                    this.obO.obB.bCZ();
                }
            }
        });
        ((Button) findViewById(2131759548)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav obO;

            {
                this.obO = r1;
            }

            public final void onClick(View view) {
                TalkRoomPopupNav.b(this.obO);
            }
        });
        ((Button) findViewById(2131759549)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav obO;

            {
                this.obO = r1;
            }

            public final void onClick(View view) {
                TalkRoomPopupNav.b(this.obO);
                if (this.obO.obB != null) {
                    this.obO.obB.bDa();
                }
            }
        });
        this.obI = this.fTh.getLayoutParams().height;
        this.obJ = this.obC.getLayoutParams().height;
    }

    public final void stop() {
        if (this.obM != null && this.obN != null) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(this.obF, this.obM);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(this.obF, this.obN);
            this.obF.clearAnimation();
            this.obM = null;
            this.obN = null;
        }
    }
}
