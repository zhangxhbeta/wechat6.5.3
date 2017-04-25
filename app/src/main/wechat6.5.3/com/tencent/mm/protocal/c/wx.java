package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class wx extends aqx {
    public String muA;
    public String muB;
    public int muC;
    public String muD;
    public int muz;
    public String mzd;
    public String mze;

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
            if (this.mzd != null) {
                aVar.e(2, this.mzd);
            }
            aVar.dV(3, this.muz);
            if (this.muA != null) {
                aVar.e(4, this.muA);
            }
            if (this.muB != null) {
                aVar.e(5, this.muB);
            }
            aVar.dV(6, this.muC);
            if (this.muD != null) {
                aVar.e(7, this.muD);
            }
            if (this.mze == null) {
                return 0;
            }
            aVar.e(8, this.mze);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mzd != null) {
                r0 += a.a.a.b.b.a.f(2, this.mzd);
            }
            r0 += a.a.a.a.dS(3, this.muz);
            if (this.muA != null) {
                r0 += a.a.a.b.b.a.f(4, this.muA);
            }
            if (this.muB != null) {
                r0 += a.a.a.b.b.a.f(5, this.muB);
            }
            r0 += a.a.a.a.dS(6, this.muC);
            if (this.muD != null) {
                r0 += a.a.a.b.b.a.f(7, this.muD);
            }
            if (this.mze != null) {
                r0 += a.a.a.b.b.a.f(8, this.mze);
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
            wx wxVar = (wx) objArr[1];
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
                        wxVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    wxVar.mzd = aVar3.pMj.readString();
                    return 0;
                case 3:
                    wxVar.muz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    wxVar.muA = aVar3.pMj.readString();
                    return 0;
                case 5:
                    wxVar.muB = aVar3.pMj.readString();
                    return 0;
                case 6:
                    wxVar.muC = aVar3.pMj.mH();
                    return 0;
                case 7:
                    wxVar.muD = aVar3.pMj.readString();
                    return 0;
                case 8:
                    wxVar.mze = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
