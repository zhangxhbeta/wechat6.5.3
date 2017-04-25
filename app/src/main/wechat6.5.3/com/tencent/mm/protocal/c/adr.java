package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class adr extends aqx {
    public LinkedList<aeo> mEA = new LinkedList();
    public ads mEx;
    public LinkedList<adp> mEy = new LinkedList();
    public String mEz;

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
            if (this.mEx != null) {
                aVar.dX(2, this.mEx.aHr());
                this.mEx.a(aVar);
            }
            aVar.d(3, 8, this.mEy);
            if (this.mEz != null) {
                aVar.e(4, this.mEz);
            }
            aVar.d(5, 8, this.mEA);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mEx != null) {
                r0 += a.a.a.a.dU(2, this.mEx.aHr());
            }
            r0 += a.a.a.a.c(3, 8, this.mEy);
            if (this.mEz != null) {
                r0 += a.a.a.b.b.a.f(4, this.mEz);
            }
            return r0 + a.a.a.a.c(5, 8, this.mEA);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mEy.clear();
            this.mEA.clear();
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
            adr com_tencent_mm_protocal_c_adr = (adr) objArr[1];
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
                        com_tencent_mm_protocal_c_adr.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ads com_tencent_mm_protocal_c_ads = new ads();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ads.a(aVar4, com_tencent_mm_protocal_c_ads, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adr.mEx = com_tencent_mm_protocal_c_ads;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        adp com_tencent_mm_protocal_c_adp = new adp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_adp.a(aVar4, com_tencent_mm_protocal_c_adp, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adr.mEy.add(com_tencent_mm_protocal_c_adp);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adr.mEz = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aeo com_tencent_mm_protocal_c_aeo = new aeo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aeo.a(aVar4, com_tencent_mm_protocal_c_aeo, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adr.mEA.add(com_tencent_mm_protocal_c_aeo);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
