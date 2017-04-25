package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ake extends a {
    public la mLf;
    public int mLg;
    public int maG;
    public String meq;
    public int mkE;
    public are mkF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mLf == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.mkF == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                if (this.mLf != null) {
                    aVar.dX(1, this.mLf.aHr());
                    this.mLf.a(aVar);
                }
                aVar.dV(2, this.mkE);
                if (this.mkF != null) {
                    aVar.dX(3, this.mkF.aHr());
                    this.mkF.a(aVar);
                }
                aVar.dV(4, this.maG);
                if (this.meq != null) {
                    aVar.e(5, this.meq);
                }
                aVar.dV(6, this.mLg);
                return 0;
            }
        } else if (i == 1) {
            if (this.mLf != null) {
                r0 = a.a.a.a.dU(1, this.mLf.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mkE);
            if (this.mkF != null) {
                r0 += a.a.a.a.dU(3, this.mkF.aHr());
            }
            r0 += a.a.a.a.dS(4, this.maG);
            if (this.meq != null) {
                r0 += a.a.a.b.b.a.f(5, this.meq);
            }
            return r0 + a.a.a.a.dS(6, this.mLg);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mLf == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.mkF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ake com_tencent_mm_protocal_c_ake = (ake) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a laVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        laVar = new la();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = laVar.a(aVar4, laVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ake.mLf = laVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ake.mkE = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        laVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = laVar.a(aVar4, laVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ake.mkF = laVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ake.maG = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ake.meq = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ake.mLg = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
