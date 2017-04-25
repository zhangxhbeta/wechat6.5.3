package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class qk extends a {
    public int aLe;
    public String lnP;
    public String mtW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lnP == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.mtW == null) {
                throw new b("Not all required fields were included: tagPinYin");
            } else {
                if (this.lnP != null) {
                    aVar.e(1, this.lnP);
                }
                if (this.mtW != null) {
                    aVar.e(2, this.mtW);
                }
                aVar.dV(3, this.aLe);
                return 0;
            }
        } else if (i == 1) {
            if (this.lnP != null) {
                r0 = a.a.a.b.b.a.f(1, this.lnP) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtW != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtW);
            }
            return r0 + a.a.a.a.dS(3, this.aLe);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.lnP == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.mtW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: tagPinYin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            qk qkVar = (qk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qkVar.lnP = aVar3.pMj.readString();
                    return 0;
                case 2:
                    qkVar.mtW = aVar3.pMj.readString();
                    return 0;
                case 3:
                    qkVar.aLe = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
