package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mmdb.FileUtils;

final class bp extends c {
    private a onG;

    public bp() {
        super(17);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903352);
        view.setTag(new do(this.eKg).o(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        do.a((do) aVar, atVar, false, i, aVar2);
        do doVar = (do) aVar;
        if (ad.bEA()) {
            if (atVar.field_status == 2 && ad.a(aVar2.onh, atVar.field_msgId)) {
                if (doVar.okm != null) {
                    doVar.okm.setVisibility(0);
                }
            } else if (doVar.okm != null) {
                doVar.okm.setVisibility(8);
            }
        }
        ad.a(i, (ad.a) doVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        if (atVar.field_type == 48) {
            int i = ((dl) view.getTag()).position;
            if (atVar.field_status == 5) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, view.getContext().getString(2131231874));
            }
            contextMenu.add(i, 126, 0, view.getContext().getString(2131234555));
            if (e.Dj() && !this.onG.bFL()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
            }
            if (com.tencent.mm.ay.c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            b cpVar = new cp();
            cpVar.bay.bao = atVar.field_msgId;
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW || g.G(this.onG.nDR.nEl, atVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
            }
            if (!atVar.bvZ() && atVar.bwl() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }
}
