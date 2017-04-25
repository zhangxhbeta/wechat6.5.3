package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ajb extends a {
    public int mJz;
    public abt mgm;
    public abu mgn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mgm == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.mgn == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.mgm != null) {
                    aVar.dX(1, this.mgm.aHr());
                    this.mgm.a(aVar);
                }
                if (this.mgn != null) {
                    aVar.dX(2, this.mgn.aHr());
                    this.mgn.a(aVar);
                }
                aVar.dV(3, this.mJz);
                return 0;
            }
        } else if (i == 1) {
            if (this.mgm != null) {
                r0 = a.a.a.a.dU(1, this.mgm.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mgn != null) {
                r0 += a.a.a.a.dU(2, this.mgn.aHr());
            }
            return r0 + a.a.a.a.dS(3, this.mJz);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mgm == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.mgn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HardDeviceAttr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ajb com_tencent_mm_protocal_c_ajb = (ajb) objArr[1];
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
                        abt com_tencent_mm_protocal_c_abt = new abt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_abt.a(aVar4, com_tencent_mm_protocal_c_abt, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajb.mgm = com_tencent_mm_protocal_c_abt;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        abu com_tencent_mm_protocal_c_abu = new abu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_abu.a(aVar4, com_tencent_mm_protocal_c_abu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajb.mgn = com_tencent_mm_protocal_c_abu;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajb.mJz = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
