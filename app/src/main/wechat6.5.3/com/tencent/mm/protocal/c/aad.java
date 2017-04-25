package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aad extends aqx {
    public String coI;
    public boolean fwA;
    public String mBA;
    public String mBB;
    public LinkedList<bjn> mBF = new LinkedList();
    public LinkedList<bjo> mBG = new LinkedList();
    public String mBH;
    public String mBI;
    public String mBJ;
    public LinkedList<String> mBz = new LinkedList();
    public LinkedList<qs> mbS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mBH == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.mBI == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.coI == null) {
                throw new b("Not all required fields were included: rankid");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.d(2, 8, this.mBF);
                aVar.d(3, 8, this.mBG);
                aVar.d(4, 1, this.mBz);
                if (this.mBH != null) {
                    aVar.e(5, this.mBH);
                }
                if (this.mBI != null) {
                    aVar.e(6, this.mBI);
                }
                if (this.coI != null) {
                    aVar.e(7, this.coI);
                }
                if (this.mBJ != null) {
                    aVar.e(8, this.mBJ);
                }
                if (this.mBA != null) {
                    aVar.e(9, this.mBA);
                }
                aVar.ab(10, this.fwA);
                if (this.mBB != null) {
                    aVar.e(11, this.mBB);
                }
                aVar.d(12, 8, this.mbS);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.c(2, 8, this.mBF)) + a.a.a.a.c(3, 8, this.mBG)) + a.a.a.a.c(4, 1, this.mBz);
            if (this.mBH != null) {
                r0 += a.a.a.b.b.a.f(5, this.mBH);
            }
            if (this.mBI != null) {
                r0 += a.a.a.b.b.a.f(6, this.mBI);
            }
            if (this.coI != null) {
                r0 += a.a.a.b.b.a.f(7, this.coI);
            }
            if (this.mBJ != null) {
                r0 += a.a.a.b.b.a.f(8, this.mBJ);
            }
            if (this.mBA != null) {
                r0 += a.a.a.b.b.a.f(9, this.mBA);
            }
            r0 += a.a.a.b.b.a.cw(10) + 1;
            if (this.mBB != null) {
                r0 += a.a.a.b.b.a.f(11, this.mBB);
            }
            return r0 + a.a.a.a.c(12, 8, this.mbS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mBF.clear();
            this.mBG.clear();
            this.mBz.clear();
            this.mbS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mBH == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.mBI == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.coI != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aad com_tencent_mm_protocal_c_aad = (aad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bjn com_tencent_mm_protocal_c_bjn = new bjn();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bjn.a(aVar4, com_tencent_mm_protocal_c_bjn, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.mBF.add(com_tencent_mm_protocal_c_bjn);
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bjo com_tencent_mm_protocal_c_bjo = new bjo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bjo.a(aVar4, com_tencent_mm_protocal_c_bjo, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.mBG.add(com_tencent_mm_protocal_c_bjo);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aad.mBz.add(aVar3.pMj.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aad.mBH = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aad.mBI = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aad.coI = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aad.mBJ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aad.mBA = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aad.fwA = aVar3.bQJ();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aad.mBB = aVar3.pMj.readString();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qs qsVar = new qs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qsVar.a(aVar4, qsVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aad.mbS.add(qsVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
