package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class au extends aqp {
    public String bssid;
    public String cZv;
    public String mbb;
    public long mbc;
    public int mbe;
    public int mbp;
    public at mbq;
    public aw mbr;
    public int scene;
    public String ssid;
    public int type;

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
            aVar.dV(3, this.scene);
            aVar.dV(4, this.type);
            aVar.dV(5, this.mbp);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.C(8, this.mbc);
            if (this.mbq != null) {
                aVar.dX(9, this.mbq.aHr());
                this.mbq.a(aVar);
            }
            if (this.mbr != null) {
                aVar.dX(10, this.mbr.aHr());
                this.mbr.a(aVar);
            }
            aVar.dV(11, this.mbe);
            if (this.mbb == null) {
                return 0;
            }
            aVar.e(12, this.mbb);
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
            r0 = ((r0 + a.a.a.a.dS(3, this.scene)) + a.a.a.a.dS(4, this.type)) + a.a.a.a.dS(5, this.mbp);
            if (this.ssid != null) {
                r0 += a.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                r0 += a.a.a.b.b.a.f(7, this.bssid);
            }
            r0 += a.a.a.a.B(8, this.mbc);
            if (this.mbq != null) {
                r0 += a.a.a.a.dU(9, this.mbq.aHr());
            }
            if (this.mbr != null) {
                r0 += a.a.a.a.dU(10, this.mbr.aHr());
            }
            r0 += a.a.a.a.dS(11, this.mbe);
            if (this.mbb != null) {
                r0 += a.a.a.b.b.a.f(12, this.mbb);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            au auVar = (au) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        auVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    auVar.cZv = aVar3.pMj.readString();
                    return 0;
                case 3:
                    auVar.scene = aVar3.pMj.mH();
                    return 0;
                case 4:
                    auVar.type = aVar3.pMj.mH();
                    return 0;
                case 5:
                    auVar.mbp = aVar3.pMj.mH();
                    return 0;
                case 6:
                    auVar.ssid = aVar3.pMj.readString();
                    return 0;
                case 7:
                    auVar.bssid = aVar3.pMj.readString();
                    return 0;
                case 8:
                    auVar.mbc = aVar3.pMj.mI();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        at atVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atVar.a(aVar4, atVar, aqp.a(aVar4))) {
                        }
                        auVar.mbq = atVar;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, aqp.a(aVar4))) {
                        }
                        auVar.mbr = awVar;
                    }
                    return 0;
                case 11:
                    auVar.mbe = aVar3.pMj.mH();
                    return 0;
                case 12:
                    auVar.mbb = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
