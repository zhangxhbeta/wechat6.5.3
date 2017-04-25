package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aba extends aqx {
    public int ehT;
    public String mCs;
    public String mCt;
    public int mCu;
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
            if (this.mCt != null) {
                aVar.e(3, this.mCt);
            }
            aVar.dV(4, this.mCu);
            aVar.dV(5, this.ehT);
            if (this.mCs == null) {
                return 0;
            }
            aVar.e(6, this.mCs);
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
            if (this.mCt != null) {
                r0 += a.a.a.b.b.a.f(3, this.mCt);
            }
            r0 = (r0 + a.a.a.a.dS(4, this.mCu)) + a.a.a.a.dS(5, this.ehT);
            if (this.mCs != null) {
                r0 += a.a.a.b.b.a.f(6, this.mCs);
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
            aba com_tencent_mm_protocal_c_aba = (aba) objArr[1];
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
                        com_tencent_mm_protocal_c_aba.mQl = eoVar;
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
                        com_tencent_mm_protocal_c_aba.mmz = com_tencent_mm_protocal_c_bix;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aba.mCt = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aba.mCu = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aba.ehT = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aba.mCs = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
