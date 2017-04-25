package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class hj extends aqp {
    public int maG;
    public int mfb;
    public int mfh;
    public int mgV;
    public int mid;
    public are mie;
    public int mif;
    public int mig;
    public int mih;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mie == null) {
                throw new b("Not all required fields were included: ImageBuffer");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mid);
            if (this.mie != null) {
                aVar.dX(3, this.mie.aHr());
                this.mie.a(aVar);
            }
            aVar.dV(4, this.mif);
            aVar.dV(5, this.mfb);
            aVar.dV(6, this.mfh);
            aVar.dV(7, this.mig);
            aVar.dV(8, this.mgV);
            aVar.dV(9, this.mih);
            aVar.dV(10, this.maG);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mid);
            if (this.mie != null) {
                r0 += a.a.a.a.dU(3, this.mie.aHr());
            }
            return ((((((r0 + a.a.a.a.dS(4, this.mif)) + a.a.a.a.dS(5, this.mfb)) + a.a.a.a.dS(6, this.mfh)) + a.a.a.a.dS(7, this.mig)) + a.a.a.a.dS(8, this.mgV)) + a.a.a.a.dS(9, this.mih)) + a.a.a.a.dS(10, this.maG);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mie != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImageBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hj hjVar = (hj) objArr[1];
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
                        hjVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    hjVar.mid = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        hjVar.mie = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    hjVar.mif = aVar3.pMj.mH();
                    return 0;
                case 5:
                    hjVar.mfb = aVar3.pMj.mH();
                    return 0;
                case 6:
                    hjVar.mfh = aVar3.pMj.mH();
                    return 0;
                case 7:
                    hjVar.mig = aVar3.pMj.mH();
                    return 0;
                case 8:
                    hjVar.mgV = aVar3.pMj.mH();
                    return 0;
                case 9:
                    hjVar.mih = aVar3.pMj.mH();
                    return 0;
                case 10:
                    hjVar.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
