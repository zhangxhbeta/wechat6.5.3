package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class acl extends a {
    public String gnz;
    public float mDA;
    public String mDC;
    public float mij;
    public float mik;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.j(1, this.mij);
            aVar.j(2, this.mik);
            aVar.j(3, this.mDA);
            if (this.gnz != null) {
                aVar.e(4, this.gnz);
            }
            if (this.mDC != null) {
                aVar.e(5, this.mDC);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.b.b.a.cw(1) + 4) + 0) + (a.a.a.b.b.a.cw(2) + 4)) + (a.a.a.b.b.a.cw(3) + 4);
            if (this.gnz != null) {
                r0 += a.a.a.b.b.a.f(4, this.gnz);
            }
            if (this.mDC != null) {
                return r0 + a.a.a.b.b.a.f(5, this.mDC);
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
            acl com_tencent_mm_protocal_c_acl = (acl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_acl.mij = aVar3.pMj.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acl.mik = aVar3.pMj.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_acl.mDA = aVar3.pMj.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_acl.gnz = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_acl.mDC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
