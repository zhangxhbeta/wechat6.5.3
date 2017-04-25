package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class rj extends a {
    public String aXz;
    public LinkedList<rd> mvg = new LinkedList();
    public LinkedList<rl> mvh = new LinkedList();
    public String mvi;
    public String mvj;
    public LinkedList<rk> mvk = new LinkedList();
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz != null) {
                aVar.e(1, this.aXz);
            }
            aVar.dV(2, this.type);
            aVar.d(3, 8, this.mvg);
            aVar.d(4, 8, this.mvh);
            if (this.mvi != null) {
                aVar.e(5, this.mvi);
            }
            if (this.mvj != null) {
                aVar.e(6, this.mvj);
            }
            aVar.d(7, 8, this.mvk);
            return 0;
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.dS(2, this.type)) + a.a.a.a.c(3, 8, this.mvg)) + a.a.a.a.c(4, 8, this.mvh);
            if (this.mvi != null) {
                r0 += a.a.a.b.b.a.f(5, this.mvi);
            }
            if (this.mvj != null) {
                r0 += a.a.a.b.b.a.f(6, this.mvj);
            }
            return r0 + a.a.a.a.c(7, 8, this.mvk);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mvg.clear();
            this.mvh.clear();
            this.mvk.clear();
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
            rj rjVar = (rj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rjVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    rjVar.type = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        rd rdVar = new rd();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rdVar.a(aVar4, rdVar, a.a(aVar4))) {
                        }
                        rjVar.mvg.add(rdVar);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        rl rlVar = new rl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rlVar.a(aVar4, rlVar, a.a(aVar4))) {
                        }
                        rjVar.mvh.add(rlVar);
                    }
                    return 0;
                case 5:
                    rjVar.mvi = aVar3.pMj.readString();
                    return 0;
                case 6:
                    rjVar.mvj = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        rk rkVar = new rk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rkVar.a(aVar4, rkVar, a.a(aVar4))) {
                        }
                        rjVar.mvk.add(rkVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
