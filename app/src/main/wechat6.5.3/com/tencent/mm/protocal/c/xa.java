package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xa extends aqp {
    public int maG;
    public int meB;
    public afu moG;
    public String muW;
    public are mzn;
    public int mzo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.moG == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.meB);
            aVar.dV(3, this.maG);
            if (this.mzn != null) {
                aVar.dX(4, this.mzn.aHr());
                this.mzn.a(aVar);
            }
            if (this.moG != null) {
                aVar.dX(5, this.moG.aHr());
                this.moG.a(aVar);
            }
            if (this.muW != null) {
                aVar.e(6, this.muW);
            }
            aVar.dV(7, this.mzo);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.meB)) + a.a.a.a.dS(3, this.maG);
            if (this.mzn != null) {
                r0 += a.a.a.a.dU(4, this.mzn.aHr());
            }
            if (this.moG != null) {
                r0 += a.a.a.a.dU(5, this.moG.aHr());
            }
            if (this.muW != null) {
                r0 += a.a.a.b.b.a.f(6, this.muW);
            }
            return r0 + a.a.a.a.dS(7, this.mzo);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.moG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xa xaVar = (xa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        xaVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    xaVar.meB = aVar3.pMj.mH();
                    return 0;
                case 3:
                    xaVar.maG = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        xaVar.mzn = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        afu com_tencent_mm_protocal_c_afu = new afu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afu.a(aVar4, com_tencent_mm_protocal_c_afu, aqp.a(aVar4))) {
                        }
                        xaVar.moG = com_tencent_mm_protocal_c_afu;
                    }
                    return 0;
                case 6:
                    xaVar.muW = aVar3.pMj.readString();
                    return 0;
                case 7:
                    xaVar.mzo = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
