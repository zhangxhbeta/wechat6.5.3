package com.tencent.mm.ui;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.t.c;
import java.util.ArrayList;

public final class s {
    private static s nGx = null;
    private SparseArray<b> nGA = new SparseArray();
    private ArrayList<Integer> nGB = new ArrayList();
    public SparseArray<c> nGC = new SparseArray();
    private boolean nGD = false;
    int nGy = 0;
    private SparseIntArray nGz = new SparseIntArray();
    private long timestamp = 0;

    public static s bAC() {
        if (nGx == null) {
            nGx = new s();
        }
        return nGx;
    }

    public final void vO(int i) {
        if (this.nGA.size() != 0) {
            b bVar = (b) this.nGA.get(i);
            if (bVar != null && bVar.nGI == 1) {
                this.nGz.put(bVar.id, bVar.cZF);
                this.nGy--;
                if (this.nGD) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < this.nGz.size(); i2++) {
                        int keyAt = this.nGz.keyAt(i2);
                        Integer valueOf = Integer.valueOf(this.nGz.get(keyAt));
                        stringBuffer.append(keyAt);
                        stringBuffer.append(":");
                        stringBuffer.append(valueOf);
                        stringBuffer.append("|");
                    }
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(299010, stringBuffer.toString());
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ja(boolean r15) {
        /*
        r14 = this;
        r13 = 2;
        r5 = 1;
        r3 = 0;
        if (r15 != 0) goto L_0x001e;
    L_0x0005:
        r0 = r14.nGA;	 Catch:{ Exception -> 0x00de }
        r0 = r0.size();	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x001b;
    L_0x000d:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00de }
        r6 = r14.timestamp;	 Catch:{ Exception -> 0x00de }
        r0 = r0 - r6;
        r6 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x00d0;
    L_0x001b:
        r0 = r5;
    L_0x001c:
        if (r0 == 0) goto L_0x00ea;
    L_0x001e:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00de }
        r0 = r14.nGA;	 Catch:{ Exception -> 0x00de }
        r0.clear();	 Catch:{ Exception -> 0x00de }
        r0 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r0.clear();	 Catch:{ Exception -> 0x00de }
        r0 = com.tencent.mm.h.j.sU();	 Catch:{ Exception -> 0x00de }
        r1 = "TopRightMenu\\d*";
        r0 = r0.dy(r1);	 Catch:{ Exception -> 0x00de }
        r1 = "MicroMsg.PlusMenaDataManager";
        r2 = "dynaConfigs size %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00de }
        r8 = 0;
        r9 = r0.size();	 Catch:{ Exception -> 0x00de }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x00de }
        r4[r8] = r9;	 Catch:{ Exception -> 0x00de }
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r4);	 Catch:{ Exception -> 0x00de }
        r2 = r0.iterator();	 Catch:{ Exception -> 0x00de }
    L_0x0052:
        r0 = r2.hasNext();	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x0136;
    L_0x0058:
        r0 = r2.next();	 Catch:{ Exception -> 0x00de }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00de }
        r1 = "Menu";
        r1 = com.tencent.mm.sdk.platformtools.bf.q(r0, r1);	 Catch:{ Exception -> 0x00de }
        if (r1 == 0) goto L_0x0052;
    L_0x0067:
        r0 = r1.size();	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x0052;
    L_0x006d:
        r0 = ".Menu.$id";
        r0 = r1.get(r0);	 Catch:{ Exception -> 0x00de }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00de }
        r4 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x00de }
        r0 = ".Menu.$shownew";
        r0 = r1.get(r0);	 Catch:{ Exception -> 0x00de }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00de }
        r8 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x00de }
        r0 = ".Menu.$seq";
        r0 = r1.get(r0);	 Catch:{ Exception -> 0x00de }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00de }
        r9 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x00de }
        r0 = ".Menu.$order";
        r0 = r1.get(r0);	 Catch:{ Exception -> 0x00de }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00de }
        r10 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x00de }
        r0 = r14.nGA;	 Catch:{ Exception -> 0x00de }
        r1 = new com.tencent.mm.ui.t$b;	 Catch:{ Exception -> 0x00de }
        r1.<init>(r4, r8, r9, r10);	 Catch:{ Exception -> 0x00de }
        r0.put(r4, r1);	 Catch:{ Exception -> 0x00de }
        r1 = r3;
    L_0x00ac:
        r0 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r0 = r0.size();	 Catch:{ Exception -> 0x00de }
        if (r1 >= r0) goto L_0x00d3;
    L_0x00b4:
        r8 = r14.nGA;	 Catch:{ Exception -> 0x00de }
        r0 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x00de }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x00de }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x00de }
        r0 = r8.get(r0);	 Catch:{ Exception -> 0x00de }
        r0 = (com.tencent.mm.ui.t.b) r0;	 Catch:{ Exception -> 0x00de }
        r0 = r0.order;	 Catch:{ Exception -> 0x00de }
        if (r0 > r10) goto L_0x00d3;
    L_0x00cc:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00ac;
    L_0x00d0:
        r0 = r3;
        goto L_0x001c;
    L_0x00d3:
        r0 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00de }
        r0.add(r1, r4);	 Catch:{ Exception -> 0x00de }
        goto L_0x0052;
    L_0x00de:
        r0 = move-exception;
        r1 = "MicroMsg.PlusMenaDataManager";
        r2 = "";
        r4 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r4);
    L_0x00ea:
        r14.nGy = r3;
        r1 = r3;
        r2 = r3;
    L_0x00ee:
        r0 = r14.nGB;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0265;
    L_0x00f6:
        r0 = r14.nGB;
        r0 = r0.get(r1);
        r0 = (java.lang.Integer) r0;
        r4 = r0.intValue();
        r0 = r14.nGA;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.ui.t.b) r0;
        r6 = com.tencent.mm.ui.t.vP(r4);
        if (r6 == 0) goto L_0x0132;
    L_0x0110:
        r7 = new com.tencent.mm.ui.t$c;
        r7.<init>(r6);
        r6 = r14.nGC;
        r6.put(r2, r7);
        r6 = r14.nGz;
        r4 = r6.get(r4);
        r6 = r0.nGI;
        if (r6 != r5) goto L_0x0130;
    L_0x0124:
        r0 = r0.cZF;
        if (r4 == r0) goto L_0x0130;
    L_0x0128:
        r7.nGK = r5;
        r0 = r14.nGy;
        r0 = r0 + 1;
        r14.nGy = r0;
    L_0x0130:
        r2 = r2 + 1;
    L_0x0132:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00ee;
    L_0x0136:
        r0 = "MicroMsg.PlusMenaDataManager";
        r1 = "dynaMenuOrder size %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00de }
        r4 = 0;
        r8 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r8 = r8.size();	 Catch:{ Exception -> 0x00de }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x00de }
        r2[r4] = r8;	 Catch:{ Exception -> 0x00de }
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);	 Catch:{ Exception -> 0x00de }
        r0 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r0 = r0.size();	 Catch:{ Exception -> 0x00de }
        if (r0 != 0) goto L_0x0184;
    L_0x0157:
        r0 = r14.nGA;	 Catch:{ Exception -> 0x00de }
        r0.clear();	 Catch:{ Exception -> 0x00de }
        r0 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r0.clear();	 Catch:{ Exception -> 0x00de }
        r0 = com.tencent.mm.h.j.sU();	 Catch:{ Exception -> 0x00de }
        r1 = "TopRightMenus";
        r0 = r0.getValue(r1);	 Catch:{ Exception -> 0x00de }
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);	 Catch:{ Exception -> 0x00de }
        if (r1 != 0) goto L_0x0184;
    L_0x0172:
        r1 = "TopRightMenus";
        r8 = com.tencent.mm.sdk.platformtools.bf.q(r0, r1);	 Catch:{ Exception -> 0x00de }
        if (r8 != 0) goto L_0x01ae;
    L_0x017b:
        r0 = "MicroMsg.PlusMenaDataManager";
        r1 = "TopRightMenus is not right";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);	 Catch:{ Exception -> 0x00de }
    L_0x0184:
        r0 = r14.nGA;	 Catch:{ Exception -> 0x00de }
        r0 = r0.size();	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x018f;
    L_0x018c:
        r14.bAD();	 Catch:{ Exception -> 0x00de }
    L_0x018f:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00de }
        r14.timestamp = r0;	 Catch:{ Exception -> 0x00de }
        r0 = "MicroMsg.PlusMenaDataManager";
        r1 = " plus menu load data spent time : %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00de }
        r4 = 0;
        r8 = r14.timestamp;	 Catch:{ Exception -> 0x00de }
        r6 = r8 - r6;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x00de }
        r2[r4] = r6;	 Catch:{ Exception -> 0x00de }
        com.tencent.mm.sdk.platformtools.v.d(r0, r1, r2);	 Catch:{ Exception -> 0x00de }
        goto L_0x00ea;
    L_0x01ae:
        r4 = r3;
    L_0x01af:
        r0 = 100;
        if (r4 >= r0) goto L_0x0184;
    L_0x01b3:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00de }
        r0 = ".TopRightMenus.Menu";
        r1.<init>(r0);	 Catch:{ Exception -> 0x00de }
        if (r4 != 0) goto L_0x025f;
    L_0x01bd:
        r0 = "";
    L_0x01c0:
        r0 = r1.append(r0);	 Catch:{ Exception -> 0x00de }
        r2 = r0.toString();	 Catch:{ Exception -> 0x00de }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00de }
        r0.<init>();	 Catch:{ Exception -> 0x00de }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00de }
        r1 = ".$id";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00de }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00de }
        r0 = r8.get(r0);	 Catch:{ Exception -> 0x00de }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x0184;
    L_0x01e4:
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);	 Catch:{ Exception -> 0x00de }
        if (r1 != 0) goto L_0x0184;
    L_0x01ea:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00de }
        r1.<init>();	 Catch:{ Exception -> 0x00de }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00de }
        r9 = ".$shownew";
        r1 = r1.append(r9);	 Catch:{ Exception -> 0x00de }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00de }
        r1 = r8.get(r1);	 Catch:{ Exception -> 0x00de }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x00de }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00de }
        r9.<init>();	 Catch:{ Exception -> 0x00de }
        r2 = r9.append(r2);	 Catch:{ Exception -> 0x00de }
        r9 = ".$seq";
        r2 = r2.append(r9);	 Catch:{ Exception -> 0x00de }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00de }
        r2 = r8.get(r2);	 Catch:{ Exception -> 0x00de }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x00de }
        r9 = "MicroMsg.PlusMenaDataManager";
        r10 = "got plus panel configs : %s %s %s";
        r11 = 3;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x00de }
        r12 = 0;
        r11[r12] = r0;	 Catch:{ Exception -> 0x00de }
        r12 = 1;
        r11[r12] = r1;	 Catch:{ Exception -> 0x00de }
        r12 = 2;
        r11[r12] = r2;	 Catch:{ Exception -> 0x00de }
        com.tencent.mm.sdk.platformtools.v.d(r9, r10, r11);	 Catch:{ Exception -> 0x00de }
        r9 = r14.nGA;	 Catch:{ Exception -> 0x00de }
        r10 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x00de }
        r11 = new com.tencent.mm.ui.t$b;	 Catch:{ Exception -> 0x00de }
        r12 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x00de }
        r1 = com.tencent.mm.sdk.platformtools.be.KL(r1);	 Catch:{ Exception -> 0x00de }
        r2 = com.tencent.mm.sdk.platformtools.be.KL(r2);	 Catch:{ Exception -> 0x00de }
        r11.<init>(r12, r1, r2);	 Catch:{ Exception -> 0x00de }
        r9.put(r10, r11);	 Catch:{ Exception -> 0x00de }
        r1 = r14.nGB;	 Catch:{ Exception -> 0x00de }
        r0 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x00de }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00de }
        r1.add(r0);	 Catch:{ Exception -> 0x00de }
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x01af;
    L_0x025f:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00de }
        goto L_0x01c0;
    L_0x0265:
        r0 = "MicroMsg.PlusMenaDataManager";
        r1 = "dynaMenuOrder.size() %s menuDataMap.size() %s";
        r4 = new java.lang.Object[r13];
        r6 = r14.nGB;
        r6 = r6.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r3] = r6;
        r3 = r14.nGC;
        r3 = r3.size();
        r3 = java.lang.Integer.valueOf(r3);
        r4[r5] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r4);
        r0 = r14.nGC;
        r1 = new com.tencent.mm.ui.t$c;
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r3 = com.tencent.mm.ui.t.vP(r3);
        r1.<init>(r3);
        r0.put(r2, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.s.ja(boolean):void");
    }

    private void bAD() {
        this.nGz.clear();
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(299010, null);
        if (!be.kS(str)) {
            String[] split = str.split("\\|");
            for (String split2 : split) {
                String[] split3 = split2.split("\\:");
                if (split3.length == 2) {
                    this.nGz.put(be.KL(split3[0]), be.KL(split3[1]));
                }
            }
        }
        this.nGD = true;
    }
}
