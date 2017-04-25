package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class awq extends a {
    public int jhn;
    public int jho;
    public int jhp;
    public int mTY;
    public LinkedList<avx> mTZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mTY);
            aVar.d(2, 8, this.mTZ);
            aVar.dV(3, this.jhn);
            aVar.dV(4, this.jho);
            aVar.dV(5, this.jhp);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.dS(1, this.mTY) + 0) + a.a.a.a.c(2, 8, this.mTZ)) + a.a.a.a.dS(3, this.jhn)) + a.a.a.a.dS(4, this.jho)) + a.a.a.a.dS(5, this.jhp);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mTZ.clear();
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
                awq com_tencent_mm_protocal_c_awq = (awq) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_awq.mTY = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            a com_tencent_mm_protocal_c_avx = new avx();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_awq.mTZ.add(com_tencent_mm_protocal_c_avx);
                        }
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_awq.jhn = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_awq.jho = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_awq.jhp = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
