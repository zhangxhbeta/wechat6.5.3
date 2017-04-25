package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class pu extends a {
    public long mrF;
    public long mrG;
    public LinkedList<azs> mrH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.mrF);
            aVar.C(2, this.mrG);
            aVar.d(3, 8, this.mrH);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.B(1, this.mrF) + 0) + a.a.a.a.B(2, this.mrG)) + a.a.a.a.c(3, 8, this.mrH);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mrH.clear();
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
                pu puVar = (pu) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        puVar.mrF = aVar3.pMj.mI();
                        return 0;
                    case 2:
                        puVar.mrG = aVar3.pMj.mI();
                        return 0;
                    case 3:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            azs com_tencent_mm_protocal_c_azs = new azs();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_azs.a(aVar4, com_tencent_mm_protocal_c_azs, a.a(aVar4))) {
                            }
                            puVar.mrH.add(com_tencent_mm_protocal_c_azs);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
