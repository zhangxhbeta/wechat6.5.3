package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bhv extends a {
    public LinkedList<Integer> ncI = new LinkedList();
    public boolean ncJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 2, this.ncI);
            aVar.ab(2, this.ncJ);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 2, this.ncI) + 0) + (a.a.a.b.b.a.cw(2) + 1);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.ncI.clear();
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
                bhv com_tencent_mm_protocal_c_bhv = (bhv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bhv.ncI.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bhv.ncJ = aVar3.bQJ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
