package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.sdk.platformtools.u;

public final class a {
    public Button eVF;
    public TextView eVL;
    public boolean fPG = false;
    public View fPH;
    public long fPI = v.alW();
    public a fPJ;

    public interface a {
        void amA();
    }

    public final void show() {
        if (!this.fPG) {
            if (this.fPH != null) {
                if (this.fPH instanceof ViewStub) {
                    this.fPH = ((ViewStub) this.fPH).inflate();
                }
                this.eVL = (TextView) this.fPH.findViewById(2131756924);
                if (!u.bsU()) {
                    this.eVL.setTextSize(1, 14.0f);
                }
                this.eVF = (Button) this.fPH.findViewById(2131756925);
                amS();
                this.eVF.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a fPK;

                    {
                        this.fPK = r1;
                    }

                    public final void onClick(View view) {
                        if (this.fPK.fPJ != null) {
                            this.fPK.fPJ.amA();
                        }
                    }
                });
                this.fPG = true;
            } else {
                return;
            }
        }
        if (this.fPH.getVisibility() != 0) {
            this.fPH.setVisibility(0);
            this.fPH.startAnimation(AnimationUtils.loadAnimation(this.fPH.getContext(), 2130968622));
        }
    }

    public final void amS() {
        this.eVL.setText(this.eVL.getContext().getString(2131232631, new Object[]{c.bx(this.fPI)}));
        this.eVF.setEnabled(false);
    }
}
