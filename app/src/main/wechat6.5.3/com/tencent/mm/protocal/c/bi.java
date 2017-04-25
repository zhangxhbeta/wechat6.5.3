package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bi extends aqp {
    public int efm;
    public String mbN;
    public int mbO;
    public String mbP;
    public String mbQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mbN != null) {
                aVar.e(2, this.mbN);
            }
            aVar.dV(3, this.efm);
            aVar.dV(4, this.mbO);
            if (this.mbP != null) {
                aVar.e(5, this.mbP);
            }
            if (this.mbQ == null) {
                return 0;
            }
            aVar.e(6, this.mbQ);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mbN != null) {
                r0 += a.a.a.b.b.a.f(2, this.mbN);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.efm)) + a.a.a.a.dS(4, this.mbO);
            if (this.mbP != null) {
                r0 += a.a.a.b.b.a.f(5, this.mbP);
            }
            if (this.mbQ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mbQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bi biVar = (bi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        biVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    biVar.mbN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    biVar.efm = aVar3.pMj.mH();
                    return 0;
                case 4:
                    biVar.mbO = aVar3.pMj.mH();
                    return 0;
                case 5:
                    biVar.mbP = aVar3.pMj.readString();
                    return 0;
                case 6:
                    biVar.mbQ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
