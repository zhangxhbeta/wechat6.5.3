package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.FileUtils;

final class by extends b {
    private a onG;

    public by(int i) {
        super(i);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903325);
        view.setTag(new ee(this.eKg).o(view, true));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        ee eeVar = (ee) aVar;
        ee.a(eeVar, atVar, true, i, aVar2, 2130837919);
        String str2 = atVar.bNm;
        if (str2 == null || str2.length() == 0) {
            eeVar.oks.setVisibility(8);
            return;
        }
        eeVar.oks.setVisibility(0);
        ad.b(aVar2, eeVar.oks, (Object) dl.Pa(str2));
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        ak.yW();
        if (c.isSDCardAvailable()) {
            int i = ((dl) view.getTag()).position;
            n kZ = k.KV().kZ(atVar.field_imgPath);
            contextMenu.add(i, 129, 0, view.getContext().getString(2131231833));
            contextMenu.add(i, MMGIFException.D_GIF_ERR_WRONG_RECORD, 0, view.getContext().getString(2131234555));
            if (com.tencent.mm.ay.c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            com.tencent.mm.sdk.c.b cpVar = new cp();
            cpVar.bay.bao = atVar.field_msgId;
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
            }
            if (kZ != null && ((kZ.status == 199 || kZ.status == 199) && e.Dh() && !this.onG.bFL())) {
                contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231830));
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
