package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class nu extends a {
    public String glb;
    public String hOx;
    public String mdM;
    public String mpC;
    public String mpD;
    public String mpE;
    public String mpF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpC == null) {
                throw new b("Not all required fields were included: Md5");
            }
            if (this.mpC != null) {
                aVar.e(1, this.mpC);
            }
            if (this.glb != null) {
                aVar.e(2, this.glb);
            }
            if (this.hOx != null) {
                aVar.e(3, this.hOx);
            }
            if (this.mpD != null) {
                aVar.e(4, this.mpD);
            }
            if (this.mpE != null) {
                aVar.e(5, this.mpE);
            }
            if (this.mpF != null) {
                aVar.e(6, this.mpF);
            }
            if (this.mdM == null) {
                return 0;
            }
            aVar.e(7, this.mdM);
            return 0;
        } else if (i == 1) {
            if (this.mpC != null) {
                r0 = a.a.a.b.b.a.f(1, this.mpC) + 0;
            } else {
                r0 = 0;
            }
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(2, this.glb);
            }
            if (this.hOx != null) {
                r0 += a.a.a.b.b.a.f(3, this.hOx);
            }
            if (this.mpD != null) {
                r0 += a.a.a.b.b.a.f(4, this.mpD);
            }
            if (this.mpE != null) {
                r0 += a.a.a.b.b.a.f(5, this.mpE);
            }
            if (this.mpF != null) {
                r0 += a.a.a.b.b.a.f(6, this.mpF);
            }
            if (this.mdM != null) {
                r0 += a.a.a.b.b.a.f(7, this.mdM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mpC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Md5");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            nu nuVar = (nu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nuVar.mpC = aVar3.pMj.readString();
                    return 0;
                case 2:
                    nuVar.glb = aVar3.pMj.readString();
                    return 0;
                case 3:
                    nuVar.hOx = aVar3.pMj.readString();
                    return 0;
                case 4:
                    nuVar.mpD = aVar3.pMj.readString();
                    return 0;
                case 5:
                    nuVar.mpE = aVar3.pMj.readString();
                    return 0;
                case 6:
                    nuVar.mpF = aVar3.pMj.readString();
                    return 0;
                case 7:
                    nuVar.mdM = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
