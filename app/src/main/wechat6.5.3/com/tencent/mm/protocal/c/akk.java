package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class akk extends aqp {
    public String mLq;
    public String mLr;
    public int mid;
    public are mie;
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
            aVar.dV(4, this.mig);
            if (this.mLq != null) {
                aVar.e(5, this.mLq);
            }
            if (this.mLr != null) {
                aVar.e(6, this.mLr);
            }
            aVar.dV(7, this.mih);
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
            r0 += a.a.a.a.dS(4, this.mig);
            if (this.mLq != null) {
                r0 += a.a.a.b.b.a.f(5, this.mLq);
            }
            if (this.mLr != null) {
                r0 += a.a.a.b.b.a.f(6, this.mLr);
            }
            return r0 + a.a.a.a.dS(7, this.mih);
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
            akk com_tencent_mm_protocal_c_akk = (akk) objArr[1];
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
                        com_tencent_mm_protocal_c_akk.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akk.mid = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_akk.mie = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akk.mig = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akk.mLq = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akk.mLr = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akk.mih = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
