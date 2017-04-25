package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class g extends a {
    public String eeA;
    public String eeB;
    public String eeC;
    public String eeD;
    public int eeE;
    public long eeF;
    public String eez;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eez == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.eeA == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.eeB == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.eeC == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.eeD == null) {
                throw new b("Not all required fields were included: SystemVersion");
            } else {
                if (this.eez != null) {
                    aVar.e(1, this.eez);
                }
                if (this.eeA != null) {
                    aVar.e(2, this.eeA);
                }
                if (this.eeB != null) {
                    aVar.e(3, this.eeB);
                }
                if (this.eeC != null) {
                    aVar.e(4, this.eeC);
                }
                if (this.eeD != null) {
                    aVar.e(5, this.eeD);
                }
                aVar.dV(6, this.eeE);
                aVar.C(7, this.eeF);
                return 0;
            }
        } else if (i == 1) {
            if (this.eez != null) {
                r0 = a.a.a.b.b.a.f(1, this.eez) + 0;
            } else {
                r0 = 0;
            }
            if (this.eeA != null) {
                r0 += a.a.a.b.b.a.f(2, this.eeA);
            }
            if (this.eeB != null) {
                r0 += a.a.a.b.b.a.f(3, this.eeB);
            }
            if (this.eeC != null) {
                r0 += a.a.a.b.b.a.f(4, this.eeC);
            }
            if (this.eeD != null) {
                r0 += a.a.a.b.b.a.f(5, this.eeD);
            }
            return (r0 + a.a.a.a.dS(6, this.eeE)) + a.a.a.a.B(7, this.eeF);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.eez == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.eeA == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.eeB == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.eeC == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.eeD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SystemVersion");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.eez = aVar3.pMj.readString();
                    return 0;
                case 2:
                    gVar.eeA = aVar3.pMj.readString();
                    return 0;
                case 3:
                    gVar.eeB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    gVar.eeC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    gVar.eeD = aVar3.pMj.readString();
                    return 0;
                case 6:
                    gVar.eeE = aVar3.pMj.mH();
                    return 0;
                case 7:
                    gVar.eeF = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
