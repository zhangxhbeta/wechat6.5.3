package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class cu extends a {
    public String glj;
    public int lZm;
    public int mdl;
    public int mdm;
    public cz mdn;
    public ct mdo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.glj == null) {
                throw new b("Not all required fields were included: AppId");
            }
            aVar.dV(1, this.lZm);
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            aVar.dV(3, this.mdl);
            aVar.dV(4, this.mdm);
            if (this.mdn != null) {
                aVar.dX(5, this.mdn.aHr());
                this.mdn.a(aVar);
            }
            if (this.mdo != null) {
                aVar.dX(6, this.mdo.aHr());
                this.mdo.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.lZm) + 0;
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mdl)) + a.a.a.a.dS(4, this.mdm);
            if (this.mdn != null) {
                r0 += a.a.a.a.dU(5, this.mdn.aHr());
            }
            if (this.mdo != null) {
                return r0 + a.a.a.a.dU(6, this.mdo.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.glj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            cu cuVar = (cu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a czVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cuVar.lZm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    cuVar.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    cuVar.mdl = aVar3.pMj.mH();
                    return 0;
                case 4:
                    cuVar.mdm = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        czVar = new cz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = czVar.a(aVar4, czVar, a.a(aVar4))) {
                        }
                        cuVar.mdn = czVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        czVar = new ct();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = czVar.a(aVar4, czVar, a.a(aVar4))) {
                        }
                        cuVar.mdo = czVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
