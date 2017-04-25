package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bgq extends a {
    public LinkedList<bgr> mws = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).d(1, 8, this.mws);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.c(1, 8, this.mws) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mws.clear();
                a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                bgq com_tencent_mm_protocal_c_bgq = (bgq) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList zQ = aVar2.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            bgr com_tencent_mm_protocal_c_bgr = new bgr();
                            a.a.a.a.a aVar3 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bgr.a(aVar3, com_tencent_mm_protocal_c_bgr, a.a(aVar3))) {
                            }
                            com_tencent_mm_protocal_c_bgq.mws.add(com_tencent_mm_protocal_c_bgr);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
