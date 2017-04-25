package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.plugin.search.ui.a.b.b;

public final class j extends b {
    private a iJk = new a(this);

    public class a extends b {
        final /* synthetic */ j iJl;

        public a(j jVar) {
            this.iJl = jVar;
            super(jVar);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            j jVar = (j) aVar;
            p.b(this.iJl.bkC, jVar.eAt, 0);
            c.a(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", jVar.username).putExtra("finish_direct", true));
            return true;
        }
    }

    public j(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r14, com.tencent.mm.ui.f.a.a.a r15) {
        /*
        r13 = this;
        r4 = 0;
        r3 = 0;
        r2 = 1;
        r0 = r13.eAt;
        r0 = r0.cWv;
        r13.username = r0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wH();
        r1 = r13.username;
        r0 = r0.LX(r1);
        r13.euW = r0;
        r0 = r13.username;
        r9 = com.tencent.mm.model.l.er(r0);
        r0 = r13.eAt;
        r0 = r0.cWt;
        switch(r0) {
            case 1: goto L_0x022b;
            case 2: goto L_0x0228;
            case 3: goto L_0x0084;
            case 4: goto L_0x00a3;
            case 5: goto L_0x0232;
            case 6: goto L_0x022f;
            case 7: goto L_0x008e;
            case 8: goto L_0x0025;
            case 9: goto L_0x0025;
            case 10: goto L_0x0025;
            case 11: goto L_0x0132;
            case 12: goto L_0x0025;
            case 13: goto L_0x0025;
            case 14: goto L_0x0025;
            case 15: goto L_0x00b7;
            case 16: goto L_0x00d7;
            case 17: goto L_0x011e;
            case 18: goto L_0x010a;
            default: goto L_0x0025;
        };
    L_0x0025:
        r0 = r3;
        r1 = r3;
        r5 = r3;
        r6 = r3;
        r7 = r4;
        r8 = r4;
        r4 = r3;
    L_0x002c:
        if (r6 == 0) goto L_0x0152;
    L_0x002e:
        r6 = com.tencent.mm.modelsearch.h.cVN;
        r6 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r9, r6);
        r13.eAu = r6;
        if (r4 == 0) goto L_0x0142;
    L_0x0038:
        r6 = r13.eAu;
        r9 = r13.ezU;
        r10 = r13.bkC;
        r6 = com.tencent.mm.modelsearch.h.a(r6, r9, r1, r10);
        r13.eAu = r6;
    L_0x0044:
        if (r5 == 0) goto L_0x0083;
    L_0x0046:
        if (r0 == 0) goto L_0x01fd;
    L_0x0048:
        r0 = r13.eAt;
        r0 = r0.userData;
        r0 = (java.util.List) r0;
        r1 = r13.euW;
        r1 = r1.field_contactLabelIds;
        r7 = r13.ezU;
        r9 = r13.bkC;
        r4 = "\u0000";
        r4 = r1.endsWith(r4);
        if (r4 == 0) goto L_0x0069;
    L_0x005f:
        r4 = r1.length();
        r4 = r4 + -1;
        r1 = r1.substring(r3, r4);
    L_0x0069:
        r4 = r1.length();
        if (r4 != 0) goto L_0x015c;
    L_0x006f:
        r0 = "";
    L_0x0072:
        r13.eAv = r0;
    L_0x0074:
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r3] = r8;
        r1 = r13.eAv;
        r0[r2] = r1;
        r0 = android.text.TextUtils.concat(r0);
        r13.eAv = r0;
    L_0x0083:
        return;
    L_0x0084:
        r0 = r2;
    L_0x0085:
        r1 = r2;
    L_0x0086:
        r5 = r3;
        r6 = r2;
        r7 = r4;
        r8 = r4;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x002c;
    L_0x008e:
        r0 = r2;
    L_0x008f:
        r1 = r2;
    L_0x0090:
        r4 = r13.euW;
        r4 = r4.field_nickname;
        r5 = 2131234837; // 0x7f081015 float:1.808585E38 double:1.052969916E-314;
        r5 = r14.getString(r5);
        r6 = r3;
        r7 = r4;
        r8 = r5;
        r5 = r2;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x002c;
    L_0x00a3:
        r0 = r13.euW;
        r0 = r0.bCt;
        r1 = 2131234832; // 0x7f081010 float:1.808584E38 double:1.0529699137E-314;
        r4 = r14.getString(r1);
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r8 = r4;
        r0 = r3;
        r4 = r3;
        goto L_0x002c;
    L_0x00b7:
        r0 = r13.euW;
        r0 = r0.pD();
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 == 0) goto L_0x00c7;
    L_0x00c3:
        r0 = r13.euW;
        r0 = r0.field_username;
    L_0x00c7:
        r1 = 2131234841; // 0x7f081019 float:1.808586E38 double:1.052969918E-314;
        r4 = r14.getString(r1);
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r8 = r4;
        r0 = r3;
        r4 = r3;
        goto L_0x002c;
    L_0x00d7:
        r0 = r13.eAt;
        r1 = r0.content;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r0 != 0) goto L_0x0225;
    L_0x00e1:
        r0 = "​";
        r5 = r1.split(r0);
        r6 = r5.length;
        r4 = r3;
    L_0x00ea:
        if (r4 >= r6) goto L_0x0225;
    L_0x00ec:
        r0 = r5[r4];
        r7 = r13.bkC;
        r7 = r0.startsWith(r7);
        if (r7 == 0) goto L_0x0106;
    L_0x00f6:
        r1 = 2131234836; // 0x7f081014 float:1.8085849E38 double:1.0529699157E-314;
        r4 = r14.getString(r1);
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r8 = r4;
        r0 = r3;
        r4 = r3;
        goto L_0x002c;
    L_0x0106:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x00ea;
    L_0x010a:
        r0 = r13.eAt;
        r0 = r0.content;
        r1 = 2131234838; // 0x7f081016 float:1.8085853E38 double:1.0529699167E-314;
        r4 = r14.getString(r1);
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r8 = r4;
        r0 = r3;
        r4 = r3;
        goto L_0x002c;
    L_0x011e:
        r0 = r13.eAt;
        r0 = r0.content;
        r1 = 2131234831; // 0x7f08100f float:1.8085839E38 double:1.052969913E-314;
        r4 = r14.getString(r1);
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r8 = r4;
        r0 = r3;
        r4 = r3;
        goto L_0x002c;
    L_0x0132:
        r0 = 2131234840; // 0x7f081018 float:1.8085857E38 double:1.0529699177E-314;
        r0 = r14.getString(r0);
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r4;
        r8 = r0;
        r0 = r2;
        r4 = r3;
        goto L_0x002c;
    L_0x0142:
        r6 = r13.eAu;
        r9 = r13.ezU;
        r10 = r13.bkC;
        r11 = r13.eAt;
        r6 = com.tencent.mm.modelsearch.h.a(r6, r9, r10, r11);
        r13.eAu = r6;
        goto L_0x0044;
    L_0x0152:
        r6 = com.tencent.mm.modelsearch.h.cVN;
        r6 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r9, r6);
        r13.eAu = r6;
        goto L_0x0044;
    L_0x015c:
        r5 = com.tencent.mm.pluginsdk.j.a.bmu();
        r4 = com.tencent.mm.modelsearch.d.cVF;
        r10 = r4.split(r1);
        r6 = new android.text.SpannableStringBuilder;
        r6.<init>();
        r4 = r3;
    L_0x016c:
        r1 = r0.size();
        if (r4 >= r1) goto L_0x019e;
    L_0x0172:
        r1 = r0.get(r4);
        r1 = (com.tencent.mm.modelsearch.p.i) r1;
        r11 = r1.cWG;
        r12 = r10.length;
        if (r11 >= r12) goto L_0x0182;
    L_0x017d:
        r11 = r1.cWt;
        switch(r11) {
            case 8: goto L_0x018a;
            case 9: goto L_0x0188;
            case 10: goto L_0x0186;
            default: goto L_0x0182;
        };
    L_0x0182:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x016c;
    L_0x0186:
        r1.cWL = r2;
    L_0x0188:
        r1.cWK = r2;
    L_0x018a:
        r11 = r1.cWK;
        if (r11 == 0) goto L_0x0199;
    L_0x018e:
        r11 = r1.cWG;
        r11 = r10[r11];
        r11 = r5.vu(r11);
        r1.cWI = r11;
        goto L_0x0182;
    L_0x0199:
        r11 = r1.content;
        r1.cWI = r11;
        goto L_0x0182;
    L_0x019e:
        r4 = r3;
    L_0x019f:
        r1 = r0.size();
        if (r4 >= r1) goto L_0x01fa;
    L_0x01a5:
        r1 = r0.get(r4);
        r1 = (com.tencent.mm.modelsearch.p.i) r1;
        r5 = r1.cWI;
        r10 = com.tencent.mm.modelsearch.h.cVP;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r5, r10);
        r10 = r1.cWK;
        if (r10 == 0) goto L_0x01d8;
    L_0x01b7:
        r10 = r1.cWL;
        r5 = com.tencent.mm.modelsearch.h.a(r5, r7, r10, r9);
    L_0x01bd:
        r10 = r6.length();
        if (r10 <= 0) goto L_0x01c9;
    L_0x01c3:
        r10 = ", ";
        r6.append(r10);
    L_0x01c9:
        r10 = r1.cWJ;
        r10 = com.tencent.mm.sdk.platformtools.be.kS(r10);
        if (r10 == 0) goto L_0x01dd;
    L_0x01d1:
        r6.append(r5);
    L_0x01d4:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x019f;
    L_0x01d8:
        r5 = com.tencent.mm.modelsearch.h.a(r14, r5, r7, r9);
        goto L_0x01bd;
    L_0x01dd:
        r1 = r1.cWJ;
        r10 = com.tencent.mm.modelsearch.h.cVP;
        r1 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r1, r10);
        r1 = r6.append(r1);
        r10 = 40;
        r1 = r1.append(r10);
        r1 = r1.append(r5);
        r5 = ")";
        r1.append(r5);
        goto L_0x01d4;
    L_0x01fa:
        r0 = r6;
        goto L_0x0072;
    L_0x01fd:
        r0 = com.tencent.mm.modelsearch.h.cVN;
        r0 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r7, r0);
        r13.eAv = r0;
        if (r4 == 0) goto L_0x0215;
    L_0x0207:
        r0 = r13.eAv;
        r4 = r13.ezU;
        r5 = r13.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r0, r4, r1, r5);
        r13.eAv = r0;
        goto L_0x0074;
    L_0x0215:
        r0 = r13.eAv;
        r1 = r13.ezU;
        r4 = r13.bkC;
        r5 = r13.eAt;
        r0 = com.tencent.mm.modelsearch.h.a(r0, r1, r4, r5);
        r13.eAv = r0;
        goto L_0x0074;
    L_0x0225:
        r0 = r1;
        goto L_0x00f6;
    L_0x0228:
        r0 = r3;
        goto L_0x0085;
    L_0x022b:
        r0 = r3;
        r1 = r3;
        goto L_0x0086;
    L_0x022f:
        r0 = r3;
        goto L_0x008f;
    L_0x0232:
        r0 = r3;
        r1 = r3;
        goto L_0x0090;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.j.a(android.content.Context, com.tencent.mm.ui.f.a.a$a):void");
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.iJk;
    }
}
