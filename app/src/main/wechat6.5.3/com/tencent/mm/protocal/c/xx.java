package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class xx extends a {
    public int maG;
    public are mcz;
    public int mxS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mcz == null) {
                throw new b("Not all required fields were included: ReqBuf");
            }
            aVar.dV(1, this.mxS);
            if (this.mcz != null) {
                aVar.dX(2, this.mcz.aHr());
                this.mcz.a(aVar);
            }
            aVar.dV(3, this.maG);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mxS) + 0;
            if (this.mcz != null) {
                r0 += a.a.a.a.dU(2, this.mcz.aHr());
            }
            return r0 + a.a.a.a.dS(3, this.maG);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mcz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReqBuf");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xx xxVar = (xx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    xxVar.mxS = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        xxVar.mcz = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    xxVar.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
