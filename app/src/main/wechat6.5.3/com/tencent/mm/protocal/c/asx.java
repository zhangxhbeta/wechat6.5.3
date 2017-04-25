package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class asx extends aqp {
    public String hQP;
    public String mRp;
    public int mRq;
    public LinkedList<arf> mRr = new LinkedList();
    public String mRs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mRp != null) {
                aVar.e(2, this.mRp);
            }
            aVar.dV(3, this.mRq);
            aVar.d(4, 8, this.mRr);
            if (this.mRs != null) {
                aVar.e(5, this.mRs);
            }
            if (this.hQP == null) {
                return 0;
            }
            aVar.e(6, this.hQP);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mRp != null) {
                r0 += a.a.a.b.b.a.f(2, this.mRp);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mRq)) + a.a.a.a.c(4, 8, this.mRr);
            if (this.mRs != null) {
                r0 += a.a.a.b.b.a.f(5, this.mRs);
            }
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(6, this.hQP);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mRr.clear();
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
            asx com_tencent_mm_protocal_c_asx = (asx) objArr[1];
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
                        com_tencent_mm_protocal_c_asx.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asx.mRp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asx.mRq = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_asx.mRr.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asx.mRs = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asx.hQP = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
