package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class kv extends a implements avb {
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
            return 0;
        } else if (i == 1) {
            return (((((((((a.a.a.a.dS(1, this.mcj) + 0) + a.a.a.a.dS(2, this.mnq)) + a.a.a.a.dS(3, this.mnr)) + a.a.a.a.dS(4, this.mns)) + a.a.a.a.c(5, 8, this.mnt)) + a.a.a.a.c(6, 8, this.mnu)) + a.a.a.a.c(7, 8, this.mnv)) + a.a.a.a.dS(8, this.mnw)) + a.a.a.a.dS(9, this.mnx)) + a.a.a.a.dS(10, this.mny);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mnt.clear();
                this.mnu.clear();
                this.mnv.clear();
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
                kv kvVar = (kv) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList zQ;
                int size;
                a com_tencent_mm_protocal_c_ayi;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        kvVar.mcj = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        kvVar.mnq = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        kvVar.mnr = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        kvVar.mns = aVar3.pMj.mH();
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
                            kvVar.mnt.add(com_tencent_mm_protocal_c_ayi);
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
                            kvVar.mnu.add(com_tencent_mm_protocal_c_ayi);
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
                            kvVar.mnv.add(com_tencent_mm_protocal_c_ayi);
                        }
                        return 0;
                    case 8:
                        kvVar.mnw = aVar3.pMj.mH();
                        return 0;
                    case 9:
                        kvVar.mnx = aVar3.pMj.mH();
                        return 0;
                    case 10:
                        kvVar.mny = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
