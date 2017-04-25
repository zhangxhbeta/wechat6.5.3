package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class axw extends a {
    public int cZD;
    public long cZE;
    public int cZF;
    public int cZG;
    public int cZH;
    public String mVo;
    public String mVp;
    public String mVq;
    public String mVr;
    public int opType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mVo == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.mVp == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.mVq == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.mVr == null) {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            } else {
                aVar.dV(1, this.opType);
                aVar.dV(2, this.cZH);
                aVar.dV(3, this.cZD);
                aVar.C(4, this.cZE);
                aVar.dV(5, this.cZF);
                aVar.dV(6, this.cZG);
                if (this.mVo != null) {
                    aVar.e(7, this.mVo);
                }
                if (this.mVp != null) {
                    aVar.e(8, this.mVp);
                }
                if (this.mVq != null) {
                    aVar.e(9, this.mVq);
                }
                if (this.mVr != null) {
                    aVar.e(10, this.mVr);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = (((((a.a.a.a.dS(1, this.opType) + 0) + a.a.a.a.dS(2, this.cZH)) + a.a.a.a.dS(3, this.cZD)) + a.a.a.a.B(4, this.cZE)) + a.a.a.a.dS(5, this.cZF)) + a.a.a.a.dS(6, this.cZG);
            if (this.mVo != null) {
                r0 += a.a.a.b.b.a.f(7, this.mVo);
            }
            if (this.mVp != null) {
                r0 += a.a.a.b.b.a.f(8, this.mVp);
            }
            if (this.mVq != null) {
                r0 += a.a.a.b.b.a.f(9, this.mVq);
            }
            if (this.mVr != null) {
                return r0 + a.a.a.b.b.a.f(10, this.mVr);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mVo == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.mVp == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.mVq == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.mVr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axw com_tencent_mm_protocal_c_axw = (axw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_axw.opType = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axw.cZH = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axw.cZD = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axw.cZE = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axw.cZF = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axw.cZG = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axw.mVo = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axw.mVp = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axw.mVq = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axw.mVr = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
