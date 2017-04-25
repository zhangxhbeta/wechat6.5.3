package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.be;

public final class n extends c {
    public n(Context context, int i) {
        super(context);
        this.gjl = i;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof com.tencent.mm.plugin.game.c.n) {
            com.tencent.mm.plugin.game.c.n nVar = (com.tencent.mm.plugin.game.c.n) view.getTag();
            switch (nVar.field_msgType) {
                case 6:
                    if (!be.kS(nVar.gik)) {
                        c.W(this.mContext, nVar.gik);
                        af.a(this.mContext, 13, 1301, 5, 7, 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                        return;
                    }
                    return;
                default:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", nVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    af.a(this.mContext, 13, 1301, 5, c.a(this.mContext, nVar.field_appId, null, bundle), 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
            }
        }
    }
}
