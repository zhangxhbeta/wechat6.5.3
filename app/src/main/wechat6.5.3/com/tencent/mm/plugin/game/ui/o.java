package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class o extends c {
    public o(Context context, int i) {
        super(context);
        this.gjl = i;
    }

    public final void onClick(View view) {
        n nVar;
        Object tag = view.getTag();
        if (tag == null) {
            v.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            nVar = null;
        } else if (tag instanceof Long) {
            n bX = au.asc().bX(((Long) tag).longValue());
            if (bX != null) {
                bX.arp();
            }
            nVar = bX;
        } else {
            v.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            nVar = null;
        }
        if (nVar == null) {
            v.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            return;
        }
        switch (nVar.field_msgType) {
            case 5:
                if (!be.kS(nVar.giI)) {
                    c.W(this.mContext, nVar.giI);
                    af.a(this.mContext, 13, 1301, 3, 7, 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
                }
                return;
            case 6:
                if (!be.kS(nVar.giF)) {
                    c.W(this.mContext, nVar.giF);
                    af.a(this.mContext, 13, 1301, 3, 7, 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
                }
                return;
            case 10:
            case 11:
                if (be.kS(nVar.gid)) {
                    af.a(this.mContext, 13, 1301, 3, c.a(this.mContext, nVar), 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
                }
                Context context = this.mContext;
                String str = nVar.gid;
                if (nVar == null) {
                    v.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
                } else if (!be.kS(str)) {
                    c.W(context, str);
                }
                af.a(this.mContext, 13, 1301, 3, 7, 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                return;
            default:
                af.a(this.mContext, 13, 1301, 3, c.a(this.mContext, nVar), 0, nVar.field_appId, this.gjl, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                return;
        }
    }
}
