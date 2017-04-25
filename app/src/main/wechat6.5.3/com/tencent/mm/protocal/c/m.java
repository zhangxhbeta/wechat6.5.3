package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class m extends aqx {
    public int hKq = 268513600;
    public String hKr = "请求不成功，请稍候再试";
    public String hbX;
    public String irN;
    public int lYH;
    public int lYI;
    public int lYJ;
    public long lYK;
    public long lYL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.hKq);
            if (this.hKr != null) {
                aVar.e(3, this.hKr);
            }
            aVar.dV(4, this.lYH);
            aVar.dV(5, this.lYI);
            aVar.dV(6, this.lYJ);
            aVar.C(7, this.lYK);
            aVar.C(8, this.lYL);
            if (this.hbX != null) {
                aVar.e(9, this.hbX);
            }
            if (this.irN == null) {
                return 0;
            }
            aVar.e(10, this.irN);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.hKq);
            if (this.hKr != null) {
                r0 += a.a.a.b.b.a.f(3, this.hKr);
            }
            r0 = ((((r0 + a.a.a.a.dS(4, this.lYH)) + a.a.a.a.dS(5, this.lYI)) + a.a.a.a.dS(6, this.lYJ)) + a.a.a.a.B(7, this.lYK)) + a.a.a.a.B(8, this.lYL);
            if (this.hbX != null) {
                r0 += a.a.a.b.b.a.f(9, this.hbX);
            }
            if (this.irN != null) {
                r0 += a.a.a.b.b.a.f(10, this.irN);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        mVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    mVar.hKq = aVar3.pMj.mH();
                    return 0;
                case 3:
                    mVar.hKr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    mVar.lYH = aVar3.pMj.mH();
                    return 0;
                case 5:
                    mVar.lYI = aVar3.pMj.mH();
                    return 0;
                case 6:
                    mVar.lYJ = aVar3.pMj.mH();
                    return 0;
                case 7:
                    mVar.lYK = aVar3.pMj.mI();
                    return 0;
                case 8:
                    mVar.lYL = aVar3.pMj.mI();
                    return 0;
                case 9:
                    mVar.hbX = aVar3.pMj.readString();
                    return 0;
                case 10:
                    mVar.irN = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
