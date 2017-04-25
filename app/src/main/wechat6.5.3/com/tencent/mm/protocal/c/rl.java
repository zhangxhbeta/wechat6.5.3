package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class rl extends a {
    public String aXz;
    public String gkC;
    public String glj;
    public String hNZ;
    public String hOx;
    public int mkB;
    public String muV;
    public int mvn;
    public int mvo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.gkC == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.hOx == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                if (this.aXz != null) {
                    aVar.e(1, this.aXz);
                }
                if (this.gkC != null) {
                    aVar.e(2, this.gkC);
                }
                if (this.hOx != null) {
                    aVar.e(3, this.hOx);
                }
                if (this.muV != null) {
                    aVar.e(4, this.muV);
                }
                aVar.dV(5, this.mvn);
                aVar.dV(6, this.mvo);
                if (this.glj != null) {
                    aVar.e(7, this.glj);
                }
                aVar.dV(8, this.mkB);
                if (this.hNZ == null) {
                    return 0;
                }
                aVar.e(9, this.hNZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkC);
            }
            if (this.hOx != null) {
                r0 += a.a.a.b.b.a.f(3, this.hOx);
            }
            if (this.muV != null) {
                r0 += a.a.a.b.b.a.f(4, this.muV);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.mvn)) + a.a.a.a.dS(6, this.mvo);
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(7, this.glj);
            }
            r0 += a.a.a.a.dS(8, this.mkB);
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(9, this.hNZ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.gkC == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.hOx != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            rl rlVar = (rl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rlVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    rlVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    rlVar.hOx = aVar3.pMj.readString();
                    return 0;
                case 4:
                    rlVar.muV = aVar3.pMj.readString();
                    return 0;
                case 5:
                    rlVar.mvn = aVar3.pMj.mH();
                    return 0;
                case 6:
                    rlVar.mvo = aVar3.pMj.mH();
                    return 0;
                case 7:
                    rlVar.glj = aVar3.pMj.readString();
                    return 0;
                case 8:
                    rlVar.mkB = aVar3.pMj.mH();
                    return 0;
                case 9:
                    rlVar.hNZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
