package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bcv extends a {
    public LinkedList<azb> mYD = new LinkedList();
    public LinkedList<azb> mYE = new LinkedList();
    public LinkedList<ld> mYF = new LinkedList();
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.d(2, 8, this.mYD);
            aVar.d(3, 8, this.mYE);
            aVar.d(4, 8, this.mYF);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.c(2, 8, this.mYD)) + a.a.a.a.c(3, 8, this.mYE)) + a.a.a.a.c(4, 8, this.mYF);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mYD.clear();
            this.mYE.clear();
            this.mYF.clear();
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
            bcv com_tencent_mm_protocal_c_bcv = (bcv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            azb com_tencent_mm_protocal_c_azb;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bcv.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_azb = new azb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_azb.a(aVar4, com_tencent_mm_protocal_c_azb, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcv.mYD.add(com_tencent_mm_protocal_c_azb);
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_azb = new azb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_azb.a(aVar4, com_tencent_mm_protocal_c_azb, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcv.mYE.add(com_tencent_mm_protocal_c_azb);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ld ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcv.mYF.add(ldVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
