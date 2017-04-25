package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class axf extends aqx {
    public int efm;
    public int mIG;
    public LinkedList<avo> mIH = new LinkedList();
    public avo mUw;
    public String mbN;
    public int mdA;
    public int mdz;
    public long mjq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mUw == null) {
                throw new b("Not all required fields were included: BufferUrl");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(2, this.mdA);
                aVar.dV(3, this.mdz);
                if (this.mbN != null) {
                    aVar.e(4, this.mbN);
                }
                if (this.mUw != null) {
                    aVar.dX(5, this.mUw.aHr());
                    this.mUw.a(aVar);
                }
                aVar.dV(6, this.mIG);
                aVar.d(7, 8, this.mIH);
                aVar.C(8, this.mjq);
                aVar.dV(9, this.efm);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mdA)) + a.a.a.a.dS(3, this.mdz);
            if (this.mbN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mbN);
            }
            if (this.mUw != null) {
                r0 += a.a.a.a.dU(5, this.mUw.aHr());
            }
            return (((r0 + a.a.a.a.dS(6, this.mIG)) + a.a.a.a.c(7, 8, this.mIH)) + a.a.a.a.B(8, this.mjq)) + a.a.a.a.dS(9, this.efm);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mIH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mUw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BufferUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axf com_tencent_mm_protocal_c_axf = (axf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            avo com_tencent_mm_protocal_c_avo;
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
                        com_tencent_mm_protocal_c_axf.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axf.mdA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axf.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axf.mbN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avo = new avo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avo.a(aVar4, com_tencent_mm_protocal_c_avo, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axf.mUw = com_tencent_mm_protocal_c_avo;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axf.mIG = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avo = new avo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avo.a(aVar4, com_tencent_mm_protocal_c_avo, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axf.mIH.add(com_tencent_mm_protocal_c_avo);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axf.mjq = aVar3.pMj.mI();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axf.efm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
