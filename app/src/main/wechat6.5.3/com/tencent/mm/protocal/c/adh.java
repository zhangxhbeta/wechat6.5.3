package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class adh extends a {
    public int fvo;
    public String gln;
    public arf mEj;
    public int mEk;
    public String mgi;
    public String mnX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mEj == null) {
                throw new b("Not all required fields were included: NickName");
            }
            aVar.dV(1, this.fvo);
            if (this.mEj != null) {
                aVar.dX(2, this.mEj.aHr());
                this.mEj.a(aVar);
            }
            if (this.mgi != null) {
                aVar.e(3, this.mgi);
            }
            if (this.mnX != null) {
                aVar.e(4, this.mnX);
            }
            if (this.gln != null) {
                aVar.e(5, this.gln);
            }
            aVar.dV(6, this.mEk);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.fvo) + 0;
            if (this.mEj != null) {
                r0 += a.a.a.a.dU(2, this.mEj.aHr());
            }
            if (this.mgi != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgi);
            }
            if (this.mnX != null) {
                r0 += a.a.a.b.b.a.f(4, this.mnX);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(5, this.gln);
            }
            return r0 + a.a.a.a.dS(6, this.mEk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mEj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: NickName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            adh com_tencent_mm_protocal_c_adh = (adh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_adh.fvo = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_arf = new arf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adh.mEj = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adh.mgi = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adh.mnX = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adh.gln = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adh.mEk = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
