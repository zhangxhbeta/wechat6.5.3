package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.e.a.gy;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class al extends c {
    private a onG;

    public al() {
        super(62);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof f) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903348);
        view.setTag(new f(this.eKg).n(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a B;
        this.onG = aVar2;
        f fVar = (f) aVar;
        String str2 = atVar.field_content;
        if (str2 != null) {
            B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        } else {
            B = null;
        }
        fVar.a(aVar2.nDR.nEl, B, atVar.field_imgPath, this.lVu);
        aVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        aVar.onC.setOnClickListener(aVar2.onh.oqh);
        if (this.lVu) {
            aVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        String str = atVar.field_content;
        if (str == null) {
            return true;
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(str, atVar.field_isSend));
        if (dV == null) {
            return true;
        }
        switch (dV.type) {
            case 16:
                if (dV.cpo == 5 || dV.cpo == 6 || dV.cpo == 2) {
                    if (dV.cpo != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
                    return false;
                }
            case 34:
                contextMenu.clear();
                contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
                return false;
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        com.tencent.mm.q.a.a aVar2;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = atVar.field_content;
                aVar2 = null;
                if (str2 != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str2);
                }
                if (aVar2 != null) {
                    l.GB(aVar2.aXa);
                }
                aw.L(atVar.field_msgId);
                break;
            case MMGIFException.D_GIF_ERR_NOT_GIF_FILE /*103*/:
                str = atVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                b gyVar = new gy();
                                gyVar.bgC.bgD = aVar2.bgD;
                                gyVar.bgC.aYG = atVar.field_msgId;
                                gyVar.bgC.bgE = atVar.field_talker;
                                com.tencent.mm.sdk.c.a.nhr.z(gyVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                str = aVar.cf(atVar.field_content, atVar.field_isSend);
                Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", str);
                aVar2 = com.tencent.mm.q.a.a.dV(str);
                if (aVar2 == null || 16 != aVar2.type) {
                    intent.putExtra("Retr_Msg_Type", 2);
                } else {
                    intent.putExtra("Retr_Msg_Type", 14);
                }
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        String str = atVar.field_content;
        if (str == null) {
            return false;
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
        if (dV == null) {
            return false;
        }
        Intent intent;
        switch (dV.type) {
            case 16:
                if (be.kS(dV.bgD)) {
                    return false;
                }
                intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_card_app_msg", dV.bgD);
                intent.putExtra("key_from_scene", dV.cpo);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "card", ".ui.CardDetailUI", intent);
                return true;
            case 34:
                intent = new Intent();
                intent.putExtra("key_from_user_name", a(aVar, atVar));
                intent.putExtra("key_biz_uin", dV.cpq);
                intent.putExtra("key_order_id", dV.cpr);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "card", ".ui.CardGiftAcceptUI", intent);
                return true;
            default:
                return false;
        }
    }
}
