package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bcg extends aqp {
    public int gng;
    public arf mXQ;
    public arf mXR;
    public int mXS;
    public int mXT;
    public int mXU;
    public int mXV;
    public int mdA;
    public int mdB;
    public int mdz;
    public are mfg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mXQ == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.mXR == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mXQ != null) {
                    aVar.dX(2, this.mXQ.aHr());
                    this.mXQ.a(aVar);
                }
                if (this.mXR != null) {
                    aVar.dX(3, this.mXR.aHr());
                    this.mXR.a(aVar);
                }
                aVar.dV(4, this.mdz);
                aVar.dV(5, this.mdA);
                aVar.dV(6, this.mdB);
                if (this.mfg != null) {
                    aVar.dX(7, this.mfg.aHr());
                    this.mfg.a(aVar);
                }
                aVar.dV(8, this.gng);
                aVar.dV(9, this.mXS);
                aVar.dV(10, this.mXT);
                aVar.dV(11, this.mXU);
                aVar.dV(12, this.mXV);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mXQ != null) {
                r0 += a.a.a.a.dU(2, this.mXQ.aHr());
            }
            if (this.mXR != null) {
                r0 += a.a.a.a.dU(3, this.mXR.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(4, this.mdz)) + a.a.a.a.dS(5, this.mdA)) + a.a.a.a.dS(6, this.mdB);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(7, this.mfg.aHr());
            }
            return ((((r0 + a.a.a.a.dS(8, this.gng)) + a.a.a.a.dS(9, this.mXS)) + a.a.a.a.dS(10, this.mXT)) + a.a.a.a.dS(11, this.mXU)) + a.a.a.a.dS(12, this.mXV);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mXQ == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.mXR == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.mfg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bcg com_tencent_mm_protocal_c_bcg = (bcg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcg.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcg.mXQ = enVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcg.mXR = enVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcg.mdz = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcg.mdA = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcg.mdB = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcg.mfg = enVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcg.gng = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bcg.mXS = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bcg.mXT = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bcg.mXU = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bcg.mXV = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
