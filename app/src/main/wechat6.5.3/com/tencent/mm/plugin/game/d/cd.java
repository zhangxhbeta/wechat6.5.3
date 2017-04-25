package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class cd extends a {
    public String aXz;
    public int efm;
    public String gkT;
    public String gkV;
    public String gog;
    public LinkedList<ce> goh = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            if (this.gkT != null) {
                aVar.e(3, this.gkT);
            }
            if (this.gog != null) {
                aVar.e(4, this.gog);
            }
            aVar.d(5, 8, this.goh);
            if (this.gkV != null) {
                aVar.e(6, this.gkV);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkT);
            }
            if (this.gog != null) {
                r0 += a.a.a.b.b.a.f(4, this.gog);
            }
            r0 += a.a.a.a.c(5, 8, this.goh);
            if (this.gkV != null) {
                return r0 + a.a.a.b.b.a.f(6, this.gkV);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.goh.clear();
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
            cd cdVar = (cd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cdVar.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    cdVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    cdVar.gkT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    cdVar.gog = aVar3.pMj.readString();
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ce ceVar = new ce();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = ceVar.a(aVar4, ceVar, a.a(aVar4))) {
                        }
                        cdVar.goh.add(ceVar);
                    }
                    return 0;
                case 6:
                    cdVar.gkV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
