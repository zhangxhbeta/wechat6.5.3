package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class j extends a {
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
        TextView fSM;
        TextView fSN;
        FrameLayout fSO;
    }

    public j(g gVar) {
        super(gVar);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 60);
        this.fSF = " ";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.view.View r11, android.view.ViewGroup r12, com.tencent.mm.plugin.favorite.b.i r13) {
        /*
        r10 = this;
        r0 = r12.getContext();
        if (r11 != 0) goto L_0x009e;
    L_0x0006:
        r1 = new com.tencent.mm.plugin.favorite.ui.c.j$a;
        r1.<init>();
        r2 = 2130903606; // 0x7f030236 float:1.7414035E38 double:1.0528062663E-314;
        r3 = 0;
        r0 = android.view.View.inflate(r0, r2, r3);
        r11 = r10.a(r0, r1, r13);
        r0 = 2131756943; // 0x7f10078f float:1.9144808E38 double:1.053227871E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.eZn = r0;
        r0 = 2131756953; // 0x7f100799 float:1.9144828E38 double:1.053227876E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.fSK = r0;
        r0 = 2131756954; // 0x7f10079a float:1.914483E38 double:1.0532278763E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.fSL = r0;
        r0 = 2131756955; // 0x7f10079b float:1.9144832E38 double:1.0532278767E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.fSM = r0;
        r0 = 2131756956; // 0x7f10079c float:1.9144834E38 double:1.053227877E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.fSN = r0;
        r0 = 2131756951; // 0x7f100797 float:1.9144824E38 double:1.053227875E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.fSI = r0;
        r0 = 2131756952; // 0x7f100798 float:1.9144826E38 double:1.0532278753E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.fSJ = r0;
        r0 = 2131756950; // 0x7f100796 float:1.9144822E38 double:1.0532278743E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.FrameLayout) r0;
        r1.fSO = r0;
        r7 = r1;
    L_0x0070:
        r10.a(r7, r13);
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = 0;
        r5 = r13.field_favProto;
        r6 = r5.mtR;
        r8 = r6.iterator();
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r0;
    L_0x0085:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00b4;
    L_0x008b:
        r0 = r8.next();
        r0 = (com.tencent.mm.protocal.c.pw) r0;
        r0 = r0.aKG;
        switch(r0) {
            case 1: goto L_0x00ad;
            case 2: goto L_0x00a6;
            case 3: goto L_0x00ad;
            case 4: goto L_0x00a6;
            case 5: goto L_0x00ad;
            case 6: goto L_0x00ad;
            case 7: goto L_0x00ad;
            case 8: goto L_0x00ad;
            case 9: goto L_0x0096;
            case 10: goto L_0x00ad;
            case 11: goto L_0x00ad;
            case 12: goto L_0x0096;
            case 13: goto L_0x0096;
            case 14: goto L_0x00ad;
            case 15: goto L_0x00a6;
            case 16: goto L_0x00ad;
            default: goto L_0x0096;
        };
    L_0x0096:
        r0 = r1;
        r1 = r2;
    L_0x0098:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x0085;
    L_0x009e:
        r0 = r11.getTag();
        r0 = (com.tencent.mm.plugin.favorite.ui.c.j.a) r0;
        r7 = r0;
        goto L_0x0070;
    L_0x00a6:
        if (r2 != 0) goto L_0x0096;
    L_0x00a8:
        r2 = 1;
        r0 = r1;
        r4 = r3;
        r1 = r2;
        goto L_0x0098;
    L_0x00ad:
        if (r1 != 0) goto L_0x0096;
    L_0x00af:
        r1 = 1;
        r0 = r1;
        r5 = r3;
        r1 = r2;
        goto L_0x0098;
    L_0x00b4:
        r0 = "MicroMsg.FavRecordListItem";
        r1 = "hasThumb %s, firstRemarkIndex %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r8 = 0;
        r9 = java.lang.Boolean.valueOf(r2);
        r3[r8] = r9;
        r8 = 1;
        r9 = java.lang.Integer.valueOf(r5);
        r3[r8] = r9;
        com.tencent.mm.sdk.platformtools.v.d(r0, r1, r3);
        r0 = r6.size();
        if (r0 > 0) goto L_0x00de;
    L_0x00d4:
        r0 = "MicroMsg.FavRecordListItem";
        r1 = "dataList size is null";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
    L_0x00dd:
        return r11;
    L_0x00de:
        r0 = r6.get(r5);
        r0 = (com.tencent.mm.protocal.c.pw) r0;
        r1 = r7.fSK;
        r3 = r7.fSL;
        a(r1, r3, r0);
        if (r2 == 0) goto L_0x0131;
    L_0x00ed:
        r0 = r7.fSO;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r7.eZn;
        r1 = 0;
        r0.setVisibility(r1);
        r1 = r7.eZn;
        r2 = r6.get(r4);
        r2 = (com.tencent.mm.protocal.c.pw) r2;
        r0 = r2.aKG;
        switch(r0) {
            case 2: goto L_0x0115;
            case 4: goto L_0x0123;
            case 15: goto L_0x0123;
            default: goto L_0x0106;
        };
    L_0x0106:
        r0 = r7.fSM;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r7.fSN;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00dd;
    L_0x0115:
        r0 = r10.fJV;
        r4 = 2131165872; // 0x7f0702b0 float:1.7945973E38 double:1.052935843E-314;
        r5 = r10.fSr;
        r6 = r10.fSr;
        r3 = r13;
        r0.b(r1, r2, r3, r4, r5, r6);
        goto L_0x0106;
    L_0x0123:
        r0 = r10.fJV;
        r4 = 2131165518; // 0x7f07014e float:1.7945255E38 double:1.052935668E-314;
        r5 = r10.fSr;
        r6 = r10.fSr;
        r3 = r13;
        r0.b(r1, r2, r3, r4, r5, r6);
        goto L_0x0106;
    L_0x0131:
        r0 = r7.fSO;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r7.eZn;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r5 + 1;
        r1 = r6.size();
        if (r0 >= r1) goto L_0x0164;
    L_0x0147:
        r0 = r7.fSM;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r7.fSN;
        r1 = 0;
        r0.setVisibility(r1);
        r1 = r7.fSM;
        r2 = r7.fSN;
        r0 = r5 + 1;
        r0 = r6.get(r0);
        r0 = (com.tencent.mm.protocal.c.pw) r0;
        a(r1, r2, r0);
        goto L_0x00dd;
    L_0x0164:
        r0 = "MicroMsg.FavRecordListItem";
        r1 = "outofbound %d, size %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r5);
        r2[r3] = r4;
        r3 = 1;
        r4 = r6.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r0, r1, r2);
        r0 = r7.fSM;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r7.fSN;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00dd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.c.j.a(android.view.View, android.view.ViewGroup, com.tencent.mm.plugin.favorite.b.i):android.view.View");
    }

    private static void a(TextView textView, TextView textView2, pw pwVar) {
        if (pwVar.msP) {
            textView.setVisibility(0);
            textView.setText(e.a(textView.getContext(), pwVar.msO, textView.getTextSize()));
        } else {
            v.d("MicroMsg.FavRecordListItem", "has no datasrcname");
            textView.setVisibility(8);
        }
        v.d("MicroMsg.FavRecordListItem", "field type %d", new Object[]{Integer.valueOf(pwVar.aKG)});
        switch (pwVar.aKG) {
            case 1:
                textView2.setText(e.a(textView2.getContext(), pwVar.desc, textView2.getTextSize()));
                return;
            case 2:
                textView2.setText(x(textView2.getContext(), 2131232735));
                return;
            case 3:
                textView2.setText(x(textView2.getContext(), 2131232740));
                return;
            case 4:
                textView2.setText(x(textView2.getContext(), 2131232739));
                return;
            case 5:
                textView2.setText(x(textView2.getContext(), 2131232738) + pwVar.title);
                return;
            case 6:
                qc qcVar = pwVar.msM.mta;
                textView2.setText(x(textView2.getContext(), 2131232736) + (be.kS(qcVar.bkV) ? qcVar.label : qcVar.bkV));
                return;
            case 7:
                textView2.setText(x(textView2.getContext(), 2131232737) + pwVar.title);
                return;
            case 8:
                textView2.setText(x(textView2.getContext(), 2131232734) + pwVar.title);
                return;
            case 10:
                textView2.setText(x(textView2.getContext(), 2131232686) + pwVar.msM.mte.title);
                return;
            case am.CTRL_INDEX /*15*/:
                textView2.setText(x(textView2.getContext(), 2131232732));
                return;
            case 16:
                textView2.setText(x(textView2.getContext(), 2131232671));
                return;
            default:
                return;
        }
    }

    private static String x(Context context, int i) {
        return "[" + context.getResources().getString(i) + "]";
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
