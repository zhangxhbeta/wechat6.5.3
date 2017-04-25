package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ev extends a {
    public LinkedList<String> meA = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).d(1, 1, this.meA);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.c(1, 1, this.meA) + 0;
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.meA.clear();
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
                ev evVar = (ev) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        evVar.meA.add(aVar2.pMj.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
