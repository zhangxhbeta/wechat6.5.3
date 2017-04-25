package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;

final class bt extends bx {
    private a onG;

    public bt() {
        super(37);
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        aVar = (ed) aVar;
        aVar.olH.setText(com.tencent.mm.x.a.a(com.tencent.mm.x.a.a.ij(atVar.field_content)));
        if (atVar.field_status >= 2) {
            aVar.ieT.setVisibility(8);
        } else {
            aVar.ieT.setVisibility(0);
        }
        e.e(aVar.olH, 1);
        aVar.olH.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        aVar.olH.setOnClickListener(aVar2.onh.oqh);
        aVar.olH.setOnLongClickListener(aVar2.onh.oqj);
        ad.a(i, aVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        if (atVar.bwt()) {
            int i = ((dl) view.getTag()).position;
            if (atVar.field_status == 5) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, view.getContext().getString(2131231874));
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
            }
        }
        return true;
    }
}
