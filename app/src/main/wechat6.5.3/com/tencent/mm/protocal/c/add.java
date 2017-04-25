package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class add extends aqx {
    public String mhJ;
    public aot mhP;
    public String moq;
    public String mor;
    public int mos;
    public ra mot;
    public hb mou;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mhP == null) {
                throw new b("Not all required fields were included: qy_base_resp");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mhP != null) {
                    aVar.dX(2, this.mhP.aHr());
                    this.mhP.a(aVar);
                }
                if (this.mhJ != null) {
                    aVar.e(3, this.mhJ);
                }
                aVar.dV(4, this.mos);
                if (this.mot != null) {
                    aVar.dX(5, this.mot.aHr());
                    this.mot.a(aVar);
                }
                if (this.mou != null) {
                    aVar.dX(6, this.mou.aHr());
                    this.mou.a(aVar);
                }
                if (this.moq != null) {
                    aVar.e(7, this.moq);
                }
                if (this.mor == null) {
                    return 0;
                }
                aVar.e(8, this.mor);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mhP != null) {
                r0 += a.a.a.a.dU(2, this.mhP.aHr());
            }
            if (this.mhJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mhJ);
            }
            r0 += a.a.a.a.dS(4, this.mos);
            if (this.mot != null) {
                r0 += a.a.a.a.dU(5, this.mot.aHr());
            }
            if (this.mou != null) {
                r0 += a.a.a.a.dU(6, this.mou.aHr());
            }
            if (this.moq != null) {
                r0 += a.a.a.b.b.a.f(7, this.moq);
            }
            if (this.mor != null) {
                r0 += a.a.a.b.b.a.f(8, this.mor);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mhP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: qy_base_resp");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            add com_tencent_mm_protocal_c_add = (add) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_add.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new aot();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_add.mhP = eoVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_add.mhJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_add.mos = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ra();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_add.mot = eoVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new hb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_add.mou = eoVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_add.moq = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_add.mor = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
