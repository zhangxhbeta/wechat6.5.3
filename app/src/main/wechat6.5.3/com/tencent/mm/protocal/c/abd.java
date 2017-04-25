package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class abd extends aqp {
    public String bol;
    public String mCx;
    public int mCy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.bol == null) {
                throw new b("Not all required fields were included: card_id");
            } else if (this.mCx == null) {
                throw new b("Not all required fields were included: to_username");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.bol != null) {
                    aVar.e(2, this.bol);
                }
                if (this.mCx != null) {
                    aVar.e(3, this.mCx);
                }
                aVar.dV(4, this.mCy);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.bol != null) {
                r0 += a.a.a.b.b.a.f(2, this.bol);
            }
            if (this.mCx != null) {
                r0 += a.a.a.b.b.a.f(3, this.mCx);
            }
            return r0 + a.a.a.a.dS(4, this.mCy);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.bol == null) {
                throw new b("Not all required fields were included: card_id");
            } else if (this.mCx != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: to_username");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            abd com_tencent_mm_protocal_c_abd = (abd) objArr[1];
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
                        com_tencent_mm_protocal_c_abd.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_abd.bol = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_abd.mCx = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_abd.mCy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
