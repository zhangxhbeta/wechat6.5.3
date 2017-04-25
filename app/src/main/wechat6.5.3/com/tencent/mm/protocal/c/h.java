package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class h extends aqp {
    public LinkedList<j> lYB = new LinkedList();
    public am lYC;
    public long lYE;
    public String lYx;
    public int scene;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.C(3, this.lYE);
            aVar.d(5, 8, this.lYB);
            aVar.dV(7, this.scene);
            if (this.lYx != null) {
                aVar.e(8, this.lYx);
            }
            if (this.lYC == null) {
                return 0;
            }
            aVar.dX(9, this.lYC.aHr());
            this.lYC.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            r0 = ((r0 + a.a.a.a.B(3, this.lYE)) + a.a.a.a.c(5, 8, this.lYB)) + a.a.a.a.dS(7, this.scene);
            if (this.lYx != null) {
                r0 += a.a.a.b.b.a.f(8, this.lYx);
            }
            if (this.lYC != null) {
                r0 += a.a.a.a.dU(9, this.lYC.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lYB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        hVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    hVar.title = aVar3.pMj.readString();
                    return 0;
                case 3:
                    hVar.lYE = aVar3.pMj.mI();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        j jVar = new j();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jVar.a(aVar4, jVar, aqp.a(aVar4))) {
                        }
                        hVar.lYB.add(jVar);
                    }
                    return 0;
                case 7:
                    hVar.scene = aVar3.pMj.mH();
                    return 0;
                case 8:
                    hVar.lYx = aVar3.pMj.readString();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        am amVar = new am();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = amVar.a(aVar4, amVar, aqp.a(aVar4))) {
                        }
                        hVar.lYC = amVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
