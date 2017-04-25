package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private MMActivity eBk;
    private View eEX;
    private b eGa;
    private int eJJ;
    private View eJK;
    private TextView eJL;
    private TextView eJM;
    private ImageView eJN;
    private ImageView[] eJO = new ImageView[3];
    private TextView eJP;
    private ImageView eJQ;

    public e(MMActivity mMActivity, View view, int i, b bVar) {
        this.eBk = mMActivity;
        this.eEX = view;
        this.eJJ = i;
        this.eGa = bVar;
        this.eJK = this.eEX.findViewById(2131755873);
        this.eJL = (TextView) this.eEX.findViewById(2131755875);
        this.eJM = (TextView) this.eEX.findViewById(2131755876);
        this.eJP = (TextView) this.eEX.findViewById(2131755877);
        this.eJN = (ImageView) this.eEX.findViewById(2131755874);
        this.eJO[0] = (ImageView) this.eEX.findViewById(2131755878);
        this.eJO[1] = (ImageView) this.eEX.findViewById(2131755879);
        this.eJO[2] = (ImageView) this.eEX.findViewById(2131755880);
        this.eJQ = (ImageView) this.eEX.findViewById(2131755881);
        if (this.eJJ == 1) {
            this.eJL.setText(this.eBk.getString(2131231646, new Object[]{Integer.valueOf(0)}));
            this.eJN.setImageResource(2130837865);
        } else if (this.eJJ == 2) {
            this.eJL.setText(2131231691);
            this.eJN.setImageResource(2130837881);
        } else if (this.eJJ == 3) {
            this.eJL.setText(this.eBk.getString(2131231716, new Object[]{Integer.valueOf(b.aaA())}));
            this.eJN.setImageResource(2130837884);
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.eJK.setOnClickListener(onClickListener);
    }

    public final void av() {
        if (this.eJJ == 2) {
            l lVar = (l) af.aap().getValue("key_share_card_layout_data");
            if (lVar == null) {
                v.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
                return;
            }
            if (be.kS(lVar.eEL)) {
                this.eJM.setVisibility(8);
            } else {
                this.eJM.setVisibility(0);
                this.eJM.setText(lVar.eEL);
            }
            if (be.bP(lVar.eEK)) {
                for (int i = 0; i < 3; i++) {
                    this.eJO[i].setVisibility(8);
                }
            } else {
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 < lVar.eEK.size()) {
                        this.eJO[i2].setVisibility(0);
                        k.a(this.eJO[i2], (String) lVar.eEK.get(i2), this.eBk.getResources().getDimensionPixelSize(2131493138), 2130838736, true);
                    } else {
                        this.eJO[i2].setVisibility(8);
                    }
                }
            }
            if (lVar.eEJ) {
                this.eJP.setVisibility(0);
            } else {
                this.eJP.setVisibility(8);
            }
            if (be.bP(lVar.eEK) || lVar.eEK.size() != 1 || !lVar.eEI || lVar.eEJ) {
                this.eJQ.setVisibility(8);
            } else {
                this.eJQ.setVisibility(0);
            }
        } else if (this.eJJ == 3) {
            this.eJL.setText(this.eBk.getString(2131231716, new Object[]{Integer.valueOf(b.aaA())}));
            String str = (String) af.aap().getValue("key_card_entrance_tips");
            if (be.kS(str)) {
                this.eJM.setVisibility(8);
                return;
            }
            this.eJM.setText(str);
            this.eJM.setVisibility(0);
        }
    }

    public final void setVisibility(int i) {
        this.eEX.setVisibility(i);
    }
}
