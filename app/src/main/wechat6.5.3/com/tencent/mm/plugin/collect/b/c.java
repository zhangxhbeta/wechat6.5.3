package com.tencent.mm.plugin.collect.b;

import a.a.a.b;
import com.tencent.mm.ba.a;

public class c extends a {
    public String caJ;
    public String cpl;
    public String eWA;
    public int eWB;
    public double eWz;
    public int scene;
    public int status;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.eWA == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.cpl == null) {
                throw new b("Not all required fields were included: feeType");
            } else {
                if (this.username != null) {
                    aVar.e(1, this.username);
                }
                if (this.eWA != null) {
                    aVar.e(2, this.eWA);
                }
                aVar.a(3, this.eWz);
                if (this.cpl != null) {
                    aVar.e(4, this.cpl);
                }
                aVar.dV(5, this.eWB);
                aVar.dV(6, this.scene);
                aVar.dV(7, this.status);
                if (this.caJ == null) {
                    return 0;
                }
                aVar.e(8, this.caJ);
                return 0;
            }
        } else if (i == 1) {
            if (this.username != null) {
                r0 = a.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            if (this.eWA != null) {
                r0 += a.a.a.b.b.a.f(2, this.eWA);
            }
            r0 += a.a.a.b.b.a.cw(3) + 8;
            if (this.cpl != null) {
                r0 += a.a.a.b.b.a.f(4, this.cpl);
            }
            r0 = ((r0 + a.a.a.a.dS(5, this.eWB)) + a.a.a.a.dS(6, this.scene)) + a.a.a.a.dS(7, this.status);
            if (this.caJ != null) {
                r0 += a.a.a.b.b.a.f(8, this.caJ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.eWA == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.cpl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: feeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.username = aVar3.pMj.readString();
                    return 0;
                case 2:
                    cVar.eWA = aVar3.pMj.readString();
                    return 0;
                case 3:
                    cVar.eWz = aVar3.pMj.readDouble();
                    return 0;
                case 4:
                    cVar.cpl = aVar3.pMj.readString();
                    return 0;
                case 5:
                    cVar.eWB = aVar3.pMj.mH();
                    return 0;
                case 6:
                    cVar.scene = aVar3.pMj.mH();
                    return 0;
                case 7:
                    cVar.status = aVar3.pMj.mH();
                    return 0;
                case 8:
                    cVar.caJ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
