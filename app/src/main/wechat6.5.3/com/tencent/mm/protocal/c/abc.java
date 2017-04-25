package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class abc extends aqx {
    public LinkedList<bjd> mCv = new LinkedList();
    public LinkedList<bjd> mCw = new LinkedList();
    public bix mmz;
    public int status;

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
            aVar.d(3, 8, this.mCv);
            aVar.d(4, 8, this.mCw);
            aVar.dV(5, this.status);
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
            return ((r0 + a.a.a.a.c(3, 8, this.mCv)) + a.a.a.a.c(4, 8, this.mCw)) + a.a.a.a.dS(5, this.status);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mCv.clear();
            this.mCw.clear();
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
            abc com_tencent_mm_protocal_c_abc = (abc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            bjd com_tencent_mm_protocal_c_bjd;
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
                        com_tencent_mm_protocal_c_abc.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bix com_tencent_mm_protocal_c_bix = new bix();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bix.a(aVar4, com_tencent_mm_protocal_c_bix, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abc.mmz = com_tencent_mm_protocal_c_bix;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bjd = new bjd();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bjd.a(aVar4, com_tencent_mm_protocal_c_bjd, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abc.mCv.add(com_tencent_mm_protocal_c_bjd);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bjd = new bjd();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bjd.a(aVar4, com_tencent_mm_protocal_c_bjd, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abc.mCw.add(com_tencent_mm_protocal_c_bjd);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_abc.status = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
