package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class it extends a {
    public String lYG;
    public LinkedList<lv> mkd = new LinkedList();
    public int mke;
    public String mkf;
    public String name;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mkd);
            if (this.lYG != null) {
                aVar.e(2, this.lYG);
            }
            aVar.dV(3, this.mke);
            if (this.mkf != null) {
                aVar.e(4, this.mkf);
            }
            if (this.name != null) {
                aVar.e(5, this.name);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.mkd) + 0;
            if (this.lYG != null) {
                r0 += a.a.a.b.b.a.f(2, this.lYG);
            }
            r0 += a.a.a.a.dS(3, this.mke);
            if (this.mkf != null) {
                r0 += a.a.a.b.b.a.f(4, this.mkf);
            }
            if (this.name != null) {
                return r0 + a.a.a.b.b.a.f(5, this.name);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mkd.clear();
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
            it itVar = (it) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        lv lvVar = new lv();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = lvVar.a(aVar4, lvVar, a.a(aVar4))) {
                        }
                        itVar.mkd.add(lvVar);
                    }
                    return 0;
                case 2:
                    itVar.lYG = aVar3.pMj.readString();
                    return 0;
                case 3:
                    itVar.mke = aVar3.pMj.mH();
                    return 0;
                case 4:
                    itVar.mkf = aVar3.pMj.readString();
                    return 0;
                case 5:
                    itVar.name = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
