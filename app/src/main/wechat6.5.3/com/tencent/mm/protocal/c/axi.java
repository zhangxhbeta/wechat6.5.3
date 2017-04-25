package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class axi extends aqx {
    public axg mFA;
    public int mJw;
    public String mSV;
    public int mSZ;
    public aws mTb;
    public int mUp;
    public int mUy;
    public LinkedList<awa> mfQ = new LinkedList();

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
            if (this.mSV != null) {
                aVar.e(2, this.mSV);
            }
            aVar.dV(3, this.mJw);
            aVar.d(4, 8, this.mfQ);
            aVar.dV(5, this.mUy);
            if (this.mFA != null) {
                aVar.dX(6, this.mFA.aHr());
                this.mFA.a(aVar);
            }
            aVar.dV(7, this.mUp);
            aVar.dV(8, this.mSZ);
            if (this.mTb == null) {
                return 0;
            }
            aVar.dX(9, this.mTb.aHr());
            this.mTb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mSV != null) {
                r0 += a.a.a.b.b.a.f(2, this.mSV);
            }
            r0 = ((r0 + a.a.a.a.dS(3, this.mJw)) + a.a.a.a.c(4, 8, this.mfQ)) + a.a.a.a.dS(5, this.mUy);
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(6, this.mFA.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(7, this.mUp)) + a.a.a.a.dS(8, this.mSZ);
            if (this.mTb != null) {
                r0 += a.a.a.a.dU(9, this.mTb.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mfQ.clear();
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
            axi com_tencent_mm_protocal_c_axi = (axi) objArr[1];
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
                        com_tencent_mm_protocal_c_axi.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axi.mSV = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axi.mJw = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        awa com_tencent_mm_protocal_c_awa = new awa();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awa.a(aVar4, com_tencent_mm_protocal_c_awa, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axi.mfQ.add(com_tencent_mm_protocal_c_awa);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axi.mUy = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        axg com_tencent_mm_protocal_c_axg = new axg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axg.a(aVar4, com_tencent_mm_protocal_c_axg, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axi.mFA = com_tencent_mm_protocal_c_axg;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axi.mUp = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axi.mSZ = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aws com_tencent_mm_protocal_c_aws = new aws();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aws.a(aVar4, com_tencent_mm_protocal_c_aws, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axi.mTb = com_tencent_mm_protocal_c_aws;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
