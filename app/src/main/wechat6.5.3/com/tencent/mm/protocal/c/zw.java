package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class zw extends aqp {
    public int lZo;
    public int mBi;
    public int mdA;
    public int mdz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mBi);
            aVar.dV(3, this.mdz);
            aVar.dV(4, this.mdA);
            aVar.dV(5, this.lZo);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.dS(2, this.mBi)) + a.a.a.a.dS(3, this.mdz)) + a.a.a.a.dS(4, this.mdA)) + a.a.a.a.dS(5, this.lZo);
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
            zw zwVar = (zw) objArr[1];
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
                        zwVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zwVar.mBi = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zwVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zwVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zwVar.lZo = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
