package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class jq extends aqp {
    public String cUd;
    public String gom;
    public String gon;
    public int mdC;
    public String mjT;
    public long mmc;
    public String mmd;
    public String mme;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.gon != null) {
                aVar.e(2, this.gon);
            }
            if (this.gom != null) {
                aVar.e(3, this.gom);
            }
            aVar.C(4, this.mmc);
            if (this.mjT != null) {
                aVar.e(5, this.mjT);
            }
            if (this.mmd != null) {
                aVar.e(6, this.mmd);
            }
            aVar.dV(7, this.mdC);
            if (this.mme != null) {
                aVar.e(8, this.mme);
            }
            if (this.cUd == null) {
                return 0;
            }
            aVar.e(9, this.cUd);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gon != null) {
                r0 += a.a.a.b.b.a.f(2, this.gon);
            }
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(3, this.gom);
            }
            r0 += a.a.a.a.B(4, this.mmc);
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(5, this.mjT);
            }
            if (this.mmd != null) {
                r0 += a.a.a.b.b.a.f(6, this.mmd);
            }
            r0 += a.a.a.a.dS(7, this.mdC);
            if (this.mme != null) {
                r0 += a.a.a.b.b.a.f(8, this.mme);
            }
            if (this.cUd != null) {
                r0 += a.a.a.b.b.a.f(9, this.cUd);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            jq jqVar = (jq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        jqVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    jqVar.gon = aVar3.pMj.readString();
                    return 0;
                case 3:
                    jqVar.gom = aVar3.pMj.readString();
                    return 0;
                case 4:
                    jqVar.mmc = aVar3.pMj.mI();
                    return 0;
                case 5:
                    jqVar.mjT = aVar3.pMj.readString();
                    return 0;
                case 6:
                    jqVar.mmd = aVar3.pMj.readString();
                    return 0;
                case 7:
                    jqVar.mdC = aVar3.pMj.mH();
                    return 0;
                case 8:
                    jqVar.mme = aVar3.pMj.readString();
                    return 0;
                case 9:
                    jqVar.cUd = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
