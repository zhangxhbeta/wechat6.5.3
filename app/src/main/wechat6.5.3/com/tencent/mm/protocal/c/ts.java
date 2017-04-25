package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ts extends a implements avb {
    public int mcj;
    public int mwM;
    public int mwN;
    public int mwO;
    public LinkedList<arf> mwP = new LinkedList();

    public final int getRet() {
        return this.mcj;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            aVar.dV(2, this.mwM);
            aVar.dV(3, this.mwN);
            aVar.dV(4, this.mwO);
            aVar.d(5, 8, this.mwP);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.dS(1, this.mcj) + 0) + a.a.a.a.dS(2, this.mwM)) + a.a.a.a.dS(3, this.mwN)) + a.a.a.a.dS(4, this.mwO)) + a.a.a.a.c(5, 8, this.mwP);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mwP.clear();
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
                ts tsVar = (ts) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        tsVar.mcj = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        tsVar.mwM = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        tsVar.mwN = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        tsVar.mwO = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            arf com_tencent_mm_protocal_c_arf = new arf();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                            }
                            tsVar.mwP.add(com_tencent_mm_protocal_c_arf);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
