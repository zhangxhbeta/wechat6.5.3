package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class axd extends aqx {
    public int mJw;
    public are mSH;
    public String mSV;
    public int mSZ;
    public int mTa;
    public aws mTb;
    public int mUp;
    public int mUq;
    public LinkedList<bu> mUr = new LinkedList();
    public int mUs;
    public LinkedList<apu> mUt = new LinkedList();
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
            aVar.dV(5, this.mUp);
            aVar.dV(6, this.mSZ);
            aVar.dV(7, this.mTa);
            if (this.mTb != null) {
                aVar.dX(8, this.mTb.aHr());
                this.mTb.a(aVar);
            }
            aVar.dV(9, this.mUq);
            aVar.d(10, 8, this.mUr);
            if (this.mSH != null) {
                aVar.dX(11, this.mSH.aHr());
                this.mSH.a(aVar);
            }
            aVar.dV(12, this.mUs);
            aVar.d(13, 8, this.mUt);
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
            r0 = ((((r0 + a.a.a.a.dS(3, this.mJw)) + a.a.a.a.c(4, 8, this.mfQ)) + a.a.a.a.dS(5, this.mUp)) + a.a.a.a.dS(6, this.mSZ)) + a.a.a.a.dS(7, this.mTa);
            if (this.mTb != null) {
                r0 += a.a.a.a.dU(8, this.mTb.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(9, this.mUq)) + a.a.a.a.c(10, 8, this.mUr);
            if (this.mSH != null) {
                r0 += a.a.a.a.dU(11, this.mSH.aHr());
            }
            return (r0 + a.a.a.a.dS(12, this.mUs)) + a.a.a.a.c(13, 8, this.mUt);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mfQ.clear();
            this.mUr.clear();
            this.mUt.clear();
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
            axd com_tencent_mm_protocal_c_axd = (axd) objArr[1];
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
                        com_tencent_mm_protocal_c_axd.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axd.mSV = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axd.mJw = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_axd.mfQ.add(com_tencent_mm_protocal_c_awa);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axd.mUp = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axd.mSZ = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axd.mTa = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_axd.mTb = com_tencent_mm_protocal_c_aws;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axd.mUq = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bu buVar = new bu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = buVar.a(aVar4, buVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axd.mUr.add(buVar);
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axd.mSH = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_axd.mUs = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        apu com_tencent_mm_protocal_c_apu = new apu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_apu.a(aVar4, com_tencent_mm_protocal_c_apu, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axd.mUt.add(com_tencent_mm_protocal_c_apu);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
