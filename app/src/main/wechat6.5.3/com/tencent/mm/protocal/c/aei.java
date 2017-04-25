package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aei extends aqp {
    public String glb;
    public String glj;
    public LinkedList<String> mEH = new LinkedList();
    public int mEJ;
    public int mEK;
    public String mEL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            aVar.d(3, 1, this.mEH);
            aVar.dV(4, this.mEK);
            if (this.glb != null) {
                aVar.e(5, this.glb);
            }
            if (this.mEL != null) {
                aVar.e(6, this.mEL);
            }
            aVar.dV(7, this.mEJ);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            r0 = (r0 + a.a.a.a.c(3, 1, this.mEH)) + a.a.a.a.dS(4, this.mEK);
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(5, this.glb);
            }
            if (this.mEL != null) {
                r0 += a.a.a.b.b.a.f(6, this.mEL);
            }
            return r0 + a.a.a.a.dS(7, this.mEJ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mEH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aei com_tencent_mm_protocal_c_aei = (aei) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aei.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aei.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aei.mEH.add(aVar3.pMj.readString());
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aei.mEK = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aei.glb = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aei.mEL = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aei.mEJ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
