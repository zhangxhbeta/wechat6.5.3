package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class xr extends aqp {
    public String gor;
    public String mzQ;
    public int mzR;
    public LinkedList<arf> mzS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mzQ != null) {
                aVar.e(2, this.mzQ);
            }
            aVar.dV(3, this.mzR);
            aVar.d(4, 8, this.mzS);
            if (this.gor == null) {
                return 0;
            }
            aVar.e(5, this.gor);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mzQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.mzQ);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mzR)) + a.a.a.a.c(4, 8, this.mzS);
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(5, this.gor);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mzS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            xr xrVar = (xr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        xrVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    xrVar.mzQ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    xrVar.mzR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        xrVar.mzS.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 5:
                    xrVar.gor = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
