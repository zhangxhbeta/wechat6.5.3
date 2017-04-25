package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class do extends a {
    public dp met;
    public dm meu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.met == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.meu == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.met != null) {
                    aVar.dX(1, this.met.aHr());
                    this.met.a(aVar);
                }
                if (this.meu == null) {
                    return 0;
                }
                aVar.dX(2, this.meu.aHr());
                this.meu.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.met != null) {
                r0 = a.a.a.a.dU(1, this.met.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.meu != null) {
                r0 += a.a.a.a.dU(2, this.meu.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.met == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.meu != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            do doVar = (do) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a dpVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        dpVar = new dp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dpVar.a(aVar4, dpVar, a.a(aVar4))) {
                        }
                        doVar.met = dpVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        dpVar = new dm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dpVar.a(aVar4, dpVar, a.a(aVar4))) {
                        }
                        doVar.meu = dpVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
