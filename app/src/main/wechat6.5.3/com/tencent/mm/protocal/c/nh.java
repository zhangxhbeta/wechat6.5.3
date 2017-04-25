package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class nh extends a {
    public int mpg;
    public ni mph;
    public int mpi;
    public ni mpj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mph == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.mpj == null) {
                throw new b("Not all required fields were included: AllDayTime");
            } else {
                aVar.dV(1, this.mpg);
                if (this.mph != null) {
                    aVar.dX(2, this.mph.aHr());
                    this.mph.a(aVar);
                }
                aVar.dV(3, this.mpi);
                if (this.mpj != null) {
                    aVar.dX(4, this.mpj.aHr());
                    this.mpj.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mpg) + 0;
            if (this.mph != null) {
                r0 += a.a.a.a.dU(2, this.mph.aHr());
            }
            r0 += a.a.a.a.dS(3, this.mpi);
            if (this.mpj != null) {
                return r0 + a.a.a.a.dU(4, this.mpj.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mph == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.mpj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AllDayTime");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            nh nhVar = (nh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a niVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    nhVar.mpg = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        niVar = new ni();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = niVar.a(aVar4, niVar, a.a(aVar4))) {
                        }
                        nhVar.mph = niVar;
                    }
                    return 0;
                case 3:
                    nhVar.mpi = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        niVar = new ni();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = niVar.a(aVar4, niVar, a.a(aVar4))) {
                        }
                        nhVar.mpj = niVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
