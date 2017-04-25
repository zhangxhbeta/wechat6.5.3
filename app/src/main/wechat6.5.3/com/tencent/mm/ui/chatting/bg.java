package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.database.SQLiteDatabase;

final class bg extends b {
    private a onG;

    public bg() {
        super(14);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903318);
        view.setTag(new dg(this.eKg).o(view, true));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        c rg = j.a.bmr().rg(atVar.field_imgPath);
        dg dgVar = (dg) aVar;
        if (rg != null) {
            ag Mv = ag.Mv(atVar.field_content);
            dgVar.okk.a(rg, atVar.field_msgId, Mv);
            if (rg.bnk() && !Mv.dhD) {
                Mv.dhD = true;
                atVar.setContent(Mv.bvQ());
                ak.yW();
                com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
            }
        }
        dgVar.okk.setTag(new dl(atVar, aVar2.nQK, i, str, 0, (byte) 0));
        dgVar.okk.setOnClickListener(aVar2.onh.oqh);
        dgVar.okk.setOnLongClickListener(aVar2.onh.oqj);
    }

    protected final boolean a(a aVar) {
        return aVar.nQK;
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        if (atVar.bwp()) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int i = ((dl) view.getTag()).position;
                c rg = j.a.bmr().rg(atVar.field_imgPath);
                if (rg == null) {
                    String str;
                    String str2 = "MicroMsg.emoji.ChattingItemEmojiFrom";
                    String str3 = "emoji is null. md5:%s";
                    Object[] objArr = new Object[1];
                    if (atVar == null) {
                        str = SQLiteDatabase.KeyEmpty;
                    } else {
                        str = atVar.field_imgPath;
                    }
                    objArr[0] = str;
                    v.w(str2, str3, objArr);
                } else {
                    boolean bxE = rg.bxE();
                    if (!(rg.field_catalog == c.nwR || rg.bxG())) {
                        if (bxE) {
                            contextMenu.add(i, MMGIFException.D_GIF_ERR_NO_SCRN_DSCR, 0, view.getContext().getString(2131231837));
                        } else {
                            v.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (rg.field_catalog == c.nwR || be.kS(rg.field_groupId) || (!be.kS(rg.field_groupId) && j.a.bmr().rl(rg.field_groupId))) {
                        if (bxE) {
                            contextMenu.add(i, MMGIFException.D_GIF_ERR_EOF_TOO_SOON, 0, 2131234555);
                        } else {
                            v.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (!(be.kS(rg.field_groupId) || rg.bnk())) {
                        contextMenu.add(i, 127, 0, 2131231839);
                    }
                    if (!this.onG.bFL()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(2131231827));
                    }
                    g.iuh.h(12789, Integer.valueOf(0), rg.EB(), Integer.valueOf(0), rg.field_designerID, rg.field_groupId);
                }
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
