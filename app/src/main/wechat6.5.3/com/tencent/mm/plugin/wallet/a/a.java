package com.tencent.mm.plugin.wallet.a;

public final class a extends com.tencent.mm.ba.a {
    public String name;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.name == null) {
                return 0;
            }
            aVar.e(2, this.name);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                r0 = a.a.a.b.b.a.f(1, this.url) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.url = aVar3.pMj.readString();
                    return 0;
                case 2:
                    aVar4.name = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
