package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class uv extends aqx {
    public int eeO;
    public int mxA;
    public int mxv;
    public int mxw;
    public int mxx;
    public int mxy;
    public String mxz;

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
            aVar.dV(2, this.eeO);
            aVar.dV(3, this.mxv);
            aVar.dV(4, this.mxw);
            aVar.dV(5, this.mxx);
            aVar.dV(6, this.mxy);
            if (this.mxz != null) {
                aVar.e(7, this.mxz);
            }
            aVar.dV(8, this.mxA);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.dS(2, this.eeO)) + a.a.a.a.dS(3, this.mxv)) + a.a.a.a.dS(4, this.mxw)) + a.a.a.a.dS(5, this.mxx)) + a.a.a.a.dS(6, this.mxy);
            if (this.mxz != null) {
                r0 += a.a.a.b.b.a.f(7, this.mxz);
            }
            return r0 + a.a.a.a.dS(8, this.mxA);
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
            uv uvVar = (uv) objArr[1];
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
                        uvVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    uvVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 3:
                    uvVar.mxv = aVar3.pMj.mH();
                    return 0;
                case 4:
                    uvVar.mxw = aVar3.pMj.mH();
                    return 0;
                case 5:
                    uvVar.mxx = aVar3.pMj.mH();
                    return 0;
                case 6:
                    uvVar.mxy = aVar3.pMj.mH();
                    return 0;
                case 7:
                    uvVar.mxz = aVar3.pMj.readString();
                    return 0;
                case 8:
                    uvVar.mxA = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
