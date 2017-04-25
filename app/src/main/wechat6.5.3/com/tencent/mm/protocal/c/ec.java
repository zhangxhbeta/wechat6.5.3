package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ec extends aqx {
    public int eeQ;
    public int eet;
    public LinkedList<arf> eeu = new LinkedList();
    public int efm;
    public String meZ;
    public int mfa;
    public int mfh;
    public int mfl;

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
            if (this.meZ != null) {
                aVar.e(2, this.meZ);
            }
            aVar.dV(3, this.eet);
            aVar.d(4, 8, this.eeu);
            aVar.dV(5, this.mfa);
            aVar.dV(6, this.mfl);
            aVar.dV(7, this.efm);
            aVar.dV(8, this.mfh);
            aVar.dV(9, this.eeQ);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.meZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.meZ);
            }
            return ((((((r0 + a.a.a.a.dS(3, this.eet)) + a.a.a.a.c(4, 8, this.eeu)) + a.a.a.a.dS(5, this.mfa)) + a.a.a.a.dS(6, this.mfl)) + a.a.a.a.dS(7, this.efm)) + a.a.a.a.dS(8, this.mfh)) + a.a.a.a.dS(9, this.eeQ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.eeu.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
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
            ec ecVar = (ec) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ecVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    ecVar.meZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ecVar.eet = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ecVar.eeu.add(eoVar);
                    }
                    return 0;
                case 5:
                    ecVar.mfa = aVar3.pMj.mH();
                    return 0;
                case 6:
                    ecVar.mfl = aVar3.pMj.mH();
                    return 0;
                case 7:
                    ecVar.efm = aVar3.pMj.mH();
                    return 0;
                case 8:
                    ecVar.mfh = aVar3.pMj.mH();
                    return 0;
                case 9:
                    ecVar.eeQ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
