package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ld extends a {
    public String eBN;
    public String eBO;
    public String eBZ;
    public long mlB;
    public String mnE;
    public String mnF;
    public abh mnG;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.eBN != null) {
                aVar.e(2, this.eBN);
            }
            if (this.eBO != null) {
                aVar.e(3, this.eBO);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.C(5, this.mlB);
            if (this.mnE != null) {
                aVar.e(6, this.mnE);
            }
            if (this.mnF != null) {
                aVar.e(7, this.mnF);
            }
            if (this.eBZ != null) {
                aVar.e(8, this.eBZ);
            }
            if (this.mnG == null) {
                return 0;
            }
            aVar.dX(9, this.mnG.aHr());
            this.mnG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.eBN != null) {
                r0 += a.a.a.b.b.a.f(2, this.eBN);
            }
            if (this.eBO != null) {
                r0 += a.a.a.b.b.a.f(3, this.eBO);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(4, this.url);
            }
            r0 += a.a.a.a.B(5, this.mlB);
            if (this.mnE != null) {
                r0 += a.a.a.b.b.a.f(6, this.mnE);
            }
            if (this.mnF != null) {
                r0 += a.a.a.b.b.a.f(7, this.mnF);
            }
            if (this.eBZ != null) {
                r0 += a.a.a.b.b.a.f(8, this.eBZ);
            }
            if (this.mnG != null) {
                r0 += a.a.a.a.dU(9, this.mnG.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ld ldVar = (ld) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ldVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ldVar.eBN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ldVar.eBO = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ldVar.url = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ldVar.mlB = aVar3.pMj.mI();
                    return 0;
                case 6:
                    ldVar.mnE = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ldVar.mnF = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ldVar.eBZ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        abh com_tencent_mm_protocal_c_abh = new abh();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_abh.a(aVar4, com_tencent_mm_protocal_c_abh, a.a(aVar4))) {
                        }
                        ldVar.mnG = com_tencent_mm_protocal_c_abh;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
