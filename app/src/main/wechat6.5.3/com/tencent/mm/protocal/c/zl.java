package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zl extends aqx {
    public LinkedList<abg> gmC = new LinkedList();
    public LinkedList<ao> gmZ = new LinkedList();
    public int mAY;
    public LinkedList<apd> mAZ = new LinkedList();
    public int mBa;
    public int mBb;
    public int mBc;
    public abf mBd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.mAY);
            aVar.d(3, 8, this.mAZ);
            aVar.dV(4, this.mBa);
            aVar.dV(5, this.mBb);
            aVar.d(6, 8, this.gmZ);
            aVar.dV(7, this.mBc);
            aVar.d(8, 8, this.gmC);
            if (this.mBd == null) {
                return 0;
            }
            aVar.dX(9, this.mBd.aHr());
            this.mBd.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + a.a.a.a.dS(2, this.mAY)) + a.a.a.a.c(3, 8, this.mAZ)) + a.a.a.a.dS(4, this.mBa)) + a.a.a.a.dS(5, this.mBb)) + a.a.a.a.c(6, 8, this.gmZ)) + a.a.a.a.dS(7, this.mBc)) + a.a.a.a.c(8, 8, this.gmC);
            if (this.mBd != null) {
                r0 += a.a.a.a.dU(9, this.mBd.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mAZ.clear();
            this.gmZ.clear();
            this.gmC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zl zlVar = (zl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        zlVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zlVar.mAY = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new apd();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        zlVar.mAZ.add(eoVar);
                    }
                    return 0;
                case 4:
                    zlVar.mBa = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zlVar.mBb = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new ao();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        zlVar.gmZ.add(eoVar);
                    }
                    return 0;
                case 7:
                    zlVar.mBc = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new abg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        zlVar.gmC.add(eoVar);
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new abf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        zlVar.mBd = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
