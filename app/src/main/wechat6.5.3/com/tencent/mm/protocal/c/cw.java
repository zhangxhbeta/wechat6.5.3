package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class cw extends a {
    public int mdl;
    public int mdm;
    public int mdt;
    public cx mdu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mdl);
            aVar.dV(2, this.mdm);
            aVar.dV(3, this.mdt);
            if (this.mdu != null) {
                aVar.dX(4, this.mdu.aHr());
                this.mdu.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mdl) + 0) + a.a.a.a.dS(2, this.mdm)) + a.a.a.a.dS(3, this.mdt);
            if (this.mdu != null) {
                return r0 + a.a.a.a.dU(4, this.mdu.aHr());
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
            cw cwVar = (cw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cwVar.mdl = aVar3.pMj.mH();
                    return 0;
                case 2:
                    cwVar.mdm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    cwVar.mdt = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a cxVar = new cx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxVar.a(aVar4, cxVar, a.a(aVar4))) {
                        }
                        cwVar.mdu = cxVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
