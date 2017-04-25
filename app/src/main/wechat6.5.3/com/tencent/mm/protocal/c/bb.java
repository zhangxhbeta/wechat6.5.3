package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bb extends aqp {
    public int eOX;
    public LinkedList<aif> mbB = new LinkedList();
    public arf mbC;
    public int mbD;
    public String mbE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mbC == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.eOX);
            aVar.d(3, 8, this.mbB);
            if (this.mbC != null) {
                aVar.dX(4, this.mbC.aHr());
                this.mbC.a(aVar);
            }
            aVar.dV(5, this.mbD);
            if (this.mbE == null) {
                return 0;
            }
            aVar.e(6, this.mbE);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.eOX)) + a.a.a.a.c(3, 8, this.mbB);
            if (this.mbC != null) {
                r0 += a.a.a.a.dU(4, this.mbC.aHr());
            }
            r0 += a.a.a.a.dS(5, this.mbD);
            if (this.mbE != null) {
                r0 += a.a.a.b.b.a.f(6, this.mbE);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mbB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ChatRoomName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bb bbVar = (bb) objArr[1];
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
                        bbVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    bbVar.eOX = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aif com_tencent_mm_protocal_c_aif = new aif();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aif.a(aVar4, com_tencent_mm_protocal_c_aif, aqp.a(aVar4))) {
                        }
                        bbVar.mbB.add(com_tencent_mm_protocal_c_aif);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        bbVar.mbC = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    bbVar.mbD = aVar3.pMj.mH();
                    return 0;
                case 6:
                    bbVar.mbE = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
