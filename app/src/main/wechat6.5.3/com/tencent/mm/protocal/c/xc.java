package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class xc extends aqp {
    public int Height;
    public int Width;
    public String fvz;
    public float mjM;
    public float mjN;
    public int mzv;
    public int mzw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.j(2, this.mjM);
            aVar.j(3, this.mjN);
            aVar.dV(4, this.Width);
            aVar.dV(5, this.Height);
            if (this.fvz != null) {
                aVar.e(6, this.fvz);
            }
            aVar.dV(7, this.mzv);
            aVar.dV(8, this.mzw);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + (a.a.a.b.b.a.cw(2) + 4)) + (a.a.a.b.b.a.cw(3) + 4)) + a.a.a.a.dS(4, this.Width)) + a.a.a.a.dS(5, this.Height);
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(6, this.fvz);
            }
            return (r0 + a.a.a.a.dS(7, this.mzv)) + a.a.a.a.dS(8, this.mzw);
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
            xc xcVar = (xc) objArr[1];
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
                        xcVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    xcVar.mjM = aVar3.pMj.readFloat();
                    return 0;
                case 3:
                    xcVar.mjN = aVar3.pMj.readFloat();
                    return 0;
                case 4:
                    xcVar.Width = aVar3.pMj.mH();
                    return 0;
                case 5:
                    xcVar.Height = aVar3.pMj.mH();
                    return 0;
                case 6:
                    xcVar.fvz = aVar3.pMj.readString();
                    return 0;
                case 7:
                    xcVar.mzv = aVar3.pMj.mH();
                    return 0;
                case 8:
                    xcVar.mzw = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
