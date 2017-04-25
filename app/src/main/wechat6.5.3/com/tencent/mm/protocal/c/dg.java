package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class dg extends a {
    public String mdM;
    public oj mdN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdM == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.mdN == null) {
                throw new b("Not all required fields were included: Price");
            } else {
                if (this.mdM != null) {
                    aVar.e(1, this.mdM);
                }
                if (this.mdN == null) {
                    return 0;
                }
                aVar.dX(2, this.mdN.aHr());
                this.mdN.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mdM != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdM) + 0;
            } else {
                r0 = 0;
            }
            if (this.mdN != null) {
                r0 += a.a.a.a.dU(2, this.mdN.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdM == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.mdN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Price");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dg dgVar = (dg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dgVar.mdM = aVar3.pMj.readString();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        oj ojVar = new oj();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ojVar.a(aVar4, ojVar, a.a(aVar4))) {
                        }
                        dgVar.mdN = ojVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
