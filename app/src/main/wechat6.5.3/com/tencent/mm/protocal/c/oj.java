package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class oj extends a {
    public String gnz;
    public String mqA;
    public String mqB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gnz == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.mqA == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.mqB == null) {
                throw new b("Not all required fields were included: Type");
            } else {
                if (this.gnz != null) {
                    aVar.e(1, this.gnz);
                }
                if (this.mqA != null) {
                    aVar.e(2, this.mqA);
                }
                if (this.mqB == null) {
                    return 0;
                }
                aVar.e(3, this.mqB);
                return 0;
            }
        } else if (i == 1) {
            if (this.gnz != null) {
                r0 = a.a.a.b.b.a.f(1, this.gnz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mqA != null) {
                r0 += a.a.a.b.b.a.f(2, this.mqA);
            }
            if (this.mqB != null) {
                r0 += a.a.a.b.b.a.f(3, this.mqB);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gnz == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.mqA == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.mqB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Type");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            oj ojVar = (oj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ojVar.gnz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ojVar.mqA = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ojVar.mqB = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
