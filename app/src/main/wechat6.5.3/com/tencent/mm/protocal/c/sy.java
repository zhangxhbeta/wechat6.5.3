package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class sy extends aqx {
    public int hKq;
    public String hKr;
    public LinkedList<String> mwu = new LinkedList();
    public String mwv;

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
            aVar.d(2, 1, this.mwu);
            aVar.dV(3, this.hKq);
            if (this.hKr != null) {
                aVar.e(4, this.hKr);
            }
            if (this.mwv == null) {
                return 0;
            }
            aVar.e(5, this.mwv);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.c(2, 1, this.mwu)) + a.a.a.a.dS(3, this.hKq);
            if (this.hKr != null) {
                r0 += a.a.a.b.b.a.f(4, this.hKr);
            }
            if (this.mwv != null) {
                r0 += a.a.a.b.b.a.f(5, this.mwv);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mwu.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            sy syVar = (sy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        syVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    syVar.mwu.add(aVar3.pMj.readString());
                    return 0;
                case 3:
                    syVar.hKq = aVar3.pMj.mH();
                    return 0;
                case 4:
                    syVar.hKr = aVar3.pMj.readString();
                    return 0;
                case 5:
                    syVar.mwv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
