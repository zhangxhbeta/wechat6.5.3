package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bgd extends aqp {
    public String mOk;
    public long mZV;
    public int mkE;
    public are mkF;
    public int mqS;
    public long mqT;
    public bfd nbK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mkF == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.nbK == null) {
                throw new b("Not all required fields were included: OpLog");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mOk != null) {
                    aVar.e(2, this.mOk);
                }
                aVar.dV(3, this.mqS);
                if (this.mkF != null) {
                    aVar.dX(4, this.mkF.aHr());
                    this.mkF.a(aVar);
                }
                if (this.nbK != null) {
                    aVar.dX(5, this.nbK.aHr());
                    this.nbK.a(aVar);
                }
                aVar.C(6, this.mqT);
                aVar.dV(7, this.mkE);
                aVar.C(8, this.mZV);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mOk != null) {
                r0 += a.a.a.b.b.a.f(2, this.mOk);
            }
            r0 += a.a.a.a.dS(3, this.mqS);
            if (this.mkF != null) {
                r0 += a.a.a.a.dU(4, this.mkF.aHr());
            }
            if (this.nbK != null) {
                r0 += a.a.a.a.dU(5, this.nbK.aHr());
            }
            return ((r0 + a.a.a.a.B(6, this.mqT)) + a.a.a.a.dS(7, this.mkE)) + a.a.a.a.B(8, this.mZV);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mkF == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.nbK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: OpLog");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bgd com_tencent_mm_protocal_c_bgd = (bgd) objArr[1];
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
                        com_tencent_mm_protocal_c_bgd.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgd.mOk = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgd.mqS = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_bgd.mkF = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bfd com_tencent_mm_protocal_c_bfd = new bfd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfd.a(aVar4, com_tencent_mm_protocal_c_bfd, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bgd.nbK = com_tencent_mm_protocal_c_bfd;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bgd.mqT = aVar3.pMj.mI();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bgd.mkE = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bgd.mZV = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
