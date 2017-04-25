package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ap extends aqp {
    public int bbT;
    public String bssid;
    public String cZv;
    public int cZy;
    public String mbb;
    public long mbc;
    public ba mbd;
    public int mbe;
    public int mbf;
    public String mbg;
    public int scene;
    public String ssid;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.cZv != null) {
                aVar.e(2, this.cZv);
            }
            aVar.dV(3, this.cZy);
            if (this.mbb != null) {
                aVar.e(4, this.mbb);
            }
            aVar.dV(5, this.scene);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.C(8, this.mbc);
            if (this.mbd != null) {
                aVar.dX(9, this.mbd.aHr());
                this.mbd.a(aVar);
            }
            aVar.dV(10, this.mbe);
            aVar.dV(11, this.mbf);
            aVar.dV(12, this.bbT);
            if (this.mbg == null) {
                return 0;
            }
            aVar.e(13, this.mbg);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.cZv != null) {
                r0 += a.a.a.b.b.a.f(2, this.cZv);
            }
            r0 += a.a.a.a.dS(3, this.cZy);
            if (this.mbb != null) {
                r0 += a.a.a.b.b.a.f(4, this.mbb);
            }
            r0 += a.a.a.a.dS(5, this.scene);
            if (this.ssid != null) {
                r0 += a.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                r0 += a.a.a.b.b.a.f(7, this.bssid);
            }
            r0 += a.a.a.a.B(8, this.mbc);
            if (this.mbd != null) {
                r0 += a.a.a.a.dU(9, this.mbd.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(10, this.mbe)) + a.a.a.a.dS(11, this.mbf)) + a.a.a.a.dS(12, this.bbT);
            if (this.mbg != null) {
                r0 += a.a.a.b.b.a.f(13, this.mbg);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ap apVar = (ap) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        apVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    apVar.cZv = aVar3.pMj.readString();
                    return 0;
                case 3:
                    apVar.cZy = aVar3.pMj.mH();
                    return 0;
                case 4:
                    apVar.mbb = aVar3.pMj.readString();
                    return 0;
                case 5:
                    apVar.scene = aVar3.pMj.mH();
                    return 0;
                case 6:
                    apVar.ssid = aVar3.pMj.readString();
                    return 0;
                case 7:
                    apVar.bssid = aVar3.pMj.readString();
                    return 0;
                case 8:
                    apVar.mbc = aVar3.pMj.mI();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new ba();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        apVar.mbd = enVar;
                    }
                    return 0;
                case 10:
                    apVar.mbe = aVar3.pMj.mH();
                    return 0;
                case 11:
                    apVar.mbf = aVar3.pMj.mH();
                    return 0;
                case 12:
                    apVar.bbT = aVar3.pMj.mH();
                    return 0;
                case 13:
                    apVar.mbg = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
