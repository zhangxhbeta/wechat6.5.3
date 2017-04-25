package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.n.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.be;

public final class v implements OnClickListener {
    private int cVh = 13;
    private int gjl;
    private int gyS;
    private int kB;
    private Context mContext;

    public v(Context context) {
        this.mContext = context;
    }

    public final void bI(int i, int i2) {
        this.gjl = i;
        this.gyS = 1301;
        this.kB = i2;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            String str;
            if (view.getTag() instanceof n) {
                n nVar = (n) view.getTag();
                if (!be.bP(nVar.gil)) {
                    str = ((g) nVar.gil.get(0)).gji;
                    if (be.kS(str)) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                        return;
                    }
                    c.W(this.mContext, str);
                    af.a(this.mContext, this.cVh, this.gyS, this.kB, 7, 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                }
            } else if (view.getTag() instanceof String) {
                str = (String) view.getTag();
                if (!be.kS(str)) {
                    c.W(this.mContext, str);
                    af.a(this.mContext, this.cVh, this.gyS, this.kB, 7, this.gjl, null);
                }
            }
        }
    }
}
