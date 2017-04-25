package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;
import com.tencent.mm.ui.chatting.ad.b;

final class bi extends b {
    public bi() {
        super(9);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903320);
        view.setTag(new di(this.eKg).cS(view));
        return view;
    }

    protected final boolean bEy() {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ui.chatting.ad.a r9, int r10, com.tencent.mm.ui.chatting.ChattingUI.a r11, com.tencent.mm.storage.at r12, java.lang.String r13) {
        /*
        r8 = this;
        r7 = 2130839019; // 0x7f0205eb float:1.7283037E38 double:1.052774356E-314;
        r3 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r6 = 1;
        r4 = 8;
        r5 = 0;
        r9 = (com.tencent.mm.ui.chatting.di) r9;
        r0 = r12.field_type;
        r1 = 37;
        if (r0 != r1) goto L_0x016b;
    L_0x0012:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.field_content;
        r0 = r0.MT(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0021:
        r1 = r0.lct;
        if (r1 == 0) goto L_0x002d;
    L_0x0025:
        r1 = r0.lct;
        r1 = r1.length();
        if (r1 > 0) goto L_0x0037;
    L_0x002d:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r1 = "getView : parse verify msg failed";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x0036:
        return;
    L_0x0037:
        r1 = r0.lct;
        r2 = r0.nvF;
        com.tencent.mm.u.b.r(r1, r2);
        r1 = r0.lct;
        r1 = com.tencent.mm.model.m.eC(r1);
        if (r1 == 0) goto L_0x00d4;
    L_0x0046:
        r1 = r9.oxF;
        r1.setVisibility(r4);
        r1 = r9.oxG;
        r1.setVisibility(r4);
        r1 = r9.oxH;
        r1.setVisibility(r5);
        r1 = r9.oxE;
        r1.setBackgroundColor(r3);
        r1 = r9.oxH;
        r2 = 2131232992; // 0x7f0808e0 float:1.8082109E38 double:1.0529690046E-314;
        r2 = r11.getString(r2);
        r1.setText(r2);
    L_0x0066:
        r1 = r0.scene;
        switch(r1) {
            case 13: goto L_0x011e;
            case 14: goto L_0x006b;
            case 15: goto L_0x006b;
            case 16: goto L_0x006b;
            case 17: goto L_0x006b;
            case 18: goto L_0x00f6;
            case 19: goto L_0x006b;
            case 20: goto L_0x006b;
            case 21: goto L_0x006b;
            case 22: goto L_0x0100;
            case 23: goto L_0x0100;
            case 24: goto L_0x0100;
            case 25: goto L_0x0114;
            case 26: goto L_0x0100;
            case 27: goto L_0x0100;
            case 28: goto L_0x0100;
            case 29: goto L_0x0100;
            case 30: goto L_0x010a;
            default: goto L_0x006b;
        };
    L_0x006b:
        r1 = r9.olK;
        r2 = 2131231791; // 0x7f08042f float:1.8079673E38 double:1.0529684113E-314;
        r1.setText(r2);
    L_0x0073:
        r1 = r9.iLR;
        r2 = r11.nDR;
        r2 = r2.nEl;
        r3 = r0.getDisplayName();
        r4 = r9.iLR;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.e.a(r2, r3, r4);
        r1.setText(r2);
        r1 = r9.dtX;
        r2 = r0.lct;
        com.tencent.mm.ui.chatting.ad.q(r1, r2);
        r1 = r9.lts;
        r1.setVisibility(r5);
        r1 = r0.content;
        if (r1 == 0) goto L_0x015d;
    L_0x009a:
        r1 = r0.content;
        r1 = r1.trim();
        r2 = "";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x015d;
    L_0x00a9:
        r1 = r9.lts;
        r0 = r0.content;
        r1.setText(r0);
    L_0x00b0:
        r7 = r9.onC;
        r0 = new com.tencent.mm.ui.chatting.dl;
        r2 = r11.nQK;
        r4 = 0;
        r1 = r12;
        r3 = r10;
        r6 = r5;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r7.setTag(r0);
        r0 = r9.onC;
        r1 = r11.onh;
        r1 = r1.oqh;
        r0.setOnClickListener(r1);
        r0 = r9.onC;
        r1 = r11.onh;
        r1 = r1.oqj;
        r0.setOnLongClickListener(r1);
        goto L_0x0036;
    L_0x00d4:
        r1 = r9.oxF;
        r1.setVisibility(r5);
        r1 = r9.oxG;
        r1.setVisibility(r5);
        r1 = r9.oxH;
        r1.setVisibility(r5);
        r1 = r9.oxE;
        r1.setBackgroundResource(r7);
        r1 = r9.oxH;
        r2 = 2131232991; // 0x7f0808df float:1.8082107E38 double:1.052969004E-314;
        r2 = r11.getString(r2);
        r1.setText(r2);
        goto L_0x0066;
    L_0x00f6:
        r1 = r9.olK;
        r2 = 2131231795; // 0x7f080433 float:1.8079681E38 double:1.052968413E-314;
        r1.setText(r2);
        goto L_0x0073;
    L_0x0100:
        r1 = r9.olK;
        r2 = 2131231797; // 0x7f080435 float:1.8079685E38 double:1.052968414E-314;
        r1.setText(r2);
        goto L_0x0073;
    L_0x010a:
        r1 = r9.olK;
        r2 = 2131234279; // 0x7f080de7 float:1.808472E38 double:1.0529696405E-314;
        r1.setText(r2);
        goto L_0x0073;
    L_0x0114:
        r1 = r9.olK;
        r2 = 2131231790; // 0x7f08042e float:1.807967E38 double:1.052968411E-314;
        r1.setText(r2);
        goto L_0x0073;
    L_0x011e:
        r1 = com.tencent.mm.modelfriend.ah.FL();
        r2 = r0.lct;
        r1 = r1.iA(r2);
        r2 = r1.ED();
        if (r2 == 0) goto L_0x0156;
    L_0x012e:
        r2 = r1.ED();
        r3 = "";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0156;
    L_0x013b:
        r2 = r9.oxI;
        r2.setVisibility(r5);
        r2 = r9.oxI;
        r3 = 2131231785; // 0x7f080429 float:1.807966E38 double:1.0529684083E-314;
        r4 = new java.lang.Object[r6];
        r1 = r1.ED();
        r4[r5] = r1;
        r1 = r11.getString(r3, r4);
        r2.setText(r1);
        goto L_0x006b;
    L_0x0156:
        r1 = r9.oxI;
        r1.setVisibility(r4);
        goto L_0x006b;
    L_0x015d:
        r0 = r9.lts;
        r1 = 2131231796; // 0x7f080434 float:1.8079683E38 double:1.0529684137E-314;
        r1 = r11.getString(r1);
        r0.setText(r1);
        goto L_0x00b0;
    L_0x016b:
        r0 = r12.field_type;
        r1 = 40;
        if (r0 != r1) goto L_0x02f2;
    L_0x0171:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.field_content;
        r1 = r0.MU(r1);
        if (r1 == 0) goto L_0x018c;
    L_0x0180:
        r0 = r1.lct;
        if (r0 == 0) goto L_0x018c;
    L_0x0184:
        r0 = r1.lct;
        r0 = r0.length();
        if (r0 > 0) goto L_0x0197;
    L_0x018c:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r1 = "getView : parse possible friend msg failed";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x0036;
    L_0x0197:
        r0 = r1.lct;
        r2 = r1.nvF;
        com.tencent.mm.u.b.r(r0, r2);
        r0 = r1.lct;
        r0 = com.tencent.mm.model.m.eC(r0);
        if (r0 == 0) goto L_0x020e;
    L_0x01a6:
        r0 = r9.oxF;
        r0.setVisibility(r4);
        r0 = r9.oxG;
        r0.setVisibility(r4);
        r0 = r9.oxH;
        r0.setVisibility(r5);
        r0 = r9.oxE;
        r0.setBackgroundColor(r3);
        r0 = r9.oxH;
        r2 = 2131232992; // 0x7f0808e0 float:1.8082109E38 double:1.0529690046E-314;
        r2 = r11.getString(r2);
        r0.setText(r2);
    L_0x01c6:
        r0 = r1.scene;
        switch(r0) {
            case 4: goto L_0x022f;
            case 10: goto L_0x025d;
            case 11: goto L_0x025d;
            case 31: goto L_0x02a0;
            case 32: goto L_0x02c9;
            default: goto L_0x01cb;
        };
    L_0x01cb:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r2 = "prossible friend sceneType:%d";
        r3 = new java.lang.Object[r6];
        r4 = r1.scene;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r5] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r0, r2, r3);
        r0 = r9.olK;
        r2 = 2131231786; // 0x7f08042a float:1.8079663E38 double:1.052968409E-314;
        r0.setText(r2);
        r0 = r9.lts;
        r2 = 2131231787; // 0x7f08042b float:1.8079665E38 double:1.0529684093E-314;
        r0.setText(r2);
        r0 = r9.iLR;
        r2 = r11.nDR;
        r2 = r2.nEl;
        r3 = r1.getDisplayName();
        r4 = r9.iLR;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.e.a(r2, r3, r4);
        r0.setText(r2);
    L_0x0205:
        r0 = r9.dtX;
        r1 = r1.lct;
        com.tencent.mm.ui.chatting.ad.q(r0, r1);
        goto L_0x00b0;
    L_0x020e:
        r0 = r9.oxF;
        r0.setVisibility(r5);
        r0 = r9.oxG;
        r0.setVisibility(r5);
        r0 = r9.oxH;
        r0.setVisibility(r5);
        r0 = r9.oxE;
        r0.setBackgroundResource(r7);
        r0 = r9.oxH;
        r2 = 2131232991; // 0x7f0808df float:1.8082107E38 double:1.052969004E-314;
        r2 = r11.getString(r2);
        r0.setText(r2);
        goto L_0x01c6;
    L_0x022f:
        r0 = r9.olK;
        r2 = 2131231781; // 0x7f080425 float:1.8079653E38 double:1.0529684063E-314;
        r0.setText(r2);
        r0 = r9.lts;
        r2 = 2131231782; // 0x7f080426 float:1.8079655E38 double:1.052968407E-314;
        r0.setText(r2);
        r0 = r1.bwI();
        if (r0 != 0) goto L_0x0249;
    L_0x0245:
        r0 = r1.getDisplayName();
    L_0x0249:
        r2 = r9.iLR;
        r3 = r11.nDR;
        r3 = r3.nEl;
        r4 = r9.iLR;
        r4 = r4.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.e.a(r3, r0, r4);
        r2.setText(r0);
        goto L_0x0205;
    L_0x025d:
        r0 = r9.olK;
        r2 = 2131231784; // 0x7f080428 float:1.8079659E38 double:1.052968408E-314;
        r0.setText(r2);
        r0 = r1.nvG;
        r0 = com.tencent.mm.modelfriend.m.iI(r0);
        r2 = com.tencent.mm.platformtools.t.kS(r0);
        if (r2 == 0) goto L_0x0277;
    L_0x0271:
        r0 = r1.nvH;
        r0 = com.tencent.mm.modelfriend.m.iI(r0);
    L_0x0277:
        r2 = r9.lts;
        r3 = 2131231785; // 0x7f080429 float:1.807966E38 double:1.0529684083E-314;
        r4 = new java.lang.Object[r6];
        r4[r5] = r0;
        r0 = r11.getString(r3, r4);
        r2.setText(r0);
        r0 = r9.iLR;
        r2 = r11.nDR;
        r2 = r2.nEl;
        r3 = r1.getDisplayName();
        r4 = r9.iLR;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.e.a(r2, r3, r4);
        r0.setText(r2);
        goto L_0x0205;
    L_0x02a0:
        r0 = r9.olK;
        r2 = 2131231793; // 0x7f080431 float:1.8079677E38 double:1.052968412E-314;
        r0.setText(r2);
        r0 = r9.lts;
        r2 = 2131231794; // 0x7f080432 float:1.807968E38 double:1.0529684127E-314;
        r0.setText(r2);
        r0 = r9.iLR;
        r2 = r11.nDR;
        r2 = r2.nEl;
        r3 = r1.getDisplayName();
        r4 = r9.iLR;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.e.a(r2, r3, r4);
        r0.setText(r2);
        goto L_0x0205;
    L_0x02c9:
        r0 = r9.olK;
        r2 = 2131231789; // 0x7f08042d float:1.8079669E38 double:1.0529684103E-314;
        r0.setText(r2);
        r0 = r9.lts;
        r2 = 2131231788; // 0x7f08042c float:1.8079667E38 double:1.05296841E-314;
        r0.setText(r2);
        r0 = r9.iLR;
        r2 = r11.nDR;
        r2 = r2.nEl;
        r3 = r1.getDisplayName();
        r4 = r9.iLR;
        r4 = r4.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.e.a(r2, r3, r4);
        r0.setText(r2);
        goto L_0x0205;
    L_0x02f2:
        r0 = "MicroMsg.ChattingItemFMessageFrom";
        r1 = new java.lang.StringBuilder;
        r2 = "FROM_FMESSAGE did not include this type, msgType = ";
        r1.<init>(r2);
        r2 = r12.field_type;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        goto L_0x00b0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.bi.a(com.tencent.mm.ui.chatting.ad$a, int, com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.at, java.lang.String):void");
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, ChattingUI.a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, ChattingUI.a aVar, at atVar) {
        return false;
    }
}
