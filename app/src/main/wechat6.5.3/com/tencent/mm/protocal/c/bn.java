package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bn extends a {
    public int gll;
    public int hNS;
    public long mcb;
    public int mcc;
    public arf mcd;
    public int mce;
    public arf mcf;
    public int mcg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mcd == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.mcf == null) {
                throw new b("Not all required fields were included: DigestContent");
            } else {
                if (this.mcd != null) {
                    aVar.dX(1, this.mcd.aHr());
                    this.mcd.a(aVar);
                }
                aVar.C(2, this.mcb);
                aVar.dV(3, this.mcc);
                aVar.dV(4, this.hNS);
                aVar.dV(5, this.mce);
                if (this.mcf != null) {
                    aVar.dX(6, this.mcf.aHr());
                    this.mcf.a(aVar);
                }
                aVar.dV(7, this.mcg);
                aVar.dV(8, this.gll);
                return 0;
            }
        } else if (i == 1) {
            if (this.mcd != null) {
                r0 = a.a.a.a.dU(1, this.mcd.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.B(2, this.mcb)) + a.a.a.a.dS(3, this.mcc)) + a.a.a.a.dS(4, this.hNS)) + a.a.a.a.dS(5, this.mce);
            if (this.mcf != null) {
                r0 += a.a.a.a.dU(6, this.mcf.aHr());
            }
            return (r0 + a.a.a.a.dS(7, this.mcg)) + a.a.a.a.dS(8, this.gll);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mcd == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.mcf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DigestContent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bn bnVar = (bn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        bnVar.mcd = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 2:
                    bnVar.mcb = aVar3.pMj.mI();
                    return 0;
                case 3:
                    bnVar.mcc = aVar3.pMj.mH();
                    return 0;
                case 4:
                    bnVar.hNS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    bnVar.mce = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        bnVar.mcf = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 7:
                    bnVar.mcg = aVar3.pMj.mH();
                    return 0;
                case 8:
                    bnVar.gll = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
