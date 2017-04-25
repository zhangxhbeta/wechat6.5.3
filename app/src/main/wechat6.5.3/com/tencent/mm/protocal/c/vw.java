package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class vw extends aqp {
    public String extra;
    public int lZF = 0;
    public b myw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.lZF);
            if (this.extra != null) {
                aVar.e(3, this.extra);
            }
            if (this.myw == null) {
                return 0;
            }
            aVar.b(4, this.myw);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.lZF);
            if (this.extra != null) {
                r0 += a.a.a.b.b.a.f(3, this.extra);
            }
            if (this.myw != null) {
                r0 += a.a.a.a.a(4, this.myw);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            vw vwVar = (vw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        vwVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    vwVar.lZF = aVar3.pMj.mH();
                    return 0;
                case 3:
                    vwVar.extra = aVar3.pMj.readString();
                    return 0;
                case 4:
                    vwVar.myw = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
