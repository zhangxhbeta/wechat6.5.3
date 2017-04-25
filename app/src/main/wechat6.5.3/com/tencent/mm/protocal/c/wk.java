package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class wk extends a {
    public abt mgb;
    public int myO;
    public int myP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mgb == null) {
                throw new b("Not all required fields were included: Device");
            }
            aVar.dV(1, this.myO);
            aVar.dV(2, this.myP);
            if (this.mgb != null) {
                aVar.dX(3, this.mgb.aHr());
                this.mgb.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.myO) + 0) + a.a.a.a.dS(2, this.myP);
            if (this.mgb != null) {
                return r0 + a.a.a.a.dU(3, this.mgb.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mgb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Device");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            wk wkVar = (wk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wkVar.myO = aVar3.pMj.mH();
                    return 0;
                case 2:
                    wkVar.myP = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        abt com_tencent_mm_protocal_c_abt = new abt();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_abt.a(aVar4, com_tencent_mm_protocal_c_abt, a.a(aVar4))) {
                        }
                        wkVar.mgb = com_tencent_mm_protocal_c_abt;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
