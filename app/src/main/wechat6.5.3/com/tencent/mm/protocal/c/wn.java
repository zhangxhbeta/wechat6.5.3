package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class wn extends a {
    public int mcj;
    public abt mgb;
    public String mpB;
    public int myO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            if (this.mgb != null) {
                aVar.dX(2, this.mgb.aHr());
                this.mgb.a(aVar);
            }
            if (this.mpB != null) {
                aVar.e(3, this.mpB);
            }
            aVar.dV(4, this.myO);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.mgb != null) {
                r0 += a.a.a.a.dU(2, this.mgb.aHr());
            }
            if (this.mpB != null) {
                r0 += a.a.a.b.b.a.f(3, this.mpB);
            }
            return r0 + a.a.a.a.dS(4, this.myO);
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
            wn wnVar = (wn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wnVar.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        abt com_tencent_mm_protocal_c_abt = new abt();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_abt.a(aVar4, com_tencent_mm_protocal_c_abt, a.a(aVar4))) {
                        }
                        wnVar.mgb = com_tencent_mm_protocal_c_abt;
                    }
                    return 0;
                case 3:
                    wnVar.mpB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    wnVar.myO = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
