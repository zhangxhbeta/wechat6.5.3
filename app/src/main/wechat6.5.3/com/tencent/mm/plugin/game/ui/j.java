package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class j implements OnClickListener, OnItemClickListener {
    protected int gjl = 0;
    protected String gux;

    public final void lu(int i) {
        this.gjl = i;
    }

    public final void ur(String str) {
        this.gux = str;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = adapterView.getAdapter().getItem(i);
        if (item != null && (item instanceof c)) {
            c cVar = (c) item;
            if (!be.kS(cVar.field_appId)) {
                a(view.getContext(), cVar);
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            a(view.getContext(), (c) view.getTag());
        }
    }

    private void a(Context context, c cVar) {
        int i = 0;
        if (cVar.type == 1) {
            com.tencent.mm.plugin.game.e.c.W(context, cVar.ghp);
            i = 7;
        } else if (cVar.type == 0) {
            if (be.kS(cVar.bxu) || cVar.bxx != 4) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", cVar.field_appId);
                if (cVar.bmG == 1601) {
                    bundle.putInt("game_report_from_scene", this.gjl);
                } else {
                    bundle.putInt("game_report_from_scene", cVar.bmG);
                }
                i = com.tencent.mm.plugin.game.e.c.a(context, cVar.field_appId, cVar.ghp, bundle);
            } else {
                v.i("MicroMsg.GameItemClickListener", "Download via Google Play");
                p.aO(context, cVar.bxu);
                i = 25;
            }
        }
        af.a(context, cVar.scene, cVar.bmG, cVar.position, i, cVar.field_appId, this.gjl, cVar.bln, cVar.ghF);
    }
}
