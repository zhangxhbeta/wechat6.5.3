package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class acn extends a {
    public String aXz;
    public String glb;
    public String hNZ;
    public String mDD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.glb != null) {
                aVar.e(1, this.glb);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            if (this.mDD != null) {
                aVar.e(3, this.mDD);
            }
            if (this.hNZ == null) {
                return 0;
            }
            aVar.e(4, this.hNZ);
            return 0;
        } else if (i == 1) {
            if (this.glb != null) {
                r0 = a.a.a.b.b.a.f(1, this.glb) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.mDD != null) {
                r0 += a.a.a.b.b.a.f(3, this.mDD);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.hNZ);
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
            acn com_tencent_mm_protocal_c_acn = (acn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_acn.glb = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acn.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_acn.mDD = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_acn.hNZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
