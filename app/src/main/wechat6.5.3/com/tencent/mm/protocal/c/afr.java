package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class afr extends a {
    public String eEw;
    public double latitude;
    public double longitude;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.latitude);
            aVar.a(2, this.longitude);
            if (this.eEw != null) {
                aVar.e(3, this.eEw);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.b.b.a.cw(1) + 8) + 0) + (a.a.a.b.b.a.cw(2) + 8);
            if (this.eEw != null) {
                return r0 + a.a.a.b.b.a.f(3, this.eEw);
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
            afr com_tencent_mm_protocal_c_afr = (afr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afr.latitude = aVar3.pMj.readDouble();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afr.longitude = aVar3.pMj.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afr.eEw = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
