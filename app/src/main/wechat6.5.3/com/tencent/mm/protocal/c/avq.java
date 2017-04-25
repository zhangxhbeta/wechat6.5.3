package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class avq extends aqx {
    public int mJw;
    public String mSV;
    public int mSZ;
    public int mTa;
    public aws mTb;
    public String mdJ;
    public LinkedList<awa> mfQ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mTb == null) {
                throw new b("Not all required fields were included: ServerConfig");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mSV != null) {
                    aVar.e(2, this.mSV);
                }
                aVar.dV(3, this.mJw);
                aVar.d(4, 8, this.mfQ);
                aVar.dV(5, this.mSZ);
                if (this.mdJ != null) {
                    aVar.e(6, this.mdJ);
                }
                aVar.dV(7, this.mTa);
                if (this.mTb == null) {
                    return 0;
                }
                aVar.dX(8, this.mTb.aHr());
                this.mTb.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mSV != null) {
                r0 += a.a.a.b.b.a.f(2, this.mSV);
            }
            r0 = ((r0 + a.a.a.a.dS(3, this.mJw)) + a.a.a.a.c(4, 8, this.mfQ)) + a.a.a.a.dS(5, this.mSZ);
            if (this.mdJ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mdJ);
            }
            r0 += a.a.a.a.dS(7, this.mTa);
            if (this.mTb != null) {
                r0 += a.a.a.a.dU(8, this.mTb.aHr());
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
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mTb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ServerConfig");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            avq com_tencent_mm_protocal_c_avq = (avq) objArr[1];
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
                        com_tencent_mm_protocal_c_avq.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avq.mSV = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avq.mJw = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_avq.mfQ.add(com_tencent_mm_protocal_c_awa);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avq.mSZ = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avq.mdJ = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avq.mTa = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aws com_tencent_mm_protocal_c_aws = new aws();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aws.a(aVar4, com_tencent_mm_protocal_c_aws, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avq.mTb = com_tencent_mm_protocal_c_aws;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
