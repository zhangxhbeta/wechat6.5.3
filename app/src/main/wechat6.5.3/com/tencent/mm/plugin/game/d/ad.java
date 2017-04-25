package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class ad extends aqp {
    public String cHl;
    public String glC;
    public LinkedList<String> glQ = new LinkedList();
    public int gmn;
    public int gmo;
    public int gmp;
    public boolean gmq;

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
            aVar.dV(2, this.gmn);
            aVar.dV(3, this.gmo);
            if (this.glC != null) {
                aVar.e(4, this.glC);
            }
            aVar.d(5, 1, this.glQ);
            if (this.cHl != null) {
                aVar.e(6, this.cHl);
            }
            aVar.dV(7, this.gmp);
            aVar.ab(8, this.gmq);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.gmn)) + a.a.a.a.dS(3, this.gmo);
            if (this.glC != null) {
                r0 += a.a.a.b.b.a.f(4, this.glC);
            }
            r0 += a.a.a.a.c(5, 1, this.glQ);
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(6, this.cHl);
            }
            return (r0 + a.a.a.a.dS(7, this.gmp)) + (a.a.a.b.b.a.cw(8) + 1);
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
            ad adVar = (ad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        adVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    adVar.gmn = aVar3.pMj.mH();
                    return 0;
                case 3:
                    adVar.gmo = aVar3.pMj.mH();
                    return 0;
                case 4:
                    adVar.glC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    adVar.glQ.add(aVar3.pMj.readString());
                    return 0;
                case 6:
                    adVar.cHl = aVar3.pMj.readString();
                    return 0;
                case 7:
                    adVar.gmp = aVar3.pMj.mH();
                    return 0;
                case 8:
                    adVar.gmq = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
