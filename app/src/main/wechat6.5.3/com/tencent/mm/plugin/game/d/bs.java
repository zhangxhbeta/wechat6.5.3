package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bs extends a {
    public f gnO;
    public g gnP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gnO != null) {
                aVar.dX(1, this.gnO.aHr());
                this.gnO.a(aVar);
            }
            if (this.gnP == null) {
                return 0;
            }
            aVar.dX(2, this.gnP.aHr());
            this.gnP.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.gnO != null) {
                r0 = a.a.a.a.dU(1, this.gnO.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnP != null) {
                r0 += a.a.a.a.dU(2, this.gnP.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bs bsVar = (bs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        f fVar = new f();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        bsVar.gnO = fVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        g gVar = new g();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        bsVar.gnP = gVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
