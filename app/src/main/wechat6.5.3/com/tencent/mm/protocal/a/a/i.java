package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class i extends a {
    public int lXF;
    public int lXT;
    public int lXV;
    public LinkedList<e> lXW = new LinkedList();
    public b lXX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lXF);
            aVar.dV(2, this.lXV);
            aVar.dV(3, this.lXT);
            aVar.d(4, 8, this.lXW);
            if (this.lXX != null) {
                aVar.b(5, this.lXX);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.dS(1, this.lXF) + 0) + a.a.a.a.dS(2, this.lXV)) + a.a.a.a.dS(3, this.lXT)) + a.a.a.a.c(4, 8, this.lXW);
            if (this.lXX != null) {
                return r0 + a.a.a.a.a(5, this.lXX);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lXW.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.lXF = aVar3.pMj.mH();
                    return 0;
                case 2:
                    iVar.lXV = aVar3.pMj.mH();
                    return 0;
                case 3:
                    iVar.lXT = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        iVar.lXW.add(eVar);
                    }
                    return 0;
                case 5:
                    iVar.lXX = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
