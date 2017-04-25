package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMImageView;
import java.util.List;
import java.util.regex.Pattern;

public final class a extends com.tencent.mm.ui.f.a.a {
    private static final Pattern fRX = Pattern.compile("['​']+");
    private static final ac handler = new ac(Looper.getMainLooper());
    public h eAt;
    public List<String> ezU;
    public CharSequence fRY;
    public CharSequence fRZ;
    public CharSequence fSa;
    public String fSb;
    public String fSc;
    public int fSd;
    private b fSe = new b(this);
    a fSf = new a(this);

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public TextView dtY;
        public MMImageView fSg;
        public TextView fSh;
        public TextView fSi;
        final /* synthetic */ a fSj;

        public a(a aVar) {
            this.fSj = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ a fSj;

        public b(a aVar) {
            this.fSj = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903681, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.fSj.fSf;
            aVar.fSg = (MMImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.fSh = (TextView) inflate.findViewById(2131757173);
            aVar.fSi = (TextView) inflate.findViewById(2131757174);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            a aVar3 = (a) aVar;
            a aVar4 = (a) aVar2;
            cY(aVar3.dtW);
            com.tencent.mm.modelsearch.h.a(context, aVar3.fSg, aVar4.fSc, aVar4.fSb, aVar4.fSd, aVar3.fSg.getMeasuredWidth(), aVar3.fSg.getMeasuredHeight());
            a.a(aVar3.dtY, aVar3.fSh, this.fSj.fRY, this.fSj.fRZ);
            com.tencent.mm.modelsearch.h.b(this.fSj.fSa, aVar3.fSi);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            a aVar2 = (a) aVar;
            ez ezVar = new ez();
            ezVar.bdQ.type = 10;
            ezVar.bdQ.aZa = aVar2.eAt.cWu;
            ezVar.bdQ.context = context;
            com.tencent.mm.sdk.c.a.nhr.z(ezVar);
            return true;
        }
    }

    public static void a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        if (com.tencent.mm.modelsearch.h.b(charSequence, textView)) {
            if (com.tencent.mm.modelsearch.h.b(charSequence2, textView2)) {
                textView.setMaxLines(1);
                textView2.setMaxLines(1);
                return;
            }
            textView.setMaxLines(2);
        } else if (com.tencent.mm.modelsearch.h.b(charSequence2, textView2)) {
            textView2.setMaxLines(2);
        }
    }

