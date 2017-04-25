package com.tencent.mm.ui.chatting;

import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.FileUtils;

final class bm extends b {
    a onG;

    public bm() {
        super(1);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903323);
        view.setTag(new dk(this.eKg).o(view, true));
        return view;
    }

    protected final String a(a aVar, at atVar) {
        return super.a(aVar, atVar);
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        aVar2.ax(atVar);
        dk dkVar = (dk) aVar;
        boolean a = n.GH().a(dkVar.okl, atVar.field_imgPath, com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl), atVar.bNp, atVar.bNq, true, 2130837919, dkVar.oxM, 2130837921, 1, true, null);
        dkVar.oxN.setVisibility(0);
        dkVar.ieT.setVisibility(8);
        if (!(a || this.lVu)) {
            dkVar.okl.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), 2130838794));
        }
        String str2 = null;
        if (aVar2.nQK) {
            str2 = atVar.field_talker;
        }
        dkVar.onC.setTag(new dl(atVar, aVar2.nQK, i, str, str2));
        dkVar.onC.setOnClickListener(aVar2.onh.oqh);
        dkVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        if (atVar.field_content == null || atVar.field_content.length() == 0) {
            dkVar.oks.setVisibility(8);
        } else {
            dkVar.oks.setVisibility(8);
        }
    }

    protected final boolean a(a aVar) {
        return aVar.nQK;
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        ak.yW();
        if (c.isSDCardAvailable()) {
            int i = ((dl) view.getTag()).position;
            d dVar = null;
            if (atVar.field_msgId > 0) {
                dVar = n.GH().ai(atVar.field_msgId);
            }
            if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                n.GH().ah(atVar.field_msgSvrId);
            }
            contextMenu.add(i, MMGIFException.D_GIF_ERR_CLOSE_FAILED, 0, view.getContext().getString(2131234555));
            if (e.Dg() && !this.onG.bFL()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
            }
            if (com.tencent.mm.ay.c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            com.tencent.mm.sdk.c.b cpVar = new cp();
            cpVar.bay.bao = atVar.field_msgId;
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW || g.G(this.onG.nDR.nEl, atVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231828));
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
