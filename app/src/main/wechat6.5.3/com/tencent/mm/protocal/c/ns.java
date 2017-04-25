package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ns extends aqp {
    public String fvz;
    public int meB;
    public String mep;
    public are mgD;
    public String mgI;
    public String mgi;
    public int mpA;
    public String mpy;
    public String mpz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mgD == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mgD != null) {
                aVar.dX(2, this.mgD.aHr());
                this.mgD.a(aVar);
            }
            aVar.dV(3, this.meB);
            if (this.mgi != null) {
                aVar.e(4, this.mgi);
            }
            if (this.fvz != null) {
                aVar.e(5, this.fvz);
            }
            if (this.mgI != null) {
                aVar.e(6, this.mgI);
            }
            if (this.mpy != null) {
                aVar.e(7, this.mpy);
            }
            if (this.mep != null) {
                aVar.e(8, this.mep);
            }
            if (this.mpz != null) {
                aVar.e(9, this.mpz);
            }
            aVar.dV(10, this.mpA);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mgD != null) {
                r0 += a.a.a.a.dU(2, this.mgD.aHr());
            }
            r0 += a.a.a.a.dS(3, this.meB);
            if (this.mgi != null) {
                r0 += a.a.a.b.b.a.f(4, this.mgi);
            }
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(5, this.fvz);
            }
            if (this.mgI != null) {
                r0 += a.a.a.b.b.a.f(6, this.mgI);
            }
            if (this.mpy != null) {
                r0 += a.a.a.b.b.a.f(7, this.mpy);
            }
            if (this.mep != null) {
                r0 += a.a.a.b.b.a.f(8, this.mep);
            }
            if (this.mpz != null) {
                r0 += a.a.a.b.b.a.f(9, this.mpz);
            }
            return r0 + a.a.a.a.dS(10, this.mpA);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mgD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ns nsVar = (ns) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        nsVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        nsVar.mgD = enVar;
                    }
                    return 0;
                case 3:
                    nsVar.meB = aVar3.pMj.mH();
                    return 0;
                case 4:
                    nsVar.mgi = aVar3.pMj.readString();
                    return 0;
                case 5:
                    nsVar.fvz = aVar3.pMj.readString();
                    return 0;
                case 6:
                    nsVar.mgI = aVar3.pMj.readString();
                    return 0;
                case 7:
                    nsVar.mpy = aVar3.pMj.readString();
                    return 0;
                case 8:
                    nsVar.mep = aVar3.pMj.readString();
                    return 0;
                case 9:
                    nsVar.mpz = aVar3.pMj.readString();
                    return 0;
                case 10:
                    nsVar.mpA = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
