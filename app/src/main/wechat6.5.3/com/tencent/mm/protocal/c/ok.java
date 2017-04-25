package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class ok extends a {
    public int mbK;
    public String mqC;
    public String mqD;
    public String mqE;
    public String mqF;
    public String mqG;
    public int mqH;
    public int mqI;
    public String mqJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mqC == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.mqD == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.mqE == null) {
                throw new b("Not all required fields were included: ThanksPicUrl");
            } else {
                if (this.mqC != null) {
                    aVar.e(1, this.mqC);
                }
                if (this.mqD != null) {
                    aVar.e(2, this.mqD);
                }
                if (this.mqE != null) {
                    aVar.e(3, this.mqE);
                }
                if (this.mqF != null) {
                    aVar.e(4, this.mqF);
                }
                if (this.mqG != null) {
                    aVar.e(5, this.mqG);
                }
                aVar.dV(6, this.mqH);
                aVar.dV(7, this.mqI);
                if (this.mqJ != null) {
                    aVar.e(8, this.mqJ);
                }
                aVar.dV(9, this.mbK);
                return 0;
            }
        } else if (i == 1) {
            if (this.mqC != null) {
                r0 = a.a.a.b.b.a.f(1, this.mqC) + 0;
            } else {
                r0 = 0;
            }
            if (this.mqD != null) {
                r0 += a.a.a.b.b.a.f(2, this.mqD);
            }
            if (this.mqE != null) {
                r0 += a.a.a.b.b.a.f(3, this.mqE);
            }
            if (this.mqF != null) {
                r0 += a.a.a.b.b.a.f(4, this.mqF);
            }
            if (this.mqG != null) {
                r0 += a.a.a.b.b.a.f(5, this.mqG);
            }
            r0 = (r0 + a.a.a.a.dS(6, this.mqH)) + a.a.a.a.dS(7, this.mqI);
            if (this.mqJ != null) {
                r0 += a.a.a.b.b.a.f(8, this.mqJ);
            }
            return r0 + a.a.a.a.dS(9, this.mbK);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mqC == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.mqD == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.mqE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThanksPicUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ok okVar = (ok) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    okVar.mqC = aVar3.pMj.readString();
                    return 0;
                case 2:
                    okVar.mqD = aVar3.pMj.readString();
                    return 0;
                case 3:
                    okVar.mqE = aVar3.pMj.readString();
                    return 0;
                case 4:
                    okVar.mqF = aVar3.pMj.readString();
                    return 0;
                case 5:
                    okVar.mqG = aVar3.pMj.readString();
                    return 0;
                case 6:
                    okVar.mqH = aVar3.pMj.mH();
                    return 0;
                case 7:
                    okVar.mqI = aVar3.pMj.mH();
                    return 0;
                case 8:
                    okVar.mqJ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    okVar.mbK = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
