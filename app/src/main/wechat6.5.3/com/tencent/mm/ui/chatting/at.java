package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;

final class at extends c {
    private a onG;

    public at() {
        super(54);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof j) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903345);
        view.setTag(new j(this.eKg).cJ(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, com.tencent.mm.storage.at atVar, String str) {
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
                    ak.yW();
                    com.tencent.mm.i.a LW = com.tencent.mm.model.c.wH().LW(atVar.field_talker);
                    if (LW != null) {
                        str2 = LW.tU();
                    } else {
                        str2 = atVar.field_talker;
                    }
                    if (t.kS(B.cqf)) {
                        jVar.okw.setText(e.a(aVar2.nDR.nEl, aVar2.getString(2131231809, t.ma(str2)), jVar.okw.getTextSize()));
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
            jVar.onC.setTag(new dl(atVar, this.onG.nQK, i, null, 0, (byte) 0));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, com.tencent.mm.storage.at atVar) {
        int i = ((dl) view.getTag()).position;
        String str = atVar.field_content;
        com.tencent.mm.q.a.a aVar = null;
        if (str != null) {
            aVar = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
        }
        if (aVar != null) {
            contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
            if (aVar.cpe == 1) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, this.onG.getString(2131234537));
            }
        }
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, com.tencent.mm.storage.at atVar) {
        switch (menuItem.getItemId()) {
            case 100:
                aw.L(atVar.field_msgId);
                return true;
            case MMGIFException.D_GIF_ERR_NOT_GIF_FILE /*103*/:
                String str = atVar.field_content;
                com.tencent.mm.q.a.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
                }
                if (aVar2 != null) {
                    final String str2 = aVar2.cpg;
                    final String str3 = atVar.field_talker;
                    final int i = aVar2.cpi;
                    final int i2 = aVar2.cpk;
                    final String str4 = aVar2.cpl;
                    Context context = aVar.nDR.nEl;
                    String string = aVar.getString(2131234483);
                    String string2 = aVar.getString(2131231139);
                    String string3 = aVar.getString(2131234537);
                    String string4 = aVar.getString(2131231010);
                    final a aVar3 = aVar;
                    AnonymousClass1 anonymousClass1 = new OnClickListener(this) {
                        final /* synthetic */ at onZ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("transaction_id", str2);
                            intent.putExtra("receiver_name", str3);
                            intent.putExtra("resend_msg_from_flag", 2);
                            intent.putExtra("invalid_time", i);
                            intent.putExtra("total_fee", i2);
                            intent.putExtra("fee_type", str4);
                            if (k.xT()) {
                                com.tencent.mm.ay.c.b(aVar3.bzo(), "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
                            } else {
                                com.tencent.mm.ay.c.b(aVar3.bzo(), "remittance", ".ui.RemittanceResendMsgUI", intent);
                            }
                        }
                    };
                    g.b(context, string, string2, string3, string4, (OnClickListener) anonymousClass1, new OnClickListener(this) {
                        final /* synthetic */ at onZ;

                        {
                            this.onZ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, com.tencent.mm.storage.at atVar) {
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
                intent.putExtra("is_sender", true);
                intent.putExtra("appmsg_type", aVar2.cpe);
                intent.putExtra("transfer_id", aVar2.cph);
                intent.putExtra("transaction_id", aVar2.cpg);
                intent.putExtra("effective_date", aVar2.cpj);
                intent.putExtra("total_fee", aVar2.cpk);
                intent.putExtra("fee_type", aVar2.cpl);
                if (k.xT()) {
                    com.tencent.mm.ay.c.a((Fragment) aVar, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221);
                    return true;
                }
                com.tencent.mm.ay.c.a((Fragment) aVar, "remittance", ".ui.RemittanceDetailUI", intent, 221);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                intent.putExtra("appmsg_type", aVar2.cpe);
                intent.putExtra("transfer_id", aVar2.cph);
                intent.putExtra("transaction_id", aVar2.cpg);
                intent.putExtra("effective_date", aVar2.cpj);
                intent.putExtra("total_fee", aVar2.cpk);
                intent.putExtra("fee_type", aVar2.cpl);
                if (k.xT()) {
                    com.tencent.mm.ay.c.b(aVar.nDR.nEl, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                    return true;
                }
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "remittance", ".ui.RemittanceDetailUI", intent);
                return true;
            default:
                v.d("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type, probably version to low & check update!");
                t.bn(aVar.nDR.nEl);
                return true;
        }
    }
}
