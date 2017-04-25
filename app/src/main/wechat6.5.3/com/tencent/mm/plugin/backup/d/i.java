package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class i extends a {
    public String ID;
    public long eeG;
    public g eeJ;
    public long eeM;
    public long eeN;
    public int eeO;
    public int eeP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.C(2, this.eeM);
            aVar.C(3, this.eeN);
            aVar.dV(4, this.eeO);
            aVar.dV(5, this.eeP);
            aVar.C(6, this.eeG);
            if (this.eeJ == null) {
                return 0;
            }
            aVar.dX(7, this.eeJ.aHr());
            this.eeJ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.B(2, this.eeM)) + a.a.a.a.B(3, this.eeN)) + a.a.a.a.dS(4, this.eeO)) + a.a.a.a.dS(5, this.eeP)) + a.a.a.a.B(6, this.eeG);
            if (this.eeJ != null) {
                r0 += a.a.a.a.dU(7, this.eeJ.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.ID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    iVar.eeM = aVar3.pMj.mI();
                    return 0;
                case 3:
                    iVar.eeN = aVar3.pMj.mI();
                    return 0;
                case 4:
                    iVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 5:
                    iVar.eeP = aVar3.pMj.mH();
                    return 0;
                case 6:
                    iVar.eeG = aVar3.pMj.mI();
                    return 0;
                case 7:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a gVar = new g();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        iVar.eeJ = gVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
