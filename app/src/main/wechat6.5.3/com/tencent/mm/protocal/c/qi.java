package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class qi extends a implements avb {
    public int mcj;
    public int miR;
    public are mkF;
    public la mkI;

    public final int getRet() {
        return this.mcj;
    }

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
                if (this.mkF != null) {
                    aVar.dX(3, this.mkF.aHr());
                    this.mkF.a(aVar);
                }
                aVar.dV(4, this.miR);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.mkI != null) {
                r0 += a.a.a.a.dU(2, this.mkI.aHr());
            }
            if (this.mkF != null) {
                r0 += a.a.a.a.dU(3, this.mkF.aHr());
            }
            return r0 + a.a.a.a.dS(4, this.miR);
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
            qi qiVar = (qi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    qiVar.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        la laVar = new la();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = laVar.a(aVar4, laVar, a.a(aVar4))) {
                        }
                        qiVar.mkI = laVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        qiVar.mkF = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    qiVar.miR = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
