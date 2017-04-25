package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class ax extends a {
    public String aXz;
    public String gkA;
    public String gkv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkA == null) {
                throw new b("Not all required fields were included: IconURL");
            }
            if (this.gkA != null) {
                aVar.e(1, this.gkA);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            if (this.gkv == null) {
                return 0;
            }
            aVar.e(3, this.gkv);
            return 0;
        } else if (i == 1) {
            if (this.gkA != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkA) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.gkv != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkv);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: IconURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ax axVar = (ax) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axVar.gkA = aVar3.pMj.readString();
                    return 0;
                case 2:
                    axVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    axVar.gkv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
