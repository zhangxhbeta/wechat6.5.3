package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class RadarTipsView extends RelativeLayout {
    private ac ijM = new ac(this) {
        final /* synthetic */ RadarTipsView iki;

        {
            this.iki = r1;
        }

        public final void handleMessage(Message message) {
            this.iki.setVisibility(8);
        }
    };
    Animation ijN = null;
    Animation ijO = null;
    TextView ijP = null;
    View ijQ = null;
    LinearLayout ijR = null;
    private final int ijS = 0;
    private final int ijT = 1;
    private final int ijU = 2;
    private final int ijV = 3;
    private final int ijW = 3;
    ac ijX = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ RadarTipsView iki;

        public final void handleMessage(Message message) {
            if (message.what == 0) {
                this.iki.aIX();
            } else if (message.what == 1) {
                if (this.iki.ijZ && this.iki.ikb) {
                    r0 = this.iki;
                    r0.aM(r0.getContext().getString(2131234305), -1);
                }
            } else if (message.what == 2) {
            } else {
                if (message.what == 3) {
                    r0 = this.iki;
                    r0.ijY = true;
                    r0.ikh = 2;
                    v.d("MicroMsg.RadarTipsView", "showNoviceEducation");
                    r0.ika = true;
                    r0.ijQ.setVisibility(8);
                    r0.ijQ.clearAnimation();
                    r0.setVisibility(0);
                    r0.ijR.setVisibility(0);
                    r0.ijR.startAnimation(r0.ijN);
                    r0.ijR.requestFocus();
                } else if (message.what == 3) {
                    this.iki.aIW();
                }
            }
        }
    };
    boolean ijY = false;
    private boolean ijZ = true;
    boolean ika = false;
    boolean ikb = false;
    int ikc = 0;
    long ikd = 0;
    boolean ike = false;
    private boolean ikf = false;
    private int ikg = 0;
    int ikh = 0;

    public RadarTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void aM(String str, int i) {
        this.ijY = true;
        this.ijR.setVisibility(8);
        this.ijR.clearAnimation();
        this.ijP.setText(str);
        setVisibility(0);
        this.ijQ.setVisibility(0);
        this.ijQ.startAnimation(this.ijN);
        this.ijX.removeMessages(0);
        this.ijX.removeMessages(2);
        if (i > 0) {
            this.ijX.sendEmptyMessageDelayed(0, (long) i);
        }
    }

    public final void yr(String str) {
        this.ikh = 3;
        aM(str, 5000);
    }

    public final void aIW() {
        this.ijY = false;
        this.ikh = 0;
        v.d("MicroMsg.RadarTipsView", "hidNoviceEducation");
        this.ijX.removeMessages(3);
        if (getVisibility() == 0 && this.ijR.getVisibility() == 0) {
            this.ijR.clearAnimation();
            if (this.ijQ.getAnimation() == this.ijO) {
                this.ijQ.clearAnimation();
            }
            v.d("MicroMsg.RadarTipsView", "hideNoviceEducation real");
            this.ijR.startAnimation(this.ijO);
        }
    }

    public final void eZ(boolean z) {
        this.ijZ = z;
        if (!this.ijZ) {
            aIX();
            aIY();
            aIW();
        }
    }

    public final void aIX() {
        v.d("MicroMsg.RadarTipsView", "hideRadarTips");
        if (getVisibility() == 0 && this.ijQ.getVisibility() == 0) {
            if (this.ijR.getAnimation() == this.ijO) {
                this.ijR.clearAnimation();
            }
            this.ijQ.clearAnimation();
            v.d("MicroMsg.RadarTipsView", "hideRadarTips real");
            this.ikh = 0;
            this.ijY = false;
            this.ijQ.startAnimation(this.ijO);
        }
    }

    public final void aIY() {
        this.ijY = false;
        this.ijX.removeMessages(1);
        this.ijX.removeMessages(2);
        this.ijX.removeMessages(3);
    }
}
