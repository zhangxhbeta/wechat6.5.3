package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class c extends a {
    public int lXF;
    public int lXG;
    public o lXH;
    public o lXI;
    public int lXJ;
    public int lXK;
    public int ret;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.ret);
            aVar.dV(2, this.lXF);
            aVar.dV(3, this.lXG);
            if (this.lXH != null) {
                aVar.dX(4, this.lXH.aHr());
                this.lXH.a(aVar);
            }
            if (this.lXI != null) {
                aVar.dX(5, this.lXI.aHr());
                this.lXI.a(aVar);
            }
            aVar.dV(6, this.lXJ);
            aVar.dV(7, this.lXK);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.ret) + 0) + a.a.a.a.dS(2, this.lXF)) + a.a.a.a.dS(3, this.lXG);
            if (this.lXH != null) {
                r0 += a.a.a.a.dU(4, this.lXH.aHr());
            }
            if (this.lXI != null) {
                r0 += a.a.a.a.dU(5, this.lXI.aHr());
            }
            return (r0 + a.a.a.a.dS(6, this.lXJ)) + a.a.a.a.dS(7, this.lXK);
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a oVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.ret = aVar3.pMj.mH();
                    return 0;
                case 2:
                    cVar.lXF = aVar3.pMj.mH();
                    return 0;
                case 3:
                    cVar.lXG = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        oVar = new o();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.lXH = oVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        oVar = new o();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.lXI = oVar;
                    }
                    return 0;
                case 6:
                    cVar.lXJ = aVar3.pMj.mH();
                    return 0;
                case 7:
                    cVar.lXK = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
