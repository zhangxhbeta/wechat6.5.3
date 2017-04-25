package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class anb extends a {
    public bah mNq;
    public int myW;
    public String myX;
    public String myY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.myW);
            if (this.myX != null) {
                aVar.e(2, this.myX);
            }
            if (this.myY != null) {
                aVar.e(3, this.myY);
            }
            if (this.mNq != null) {
                aVar.dX(4, this.mNq.aHr());
                this.mNq.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.myW) + 0;
            if (this.myX != null) {
                r0 += a.a.a.b.b.a.f(2, this.myX);
            }
            if (this.myY != null) {
                r0 += a.a.a.b.b.a.f(3, this.myY);
            }
            if (this.mNq != null) {
                return r0 + a.a.a.a.dU(4, this.mNq.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            anb com_tencent_mm_protocal_c_anb = (anb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_anb.myW = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anb.myX = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anb.myY = aVar3.pMj.readString();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        bah com_tencent_mm_protocal_c_bah = new bah();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bah.a(aVar4, com_tencent_mm_protocal_c_bah, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anb.mNq = com_tencent_mm_protocal_c_bah;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
