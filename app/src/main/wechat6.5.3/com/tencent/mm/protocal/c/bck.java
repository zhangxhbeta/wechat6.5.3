package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bck extends a {
    public int lZm;
    public LinkedList<String> mYg = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lZm);
            aVar.d(2, 1, this.mYg);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.dS(1, this.lZm) + 0) + a.a.a.a.c(2, 1, this.mYg);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.mYg.clear();
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
                bck com_tencent_mm_protocal_c_bck = (bck) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bck.lZm = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bck.mYg.add(aVar3.pMj.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
