package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends f {
    private View eME;

    public final void NI() {
    }

    public final void update() {
        b abq = this.eMF.abq();
        iw iwVar = abq.Zv().mlb;
        if (iwVar != null) {
            v.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + iwVar.iOT);
            v.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + iwVar.text);
            v.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + iwVar.mkC);
        }
        if (iwVar != null && !TextUtils.isEmpty(iwVar.text) && abq.Zt()) {
            if (this.eME == null) {
                this.eME = ((ViewStub) findViewById(2131755808)).inflate();
            }
            ((TextView) this.eME.findViewById(2131755741)).setText(iwVar.text);
            this.eME.setOnClickListener(this.eMF.abu());
        } else if (this.eME != null) {
            this.eME.setVisibility(8);
        }
    }

    public final void acF() {
        if (this.eME != null) {
            this.eME.setVisibility(8);
        }
    }
}
