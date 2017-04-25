package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.a.i.a;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;

public final class h implements a {
    MMActivity eBk;
    View eEX;
    boolean eGJ = false;
    View eKK;
    TextView eKL;
    ImageView eKM;
    View eKN;
    TextView eKO;
    ImageView eKP;

    public h(MMActivity mMActivity, View view) {
        this.eBk = mMActivity;
        this.eEX = view;
    }

    public final void a(g gVar) {
        abN();
    }

    public final void Yj() {
    }

    final void abN() {
        if (af.aao().eBC <= 0 || !this.eGJ) {
            this.eKK.setVisibility(8);
            if (this.eKN != null) {
                this.eKN.setVisibility(8);
                return;
            }
            return;
        }
        ak.yW();
        String str = (String) c.vf().get(t.a.npH, "");
        ak.yW();
        String str2 = (String) c.vf().get(t.a.npI, "");
        int dimensionPixelOffset = this.eBk.getResources().getDimensionPixelOffset(2131493353);
        if (TextUtils.isEmpty(str2)) {
            this.eKM.setImageResource(2130837870);
        } else {
            k.a(this.eKM, str2, dimensionPixelOffset, 2130837870, true);
        }
        if (TextUtils.isEmpty(str)) {
            this.eKL.setText(this.eBk.getString(2131231633, new Object[]{Integer.valueOf(r2)}));
        } else {
            this.eKL.setText(str);
        }
        this.eKK.setVisibility(0);
        if (this.eKN != null) {
            if (TextUtils.isEmpty(str2)) {
                this.eKP.setImageResource(2130837870);
            } else {
                k.a(this.eKP, str2, dimensionPixelOffset, 2130837870, true);
            }
            if (TextUtils.isEmpty(str)) {
                this.eKO.setText(this.eBk.getString(2131231633, new Object[]{Integer.valueOf(r2)}));
            } else {
                this.eKO.setText(str);
            }
            this.eKN.setVisibility(0);
        }
    }
}
