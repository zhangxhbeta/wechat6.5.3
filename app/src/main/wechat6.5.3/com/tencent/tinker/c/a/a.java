package com.tencent.tinker.c.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import com.tencent.tinker.c.a.b.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class a {
    private final i pCQ;
    private final i pCR;
    private final com.tencent.tinker.c.a.b.a pCS;
    private final b pCT;
    private final com.tencent.tinker.a.b.b.b pCU;
    private final com.tencent.tinker.a.b.b.b pCV;
    private final String pCW;
    private com.tencent.tinker.c.a.a.a.i<s> pCX;
    private com.tencent.tinker.c.a.a.a.i<Integer> pCY;
    private com.tencent.tinker.c.a.a.a.i<r> pCZ;
    private com.tencent.tinker.c.a.a.a.i<n> pDa;
    private com.tencent.tinker.c.a.a.a.i<p> pDb;
    private com.tencent.tinker.c.a.a.a.i<f> pDc;
    private com.tencent.tinker.c.a.a.a.i<u> pDd;
    private com.tencent.tinker.c.a.a.a.i<c> pDe;
    private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> pDf;
    private com.tencent.tinker.c.a.a.a.i<e> pDg;
    private com.tencent.tinker.c.a.a.a.i<g> pDh;
    private com.tencent.tinker.c.a.a.a.i<h> pDi;
    private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> pDj;
    private com.tencent.tinker.c.a.a.a.i<k> pDk;
    private com.tencent.tinker.c.a.a.a.i<d> pDl;

    public a(InputStream inputStream, int i, InputStream inputStream2) {
        this(new i(inputStream, i), inputStream2 != null ? new com.tencent.tinker.c.a.b.a(inputStream2) : null);
    }

    private a(i iVar, com.tencent.tinker.c.a.b.a aVar) {
        this.pCQ = iVar;
        this.pCW = com.tencent.tinker.a.b.b.a.R(iVar.kE(false));
        this.pCS = aVar;
        this.pCR = new i(aVar.pDX);
        this.pCU = new com.tencent.tinker.a.b.b.b();
        this.pCV = null;
        this.pCT = null;
        if (aVar == null) {
            throw new UnsupportedOperationException("patchFileIn is null, and extraAddedDexElementFile(smallPatchInfo) is null or does not mention oldDexIn.");
        }
    }

    public final void b(OutputStream outputStream) {
        int i = 0;
        int i2 = -1;
        byte[] kE = this.pCQ.kE(false);
        if (kE == null) {
            throw new IOException("failed to compute old dex's signature.");
        }
        t tVar;
        i.e yP;
        if (this.pCS != null) {
            if (com.tencent.tinker.a.a.b.c.m(kE, this.pCS.pEq) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(kE), Arrays.toString(this.pCS.pEq)}));
            }
        }
        String R = com.tencent.tinker.a.b.b.a.R(kE);
        t tVar2 = this.pCR.pAU;
        tVar2.pBp.pBP = 0;
        tVar2.pBp.size = 1;
        tVar2.pBw.size = 1;
        if (this.pCT != null) {
            if (this.pCT.pEr.contains(this.pCW)) {
                int i3;
                a aVar = (a) this.pCT.pEs.get(R);
                tVar2.pBq.pBP = aVar != null ? aVar.pEI : -1;
                com.tencent.tinker.a.a.t.a aVar2 = tVar2.pBr;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEJ;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBx;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEP;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBs;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEK;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBt;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEL;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBu;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEM;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBv;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEN;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBw;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEO;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBC;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEV;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBE;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pAA;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBz;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEQ;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBy;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pER;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBG;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pES;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBF;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEX;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBD;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEW;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBB;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pEU;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar2 = tVar2.pBA;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i3 = aVar.pET;
                } else {
                    i3 = -1;
                }
                aVar2.pBP = i3;
                aVar = (a) this.pCT.pEs.get(R);
                if (aVar != null) {
                    i2 = aVar.pEY;
                    tVar = tVar2;
                } else {
                    tVar = tVar2;
                }
                tVar.fileSize = i2;
                Arrays.sort(tVar2.pBH);
                tVar2.bOM();
                this.pCX = new com.tencent.tinker.c.a.a.a.n(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pCY = new o(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pCZ = new l(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDa = new j(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDb = new com.tencent.tinker.c.a.a.a.k(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDc = new com.tencent.tinker.c.a.a.a.f(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDd = new com.tencent.tinker.c.a.a.a.p(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDe = new com.tencent.tinker.c.a.a.a.b(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDf = new com.tencent.tinker.c.a.a.a.c(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDg = new com.tencent.tinker.c.a.a.a.e(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDh = new com.tencent.tinker.c.a.a.a.g(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDi = new com.tencent.tinker.c.a.a.a.h(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDj = new com.tencent.tinker.c.a.a.a.a(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDk = new m(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pDl = new com.tencent.tinker.c.a.a.a.d(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
                this.pCX.execute();
                this.pCY.execute();
                this.pDd.execute();
                this.pCZ.execute();
                this.pDa.execute();
                this.pDb.execute();
                Runtime.getRuntime().gc();
                this.pDj.execute();
                this.pDf.execute();
                this.pDe.execute();
                this.pDl.execute();
                Runtime.getRuntime().gc();
                this.pDi.execute();
                this.pDh.execute();
                Runtime.getRuntime().gc();
                this.pDg.execute();
                this.pDk.execute();
                this.pDc.execute();
                Runtime.getRuntime().gc();
                yP = this.pCR.yP(tVar2.pBp.pBP);
                yP.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
                yP.writeInt(tVar2.pBI);
                yP.write(tVar2.pBd);
                yP.writeInt(tVar2.fileSize);
                yP.writeInt(112);
                yP.writeInt(305419896);
                yP.writeInt(tVar2.pBJ);
                yP.writeInt(tVar2.pBK);
                yP.writeInt(tVar2.pBw.pBP);
                yP.writeInt(tVar2.pBq.size);
                yP.writeInt(tVar2.pBq.exists() ? tVar2.pBq.pBP : 0);
                yP.writeInt(tVar2.pBr.size);
                yP.writeInt(tVar2.pBr.exists() ? tVar2.pBr.pBP : 0);
                yP.writeInt(tVar2.pBs.size);
                yP.writeInt(tVar2.pBs.exists() ? tVar2.pBs.pBP : 0);
                yP.writeInt(tVar2.pBt.size);
                yP.writeInt(tVar2.pBt.exists() ? tVar2.pBt.pBP : 0);
                yP.writeInt(tVar2.pBu.size);
                yP.writeInt(tVar2.pBu.exists() ? tVar2.pBu.pBP : 0);
                yP.writeInt(tVar2.pBv.size);
                if (tVar2.pBv.exists()) {
                    i = tVar2.pBv.pBP;
                }
                yP.writeInt(i);
                yP.writeInt(tVar2.pBL);
                yP.writeInt(tVar2.pBM);
                tVar2.b(this.pCR.yP(tVar2.pBw.pBP));
                this.pCR.bOm();
                outputStream.write(this.pCR.hua.array());
                outputStream.flush();
            }
        }
        tVar2.pBq.pBP = this.pCS.pDZ;
        tVar2.pBr.pBP = this.pCS.pEa;
        tVar2.pBx.pBP = this.pCS.pEg;
        tVar2.pBs.pBP = this.pCS.pEb;
        tVar2.pBt.pBP = this.pCS.pEc;
        tVar2.pBu.pBP = this.pCS.pEd;
        tVar2.pBv.pBP = this.pCS.pEe;
        tVar2.pBw.pBP = this.pCS.pEf;
        tVar2.pBC.pBP = this.pCS.pEl;
        tVar2.pBE.pBP = this.pCS.pEn;
        tVar2.pBz.pBP = this.pCS.pEi;
        tVar2.pBy.pBP = this.pCS.pEh;
        tVar2.pBG.pBP = this.pCS.pEp;
        tVar2.pBF.pBP = this.pCS.pEo;
        tVar2.pBD.pBP = this.pCS.pEm;
        tVar2.pBB.pBP = this.pCS.pEk;
        tVar2.pBA.pBP = this.pCS.pEj;
        i2 = this.pCS.pDX;
        tVar = tVar2;
        tVar.fileSize = i2;
        Arrays.sort(tVar2.pBH);
        tVar2.bOM();
        this.pCX = new com.tencent.tinker.c.a.a.a.n(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pCY = new o(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pCZ = new l(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDa = new j(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDb = new com.tencent.tinker.c.a.a.a.k(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDc = new com.tencent.tinker.c.a.a.a.f(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDd = new com.tencent.tinker.c.a.a.a.p(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDe = new com.tencent.tinker.c.a.a.a.b(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDf = new com.tencent.tinker.c.a.a.a.c(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDg = new com.tencent.tinker.c.a.a.a.e(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDh = new com.tencent.tinker.c.a.a.a.g(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDi = new com.tencent.tinker.c.a.a.a.h(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDj = new com.tencent.tinker.c.a.a.a.a(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDk = new m(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pDl = new com.tencent.tinker.c.a.a.a.d(this.pCS, this.pCQ, this.pCR, this.pCU, this.pCV, this.pCT);
        this.pCX.execute();
        this.pCY.execute();
        this.pDd.execute();
        this.pCZ.execute();
        this.pDa.execute();
        this.pDb.execute();
        Runtime.getRuntime().gc();
        this.pDj.execute();
        this.pDf.execute();
        this.pDe.execute();
        this.pDl.execute();
        Runtime.getRuntime().gc();
        this.pDi.execute();
        this.pDh.execute();
        Runtime.getRuntime().gc();
        this.pDg.execute();
        this.pDk.execute();
        this.pDc.execute();
        Runtime.getRuntime().gc();
        yP = this.pCR.yP(tVar2.pBp.pBP);
        yP.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
        yP.writeInt(tVar2.pBI);
        yP.write(tVar2.pBd);
        yP.writeInt(tVar2.fileSize);
        yP.writeInt(112);
        yP.writeInt(305419896);
        yP.writeInt(tVar2.pBJ);
        yP.writeInt(tVar2.pBK);
        yP.writeInt(tVar2.pBw.pBP);
        yP.writeInt(tVar2.pBq.size);
        if (tVar2.pBq.exists()) {
        }
        yP.writeInt(tVar2.pBq.exists() ? tVar2.pBq.pBP : 0);
        yP.writeInt(tVar2.pBr.size);
        if (tVar2.pBr.exists()) {
        }
        yP.writeInt(tVar2.pBr.exists() ? tVar2.pBr.pBP : 0);
        yP.writeInt(tVar2.pBs.size);
        if (tVar2.pBs.exists()) {
        }
        yP.writeInt(tVar2.pBs.exists() ? tVar2.pBs.pBP : 0);
        yP.writeInt(tVar2.pBt.size);
        if (tVar2.pBt.exists()) {
        }
        yP.writeInt(tVar2.pBt.exists() ? tVar2.pBt.pBP : 0);
        yP.writeInt(tVar2.pBu.size);
        if (tVar2.pBu.exists()) {
        }
        yP.writeInt(tVar2.pBu.exists() ? tVar2.pBu.pBP : 0);
        yP.writeInt(tVar2.pBv.size);
        if (tVar2.pBv.exists()) {
            i = tVar2.pBv.pBP;
        }
        yP.writeInt(i);
        yP.writeInt(tVar2.pBL);
        yP.writeInt(tVar2.pBM);
        tVar2.b(this.pCR.yP(tVar2.pBw.pBP));
        this.pCR.bOm();
        outputStream.write(this.pCR.hua.array());
        outputStream.flush();
    }
}
