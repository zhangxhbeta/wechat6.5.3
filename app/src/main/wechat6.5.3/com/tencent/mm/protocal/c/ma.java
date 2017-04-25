package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ma extends aqp {
    public int eet;
    public String gkB;
    public String moE;
    public String moF;
    public afu moG;
    public LinkedList<arf> moH = new LinkedList();
    public String moI;
    public String moJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.moG == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.gkB != null) {
                aVar.e(2, this.gkB);
            }
            if (this.moE != null) {
                aVar.e(3, this.moE);
            }
            if (this.moF != null) {
                aVar.e(4, this.moF);
            }
            if (this.moG != null) {
                aVar.dX(5, this.moG.aHr());
                this.moG.a(aVar);
            }
            aVar.dV(6, this.eet);
            aVar.d(7, 8, this.moH);
            if (this.moI != null) {
                aVar.e(8, this.moI);
            }
            if (this.moJ == null) {
                return 0;
            }
            aVar.e(9, this.moJ);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            if (this.moE != null) {
                r0 += a.a.a.b.b.a.f(3, this.moE);
            }
            if (this.moF != null) {
                r0 += a.a.a.b.b.a.f(4, this.moF);
            }
            if (this.moG != null) {
                r0 += a.a.a.a.dU(5, this.moG.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(6, this.eet)) + a.a.a.a.c(7, 8, this.moH);
            if (this.moI != null) {
                r0 += a.a.a.b.b.a.f(8, this.moI);
            }
            if (this.moJ != null) {
                r0 += a.a.a.b.b.a.f(9, this.moJ);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.moH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.moG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ma maVar = (ma) objArr[1];
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
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        maVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    maVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    maVar.moE = aVar3.pMj.readString();
                    return 0;
                case 4:
                    maVar.moF = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        afu com_tencent_mm_protocal_c_afu = new afu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afu.a(aVar4, com_tencent_mm_protocal_c_afu, aqp.a(aVar4))) {
                        }
                        maVar.moG = com_tencent_mm_protocal_c_afu;
                    }
                    return 0;
                case 6:
                    maVar.eet = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        maVar.moH.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 8:
                    maVar.moI = aVar3.pMj.readString();
                    return 0;
                case 9:
                    maVar.moJ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
