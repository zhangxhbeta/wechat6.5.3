package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class kd extends aqp {
    public String mmD;
    public String mmE;
    public String mmF;
    public String mmG;
    public String mmH;
    public long mmI;
    public String mmJ;
    public String mmK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mmD != null) {
                aVar.e(2, this.mmD);
            }
            if (this.mmE != null) {
                aVar.e(3, this.mmE);
            }
            if (this.mmF != null) {
                aVar.e(4, this.mmF);
            }
            if (this.mmG != null) {
                aVar.e(5, this.mmG);
            }
            if (this.mmH != null) {
                aVar.e(6, this.mmH);
            }
            aVar.C(7, this.mmI);
            if (this.mmJ != null) {
                aVar.e(8, this.mmJ);
            }
            if (this.mmK == null) {
                return 0;
            }
            aVar.e(9, this.mmK);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mmD != null) {
                r0 += a.a.a.b.b.a.f(2, this.mmD);
            }
            if (this.mmE != null) {
                r0 += a.a.a.b.b.a.f(3, this.mmE);
            }
            if (this.mmF != null) {
                r0 += a.a.a.b.b.a.f(4, this.mmF);
            }
            if (this.mmG != null) {
                r0 += a.a.a.b.b.a.f(5, this.mmG);
            }
            if (this.mmH != null) {
                r0 += a.a.a.b.b.a.f(6, this.mmH);
            }
            r0 += a.a.a.a.B(7, this.mmI);
            if (this.mmJ != null) {
                r0 += a.a.a.b.b.a.f(8, this.mmJ);
            }
            if (this.mmK != null) {
                r0 += a.a.a.b.b.a.f(9, this.mmK);
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
            kd kdVar = (kd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        kdVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    kdVar.mmD = aVar3.pMj.readString();
                    return 0;
                case 3:
                    kdVar.mmE = aVar3.pMj.readString();
                    return 0;
                case 4:
                    kdVar.mmF = aVar3.pMj.readString();
                    return 0;
                case 5:
                    kdVar.mmG = aVar3.pMj.readString();
                    return 0;
                case 6:
                    kdVar.mmH = aVar3.pMj.readString();
                    return 0;
                case 7:
                    kdVar.mmI = aVar3.pMj.mI();
                    return 0;
                case 8:
                    kdVar.mmJ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    kdVar.mmK = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
