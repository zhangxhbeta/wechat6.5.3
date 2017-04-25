package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class kc extends aqx {
    public boolean mmA;
    public String mmB;
    public String mmC;
    public bix mmz;

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
            if (this.mmz != null) {
                aVar.dX(2, this.mmz.aHr());
                this.mmz.a(aVar);
            }
            aVar.ab(3, this.mmA);
            if (this.mmB != null) {
                aVar.e(4, this.mmB);
            }
            if (this.mmC == null) {
                return 0;
            }
            aVar.e(5, this.mmC);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mmz != null) {
                r0 += a.a.a.a.dU(2, this.mmz.aHr());
            }
            r0 += a.a.a.b.b.a.cw(3) + 1;
            if (this.mmB != null) {
                r0 += a.a.a.b.b.a.f(4, this.mmB);
            }
            if (this.mmC != null) {
                r0 += a.a.a.b.b.a.f(5, this.mmC);
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
            kc kcVar = (kc) objArr[1];
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
                        kcVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bix com_tencent_mm_protocal_c_bix = new bix();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bix.a(aVar4, com_tencent_mm_protocal_c_bix, aqx.a(aVar4))) {
                        }
                        kcVar.mmz = com_tencent_mm_protocal_c_bix;
                    }
                    return 0;
                case 3:
                    kcVar.mmA = aVar3.bQJ();
                    return 0;
                case 4:
                    kcVar.mmB = aVar3.pMj.readString();
                    return 0;
                case 5:
                    kcVar.mmC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
