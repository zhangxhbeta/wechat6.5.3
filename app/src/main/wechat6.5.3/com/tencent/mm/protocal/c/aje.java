package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aje extends a {
    public ams mJo;
    public String mJq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mJq == null) {
                throw new b("Not all required fields were included: ContactUsername");
            } else if (this.mJo == null) {
                throw new b("Not all required fields were included: PhoneNumListInfo");
            } else {
                if (this.mJq != null) {
                    aVar.e(1, this.mJq);
                }
                if (this.mJo == null) {
                    return 0;
                }
                aVar.dX(2, this.mJo.aHr());
                this.mJo.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mJq != null) {
                r0 = a.a.a.b.b.a.f(1, this.mJq) + 0;
            } else {
                r0 = 0;
            }
            if (this.mJo != null) {
                r0 += a.a.a.a.dU(2, this.mJo.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mJq == null) {
                throw new b("Not all required fields were included: ContactUsername");
            } else if (this.mJo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: PhoneNumListInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aje com_tencent_mm_protocal_c_aje = (aje) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aje.mJq = aVar3.pMj.readString();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_ams = new ams();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_ams.a(aVar4, com_tencent_mm_protocal_c_ams, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aje.mJo = com_tencent_mm_protocal_c_ams;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
