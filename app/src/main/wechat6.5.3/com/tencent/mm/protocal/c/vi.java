package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class vi extends a {
    public int lZm;
    public int mpG;
    public int mxS;
    public are mxT;
    public String mxU;
    public int mxV;
    public long mxW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lZm);
            aVar.dV(2, this.mxS);
            if (this.mxT != null) {
                aVar.dX(3, this.mxT.aHr());
                this.mxT.a(aVar);
            }
            aVar.dV(4, this.mpG);
            if (this.mxU != null) {
                aVar.e(5, this.mxU);
            }
            aVar.dV(6, this.mxV);
            aVar.C(7, this.mxW);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.lZm) + 0) + a.a.a.a.dS(2, this.mxS);
            if (this.mxT != null) {
                r0 += a.a.a.a.dU(3, this.mxT.aHr());
            }
            r0 += a.a.a.a.dS(4, this.mpG);
            if (this.mxU != null) {
                r0 += a.a.a.b.b.a.f(5, this.mxU);
            }
            return (r0 + a.a.a.a.dS(6, this.mxV)) + a.a.a.a.B(7, this.mxW);
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
            vi viVar = (vi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    viVar.lZm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    viVar.mxS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        viVar.mxT = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    viVar.mpG = aVar3.pMj.mH();
                    return 0;
                case 5:
                    viVar.mxU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    viVar.mxV = aVar3.pMj.mH();
                    return 0;
                case 7:
                    viVar.mxW = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
