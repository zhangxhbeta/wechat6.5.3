package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class anu extends a {
    public int gGc;
    public LinkedList<aod> mOf = new LinkedList();
    public int mqS;
    public long mqT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mqS);
            aVar.C(2, this.mqT);
            aVar.d(3, 8, this.mOf);
            aVar.dV(4, this.gGc);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.dS(1, this.mqS) + 0) + a.a.a.a.B(2, this.mqT)) + a.a.a.a.c(3, 8, this.mOf)) + a.a.a.a.dS(4, this.gGc);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mOf.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                anu com_tencent_mm_protocal_c_anu = (anu) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_anu.mqS = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_anu.mqT = aVar3.pMj.mI();
                        return 0;
                    case 3:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            aod com_tencent_mm_protocal_c_aod = new aod();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_aod.a(aVar4, com_tencent_mm_protocal_c_aod, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_anu.mOf.add(com_tencent_mm_protocal_c_aod);
                        }
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_anu.gGc = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
