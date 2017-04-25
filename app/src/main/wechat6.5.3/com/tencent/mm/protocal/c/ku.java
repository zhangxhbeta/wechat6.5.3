package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class ku extends a {
    public int mnl;
    public int mnm;
    public int mnn;
    public LinkedList<kt> mno = new LinkedList();
    public b mnp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mnl);
            aVar.dV(2, this.mnm);
            aVar.dV(3, this.mnn);
            aVar.d(4, 8, this.mno);
            if (this.mnp != null) {
                aVar.b(5, this.mnp);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.dS(1, this.mnl) + 0) + a.a.a.a.dS(2, this.mnm)) + a.a.a.a.dS(3, this.mnn)) + a.a.a.a.c(4, 8, this.mno);
            if (this.mnp != null) {
                return r0 + a.a.a.a.a(5, this.mnp);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mno.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            ku kuVar = (ku) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    kuVar.mnl = aVar3.pMj.mH();
                    return 0;
                case 2:
                    kuVar.mnm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    kuVar.mnn = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a ktVar = new kt();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kuVar.mno.add(ktVar);
                    }
                    return 0;
                case 5:
                    kuVar.mnp = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
