package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class bc extends c {
    private a onG;
    private String ooA;

    public bc() {
        super(13);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903347);
        view.setTag(new u(this.eKg).o(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        aVar = (u) aVar;
        ak.yW();
        at.a MU = com.tencent.mm.model.c.wJ().MU(atVar.field_content);
        if (MU.lct == null || MU.lct.length() <= 0) {
            v.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.ooA = MU.lct;
        v.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", Boolean.valueOf(m.eD(this.ooA)), this.ooA);
        if (m.eG(MU.ldy)) {
            aVar.olK.setText(2131231764);
            aVar.olL.setVisibility(8);
            if (d.dW(16)) {
                aVar.olJ.setBackground(null);
            } else {
                aVar.olJ.setBackgroundDrawable(null);
            }
            ad.r(aVar.olJ, this.ooA);
        } else {
            aVar.olK.setText(2131231855);
            aVar.olJ.setBackgroundResource(2130838080);
            ad.q(aVar.olJ, this.ooA);
        }
        aVar.euh.setText(e.a(aVar2.nDR.nEl, MU.cID, aVar.euh.getTextSize()));
        if (t.kS(u.a(MU))) {
            aVar.olL.setVisibility(8);
        } else {
            aVar.olL.setVisibility(0);
            aVar.olL.setText(u.a(MU));
        }
        aVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        aVar.onC.setOnClickListener(aVar2.onh.oqh);
        aVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        if (ad.bEA()) {
            if (aVar.ieT != null) {
                aVar.ieT.setVisibility(8);
            }
            if (atVar.field_status == 2 && ad.a(aVar2.onh, atVar.field_msgId)) {
                if (aVar.okm != null) {
                    aVar.okm.setVisibility(0);
                }
            } else if (aVar.okm != null) {
                aVar.okm.setVisibility(8);
            }
        } else if (aVar.ieT != null) {
            aVar.ieT.setVisibility(0);
            if (atVar.field_status >= 2) {
                aVar.ieT.setVisibility(8);
            }
        }
        ad.a(i, aVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        ak.yW();
        at.a MU = com.tencent.mm.model.c.wJ().MU(atVar.field_content);
        if (MU.lct == null || MU.lct.length() <= 0) {
            v.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.ooA = MU.lct;
        if (m.eD(this.ooA)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(2131234555));
        }
        if (!atVar.bvZ() && ((atVar.field_status == 2 || atVar.bNs == 1) && atVar.bwk() && ad.bEz() && ad.OI(atVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
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
