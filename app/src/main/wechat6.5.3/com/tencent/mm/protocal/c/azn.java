package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class azn extends aqx {
    public are mDl;
    public int mDm;
    public String mDn;
    public int mDo;
    public int mNf;
    public String mNg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mDl == null) {
                throw new b("Not all required fields were included: RetText");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mDl != null) {
                    aVar.dX(2, this.mDl.aHr());
                    this.mDl.a(aVar);
                }
                aVar.dV(3, this.mDm);
                if (this.mDn != null) {
                    aVar.e(4, this.mDn);
                }
                aVar.dV(5, this.mDo);
                aVar.dV(6, this.mNf);
                if (this.mNg == null) {
                    return 0;
                }
                aVar.e(7, this.mNg);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mDl != null) {
                r0 += a.a.a.a.dU(2, this.mDl.aHr());
            }
            r0 += a.a.a.a.dS(3, this.mDm);
            if (this.mDn != null) {
                r0 += a.a.a.b.b.a.f(4, this.mDn);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.mDo)) + a.a.a.a.dS(6, this.mNf);
            if (this.mNg != null) {
                r0 += a.a.a.b.b.a.f(7, this.mNg);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mDl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RetText");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            azn com_tencent_mm_protocal_c_azn = (azn) objArr[1];
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
                        com_tencent_mm_protocal_c_azn.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azn.mDl = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azn.mDm = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azn.mDn = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azn.mDo = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azn.mNf = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azn.mNg = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
