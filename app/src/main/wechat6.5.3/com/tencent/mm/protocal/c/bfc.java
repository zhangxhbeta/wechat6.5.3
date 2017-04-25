package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bfc extends a {
    public int bkM;
    public String gon;
    public are mnB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mnB == null) {
                throw new b("Not all required fields were included: CmdBuf");
            }
            aVar.dV(1, this.bkM);
            if (this.mnB != null) {
                aVar.dX(2, this.mnB.aHr());
                this.mnB.a(aVar);
            }
            if (this.gon != null) {
                aVar.e(3, this.gon);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.bkM) + 0;
            if (this.mnB != null) {
                r0 += a.a.a.a.dU(2, this.mnB.aHr());
            }
            if (this.gon != null) {
                return r0 + a.a.a.b.b.a.f(3, this.gon);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mnB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CmdBuf");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bfc com_tencent_mm_protocal_c_bfc = (bfc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bfc.bkM = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfc.mnB = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfc.gon = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
