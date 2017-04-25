package com.tencent.mm.protocal.a.a;

public final class a extends com.tencent.mm.ba.a {
    public int count;
    public int lXC;
    public int value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lXC);
            aVar.dV(2, this.value);
            aVar.dV(3, this.count);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.lXC) + 0) + a.a.a.a.dS(2, this.value)) + a.a.a.a.dS(3, this.count);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = com.tencent.mm.ba.a.a(aVar2); a > 0; a = com.tencent.mm.ba.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aVar4.lXC = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        aVar4.value = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        aVar4.count = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
