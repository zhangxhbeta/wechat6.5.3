package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class i extends a {
    public String gkA;
    public String gkB;
    public String gkv;
    public int glc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkB == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.gkA == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                aVar.dV(1, this.glc);
                if (this.gkB != null) {
                    aVar.e(2, this.gkB);
                }
                if (this.gkA != null) {
                    aVar.e(3, this.gkA);
                }
                if (this.gkv != null) {
                    aVar.e(4, this.gkv);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.glc) + 0;
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            if (this.gkA != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkA);
            }
            if (this.gkv != null) {
                return r0 + a.a.a.b.b.a.f(4, this.gkv);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkB == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.gkA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.glc = aVar3.pMj.mH();
                    return 0;
                case 2:
                    iVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    iVar.gkA = aVar3.pMj.readString();
                    return 0;
                case 4:
                    iVar.gkv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
