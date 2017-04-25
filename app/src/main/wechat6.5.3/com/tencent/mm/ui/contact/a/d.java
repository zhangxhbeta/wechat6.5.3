package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import java.util.regex.Pattern;

public class d extends a {
    private static final Pattern cVF = Pattern.compile(",");
    public String[] cUQ;
    public CharSequence dtS;
    public CharSequence dtT;
    public h eAt;
    private b oJp = new b(this);
    private a oJq = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        public CheckBox dua;
        final /* synthetic */ d oJr;

        public a(d dVar) {
            this.oJr = dVar;
            super(dVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ d oJr;

        public b(d dVar) {
            this.oJr = dVar;
            super(dVar);
        }

        public View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bd.a.dt(context)) {
                inflate = LayoutInflater.from(context).inflate(2130904339, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(2130904338, viewGroup, false);
            }
            a aVar = (a) this.oJr.NF();
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtW = inflate.findViewById(2131758337);
            aVar.dua = (CheckBox) inflate.findViewById(2131755510);
            inflate.setTag(aVar);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            d dVar = (d) aVar2;
            if (dVar.username == null || dVar.username.length() <= 0) {
                aVar3.dtX.setImageResource(2130838080);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, dVar.username);
            }
            com.tencent.mm.modelsearch.h.a(dVar.dtS, aVar3.dtY);
            com.tencent.mm.modelsearch.h.a(dVar.dtT, aVar3.dtZ);
            if (this.oJr.oHa) {
                if (z) {
                    aVar3.dua.setChecked(true);
                    aVar3.dua.setEnabled(false);
                } else {
                    aVar3.dua.setChecked(z2);
                    aVar3.dua.setEnabled(true);
                }
                aVar3.dua.setVisibility(0);
            } else {
                aVar3.dua.setVisibility(8);
            }
            if (this.oJr.eyw) {
                aVar3.dtW.setBackgroundResource(2130838048);
            } else {
                aVar3.dtW.setBackgroundResource(2130838046);
            }
            if (dVar.euW.field_deleteFlag == 1) {
                aVar3.dtZ.setVisibility(0);
                aVar3.dtZ.setText(context.getString(2131230829));
            }
        }

