package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class asj extends a {
    public nr mdT;
    public are mdU;
    public are mdV;
    public int mej;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdV == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.mdT == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.mdU == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else {
                if (this.mdV != null) {
                    aVar.dX(1, this.mdV.aHr());
                    this.mdV.a(aVar);
                }
                if (this.mdT != null) {
                    aVar.dX(2, this.mdT.aHr());
                    this.mdT.a(aVar);
                }
                if (this.mdU != null) {
                    aVar.dX(3, this.mdU.aHr());
                    this.mdU.a(aVar);
                }
                aVar.dV(4, this.mej);
                return 0;
            }
        } else if (i == 1) {
            if (this.mdV != null) {
                r0 = a.a.a.a.dU(1, this.mdV.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mdT != null) {
                r0 += a.a.a.a.dU(2, this.mdT.aHr());
            }
            if (this.mdU != null) {
                r0 += a.a.a.a.dU(3, this.mdU.aHr());
            }
            return r0 + a.a.a.a.dS(4, this.mej);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdV == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.mdT == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.mdU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            asj com_tencent_mm_protocal_c_asj = (asj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asj.mdV = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new nr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asj.mdT = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asj.mdU = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asj.mej = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
