package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class li extends a {
    public String mnP;
    public LinkedList<Integer> mnQ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mnP != null) {
                aVar.e(1, this.mnP);
            }
            aVar.d(2, 2, this.mnQ);
            return 0;
        } else if (i == 1) {
            if (this.mnP != null) {
                r0 = a.a.a.b.b.a.f(1, this.mnP) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 2, this.mnQ);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.mnQ.clear();
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
            li liVar = (li) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    liVar.mnP = aVar3.pMj.readString();
                    return 0;
                case 2:
                    liVar.mnQ.add(Integer.valueOf(aVar3.pMj.mH()));
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
