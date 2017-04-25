package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;

final class ah extends c {
    private a onG;

    public ah() {
        super(60);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof d) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903340);
        view.setTag(new d(this.eKg).cF(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a B;
        this.onG = aVar2;
        d dVar = (d) aVar;
        String str2 = atVar.field_content;
        if (str2 != null) {
            B = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            boolean z;
            if ("1001".equals(B.cpJ)) {
                dVar.onC.setBackgroundResource(2130837507);
                dVar.ojZ.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                dVar.onC.setBackgroundResource(2130837812);
                dVar.ojZ.setTypeface(Typeface.defaultFromStyle(0));
            }
            dVar.onC.setPadding(aVar2.nDR.nEl.getResources().getDimensionPixelSize(2131493152), 0, com.tencent.mm.bd.a.fromDPToPix(aVar2.nDR.nEl, 13), 0);
            CharSequence charSequence = atVar.field_isSend == 1 ? B.cpE : B.cpD;
            if (be.kS(charSequence)) {
                charSequence = B.description;
                dVar.ojZ.setSingleLine(false);
                dVar.ojZ.setMaxLines(3);
            } else {
                dVar.ojZ.setSingleLine(true);
            }
            dVar.ojZ.setText(e.a(aVar2.nDR.nEl, charSequence, dVar.ojZ.getTextSize()));
            TextView textView = dVar.oka;
            Context context = aVar2.nDR.nEl;
            if (atVar.field_isSend == 1) {
                z = true;
            } else {
                z = false;
            }
            textView.setText(e.a(context, com.tencent.mm.q.e.b(B, z), dVar.oka.getTextSize()));
            charSequence = B.cpH;
            if (be.kS(charSequence)) {
                charSequence = B.title;
            }
            dVar.okb.setText(charSequence);
            int i2 = -1;
            if ("1001".equals(B.cpJ)) {
                if (atVar.field_isSend == 1) {
                    z = true;
                } else {
                    z = false;
                }
                i2 = com.tencent.mm.q.e.a(B, z);
            }
            if (i2 > 0) {
                dVar.ojY.setImageResource(i2);
            } else {
                str2 = B.cpC;
                if (be.kS(str2)) {
                    str2 = B.thumburl;
                }
                dVar.ojY.setImageBitmap(null);
                if (!be.kS(str2)) {
                    com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
                    ak.yW();
                    aVar3.cPv = com.tencent.mm.model.c.wQ();
                    aVar3.cPs = true;
                    aVar3.cPO = true;
                    n.GL().a(str2, dVar.ojY, aVar3.GU());
                }
            }
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
            case MMGIFException.D_GIF_ERR_NOT_GIF_FILE /*103*/:
                String str = atVar.field_content;
                com.tencent.mm.q.a.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
                }
                if (aVar2 != null) {
                    final String str2 = atVar.field_talker;
                    final String str3 = aVar2.cpD;
                    final String str4 = aVar2.cpE;
                    final String str5 = aVar2.cpF;
                    final String str6 = aVar2.cpG;
                    final String str7 = aVar2.cpB;
                    final String str8 = aVar2.cpI;
                    final String str9 = aVar2.cpJ;
                    Context context = aVar.nDR.nEl;
                    String string = aVar.getString(2131231873);
                    String string2 = aVar.getString(2131231139);
                    String string3 = aVar.getString(2131231874);
                    String string4 = aVar.getString(2131231010);
                    final a aVar3 = aVar;
                    AnonymousClass1 anonymousClass1 = new OnClickListener(this) {
                        final /* synthetic */ ah onO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("key_scene", 1);
                            intent.putExtra("key_receiver", str2);
                            intent.putExtra("key_receivertitle", str3);
                            intent.putExtra("key_sendertitle", str4);
                            intent.putExtra("key_sender_des", str5);
                            intent.putExtra("key_receiver_des", str6);
                            intent.putExtra("key_url", str7);
                            intent.putExtra("key_templateid", str8);
                            intent.putExtra("key_sceneid", str9);
                            com.tencent.mm.ay.c.b(aVar3.bzo(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
                        }
                    };
                    g.b(context, string, string2, string3, string4, (OnClickListener) anonymousClass1, new OnClickListener(this) {
                        final /* synthetic */ ah onO;

                        {
                            this.onO = r1;
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

    public final boolean a(View view, a aVar, at atVar) {
        com.tencent.mm.q.a.a B;
        String str = atVar.field_content;
        if (str != null) {
            B = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            String str2 = be.kS(B.cpB) ? B.url : B.cpB;
            v.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", Boolean.valueOf(be.kS(str2)), Boolean.valueOf(be.kS(B.cpS)));
            Intent intent;
            Intent intent2;
            if (be.kS(B.cpK)) {
                if (!be.kS(B.cpS)) {
                    v.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", B.cpS, Integer.valueOf(B.cpT), B.bhM);
                    intent = new Intent();
                    intent.putExtra("bill_no", B.cpS);
                    intent.putExtra("launcher_user_name", B.bhM);
                    intent.putExtra("enter_scene", 1);
                    intent.putExtra("chatroom", aVar.bEn());
                    com.tencent.mm.ay.c.b(aVar.nDR.nEl, "aa", ".ui.PaylistAAUI", intent);
                    com.tencent.mm.plugin.report.service.g.iuh.h(13721, Integer.valueOf(4), Integer.valueOf(1));
                } else if (!(be.kS(str2) || be.kS(str2))) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    com.tencent.mm.ay.c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2);
                }
            } else if (B.cpK.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_way", 1);
                intent.putExtra("key_native_url", B.cpK);
                intent.putExtra("key_username", aVar.bEn());
                intent.putExtra("key_static_from_scene", 100002);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
            } else if (B.cpK.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                int i;
                Intent intent3 = new Intent();
                String str3 = "key_way";
                if (aVar.onl) {
                    i = 0;
                } else {
                    i = 1;
                }
                intent3.putExtra(str3, i);
                intent3.putExtra("key_native_url", B.cpK);
                intent3.putExtra("key_username", aVar.bEn());
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "luckymoney", ".ui.LuckyMoneyReceiveUI", intent3);
            } else {
                v.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + B.cpK + ", go webview:" + str2);
                if (!be.kS(str2)) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    com.tencent.mm.ay.c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2);
                }
            }
        }
        return true;
    }
}
