package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mmdb.FileUtils;

final class bz extends c {
    private a onG;

    public bz(int i) {
        super(i);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903355);
        view.setTag(new ee(this.eKg).o(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        ee eeVar = (ee) aVar;
        ee.a(eeVar, atVar, false, i, aVar2, 2130837922);
        if (ad.bEA()) {
            n lp = p.lp(atVar.field_imgPath);
            if (lp != null && lp.status == 199 && ad.a(aVar2.onh, atVar.field_msgId)) {
                if (eeVar.okm != null) {
                    eeVar.okm.setVisibility(0);
                }
            } else if (eeVar.okm != null) {
                eeVar.okm.setVisibility(8);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            int i = ((dl) view.getTag()).position;
            n kZ = k.KV().kZ(atVar.field_imgPath);
            contextMenu.add(i, 129, 0, view.getContext().getString(2131231833));
            if (kZ != null) {
                int i2 = kZ.status;
                if (!(MMGIFException.D_GIF_ERR_NO_SCRN_DSCR == i2 || MMGIFException.D_GIF_ERR_NOT_GIF_FILE == i2 || MMGIFException.D_GIF_ERR_NO_IMAG_DSCR == i2 || MMGIFException.D_GIF_ERR_NO_COLOR_MAP == i2)) {
                    contextMenu.add(i, MMGIFException.D_GIF_ERR_WRONG_RECORD, 0, view.getContext().getString(2131234555));
                }
            }
            if (kZ != null && (kZ.status == 199 || kZ.status == 199)) {
                if (com.tencent.mm.ay.c.EH("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
                }
                b cpVar = new cp();
                cpVar.bay.bao = atVar.field_msgId;
                com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                if (cpVar.baz.aZW) {
                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
                }
                if (!atVar.bvZ() && ((atVar.bwn() || atVar.bwo()) && ad.bEz() && ((kZ.status == 199 || kZ.status == 199 || atVar.bNs == 1) && ad.OI(atVar.field_talker)))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
                }
                if (e.Dh() && !this.onG.bFL()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
                }
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
