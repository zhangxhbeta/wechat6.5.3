package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class bb extends b {
    private a onG;
    private String ooA;

    public bb() {
        super(12);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903316);
        view.setTag(new u(this.eKg).o(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.nQK;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        String fM;
        this.onG = aVar2;
        u uVar = (u) aVar;
        if (aVar2.nQK) {
            fM = aw.fM(atVar.field_content);
        } else {
            fM = atVar.field_content;
        }
        ak.yW();
        at.a MU = c.wJ().MU(fM);
        if (MU.lct == null || MU.lct.length() <= 0) {
            v.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.ooA = MU.lct;
        com.tencent.mm.u.b.r(this.ooA, MU.nvF);
        if (m.eG(MU.ldy)) {
            uVar.olK.setText(2131231764);
            uVar.olL.setVisibility(8);
            if (d.dW(16)) {
                uVar.olJ.setBackground(null);
            } else {
                uVar.olJ.setBackgroundDrawable(null);
            }
            ad.r(uVar.olJ, this.ooA);
        } else {
            uVar.olK.setText(2131231855);
            uVar.olJ.setBackgroundResource(2130838080);
            ad.q(uVar.olJ, this.ooA);
        }
        if (t.kS(u.a(MU))) {
            uVar.olL.setVisibility(8);
        } else {
            uVar.olL.setVisibility(0);
            uVar.olL.setText(u.a(MU));
        }
        uVar.euh.setText(e.a(aVar2.nDR.nEl, MU.cID, (int) uVar.euh.getTextSize()));
        uVar.onC.setTag(new dl(atVar, aVar2.nQK, i, str, 0, (byte) 0));
        uVar.onC.setOnClickListener(aVar2.onh.oqh);
        uVar.onC.setOnLongClickListener(aVar2.onh.oqj);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        ak.yW();
        at.a MU = c.wJ().MU(atVar.field_content);
        if (MU.lct == null || MU.lct.length() <= 0) {
            v.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.ooA = MU.lct;
        if (m.eD(this.ooA)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(2131234555));
        }
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        switch (menuItem.getItemId()) {
            case 118:
                Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.cf(atVar.field_content, atVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 8);
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }
}
