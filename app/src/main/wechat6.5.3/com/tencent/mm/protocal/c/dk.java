package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class dk extends a {
    public String gkV;
    public String gkz;
    public String gnp;
    public String hNZ;
    public String mdQ;
    public String mdR;
    public String mdS;
    public int mdj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkz != null) {
                aVar.e(1, this.gkz);
            }
            if (this.mdQ != null) {
                aVar.e(2, this.mdQ);
            }
            if (this.gnp != null) {
                aVar.e(3, this.gnp);
            }
            if (this.hNZ != null) {
                aVar.e(4, this.hNZ);
            }
            aVar.dV(5, this.mdj);
            if (this.gkV != null) {
                aVar.e(6, this.gkV);
            }
            if (this.mdR != null) {
                aVar.e(7, this.mdR);
            }
            if (this.mdS == null) {
                return 0;
            }
            aVar.e(8, this.mdS);
            return 0;
        } else if (i == 1) {
            if (this.gkz != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mdQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.mdQ);
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(3, this.gnp);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.hNZ);
            }
            r0 += a.a.a.a.dS(5, this.mdj);
            if (this.gkV != null) {
                r0 += a.a.a.b.b.a.f(6, this.gkV);
            }
            if (this.mdR != null) {
                r0 += a.a.a.b.b.a.f(7, this.mdR);
            }
            if (this.mdS != null) {
                r0 += a.a.a.b.b.a.f(8, this.mdS);
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
            dk dkVar = (dk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dkVar.gkz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    dkVar.mdQ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dkVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 4:
                    dkVar.hNZ = aVar3.pMj.readString();
                    return 0;
                case 5:
                    dkVar.mdj = aVar3.pMj.mH();
                    return 0;
                case 6:
                    dkVar.gkV = aVar3.pMj.readString();
                    return 0;
                case 7:
                    dkVar.mdR = aVar3.pMj.readString();
                    return 0;
                case 8:
                    dkVar.mdS = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
