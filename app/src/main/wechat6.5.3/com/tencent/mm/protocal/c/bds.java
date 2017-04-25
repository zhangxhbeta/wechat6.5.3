package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bds extends aqp {
    public String mBQ;
    public int mPA;
    public int mPy;
    public bdy mZA;
    public are mgD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mZA == null) {
                throw new b("Not all required fields were included: Piece");
            } else if (this.mgD == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mZA != null) {
                    aVar.dX(2, this.mZA.aHr());
                    this.mZA.a(aVar);
                }
                aVar.dV(3, this.mPy);
                aVar.dV(4, this.mPA);
                if (this.mBQ != null) {
                    aVar.e(5, this.mBQ);
                }
                if (this.mgD == null) {
                    return 0;
                }
                aVar.dX(6, this.mgD.aHr());
                this.mgD.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mZA != null) {
                r0 += a.a.a.a.dU(2, this.mZA.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mPy)) + a.a.a.a.dS(4, this.mPA);
            if (this.mBQ != null) {
                r0 += a.a.a.b.b.a.f(5, this.mBQ);
            }
            if (this.mgD != null) {
                r0 += a.a.a.a.dU(6, this.mgD.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mZA == null) {
                throw new b("Not all required fields were included: Piece");
            } else if (this.mgD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bds com_tencent_mm_protocal_c_bds = (bds) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bds.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new bdy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bds.mZA = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bds.mPy = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bds.mPA = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bds.mBQ = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bds.mgD = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
