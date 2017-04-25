package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public class afs extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public String cHh;
    public String cHl;
    public String cHm;
    public String efy;
    public String gln;
    public String mAS;
    public axg mFA;
    public mc mFB;
    public String mFt;
    public int mFu;
    public String mFv;
    public String mFw;
    public String mFx;
    public int mFy;
    public int mFz;
    public int mbX;
    public String mlY;
    public String mlZ;
    public String mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            if (this.cHd != null) {
                aVar.e(3, this.cHd);
            }
            if (this.cHe != null) {
                aVar.e(4, this.cHe);
            }
            if (this.cHf != null) {
                aVar.e(5, this.cHf);
            }
            if (this.mFt != null) {
                aVar.e(6, this.mFt);
            }
            aVar.dV(7, this.cHc);
            aVar.dV(8, this.mbX);
            aVar.dV(9, this.mFu);
            if (this.mFv != null) {
                aVar.e(10, this.mFv);
            }
            if (this.mAS != null) {
                aVar.e(11, this.mAS);
            }
            if (this.cHh != null) {
                aVar.e(12, this.cHh);
            }
            if (this.mFw != null) {
                aVar.e(13, this.mFw);
            }
            if (this.mFx != null) {
                aVar.e(14, this.mFx);
            }
            aVar.dV(15, this.mFy);
            aVar.dV(19, this.mFz);
            if (this.mFA != null) {
                aVar.dX(20, this.mFA.aHr());
                this.mFA.a(aVar);
            }
            if (this.cHl != null) {
                aVar.e(21, this.cHl);
            }
            if (this.mlY != null) {
                aVar.e(22, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(23, this.mlZ);
            }
            if (this.cHm != null) {
                aVar.e(24, this.cHm);
            }
            if (this.mFB != null) {
                aVar.dX(25, this.mFB.aHr());
                this.mFB.a(aVar);
            }
            if (this.mvR == null) {
                return 0;
            }
            aVar.e(26, this.mvR);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(3, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(4, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(5, this.cHf);
            }
            if (this.mFt != null) {
                r0 += a.a.a.b.b.a.f(6, this.mFt);
            }
            r0 = ((r0 + a.a.a.a.dS(7, this.cHc)) + a.a.a.a.dS(8, this.mbX)) + a.a.a.a.dS(9, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(10, this.mFv);
            }
            if (this.mAS != null) {
                r0 += a.a.a.b.b.a.f(11, this.mAS);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(12, this.cHh);
            }
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(13, this.mFw);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(14, this.mFx);
            }
            r0 = (r0 + a.a.a.a.dS(15, this.mFy)) + a.a.a.a.dS(19, this.mFz);
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(20, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(21, this.cHl);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(22, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(23, this.mlZ);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(24, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(25, this.mFB.aHr());
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(26, this.mvR);
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
            afs com_tencent_mm_protocal_c_afs = (afs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_axg;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_afs.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afs.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afs.cHd = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afs.cHe = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afs.cHf = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_afs.mFt = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_afs.cHc = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_afs.mbX = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_afs.mFu = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_afs.mFv = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_afs.mAS = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_afs.cHh = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_afs.mFw = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_afs.mFx = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_afs.mFy = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_afs.mFz = aVar3.pMj.mH();
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_axg = new axg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axg.a(aVar4, com_tencent_mm_protocal_c_axg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afs.mFA = com_tencent_mm_protocal_c_axg;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_afs.cHl = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_afs.mlY = aVar3.pMj.readString();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_afs.mlZ = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_afs.cHm = aVar3.pMj.readString();
                    return 0;
                case 25:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_axg = new mc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axg.a(aVar4, com_tencent_mm_protocal_c_axg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afs.mFB = com_tencent_mm_protocal_c_axg;
                    }
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_afs.mvR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
