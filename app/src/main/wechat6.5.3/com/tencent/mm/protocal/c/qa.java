package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class qa extends a {
    public LinkedList<aix> fMd = new LinkedList();
    public LinkedList<aja> mtE = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.fMd);
            aVar.d(2, 8, this.mtE);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 8, this.fMd) + 0) + a.a.a.a.c(2, 8, this.mtE);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.fMd.clear();
                this.mtE.clear();
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
                qa qaVar = (qa) objArr[1];
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
                            bArr = (byte[]) zQ.get(intValue);
                            aix com_tencent_mm_protocal_c_aix = new aix();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_aix.a(aVar4, com_tencent_mm_protocal_c_aix, a.a(aVar4))) {
                            }
                            qaVar.fMd.add(com_tencent_mm_protocal_c_aix);
                        }
                        return 0;
                    case 2:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            aja com_tencent_mm_protocal_c_aja = new aja();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_aja.a(aVar4, com_tencent_mm_protocal_c_aja, a.a(aVar4))) {
                            }
                            qaVar.mtE.add(com_tencent_mm_protocal_c_aja);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
