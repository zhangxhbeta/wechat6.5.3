package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class gm extends a {
    public LinkedList<bjg> mhh = new LinkedList();
    public LinkedList<bjg> mhi = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mhh);
            aVar.d(2, 8, this.mhi);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 8, this.mhh) + 0) + a.a.a.a.c(2, 8, this.mhi);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mhh.clear();
                this.mhi.clear();
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
                gm gmVar = (gm) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList zQ;
                int size;
                a com_tencent_mm_protocal_c_bjg;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_bjg = new bjg();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_bjg.a(aVar4, com_tencent_mm_protocal_c_bjg, a.a(aVar4))) {
                            }
                            gmVar.mhh.add(com_tencent_mm_protocal_c_bjg);
                        }
                        return 0;
                    case 2:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_bjg = new bjg();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_bjg.a(aVar4, com_tencent_mm_protocal_c_bjg, a.a(aVar4))) {
                            }
                            gmVar.mhi.add(com_tencent_mm_protocal_c_bjg);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
