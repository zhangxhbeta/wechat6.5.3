package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bdi extends aqx {
    public arf mBN;
    public are mbY;
    public are mdX;
    public String mec;
    public are med;
    public arf mgW;
    public are mgX;
    public String mpB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mBN == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mBN != null) {
                    aVar.dX(2, this.mBN.aHr());
                    this.mBN.a(aVar);
                }
                if (this.mbY != null) {
                    aVar.dX(3, this.mbY.aHr());
                    this.mbY.a(aVar);
                }
                if (this.mpB != null) {
                    aVar.e(4, this.mpB);
                }
                if (this.mgW != null) {
                    aVar.dX(5, this.mgW.aHr());
                    this.mgW.a(aVar);
                }
                if (this.med != null) {
                    aVar.dX(6, this.med.aHr());
                    this.med.a(aVar);
                }
                if (this.mgX != null) {
                    aVar.dX(7, this.mgX.aHr());
                    this.mgX.a(aVar);
                }
                if (this.mec != null) {
                    aVar.e(8, this.mec);
                }
                if (this.mdX == null) {
                    return 0;
                }
                aVar.dX(9, this.mdX.aHr());
                this.mdX.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mBN != null) {
                r0 += a.a.a.a.dU(2, this.mBN.aHr());
            }
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(3, this.mbY.aHr());
            }
            if (this.mpB != null) {
                r0 += a.a.a.b.b.a.f(4, this.mpB);
            }
            if (this.mgW != null) {
                r0 += a.a.a.a.dU(5, this.mgW.aHr());
            }
            if (this.med != null) {
                r0 += a.a.a.a.dU(6, this.med.aHr());
            }
            if (this.mgX != null) {
                r0 += a.a.a.a.dU(7, this.mgX.aHr());
            }
            if (this.mec != null) {
                r0 += a.a.a.b.b.a.f(8, this.mec);
            }
            if (this.mdX != null) {
                r0 += a.a.a.a.dU(9, this.mdX.aHr());
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
            } else if (this.mBN == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.mbY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bdi com_tencent_mm_protocal_c_bdi = (bdi) objArr[1];
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
                        com_tencent_mm_protocal_c_bdi.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.mBN = eoVar;
                    }
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
                        com_tencent_mm_protocal_c_bdi.mbY = eoVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdi.mpB = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.mgW = eoVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.med = eoVar;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.mgX = eoVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bdi.mec = aVar3.pMj.readString();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.mdX = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
