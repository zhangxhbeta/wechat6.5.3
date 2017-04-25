package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class aq extends a {
    public String aXz;
    public String gkv;
    public String glo;
    public String gmF;
    public String gmM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.gmF != null) {
                aVar.e(1, this.gmF);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            if (this.glo != null) {
                aVar.e(3, this.glo);
            }
            if (this.gkv != null) {
                aVar.e(4, this.gkv);
            }
            if (this.gmM == null) {
                return 0;
            }
            aVar.e(5, this.gmM);
            return 0;
        } else if (i == 1) {
            if (this.gmF != null) {
                r0 = a.a.a.b.b.a.f(1, this.gmF) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.glo != null) {
                r0 += a.a.a.b.b.a.f(3, this.glo);
            }
            if (this.gkv != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkv);
            }
            if (this.gmM != null) {
                r0 += a.a.a.b.b.a.f(5, this.gmM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.aXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aq aqVar = (aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqVar.gmF = aVar3.pMj.readString();
                    return 0;
                case 2:
                    aqVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    aqVar.glo = aVar3.pMj.readString();
                    return 0;
                case 4:
                    aqVar.gkv = aVar3.pMj.readString();
                    return 0;
                case 5:
                    aqVar.gmM = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
