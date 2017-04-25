package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private ImageView bgv;
    private MMActivity eBk;
    View eFZ;
    b eGa;
    protected LinearLayout eGb;
    protected LinearLayout eGc;
    private TextView eGd;

    public e(MMActivity mMActivity) {
        this.eBk = mMActivity;
    }

    public final void aaM() {
        if (this.eFZ == null) {
            this.eFZ = View.inflate(this.eBk, 2130903241, null);
            this.bgv = (ImageView) this.eFZ.findViewById(2131755941);
            this.eGd = (TextView) this.eFZ.findViewById(2131755939);
            this.eGb = (LinearLayout) this.eFZ.findViewById(2131755940);
            this.eGc = (LinearLayout) this.eFZ.findViewById(2131755942);
            this.eGb.setVisibility(8);
            this.eGc.setVisibility(8);
            Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.bgv.startAnimation(rotateAnimation);
        }
        av();
    }

    public final void aaN() {
        this.eGb.setVisibility(0);
        this.eGc.setVisibility(8);
    }

    public final void aaO() {
        this.eGb.setVisibility(8);
    }

    private void aaP() {
        this.eGb.setVisibility(8);
        this.eGc.setVisibility(8);
    }

    public final void aaQ() {
        aaP();
        this.eGd.setVisibility(8);
    }

    public final void av() {
        Integer num = (Integer) af.aap().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (this.eGa != null && b.aaG() && ((r0.intValue() == 1 || r0.intValue() == 4) && b.aaD())) {
            this.eGd.setVisibility(0);
        } else {
            this.eGd.setVisibility(8);
            if (this.eGa != null) {
                v.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[]{Boolean.valueOf(b.aaG()), Boolean.valueOf(b.aaH())});
                if (!b.aaG() || !b.aaH()) {
                    aaN();
                    return;
                } else if (b.aaG() && b.aaH()) {
                    this.eGb.setVisibility(8);
                    this.eGc.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
        }
        aaP();
    }
}
