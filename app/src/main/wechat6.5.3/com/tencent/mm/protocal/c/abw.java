package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class abw extends aqx {
    public are mCZ;
    public are mDa;
    public int mDc;
    public int mDd;
    public int mDe;
    public are mdU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mdU == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.mCZ == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.mDa == null) {
                throw new b("Not all required fields were included: KeyBuffer");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mdU != null) {
                    aVar.dX(2, this.mdU.aHr());
                    this.mdU.a(aVar);
                }
                if (this.mCZ != null) {
                    aVar.dX(3, this.mCZ.aHr());
                    this.mCZ.a(aVar);
                }
                if (this.mDa != null) {
                    aVar.dX(4, this.mDa.aHr());
                    this.mDa.a(aVar);
                }
                aVar.dV(5, this.mDc);
                aVar.dV(6, this.mDd);
                aVar.dV(7, this.mDe);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mdU != null) {
                r0 += a.a.a.a.dU(2, this.mdU.aHr());
            }
            if (this.mCZ != null) {
                r0 += a.a.a.a.dU(3, this.mCZ.aHr());
            }
            if (this.mDa != null) {
                r0 += a.a.a.a.dU(4, this.mDa.aHr());
            }
            return ((r0 + a.a.a.a.dS(5, this.mDc)) + a.a.a.a.dS(6, this.mDd)) + a.a.a.a.dS(7, this.mDe);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mdU == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.mCZ == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.mDa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            abw com_tencent_mm_protocal_c_abw = (abw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            are com_tencent_mm_protocal_c_are;
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
                        com_tencent_mm_protocal_c_abw.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abw.mdU = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abw.mCZ = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abw.mDa = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_abw.mDc = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_abw.mDd = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_abw.mDe = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
