package com.tencent.mm.protocal.c;

import a.a.a.b;
import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class awa extends a {
    public int hNS;
    public String mGq;
    public LinkedList<arf> mIw = new LinkedList();
    public int mJm;
    public int mKB;
    public int mSO;
    public are mTg;
    public int mTh;
    public int mTi;
    public int mTj;
    public LinkedList<avr> mTk = new LinkedList();
    public int mTl;
    public int mTm;
    public LinkedList<avr> mTn = new LinkedList();
    public int mTo;
    public int mTp;
    public LinkedList<avr> mTq = new LinkedList();
    public int mTr;
    public int mTs;
    public String mTt;
    public long mTu;
    public int mTv;
    public LinkedList<arf> mTw = new LinkedList();
    public int mTx;
    public are mTy;
    public awq mTz;
    public LinkedList<avw> mcs = new LinkedList();
    public String mdw;
    public long mjq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mTg == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.C(1, this.mjq);
            if (this.mdw != null) {
                aVar.e(2, this.mdw);
            }
            if (this.mGq != null) {
                aVar.e(3, this.mGq);
            }
            aVar.dV(4, this.hNS);
            if (this.mTg != null) {
                aVar.dX(5, this.mTg.aHr());
                this.mTg.a(aVar);
            }
            aVar.dV(6, this.mTh);
            aVar.dV(7, this.mTi);
            aVar.dV(8, this.mTj);
            aVar.d(9, 8, this.mTk);
            aVar.dV(10, this.mTl);
            aVar.dV(11, this.mTm);
            aVar.d(12, 8, this.mTn);
            aVar.dV(13, this.mTo);
            aVar.dV(14, this.mTp);
            aVar.d(15, 8, this.mTq);
            aVar.dV(16, this.mTr);
            aVar.dV(17, this.mTs);
            aVar.dV(18, this.mKB);
            aVar.d(19, 8, this.mcs);
            aVar.dV(20, this.mSO);
            if (this.mTt != null) {
                aVar.e(21, this.mTt);
            }
            aVar.C(22, this.mTu);
            aVar.dV(23, this.mTv);
            aVar.d(24, 8, this.mTw);
            aVar.dV(25, this.mJm);
            aVar.dV(26, this.mTx);
            aVar.d(27, 8, this.mIw);
            if (this.mTy != null) {
                aVar.dX(28, this.mTy.aHr());
                this.mTy.a(aVar);
            }
            if (this.mTz != null) {
                aVar.dX(29, this.mTz.aHr());
                this.mTz.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.mjq) + 0;
            if (this.mdw != null) {
                r0 += a.a.a.b.b.a.f(2, this.mdw);
            }
            if (this.mGq != null) {
                r0 += a.a.a.b.b.a.f(3, this.mGq);
            }
            r0 += a.a.a.a.dS(4, this.hNS);
            if (this.mTg != null) {
                r0 += a.a.a.a.dU(5, this.mTg.aHr());
            }
            r0 = ((((((((((((((r0 + a.a.a.a.dS(6, this.mTh)) + a.a.a.a.dS(7, this.mTi)) + a.a.a.a.dS(8, this.mTj)) + a.a.a.a.c(9, 8, this.mTk)) + a.a.a.a.dS(10, this.mTl)) + a.a.a.a.dS(11, this.mTm)) + a.a.a.a.c(12, 8, this.mTn)) + a.a.a.a.dS(13, this.mTo)) + a.a.a.a.dS(14, this.mTp)) + a.a.a.a.c(15, 8, this.mTq)) + a.a.a.a.dS(16, this.mTr)) + a.a.a.a.dS(17, this.mTs)) + a.a.a.a.dS(18, this.mKB)) + a.a.a.a.c(19, 8, this.mcs)) + a.a.a.a.dS(20, this.mSO);
            if (this.mTt != null) {
                r0 += a.a.a.b.b.a.f(21, this.mTt);
            }
            r0 = (((((r0 + a.a.a.a.B(22, this.mTu)) + a.a.a.a.dS(23, this.mTv)) + a.a.a.a.c(24, 8, this.mTw)) + a.a.a.a.dS(25, this.mJm)) + a.a.a.a.dS(26, this.mTx)) + a.a.a.a.c(27, 8, this.mIw);
            if (this.mTy != null) {
                r0 += a.a.a.a.dU(28, this.mTy.aHr());
            }
            if (this.mTz != null) {
                return r0 + a.a.a.a.dU(29, this.mTz.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mTk.clear();
            this.mTn.clear();
            this.mTq.clear();
            this.mcs.clear();
            this.mTw.clear();
            this.mIw.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mTg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awa com_tencent_mm_protocal_c_awa = (awa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_awa.mjq = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awa.mdw = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awa.mGq = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awa.hNS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mTg = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awa.mTh = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awa.mTi = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_awa.mTj = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new avr();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mTk.add(com_tencent_mm_protocal_c_are);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_awa.mTl = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_awa.mTm = aVar3.pMj.mH();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new avr();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mTn.add(com_tencent_mm_protocal_c_are);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_awa.mTo = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_awa.mTp = aVar3.pMj.mH();
                    return 0;
                case 15:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new avr();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mTq.add(com_tencent_mm_protocal_c_are);
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_awa.mTr = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_awa.mTs = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_awa.mKB = aVar3.pMj.mH();
                    return 0;
                case 19:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mcs.add(com_tencent_mm_protocal_c_are);
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_awa.mSO = aVar3.pMj.mH();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_awa.mTt = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_awa.mTu = aVar3.pMj.mI();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_awa.mTv = aVar3.pMj.mH();
                    return 0;
                case 24:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mTw.add(com_tencent_mm_protocal_c_are);
                    }
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_awa.mJm = aVar3.pMj.mH();
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_awa.mTx = aVar3.pMj.mH();
                    return 0;
                case 27:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mIw.add(com_tencent_mm_protocal_c_are);
                    }
                    return 0;
                case 28:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mTy = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 29:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new awq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awa.mTz = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
