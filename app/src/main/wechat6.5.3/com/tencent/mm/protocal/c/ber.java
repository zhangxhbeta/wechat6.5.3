package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class ber extends aqx {
    public int gFS;
    public int gFY;
    public int gFZ;
    public int gGd;
    public b mOd;
    public LinkedList<bel> meE = new LinkedList();
    public long mqT;
    public int naA;
    public long nat;
    public int nay;
    public int naz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.C(2, this.nat);
            aVar.C(3, this.mqT);
            aVar.d(4, 8, this.meE);
            aVar.dV(5, this.nay);
            aVar.dV(6, this.gFY);
            aVar.dV(7, this.gFZ);
            aVar.dV(8, this.gFS);
            aVar.dV(9, this.gGd);
            aVar.dV(10, this.naz);
            aVar.dV(11, this.naA);
            if (this.mOd == null) {
                return 0;
            }
            aVar.b(12, this.mOd);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((((((((r0 + a.a.a.a.B(2, this.nat)) + a.a.a.a.B(3, this.mqT)) + a.a.a.a.c(4, 8, this.meE)) + a.a.a.a.dS(5, this.nay)) + a.a.a.a.dS(6, this.gFY)) + a.a.a.a.dS(7, this.gFZ)) + a.a.a.a.dS(8, this.gFS)) + a.a.a.a.dS(9, this.gGd)) + a.a.a.a.dS(10, this.naz)) + a.a.a.a.dS(11, this.naA);
            if (this.mOd != null) {
                r0 += a.a.a.a.a(12, this.mOd);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.meE.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ber com_tencent_mm_protocal_c_ber = (ber) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ber.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ber.nat = aVar3.pMj.mI();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ber.mqT = aVar3.pMj.mI();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bel com_tencent_mm_protocal_c_bel = new bel();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bel.a(aVar4, com_tencent_mm_protocal_c_bel, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ber.meE.add(com_tencent_mm_protocal_c_bel);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ber.nay = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ber.gFY = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ber.gFZ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ber.gFS = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ber.gGd = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ber.naz = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ber.naA = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ber.mOd = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
