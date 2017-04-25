package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aft extends a {
    public String aXz;
    public int efm;
    public String hHb;
    public float mFC;
    public int mFD;
    public LinkedList<Integer> mFE = new LinkedList();
    public int mFF;
    public LinkedList<arf> mFG = new LinkedList();
    public float mFH;
    public String mFI;
    public are mFJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hHb != null) {
                aVar.e(1, this.hHb);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            aVar.j(3, this.mFC);
            aVar.dV(4, this.mFD);
            aVar.c(5, this.mFE);
            aVar.dV(6, this.mFF);
            aVar.d(7, 8, this.mFG);
            aVar.j(8, this.mFH);
            if (this.mFI != null) {
                aVar.e(9, this.mFI);
            }
            aVar.dV(10, this.efm);
            if (this.mFJ == null) {
                return 0;
            }
            aVar.dX(11, this.mFJ.aHr());
            this.mFJ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.hHb != null) {
                r0 = a.a.a.b.b.a.f(1, this.hHb) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            r0 = (((((r0 + (a.a.a.b.b.a.cw(3) + 4)) + a.a.a.a.dS(4, this.mFD)) + a.a.a.a.b(5, this.mFE)) + a.a.a.a.dS(6, this.mFF)) + a.a.a.a.c(7, 8, this.mFG)) + (a.a.a.b.b.a.cw(8) + 4);
            if (this.mFI != null) {
                r0 += a.a.a.b.b.a.f(9, this.mFI);
            }
            r0 += a.a.a.a.dS(10, this.efm);
            if (this.mFJ != null) {
                r0 += a.a.a.a.dU(11, this.mFJ.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mFE.clear();
            this.mFG.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aft com_tencent_mm_protocal_c_aft = (aft) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aft.hHb = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aft.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aft.mFC = aVar3.pMj.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aft.mFD = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aft.mFE = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aft.mFF = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aft.mFG.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aft.mFH = aVar3.pMj.readFloat();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aft.mFI = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aft.efm = aVar3.pMj.mH();
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aft.mFJ = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
