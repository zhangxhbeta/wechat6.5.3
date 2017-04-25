package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class agu extends a {
    public String cHb;
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
    public axg mFA;
    public mc mFB;
    public String mGq;
    public po mGr;
    public String mdw;
    public String mlY;
    public String mlZ;
    public String mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdw != null) {
                aVar.e(1, this.mdw);
            }
            if (this.mGq != null) {
                aVar.e(2, this.mGq);
            }
            if (this.cHb != null) {
                aVar.e(3, this.cHb);
            }
            aVar.dV(4, this.cHc);
            if (this.cHd != null) {
                aVar.e(5, this.cHd);
            }
            if (this.cHe != null) {
                aVar.e(6, this.cHe);
            }
            if (this.cHf != null) {
                aVar.e(7, this.cHf);
            }
            aVar.dV(8, this.cHg);
            if (this.cHh != null) {
                aVar.e(9, this.cHh);
            }
            if (this.mGr != null) {
                aVar.dX(10, this.mGr.aHr());
                this.mGr.a(aVar);
            }
            aVar.dV(11, this.cHi);
            aVar.dV(12, this.cHj);
            if (this.cHk != null) {
                aVar.e(13, this.cHk);
            }
            if (this.mFA != null) {
                aVar.dX(14, this.mFA.aHr());
                this.mFA.a(aVar);
            }
            if (this.cHl != null) {
                aVar.e(15, this.cHl);
            }
            if (this.cHm != null) {
                aVar.e(16, this.cHm);
            }
            if (this.mFB != null) {
                aVar.dX(17, this.mFB.aHr());
                this.mFB.a(aVar);
            }
            if (this.mlY != null) {
                aVar.e(20, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(21, this.mlZ);
            }
            if (this.mvR == null) {
                return 0;
            }
            aVar.e(22, this.mvR);
            return 0;
        } else if (i == 1) {
            if (this.mdw != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdw) + 0;
            } else {
                r0 = 0;
            }
            if (this.mGq != null) {
                r0 += a.a.a.b.b.a.f(2, this.mGq);
            }
            if (this.cHb != null) {
                r0 += a.a.a.b.b.a.f(3, this.cHb);
            }
            r0 += a.a.a.a.dS(4, this.cHc);
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(5, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(6, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(7, this.cHf);
            }
            r0 += a.a.a.a.dS(8, this.cHg);
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(9, this.cHh);
            }
            if (this.mGr != null) {
                r0 += a.a.a.a.dU(10, this.mGr.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(11, this.cHi)) + a.a.a.a.dS(12, this.cHj);
            if (this.cHk != null) {
                r0 += a.a.a.b.b.a.f(13, this.cHk);
            }
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(14, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(15, this.cHl);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(16, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(17, this.mFB.aHr());
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(20, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(21, this.mlZ);
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(22, this.mvR);
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
            agu com_tencent_mm_protocal_c_agu = (agu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a poVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_agu.mdw = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agu.mGq = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agu.cHb = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agu.cHc = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agu.cHd = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agu.cHe = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agu.cHf = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agu.cHg = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agu.cHh = aVar3.pMj.readString();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        poVar = new po();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = poVar.a(aVar4, poVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agu.mGr = poVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_agu.cHi = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_agu.cHj = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_agu.cHk = aVar3.pMj.readString();
                    return 0;
                case 14:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        poVar = new axg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = poVar.a(aVar4, poVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agu.mFA = poVar;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_agu.cHl = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_agu.cHm = aVar3.pMj.readString();
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        poVar = new mc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = poVar.a(aVar4, poVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agu.mFB = poVar;
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_agu.mlY = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_agu.mlZ = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_agu.mvR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
