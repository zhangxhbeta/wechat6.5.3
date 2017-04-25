package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class v extends aqx {
    public int hKq = 268513600;
    public String hKr = "请求不成功，请稍候再试";
    public LinkedList<k> lZg = new LinkedList();
    public String lZh;

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
            aVar.d(4, 8, this.lZg);
            if (this.lZh == null) {
                return 0;
            }
            aVar.e(5, this.lZh);
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
            r0 += a.a.a.a.c(4, 8, this.lZg);
            if (this.lZh != null) {
                r0 += a.a.a.b.b.a.f(5, this.lZh);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lZg.clear();
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
            v vVar = (v) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        vVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    vVar.hKq = aVar3.pMj.mH();
                    return 0;
                case 3:
                    vVar.hKr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        k kVar = new k();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, aqx.a(aVar4))) {
                        }
                        vVar.lZg.add(kVar);
                    }
                    return 0;
                case 5:
                    vVar.lZh = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
