package com.tencent.mm.plugin.game.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.c.n.c;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class o implements OnClickListener {
    public int gjl;
    private Context mContext;

    public static class a {
        public int bmG = 1301;
        public n ghM;
        public String gjk;
        public int position;

        public a(n nVar, String str, int i) {
            this.ghM = nVar;
            this.gjk = str;
            this.position = i;
        }
    }

    public o(Context context) {
        this.mContext = context;
    }

    public o(Context context, int i) {
        this.mContext = context;
        this.gjl = i;
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            v.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.ghM == null) {
            v.e("MicroMsg.GameMessageClickListener", "message is null");
        } else if (aVar.gjk == null) {
            v.e("MicroMsg.GameMessageClickListener", "jumpId is null");
        } else {
            c cVar = (c) aVar.ghM.giq.get(aVar.gjk);
            if (cVar == null) {
                v.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                return;
            }
            int a = a(this.mContext, aVar.ghM, cVar, aVar.ghM.field_appId, aVar.bmG);
            if (a != 0) {
                af.a(this.mContext, 13, aVar.bmG, aVar.position, a, 0, aVar.ghM.field_appId, this.gjl, aVar.ghM.giT, aVar.ghM.field_gameMsgId, aVar.ghM.giU, null);
            }
        }
    }

    public static int a(Context context, n nVar, c cVar, String str, int i) {
        int i2 = 0;
        switch (cVar.gjb) {
            case 1:
                if (!g.o(context, str)) {
                    return d(context, str, i);
                }
                e.R(context, str);
                return 3;
            case 2:
                if (!g.o(context, str)) {
                    return 0;
                }
                e.R(context, str);
                return 3;
            case 3:
                return d(context, str, i);
            case 4:
                if (nVar != null) {
                    nVar.field_isRead = true;
                    au.asc().a(nVar, new String[0]);
                }
                Intent intent = new Intent(context, GameMessageUI.class);
                intent.putExtra("game_report_from_scene", i);
                context.startActivity(intent);
                return 6;
            case 5:
                String str2 = cVar.fBu;
                if (!be.kS(str2)) {
                    com.tencent.mm.plugin.game.e.c.W(context, str2);
                    i2 = 7;
                }
                return i2;
            default:
                v.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + cVar.gjb);
                return 0;
        }
    }

    private static int d(Context context, String str, int i) {
        if (be.kS(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i);
        return com.tencent.mm.plugin.game.e.c.a(context, str, null, bundle);
    }
}
