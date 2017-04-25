package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bgm extends a {
    public are mbY;
    public String mgT;
    public are mgX;
    public String nbU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mgX == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.nbU != null) {
                    aVar.e(1, this.nbU);
                }
                if (this.mgX != null) {
                    aVar.dX(2, this.mgX.aHr());
                    this.mgX.a(aVar);
                }
                if (this.mgT != null) {
                    aVar.e(3, this.mgT);
                }
                if (this.mbY == null) {
                    return 0;
                }
                aVar.dX(4, this.mbY.aHr());
                this.mbY.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.nbU != null) {
                r0 = a.a.a.b.b.a.f(1, this.nbU) + 0;
            } else {
                r0 = 0;
            }
            if (this.mgX != null) {
                r0 += a.a.a.a.dU(2, this.mgX.aHr());
            }
            if (this.mgT != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgT);
            }
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(4, this.mbY.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mgX == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.mbY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bgm com_tencent_mm_protocal_c_bgm = (bgm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bgm.nbU = aVar3.pMj.readString();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bgm.mgX = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgm.mgT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bgm.mbY = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
