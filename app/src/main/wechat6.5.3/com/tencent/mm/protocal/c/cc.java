package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class cc extends a {
    public String mac;
    public int mcu;
    public String ssid;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mac != null) {
                aVar.e(1, this.mac);
            }
            aVar.dV(2, this.mcu);
            if (this.ssid == null) {
                return 0;
            }
            aVar.e(3, this.ssid);
            return 0;
        } else if (i == 1) {
            if (this.mac != null) {
                r0 = a.a.a.b.b.a.f(1, this.mac) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mcu);
            if (this.ssid != null) {
                r0 += a.a.a.b.b.a.f(3, this.ssid);
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
            cc ccVar = (cc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccVar.mac = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ccVar.mcu = aVar3.pMj.mH();
                    return 0;
                case 3:
                    ccVar.ssid = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
