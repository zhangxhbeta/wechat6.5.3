package com.tencent.mm.al;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class f extends a {
    public LinkedList<d> cUj = new LinkedList();
    public double cUk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.cUj);
            aVar.a(2, this.cUk);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 8, this.cUj) + 0) + (a.a.a.b.b.a.cw(2) + 8);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.cUj.clear();
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
                f fVar = (f) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            a dVar = new d();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                            }
                            fVar.cUj.add(dVar);
                        }
                        return 0;
                    case 2:
                        fVar.cUk = aVar3.pMj.readDouble();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
