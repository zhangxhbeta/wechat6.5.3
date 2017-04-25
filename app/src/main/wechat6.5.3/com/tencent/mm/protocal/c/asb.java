package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class asb extends a {
    public afv mGZ;
    public int mQL;
    public LinkedList<bcy> mQM = new LinkedList();
    public long miQ;
    public String mxU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mxU == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.C(1, this.miQ);
            if (this.mxU != null) {
                aVar.e(2, this.mxU);
            }
            if (this.mGZ != null) {
                aVar.dX(3, this.mGZ.aHr());
                this.mGZ.a(aVar);
            }
            aVar.dV(4, this.mQL);
            aVar.d(5, 8, this.mQM);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.miQ) + 0;
            if (this.mxU != null) {
                r0 += a.a.a.b.b.a.f(2, this.mxU);
            }
            if (this.mGZ != null) {
                r0 += a.a.a.a.dU(3, this.mGZ.aHr());
            }
            return (r0 + a.a.a.a.dS(4, this.mQL)) + a.a.a.a.c(5, 8, this.mQM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mQM.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mxU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            asb com_tencent_mm_protocal_c_asb = (asb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_asb.miQ = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asb.mxU = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        afv com_tencent_mm_protocal_c_afv = new afv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afv.a(aVar4, com_tencent_mm_protocal_c_afv, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asb.mGZ = com_tencent_mm_protocal_c_afv;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asb.mQL = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bcy com_tencent_mm_protocal_c_bcy = new bcy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcy.a(aVar4, com_tencent_mm_protocal_c_bcy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asb.mQM.add(com_tencent_mm_protocal_c_bcy);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
