package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class aq extends b {
    private a onG;

    public aq() {
        super(48);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof i) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903313);
        view.setTag(new i(this.eKg).cI(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        String substring;
        String str2;
        String str3;
        Object[] objArr;
        com.tencent.mm.q.a.a aVar3;
        i iVar = (i) aVar;
        this.onG = aVar2;
        com.tencent.mm.q.a dz = am.bnC().dz(atVar.field_msgId);
        String str4 = atVar.field_content;
        if (aVar2.onl) {
            int indexOf = atVar.field_content.indexOf(58);
            if (indexOf != -1) {
                substring = atVar.field_content.substring(indexOf + 1);
                if (dz != null || substring == null) {
                    str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
                    str3 = "amessage:%b, %s, %s";
                    objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(dz != null);
                    objArr[1] = substring;
                    objArr[2] = Long.valueOf(atVar.field_msgId);
                    objArr[3] = str;
                    v.e(str2, str3, objArr);
                    aVar3 = null;
                } else {
                    aVar3 = com.tencent.mm.q.a.a.B(substring, atVar.field_reserved);
                }
                if (aVar3 != null) {
                    iVar.oku.setText(aVar3.title);
                    iVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
                    iVar.onC.setOnClickListener(aVar2.onh.oqh);
                    if (this.lVu) {
                        iVar.onC.setOnLongClickListener(aVar2.onh.oqj);
                    }
                }
                if (j.a.lxQ == null && j.a.lxQ.vJ(aVar2.bEn())) {
                    iVar.oku.setTextColor(aVar2.bzo().getResources().getColor(2131689909));
                    iVar.onC.setClickable(true);
                    iVar.onC.setEnabled(true);
                    return;
                }
                iVar.oku.setTextColor(-8750470);
                iVar.onC.setClickable(false);
                iVar.onC.setEnabled(false);
            }
        }
        substring = str4;
        if (dz != null) {
        }
        str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
        str3 = "amessage:%b, %s, %s";
        objArr = new Object[4];
        if (dz != null) {
        }
        objArr[0] = Boolean.valueOf(dz != null);
        objArr[1] = substring;
        objArr[2] = Long.valueOf(atVar.field_msgId);
        objArr[3] = str;
        v.e(str2, str3, objArr);
        aVar3 = null;
        if (aVar3 != null) {
            iVar.oku.setText(aVar3.title);
            iVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
            iVar.onC.setOnClickListener(aVar2.onh.oqh);
            if (this.lVu) {
                iVar.onC.setOnLongClickListener(aVar2.onh.oqj);
            }
        }
        if (j.a.lxQ == null) {
        }
        iVar.oku.setTextColor(-8750470);
        iVar.onC.setClickable(false);
        iVar.onC.setEnabled(false);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        l.GC(this.onG.cf(atVar.field_content, atVar.field_isSend));
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(atVar.field_content, atVar.field_isSend));
        f aC = g.aC(dV.appId, false);
        if (c.EH("favorite") && (aC == null || !aC.bnk())) {
            switch (dV.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 20:
                    contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
                    break;
            }
        }
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = atVar.field_content;
                com.tencent.mm.q.a.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str);
                }
                if (aVar2 != null) {
                    l.GB(aVar2.aXa);
                    aw.L(atVar.field_msgId);
                    f aC = g.aC(aVar2.appId, false);
                    if (aC != null && aC.bnk()) {
                        ad.a(aVar, aVar2, atVar, aC);
                        break;
                    }
                }
                break;
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.cf(atVar.field_content, atVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        aVar.bEn();
        aVar.aQ("fromMessage", true);
        return true;
    }
}
