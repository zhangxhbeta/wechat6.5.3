package com.tencent.mm.plugin.product.c;

import com.tencent.mm.ba.a;

public final class e extends a {
    public int id;
    public String name;
    public int value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.id);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.dV(3, this.value);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.id) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            return r0 + a.a.a.a.dS(3, this.value);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.id = aVar3.pMj.mH();
                    return 0;
                case 2:
                    eVar.name = aVar3.pMj.readString();
                    return 0;
                case 3:
                    eVar.value = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
