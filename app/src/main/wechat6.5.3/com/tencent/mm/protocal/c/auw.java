package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class auw extends a {
    public LinkedList<String> mSn = new LinkedList();
    public LinkedList<String> mSp = new LinkedList();
    public LinkedList<Integer> mSq = new LinkedList();
    public LinkedList<Integer> mSr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.mSn);
            aVar.d(2, 1, this.mSp);
            aVar.d(3, 2, this.mSq);
            aVar.d(4, 2, this.mSr);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.c(1, 1, this.mSn) + 0) + a.a.a.a.c(2, 1, this.mSp)) + a.a.a.a.c(3, 2, this.mSq)) + a.a.a.a.c(4, 2, this.mSr);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.mSn.clear();
                this.mSp.clear();
                this.mSq.clear();
                this.mSr.clear();
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
                auw com_tencent_mm_protocal_c_auw = (auw) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_auw.mSn.add(aVar3.pMj.readString());
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_auw.mSp.add(aVar3.pMj.readString());
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_auw.mSq.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_auw.mSr.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
