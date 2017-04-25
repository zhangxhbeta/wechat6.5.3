package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class rn extends aqp {
    public int itQ;
    public String mio;
    public String mip;
    public String miq;
    public String mir;
    public String mis;
    public String mit;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mio != null) {
                aVar.e(2, this.mio);
            }
            if (this.mip != null) {
                aVar.e(3, this.mip);
            }
            if (this.miq != null) {
                aVar.e(4, this.miq);
            }
            if (this.mir != null) {
                aVar.e(5, this.mir);
            }
            if (this.mis != null) {
                aVar.e(6, this.mis);
            }
            aVar.dV(7, this.itQ);
            if (this.mit == null) {
                return 0;
            }
            aVar.e(8, this.mit);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mio != null) {
                r0 += a.a.a.b.b.a.f(2, this.mio);
            }
            if (this.mip != null) {
                r0 += a.a.a.b.b.a.f(3, this.mip);
            }
            if (this.miq != null) {
                r0 += a.a.a.b.b.a.f(4, this.miq);
            }
            if (this.mir != null) {
                r0 += a.a.a.b.b.a.f(5, this.mir);
            }
            if (this.mis != null) {
                r0 += a.a.a.b.b.a.f(6, this.mis);
            }
            r0 += a.a.a.a.dS(7, this.itQ);
            if (this.mit != null) {
                r0 += a.a.a.b.b.a.f(8, this.mit);
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
            rn rnVar = (rn) objArr[1];
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
                        rnVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    rnVar.mio = aVar3.pMj.readString();
                    return 0;
                case 3:
                    rnVar.mip = aVar3.pMj.readString();
                    return 0;
                case 4:
                    rnVar.miq = aVar3.pMj.readString();
                    return 0;
                case 5:
                    rnVar.mir = aVar3.pMj.readString();
                    return 0;
                case 6:
                    rnVar.mis = aVar3.pMj.readString();
                    return 0;
                case 7:
                    rnVar.itQ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    rnVar.mit = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
