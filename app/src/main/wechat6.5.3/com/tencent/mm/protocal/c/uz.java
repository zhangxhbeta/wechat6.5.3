package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class uz extends a implements avb {
    public int mcj;
    public int mnq;
    public int mnr;
    public int mns;
    public LinkedList<ayi> mnt = new LinkedList();
    public LinkedList<ayi> mnu = new LinkedList();
    public LinkedList<ayi> mnv = new LinkedList();
    public int mnw;
    public int mnx;
    public int mny;
    public int mxD;
    public int mxE;
    public int mxF;
    public LinkedList<ayi> mxG = new LinkedList();
    public LinkedList<ayi> mxH = new LinkedList();
    public LinkedList<ayi> mxI = new LinkedList();

    public final int getRet() {
        return this.mcj;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            aVar.dV(2, this.mnq);
            aVar.dV(3, this.mnr);
            aVar.dV(4, this.mns);
            aVar.d(5, 8, this.mnt);
            aVar.d(6, 8, this.mnu);
            aVar.d(7, 8, this.mnv);
            aVar.dV(8, this.mnw);
            aVar.dV(9, this.mnx);
            aVar.dV(10, this.mny);
            aVar.dV(11, this.mxD);
            aVar.dV(12, this.mxE);
            aVar.dV(13, this.mxF);
            aVar.d(14, 8, this.mxG);
            aVar.d(15, 8, this.mxH);
            aVar.d(16, 8, this.mxI);
            return 0;
        } else if (i == 1) {
            return (((((((((((((((a.a.a.a.dS(1, this.mcj) + 0) + a.a.a.a.dS(2, this.mnq)) + a.a.a.a.dS(3, this.mnr)) + a.a.a.a.dS(4, this.mns)) + a.a.a.a.c(5, 8, this.mnt)) + a.a.a.a.c(6, 8, this.mnu)) + a.a.a.a.c(7, 8, this.mnv)) + a.a.a.a.dS(8, this.mnw)) + a.a.a.a.dS(9, this.mnx)) + a.a.a.a.dS(10, this.mny)) + a.a.a.a.dS(11, this.mxD)) + a.a.a.a.dS(12, this.mxE)) + a.a.a.a.dS(13, this.mxF)) + a.a.a.a.c(14, 8, this.mxG)) + a.a.a.a.c(15, 8, this.mxH)) + a.a.a.a.c(16, 8, this.mxI);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mnt.clear();
                this.mnu.clear();
                this.mnv.clear();
                this.mxG.clear();
                this.mxH.clear();
                this.mxI.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                uz uzVar = (uz) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList zQ;
                int size;
                a com_tencent_mm_protocal_c_ayi;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        uzVar.mcj = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        uzVar.mnq = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        uzVar.mnr = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        uzVar.mns = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_ayi = new ayi();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_ayi.a(aVar4, com_tencent_mm_protocal_c_ayi, a.a(aVar4))) {
                            }
                            uzVar.mnt.add(com_tencent_mm_protocal_c_ayi);
                        }
                        return 0;
                    case 6:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_ayi = new ayi();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_ayi.a(aVar4, com_tencent_mm_protocal_c_ayi, a.a(aVar4))) {
                            }
                            uzVar.mnu.add(com_tencent_mm_protocal_c_ayi);
                        }
                        return 0;
                    case 7:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_ayi = new ayi();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_ayi.a(aVar4, com_tencent_mm_protocal_c_ayi, a.a(aVar4))) {
                            }
                            uzVar.mnv.add(com_tencent_mm_protocal_c_ayi);
                        }
                        return 0;
                    case 8:
                        uzVar.mnw = aVar3.pMj.mH();
                        return 0;
                    case 9:
                        uzVar.mnx = aVar3.pMj.mH();
                        return 0;
                    case 10:
                        uzVar.mny = aVar3.pMj.mH();
                        return 0;
                    case 11:
                        uzVar.mxD = aVar3.pMj.mH();
                        return 0;
                    case 12:
                        uzVar.mxE = aVar3.pMj.mH();
                        return 0;
                    case 13:
                        uzVar.mxF = aVar3.pMj.mH();
                        return 0;
                    case 14:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_ayi = new ayi();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_ayi.a(aVar4, com_tencent_mm_protocal_c_ayi, a.a(aVar4))) {
                            }
                            uzVar.mxG.add(com_tencent_mm_protocal_c_ayi);
                        }
                        return 0;
                    case 15:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_ayi = new ayi();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_ayi.a(aVar4, com_tencent_mm_protocal_c_ayi, a.a(aVar4))) {
                            }
                            uzVar.mxH.add(com_tencent_mm_protocal_c_ayi);
                        }
                        return 0;
                    case 16:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com_tencent_mm_protocal_c_ayi = new ayi();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_ayi.a(aVar4, com_tencent_mm_protocal_c_ayi, a.a(aVar4))) {
                            }
                            uzVar.mxI.add(com_tencent_mm_protocal_c_ayi);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
