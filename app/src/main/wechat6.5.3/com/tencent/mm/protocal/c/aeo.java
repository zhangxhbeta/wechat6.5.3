package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aeo extends a {
    public int mES;
    public String mET;
    public LinkedList<String> mEU = new LinkedList();
    public String mEw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mEw != null) {
                aVar.e(1, this.mEw);
            }
            aVar.dV(2, this.mES);
            if (this.mET != null) {
                aVar.e(3, this.mET);
            }
            aVar.d(4, 1, this.mEU);
            return 0;
        } else if (i == 1) {
            if (this.mEw != null) {
                r0 = a.a.a.b.b.a.f(1, this.mEw) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mES);
            if (this.mET != null) {
                r0 += a.a.a.b.b.a.f(3, this.mET);
            }
            return r0 + a.a.a.a.c(4, 1, this.mEU);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.mEU.clear();
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
            aeo com_tencent_mm_protocal_c_aeo = (aeo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aeo.mEw = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aeo.mES = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aeo.mET = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aeo.mEU.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
