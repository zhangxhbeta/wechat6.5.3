package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class hx extends a {
    public String efy;
    public String gkT;
    public hz miL;
    public asg miO;
    public ie miP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.efy == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.miO == null) {
                throw new b("Not all required fields were included: ContactItem");
            } else {
                if (this.efy != null) {
                    aVar.e(1, this.efy);
                }
                if (this.miL != null) {
                    aVar.dX(2, this.miL.aHr());
                    this.miL.a(aVar);
                }
                if (this.miO != null) {
                    aVar.dX(3, this.miO.aHr());
                    this.miO.a(aVar);
                }
                if (this.miP != null) {
                    aVar.dX(4, this.miP.aHr());
                    this.miP.a(aVar);
                }
                if (this.gkT == null) {
                    return 0;
                }
                aVar.e(5, this.gkT);
                return 0;
            }
        } else if (i == 1) {
            if (this.efy != null) {
                r0 = a.a.a.b.b.a.f(1, this.efy) + 0;
            } else {
                r0 = 0;
            }
            if (this.miL != null) {
                r0 += a.a.a.a.dU(2, this.miL.aHr());
            }
            if (this.miO != null) {
                r0 += a.a.a.a.dU(3, this.miO.aHr());
            }
            if (this.miP != null) {
                r0 += a.a.a.a.dU(4, this.miP.aHr());
            }
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkT);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.efy == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.miO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ContactItem");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hx hxVar = (hx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hxVar.efy = aVar3.pMj.readString();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        hz hzVar = new hz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hzVar.a(aVar4, hzVar, a.a(aVar4))) {
                        }
                        hxVar.miL = hzVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        asg com_tencent_mm_protocal_c_asg = new asg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_asg.a(aVar4, com_tencent_mm_protocal_c_asg, a.a(aVar4))) {
                        }
                        hxVar.miO = com_tencent_mm_protocal_c_asg;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ie ieVar = new ie();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ieVar.a(aVar4, ieVar, a.a(aVar4))) {
                        }
                        hxVar.miP = ieVar;
                    }
                    return 0;
                case 5:
                    hxVar.gkT = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
