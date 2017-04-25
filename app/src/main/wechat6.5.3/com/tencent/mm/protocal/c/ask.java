package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class ask extends a {
    public int mQZ;
    public b mQh;
    public int mRa;
    public int mRb;
    public int mRc;
    public int mRd;
    public int mRe;
    public int mRf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mQh == null) {
                throw new a.a.a.b("Not all required fields were included: data");
            }
            aVar.dV(1, this.mQZ);
            aVar.dV(2, this.mRa);
            aVar.dV(3, this.mRb);
            aVar.dV(4, this.mRc);
            aVar.dV(5, this.mRd);
            aVar.dV(6, this.mRe);
            aVar.dV(7, this.mRf);
            if (this.mQh != null) {
                aVar.b(8, this.mQh);
            }
            return 0;
        } else if (i == 1) {
            int dS = ((((((a.a.a.a.dS(1, this.mQZ) + 0) + a.a.a.a.dS(2, this.mRa)) + a.a.a.a.dS(3, this.mRb)) + a.a.a.a.dS(4, this.mRc)) + a.a.a.a.dS(5, this.mRd)) + a.a.a.a.dS(6, this.mRe)) + a.a.a.a.dS(7, this.mRf);
            if (this.mQh != null) {
                return dS + a.a.a.a.a(8, this.mQh);
            }
            return dS;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.bQL();
                }
            }
            if (bArr != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ask com_tencent_mm_protocal_c_ask = (ask) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ask.mQZ = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ask.mRa = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ask.mRb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ask.mRc = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ask.mRd = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ask.mRe = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ask.mRf = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ask.mQh = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
