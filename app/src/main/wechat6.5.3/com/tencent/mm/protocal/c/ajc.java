package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ajc extends a {
    public int mJA;
    public int mJB;
    public int mJm;
    public arf moM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.moM == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.moM != null) {
                aVar.dX(1, this.moM.aHr());
                this.moM.a(aVar);
            }
            aVar.dV(2, this.mJA);
            aVar.dV(3, this.mJB);
            aVar.dV(4, this.mJm);
            return 0;
        } else if (i == 1) {
            if (this.moM != null) {
                r0 = a.a.a.a.dU(1, this.moM.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.dS(2, this.mJA)) + a.a.a.a.dS(3, this.mJB)) + a.a.a.a.dS(4, this.mJm);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.moM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ajc com_tencent_mm_protocal_c_ajc = (ajc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_arf = new arf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajc.moM = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajc.mJA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajc.mJB = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajc.mJm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
