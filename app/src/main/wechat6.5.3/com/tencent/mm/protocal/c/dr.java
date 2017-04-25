package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class dr extends a {
    public LinkedList<String> meA = new LinkedList();
    public int meB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.meA);
            aVar.dV(2, this.meB);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 1, this.meA) + 0) + a.a.a.a.dS(2, this.meB);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.meA.clear();
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
                dr drVar = (dr) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        drVar.meA.add(aVar3.pMj.readString());
                        return 0;
                    case 2:
                        drVar.meB = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
