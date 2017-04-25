package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import java.util.Map;

final class af extends b {
    private a onG;
    private final int onH = 1;

    public af() {
        super(63);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof e) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903310);
        view.setTag(new e(this.eKg).cG(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a B;
        this.onG = aVar2;
        String str2 = atVar.field_content;
        if (str2 != null) {
            B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        } else {
            B = null;
        }
        e eVar = (e) aVar;
        if (B != null) {
            eVar.okc.setText(atVar.field_isSend == 1 ? B.cpF : B.cpG);
        }
        aVar.onC.setOnClickListener(aVar2.onh.oqh);
        aVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        aVar.onC.setTag(new dl(atVar, this.onG.nQK, i, null, 0, (byte) 0));
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        contextMenu.add(((dl) view.getTag()).position, 100, 0, this.onG.getString(2131231829));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        switch (menuItem.getItemId()) {
            case 100:
                aw.L(atVar.field_msgId);
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, at atVar) {
        String str = atVar.field_content;
        if (str != null) {
            com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
            if (!be.kS(B.cpK)) {
                Intent intent;
                if (B.cpL == 1) {
                    v.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick hasplay, skip");
                    intent = new Intent();
                    intent.putExtra("key_native_url", B.cpK);
                    intent.putExtra("key_username", aVar.bEn());
                    intent.putExtra("key_image_id", B.cpN);
                    intent.putExtra("key_image_aes_key", B.cpO);
                    intent.putExtra("key_image_length", B.cpP);
                    c.b(aVar.nDR.nEl, "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                } else {
                    v.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
                    intent = new Intent();
                    intent.putExtra("key_native_url", B.cpK);
                    intent.putExtra("key_username", aVar.bEn());
                    intent.putExtra("key_image_id", B.cpN);
                    intent.putExtra("key_image_aes_key", B.cpO);
                    intent.putExtra("key_image_length", B.cpP);
                    c.b(aVar.nDR.nEl, "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                    B.cpL = 1;
                    atVar.setContent(com.tencent.mm.q.a.a.b(B));
                    if (atVar != null && atVar.bvY()) {
                        try {
                            str = atVar.field_content;
                            int indexOf = str.indexOf("<msg>");
                            if (indexOf > 0 && indexOf < str.length()) {
                                str = str.substring(indexOf).trim();
                            }
                            Map q = bf.q(str, "msg");
                            if (q != null && q.size() > 0) {
                                atVar.cJ(au.U(q));
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", e.getMessage());
                        }
                    }
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
                }
            }
        }
        return true;
    }
}
