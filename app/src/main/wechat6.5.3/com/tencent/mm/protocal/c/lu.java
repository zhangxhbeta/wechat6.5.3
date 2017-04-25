package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class lu extends aqx {
    public String kLC;
    public LinkedList<it> mov = new LinkedList();
    public int mow;
    public int mox;
    public int version;

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
            aVar.d(2, 8, this.mov);
            aVar.dV(3, this.version);
            aVar.dV(4, this.mow);
            aVar.dV(5, this.mox);
            if (this.kLC == null) {
                return 0;
            }
            aVar.e(6, this.kLC);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.c(2, 8, this.mov)) + a.a.a.a.dS(3, this.version)) + a.a.a.a.dS(4, this.mow)) + a.a.a.a.dS(5, this.mox);
            if (this.kLC != null) {
                r0 += a.a.a.b.b.a.f(6, this.kLC);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mov.clear();
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
            lu luVar = (lu) objArr[1];
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
                        luVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        it itVar = new it();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = itVar.a(aVar4, itVar, aqx.a(aVar4))) {
                        }
                        luVar.mov.add(itVar);
                    }
                    return 0;
                case 3:
                    luVar.version = aVar3.pMj.mH();
                    return 0;
                case 4:
                    luVar.mow = aVar3.pMj.mH();
                    return 0;
                case 5:
                    luVar.mox = aVar3.pMj.mH();
                    return 0;
                case 6:
                    luVar.kLC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
