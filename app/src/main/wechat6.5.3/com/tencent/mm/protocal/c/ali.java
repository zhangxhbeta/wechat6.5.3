package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ali extends a {
    public int efj;
    public int efl;
    public String gkB;
    public int gof;
    public are mMh;
    public are mcO;
    public String mpC;
    public String mqd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.gof);
            aVar.dV(2, this.efl);
            if (this.gkB != null) {
                aVar.e(3, this.gkB);
            }
            aVar.dV(4, this.efj);
            if (this.mcO != null) {
                aVar.dX(5, this.mcO.aHr());
                this.mcO.a(aVar);
            }
            if (this.mqd != null) {
                aVar.e(6, this.mqd);
            }
            if (this.mMh != null) {
                aVar.dX(7, this.mMh.aHr());
                this.mMh.a(aVar);
            }
            if (this.mpC != null) {
                aVar.e(8, this.mpC);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.gof) + 0) + a.a.a.a.dS(2, this.efl);
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkB);
            }
            r0 += a.a.a.a.dS(4, this.efj);
            if (this.mcO != null) {
                r0 += a.a.a.a.dU(5, this.mcO.aHr());
            }
            if (this.mqd != null) {
                r0 += a.a.a.b.b.a.f(6, this.mqd);
            }
            if (this.mMh != null) {
                r0 += a.a.a.a.dU(7, this.mMh.aHr());
            }
            if (this.mpC != null) {
                return r0 + a.a.a.b.b.a.f(8, this.mpC);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ali com_tencent_mm_protocal_c_ali = (ali) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ali.gof = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ali.efl = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ali.gkB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ali.efj = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.mcO = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ali.mqd = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.mMh = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ali.mpC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
