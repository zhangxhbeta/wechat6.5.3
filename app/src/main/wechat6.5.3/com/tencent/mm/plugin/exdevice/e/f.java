package com.tencent.mm.plugin.exdevice.e;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class f extends i {
    public b fvE;
    public b fvF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fvS != null) {
                aVar.dX(1, this.fvS.aHr());
                this.fvS.a(aVar);
            }
            if (this.fvE != null) {
                aVar.b(2, this.fvE);
            }
            if (this.fvF == null) {
                return 0;
            }
            aVar.b(3, this.fvF);
            return 0;
        } else if (i == 1) {
            if (this.fvS != null) {
                r0 = a.a.a.a.dU(1, this.fvS.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fvE != null) {
                r0 += a.a.a.a.a(2, this.fvE);
            }
            if (this.fvF != null) {
                r0 += a.a.a.a.a(3, this.fvF);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = i.a(aVar2); r0 > 0; r0 = i.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
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
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, i.a(aVar4))) {
                        }
                        fVar.fvS = dVar;
                    }
                    return 0;
                case 2:
                    fVar.fvE = aVar3.bQK();
                    return 0;
                case 3:
                    fVar.fvF = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
