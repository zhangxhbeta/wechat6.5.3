package com.tencent.mm.ui.chatting;

import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mmdb.database.SQLiteDatabase;

final class bh extends c {
    private a onG;

    public bh() {
        super(15);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903349);
        view.setTag(new dg(this.eKg).o(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        aVar = (dg) aVar;
        com.tencent.mm.storage.a.c rg = j.a.bmr().rg(atVar.field_imgPath);
        if (rg != null) {
            ag Mv = ag.Mv(atVar.field_content);
            aVar.okk.a(rg, atVar.field_msgId, Mv);
            if (aVar.oxD != null) {
                if (Mv.nuZ) {
                    aVar.oxD.setVisibility(0);
                    TextView textView = (TextView) aVar.kad.findViewById(2131756262).findViewById(2131756264);
                    textView.setText(Html.fromHtml(aVar2.getString(2131232327)));
                    ImageView imageView = (ImageView) aVar.kad.findViewById(2131756262).findViewById(2131756265);
                    TextView textView2 = textView;
                    textView2.setTag(new dl(atVar, false, i, aVar2.onh.cyO, 8, false, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, rg.field_groupId, SQLiteDatabase.KeyEmpty, true, false));
                    textView.setOnClickListener(aVar2.onh.oqh);
                    if (j.a.bmr().afa()) {
                        imageView.setVisibility(0);
                        ImageView imageView2 = imageView;
                        imageView2.setTag(new dl(atVar, aVar2.nQK, i, aVar2.onh.cyO, 11, (byte) 0));
                        imageView.setOnClickListener(aVar2.onh.oqh);
                    } else {
                        imageView.setVisibility(8);
                    }
                } else {
                    aVar.oxD.setVisibility(8);
                }
            }
            if (rg.bnk() && !Mv.dhD) {
                Mv.dhD = true;
                atVar.setContent(Mv.bvQ());
                ak.yW();
                atVar.dh(com.tencent.mm.model.c.wJ().ek(atVar.field_msgId).field_status);
                ak.yW();
                com.tencent.mm.model.c.wJ().T(atVar);
            }
            if (ad.bEA()) {
                aVar.ieT.setVisibility(8);
                if (atVar != null && atVar.field_status == 2 && ad.a(aVar2.onh, atVar.field_msgId)) {
                    if (aVar.okm != null) {
                        aVar.okm.setVisibility(0);
                    }
                } else if (aVar.okm != null) {
                    aVar.okm.setVisibility(8);
                }
            } else {
                if (aVar.okm != null) {
                    aVar.okm.setVisibility(8);
                }
                if (aVar.ieT != null) {
                    aVar.ieT.setVisibility(0);
                    if (atVar.field_status >= 2) {
                        aVar.ieT.setVisibility(8);
                    }
                }
            }
        }
        aVar.okk.setTag(new dl(atVar, aVar2.nQK, i, aVar2.onh.cyO, 0, (byte) 0));
        aVar.okk.setOnClickListener(aVar2.onh.oqh);
        aVar.okk.setOnLongClickListener(aVar2.onh.oqj);
        ad.a(i, aVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        if (atVar.bwp()) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int i = ((dl) view.getTag()).position;
                com.tencent.mm.storage.a.c rg = j.a.bmr().rg(atVar.field_imgPath);
                if (rg == null) {
                    String str;
                    String str2 = "MicroMsg.emoji.ChattingItemEmojiTo";
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
                    if (!(rg.field_catalog == com.tencent.mm.storage.a.c.nwR || rg.bxG())) {
                        if (bxE) {
                            contextMenu.add(i, MMGIFException.D_GIF_ERR_NO_SCRN_DSCR, 0, view.getContext().getString(2131231837));
                        } else {
                            v.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (rg.field_catalog == com.tencent.mm.storage.a.c.nwR || be.kS(rg.field_groupId) || (!be.kS(rg.field_groupId) && j.a.bmr().rl(rg.field_groupId))) {
                        if (bxE) {
                            contextMenu.add(i, MMGIFException.D_GIF_ERR_EOF_TOO_SOON, 0, 2131234555);
                        } else {
                            v.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (!(be.kS(rg.field_groupId) || rg.bnk())) {
                        contextMenu.add(i, 127, 0, 2131231839);
                    }
                    if (!this.onG.bFL()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(2131231827));
                    }
                    if (!atVar.bvZ() && atVar.bwp() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
                    }
                    if (atVar.field_status == 5) {
                        contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, view.getContext().getString(2131231874));
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
