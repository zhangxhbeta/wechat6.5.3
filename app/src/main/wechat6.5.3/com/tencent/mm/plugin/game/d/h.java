package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class h extends a {
    public String gkY;
    public String gkZ;
    public String gla;
    public String glb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkY == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.gkZ == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.gla == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.glb == null) {
                throw new b("Not all required fields were included: Url");
            } else {
                if (this.gkY != null) {
                    aVar.e(1, this.gkY);
                }
                if (this.gkZ != null) {
                    aVar.e(2, this.gkZ);
                }
                if (this.gla != null) {
                    aVar.e(3, this.gla);
                }
                if (this.glb == null) {
                    return 0;
                }
                aVar.e(4, this.glb);
                return 0;
            }
        } else if (i == 1) {
            if (this.gkY != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkY) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkZ);
            }
            if (this.gla != null) {
                r0 += a.a.a.b.b.a.f(3, this.gla);
            }
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(4, this.glb);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkY == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.gkZ == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.gla == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.glb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.gkY = aVar3.pMj.readString();
                    return 0;
                case 2:
                    hVar.gkZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    hVar.gla = aVar3.pMj.readString();
                    return 0;
                case 4:
                    hVar.glb = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
