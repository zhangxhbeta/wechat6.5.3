package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class lr extends aqp {
    public String mop;
    public String moq;
    public String mor;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mop == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.moq == null) {
                throw new b("Not all required fields were included: qychat_type");
            } else if (this.mor == null) {
                throw new b("Not all required fields were included: qychat_id");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mop != null) {
                    aVar.e(2, this.mop);
                }
                if (this.moq != null) {
                    aVar.e(3, this.moq);
                }
                if (this.mor == null) {
                    return 0;
                }
                aVar.e(4, this.mor);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mop != null) {
                r0 += a.a.a.b.b.a.f(2, this.mop);
            }
            if (this.moq != null) {
                r0 += a.a.a.b.b.a.f(3, this.moq);
            }
            if (this.mor != null) {
                r0 += a.a.a.b.b.a.f(4, this.mor);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mop == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.moq == null) {
                throw new b("Not all required fields were included: qychat_type");
            } else if (this.mor != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: qychat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            lr lrVar = (lr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        lrVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    lrVar.mop = aVar3.pMj.readString();
                    return 0;
                case 3:
                    lrVar.moq = aVar3.pMj.readString();
                    return 0;
                case 4:
                    lrVar.mor = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
