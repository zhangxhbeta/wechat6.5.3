package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bjf extends a {
    public int mht;
    public LinkedList<jf> moH = new LinkedList();
    public int ndI;
    public String ndJ;
    public String ndK;
    public int ndL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mht);
            aVar.dV(2, this.ndI);
            if (this.ndJ != null) {
                aVar.e(3, this.ndJ);
            }
            if (this.ndK != null) {
                aVar.e(4, this.ndK);
            }
            aVar.dV(5, this.ndL);
            aVar.d(6, 8, this.moH);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.mht) + 0) + a.a.a.a.dS(2, this.ndI);
            if (this.ndJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.ndJ);
            }
            if (this.ndK != null) {
                r0 += a.a.a.b.b.a.f(4, this.ndK);
            }
            return (r0 + a.a.a.a.dS(5, this.ndL)) + a.a.a.a.c(6, 8, this.moH);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.moH.clear();
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
            bjf com_tencent_mm_protocal_c_bjf = (bjf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bjf.mht = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjf.ndI = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjf.ndJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjf.ndK = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjf.ndL = aVar3.pMj.mH();
                    return 0;
                case 6:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a jfVar = new jf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = jfVar.a(aVar4, jfVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjf.moH.add(jfVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
