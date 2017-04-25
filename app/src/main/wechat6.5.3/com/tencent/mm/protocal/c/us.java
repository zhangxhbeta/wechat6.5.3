package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class us extends a {
    public int mcc;
    public arf mxp;
    public int mxq;
    public int mxr;
    public int mxs = 1;
    public int mxt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mxp == null) {
                throw new b("Not all required fields were included: ChatroomId");
            }
            if (this.mxp != null) {
                aVar.dX(1, this.mxp.aHr());
                this.mxp.a(aVar);
            }
            aVar.dV(2, this.mcc);
            aVar.dV(3, this.mxq);
            aVar.dV(4, this.mxr);
            aVar.dV(5, this.mxs);
            aVar.dV(6, this.mxt);
            return 0;
        } else if (i == 1) {
            if (this.mxp != null) {
                r0 = a.a.a.a.dU(1, this.mxp.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return ((((r0 + a.a.a.a.dS(2, this.mcc)) + a.a.a.a.dS(3, this.mxq)) + a.a.a.a.dS(4, this.mxr)) + a.a.a.a.dS(5, this.mxs)) + a.a.a.a.dS(6, this.mxt);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mxp != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ChatroomId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            us usVar = (us) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_arf = new arf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        usVar.mxp = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 2:
                    usVar.mcc = aVar3.pMj.mH();
                    return 0;
                case 3:
                    usVar.mxq = aVar3.pMj.mH();
                    return 0;
                case 4:
                    usVar.mxr = aVar3.pMj.mH();
                    return 0;
                case 5:
                    usVar.mxs = aVar3.pMj.mH();
                    return 0;
                case 6:
                    usVar.mxt = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
