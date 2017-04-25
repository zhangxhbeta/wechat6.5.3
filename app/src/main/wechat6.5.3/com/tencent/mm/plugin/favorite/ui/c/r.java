package com.tencent.mm.plugin.favorite.ui.c;

import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import java.util.HashMap;

public final class r extends a {
    private static int fSt;
    private static int fSu;
    private final String fSF;
    private final SparseIntArray fSG = new SparseIntArray();
    private HashMap<String, SpannableString> fSH = new HashMap();
    private final int fSr;

    public static class a extends b {
        ImageView eZn;
        ImageView fSI;
        ImageView fSJ;
        TextView fSK;
        TextView fSL;
        FrameLayout fSO;
        LinearLayout fSV;
        ImageView fSW;
        TextView fSX;
        TextView fSY;
        LinearLayout fSZ;
    }

    public r(g gVar) {
        super(gVar);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 60);
        this.fSF = " ";
        fSu = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 138);
        fSt = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 230);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.view.View r25, android.view.ViewGroup r26, com.tencent.mm.plugin.favorite.b.i r27) {
        /*
        r24 = this;
        r17 = r26.getContext();
        if (r25 != 0) goto L_0x0100;
    L_0x0006:
        r5 = new com.tencent.mm.plugin.favorite.ui.c.r$a;
        r5.<init>();
        r4 = 2130903609; // 0x7f030239 float:1.741404E38 double:1.052806268E-314;
        r6 = 0;
        r0 = r17;
        r4 = android.view.View.inflate(r0, r4, r6);
        r0 = r24;
        r1 = r27;
        r25 = r0.a(r4, r5, r1);
        r4 = 2131756943; // 0x7f10078f float:1.9144808E38 double:1.053227871E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.eZn = r4;
        r4 = 2131756950; // 0x7f100796 float:1.9144822E38 double:1.0532278743E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.FrameLayout) r4;
        r5.fSO = r4;
        r4 = 2131756953; // 0x7f100799 float:1.9144828E38 double:1.053227876E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.fSK = r4;
        r4 = 2131756954; // 0x7f10079a float:1.914483E38 double:1.0532278763E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.fSL = r4;
        r4 = 2131756960; // 0x7f1007a0 float:1.9144842E38 double:1.053227879E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.LinearLayout) r4;
        r5.fSV = r4;
        r4 = 2131756951; // 0x7f100797 float:1.9144824E38 double:1.053227875E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.fSI = r4;
        r4 = 2131756952; // 0x7f100798 float:1.9144826E38 double:1.0532278753E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.fSJ = r4;
        r4 = 2131756962; // 0x7f1007a2 float:1.9144846E38 double:1.05322788E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5.fSW = r4;
        r4 = 2131756963; // 0x7f1007a3 float:1.9144848E38 double:1.0532278807E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.fSX = r4;
        r4 = 2131756964; // 0x7f1007a4 float:1.914485E38 double:1.053227881E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r5.fSY = r4;
        r4 = 2131756961; // 0x7f1007a1 float:1.9144844E38 double:1.0532278797E-314;
        r0 = r25;
        r4 = r0.findViewById(r4);
        r4 = (android.widget.LinearLayout) r4;
        r5.fSZ = r4;
    L_0x00ac:
        r0 = r24;
        r1 = r27;
        r0.a(r5, r1);
        r15 = 0;
        r14 = 0;
        r13 = 0;
        r12 = 0;
        r11 = 0;
        r10 = 0;
        r9 = 0;
        r8 = 0;
        r7 = 0;
        r6 = 0;
        r4 = 0;
        r0 = r27;
        r0 = r0.field_favProto;
        r16 = r0;
        r0 = r16;
        r0 = r0.mtR;
        r18 = r0;
        r19 = r18.iterator();
        r16 = r15;
        r15 = r14;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r4;
    L_0x00da:
        r4 = r19.hasNext();
        if (r4 == 0) goto L_0x01ae;
    L_0x00e0:
        r4 = r19.next();
        r4 = (com.tencent.mm.protocal.c.pw) r4;
        if (r14 != 0) goto L_0x0143;
    L_0x00e8:
        r20 = new java.io.File;
        r21 = com.tencent.mm.plugin.favorite.b.v.f(r4);
        r20.<init>(r21);
        r21 = r20.exists();
        if (r21 != 0) goto L_0x0108;
    L_0x00f7:
        r0 = r27;
        com.tencent.mm.plugin.favorite.c.g.a(r0, r4);
    L_0x00fc:
        r4 = r14 + 1;
        r14 = r4;
        goto L_0x00da;
    L_0x0100:
        r4 = r25.getTag();
        r4 = (com.tencent.mm.plugin.favorite.ui.c.r.a) r4;
        r5 = r4;
        goto L_0x00ac;
    L_0x0108:
        r4 = r4.msU;
        if (r4 != 0) goto L_0x00fc;
    L_0x010c:
        r4 = new com.tencent.mm.e.a.ja;
        r4.<init>();
        r0 = r4.bjr;
        r21 = r0;
        r22 = 10;
        r0 = r22;
        r1 = r21;
        r1.type = r0;
        r0 = r4.bjr;
        r21 = r0;
        r0 = r27;
        r0 = r0.field_localId;
        r22 = r0;
        r0 = r22;
        r2 = r21;
        r2.field_localId = r0;
        r0 = r4.bjr;
        r21 = r0;
        r20 = r20.getAbsolutePath();
        r0 = r20;
        r1 = r21;
        r1.path = r0;
        r20 = com.tencent.mm.sdk.c.a.nhr;
        r0 = r20;
        r0.z(r4);
        goto L_0x00fc;
    L_0x0143:
        r0 = r4.aKG;
        r20 = r0;
        switch(r20) {
            case 1: goto L_0x016c;
            case 2: goto L_0x015f;
            case 3: goto L_0x0184;
            case 4: goto L_0x015f;
            case 5: goto L_0x0178;
            case 6: goto L_0x0190;
            case 7: goto L_0x0178;
            case 8: goto L_0x0178;
            case 9: goto L_0x014a;
            case 10: goto L_0x0178;
            case 11: goto L_0x0178;
            case 12: goto L_0x014a;
            case 13: goto L_0x014a;
            case 14: goto L_0x0178;
            case 15: goto L_0x015f;
            case 16: goto L_0x0178;
            default: goto L_0x014a;
        };
    L_0x014a:
        r4 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
    L_0x0152:
        r13 = r14 + 1;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r4;
        goto L_0x00da;
    L_0x015f:
        if (r10 != 0) goto L_0x014a;
    L_0x0161:
        r10 = 1;
        r4 = r6;
        r15 = r14;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        goto L_0x0152;
    L_0x016c:
        if (r6 != 0) goto L_0x014a;
    L_0x016e:
        r6 = 1;
        r4 = r6;
        r11 = r12;
        r6 = r7;
        r12 = r13;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r14;
        goto L_0x0152;
    L_0x0178:
        if (r9 != 0) goto L_0x014a;
    L_0x017a:
        r9 = 1;
        r4 = r6;
        r12 = r13;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r14;
        goto L_0x0152;
    L_0x0184:
        if (r7 != 0) goto L_0x014a;
    L_0x0186:
        r7 = 1;
        r4 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r14;
        goto L_0x0152;
    L_0x0190:
        r20 = com.tencent.mm.model.ak.vA();
        r21 = new com.tencent.mm.plugin.favorite.ui.c.r$1;
        r0 = r21;
        r1 = r24;
        r0.<init>(r1, r4);
        r20.x(r21);
        if (r8 != 0) goto L_0x014a;
    L_0x01a2:
        r8 = 1;
        r4 = r6;
        r16 = r14;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        goto L_0x0152;
    L_0x01ae:
        r4 = "MicroMsg.FavWNNoteListItem";
        r14 = "hasThumb %s, firstRemarkIndex %d";
        r19 = 2;
        r0 = r19;
        r0 = new java.lang.Object[r0];
        r19 = r0;
        r20 = 0;
        r21 = java.lang.Boolean.valueOf(r10);
        r19[r20] = r21;
        r20 = 1;
        r21 = 0;
        r21 = java.lang.Integer.valueOf(r21);
        r19[r20] = r21;
        r0 = r19;
        com.tencent.mm.sdk.platformtools.v.d(r4, r14, r0);
        r4 = r18.size();
        r14 = 2;
        if (r4 >= r14) goto L_0x01e4;
    L_0x01da:
        r4 = "MicroMsg.FavWNNoteListItem";
        r5 = "dataList size is null";
        com.tencent.mm.sdk.platformtools.v.w(r4, r5);
    L_0x01e3:
        return r25;
    L_0x01e4:
        r4 = r5.fSO;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r5.fSV;
        r14 = 8;
        r4.setVisibility(r14);
        r4 = r5.fSZ;
        r14 = 8;
        r4.setVisibility(r14);
        if (r6 == 0) goto L_0x02c1;
    L_0x01fb:
        r4 = r5.fSV;
        r6 = 0;
        r4.setVisibility(r6);
        r4 = r5.fSK;
        r6 = 0;
        r4.setVisibility(r6);
        r0 = r18;
        r4 = r0.get(r11);
        r4 = (com.tencent.mm.protocal.c.pw) r4;
        r4 = r4.desc;
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r6 != 0) goto L_0x02c1;
    L_0x0217:
        r6 = "&lt;";
        r11 = "<";
        r4 = r4.replaceAll(r6, r11);
        r6 = "&gt;";
        r11 = ">";
        r4 = r4.replaceAll(r6, r11);
        r6 = "\n";
        r11 = r4.split(r6);
        r14 = new java.util.ArrayList;
        r14.<init>();
        r4 = 0;
        r4 = r11[r4];
        r14.add(r4);
        r6 = "";
        r4 = 1;
    L_0x0241:
        r0 = r11.length;
        r19 = r0;
        r0 = r19;
        if (r4 >= r0) goto L_0x026b;
    L_0x0248:
        r19 = new java.lang.StringBuilder;
        r19.<init>();
        r0 = r19;
        r6 = r0.append(r6);
        r19 = r11[r4];
        r0 = r19;
        r6 = r6.append(r0);
        r19 = " ";
        r0 = r19;
        r6 = r6.append(r0);
        r6 = r6.toString();
        r4 = r4 + 1;
        goto L_0x0241;
    L_0x026b:
        r4 = r6.trim();
        r6 = r4.length();
        if (r6 <= 0) goto L_0x0278;
    L_0x0275:
        r14.add(r4);
    L_0x0278:
        r4 = r14.size();
        r6 = 1;
        if (r4 <= r6) goto L_0x02ec;
    L_0x027f:
        r4 = r5.fSL;
        r6 = 0;
        r4.setVisibility(r6);
        r6 = r5.fSK;
        r4 = r5.fSK;
        r11 = r4.getContext();
        r4 = 0;
        r4 = r14.get(r4);
        r4 = (java.lang.CharSequence) r4;
        r0 = r5.fSK;
        r19 = r0;
        r19 = r19.getTextSize();
        r0 = r19;
        r4 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r4, r0);
        r6.setText(r4);
        r6 = r5.fSL;
        r4 = r5.fSL;
        r11 = r4.getContext();
        r4 = 1;
        r4 = r14.get(r4);
        r4 = (java.lang.CharSequence) r4;
        r14 = r5.fSL;
        r14 = r14.getTextSize();
        r4 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r4, r14);
        r6.setText(r4);
    L_0x02c1:
        if (r10 == 0) goto L_0x0310;
    L_0x02c3:
        r4 = r5.fSZ;
        r6 = 8;
        r4.setVisibility(r6);
        r4 = r5.fSO;
        r6 = 0;
        r4.setVisibility(r6);
        r4 = r5.eZn;
        r6 = 0;
        r4.setVisibility(r6);
        r4 = r5.eZn;
        r0 = r18;
        r5 = r0.get(r15);
        r5 = (com.tencent.mm.protocal.c.pw) r5;
        r7 = 1;
        r8 = fSt;
        r9 = fSu;
        r6 = r27;
        com.tencent.mm.plugin.favorite.c.g.a(r4, r5, r6, r7, r8, r9);
        goto L_0x01e3;
    L_0x02ec:
        r4 = r5.fSL;
        r6 = 8;
        r4.setVisibility(r6);
        r6 = r5.fSK;
        r4 = r5.fSK;
        r11 = r4.getContext();
        r4 = 0;
        r4 = r14.get(r4);
        r4 = (java.lang.CharSequence) r4;
        r14 = r5.fSK;
        r14 = r14.getTextSize();
        r4 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r4, r14);
        r6.setText(r4);
        goto L_0x02c1;
    L_0x0310:
        if (r8 == 0) goto L_0x038e;
    L_0x0312:
        r0 = r18;
        r1 = r16;
        r4 = r0.get(r1);
        r4 = (com.tencent.mm.protocal.c.pw) r4;
        r6 = r5.fSO;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r5.eZn;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r5.fSZ;
        r7 = 0;
        r6.setVisibility(r7);
        r6 = r5.fSW;
        r7 = 2131165511; // 0x7f070147 float:1.7945241E38 double:1.0529356646E-314;
        r6.setImageResource(r7);
        r6 = r4.msM;
        r6 = r6.mta;
        r4 = r4.msM;
        r4 = r4.gxy;
        r7 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r7 == 0) goto L_0x036f;
    L_0x0346:
        r4 = r6.bkV;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r4 == 0) goto L_0x035f;
    L_0x034e:
        r4 = r5.fSX;
        r6 = r6.label;
        r4.setText(r6);
        r4 = r5.fSY;
        r5 = 2131232684; // 0x7f0807ac float:1.8081484E38 double:1.0529688525E-314;
        r4.setText(r5);
        goto L_0x01e3;
    L_0x035f:
        r4 = r5.fSX;
        r7 = r6.bkV;
        r4.setText(r7);
        r4 = r5.fSY;
        r5 = r6.label;
        r4.setText(r5);
        goto L_0x01e3;
    L_0x036f:
        r7 = r5.fSX;
        r7.setText(r4);
        r4 = r6.bkV;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r4 == 0) goto L_0x0385;
    L_0x037c:
        r4 = r5.fSY;
        r5 = r6.label;
        r4.setText(r5);
        goto L_0x01e3;
    L_0x0385:
        r4 = r5.fSY;
        r5 = r6.bkV;
        r4.setText(r5);
        goto L_0x01e3;
    L_0x038e:
        if (r9 == 0) goto L_0x03d4;
    L_0x0390:
        r0 = r18;
        r4 = r0.get(r12);
        r4 = (com.tencent.mm.protocal.c.pw) r4;
        r6 = r5.fSO;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r5.eZn;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r5.fSZ;
        r7 = 0;
        r6.setVisibility(r7);
        r6 = r5.fSW;
        r7 = r4.msh;
        r7 = com.tencent.mm.plugin.favorite.b.v.ta(r7);
        r6.setImageResource(r7);
        r6 = r5.fSX;
        r7 = r4.title;
        r6.setText(r7);
        r6 = r4.desc;
        r7 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r7 == 0) goto L_0x0421;
    L_0x03c6:
        r6 = r4.msn;
        r4 = (float) r6;
        r4 = com.tencent.mm.plugin.favorite.b.v.N(r4);
    L_0x03cd:
        r5 = r5.fSY;
        r5.setText(r4);
        goto L_0x01e3;
    L_0x03d4:
        if (r7 == 0) goto L_0x01e3;
    L_0x03d6:
        r0 = r18;
        r4 = r0.get(r13);
        r4 = (com.tencent.mm.protocal.c.pw) r4;
        r6 = r5.fSO;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r5.eZn;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r5.fSZ;
        r7 = 0;
        r6.setVisibility(r7);
        r6 = r5.fSW;
        r7 = 2131165515; // 0x7f07014b float:1.794525E38 double:1.0529356666E-314;
        r6.setImageResource(r7);
        r6 = r5.fSX;
        r7 = 2131231178; // 0x7f0801ca float:1.807843E38 double:1.0529681084E-314;
        r0 = r17;
        r7 = r0.getString(r7);
        r6.setText(r7);
        r4 = r4.duration;
        r6 = (long) r4;
        r4 = com.tencent.mm.plugin.favorite.b.v.au(r6);
        r4 = (int) r4;
        r5 = r5.fSY;
        r0 = r24;
        r6 = r0.fJV;
        r6 = r6.context;
        r4 = com.tencent.mm.plugin.favorite.b.s.v(r6, r4);
        r5.setText(r4);
        goto L_0x01e3;
    L_0x0421:
        r4 = r6;
        goto L_0x03cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.c.r.a(android.view.View, android.view.ViewGroup, com.tencent.mm.plugin.favorite.b.i):android.view.View");
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
