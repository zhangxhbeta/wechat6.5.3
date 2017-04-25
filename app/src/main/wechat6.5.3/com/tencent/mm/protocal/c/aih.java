package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aih extends a {
    public int efm;
    public int hNS;
    public String hQP;
    public int mIR;
    public arf mbV;
    public String mbZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            if (this.mbV != null) {
                aVar.dX(1, this.mbV.aHr());
                this.mbV.a(aVar);
            }
            if (this.hQP != null) {
                aVar.e(2, this.hQP);
            }
            aVar.dV(3, this.efm);
            aVar.dV(4, this.hNS);
            aVar.dV(5, this.mIR);
            if (this.mbZ == null) {
                return 0;
            }
            aVar.e(6, this.mbZ);
            return 0;
        } else if (i == 1) {
            if (this.mbV != null) {
                r0 = a.a.a.a.dU(1, this.mbV.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(2, this.hQP);
            }
            r0 = ((r0 + a.a.a.a.dS(3, this.efm)) + a.a.a.a.dS(4, this.hNS)) + a.a.a.a.dS(5, this.mIR);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mbZ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ToUserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aih com_tencent_mm_protocal_c_aih = (aih) objArr[1];
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
                        com_tencent_mm_protocal_c_aih.mbV = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aih.hQP = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aih.efm = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aih.hNS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aih.mIR = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aih.mbZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
