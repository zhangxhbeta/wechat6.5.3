package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class my extends aqp {
    public String bkC;
    public int ncj;
    public String ncl;
    public String ncm;
    public String pRA;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.bkC != null) {
                aVar.e(2, this.bkC);
            }
            aVar.dV(3, this.ncj);
            if (this.ncl != null) {
                aVar.e(99, this.ncl);
            }
            if (this.ncm != null) {
                aVar.e(100, this.ncm);
            }
            if (this.pRA == null) {
                return 0;
            }
            aVar.e(101, this.pRA);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.bkC != null) {
                r0 += a.a.a.b.b.a.f(2, this.bkC);
            }
            r0 += a.a.a.a.dS(3, this.ncj);
            if (this.ncl != null) {
                r0 += a.a.a.b.b.a.f(99, this.ncl);
            }
            if (this.ncm != null) {
                r0 += a.a.a.b.b.a.f(100, this.ncm);
            }
            if (this.pRA != null) {
                r0 += a.a.a.b.b.a.f(101, this.pRA);
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
            my myVar = (my) objArr[1];
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
                        myVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    myVar.bkC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    myVar.ncj = aVar3.pMj.mH();
                    return 0;
                case 99:
                    myVar.ncl = aVar3.pMj.readString();
                    return 0;
                case 100:
                    myVar.ncm = aVar3.pMj.readString();
                    return 0;
                case 101:
                    myVar.pRA = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
