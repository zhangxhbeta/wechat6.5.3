package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class cl extends a {
    public String efc;
    public String gID;
    public String hNZ;
    public String mcF;
    public String mcG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gID != null) {
                aVar.e(1, this.gID);
            }
            if (this.efc != null) {
                aVar.e(2, this.efc);
            }
            if (this.hNZ != null) {
                aVar.e(3, this.hNZ);
            }
            if (this.mcF != null) {
                aVar.e(4, this.mcF);
            }
            if (this.mcG == null) {
                return 0;
            }
            aVar.e(5, this.mcG);
            return 0;
        } else if (i == 1) {
            if (this.gID != null) {
                r0 = a.a.a.b.b.a.f(1, this.gID) + 0;
            } else {
                r0 = 0;
            }
            if (this.efc != null) {
                r0 += a.a.a.b.b.a.f(2, this.efc);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.hNZ);
            }
            if (this.mcF != null) {
                r0 += a.a.a.b.b.a.f(4, this.mcF);
            }
            if (this.mcG != null) {
                r0 += a.a.a.b.b.a.f(5, this.mcG);
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
            cl clVar = (cl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clVar.gID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    clVar.efc = aVar3.pMj.readString();
                    return 0;
                case 3:
                    clVar.hNZ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    clVar.mcF = aVar3.pMj.readString();
                    return 0;
                case 5:
                    clVar.mcG = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
