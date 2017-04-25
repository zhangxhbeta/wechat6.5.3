package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.database.SQLiteDatabase;

final class av extends c {
    a onG;

    public av() {
        super(23);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof m) && ((m) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903346);
        view.setTag(new k(this.eKg).cK(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a B;
        k kVar = (k) aVar;
        this.onG = aVar2;
        aVar2.ay(atVar);
        String str2 = atVar.field_content;
        if (str2 != null) {
            B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null && B.type == 1) {
            kVar.eTf.setText(B.title);
            e.e(kVar.eTf, 1);
            f aC = g.aC(B.appId, true);
            String str3 = (aC == null || aC.field_appName == null || aC.field_appName.trim().length() <= 0) ? B.appName : aC.field_appName;
            if (B.appId == null || B.appId.length() <= 0 || !g.bo(str3)) {
                kVar.fSs.setVisibility(8);
            } else {
                kVar.fSs.setText(aVar2.getString(2131231902, g.a(aVar2.nDR.nEl, aC, str3)));
                kVar.fSs.setVisibility(0);
                ad.a(aVar2, kVar.fSs, B.appId);
                ad.a(aVar2, kVar.fSs, B.appId);
            }
            if (atVar.field_status == 2 || atVar.field_status == 5) {
                kVar.ieT.setVisibility(8);
            } else {
                kVar.ieT.setVisibility(0);
            }
            ad.a(i, (ad.a) kVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
        }
        kVar.eTf.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        kVar.eTf.setOnClickListener(aVar2.onh.oqh);
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            kVar.eTf.setOnLongClickListener(aVar2.onh.oqj);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_READABLE, 0, this.onG.getString(2131234555));
        if (com.tencent.mm.ay.c.EH("favorite")) {
            contextMenu.add(i, 116, 0, this.onG.getString(2131234180));
        }
        if (!atVar.bvZ() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
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
                aw.L(atVar.field_msgId);
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
                break;
            case MMGIFException.D_GIF_ERR_READ_FAILED /*102*/:
                ((ClipboardManager) aVar.nDR.nEl.getSystemService("clipboard")).setText(aVar.cf(com.tencent.mm.q.a.a.dV(atVar.field_content).title, atVar.field_isSend));
                break;
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", atVar.field_content);
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, final at atVar) {
        if (((dl) view.getTag()).eKg != 5 || atVar.field_isSend != 1) {
            return false;
        }
        if (atVar != null) {
            com.tencent.mm.ui.base.g.b(this.onG.nDR.nEl, this.onG.getString(2131231873), SQLiteDatabase.KeyEmpty, this.onG.getString(2131231143), this.onG.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ av ooa;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.L(atVar);
                    aw.L(atVar.field_msgId);
                    this.ooa.onG.bFI();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ av ooa;

                {
                    this.ooa = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return true;
    }
}
