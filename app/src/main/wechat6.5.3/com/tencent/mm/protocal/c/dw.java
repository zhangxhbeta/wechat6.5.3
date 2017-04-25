package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class dw extends a implements avb {
    public String ID;
    public int mcj;
    public String meI;
    public are meJ;
    public String meK;
    public int meL;
    public String meM;
    public String meN;
    public are mes;

    public final int getRet() {
        return this.mcj;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.meJ == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.mes == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                aVar.dV(1, this.mcj);
                if (this.meJ != null) {
                    aVar.dX(2, this.meJ.aHr());
                    this.meJ.a(aVar);
                }
                if (this.meK != null) {
                    aVar.e(3, this.meK);
                }
                if (this.mes != null) {
                    aVar.dX(4, this.mes.aHr());
                    this.mes.a(aVar);
                }
                if (this.meM != null) {
                    aVar.e(5, this.meM);
                }
                if (this.meN != null) {
                    aVar.e(6, this.meN);
                }
                aVar.dV(7, this.meL);
                if (this.ID != null) {
                    aVar.e(8, this.ID);
                }
                if (this.meI != null) {
                    aVar.e(9, this.meI);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.meJ != null) {
                r0 += a.a.a.a.dU(2, this.meJ.aHr());
            }
            if (this.meK != null) {
                r0 += a.a.a.b.b.a.f(3, this.meK);
            }
            if (this.mes != null) {
                r0 += a.a.a.a.dU(4, this.mes.aHr());
            }
            if (this.meM != null) {
                r0 += a.a.a.b.b.a.f(5, this.meM);
            }
            if (this.meN != null) {
                r0 += a.a.a.b.b.a.f(6, this.meN);
            }
            r0 += a.a.a.a.dS(7, this.meL);
            if (this.ID != null) {
                r0 += a.a.a.b.b.a.f(8, this.ID);
            }
            if (this.meI != null) {
                return r0 + a.a.a.b.b.a.f(9, this.meI);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.meJ == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.mes != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dw dwVar = (dw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dwVar.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        dwVar.meJ = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    dwVar.meK = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        dwVar.mes = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    dwVar.meM = aVar3.pMj.readString();
                    return 0;
                case 6:
                    dwVar.meN = aVar3.pMj.readString();
                    return 0;
                case 7:
                    dwVar.meL = aVar3.pMj.mH();
                    return 0;
                case 8:
                    dwVar.ID = aVar3.pMj.readString();
                    return 0;
                case 9:
                    dwVar.meI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
