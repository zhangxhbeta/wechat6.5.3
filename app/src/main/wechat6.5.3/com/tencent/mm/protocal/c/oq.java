package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class oq extends aqx {
    public LinkedList<azi> mbB = new LinkedList();
    public int meD;
    public LinkedList<azh> meE = new LinkedList();
    public int mqS;
    public long mqT;
    public int mqU;
    public int mqV;
    public int mqW;

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
            aVar.dV(2, this.mqS);
            aVar.C(3, this.mqT);
            aVar.dV(4, this.mqU);
            aVar.dV(5, this.mqV);
            aVar.d(6, 8, this.mbB);
            aVar.dV(7, this.mqW);
            aVar.dV(8, this.meD);
            aVar.d(9, 8, this.meE);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (((((((r0 + a.a.a.a.dS(2, this.mqS)) + a.a.a.a.B(3, this.mqT)) + a.a.a.a.dS(4, this.mqU)) + a.a.a.a.dS(5, this.mqV)) + a.a.a.a.c(6, 8, this.mbB)) + a.a.a.a.dS(7, this.mqW)) + a.a.a.a.dS(8, this.meD)) + a.a.a.a.c(9, 8, this.meE);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mbB.clear();
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
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            oq oqVar = (oq) objArr[1];
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
                        oqVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    oqVar.mqS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    oqVar.mqT = aVar3.pMj.mI();
                    return 0;
                case 4:
                    oqVar.mqU = aVar3.pMj.mH();
                    return 0;
                case 5:
                    oqVar.mqV = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        azi com_tencent_mm_protocal_c_azi = new azi();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_azi.a(aVar4, com_tencent_mm_protocal_c_azi, aqx.a(aVar4))) {
                        }
                        oqVar.mbB.add(com_tencent_mm_protocal_c_azi);
                    }
                    return 0;
                case 7:
                    oqVar.mqW = aVar3.pMj.mH();
                    return 0;
                case 8:
                    oqVar.meD = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        azh com_tencent_mm_protocal_c_azh = new azh();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_azh.a(aVar4, com_tencent_mm_protocal_c_azh, aqx.a(aVar4))) {
                        }
                        oqVar.meE.add(com_tencent_mm_protocal_c_azh);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
