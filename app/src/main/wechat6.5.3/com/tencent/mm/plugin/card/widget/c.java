package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.protocal.c.ld;

public final class c extends a {
    protected TextView eNO;
    protected TextView eNP;

    public c(Context context) {
        super(context);
    }

    protected final void acQ() {
        this.eNP = (TextView) acP().findViewById(2131756004);
        this.eNO = (TextView) acP().findViewById(2131756003);
    }

    protected final void acR() {
        if (this.eBg.Zv().mkN != null && this.eBg.Zv().mkN.size() > 0) {
            ld ldVar = (ld) this.eBg.Zv().mkN.get(0);
            if (this.eNF != null) {
                this.eNF.setText(ldVar.title);
            }
            if (this.eNO != null) {
                if (TextUtils.isEmpty(ldVar.eBN)) {
                    this.eNO.setVisibility(8);
                } else {
                    this.eNO.setText(ldVar.eBN);
                }
            }
            if (this.eNP == null) {
                return;
            }
            if (TextUtils.isEmpty(ldVar.eBO)) {
                this.eNP.setVisibility(8);
            } else {
                this.eNP.setText(ldVar.eBO);
            }
        }
    }

    public final void j(boolean z, boolean z2) {
    }
}
