package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public ah dwn = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ a kFc;

        {
            this.kFc = r1;
        }

        public final boolean oU() {
            int i = this.kFc.kxF[this.kFc.kxH % this.kFc.kxF.length];
            if (this.kFc.kG != null) {
                if (-1 == i) {
                    this.kFc.kG.setText(null);
                } else {
                    this.kFc.kG.setText(i);
                }
            }
            a aVar = this.kFc;
            aVar.kxH++;
            return true;
        }
    }, true);
    public TextView kG;
    public int[] kxF;
    public int kxG;
    public int kxH;

    public final void bdp() {
        if (this.dwn != null) {
            this.dwn.QI();
        }
        v.h("MicroMsg.DynamicTextWrap", "stop textview: " + this.kG, new Object[0]);
        this.kG = null;
    }
}
