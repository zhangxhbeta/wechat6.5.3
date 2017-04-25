package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class alx extends aqx {
    public int bcd;
    public String bce;
    public int hih;
    public String kQM;
    public bgs mMG;
    public bgp mMH;
    public bgn mMI;
    public bgq mMJ;
    public boolean mMK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.bcd);
            if (this.bce != null) {
                aVar.e(3, this.bce);
            }
            if (this.mMG != null) {
                aVar.dX(4, this.mMG.aHr());
                this.mMG.a(aVar);
            }
            if (this.mMH != null) {
                aVar.dX(5, this.mMH.aHr());
                this.mMH.a(aVar);
            }
            if (this.mMI != null) {
                aVar.dX(6, this.mMI.aHr());
                this.mMI.a(aVar);
            }
            if (this.mMJ != null) {
                aVar.dX(7, this.mMJ.aHr());
                this.mMJ.a(aVar);
            }
            aVar.dV(8, this.hih);
            aVar.ab(9, this.mMK);
            if (this.kQM == null) {
                return 0;
            }
            aVar.e(10, this.kQM);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.bcd);
            if (this.bce != null) {
                r0 += a.a.a.b.b.a.f(3, this.bce);
            }
            if (this.mMG != null) {
                r0 += a.a.a.a.dU(4, this.mMG.aHr());
            }
            if (this.mMH != null) {
                r0 += a.a.a.a.dU(5, this.mMH.aHr());
            }
            if (this.mMI != null) {
                r0 += a.a.a.a.dU(6, this.mMI.aHr());
            }
            if (this.mMJ != null) {
                r0 += a.a.a.a.dU(7, this.mMJ.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(8, this.hih)) + (a.a.a.b.b.a.cw(9) + 1);
            if (this.kQM != null) {
                r0 += a.a.a.b.b.a.f(10, this.kQM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alx com_tencent_mm_protocal_c_alx = (alx) objArr[1];
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
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alx.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alx.bcd = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alx.bce = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgs com_tencent_mm_protocal_c_bgs = new bgs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bgs.a(aVar4, com_tencent_mm_protocal_c_bgs, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alx.mMG = com_tencent_mm_protocal_c_bgs;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgp com_tencent_mm_protocal_c_bgp = new bgp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bgp.a(aVar4, com_tencent_mm_protocal_c_bgp, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alx.mMH = com_tencent_mm_protocal_c_bgp;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgn com_tencent_mm_protocal_c_bgn = new bgn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bgn.a(aVar4, com_tencent_mm_protocal_c_bgn, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alx.mMI = com_tencent_mm_protocal_c_bgn;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgq com_tencent_mm_protocal_c_bgq = new bgq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bgq.a(aVar4, com_tencent_mm_protocal_c_bgq, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alx.mMJ = com_tencent_mm_protocal_c_bgq;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_alx.hih = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_alx.mMK = aVar3.bQJ();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_alx.kQM = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
