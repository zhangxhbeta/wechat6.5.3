package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bei extends aqp {
    public String mOk;
    public bfs mZR;
    public bfs mZS;
    public long mZV;
    public int mnk;
    public int mqS;
    public long mqT;
    public int nac;
    public int nad;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mOk != null) {
                aVar.e(2, this.mOk);
            }
            aVar.dV(3, this.mqS);
            aVar.dV(4, this.nac);
            if (this.mZR != null) {
                aVar.dX(5, this.mZR.aHr());
                this.mZR.a(aVar);
            }
            if (this.mZS != null) {
                aVar.dX(6, this.mZS.aHr());
                this.mZS.a(aVar);
            }
            aVar.C(7, this.mqT);
            aVar.dV(8, this.mnk);
            aVar.C(9, this.mZV);
            aVar.dV(10, this.nad);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mOk != null) {
                r0 += a.a.a.b.b.a.f(2, this.mOk);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mqS)) + a.a.a.a.dS(4, this.nac);
            if (this.mZR != null) {
                r0 += a.a.a.a.dU(5, this.mZR.aHr());
            }
            if (this.mZS != null) {
                r0 += a.a.a.a.dU(6, this.mZS.aHr());
            }
            return (((r0 + a.a.a.a.B(7, this.mqT)) + a.a.a.a.dS(8, this.mnk)) + a.a.a.a.B(9, this.mZV)) + a.a.a.a.dS(10, this.nad);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bei com_tencent_mm_protocal_c_bei = (bei) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            bfs com_tencent_mm_protocal_c_bfs;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bei.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bei.mOk = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bei.mqS = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bei.nac = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfs = new bfs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfs.a(aVar4, com_tencent_mm_protocal_c_bfs, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bei.mZR = com_tencent_mm_protocal_c_bfs;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfs = new bfs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfs.a(aVar4, com_tencent_mm_protocal_c_bfs, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bei.mZS = com_tencent_mm_protocal_c_bfs;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bei.mqT = aVar3.pMj.mI();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bei.mnk = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bei.mZV = aVar3.pMj.mI();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bei.nad = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