    public a(int i) {
        super(7, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r14, com.tencent.mm.ui.f.a.a.a r15) {
        /*
        r13 = this;
        r1 = 0;
        r11 = 2;
        r5 = -1;
        r4 = 0;
        r3 = 1;
        r0 = r13.eAt;
        r6 = r0.cWu;
        r0 = new com.tencent.mm.e.a.ez;
        r0.<init>();
        r2 = r0.bdQ;
        r8 = 9;
        r2.type = r8;
        r2 = r0.bdQ;
        r2.aZa = r6;
        r2 = com.tencent.mm.sdk.c.a.nhr;
        r2.z(r0);
        r0 = r0.bdR;
        r7 = r0.beb;
        r0 = r13.eAt;
        r8 = r0.cWu;
        r0 = new com.tencent.mm.e.a.ez;
        r0.<init>();
        r2 = r0.bdQ;
        r6 = 11;
        r2.type = r6;
        r2 = r0.bdQ;
        r2.aZa = r8;
        r2 = r0.bdQ;
        r6 = handler;
        r2.handler = r6;
        r2 = com.tencent.mm.sdk.c.a.nhr;
        r2.z(r0);
        r2 = r0.bdR;
        r2 = r2.bdZ;
        r6 = "";
        r2 = com.tencent.mm.sdk.platformtools.be.ah(r2, r6);
        r13.fSb = r2;
        r0 = r0.bdR;
        r0 = r0.bea;
        r2 = "";
        r0 = com.tencent.mm.sdk.platformtools.be.ah(r0, r2);
        r13.fSc = r0;
        r2 = r13.eAt;
        r6 = r13.ezU;
        r15 = (com.tencent.mm.plugin.favorite.ui.b.a.a) r15;
        r0 = r15.dtY;
        r0 = r0.getMeasuredWidth();
        r0 = r0 * 2;
        r8 = (float) r0;
        r9 = r7.bmi;
        r0 = "";
        r10 = r7.type;
        switch(r10) {
            case 1: goto L_0x00de;
            case 2: goto L_0x00e1;
            case 3: goto L_0x014f;
            case 4: goto L_0x0142;
            case 5: goto L_0x0072;
            case 6: goto L_0x00ed;
            case 7: goto L_0x01b1;
            case 8: goto L_0x0072;
            case 9: goto L_0x0072;
            case 10: goto L_0x015c;
            case 11: goto L_0x015c;
            case 12: goto L_0x0072;
            case 13: goto L_0x0072;
            case 14: goto L_0x0166;
            case 15: goto L_0x0072;
            case 16: goto L_0x01d7;
            default: goto L_0x0072;
        };
    L_0x0072:
        r0 = r7.title;
    L_0x0074:
        r2 = r2.cWt;
        switch(r2) {
            case 1: goto L_0x01e4;
            case 2: goto L_0x01e4;
            case 3: goto L_0x01e4;
            case 4: goto L_0x01e4;
            case 5: goto L_0x01e4;
            case 6: goto L_0x01e4;
            default: goto L_0x0079;
        };
    L_0x0079:
        r13.fRY = r0;
        r2 = r13.eAt;
        r6 = r13.ezU;
        r8 = r7.bmi;
        r0 = "";
        r9 = r7.type;
        switch(r9) {
            case 2: goto L_0x0201;
            case 3: goto L_0x0089;
            case 4: goto L_0x0089;
            case 5: goto L_0x01ef;
            case 6: goto L_0x0205;
            case 7: goto L_0x01ef;
            case 8: goto L_0x0089;
            case 9: goto L_0x0089;
            case 10: goto L_0x0221;
            case 11: goto L_0x0221;
            case 12: goto L_0x01ef;
            case 13: goto L_0x0089;
            case 14: goto L_0x022b;
            case 15: goto L_0x01ef;
            default: goto L_0x0089;
        };
    L_0x0089:
        r0 = "";
    L_0x008c:
        r2 = r2.cWt;
        switch(r2) {
            case 6: goto L_0x024f;
            case 7: goto L_0x023c;
            case 8: goto L_0x023c;
            case 23: goto L_0x0230;
            default: goto L_0x0091;
        };
    L_0x0091:
        r2 = "";
        r6 = r0;
        r0 = r2;
        r2 = r5;
    L_0x0097:
        if (r2 == r5) goto L_0x00b1;
    L_0x0099:
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r5 != 0) goto L_0x00b1;
    L_0x009f:
        r5 = new java.lang.CharSequence[r11];
        r6 = r14.getResources();
        r2 = r6.getString(r2);
        r5[r4] = r2;
        r5[r3] = r0;
        r0 = android.text.TextUtils.concat(r5);
    L_0x00b1:
        r13.fRZ = r0;
        r6 = r13.eAt;
        r8 = r13.ezU;
        r2 = r7.bhM;
        r0 = r7.mtF;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r5 == 0) goto L_0x00c3;
    L_0x00c1:
        r2 = r0;
        r0 = r1;
    L_0x00c3:
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r5 == 0) goto L_0x0258;
    L_0x00c9:
        r0 = new android.text.SpannableString;
        r1 = "";
        r0.<init>(r1);
    L_0x00d1:
        r13.fSa = r0;
        r0 = r7.type;
        switch(r0) {
            case 3: goto L_0x034b;
            case 4: goto L_0x0350;
            case 5: goto L_0x0346;
            case 6: goto L_0x0355;
            case 7: goto L_0x00d8;
            case 8: goto L_0x0324;
            default: goto L_0x00d8;
        };
    L_0x00d8:
        r0 = 2131165590; // 0x7f070196 float:1.7945401E38 double:1.0529357036E-314;
    L_0x00db:
        r13.fSd = r0;
        return;
    L_0x00de:
        r0 = r7.desc;
        goto L_0x0074;
    L_0x00e1:
        r0 = r14.getResources();
        r9 = 2131234849; // 0x7f081021 float:1.8085875E38 double:1.052969922E-314;
        r0 = r0.getString(r9);
        goto L_0x0074;
    L_0x00ed:
        r0 = r9.gxy;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x012a;
    L_0x00f5:
        r0 = r9.gxy;
        r10 = r9.mta;
        if (r10 == 0) goto L_0x0074;
    L_0x00fb:
        r10 = r9.mta;
        r10 = r10.bkV;
        r10 = com.tencent.mm.sdk.platformtools.be.kS(r10);
        if (r10 != 0) goto L_0x0074;
    L_0x0105:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r0 = r10.append(r0);
        r10 = "(";
        r0 = r0.append(r10);
        r9 = r9.mta;
        r9 = r9.bkV;
        r0 = r0.append(r9);
        r9 = ")";
        r0 = r0.append(r9);
        r0 = r0.toString();
        goto L_0x0074;
    L_0x012a:
        r0 = r9.mta;
        if (r0 == 0) goto L_0x013e;
    L_0x012e:
        r0 = r9.mta;
        r0 = r0.bkV;
        r10 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r10 == 0) goto L_0x0074;
    L_0x0138:
        r0 = r9.mta;
        r0 = r0.label;
        goto L_0x0074;
    L_0x013e:
        r0 = r7.desc;
        goto L_0x0074;
    L_0x0142:
        r0 = r14.getResources();
        r9 = 2131234853; // 0x7f081025 float:1.8085883E38 double:1.052969924E-314;
        r0 = r0.getString(r9);
        goto L_0x0074;
    L_0x014f:
        r0 = r14.getResources();
        r9 = 2131234854; // 0x7f081026 float:1.8085885E38 double:1.0529699246E-314;
        r0 = r0.getString(r9);
        goto L_0x0074;
    L_0x015c:
        r10 = r9.mte;
        if (r10 == 0) goto L_0x0074;
    L_0x0160:
        r0 = r9.mte;
        r0 = r0.title;
        goto L_0x0074;
    L_0x0166:
        r0 = fRX;
        r9 = r2.content;
        r0 = r0.matcher(r9);
        r9 = "​";
        r0 = r0.replaceAll(r9);
        r9 = "​";
        r9 = r0.endsWith(r9);
        if (r9 == 0) goto L_0x0194;
    L_0x017e:
        r9 = r0.length();
        r9 = r9 + -1;
        r9 = r9 + -1;
        if (r9 <= 0) goto L_0x0194;
    L_0x0188:
        r9 = r0.length();
        r9 = r9 + -1;
        r9 = r9 + -1;
        r0 = r0.substring(r4, r9);
    L_0x0194:
        r9 = "​";
        r10 = ", ";
        r0 = r0.replaceAll(r9, r10);
        r9 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r9 == 0) goto L_0x0074;
    L_0x01a4:
        r0 = r14.getResources();
        r9 = 2131234851; // 0x7f081023 float:1.808588E38 double:1.052969923E-314;
        r0 = r0.getString(r9);
        goto L_0x0074;
    L_0x01b1:
        r0 = r7.title;
        r9 = r7.desc;
        r9 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r9 != 0) goto L_0x0074;
    L_0x01bb:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r9.append(r0);
        r9 = "-";
        r0 = r0.append(r9);
        r9 = r7.desc;
        r0 = r0.append(r9);
        r0 = r0.toString();
        goto L_0x0074;
    L_0x01d7:
        r0 = r14.getResources();
        r9 = 2131234852; // 0x7f081024 float:1.8085881E38 double:1.0529699236E-314;
        r0 = r0.getString(r9);
        goto L_0x0074;
    L_0x01e4:
        r2 = com.tencent.mm.modelsearch.h.cVQ;
        r9 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r8 = r8 - r9;
        r0 = com.tencent.mm.modelsearch.h.a(r14, r0, r6, r2, r8);
        goto L_0x0079;
    L_0x01ef:
        r8 = r7.appId;
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r8 != 0) goto L_0x008c;
    L_0x01f7:
        r0 = com.tencent.mm.model.ab.a.csc;
        r8 = r7.appId;
        r0 = r0.n(r14, r8);
        goto L_0x008c;
    L_0x0201:
        r0 = r7.title;
        goto L_0x008c;
    L_0x0205:
        r9 = r8.mta;
        if (r9 == 0) goto L_0x008c;
    L_0x0209:
        r0 = r8.mta;
        r0 = r0.label;
        r9 = r8.gxy;
        r9 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r9 == 0) goto L_0x008c;
    L_0x0215:
        r8 = r8.mta;
        r8 = r8.bkV;
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r8 == 0) goto L_0x008c;
    L_0x021f:
        goto L_0x0089;
    L_0x0221:
        r9 = r8.mte;
        if (r9 == 0) goto L_0x008c;
    L_0x0225:
        r0 = r8.mte;
        r0 = r0.desc;
        goto L_0x008c;
    L_0x022b:
        r0 = "";
        goto L_0x008c;
    L_0x0230:
        r2 = 2131234848; // 0x7f081020 float:1.8085873E38 double:1.0529699216E-314;
        r6 = com.tencent.mm.modelsearch.h.a(r14, r0, r6);
        r12 = r0;
        r0 = r6;
        r6 = r12;
        goto L_0x0097;
    L_0x023c:
        r0 = 2131234850; // 0x7f081022 float:1.8085877E38 double:1.0529699226E-314;
        r2 = r7.mtG;
        r2 = c(r2, r6);
        r6 = com.tencent.mm.modelsearch.h.a(r14, r2, r6);
        r12 = r0;
        r0 = r6;
        r6 = r2;
        r2 = r12;
        goto L_0x0097;
    L_0x024f:
        r2 = com.tencent.mm.modelsearch.h.a(r14, r0, r6);
        r6 = r0;
        r0 = r2;
        r2 = r5;
        goto L_0x0097;
    L_0x0258:
        com.tencent.mm.model.ak.yW();
        r5 = com.tencent.mm.model.c.wH();
        r9 = r5.LX(r2);
        r9.setUsername(r2);
        r2 = com.tencent.mm.model.m.dE(r2);
        if (r2 == 0) goto L_0x0280;
    L_0x026c:
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r2 != 0) goto L_0x0280;
    L_0x0272:
        com.tencent.mm.model.ak.yW();
        r1 = com.tencent.mm.model.c.wH();
        r1 = r1.LX(r0);
        r1.setUsername(r0);
    L_0x0280:
        r0 = r6.cWt;
        switch(r0) {
            case 9: goto L_0x0362;
            case 10: goto L_0x0360;
            case 11: goto L_0x0305;
            case 12: goto L_0x0365;
            case 13: goto L_0x035d;
            case 14: goto L_0x02d6;
            case 15: goto L_0x0285;
            case 16: goto L_0x0362;
            case 17: goto L_0x0360;
            case 18: goto L_0x0305;
            default: goto L_0x0285;
        };
    L_0x0285:
        r0 = r4;
        r2 = r4;
        r5 = r4;
    L_0x0288:
        if (r1 == 0) goto L_0x030b;
    L_0x028a:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r1 = a(r1, r3);
        r1 = r10.append(r1);
        r10 = "-";
        r1 = r1.append(r10);
        r9 = c(r14, r9);
        r1 = r1.append(r9);
        r1 = r1.toString();
    L_0x02aa:
        r9 = 2131493128; // 0x7f0c0108 float:1.8609727E38 double:1.053097529E-314;
        r9 = com.tencent.mm.bd.a.N(r14, r9);
        r1 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r1, r9);
        if (r5 == 0) goto L_0x035a;
    L_0x02b7:
        if (r0 == 0) goto L_0x031d;
    L_0x02b9:
        r0 = r13.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r1, r8, r2, r0);
    L_0x02bf:
        r1 = new java.lang.CharSequence[r11];
        r2 = r14.getResources();
        r5 = 2131234810; // 0x7f080ffa float:1.8085796E38 double:1.052969903E-314;
        r2 = r2.getString(r5);
        r1[r4] = r2;
        r1[r3] = r0;
        r0 = android.text.TextUtils.concat(r1);
        goto L_0x00d1;
    L_0x02d6:
        r0 = r3;
    L_0x02d7:
        r2 = r3;
        r5 = r0;
    L_0x02d9:
        if (r1 == 0) goto L_0x0300;
    L_0x02db:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = a(r1, r4);
        r0 = r0.append(r1);
        r1 = "-";
        r0 = r0.append(r1);
        r1 = c(r14, r9);
        r0 = r0.append(r1);
        r0 = r0.toString();
    L_0x02fb:
        r1 = r0;
        r0 = r2;
        r2 = r5;
        r5 = r3;
        goto L_0x02aa;
    L_0x0300:
        r0 = a(r9, r4);
        goto L_0x02fb;
    L_0x0305:
        r0 = r3;
    L_0x0306:
        r2 = r0;
        r0 = r3;
    L_0x0308:
        r5 = r3;
        goto L_0x0288;
    L_0x030b:
        r1 = r9.field_username;
        r1 = com.tencent.mm.model.m.dE(r1);
        if (r1 == 0) goto L_0x0318;
    L_0x0313:
        r1 = c(r14, r9);
        goto L_0x02aa;
    L_0x0318:
        r1 = a(r9, r3);
        goto L_0x02aa;
    L_0x031d:
        r0 = r13.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r1, r8, r0, r6);
        goto L_0x02bf;
    L_0x0324:
        r0 = r7.bmi;
        r0 = r0.mtR;
        if (r0 == 0) goto L_0x00d8;
    L_0x032a:
        r0 = r7.bmi;
        r0 = r0.mtR;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x00d8;
    L_0x0334:
        r0 = r7.bmi;
        r0 = r0.mtR;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.protocal.c.pw) r0;
        r0 = r0.msh;
        r0 = com.tencent.mm.pluginsdk.c.Ga(r0);
        goto L_0x00db;
    L_0x0346:
        r0 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        goto L_0x00db;
    L_0x034b:
        r0 = 2131165246; // 0x7f07003e float:1.7944704E38 double:1.0529355337E-314;
        goto L_0x00db;
    L_0x0350:
        r0 = 2131165244; // 0x7f07003c float:1.79447E38 double:1.0529355327E-314;
        goto L_0x00db;
    L_0x0355:
        r0 = 2131165231; // 0x7f07002f float:1.7944673E38 double:1.0529355262E-314;
        goto L_0x00db;
    L_0x035a:
        r0 = r1;
        goto L_0x02bf;
    L_0x035d:
        r0 = r4;
        goto L_0x02d7;
    L_0x0360:
        r0 = r4;
        goto L_0x0306;
    L_0x0362:
        r0 = r4;
        r2 = r4;
        goto L_0x0308;
    L_0x0365:
        r2 = r4;
        r5 = r4;
        goto L_0x02d9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.b.a.a(android.content.Context, com.tencent.mm.ui.f.a.a$a):void");
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.fSe;
    }

    private static String a(u uVar, boolean z) {
        String str;
        if (!z || be.kS(uVar.field_conRemark)) {
            str = uVar.field_nickname;
        } else {
            str = uVar.field_conRemark;
        }
        if (be.kS(str)) {
            return uVar.field_username;
        }
        return str;
    }

    private static String c(Context context, u uVar) {
        String str = uVar.field_conRemark;
        if (be.kS(str)) {
            str = uVar.field_nickname;
        }
        if (be.kS(str)) {
            return context.getString(2131234812);
        }
        return str;
    }

    private static String c(List<String> list, List<String> list2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String toLowerCase : list2) {
            CharSequence toLowerCase2 = toLowerCase.toLowerCase();
            for (String toLowerCase3 : list) {
                if (toLowerCase3.toLowerCase().contains(toLowerCase2)) {
                    stringBuffer.append(toLowerCase3);
                    stringBuffer.append(" ");
                }
            }
        }
        stringBuffer.trimToSize();
        return stringBuffer.toString();
    }

    public final int YM() {
        return this.eAt.cWA;
    }
}
