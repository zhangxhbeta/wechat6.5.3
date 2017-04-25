package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ark extends a {
    public String mGp;
    public LinkedList<cc> mQC = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mQC);
            if (this.mGp != null) {
                aVar.e(2, this.mGp);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.mQC) + 0;
            if (this.mGp != null) {
                return r0 + a.a.a.b.b.a.f(2, this.mGp);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mQC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            ark com_tencent_mm_protocal_c_ark = (ark) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        cc ccVar = new cc();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = ccVar.a(aVar4, ccVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ark.mQC.add(ccVar);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ark.mGp = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
