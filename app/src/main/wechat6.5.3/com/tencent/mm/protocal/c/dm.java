package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class dm extends aqp {
    public String cHf;
    public String eeA;
    public String fvy;
    public String fvz;
    public are mdV;
    public em mel;
    public String mem;
    public String men;
    public int meo;
    public String mep;
    public String meq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mdV == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mel != null) {
                aVar.dX(2, this.mel.aHr());
                this.mel.a(aVar);
            }
            if (this.mdV != null) {
                aVar.dX(3, this.mdV.aHr());
                this.mdV.a(aVar);
            }
            if (this.mem != null) {
                aVar.e(4, this.mem);
            }
            if (this.men != null) {
                aVar.e(5, this.men);
            }
            aVar.dV(6, this.meo);
            if (this.mep != null) {
                aVar.e(7, this.mep);
            }
            if (this.cHf != null) {
                aVar.e(8, this.cHf);
            }
            if (this.eeA != null) {
                aVar.e(9, this.eeA);
            }
            if (this.meq != null) {
                aVar.e(10, this.meq);
            }
            if (this.fvz != null) {
                aVar.e(11, this.fvz);
            }
            if (this.fvy == null) {
                return 0;
            }
            aVar.e(12, this.fvy);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mel != null) {
                r0 += a.a.a.a.dU(2, this.mel.aHr());
            }
            if (this.mdV != null) {
                r0 += a.a.a.a.dU(3, this.mdV.aHr());
            }
            if (this.mem != null) {
                r0 += a.a.a.b.b.a.f(4, this.mem);
            }
            if (this.men != null) {
                r0 += a.a.a.b.b.a.f(5, this.men);
            }
            r0 += a.a.a.a.dS(6, this.meo);
            if (this.mep != null) {
                r0 += a.a.a.b.b.a.f(7, this.mep);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(8, this.cHf);
            }
            if (this.eeA != null) {
                r0 += a.a.a.b.b.a.f(9, this.eeA);
            }
            if (this.meq != null) {
                r0 += a.a.a.b.b.a.f(10, this.meq);
            }
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(11, this.fvz);
            }
            if (this.fvy != null) {
                r0 += a.a.a.b.b.a.f(12, this.fvy);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AutoAuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dm dmVar = (dm) objArr[1];
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
                        dmVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        dmVar.mel = enVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        dmVar.mdV = enVar;
                    }
                    return 0;
                case 4:
                    dmVar.mem = aVar3.pMj.readString();
                    return 0;
                case 5:
                    dmVar.men = aVar3.pMj.readString();
                    return 0;
                case 6:
                    dmVar.meo = aVar3.pMj.mH();
                    return 0;
                case 7:
                    dmVar.mep = aVar3.pMj.readString();
                    return 0;
                case 8:
                    dmVar.cHf = aVar3.pMj.readString();
                    return 0;
                case 9:
                    dmVar.eeA = aVar3.pMj.readString();
                    return 0;
                case 10:
                    dmVar.meq = aVar3.pMj.readString();
                    return 0;
                case 11:
                    dmVar.fvz = aVar3.pMj.readString();
                    return 0;
                case 12:
                    dmVar.fvy = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
