package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.h.j;
import com.tencent.mm.modelsearch.k;
import com.tencent.mm.modelsearch.l;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.f.f.b;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class f extends b implements b {
    protected boolean iGM;
    private ac iGN = new ac(Looper.getMainLooper());
    private boolean iHF;
    private boolean iHG;
    private List<com.tencent.mm.ui.f.f> iHR;
    private k iHS = new k();
    private long iHT;
    private long iHU;
    private long iHV;
    private long iHW;
    private ac iHX = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ f iIa;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!this.iIa.iHG && this.iIa.getCount() > 0) {
                        e.bIM().aMI();
                        ak.lye.start();
                        this.iIa.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int iHY = -1;
    boolean iHZ;
    private int iHb = 1;

    private class a implements Runnable {
        private String bkC;
        final /* synthetic */ f iIa;
        private com.tencent.mm.ui.f.f iIb;

        a(f fVar, com.tencent.mm.ui.f.f fVar2, String str) {
            this.iIa = fVar;
            this.bkC = str;
            this.iIb = fVar2;
        }

        public final void run() {
            if (!this.iIa.iHZ && ((com.tencent.mm.ui.f.f) this.iIa.iHR.get(this.iIa.iHR.size() - 1)).getType() == this.iIb.getType()) {
                this.iIa.iHZ = true;
            }
            int i = 0;
            for (com.tencent.mm.ui.f.f xY : this.iIa.iHR) {
                i = xY.xY(i);
            }
            this.iIa.pf(i);
            this.iIa.notifyDataSetChanged();
            this.iIa.D(i, this.iIa.iHZ);
            if (this.iIa.iHZ) {
                this.iIa.iHS.cVG = System.currentTimeMillis();
            }
        }
    }

    public f(c cVar, int i) {
        super(cVar);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(16));
        hashSet.add(Integer.valueOf(32));
        hashSet.add(Integer.valueOf(48));
        hashSet.add(Integer.valueOf(64));
        hashSet.add(Integer.valueOf(80));
        hashSet.add(Integer.valueOf(128));
        hashSet.add(Integer.valueOf(96));
        hashSet.add(Integer.valueOf(112));
        nd ndVar = new nd();
        com.tencent.mm.sdk.c.a.nhr.z(ndVar);
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100193");
        if (Ls.isValid() && "1".equals(Ls.buX().get("isOpenLocalSearch")) && ndVar.dRM.dRN) {
            hashSet.add(Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX));
        }
        this.iHR = e.a(hashSet, getContext(), this, i);
    }

    protected final com.tencent.mm.ui.f.a.a pe(int i) {
        com.tencent.mm.ui.f.a.a aVar = null;
        for (com.tencent.mm.ui.f.f pe : this.iHR) {
            aVar = pe.pe(i);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.ui.f.a.a aVar2 = aVar;
        if (aVar2 != null) {
            LinkedList linkedList = new LinkedList();
            for (com.tencent.mm.ui.f.f pe2 : this.iHR) {
                linkedList.addAll(pe2.bIK());
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                if (i > ((Integer) linkedList.get(size)).intValue()) {
                    i -= size;
                    break;
                }
            }
            aVar2.oJg = i;
            if (aVar2.position == getCount() - 1) {
                aVar2.oPt = true;
            }
        }
        return aVar2;
    }

    protected final void aMm() {
        this.iHF = false;
        this.iGM = false;
        this.iHY = -1;
        this.iHZ = false;
        this.iHS.reset();
        this.iHb = 1;
        this.iHT = 0;
        this.iHU = 0;
        this.iHV = 0;
        this.iHW = 0;
        HashSet hashSet = new HashSet();
        hashSet.add("filehelper");
        boolean yn = com.tencent.mm.model.k.yn();
        if (!yn) {
            yn = be.getInt(j.sU().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!yn) {
            v.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        v.d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", new Object[]{Integer.valueOf(hashSet.size())});
        c(hashSet);
    }

    public final void finish() {
        boolean z = true;
        if (!this.iHF) {
            this.iHF = true;
            String str = this.bkC;
            int count = getCount();
            if (this.iHS.cVW <= 0) {
                z = false;
            }
            com.tencent.mm.modelsearch.j.a(str, false, count, 0, z);
        }
        if (!this.iGM) {
            l.c(this.bkC, this.iHb, 3, 3);
        }
        this.iHS.reset();
        super.finish();
    }

    protected final void clearCache() {
        super.clearCache();
        for (com.tencent.mm.ui.f.f fVar : this.iHR) {
            fVar.bIJ();
            fVar.ua();
        }
    }

    public final void stopSearch() {
        this.iHX.removeMessages(1);
        super.stopSearch();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean a(com.tencent.mm.ui.f.a.a r20) {
        /*
        r19 = this;
        r0 = r20;
        r2 = r0.imS;
        if (r2 == 0) goto L_0x032d;
    L_0x0006:
        r2 = "MicroMsg.FTS.FTSMainAdapter";
        r3 = "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d";
        r4 = 6;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r20;
        r6 = r0.iHC;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r0 = r20;
        r6 = r0.iHJ;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r0 = r20;
        r6 = r0.oJg;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 3;
        r0 = r20;
        r6 = r0.oPu;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 4;
        r0 = r20;
        r6 = r0.oPv;
        r4[r5] = r6;
        r5 = 5;
        r0 = r20;
        r6 = r0.oPw;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);
        r0 = r19;
        r2 = r0.iHF;
        if (r2 != 0) goto L_0x0071;
    L_0x0056:
        r0 = r19;
        r3 = r0.bkC;
        r4 = 1;
        r5 = r19.getCount();
        r6 = 0;
        r0 = r19;
        r2 = r0.iHS;
        r2 = r2.cVW;
        if (r2 <= 0) goto L_0x01c8;
    L_0x0068:
        r2 = 1;
    L_0x0069:
        com.tencent.mm.modelsearch.j.a(r3, r4, r5, r6, r2);
        r2 = 1;
        r0 = r19;
        r0.iHF = r2;
    L_0x0071:
        r0 = r19;
        r2 = r0.bkC;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 != 0) goto L_0x008d;
    L_0x007b:
        r2 = 1;
        r0 = r19;
        r0.iGM = r2;
        r0 = r19;
        r2 = r0.bkC;
        r0 = r19;
        r3 = r0.iHb;
        r4 = 1;
        r5 = 3;
        com.tencent.mm.modelsearch.l.c(r2, r3, r4, r5);
    L_0x008d:
        r0 = r19;
        r6 = r0.iHS;
        r3 = 1;
        r0 = r20;
        r7 = r0.oJg;
        r0 = r20;
        r8 = r0.oPu;
        r0 = r20;
        r9 = r0.oPv;
        r0 = r20;
        r10 = r0.oPw;
        r0 = r20;
        r2 = r0.oJf;
        r0 = r20;
        r4 = r0.oJe;
        r5 = r20.aMM();
        r12 = com.tencent.mm.modelsearch.j.f(r2, r4, r5);
        r0 = r20;
        r2 = r0.iHC;
        r4 = -8;
        if (r2 != r4) goto L_0x01cb;
    L_0x00b9:
        r2 = 2;
        r18 = r3;
        r3 = r2;
        r2 = r18;
    L_0x00bf:
        r4 = java.lang.System.currentTimeMillis();
        r14 = r6.cVG;
        r4 = r4 - r14;
        r14 = 0;
        r13 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r13 < 0) goto L_0x00d4;
    L_0x00cc:
        r14 = r6.cVG;
        r16 = 0;
        r13 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r13 != 0) goto L_0x00d6;
    L_0x00d4:
        r4 = 0;
    L_0x00d6:
        r13 = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        r14 = 21;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r0 = r20;
        r0 = r0.iHJ;
        r16 = r0;
        r16 = java.lang.Integer.valueOf(r16);
        r14[r15] = r16;
        r15 = 1;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r15] = r3;
        r3 = 2;
        r7 = java.lang.Integer.valueOf(r7);
        r14[r3] = r7;
        r3 = 3;
        r2 = java.lang.Integer.valueOf(r2);
        r14[r3] = r2;
        r2 = 4;
        r3 = java.lang.Integer.valueOf(r8);
        r14[r2] = r3;
        r2 = 5;
        r3 = "";
        r3 = com.tencent.mm.sdk.platformtools.be.ah(r9, r3);
        r14[r2] = r3;
        r2 = 6;
        r3 = java.lang.Long.valueOf(r10);
        r14[r2] = r3;
        r2 = 7;
        r3 = java.lang.Integer.valueOf(r12);
        r14[r2] = r3;
        r2 = 8;
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 9;
        r3 = r20.YM();
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 10;
        r3 = r20.aML();
        r3 = com.tencent.mm.modelsearch.j.fX(r3);
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 11;
        r3 = r20.asE();
        r14[r2] = r3;
        r2 = 12;
        r3 = java.lang.Long.valueOf(r4);
        r14[r2] = r3;
        r2 = 13;
        r3 = r6.cVX;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 14;
        r3 = r6.cVY;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 15;
        r3 = r6.cVZ;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 16;
        r3 = r6.cWa;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 17;
        r3 = r6.cWb;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 18;
        r3 = r6.cWc;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 19;
        r3 = r6.cWd;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = 20;
        r3 = r6.cWe;
        r3 = java.lang.Integer.valueOf(r3);
        r14[r2] = r3;
        r2 = java.lang.String.format(r13, r14);
        r3 = "MicroMsg.FTS.FTSReportLogic";
        r4 = "report home page click: %d, %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = 10991; // 0x2aef float:1.5402E-41 double:5.4303E-320;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.v.v(r3, r4, r5);
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 10991; // 0x2aef float:1.5402E-41 double:5.4303E-320;
        r3.Y(r4, r2);
    L_0x01c6:
        r2 = 1;
    L_0x01c7:
        return r2;
    L_0x01c8:
        r2 = 0;
        goto L_0x0069;
    L_0x01cb:
        r0 = r20;
        r2 = r0.eKg;
        switch(r2) {
            case 1: goto L_0x01d3;
            case 2: goto L_0x01db;
            case 3: goto L_0x01eb;
            case 4: goto L_0x01e3;
            case 5: goto L_0x0206;
            case 6: goto L_0x01f4;
            case 7: goto L_0x0218;
            case 8: goto L_0x0221;
            case 9: goto L_0x022a;
            case 10: goto L_0x0269;
            case 11: goto L_0x01d2;
            case 12: goto L_0x0233;
            case 13: goto L_0x020f;
            case 14: goto L_0x01fd;
            case 15: goto L_0x01d2;
            case 16: goto L_0x0281;
            default: goto L_0x01d2;
        };
    L_0x01d2:
        goto L_0x01c6;
    L_0x01d3:
        r2 = 3;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x01db:
        r2 = 4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x01e3:
        r2 = 5;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x01eb:
        r2 = 10;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x01f4:
        r2 = 11;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x01fd:
        r2 = 15;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x0206:
        r2 = 16;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x020f:
        r2 = 17;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x0218:
        r2 = 12;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x0221:
        r2 = 13;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x022a:
        r2 = 14;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x0233:
        r2 = 2;
        r0 = r20;
        r3 = r0.iHC;
        r4 = -5;
        if (r3 != r4) goto L_0x023f;
    L_0x023b:
        r3 = 16;
        goto L_0x00bf;
    L_0x023f:
        r0 = r20;
        r3 = r0.iHC;
        r4 = -3;
        if (r3 != r4) goto L_0x0249;
    L_0x0246:
        r3 = 4;
        goto L_0x00bf;
    L_0x0249:
        r0 = r20;
        r3 = r0.iHC;
        r4 = -4;
        if (r3 != r4) goto L_0x0253;
    L_0x0250:
        r3 = 3;
        goto L_0x00bf;
    L_0x0253:
        r0 = r20;
        r3 = r0.iHC;
        r4 = -1;
        if (r3 != r4) goto L_0x025e;
    L_0x025a:
        r3 = 12;
        goto L_0x00bf;
    L_0x025e:
        r0 = r20;
        r3 = r0.iHC;
        r4 = -2;
        if (r3 != r4) goto L_0x01c6;
    L_0x0265:
        r3 = 11;
        goto L_0x00bf;
    L_0x0269:
        r0 = r20;
        r2 = r0.oPx;
        if (r2 == 0) goto L_0x0278;
    L_0x026f:
        r2 = 8;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x0278:
        r2 = 9;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x00bf;
    L_0x0281:
        r4 = 19;
        r5 = new com.tencent.mm.modelsns.c;
        r5.<init>();
        r0 = r20;
        r2 = r0.bkC;
        if (r2 == 0) goto L_0x0298;
    L_0x028e:
        r13 = ",";
        r14 = " ";
        r2 = r2.replaceAll(r13, r14);
    L_0x0298:
        r13 = "20KeyWordId";
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r2 = r14.append(r2);
        r14 = ",";
        r2 = r2.append(r14);
        r2 = r2.toString();
        r5.n(r13, r2);
        r2 = "21ViewType";
        r13 = "1,";
        r5.n(r2, r13);
        r2 = "22OpType";
        r13 = "2,";
        r5.n(r2, r13);
        r2 = "23ResultCount";
        r13 = ",";
        r5.n(r2, r13);
        r2 = "24ClickPos";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r0 = r20;
        r14 = r0.oPu;
        r13 = r13.append(r14);
        r14 = ",";
        r13 = r13.append(r14);
        r13 = r13.toString();
        r5.n(r2, r13);
        r2 = "25ClickAppUserName";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r0 = r20;
        r14 = r0.info;
        r13 = r13.append(r14);
        r14 = ",";
        r13 = r13.append(r14);
        r13 = r13.toString();
        r5.n(r2, r13);
        r2 = "MicroMsg.FTS.FTSReportLogic";
        r13 = "report oreh LocalSearchWeApp(13963), %s";
        r14 = 1;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r16 = r5.JH();
        r14[r15] = r16;
        com.tencent.mm.sdk.platformtools.v.i(r2, r13, r14);
        r2 = com.tencent.mm.plugin.report.service.g.iuh;
        r13 = 13963; // 0x368b float:1.9566E-41 double:6.8986E-320;
        r14 = 1;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r14[r15] = r5;
        r2.h(r13, r14);
        r2 = r3;
        r3 = r4;
        goto L_0x00bf;
    L_0x032d:
        r2 = 0;
        goto L_0x01c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.f.a(com.tencent.mm.ui.f.a.a):boolean");
    }

    public final void a(com.tencent.mm.ui.f.f fVar, String str) {
        com.tencent.mm.ui.f.c cVar = (com.tencent.mm.ui.f.c) fVar;
        if (str.equals(this.bkC)) {
            c(cVar.cUR);
        }
        int i = 0;
        for (int i2 = 0; i2 < cVar.oPj.size(); i2++) {
            i += ((com.tencent.mm.ui.f.f.a) cVar.oPj.get(i2)).iHv.size();
        }
        if (i > 0 && this.iHT == 0) {
            this.iHT = System.currentTimeMillis() - this.iHm;
            com.tencent.mm.modelsearch.j.l(9, this.iHT);
            v.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[]{Long.valueOf(this.iHT)});
        }
        switch (cVar.getType()) {
            case 16:
                if (this.iHU == 0) {
                    this.iHU = System.currentTimeMillis() - this.iHm;
                    v.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[]{Long.valueOf(this.iHU)});
                    com.tencent.mm.modelsearch.j.l(0, this.iHU);
                    break;
                }
                break;
            case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
                if (this.iHV == 0) {
                    this.iHV = System.currentTimeMillis() - this.iHm;
                    v.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[]{Long.valueOf(this.iHV)});
                    com.tencent.mm.modelsearch.j.l(3, this.iHV);
                    break;
                }
                break;
            case 48:
                if (this.iHW == 0) {
                    this.iHW = System.currentTimeMillis() - this.iHm;
                    v.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[]{Long.valueOf(this.iHW)});
                    com.tencent.mm.modelsearch.j.l(6, this.iHW);
                    break;
                }
                break;
        }
        k kVar = this.iHS;
        for (com.tencent.mm.ui.f.f.a aVar : cVar.oPj) {
            switch (aVar.cWS) {
                case -11:
                    kVar.cWe = aVar.iHv.size();
                    break;
                case -8:
                    kVar.cVW = aVar.iHv.size();
                    break;
                case -7:
                    kVar.cVZ = aVar.iHv.size();
                    break;
                case -6:
                    kVar.cWb = aVar.iHv.size();
                    break;
                case -5:
                    kVar.cWd = aVar.iHv.size();
                    break;
                case -4:
                    kVar.cVX = aVar.iHv.size();
                    break;
                case -3:
                    kVar.cVY = aVar.iHv.size();
                    break;
                case ai.CTRL_INDEX /*-2*/:
                    kVar.cWa = aVar.iHv.size();
                    break;
                case -1:
                    kVar.cWc = aVar.iHv.size();
                    break;
                default:
                    break;
            }
        }
        new a(this, fVar, str).run();
    }

    private void c(HashSet<String> hashSet) {
        this.iHY++;
        if (this.iHY < this.iHR.size()) {
            ((com.tencent.mm.ui.f.f) this.iHR.get(this.iHY)).a(this.bkC, this.iGN, hashSet);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (absListView.getLastVisiblePosition() == getCount() && this.iHZ) {
            this.iHb = 2;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iHG = true;
            e.bIM().aMG();
            ak.lye.pause();
            return;
        }
        this.iHG = false;
        if (!e.bIM().aMH()) {
            this.iHX.removeMessages(1);
            this.iHX.sendEmptyMessageDelayed(1, 200);
        }
    }
}
