package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class bv extends a {
    public String gkA;
    public String gkv;
    public String gnS;
    public String gnT;
    public String gnU;
    public boolean gnV;
    public boolean gnW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkA != null) {
                aVar.e(1, this.gkA);
            }
            if (this.gnS != null) {
                aVar.e(2, this.gnS);
            }
            if (this.gnT != null) {
                aVar.e(3, this.gnT);
            }
            if (this.gnU != null) {
                aVar.e(4, this.gnU);
            }
            if (this.gkv != null) {
                aVar.e(5, this.gkv);
            }
            aVar.ab(6, this.gnV);
            aVar.ab(7, this.gnW);
            return 0;
        } else if (i == 1) {
            if (this.gkA != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkA) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnS != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnS);
            }
            if (this.gnT != null) {
                r0 += a.a.a.b.b.a.f(3, this.gnT);
            }
            if (this.gnU != null) {
                r0 += a.a.a.b.b.a.f(4, this.gnU);
            }
            if (this.gkv != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkv);
            }
            return (r0 + (a.a.a.b.b.a.cw(6) + 1)) + (a.a.a.b.b.a.cw(7) + 1);
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
            bv bvVar = (bv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bvVar.gkA = aVar3.pMj.readString();
                    return 0;
                case 2:
                    bvVar.gnS = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bvVar.gnT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    bvVar.gnU = aVar3.pMj.readString();
                    return 0;
                case 5:
                    bvVar.gkv = aVar3.pMj.readString();
                    return 0;
                case 6:
                    bvVar.gnV = aVar3.bQJ();
                    return 0;
                case 7:
                    bvVar.gnW = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
