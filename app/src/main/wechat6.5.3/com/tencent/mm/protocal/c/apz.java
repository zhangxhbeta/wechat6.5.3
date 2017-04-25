package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class apz extends aqp {
    public int efm;
    public int glx;
    public bda mPs;
    public azu mPt;
    public String mrc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPs == null) {
                throw new b("Not all required fields were included: UserPosition");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mrc != null) {
                aVar.e(2, this.mrc);
            }
            aVar.dV(3, this.efm);
            if (this.mPs != null) {
                aVar.dX(4, this.mPs.aHr());
                this.mPs.a(aVar);
            }
            aVar.dV(5, this.glx);
            if (this.mPt == null) {
                return 0;
            }
            aVar.dX(6, this.mPt.aHr());
            this.mPt.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mrc != null) {
                r0 += a.a.a.b.b.a.f(2, this.mrc);
            }
            r0 += a.a.a.a.dS(3, this.efm);
            if (this.mPs != null) {
                r0 += a.a.a.a.dU(4, this.mPs.aHr());
            }
            r0 += a.a.a.a.dS(5, this.glx);
            if (this.mPt != null) {
                r0 += a.a.a.a.dU(6, this.mPt.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mPs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserPosition");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            apz com_tencent_mm_protocal_c_apz = (apz) objArr[1];
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
                        com_tencent_mm_protocal_c_apz.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apz.mrc = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apz.efm = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bda com_tencent_mm_protocal_c_bda = new bda();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bda.a(aVar4, com_tencent_mm_protocal_c_bda, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apz.mPs = com_tencent_mm_protocal_c_bda;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apz.glx = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        azu com_tencent_mm_protocal_c_azu = new azu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_azu.a(aVar4, com_tencent_mm_protocal_c_azu, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apz.mPt = com_tencent_mm_protocal_c_azu;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
