package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class beq extends aqp {
    public long mNN;
    public int mNO;
    public int mnk;
    public String nau;
    public b nav;
    public b naw;
    public String nax;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nau == null) {
                throw new a.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.naw == null) {
                throw new a.a.a.b("Not all required fields were included: CapInfo");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                aVar.dV(2, this.mNO);
                if (this.nau != null) {
                    aVar.e(3, this.nau);
                }
                aVar.dV(4, this.mnk);
                if (this.nav != null) {
                    aVar.b(5, this.nav);
                }
                if (this.naw != null) {
                    aVar.b(6, this.naw);
                }
                aVar.C(7, this.mNN);
                if (this.nax == null) {
                    return 0;
                }
                aVar.e(8, this.nax);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mNO);
            if (this.nau != null) {
                r0 += a.a.a.b.b.a.f(3, this.nau);
            }
            r0 += a.a.a.a.dS(4, this.mnk);
            if (this.nav != null) {
                r0 += a.a.a.a.a(5, this.nav);
            }
            if (this.naw != null) {
                r0 += a.a.a.a.a(6, this.naw);
            }
            r0 += a.a.a.a.B(7, this.mNN);
            if (this.nax != null) {
                r0 += a.a.a.b.b.a.f(8, this.nax);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.nau == null) {
                throw new a.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.naw != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            beq com_tencent_mm_protocal_c_beq = (beq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beq.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_beq.mNO = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_beq.nau = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_beq.mnk = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_beq.nav = aVar3.bQK();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_beq.naw = aVar3.bQK();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_beq.mNN = aVar3.pMj.mI();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_beq.nax = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
