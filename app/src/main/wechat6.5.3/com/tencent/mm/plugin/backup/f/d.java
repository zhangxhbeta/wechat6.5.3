package com.tencent.mm.plugin.backup.f;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.protocal.c.dx;
import java.util.LinkedList;

public final class d extends a {
    public String bNv;
    public int ehw;
    public LinkedList<dx> ehx = new LinkedList();
    public int ehy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bNv == null) {
                throw new b("Not all required fields were included: clientMsgId");
            }
            if (this.bNv != null) {
                aVar.e(1, this.bNv);
            }
            aVar.dV(2, this.ehw);
            aVar.d(3, 8, this.ehx);
            aVar.dV(4, this.ehy);
            return 0;
        } else if (i == 1) {
            if (this.bNv != null) {
                r0 = a.a.a.b.b.a.f(1, this.bNv) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.dS(2, this.ehw)) + a.a.a.a.c(3, 8, this.ehx)) + a.a.a.a.dS(4, this.ehy);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ehx.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.bNv != null) {
                return 0;
            }
            throw new b("Not all required fields were included: clientMsgId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.bNv = aVar3.pMj.readString();
                    return 0;
                case 2:
                    dVar.ehw = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a dxVar = new dx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = dxVar.a(aVar4, dxVar, a.a(aVar4))) {
                        }
                        dVar.ehx.add(dxVar);
                    }
                    return 0;
                case 4:
                    dVar.ehy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
