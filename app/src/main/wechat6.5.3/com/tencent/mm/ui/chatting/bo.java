package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.FileUtils;

final class bo extends b {
    private a onG;

    public bo() {
        super(16);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903321);
        view.setTag(new do(this.eKg).o(view, true));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        do.a((do) aVar, atVar, true, i, aVar2);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        if (atVar.field_type == 48) {
            int i = ((dl) view.getTag()).position;
            contextMenu.add(i, 126, 0, view.getContext().getString(2131234555));
            if (e.Dj() && !this.onG.bFL()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
            }
            if (c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            com.tencent.mm.sdk.c.b cpVar = new cp();
            cpVar.bay.bao = atVar.field_msgId;
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW || g.G(this.onG.nDR.nEl, atVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
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
