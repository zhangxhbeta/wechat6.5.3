package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ae.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import java.lang.ref.WeakReference;

final class am extends b {
    private a onG;

    public am() {
        super(22);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903311);
        view.setTag(new g(this.eKg).o(view, true));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a B;
        c cVar;
        this.onG = aVar2;
        aVar2.ay(atVar);
        g gVar = (g) aVar;
        String str2 = atVar.field_content;
        if (str2 != null) {
            B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B == null || B.cod == null) {
            cVar = null;
        } else {
            cVar = j.a.bmr().rg(B.cod);
        }
        if (cVar == null || !cVar.bxE()) {
            String w = n.GH().w(atVar.field_imgPath, true);
            Bitmap jh = n.GL().jh(w);
            if (jh == null || jh.isRecycled()) {
                jh = n.GH().a(w, com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl));
                n.GL().h(w, jh);
            }
            if (cVar == null) {
                gVar.oko.setVisibility(0);
                gVar.okn.setVisibility(8);
                gVar.okp.setText(t.aw((long) B.cob));
                gVar.okp.setVisibility(0);
                gVar.oko.setImageResource(2130838149);
            } else {
                gVar.okn.setVisibility(0);
                gVar.okp.setVisibility(8);
                gVar.oko.setVisibility(8);
                gVar.okn.setProgress(0);
                gVar.okp.setVisibility(8);
            }
            if (!(B == null || be.kS(B.cod))) {
                g.okq.put(B.cod, new WeakReference(gVar));
            }
            if (jh == null || jh.isRecycled()) {
                jh = d.s(this.onG.getResources().getDrawable(2130837666));
            }
            gVar.okk.setImageBitmap(jh);
        } else {
            gVar.okk.a(cVar, atVar.field_msgId);
            gVar.oko.setVisibility(8);
            gVar.okn.setVisibility(8);
            gVar.okp.setVisibility(8);
            gVar.oko.setVisibility(8);
            if (!(B == null || be.kS(B.cod))) {
                g.okq.remove(B.cod);
            }
            ad.t(cVar);
        }
        gVar.okk.setTag(new dl(atVar, aVar2.nQK, i, str, 0, (byte) 0));
        gVar.okk.setOnClickListener(aVar2.onh.oqh);
        gVar.okk.setOnLongClickListener(aVar2.onh.oqj);
        gVar.oko.setOnClickListener(aVar2.onh.oqh);
        gVar.oko.setOnClickListener(aVar2.onh.oqh);
        gVar.oko.setOnLongClickListener(aVar2.onh.oqj);
        gVar.oko.setTag(gVar.okk.getTag());
    }

    protected final boolean a(a aVar) {
        return aVar.nQK;
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        ag Mv = ag.Mv(atVar.field_content);
        com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(atVar.field_content, atVar.field_reserved);
        if (B == null) {
            B = new com.tencent.mm.q.a.a();
            B.cod = Mv.aZy;
        }
        if (!(t.kS(B.cod) || B.cod.equals("-1"))) {
            c rg = j.a.bmr().rg(B.cod);
            if (rg != null) {
                if (!(rg.field_catalog == c.nwR || rg.bxG())) {
                    contextMenu.add(i, MMGIFException.D_GIF_ERR_NO_SCRN_DSCR, 0, view.getContext().getString(2131231837));
                }
                if (rg != null) {
                    g.iuh.h(12789, Integer.valueOf(0), rg.EB(), Integer.valueOf(0), rg.field_designerID, rg.field_groupId);
                }
                boolean bxE = rg.bxE();
                if (rg.field_catalog == c.nwR || be.kS(rg.field_groupId) || (!be.kS(rg.field_groupId) && j.a.bmr().rl(rg.field_groupId))) {
                    if (bxE) {
                        contextMenu.add(i, MMGIFException.D_GIF_ERR_EOF_TOO_SOON, 0, 2131234555);
                    } else {
                        v.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                    }
                }
            }
        }
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(2131231827));
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
