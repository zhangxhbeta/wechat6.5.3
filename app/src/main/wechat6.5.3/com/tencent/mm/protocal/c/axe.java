package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class axe extends aqp {
    public int efm;
    public String glj;
    public int mIl;
    public int mIm;
    public bah mNq;
    public int mTr;
    public int mUu;
    public int mUv;
    public String mbN;
    public int mdA;
    public String mdJ;
    public int mdz;
    public are meT;
    public int mnk;
    public String mpI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.meT == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.efm);
            aVar.dV(3, this.mdA);
            aVar.dV(4, this.mdz);
            if (this.meT != null) {
                aVar.dX(5, this.meT.aHr());
                this.meT.a(aVar);
            }
            if (this.mbN != null) {
                aVar.e(6, this.mbN);
            }
            aVar.dV(7, this.mIl);
            aVar.dV(8, this.mIm);
            if (this.mdJ != null) {
                aVar.e(9, this.mdJ);
            }
            aVar.dV(10, this.mUu);
            aVar.dV(11, this.mnk);
            if (this.mNq != null) {
                aVar.dX(12, this.mNq.aHr());
                this.mNq.a(aVar);
            }
            if (this.glj != null) {
                aVar.e(13, this.glj);
            }
            aVar.dV(14, this.mTr);
            if (this.mpI != null) {
                aVar.e(15, this.mpI);
            }
            aVar.dV(16, this.mUv);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.dS(2, this.efm)) + a.a.a.a.dS(3, this.mdA)) + a.a.a.a.dS(4, this.mdz);
            if (this.meT != null) {
                r0 += a.a.a.a.dU(5, this.meT.aHr());
            }
            if (this.mbN != null) {
                r0 += a.a.a.b.b.a.f(6, this.mbN);
            }
            r0 = (r0 + a.a.a.a.dS(7, this.mIl)) + a.a.a.a.dS(8, this.mIm);
            if (this.mdJ != null) {
                r0 += a.a.a.b.b.a.f(9, this.mdJ);
            }
            r0 = (r0 + a.a.a.a.dS(10, this.mUu)) + a.a.a.a.dS(11, this.mnk);
            if (this.mNq != null) {
                r0 += a.a.a.a.dU(12, this.mNq.aHr());
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(13, this.glj);
            }
            r0 += a.a.a.a.dS(14, this.mTr);
            if (this.mpI != null) {
                r0 += a.a.a.b.b.a.f(15, this.mpI);
            }
            return r0 + a.a.a.a.dS(16, this.mUv);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.meT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axe com_tencent_mm_protocal_c_axe = (axe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axe.efm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axe.mdA = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axe.mdz = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.meT = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axe.mbN = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axe.mIl = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axe.mIm = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axe.mdJ = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axe.mUu = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_axe.mnk = aVar3.pMj.mH();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bah com_tencent_mm_protocal_c_bah = new bah();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bah.a(aVar4, com_tencent_mm_protocal_c_bah, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.mNq = com_tencent_mm_protocal_c_bah;
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_axe.glj = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_axe.mTr = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_axe.mpI = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_axe.mUv = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
