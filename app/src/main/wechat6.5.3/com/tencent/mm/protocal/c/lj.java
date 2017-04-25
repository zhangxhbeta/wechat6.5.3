package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class lj extends aqp {
    public String glj;
    public String meq;
    public String mnR;
    public String mnS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mnR == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.meq == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.mnS == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.glj == null) {
                throw new b("Not all required fields were included: AppId");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mnR != null) {
                    aVar.e(2, this.mnR);
                }
                if (this.meq != null) {
                    aVar.e(3, this.meq);
                }
                if (this.mnS != null) {
                    aVar.e(4, this.mnS);
                }
                if (this.glj == null) {
                    return 0;
                }
                aVar.e(5, this.glj);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mnR != null) {
                r0 += a.a.a.b.b.a.f(2, this.mnR);
            }
            if (this.meq != null) {
                r0 += a.a.a.b.b.a.f(3, this.meq);
            }
            if (this.mnS != null) {
                r0 += a.a.a.b.b.a.f(4, this.mnS);
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(5, this.glj);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mnR == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.meq == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.mnS == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.glj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            lj ljVar = (lj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        ljVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    ljVar.mnR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ljVar.meq = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ljVar.mnS = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ljVar.glj = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
