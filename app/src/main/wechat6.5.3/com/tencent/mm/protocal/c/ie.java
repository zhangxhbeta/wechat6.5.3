package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class ie extends a {
    public b mjn;
    public b mjo;
    public LinkedList<atj> mjp = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mjn == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.mjo == null) {
                throw new a.a.a.b("Not all required fields were included: ServiceUrl");
            } else {
                if (this.mjn != null) {
                    aVar.b(1, this.mjn);
                }
                if (this.mjo != null) {
                    aVar.b(2, this.mjo);
                }
                aVar.d(3, 8, this.mjp);
                return 0;
            }
        } else if (i == 1) {
            if (this.mjn != null) {
                r0 = a.a.a.a.a(1, this.mjn) + 0;
            } else {
                r0 = 0;
            }
            if (this.mjo != null) {
                r0 += a.a.a.a.a(2, this.mjo);
            }
            return r0 + a.a.a.a.c(3, 8, this.mjp);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mjp.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mjn == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.mjo != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: ServiceUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ie ieVar = (ie) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ieVar.mjn = aVar3.bQK();
                    return 0;
                case 2:
                    ieVar.mjo = aVar3.bQK();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        atj com_tencent_mm_protocal_c_atj = new atj();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_atj.a(aVar4, com_tencent_mm_protocal_c_atj, a.a(aVar4))) {
                        }
                        ieVar.mjp.add(com_tencent_mm_protocal_c_atj);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
