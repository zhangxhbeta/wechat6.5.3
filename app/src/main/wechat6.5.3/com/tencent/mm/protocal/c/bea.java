package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bea extends a {
    public are mXM;
    public int mZJ;
    public int mfh;
    public String mne;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mXM == null) {
                throw new b("Not all required fields were included: Text");
            }
            if (this.mXM != null) {
                aVar.dX(1, this.mXM.aHr());
                this.mXM.a(aVar);
            }
            if (this.mne != null) {
                aVar.e(2, this.mne);
            }
            aVar.dV(3, this.mfh);
            aVar.dV(4, this.mZJ);
            return 0;
        } else if (i == 1) {
            if (this.mXM != null) {
                r0 = a.a.a.a.dU(1, this.mXM.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mne != null) {
                r0 += a.a.a.b.b.a.f(2, this.mne);
            }
            return (r0 + a.a.a.a.dS(3, this.mfh)) + a.a.a.a.dS(4, this.mZJ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mXM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Text");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bea com_tencent_mm_protocal_c_bea = (bea) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bea.mXM = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bea.mne = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bea.mfh = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bea.mZJ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
