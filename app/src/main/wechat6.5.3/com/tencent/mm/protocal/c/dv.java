package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class dv extends a {
    public String ID;
    public int mcj;
    public are meJ;
    public String meK;
    public int meL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.meJ == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            }
            aVar.dV(1, this.mcj);
            if (this.meJ != null) {
                aVar.dX(2, this.meJ.aHr());
                this.meJ.a(aVar);
            }
            if (this.meK != null) {
                aVar.e(3, this.meK);
            }
            aVar.dV(4, this.meL);
            if (this.ID != null) {
                aVar.e(5, this.ID);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.meJ != null) {
                r0 += a.a.a.a.dU(2, this.meJ.aHr());
            }
            if (this.meK != null) {
                r0 += a.a.a.b.b.a.f(3, this.meK);
            }
            r0 += a.a.a.a.dS(4, this.meL);
            if (this.ID != null) {
                return r0 + a.a.a.b.b.a.f(5, this.ID);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.meJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: QRCodeBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dv dvVar = (dv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvVar.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        dvVar.meJ = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    dvVar.meK = aVar3.pMj.readString();
                    return 0;
                case 4:
                    dvVar.meL = aVar3.pMj.mH();
                    return 0;
                case 5:
                    dvVar.ID = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
