package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class api extends a {
    public int count;
    public int eWB;
    public LinkedList<apj> mOV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.count);
            aVar.d(2, 8, this.mOV);
            aVar.dV(3, this.eWB);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.count) + 0) + a.a.a.a.c(2, 8, this.mOV)) + a.a.a.a.dS(3, this.eWB);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mOV.clear();
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
                api com_tencent_mm_protocal_c_api = (api) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_api.count = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            apj com_tencent_mm_protocal_c_apj = new apj();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_apj.a(aVar4, com_tencent_mm_protocal_c_apj, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_api.mOV.add(com_tencent_mm_protocal_c_apj);
                        }
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_api.eWB = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
