package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class wu extends aqp {
    public String mjX;
    public String mjc;
    public bt myZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.myZ == null) {
                throw new b("Not all required fields were included: Address");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mjc != null) {
                aVar.e(2, this.mjc);
            }
            if (this.mjX != null) {
                aVar.e(3, this.mjX);
            }
            if (this.myZ == null) {
                return 0;
            }
            aVar.dX(4, this.myZ.aHr());
            this.myZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mjc != null) {
                r0 += a.a.a.b.b.a.f(2, this.mjc);
            }
            if (this.mjX != null) {
                r0 += a.a.a.b.b.a.f(3, this.mjX);
            }
            if (this.myZ != null) {
                r0 += a.a.a.a.dU(4, this.myZ.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.myZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Address");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            wu wuVar = (wu) objArr[1];
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
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        wuVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    wuVar.mjc = aVar3.pMj.readString();
                    return 0;
                case 3:
                    wuVar.mjX = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bt btVar = new bt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btVar.a(aVar4, btVar, aqp.a(aVar4))) {
                        }
                        wuVar.myZ = btVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
