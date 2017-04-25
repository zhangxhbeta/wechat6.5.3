package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class cv extends aqx {
    public b mdk;
    public int mdp;
    public int mdq;
    public da mdr;
    public cw mds;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.mdp);
            aVar.dV(3, this.mdq);
            if (this.mdk != null) {
                aVar.b(4, this.mdk);
            }
            if (this.mdr != null) {
                aVar.dX(5, this.mdr.aHr());
                this.mdr.a(aVar);
            }
            if (this.mds == null) {
                return 0;
            }
            aVar.dX(6, this.mds.aHr());
            this.mds.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mdp)) + a.a.a.a.dS(3, this.mdq);
            if (this.mdk != null) {
                r0 += a.a.a.a.a(4, this.mdk);
            }
            if (this.mdr != null) {
                r0 += a.a.a.a.dU(5, this.mdr.aHr());
            }
            if (this.mds != null) {
                r0 += a.a.a.a.dU(6, this.mds.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            cv cvVar = (cv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        cvVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    cvVar.mdp = aVar3.pMj.mH();
                    return 0;
                case 3:
                    cvVar.mdq = aVar3.pMj.mH();
                    return 0;
                case 4:
                    cvVar.mdk = aVar3.bQK();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new da();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        cvVar.mdr = eoVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new cw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        cvVar.mds = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
