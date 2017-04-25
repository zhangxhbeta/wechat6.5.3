package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class gy extends a {
    public hb mhM;
    public String mhN;
    public String mhO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhM != null) {
                aVar.dX(1, this.mhM.aHr());
                this.mhM.a(aVar);
            }
            if (this.mhN != null) {
                aVar.e(2, this.mhN);
            }
            if (this.mhO == null) {
                return 0;
            }
            aVar.e(3, this.mhO);
            return 0;
        } else if (i == 1) {
            if (this.mhM != null) {
                r0 = a.a.a.a.dU(1, this.mhM.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mhN != null) {
                r0 += a.a.a.b.b.a.f(2, this.mhN);
            }
            if (this.mhO != null) {
                r0 += a.a.a.b.b.a.f(3, this.mhO);
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
            gy gyVar = (gy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a hbVar = new hb();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hbVar.a(aVar4, hbVar, a.a(aVar4))) {
                        }
                        gyVar.mhM = hbVar;
                    }
                    return 0;
                case 2:
                    gyVar.mhN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    gyVar.mhO = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
