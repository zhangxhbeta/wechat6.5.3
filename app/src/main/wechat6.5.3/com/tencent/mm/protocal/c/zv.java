package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zv extends aqx {
    public int mBj;
    public String mBk;
    public int mBl;
    public String mBm;
    public int mBn;
    public LinkedList<arf> mBo = new LinkedList();
    public String mBp;
    public int mBq;
    public String mBr;
    public int mBs;
    public are mBt;

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
            aVar.dV(2, this.mBj);
            if (this.mBk != null) {
                aVar.e(3, this.mBk);
            }
            aVar.dV(4, this.mBl);
            if (this.mBm != null) {
                aVar.e(5, this.mBm);
            }
            aVar.dV(6, this.mBn);
            aVar.d(7, 8, this.mBo);
            if (this.mBp != null) {
                aVar.e(8, this.mBp);
            }
            aVar.dV(9, this.mBq);
            if (this.mBr != null) {
                aVar.e(10, this.mBr);
            }
            aVar.dV(11, this.mBs);
            if (this.mBt == null) {
                return 0;
            }
            aVar.dX(12, this.mBt.aHr());
            this.mBt.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mBj);
            if (this.mBk != null) {
                r0 += a.a.a.b.b.a.f(3, this.mBk);
            }
            r0 += a.a.a.a.dS(4, this.mBl);
            if (this.mBm != null) {
                r0 += a.a.a.b.b.a.f(5, this.mBm);
            }
            r0 = (r0 + a.a.a.a.dS(6, this.mBn)) + a.a.a.a.c(7, 8, this.mBo);
            if (this.mBp != null) {
                r0 += a.a.a.b.b.a.f(8, this.mBp);
            }
            r0 += a.a.a.a.dS(9, this.mBq);
            if (this.mBr != null) {
                r0 += a.a.a.b.b.a.f(10, this.mBr);
            }
            r0 += a.a.a.a.dS(11, this.mBs);
            if (this.mBt != null) {
                r0 += a.a.a.a.dU(12, this.mBt.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mBo.clear();
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
            zv zvVar = (zv) objArr[1];
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
                        zvVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zvVar.mBj = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zvVar.mBk = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zvVar.mBl = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zvVar.mBm = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zvVar.mBn = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        zvVar.mBo.add(eoVar);
                    }
                    return 0;
                case 8:
                    zvVar.mBp = aVar3.pMj.readString();
                    return 0;
                case 9:
                    zvVar.mBq = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zvVar.mBr = aVar3.pMj.readString();
                    return 0;
                case 11:
                    zvVar.mBs = aVar3.pMj.mH();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        zvVar.mBt = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
