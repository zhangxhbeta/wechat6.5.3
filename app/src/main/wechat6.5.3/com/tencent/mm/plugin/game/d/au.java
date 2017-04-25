package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class au extends a {
    public cc gmR;
    public bf gmS;
    public m gmT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gmR != null) {
                aVar.dX(1, this.gmR.aHr());
                this.gmR.a(aVar);
            }
            if (this.gmS != null) {
                aVar.dX(2, this.gmS.aHr());
                this.gmS.a(aVar);
            }
            if (this.gmT == null) {
                return 0;
            }
            aVar.dX(3, this.gmT.aHr());
            this.gmT.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.gmR != null) {
                r0 = a.a.a.a.dU(1, this.gmR.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gmS != null) {
                r0 += a.a.a.a.dU(2, this.gmS.aHr());
            }
            if (this.gmT != null) {
                r0 += a.a.a.a.dU(3, this.gmT.aHr());
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
            au auVar = (au) objArr[1];
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
                        cc ccVar = new cc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccVar.a(aVar4, ccVar, a.a(aVar4))) {
                        }
                        auVar.gmR = ccVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bf bfVar = new bf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfVar.a(aVar4, bfVar, a.a(aVar4))) {
                        }
                        auVar.gmS = bfVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        m mVar = new m();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        auVar.gmT = mVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
