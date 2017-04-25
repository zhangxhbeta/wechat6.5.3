package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class avd extends a {
    public int hOe;
    public LinkedList<apv> mSA = new LinkedList();
    public int mSB;
    public LinkedList<ank> mSy = new LinkedList();
    public pc mSz;
    public String mjX;
    public bt myZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.hOe);
            aVar.d(2, 8, this.mSy);
            if (this.mSz != null) {
                aVar.dX(3, this.mSz.aHr());
                this.mSz.a(aVar);
            }
            if (this.myZ != null) {
                aVar.dX(4, this.myZ.aHr());
                this.myZ.a(aVar);
            }
            aVar.d(5, 8, this.mSA);
            aVar.dV(6, this.mSB);
            if (this.mjX != null) {
                aVar.e(7, this.mjX);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.hOe) + 0) + a.a.a.a.c(2, 8, this.mSy);
            if (this.mSz != null) {
                r0 += a.a.a.a.dU(3, this.mSz.aHr());
            }
            if (this.myZ != null) {
                r0 += a.a.a.a.dU(4, this.myZ.aHr());
            }
            r0 = (r0 + a.a.a.a.c(5, 8, this.mSA)) + a.a.a.a.dS(6, this.mSB);
            if (this.mjX != null) {
                return r0 + a.a.a.b.b.a.f(7, this.mjX);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mSy.clear();
            this.mSA.clear();
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
            avd com_tencent_mm_protocal_c_avd = (avd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_avd.hOe = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ank com_tencent_mm_protocal_c_ank = new ank();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ank.a(aVar4, com_tencent_mm_protocal_c_ank, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avd.mSy.add(com_tencent_mm_protocal_c_ank);
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        pc pcVar = new pc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = pcVar.a(aVar4, pcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avd.mSz = pcVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bt btVar = new bt();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = btVar.a(aVar4, btVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avd.myZ = btVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        apv com_tencent_mm_protocal_c_apv = new apv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_apv.a(aVar4, com_tencent_mm_protocal_c_apv, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avd.mSA.add(com_tencent_mm_protocal_c_apv);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avd.mSB = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avd.mjX = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
