package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aof extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public int cHg;
    public String cHh;
    public int cHi;
    public int cHj;
    public String cHk;
    public String cHl;
    public String cHm;
    public String efy;
    public String gln;
    public axg mFA;
    public mc mFB;
    public int mOr;
    public String mOs;
    public int mOt;
    public String mOu;
    public String mlY;
    public String mlZ;
    public String mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mOr);
            if (this.gln != null) {
                aVar.e(2, this.gln);
            }
            if (this.efy != null) {
                aVar.e(3, this.efy);
            }
            if (this.mOs != null) {
                aVar.e(4, this.mOs);
            }
            aVar.dV(5, this.mOt);
            if (this.mOu != null) {
                aVar.e(6, this.mOu);
            }
            aVar.dV(7, this.cHc);
            if (this.cHd != null) {
                aVar.e(8, this.cHd);
            }
            if (this.cHe != null) {
                aVar.e(9, this.cHe);
            }
            if (this.cHf != null) {
                aVar.e(10, this.cHf);
            }
            aVar.dV(11, this.cHg);
            if (this.cHh != null) {
                aVar.e(12, this.cHh);
            }
            aVar.dV(13, this.cHi);
            aVar.dV(14, this.cHj);
            if (this.cHk != null) {
                aVar.e(15, this.cHk);
            }
            if (this.mFA != null) {
                aVar.dX(16, this.mFA.aHr());
                this.mFA.a(aVar);
            }
            if (this.cHl != null) {
                aVar.e(17, this.cHl);
            }
            if (this.cHm != null) {
                aVar.e(18, this.cHm);
            }
            if (this.mFB != null) {
                aVar.dX(19, this.mFB.aHr());
                this.mFB.a(aVar);
            }
            if (this.mlY != null) {
                aVar.e(20, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(21, this.mlZ);
            }
            if (this.mvR != null) {
                aVar.e(22, this.mvR);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mOr) + 0;
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(3, this.efy);
            }
            if (this.mOs != null) {
                r0 += a.a.a.b.b.a.f(4, this.mOs);
            }
            r0 += a.a.a.a.dS(5, this.mOt);
            if (this.mOu != null) {
                r0 += a.a.a.b.b.a.f(6, this.mOu);
            }
            r0 += a.a.a.a.dS(7, this.cHc);
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(8, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(9, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(10, this.cHf);
            }
            r0 += a.a.a.a.dS(11, this.cHg);
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(12, this.cHh);
            }
            r0 = (r0 + a.a.a.a.dS(13, this.cHi)) + a.a.a.a.dS(14, this.cHj);
            if (this.cHk != null) {
                r0 += a.a.a.b.b.a.f(15, this.cHk);
            }
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(16, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(17, this.cHl);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(18, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(19, this.mFB.aHr());
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(20, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(21, this.mlZ);
            }
            if (this.mvR != null) {
                return r0 + a.a.a.b.b.a.f(22, this.mvR);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aof com_tencent_mm_protocal_c_aof = (aof) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_axg;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aof.mOr = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aof.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aof.efy = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aof.mOs = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aof.mOt = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aof.mOu = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aof.cHc = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aof.cHd = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aof.cHe = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aof.cHf = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aof.cHg = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aof.cHh = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aof.cHi = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aof.cHj = aVar3.pMj.mH();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aof.cHk = aVar3.pMj.readString();
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_axg = new axg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axg.a(aVar4, com_tencent_mm_protocal_c_axg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aof.mFA = com_tencent_mm_protocal_c_axg;
                    }
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aof.cHl = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_aof.cHm = aVar3.pMj.readString();
                    return 0;
                case 19:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_axg = new mc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axg.a(aVar4, com_tencent_mm_protocal_c_axg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aof.mFB = com_tencent_mm_protocal_c_axg;
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aof.mlY = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aof.mlZ = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_aof.mvR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
