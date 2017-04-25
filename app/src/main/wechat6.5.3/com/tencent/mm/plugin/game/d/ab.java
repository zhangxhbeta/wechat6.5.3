package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class ab extends aqp {
    public String cHl;
    public String glC;
    public LinkedList<String> glQ = new LinkedList();
    public k glR;
    public int glS;
    public boolean glT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.glC == null) {
                throw new b("Not all required fields were included: Lang");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.glC != null) {
                aVar.e(2, this.glC);
            }
            aVar.d(3, 1, this.glQ);
            if (this.cHl != null) {
                aVar.e(4, this.cHl);
            }
            if (this.glR != null) {
                aVar.dX(5, this.glR.aHr());
                this.glR.a(aVar);
            }
            aVar.dV(6, this.glS);
            aVar.ab(7, this.glT);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glC != null) {
                r0 += a.a.a.b.b.a.f(2, this.glC);
            }
            r0 += a.a.a.a.c(3, 1, this.glQ);
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(4, this.cHl);
            }
            if (this.glR != null) {
                r0 += a.a.a.a.dU(5, this.glR.aHr());
            }
            return (r0 + a.a.a.a.dS(6, this.glS)) + (a.a.a.b.b.a.cw(7) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.glQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.glC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Lang");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        abVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    abVar.glC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    abVar.glQ.add(aVar3.pMj.readString());
                    return 0;
                case 4:
                    abVar.cHl = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        k kVar = new k();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, aqp.a(aVar4))) {
                        }
                        abVar.glR = kVar;
                    }
                    return 0;
                case 6:
                    abVar.glS = aVar3.pMj.mH();
                    return 0;
                case 7:
                    abVar.glT = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
