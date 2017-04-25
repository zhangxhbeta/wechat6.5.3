package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class ael extends aqx {
    public b eew;
    public String hNZ;
    public arn mEQ;
    public String maV;
    public ads mmP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            if (this.mmP != null) {
                aVar.dX(2, this.mmP.aHr());
                this.mmP.a(aVar);
            }
            if (this.eew != null) {
                aVar.b(3, this.eew);
            }
            if (this.mEQ != null) {
                aVar.dX(4, this.mEQ.aHr());
                this.mEQ.a(aVar);
            }
            if (this.hNZ != null) {
                aVar.e(5, this.hNZ);
            }
            if (this.maV == null) {
                return 0;
            }
            aVar.e(6, this.maV);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mmP != null) {
                r0 += a.a.a.a.dU(2, this.mmP.aHr());
            }
            if (this.eew != null) {
                r0 += a.a.a.a.a(3, this.eew);
            }
            if (this.mEQ != null) {
                r0 += a.a.a.a.dU(4, this.mEQ.aHr());
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.hNZ);
            }
            if (this.maV != null) {
                r0 += a.a.a.b.b.a.f(6, this.maV);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ael com_tencent_mm_protocal_c_ael = (ael) objArr[1];
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
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ael.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ads com_tencent_mm_protocal_c_ads = new ads();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ads.a(aVar4, com_tencent_mm_protocal_c_ads, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ael.mmP = com_tencent_mm_protocal_c_ads;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ael.eew = aVar3.bQK();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        arn com_tencent_mm_protocal_c_arn = new arn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arn.a(aVar4, com_tencent_mm_protocal_c_arn, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ael.mEQ = com_tencent_mm_protocal_c_arn;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ael.hNZ = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ael.maV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
