package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class apy extends a {
    public String bCj;
    public String eBN;
    public String eBZ;
    public LinkedList<String> hED = new LinkedList();
    public String mPq;
    public String mPr;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eBZ != null) {
                aVar.e(1, this.eBZ);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.eBN != null) {
                aVar.e(3, this.eBN);
            }
            if (this.mPq != null) {
                aVar.e(4, this.mPq);
            }
            if (this.mPr != null) {
                aVar.e(5, this.mPr);
            }
            if (this.bCj != null) {
                aVar.e(6, this.bCj);
            }
            aVar.d(7, 1, this.hED);
            return 0;
        } else if (i == 1) {
            if (this.eBZ != null) {
                r0 = a.a.a.b.b.a.f(1, this.eBZ) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            if (this.eBN != null) {
                r0 += a.a.a.b.b.a.f(3, this.eBN);
            }
            if (this.mPq != null) {
                r0 += a.a.a.b.b.a.f(4, this.mPq);
            }
            if (this.mPr != null) {
                r0 += a.a.a.b.b.a.f(5, this.mPr);
            }
            if (this.bCj != null) {
                r0 += a.a.a.b.b.a.f(6, this.bCj);
            }
            return r0 + a.a.a.a.c(7, 1, this.hED);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.hED.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            apy com_tencent_mm_protocal_c_apy = (apy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_apy.eBZ = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apy.title = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apy.eBN = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apy.mPq = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apy.mPr = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apy.bCj = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_apy.hED.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
