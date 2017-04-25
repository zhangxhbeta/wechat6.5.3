package com.tencent.mm.plugin.qqmail.b;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class i extends a {
    public String gRG;
    public int iaM;
    public int iaN;
    public String iaO;
    public String name;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.gRG == null) {
                throw new b("Not all required fields were included: addr");
            } else {
                aVar.dV(1, this.iaM);
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                if (this.gRG != null) {
                    aVar.e(3, this.gRG);
                }
                aVar.dV(4, this.iaN);
                if (this.iaO != null) {
                    aVar.e(5, this.iaO);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.iaM) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.gRG != null) {
                r0 += a.a.a.b.b.a.f(3, this.gRG);
            }
            r0 += a.a.a.a.dS(4, this.iaN);
            if (this.iaO != null) {
                return r0 + a.a.a.b.b.a.f(5, this.iaO);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.gRG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: addr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.iaM = aVar3.pMj.mH();
                    return 0;
                case 2:
                    iVar.name = aVar3.pMj.readString();
                    return 0;
                case 3:
                    iVar.gRG = aVar3.pMj.readString();
                    return 0;
                case 4:
                    iVar.iaN = aVar3.pMj.mH();
                    return 0;
                case 5:
                    iVar.iaO = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
