package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class gh extends aqx {
    public int eeO;
    public int maB;
    public int may;
    public are mbY;
    public are mdX;
    public are med;
    public ari mgO;
    public String mgT;
    public arf mgW;
    public are mgX;
    public int mgZ;
    public String mha;
    public String mhb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mgT != null) {
                    aVar.e(2, this.mgT);
                }
                if (this.mbY != null) {
                    aVar.dX(3, this.mbY.aHr());
                    this.mbY.a(aVar);
                }
                aVar.dV(4, this.maB);
                aVar.dV(5, this.mgZ);
                if (this.mha != null) {
                    aVar.e(6, this.mha);
                }
                aVar.dV(7, this.eeO);
                if (this.mhb != null) {
                    aVar.e(8, this.mhb);
                }
                if (this.mgW != null) {
                    aVar.dX(9, this.mgW.aHr());
                    this.mgW.a(aVar);
                }
                if (this.med != null) {
                    aVar.dX(10, this.med.aHr());
                    this.med.a(aVar);
                }
                if (this.mgX != null) {
                    aVar.dX(11, this.mgX.aHr());
                    this.mgX.a(aVar);
                }
                if (this.mgO != null) {
                    aVar.dX(12, this.mgO.aHr());
                    this.mgO.a(aVar);
                }
                aVar.dV(13, this.may);
                if (this.mdX == null) {
                    return 0;
                }
                aVar.dX(14, this.mdX.aHr());
                this.mdX.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mgT != null) {
                r0 += a.a.a.b.b.a.f(2, this.mgT);
            }
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(3, this.mbY.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(4, this.maB)) + a.a.a.a.dS(5, this.mgZ);
            if (this.mha != null) {
                r0 += a.a.a.b.b.a.f(6, this.mha);
            }
            r0 += a.a.a.a.dS(7, this.eeO);
            if (this.mhb != null) {
                r0 += a.a.a.b.b.a.f(8, this.mhb);
            }
            if (this.mgW != null) {
                r0 += a.a.a.a.dU(9, this.mgW.aHr());
            }
            if (this.med != null) {
                r0 += a.a.a.a.dU(10, this.med.aHr());
            }
            if (this.mgX != null) {
                r0 += a.a.a.a.dU(11, this.mgX.aHr());
            }
            if (this.mgO != null) {
                r0 += a.a.a.a.dU(12, this.mgO.aHr());
            }
            r0 += a.a.a.a.dS(13, this.may);
            if (this.mdX != null) {
                r0 += a.a.a.a.dU(14, this.mdX.aHr());
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
            } else if (this.mbY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            gh ghVar = (gh) objArr[1];
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
                        ghVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    ghVar.mgT = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ghVar.mbY = eoVar;
                    }
                    return 0;
                case 4:
                    ghVar.maB = aVar3.pMj.mH();
                    return 0;
                case 5:
                    ghVar.mgZ = aVar3.pMj.mH();
                    return 0;
                case 6:
                    ghVar.mha = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ghVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 8:
                    ghVar.mhb = aVar3.pMj.readString();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ghVar.mgW = eoVar;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ghVar.med = eoVar;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ghVar.mgX = eoVar;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ari();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ghVar.mgO = eoVar;
                    }
                    return 0;
                case 13:
                    ghVar.may = aVar3.pMj.mH();
                    return 0;
                case 14:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ghVar.mdX = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
