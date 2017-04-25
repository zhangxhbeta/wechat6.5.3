package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ix extends a {
    public String bCk;
    public String bCl;
    public float bhs;
    public float biH;
    public String cJf;
    public String cJg;
    public String descriptor;
    public String eBY;
    public String eDc;
    public float mkD;
    public String name;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.descriptor != null) {
                aVar.e(2, this.descriptor);
            }
            if (this.eBY != null) {
                aVar.e(3, this.eBY);
            }
            if (this.cJg != null) {
                aVar.e(4, this.cJg);
            }
            if (this.bCk != null) {
                aVar.e(5, this.bCk);
            }
            if (this.bCl != null) {
                aVar.e(6, this.bCl);
            }
            if (this.cJf != null) {
                aVar.e(7, this.cJf);
            }
            aVar.j(8, this.mkD);
            aVar.j(9, this.biH);
            aVar.j(10, this.bhs);
            if (this.eDc == null) {
                return 0;
            }
            aVar.e(11, this.eDc);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                r0 = a.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                r0 = 0;
            }
            if (this.descriptor != null) {
                r0 += a.a.a.b.b.a.f(2, this.descriptor);
            }
            if (this.eBY != null) {
                r0 += a.a.a.b.b.a.f(3, this.eBY);
            }
            if (this.cJg != null) {
                r0 += a.a.a.b.b.a.f(4, this.cJg);
            }
            if (this.bCk != null) {
                r0 += a.a.a.b.b.a.f(5, this.bCk);
            }
            if (this.bCl != null) {
                r0 += a.a.a.b.b.a.f(6, this.bCl);
            }
            if (this.cJf != null) {
                r0 += a.a.a.b.b.a.f(7, this.cJf);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cw(8) + 4)) + (a.a.a.b.b.a.cw(9) + 4)) + (a.a.a.b.b.a.cw(10) + 4);
            if (this.eDc != null) {
                r0 += a.a.a.b.b.a.f(11, this.eDc);
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
            ix ixVar = (ix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ixVar.name = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ixVar.descriptor = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ixVar.eBY = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ixVar.cJg = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ixVar.bCk = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ixVar.bCl = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ixVar.cJf = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ixVar.mkD = aVar3.pMj.readFloat();
                    return 0;
                case 9:
                    ixVar.biH = aVar3.pMj.readFloat();
                    return 0;
                case 10:
                    ixVar.bhs = aVar3.pMj.readFloat();
                    return 0;
                case 11:
                    ixVar.eDc = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
