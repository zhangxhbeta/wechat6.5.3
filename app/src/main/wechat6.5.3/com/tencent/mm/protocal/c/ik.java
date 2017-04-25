package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ik extends aqx {
    public String gom;
    public String gon;
    public int hNS;
    public long mcb;
    public String mjI;
    public String mjT;
    public String mjV;

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
            if (this.mjI != null) {
                aVar.e(3, this.mjI);
            }
            if (this.gon != null) {
                aVar.e(4, this.gon);
            }
            if (this.gom != null) {
                aVar.e(5, this.gom);
            }
            aVar.dV(9, this.hNS);
            aVar.C(10, this.mcb);
            if (this.mjT != null) {
                aVar.e(11, this.mjT);
            }
            if (this.mjV == null) {
                return 0;
            }
            aVar.e(12, this.mjV);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mjI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mjI);
            }
            if (this.gon != null) {
                r0 += a.a.a.b.b.a.f(4, this.gon);
            }
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(5, this.gom);
            }
            r0 = (r0 + a.a.a.a.dS(9, this.hNS)) + a.a.a.a.B(10, this.mcb);
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(11, this.mjT);
            }
            if (this.mjV != null) {
                r0 += a.a.a.b.b.a.f(12, this.mjV);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ik ikVar = (ik) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ikVar.mQl = eoVar;
                    }
                    return 0;
                case 3:
                    ikVar.mjI = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ikVar.gon = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ikVar.gom = aVar3.pMj.readString();
                    return 0;
                case 9:
                    ikVar.hNS = aVar3.pMj.mH();
                    return 0;
                case 10:
                    ikVar.mcb = aVar3.pMj.mI();
                    return 0;
                case 11:
                    ikVar.mjT = aVar3.pMj.readString();
                    return 0;
                case 12:
                    ikVar.mjV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
