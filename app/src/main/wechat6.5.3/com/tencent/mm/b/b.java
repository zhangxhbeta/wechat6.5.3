package com.tencent.mm.b;

import com.tencent.mm.ba.a;

public final class b extends a {
    public int aPW;
    public String aPX;
    public int aPY;
    public String aPZ;
    public String aQa;
    public boolean aQb;
    public int aQc;
    public boolean aQd;
    public String apkMd5;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.apkMd5 == null) {
                throw new a.a.a.b("Not all required fields were included: apkMd5");
            }
            if (this.apkMd5 != null) {
                aVar.e(1, this.apkMd5);
            }
            aVar.dW(2, this.aPW);
            if (this.aPX != null) {
                aVar.e(3, this.aPX);
            }
            aVar.dW(4, this.aPY);
            if (this.aPZ != null) {
                aVar.e(5, this.aPZ);
            }
            if (this.aQa != null) {
                aVar.e(6, this.aQa);
            }
            aVar.ab(7, this.aQb);
            aVar.dW(8, this.aQc);
            aVar.ab(9, this.aQd);
            return 0;
        } else if (i == 1) {
            if (this.apkMd5 != null) {
                r0 = a.a.a.a.f(1, this.apkMd5) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dT(2, this.aPW);
            if (this.aPX != null) {
                r0 += a.a.a.a.f(3, this.aPX);
            }
            r0 += a.a.a.a.dT(4, this.aPY);
            if (this.aPZ != null) {
                r0 += a.a.a.a.f(5, this.aPZ);
            }
            if (this.aQa != null) {
                r0 += a.a.a.a.f(6, this.aQa);
            }
            return ((r0 + a.a.a.a.zP(7)) + a.a.a.a.dT(8, this.aQc)) + a.a.a.a.zP(9);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.apkMd5 != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: apkMd5");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.apkMd5 = aVar3.bQI();
                    return 0;
                case 2:
                    bVar.aPW = aVar3.bQG();
                    return 0;
                case 3:
                    bVar.aPX = aVar3.bQI();
                    return 0;
                case 4:
                    bVar.aPY = aVar3.bQG();
                    return 0;
                case 5:
                    bVar.aPZ = aVar3.bQI();
                    return 0;
                case 6:
                    bVar.aQa = aVar3.bQI();
                    return 0;
                case 7:
                    bVar.aQb = aVar3.bQJ();
                    return 0;
                case 8:
                    bVar.aQc = aVar3.bQG();
                    return 0;
                case 9:
                    bVar.aQd = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
