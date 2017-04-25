package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;

final class an extends c {
    private a onG;

    public an() {
        super(23);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903342);
        view.setTag(new g(this.eKg).o(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.storage.a.c cVar = null;
        this.onG = aVar2;
        aVar2.ay(atVar);
        aVar = (g) aVar;
        if (atVar != null) {
            com.tencent.mm.storage.a.c cVar2;
            String str2 = atVar.field_content;
            ag Mv = ag.Mv(atVar.field_content);
            if (!Mv.dhD) {
                com.tencent.mm.q.a.a B;
                if (str2 != null) {
                    B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
                } else {
                    B = null;
                }
                if (B != null) {
                    cVar = j.a.bmr().rg(B.cod);
                }
            }
            if (Mv.aZy == null || Mv.aZy.equals("-1") || cVar != null) {
                cVar2 = cVar;
            } else {
                cVar2 = j.a.bmr().rg(Mv.aZy);
            }
            if (cVar2 != null) {
                aVar.okk.a(cVar2, atVar.field_msgId);
                RTChattingEmojiView rTChattingEmojiView = aVar.okk;
                if (rTChattingEmojiView.lPa != null) {
                    rTChattingEmojiView.lPa.resume();
                }
                int i2 = (cVar2.field_state == com.tencent.mm.storage.a.c.nxa || atVar.field_status != 1) ? true : 0;
                ProgressBar progressBar = aVar.ieT;
                if (i2 != 0) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
                progressBar.setVisibility(i2);
                ad.t(cVar2);
            } else {
                String w = n.GH().w(atVar.field_imgPath, true);
                Bitmap jh = n.GL().jh(w);
                if (jh == null || jh.isRecycled()) {
                    jh = n.GH().a(w, com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl));
                    n.GL().h(w, jh);
                }
                if (jh != null) {
                    aVar.okk.setImageBitmap(jh);
                }
                aVar.ieT.setVisibility(8);
            }
            if (ad.bEA()) {
                if (atVar != null && atVar.field_status == 2 && ad.a(aVar2.onh, atVar.field_msgId)) {
                    if (aVar.okm != null) {
                        aVar.okm.setVisibility(0);
                    }
                } else if (aVar.okm != null) {
                    aVar.okm.setVisibility(8);
                }
            }
            aVar.okk.setTag(new dl(atVar, aVar2.nQK, i, aVar2.onh.cyO, 0, (byte) 0));
            aVar.okk.setOnClickListener(aVar2.onh.oqh);
            aVar.okk.setOnLongClickListener(aVar2.onh.oqj);
            ad.a(i, aVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            int i = ((dl) view.getTag()).position;
            ag Mv = ag.Mv(atVar.field_content);
            com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(atVar.field_content, atVar.field_reserved);
            if (B == null) {
                B = new com.tencent.mm.q.a.a();
                B.cod = Mv.aZy;
            }
            if (!(t.kS(B.cod) || B.cod.equals("-1"))) {
                com.tencent.mm.storage.a.c rg = j.a.bmr().rg(B.cod);
                if (!(rg.field_catalog == com.tencent.mm.storage.a.c.nwR || rg.bxG())) {
                    contextMenu.add(i, MMGIFException.D_GIF_ERR_NO_SCRN_DSCR, 0, view.getContext().getString(2131231837));
                }
                if (rg != null) {
                    g.iuh.h(12789, Integer.valueOf(0), rg.EB(), Integer.valueOf(0), rg.field_designerID, rg.field_groupId);
                }
                boolean bxE = rg.bxE();
                if (rg.field_catalog == com.tencent.mm.storage.a.c.nwR || be.kS(rg.field_groupId) || (!be.kS(rg.field_groupId) && j.a.bmr().rl(rg.field_groupId))) {
                    if (bxE) {
                        contextMenu.add(i, MMGIFException.D_GIF_ERR_EOF_TOO_SOON, 0, 2131234555);
                    } else {
                        v.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                    }
                }
            }
            if (atVar.field_status == 5) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, view.getContext().getString(2131231874));
            }
            if (!atVar.bvZ() && atVar.bwq() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231827));
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
