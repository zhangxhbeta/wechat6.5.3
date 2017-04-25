package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aa extends aqx {
    public int lZE;
    public lh lZI;
    public boolean lZJ;
    public int lZK;
    public int lZu;
    public String lZv;
    public auy lZw;
    public aqb lZx;

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
            aVar.dV(2, this.lZu);
            if (this.lZv != null) {
                aVar.e(3, this.lZv);
            }
            if (this.lZw != null) {
                aVar.dX(4, this.lZw.aHr());
                this.lZw.a(aVar);
            }
            if (this.lZx != null) {
                aVar.dX(5, this.lZx.aHr());
                this.lZx.a(aVar);
            }
            aVar.dV(6, this.lZE);
            if (this.lZI != null) {
                aVar.dX(7, this.lZI.aHr());
                this.lZI.a(aVar);
            }
            aVar.ab(8, this.lZJ);
            aVar.dV(9, this.lZK);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.lZu);
            if (this.lZv != null) {
                r0 += a.a.a.b.b.a.f(3, this.lZv);
            }
            if (this.lZw != null) {
                r0 += a.a.a.a.dU(4, this.lZw.aHr());
            }
            if (this.lZx != null) {
                r0 += a.a.a.a.dU(5, this.lZx.aHr());
            }
            r0 += a.a.a.a.dS(6, this.lZE);
            if (this.lZI != null) {
                r0 += a.a.a.a.dU(7, this.lZI.aHr());
            }
            return (r0 + (a.a.a.b.b.a.cw(8) + 1)) + a.a.a.a.dS(9, this.lZK);
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
            aa aaVar = (aa) objArr[1];
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
                        aaVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    aaVar.lZu = aVar3.pMj.mH();
                    return 0;
                case 3:
                    aaVar.lZv = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        auy com_tencent_mm_protocal_c_auy = new auy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_auy.a(aVar4, com_tencent_mm_protocal_c_auy, aqx.a(aVar4))) {
                        }
                        aaVar.lZw = com_tencent_mm_protocal_c_auy;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aqb com_tencent_mm_protocal_c_aqb = new aqb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqb.a(aVar4, com_tencent_mm_protocal_c_aqb, aqx.a(aVar4))) {
                        }
                        aaVar.lZx = com_tencent_mm_protocal_c_aqb;
                    }
                    return 0;
                case 6:
                    aaVar.lZE = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        lh lhVar = new lh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lhVar.a(aVar4, lhVar, aqx.a(aVar4))) {
                        }
                        aaVar.lZI = lhVar;
                    }
                    return 0;
                case 8:
                    aaVar.lZJ = aVar3.bQJ();
                    return 0;
                case 9:
                    aaVar.lZK = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
