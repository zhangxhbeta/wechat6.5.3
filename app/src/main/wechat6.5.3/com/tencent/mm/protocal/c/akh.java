package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class akh extends a {
    public int aXy;
    public b jen;
    public int mLj;
    public LinkedList<Integer> mLk = new LinkedList();
    public int mLl;
    public b mLm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.aXy);
            aVar.dV(2, this.mLj);
            aVar.d(3, 2, this.mLk);
            aVar.dV(4, this.mLl);
            if (this.jen != null) {
                aVar.b(5, this.jen);
            }
            if (this.mLm != null) {
                aVar.b(6, this.mLm);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.dS(1, this.aXy) + 0) + a.a.a.a.dS(2, this.mLj)) + a.a.a.a.c(3, 2, this.mLk)) + a.a.a.a.dS(4, this.mLl);
            if (this.jen != null) {
                r0 += a.a.a.a.a(5, this.jen);
            }
            if (this.mLm != null) {
                return r0 + a.a.a.a.a(6, this.mLm);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.mLk.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            akh com_tencent_mm_protocal_c_akh = (akh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akh.aXy = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akh.mLj = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akh.mLk.add(Integer.valueOf(aVar3.pMj.mH()));
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akh.mLl = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akh.jen = aVar3.bQK();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akh.mLm = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
