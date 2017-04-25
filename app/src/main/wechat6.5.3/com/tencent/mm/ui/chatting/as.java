package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;

final class as extends b {
    private a onG;

    public as() {
        super(53);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof j) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903314);
        view.setTag(new j(this.eKg).cJ(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a B;
        this.onG = aVar2;
        j jVar = (j) aVar;
        String str2 = atVar.field_content;
        if (str2 != null) {
            B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            jVar.okw.setSingleLine(true);
            switch (B.cpe) {
                case 1:
                case 7:
                    if (t.kS(B.cqf)) {
                        jVar.okw.setText(2131231810);
                    } else {
                        jVar.okw.setText(e.a(aVar2.nDR.nEl, B.cqf));
                    }
                    jVar.okx.setText(B.cpf);
                    jVar.okv.setImageResource(2131165358);
                    break;
                case 3:
                    jVar.okw.setText(2131231803);
                    jVar.okx.setText(B.cpf);
                    jVar.okv.setImageResource(2131165359);
                    break;
                case 4:
                    jVar.okw.setText(2131231811);
                    jVar.okx.setText(B.cpf);
                    jVar.okv.setImageResource(2131165360);
                    break;
                case 5:
                    jVar.okw.setText(2131231808);
                    jVar.okx.setText(B.cpf);
                    jVar.okv.setImageResource(2131165359);
                    break;
                case 6:
                    jVar.okw.setText(2131231804);
                    jVar.okx.setText(B.cpf);
                    jVar.okv.setImageResource(2131165357);
                    break;
                default:
                    jVar.okv.setImageResource(2131165358);
                    jVar.okw.setSingleLine(false);
                    jVar.okw.setMaxLines(2);
                    jVar.okx.setText(null);
                    jVar.okw.setText(B.description);
                    break;
            }
            jVar.onC.setOnClickListener(aVar2.onh.oqh);
            jVar.onC.setOnLongClickListener(aVar2.onh.oqj);
            jVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        if (atVar != null) {
            contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
        }
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
        com.tencent.mm.q.a.a aVar2 = null;
        if (str != null) {
            aVar2 = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
        }
        if (aVar2 == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sender_name", atVar.field_talker);
        switch (aVar2.cpe) {
            case 1:
            case 7:
                intent.putExtra("invalid_time", aVar2.cpi);
                intent.putExtra("is_sender", false);
                intent.putExtra("appmsg_type", aVar2.cpe);
                intent.putExtra("transfer_id", aVar2.cph);
                intent.putExtra("transaction_id", aVar2.cpg);
                intent.putExtra("effective_date", aVar2.cpj);
                intent.putExtra("total_fee", aVar2.cpk);
                intent.putExtra("fee_type", aVar2.cpl);
                if (k.xT()) {
                    c.a((Fragment) aVar, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221);
                    return true;
                }
                c.a((Fragment) aVar, "remittance", ".ui.RemittanceDetailUI", intent, 221);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                intent.putExtra("is_sender", true);
                intent.putExtra("appmsg_type", aVar2.cpe);
                intent.putExtra("transfer_id", aVar2.cph);
                intent.putExtra("transaction_id", aVar2.cpg);
                intent.putExtra("effective_date", aVar2.cpj);
                intent.putExtra("total_fee", aVar2.cpk);
                intent.putExtra("fee_type", aVar2.cpl);
                if (k.xT()) {
                    c.b(aVar.nDR.nEl, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                    return true;
                }
                c.b(aVar.nDR.nEl, "remittance", ".ui.RemittanceDetailUI", intent);
                return true;
            default:
                v.d("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type, probably version to low & check update!");
                t.bn(aVar.nDR.nEl);
                return true;
        }
    }
}
