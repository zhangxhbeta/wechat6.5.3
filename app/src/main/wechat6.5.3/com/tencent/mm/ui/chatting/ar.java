package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ar extends c {
    private a onG;

    public ar() {
        super(49);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof i) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903344);
        view.setTag(new i(this.eKg).cI(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a B;
        i iVar = (i) aVar;
        this.onG = aVar2;
        String str2 = atVar.field_content;
        if (str2 != null) {
            B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            iVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
            iVar.onC.setOnClickListener(aVar2.onh.oqh);
            if (this.lVu) {
                iVar.onC.setOnLongClickListener(aVar2.onh.oqj);
            }
            iVar.oku.setText(B.title);
        }
        if (j.a.lxQ == null || !j.a.lxQ.vJ(aVar2.bEn())) {
            iVar.oku.setTextColor(-8750470);
            iVar.onC.setClickable(false);
            iVar.onC.setEnabled(false);
            return;
        }
        iVar.oku.setTextColor(aVar2.bzo().getResources().getColor(2131689909));
        iVar.onC.setClickable(true);
        iVar.onC.setEnabled(true);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        l.GC(this.onG.cf(atVar.field_content, atVar.field_isSend));
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(atVar.field_content, atVar.field_isSend));
        f aC = g.aC(dV.appId, false);
        if (com.tencent.mm.ay.c.EH("favorite") && (aC == null || !aC.bnk())) {
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
        if (!atVar.bvZ() && atVar.bwl() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
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
