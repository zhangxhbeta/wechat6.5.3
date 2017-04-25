package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class h extends a {
    public String ID;
    public long eeG;
    public long eeH;
    public long eeI;
    public g eeJ;
    public long eeK;
    public int eeL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.C(2, this.eeG);
            aVar.C(3, this.eeH);
            aVar.C(4, this.eeI);
            if (this.eeJ != null) {
                aVar.dX(5, this.eeJ.aHr());
                this.eeJ.a(aVar);
            }
            aVar.C(6, this.eeK);
            aVar.dV(7, this.eeL);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.B(2, this.eeG)) + a.a.a.a.B(3, this.eeH)) + a.a.a.a.B(4, this.eeI);
            if (this.eeJ != null) {
                r0 += a.a.a.a.dU(5, this.eeJ.aHr());
            }
            return (r0 + a.a.a.a.B(6, this.eeK)) + a.a.a.a.dS(7, this.eeL);
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
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hVar.ID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    hVar.eeG = aVar3.pMj.mI();
                    return 0;
                case 3:
                    hVar.eeH = aVar3.pMj.mI();
                    return 0;
                case 4:
                    hVar.eeI = aVar3.pMj.mI();
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a gVar = new g();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        hVar.eeJ = gVar;
                    }
                    return 0;
                case 6:
                    hVar.eeK = aVar3.pMj.mI();
                    return 0;
                case 7:
                    hVar.eeL = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
