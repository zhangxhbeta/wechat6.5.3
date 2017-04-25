package com.tencent.mm.plugin.exdevice.e;

import a.a.a.c.a;
import java.util.LinkedList;

public final class b extends j {
    public com.tencent.mm.ba.b fvA;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fvT == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            } else if (this.fvA == null) {
                throw new a.a.a.b("Not all required fields were included: AesSessionKey");
            } else {
                if (this.fvT != null) {
                    aVar.dX(1, this.fvT.aHr());
                    this.fvT.a(aVar);
                }
                if (this.fvA == null) {
                    return 0;
                }
                aVar.b(2, this.fvA);
                return 0;
            }
        } else if (i == 1) {
            if (this.fvT != null) {
                r0 = a.a.a.a.dU(1, this.fvT.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fvA != null) {
                r0 += a.a.a.a.a(2, this.fvA);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = j.a(aVar2); r0 > 0; r0 = j.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.fvT == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            } else if (this.fvA != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: AesSessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        e eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, j.a(aVar4))) {
                        }
                        bVar.fvT = eVar;
                    }
                    return 0;
                case 2:
                    bVar.fvA = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
