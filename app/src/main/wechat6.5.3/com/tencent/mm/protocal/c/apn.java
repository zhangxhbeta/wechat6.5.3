package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class apn extends aqx {
    public int id;
    public api mOR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mOR == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                aVar.dV(1, this.id);
                if (this.mOR != null) {
                    aVar.dX(2, this.mOR.aHr());
                    this.mOR.a(aVar);
                }
                if (this.mQl != null) {
                    aVar.dX(3, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.id) + 0;
            if (this.mOR != null) {
                r0 += a.a.a.a.dU(2, this.mOR.aHr());
            }
            if (this.mQl != null) {
                return r0 + a.a.a.a.dU(3, this.mQl.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mOR == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.mQl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            apn com_tencent_mm_protocal_c_apn = (apn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_apn.id = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        api com_tencent_mm_protocal_c_api = new api();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_api.a(aVar4, com_tencent_mm_protocal_c_api, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apn.mOR = com_tencent_mm_protocal_c_api;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apn.mQl = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
