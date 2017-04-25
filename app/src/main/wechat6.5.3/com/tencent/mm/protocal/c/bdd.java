package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bdd extends a {
    public int aRI;
    public String gkC;
    public are mZf;
    public are mZg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mZf == null) {
                throw new b("Not all required fields were included: Icon");
            } else if (this.mZg == null) {
                throw new b("Not all required fields were included: HDIcon");
            } else {
                aVar.dV(1, this.aRI);
                if (this.gkC != null) {
                    aVar.e(2, this.gkC);
                }
                if (this.mZf != null) {
                    aVar.dX(3, this.mZf.aHr());
                    this.mZf.a(aVar);
                }
                if (this.mZg != null) {
                    aVar.dX(4, this.mZg.aHr());
                    this.mZg.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.aRI) + 0;
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkC);
            }
            if (this.mZf != null) {
                r0 += a.a.a.a.dU(3, this.mZf.aHr());
            }
            if (this.mZg != null) {
                return r0 + a.a.a.a.dU(4, this.mZg.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mZf == null) {
                throw new b("Not all required fields were included: Icon");
            } else if (this.mZg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HDIcon");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bdd com_tencent_mm_protocal_c_bdd = (bdd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bdd.aRI = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdd.gkC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdd.mZf = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdd.mZg = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
