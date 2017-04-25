package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ayi extends a {
    public int mVP;
    public int mVQ;
    public LinkedList<akd> mVR = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mVP);
            aVar.dV(2, this.mVQ);
            aVar.d(3, 8, this.mVR);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.mVP) + 0) + a.a.a.a.dS(2, this.mVQ)) + a.a.a.a.c(3, 8, this.mVR);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mVR.clear();
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
                ayi com_tencent_mm_protocal_c_ayi = (ayi) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_ayi.mVP = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_ayi.mVQ = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            a com_tencent_mm_protocal_c_akd = new akd();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_akd.a(aVar4, com_tencent_mm_protocal_c_akd, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_ayi.mVR.add(com_tencent_mm_protocal_c_akd);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
