package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class adu extends aqx {
    public String glj;
    public String mgs;
    public String mmT;
    public String mmU;
    public String mmV;
    public String mmW;

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
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            if (this.mmT != null) {
                aVar.e(3, this.mmT);
            }
            if (this.mgs != null) {
                aVar.e(4, this.mgs);
            }
            if (this.mmU != null) {
                aVar.e(5, this.mmU);
            }
            if (this.mmV != null) {
                aVar.e(6, this.mmV);
            }
            if (this.mmW == null) {
                return 0;
            }
            aVar.e(7, this.mmW);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            if (this.mmT != null) {
                r0 += a.a.a.b.b.a.f(3, this.mmT);
            }
            if (this.mgs != null) {
                r0 += a.a.a.b.b.a.f(4, this.mgs);
            }
            if (this.mmU != null) {
                r0 += a.a.a.b.b.a.f(5, this.mmU);
            }
            if (this.mmV != null) {
                r0 += a.a.a.b.b.a.f(6, this.mmV);
            }
            if (this.mmW != null) {
                r0 += a.a.a.b.b.a.f(7, this.mmW);
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
            adu com_tencent_mm_protocal_c_adu = (adu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adu.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adu.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adu.mmT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adu.mgs = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adu.mmU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adu.mmV = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adu.mmW = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
