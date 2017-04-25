package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bu extends a {
    public avi mcn;
    public arf mco;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mcn == null) {
                throw new b("Not all required fields were included: SnsADObject");
            }
            if (this.mcn != null) {
                aVar.dX(1, this.mcn.aHr());
                this.mcn.a(aVar);
            }
            if (this.mco == null) {
                return 0;
            }
            aVar.dX(2, this.mco.aHr());
            this.mco.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mcn != null) {
                r0 = a.a.a.a.dU(1, this.mcn.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mco != null) {
                r0 += a.a.a.a.dU(2, this.mco.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mcn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsADObject");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bu buVar = (bu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        avi com_tencent_mm_protocal_c_avi = new avi();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avi.a(aVar4, com_tencent_mm_protocal_c_avi, a.a(aVar4))) {
                        }
                        buVar.mcn = com_tencent_mm_protocal_c_avi;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        buVar.mco = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
