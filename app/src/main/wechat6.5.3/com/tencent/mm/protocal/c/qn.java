package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class qn extends a {
    public LinkedList<String> mua = new LinkedList();
    public LinkedList<String> mub = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.mua);
            aVar.d(2, 1, this.mub);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 1, this.mua) + 0) + a.a.a.a.c(2, 1, this.mub);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.mua.clear();
                this.mub.clear();
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
                qn qnVar = (qn) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        qnVar.mua.add(aVar3.pMj.readString());
                        return 0;
                    case 2:
                        qnVar.mub.add(aVar3.pMj.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
