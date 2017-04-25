package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ke extends aqx {
    public String mmD;
    public String mmE;
    public int mmL;
    public long mmM;

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
            aVar.dV(2, this.mmL);
            if (this.mmD != null) {
                aVar.e(3, this.mmD);
            }
            if (this.mmE != null) {
                aVar.e(4, this.mmE);
            }
            aVar.C(5, this.mmM);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mmL);
            if (this.mmD != null) {
                r0 += a.a.a.b.b.a.f(3, this.mmD);
            }
            if (this.mmE != null) {
                r0 += a.a.a.b.b.a.f(4, this.mmE);
            }
            return r0 + a.a.a.a.B(5, this.mmM);
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
            ke keVar = (ke) objArr[1];
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
                        keVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    keVar.mmL = aVar3.pMj.mH();
                    return 0;
                case 3:
                    keVar.mmD = aVar3.pMj.readString();
                    return 0;
                case 4:
                    keVar.mmE = aVar3.pMj.readString();
                    return 0;
                case 5:
                    keVar.mmM = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
