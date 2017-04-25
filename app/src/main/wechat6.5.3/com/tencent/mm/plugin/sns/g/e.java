package com.tencent.mm.plugin.sns.g;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.protocal.c.avn;
import java.util.LinkedList;

public final class e extends a {
    public avn jjS;
    public String jqw;
    public int jqx;
    public String jqy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jqw == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.jjS == null) {
                throw new b("Not all required fields were included: actionGroup");
            } else {
                if (this.jqw != null) {
                    aVar.e(1, this.jqw);
                }
                if (this.jjS != null) {
                    aVar.dX(2, this.jjS.aHr());
                    this.jjS.a(aVar);
                }
                aVar.dV(3, this.jqx);
                if (this.jqy == null) {
                    return 0;
                }
                aVar.e(4, this.jqy);
                return 0;
            }
        } else if (i == 1) {
            if (this.jqw != null) {
                r0 = a.a.a.b.b.a.f(1, this.jqw) + 0;
            } else {
                r0 = 0;
            }
            if (this.jjS != null) {
                r0 += a.a.a.a.dU(2, this.jjS.aHr());
            }
            r0 += a.a.a.a.dS(3, this.jqx);
            if (this.jqy != null) {
                r0 += a.a.a.b.b.a.f(4, this.jqy);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.jqw == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.jjS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: actionGroup");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.jqw = aVar3.pMj.readString();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        avn com_tencent_mm_protocal_c_avn = new avn();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avn.a(aVar4, com_tencent_mm_protocal_c_avn, a.a(aVar4))) {
                        }
                        eVar.jjS = com_tencent_mm_protocal_c_avn;
                    }
                    return 0;
                case 3:
                    eVar.jqx = aVar3.pMj.mH();
                    return 0;
                case 4:
                    eVar.jqy = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
