package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class on extends a {
    public oo mqP;
    public om mqQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mqP == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.mqQ == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.mqP != null) {
                    aVar.dX(1, this.mqP.aHr());
                    this.mqP.a(aVar);
                }
                if (this.mqQ == null) {
                    return 0;
                }
                aVar.dX(2, this.mqQ.aHr());
                this.mqQ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mqP != null) {
                r0 = a.a.a.a.dU(1, this.mqP.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mqQ != null) {
                r0 += a.a.a.a.dU(2, this.mqQ.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mqP == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.mqQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            on onVar = (on) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a ooVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ooVar = new oo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ooVar.a(aVar4, ooVar, a.a(aVar4))) {
                        }
                        onVar.mqP = ooVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ooVar = new om();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ooVar.a(aVar4, ooVar, a.a(aVar4))) {
                        }
                        onVar.mqQ = ooVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
