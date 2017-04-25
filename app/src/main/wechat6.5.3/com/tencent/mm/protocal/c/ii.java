package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ii extends a {
    public int mjG;
    public LinkedList<Integer> mjH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mjG);
            aVar.c(2, this.mjH);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.dS(1, this.mjG) + 0) + a.a.a.a.b(2, this.mjH);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.mjH.clear();
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
                ii iiVar = (ii) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iiVar.mjG = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        iiVar.mjH = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
