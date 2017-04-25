package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class ib extends a {
    public String aXz;
    public String glb;
    public String miX;
    public String miY;
    public int miZ;
    public String mja;
    public int mjb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.glb == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.miX == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.miY == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else {
                if (this.aXz != null) {
                    aVar.e(1, this.aXz);
                }
                if (this.glb != null) {
                    aVar.e(2, this.glb);
                }
                if (this.miX != null) {
                    aVar.e(3, this.miX);
                }
                if (this.miY != null) {
                    aVar.e(4, this.miY);
                }
                aVar.dV(5, this.miZ);
                if (this.mja != null) {
                    aVar.e(6, this.mja);
                }
                aVar.dV(7, this.mjb);
                return 0;
            }
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(2, this.glb);
            }
            if (this.miX != null) {
                r0 += a.a.a.b.b.a.f(3, this.miX);
            }
            if (this.miY != null) {
                r0 += a.a.a.b.b.a.f(4, this.miY);
            }
            r0 += a.a.a.a.dS(5, this.miZ);
            if (this.mja != null) {
                r0 += a.a.a.b.b.a.f(6, this.mja);
            }
            return r0 + a.a.a.a.dS(7, this.mjb);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.glb == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.miX == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.miY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DetailInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ib ibVar = (ib) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ibVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ibVar.glb = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ibVar.miX = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ibVar.miY = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ibVar.miZ = aVar3.pMj.mH();
                    return 0;
                case 6:
                    ibVar.mja = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ibVar.mjb = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
