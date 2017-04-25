package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class xl extends aqp {
    public int lZm;
    public int maG;
    public double mhY;
    public double mhZ;
    public String muW;
    public double mzJ;
    public double mzK;
    public are mzn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mzn == null) {
                throw new b("Not all required fields were included: Buff");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.maG);
            aVar.dV(3, this.lZm);
            if (this.muW != null) {
                aVar.e(4, this.muW);
            }
            if (this.mzn != null) {
                aVar.dX(5, this.mzn.aHr());
                this.mzn.a(aVar);
            }
            aVar.a(6, this.mhY);
            aVar.a(7, this.mhZ);
            aVar.a(8, this.mzJ);
            aVar.a(9, this.mzK);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.maG)) + a.a.a.a.dS(3, this.lZm);
            if (this.muW != null) {
                r0 += a.a.a.b.b.a.f(4, this.muW);
            }
            if (this.mzn != null) {
                r0 += a.a.a.a.dU(5, this.mzn.aHr());
            }
            return (((r0 + (a.a.a.b.b.a.cw(6) + 8)) + (a.a.a.b.b.a.cw(7) + 8)) + (a.a.a.b.b.a.cw(8) + 8)) + (a.a.a.b.b.a.cw(9) + 8);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mzn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buff");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xl xlVar = (xl) objArr[1];
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
                        xlVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    xlVar.maG = aVar3.pMj.mH();
                    return 0;
                case 3:
                    xlVar.lZm = aVar3.pMj.mH();
                    return 0;
                case 4:
                    xlVar.muW = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        xlVar.mzn = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 6:
                    xlVar.mhY = aVar3.pMj.readDouble();
                    return 0;
                case 7:
                    xlVar.mhZ = aVar3.pMj.readDouble();
                    return 0;
                case 8:
                    xlVar.mzJ = aVar3.pMj.readDouble();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    xlVar.mzK = aVar3.pMj.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
