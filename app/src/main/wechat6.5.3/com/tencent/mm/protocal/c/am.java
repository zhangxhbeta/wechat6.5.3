package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class am extends a {
    public String bCk;
    public String bCl;
    public double latitude;
    public double longitude;
    public long maQ;
    public String maR;
    public String maS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bCk != null) {
                aVar.e(1, this.bCk);
            }
            if (this.bCl != null) {
                aVar.e(2, this.bCl);
            }
            aVar.a(3, this.latitude);
            aVar.a(4, this.longitude);
            aVar.C(5, this.maQ);
            if (this.maR != null) {
                aVar.e(6, this.maR);
            }
            if (this.maS == null) {
                return 0;
            }
            aVar.e(7, this.maS);
            return 0;
        } else if (i == 1) {
            if (this.bCk != null) {
                r0 = a.a.a.b.b.a.f(1, this.bCk) + 0;
            } else {
                r0 = 0;
            }
            if (this.bCl != null) {
                r0 += a.a.a.b.b.a.f(2, this.bCl);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cw(3) + 8)) + (a.a.a.b.b.a.cw(4) + 8)) + a.a.a.a.B(5, this.maQ);
            if (this.maR != null) {
                r0 += a.a.a.b.b.a.f(6, this.maR);
            }
            if (this.maS != null) {
                r0 += a.a.a.b.b.a.f(7, this.maS);
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
            am amVar = (am) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amVar.bCk = aVar3.pMj.readString();
                    return 0;
                case 2:
                    amVar.bCl = aVar3.pMj.readString();
                    return 0;
                case 3:
                    amVar.latitude = aVar3.pMj.readDouble();
                    return 0;
                case 4:
                    amVar.longitude = aVar3.pMj.readDouble();
                    return 0;
                case 5:
                    amVar.maQ = aVar3.pMj.mI();
                    return 0;
                case 6:
                    amVar.maR = aVar3.pMj.readString();
                    return 0;
                case 7:
                    amVar.maS = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
