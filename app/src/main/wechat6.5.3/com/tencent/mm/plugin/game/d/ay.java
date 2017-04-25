package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ay extends a {
    public String aXz;
    public String glo;
    public LinkedList<bd> gmX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.glo == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.aXz != null) {
                    aVar.e(1, this.aXz);
                }
                aVar.d(2, 8, this.gmX);
                if (this.glo == null) {
                    return 0;
                }
                aVar.e(3, this.glo);
                return 0;
            }
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.gmX);
            if (this.glo != null) {
                r0 += a.a.a.b.b.a.f(3, this.glo);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gmX.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.glo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ay ayVar = (ay) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bd bdVar = new bd();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bdVar.a(aVar4, bdVar, a.a(aVar4))) {
                        }
                        ayVar.gmX.add(bdVar);
                    }
                    return 0;
                case 3:
                    ayVar.glo = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
