package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;

final class bs extends bw {
    private a onG;

    public bs() {
        super(36);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903336);
        view.setTag(new du(this.eKg).cS(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        du duVar = (du) aVar;
        com.tencent.mm.x.a.a ij = com.tencent.mm.x.a.a.ij(atVar.field_content);
        String str2 = ij.bhM;
        a((ad.a) duVar, aVar2, atVar, str2);
        ad.a((ad.a) duVar, aVar2, str2, atVar);
        duVar.lts.setText(com.tencent.mm.x.a.a(ij));
        e.e(duVar.lts, 1);
        duVar.lts.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        duVar.lts.setOnClickListener(aVar2.onh.oqh);
        duVar.lts.setOnLongClickListener(aVar2.onh.oqj);
    }

    protected final boolean bEy() {
        return false;
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
