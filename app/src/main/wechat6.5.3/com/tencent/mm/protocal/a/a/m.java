package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class m extends a {
    public int lYi;
    public int lYj;
    public LinkedList<n> lYk = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lYi);
            aVar.dV(2, this.lYj);
            aVar.d(3, 8, this.lYk);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.lYi) + 0) + a.a.a.a.dS(2, this.lYj)) + a.a.a.a.c(3, 8, this.lYk);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.lYk.clear();
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
                m mVar = (m) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        mVar.lYi = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        mVar.lYj = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            a nVar = new n();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                            }
                            mVar.lYk.add(nVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
