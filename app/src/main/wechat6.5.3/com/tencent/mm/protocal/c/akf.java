package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class akf extends a {
    public int eeO;
    public int mLh;
    public int mLi;
    public int mcj;
    public int miR;
    public are mkF;
    public la mkI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mkI == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.mkF == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                aVar.dV(1, this.mcj);
                if (this.mkI != null) {
                    aVar.dX(2, this.mkI.aHr());
                    this.mkI.a(aVar);
                }
                aVar.dV(3, this.miR);
                if (this.mkF != null) {
                    aVar.dX(4, this.mkF.aHr());
                    this.mkF.a(aVar);
                }
                aVar.dV(5, this.eeO);
                aVar.dV(6, this.mLh);
                aVar.dV(7, this.mLi);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.mkI != null) {
                r0 += a.a.a.a.dU(2, this.mkI.aHr());
            }
            r0 += a.a.a.a.dS(3, this.miR);
            if (this.mkF != null) {
                r0 += a.a.a.a.dU(4, this.mkF.aHr());
            }
            return ((r0 + a.a.a.a.dS(5, this.eeO)) + a.a.a.a.dS(6, this.mLh)) + a.a.a.a.dS(7, this.mLi);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mkI == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.mkF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            akf com_tencent_mm_protocal_c_akf = (akf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a laVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_akf.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        laVar = new la();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = laVar.a(aVar4, laVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akf.mkI = laVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akf.miR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        laVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = laVar.a(aVar4, laVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akf.mkF = laVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akf.eeO = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akf.mLh = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akf.mLi = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
