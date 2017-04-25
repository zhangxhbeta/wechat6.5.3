package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ahq extends a {
    public String gln;
    public nr mew;
    public are mgD;
    public String mgI;
    public String mgS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mgD == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.mew == null) {
                throw new b("Not all required fields were included: CliPubECDHKey");
            } else {
                if (this.mgD != null) {
                    aVar.dX(1, this.mgD.aHr());
                    this.mgD.a(aVar);
                }
                if (this.mew != null) {
                    aVar.dX(2, this.mew.aHr());
                    this.mew.a(aVar);
                }
                if (this.gln != null) {
                    aVar.e(3, this.gln);
                }
                if (this.mgI != null) {
                    aVar.e(4, this.mgI);
                }
                if (this.mgS == null) {
                    return 0;
                }
                aVar.e(5, this.mgS);
                return 0;
            }
        } else if (i == 1) {
            if (this.mgD != null) {
                r0 = a.a.a.a.dU(1, this.mgD.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mew != null) {
                r0 += a.a.a.a.dU(2, this.mew.aHr());
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(3, this.gln);
            }
            if (this.mgI != null) {
                r0 += a.a.a.b.b.a.f(4, this.mgI);
            }
            if (this.mgS != null) {
                r0 += a.a.a.b.b.a.f(5, this.mgS);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mgD == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.mew != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CliPubECDHKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ahq com_tencent_mm_protocal_c_ahq = (ahq) objArr[1];
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
                        com_tencent_mm_protocal_c_ahq.mgD = com_tencent_mm_protocal_c_are;
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
                        com_tencent_mm_protocal_c_ahq.mew = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahq.gln = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahq.mgI = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahq.mgS = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