        public final boolean NG() {
            if (this.oJr.eAt != null) {
                p.b(this.oJr.bkC, this.oJr.eAt, 1);
            }
            return false;
        }
    }

    public d(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bo(android.content.Context r20) {
        /*
        r19 = this;
        r0 = r19;
        r1 = r0.eAt;
        if (r1 == 0) goto L_0x006a;
    L_0x0006:
        r0 = r19;
        r1 = r0.cUQ;
        if (r1 == 0) goto L_0x0068;
    L_0x000c:
        r0 = r19;
        r1 = r0.cUQ;
        r1 = r1.length;
        if (r1 <= 0) goto L_0x0068;
    L_0x0013:
        r1 = 1;
    L_0x0014:
        r0 = r19;
        r2 = r0.euW;
        if (r2 != 0) goto L_0x004a;
    L_0x001a:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wH();
        r0 = r19;
        r3 = r0.eAt;
        r3 = r3.cWv;
        r2 = r2.LS(r3);
        r0 = r19;
        r0.euW = r2;
        r0 = r19;
        r2 = r0.euW;
        if (r2 != 0) goto L_0x004a;
    L_0x0035:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wH();
        r0 = r19;
        r3 = r0.eAt;
        r3 = r3.cWv;
        r2 = r2.LW(r3);
        r0 = r19;
        r0.euW = r2;
    L_0x004a:
        r0 = r19;
        r2 = r0.euW;
        if (r2 != 0) goto L_0x006c;
    L_0x0050:
        r1 = "MicroMsg.ContactDataItem";
        r2 = "filling dataItem Occur Error Contact is null, position=%d";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = r19;
        r5 = r0.position;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
    L_0x0067:
        return;
    L_0x0068:
        r1 = 0;
        goto L_0x0014;
    L_0x006a:
        r1 = 0;
        goto L_0x004a;
    L_0x006c:
        r0 = r19;
        r2 = r0.euW;
        r2 = r2.field_username;
        r0 = r19;
        r0.username = r2;
        if (r1 == 0) goto L_0x029f;
    L_0x0078:
        r0 = r19;
        r10 = r0.eAt;
        r0 = r19;
        r11 = r0.euW;
        r0 = r19;
        r12 = r0.cUQ;
        r3 = 0;
        r8 = 0;
        r6 = 0;
        r7 = 0;
        r4 = 0;
        r2 = 0;
        r1 = 0;
        r5 = 0;
        r13 = r20.getResources();
        if (r11 == 0) goto L_0x02df;
    L_0x0092:
        r3 = r11.field_username;
        r9 = com.tencent.mm.model.l.a(r11, r3);
        r3 = r10.cWt;
        switch(r3) {
            case 1: goto L_0x0111;
            case 2: goto L_0x0110;
            case 3: goto L_0x010f;
            case 4: goto L_0x0135;
            case 5: goto L_0x011e;
            case 6: goto L_0x011d;
            case 7: goto L_0x011c;
            case 8: goto L_0x009d;
            case 9: goto L_0x009d;
            case 10: goto L_0x009d;
            case 11: goto L_0x01c0;
            case 12: goto L_0x009d;
            case 13: goto L_0x009d;
            case 14: goto L_0x009d;
            case 15: goto L_0x014c;
            case 16: goto L_0x016c;
            case 17: goto L_0x01a9;
            case 18: goto L_0x01a9;
            default: goto L_0x009d;
        };
    L_0x009d:
        r3 = r2;
        r2 = r1;
        r1 = r5;
        r5 = r7;
        r7 = r8;
        r8 = r9;
    L_0x00a3:
        r9 = com.tencent.mm.sdk.platformtools.be.g(r12);
        if (r5 == 0) goto L_0x01de;
    L_0x00a9:
        r5 = "MicroMsg.ContactDataItem";
        r13 = "highlight first line";
        com.tencent.mm.sdk.platformtools.v.d(r5, r13);
        r5 = cVN;
        r0 = r20;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r0, r8, r5);
        if (r3 == 0) goto L_0x01d6;
    L_0x00bc:
        r0 = r19;
        r8 = r0.bkC;
        r5 = com.tencent.mm.modelsearch.h.a(r5, r9, r2, r8);
    L_0x00c4:
        r0 = r19;
        r0.dtS = r5;
        r5 = 0;
        if (r1 == 0) goto L_0x026c;
    L_0x00cb:
        r1 = r10.userData;
        r1 = (java.util.List) r1;
        r2 = r11.field_contactLabelIds;
        r5 = -1;
        r3 = "\u0000";
        r3 = r2.endsWith(r3);
        if (r3 == 0) goto L_0x00e6;
    L_0x00db:
        r3 = 0;
        r4 = r2.length();
        r4 = r4 + -1;
        r2 = r2.substring(r3, r4);
    L_0x00e6:
        r3 = r2.length();
        if (r3 != 0) goto L_0x01e8;
    L_0x00ec:
        r1 = new android.text.SpannableString;
        r2 = "";
        r1.<init>(r2);
    L_0x00f4:
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r2 != 0) goto L_0x0067;
    L_0x00fa:
        if (r1 == 0) goto L_0x0067;
    L_0x00fc:
        r2 = 2;
        r2 = new java.lang.CharSequence[r2];
        r3 = 0;
        r2[r3] = r7;
        r3 = 1;
        r2[r3] = r1;
        r1 = android.text.TextUtils.concat(r2);
        r0 = r19;
        r0.dtT = r1;
        goto L_0x0067;
    L_0x010f:
        r1 = 1;
    L_0x0110:
        r2 = 1;
    L_0x0111:
        r3 = 1;
        r7 = r8;
        r8 = r9;
        r17 = r2;
        r2 = r1;
        r1 = r5;
        r5 = r3;
        r3 = r17;
        goto L_0x00a3;
    L_0x011c:
        r1 = 1;
    L_0x011d:
        r2 = 1;
    L_0x011e:
        r3 = 1;
        r4 = r11.field_nickname;
        r6 = 2131234837; // 0x7f081015 float:1.808585E38 double:1.052969916E-314;
        r6 = r13.getString(r6);
        r8 = r9;
        r17 = r1;
        r1 = r5;
        r5 = r7;
        r7 = r6;
        r6 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r17;
        goto L_0x00a3;
    L_0x0135:
        r3 = 1;
        r4 = r11.bCt;
        r6 = 2131234832; // 0x7f081010 float:1.808584E38 double:1.0529699137E-314;
        r6 = r13.getString(r6);
        r8 = r9;
        r17 = r1;
        r1 = r5;
        r5 = r7;
        r7 = r6;
        r6 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r17;
        goto L_0x00a3;
    L_0x014c:
        r4 = 1;
        r3 = r11.pD();
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r6 == 0) goto L_0x0159;
    L_0x0157:
        r3 = r11.field_username;
    L_0x0159:
        r6 = 2131234841; // 0x7f081019 float:1.808586E38 double:1.052969918E-314;
        r6 = r13.getString(r6);
        r8 = r9;
        r17 = r1;
        r1 = r5;
        r5 = r7;
        r7 = r6;
        r6 = r3;
        r3 = r2;
        r2 = r17;
        goto L_0x00a3;
    L_0x016c:
        r6 = 1;
        r4 = r10.content;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r3 != 0) goto L_0x02dc;
    L_0x0175:
        r3 = "​";
        r14 = r4.split(r3);
        r15 = r14.length;
        r3 = 0;
        r8 = r3;
    L_0x017f:
        if (r8 >= r15) goto L_0x02dc;
    L_0x0181:
        r3 = r14[r8];
        r0 = r19;
        r0 = r0.bkC;
        r16 = r0;
        r0 = r16;
        r16 = r3.startsWith(r0);
        if (r16 == 0) goto L_0x01a5;
    L_0x0191:
        r4 = 2131234836; // 0x7f081014 float:1.8085849E38 double:1.0529699157E-314;
        r4 = r13.getString(r4);
        r8 = r9;
        r17 = r1;
        r1 = r5;
        r5 = r7;
        r7 = r4;
        r4 = r6;
        r6 = r3;
        r3 = r2;
        r2 = r17;
        goto L_0x00a3;
    L_0x01a5:
        r3 = r8 + 1;
        r8 = r3;
        goto L_0x017f;
    L_0x01a9:
        r3 = 1;
        r4 = r10.content;
        r6 = 2131234834; // 0x7f081012 float:1.8085845E38 double:1.0529699147E-314;
        r6 = r13.getString(r6);
        r8 = r9;
        r17 = r1;
        r1 = r5;
        r5 = r7;
        r7 = r6;
        r6 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r17;
        goto L_0x00a3;
    L_0x01c0:
        r3 = 1;
        r5 = 2131234840; // 0x7f081018 float:1.8085857E38 double:1.0529699177E-314;
        r5 = r13.getString(r5);
        r8 = r9;
        r17 = r1;
        r1 = r3;
        r3 = r2;
        r2 = r17;
        r18 = r5;
        r5 = r7;
        r7 = r18;
        goto L_0x00a3;
    L_0x01d6:
        r0 = r20;
        r5 = com.tencent.mm.modelsearch.h.a(r0, r5, r9);
        goto L_0x00c4;
    L_0x01de:
        r5 = cVN;
        r0 = r20;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r0, r8, r5);
        goto L_0x00c4;
    L_0x01e8:
        r3 = cVF;
        r9 = r3.split(r2);
        r10 = com.tencent.mm.pluginsdk.j.a.bmu();
        r6 = new android.text.SpannableStringBuilder;
        r6.<init>();
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r11 = r1.iterator();
    L_0x01fe:
        r1 = r11.hasNext();
        if (r1 == 0) goto L_0x0264;
    L_0x0204:
        r1 = r11.next();
        r1 = (com.tencent.mm.modelsearch.p.i) r1;
        r8 = r1.cWG;
        if (r8 == r5) goto L_0x0227;
    L_0x020e:
        if (r4 == 0) goto L_0x021b;
    L_0x0210:
        r4 = r6.append(r4);
        r5 = ", ";
        r4.append(r5);
        r4 = 0;
    L_0x021b:
        r5 = r1.cWG;
        r8 = r1.cWt;
        r13 = r9.length;
        if (r5 >= r13) goto L_0x01fe;
    L_0x0222:
        r3 = 0;
        r2 = 0;
        switch(r8) {
            case 8: goto L_0x02d8;
            case 9: goto L_0x0241;
            case 10: goto L_0x0240;
            default: goto L_0x0227;
        };
    L_0x0227:
        if (r4 == 0) goto L_0x01fe;
    L_0x0229:
        r8 = r1.start;
        r13 = r1.cWH;
        r13 = r12[r13];
        r13 = r13.length();
        r13 = r13 + r8;
        if (r3 == 0) goto L_0x0260;
    L_0x0236:
        r1 = r1.content;
        r1 = r1.substring(r8, r13);
        com.tencent.mm.modelsearch.h.a(r4, r1, r2);
        goto L_0x01fe;
    L_0x0240:
        r2 = 1;
    L_0x0241:
        r4 = 1;
        r3 = r2;
    L_0x0243:
        if (r4 == 0) goto L_0x0256;
    L_0x0245:
        r2 = r9[r5];
        r2 = r10.vu(r2);
        r8 = r2;
    L_0x024c:
        if (r8 != 0) goto L_0x025a;
    L_0x024e:
        r2 = 0;
    L_0x024f:
        r17 = r3;
        r3 = r4;
        r4 = r2;
        r2 = r17;
        goto L_0x0227;
    L_0x0256:
        r2 = r1.content;
        r8 = r2;
        goto L_0x024c;
    L_0x025a:
        r2 = new android.text.SpannableString;
        r2.<init>(r8);
        goto L_0x024f;
    L_0x0260:
        com.tencent.mm.modelsearch.h.a(r4, r8, r13);
        goto L_0x01fe;
    L_0x0264:
        if (r4 == 0) goto L_0x0269;
    L_0x0266:
        r6.append(r4);
    L_0x0269:
        r1 = r6;
        goto L_0x00f4;
    L_0x026c:
        if (r6 == 0) goto L_0x02d5;
    L_0x026e:
        if (r4 == 0) goto L_0x0295;
    L_0x0270:
        r1 = "MicroMsg.ContactDataItem";
        r4 = "highlight second line";
        com.tencent.mm.sdk.platformtools.v.d(r1, r4);
        r1 = cVP;
        r0 = r20;
        r1 = com.tencent.mm.pluginsdk.ui.d.e.a(r0, r6, r1);
        if (r3 == 0) goto L_0x028d;
    L_0x0283:
        r0 = r19;
        r3 = r0.bkC;
        r1 = com.tencent.mm.modelsearch.h.a(r1, r9, r2, r3);
        goto L_0x00f4;
    L_0x028d:
        r0 = r20;
        r1 = com.tencent.mm.modelsearch.h.a(r0, r1, r9);
        goto L_0x00f4;
    L_0x0295:
        r1 = cVP;
        r0 = r20;
        r1 = com.tencent.mm.pluginsdk.ui.d.e.a(r0, r6, r1);
        goto L_0x00f4;
    L_0x029f:
        r0 = r19;
        r1 = r0.aYF;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x02c6;
    L_0x02a9:
        r0 = r19;
        r1 = r0.euW;
        r1 = com.tencent.mm.model.l.c(r1);
    L_0x02b1:
        r2 = 2131493169; // 0x7f0c0131 float:1.860981E38 double:1.053097549E-314;
        r0 = r20;
        r2 = com.tencent.mm.bd.a.N(r0, r2);
        r0 = r20;
        r1 = com.tencent.mm.pluginsdk.ui.d.e.a(r0, r1, r2);
        r0 = r19;
        r0.dtS = r1;
        goto L_0x0067;
    L_0x02c6:
        r0 = r19;
        r1 = r0.euW;
        r1 = r1.field_username;
        r0 = r19;
        r2 = r0.aYF;
        r1 = com.tencent.mm.model.l.D(r1, r2);
        goto L_0x02b1;
    L_0x02d5:
        r1 = r5;
        goto L_0x00f4;
    L_0x02d8:
        r4 = r3;
        r3 = r2;
        goto L_0x0243;
    L_0x02dc:
        r3 = r4;
        goto L_0x0191;
    L_0x02df:
        r17 = r5;
        r5 = r7;
        r7 = r8;
        r8 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r17;
        goto L_0x00a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.d.bo(android.content.Context):void");
    }

    public com.tencent.mm.ui.contact.a.a.b NE() {
        return this.oJp;
    }

    public com.tencent.mm.ui.contact.a.a.a NF() {
        return this.oJq;
    }
}
