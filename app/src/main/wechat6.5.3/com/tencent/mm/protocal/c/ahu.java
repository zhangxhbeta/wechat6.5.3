package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ahu extends a {
    public String aYz;
    public int bcb;
    public String bssid;
    public int fXb;
    public int mHq;
    public String mHr;
    public String ssid;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ssid != null) {
                aVar.e(1, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(2, this.bssid);
            }
            aVar.dV(3, this.bcb);
            aVar.dV(4, this.mHq);
            if (this.mHr != null) {
                aVar.e(5, this.mHr);
            }
            if (this.aYz != null) {
                aVar.e(6, this.aYz);
            }
            aVar.dV(7, this.fXb);
            return 0;
        } else if (i == 1) {
            if (this.ssid != null) {
                r0 = a.a.a.b.b.a.f(1, this.ssid) + 0;
            } else {
                r0 = 0;
            }
            if (this.bssid != null) {
                r0 += a.a.a.b.b.a.f(2, this.bssid);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.bcb)) + a.a.a.a.dS(4, this.mHq);
            if (this.mHr != null) {
                r0 += a.a.a.b.b.a.f(5, this.mHr);
            }
            if (this.aYz != null) {
                r0 += a.a.a.b.b.a.f(6, this.aYz);
            }
            return r0 + a.a.a.a.dS(7, this.fXb);
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
            ahu com_tencent_mm_protocal_c_ahu = (ahu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ahu.ssid = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahu.bssid = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahu.bcb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahu.mHq = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahu.mHr = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ahu.aYz = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ahu.fXb = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
