package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bil extends a {
    public String ncW;
    public String ncX;
    public String ncY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncW == null) {
                throw new b("Not all required fields were included: Plugin");
            } else if (this.ncX == null) {
                throw new b("Not all required fields were included: ActivityPath");
            } else {
                if (this.ncW != null) {
                    aVar.e(1, this.ncW);
                }
                if (this.ncX != null) {
                    aVar.e(2, this.ncX);
                }
                if (this.ncY == null) {
                    return 0;
                }
                aVar.e(3, this.ncY);
                return 0;
            }
        } else if (i == 1) {
            if (this.ncW != null) {
                r0 = a.a.a.b.b.a.f(1, this.ncW) + 0;
            } else {
                r0 = 0;
            }
            if (this.ncX != null) {
                r0 += a.a.a.b.b.a.f(2, this.ncX);
            }
            if (this.ncY != null) {
                r0 += a.a.a.b.b.a.f(3, this.ncY);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncW == null) {
                throw new b("Not all required fields were included: Plugin");
            } else if (this.ncX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActivityPath");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bil com_tencent_mm_protocal_c_bil = (bil) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bil.ncW = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bil.ncX = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bil.ncY = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
