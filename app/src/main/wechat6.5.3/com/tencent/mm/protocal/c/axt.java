package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class axt extends a {
    public int mUL;
    public beg mUM;
    public int mVh;
    public int mVi;
    public int mVj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mUM == null) {
                throw new b("Not all required fields were included: Addr");
            }
            if (this.mUM != null) {
                aVar.dX(1, this.mUM.aHr());
                this.mUM.a(aVar);
            }
            aVar.dV(2, this.mUL);
            aVar.dV(3, this.mVh);
            aVar.dV(4, this.mVi);
            aVar.dV(5, this.mVj);
            return 0;
        } else if (i == 1) {
            if (this.mUM != null) {
                r0 = a.a.a.a.dU(1, this.mUM.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.dS(2, this.mUL)) + a.a.a.a.dS(3, this.mVh)) + a.a.a.a.dS(4, this.mVi)) + a.a.a.a.dS(5, this.mVj);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mUM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axt com_tencent_mm_protocal_c_axt = (axt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        beg com_tencent_mm_protocal_c_beg = new beg();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_beg.a(aVar4, com_tencent_mm_protocal_c_beg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axt.mUM = com_tencent_mm_protocal_c_beg;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axt.mUL = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axt.mVh = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axt.mVi = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axt.mVj = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
