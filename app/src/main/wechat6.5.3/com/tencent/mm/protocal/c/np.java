package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class np extends aqp {
    public int mbT;
    public String mcN;
    public long mcb;
    public int mfb;
    public int mff;
    public String moN;
    public long mpv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.dV(1, this.mbT);
            aVar.dV(2, this.mfb);
            aVar.dV(3, this.mff);
            if (this.mcN != null) {
                aVar.e(4, this.mcN);
            }
            if (this.mPU != null) {
                aVar.dX(5, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.C(6, this.mcb);
            if (this.moN != null) {
                aVar.e(7, this.moN);
            }
            aVar.C(8, this.mpv);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mbT) + 0) + a.a.a.a.dS(2, this.mfb)) + a.a.a.a.dS(3, this.mff);
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mcN);
            }
            if (this.mPU != null) {
                r0 += a.a.a.a.dU(5, this.mPU.aHr());
            }
            r0 += a.a.a.a.B(6, this.mcb);
            if (this.moN != null) {
                r0 += a.a.a.b.b.a.f(7, this.moN);
            }
            return r0 + a.a.a.a.B(8, this.mpv);
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
            np npVar = (np) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    npVar.mbT = aVar3.pMj.mH();
                    return 0;
                case 2:
                    npVar.mfb = aVar3.pMj.mH();
                    return 0;
                case 3:
                    npVar.mff = aVar3.pMj.mH();
                    return 0;
                case 4:
                    npVar.mcN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        npVar.mPU = enVar;
                    }
                    return 0;
                case 6:
                    npVar.mcb = aVar3.pMj.mI();
                    return 0;
                case 7:
                    npVar.moN = aVar3.pMj.readString();
                    return 0;
                case 8:
                    npVar.mpv = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
