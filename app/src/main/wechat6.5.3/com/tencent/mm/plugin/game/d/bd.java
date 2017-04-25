package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bd extends a {
    public int gng;
    public String gnh;
    public String gni;
    public boolean gnj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gni == null) {
                throw new b("Not all required fields were included: MediaURL");
            }
            aVar.dV(1, this.gng);
            if (this.gnh != null) {
                aVar.e(2, this.gnh);
            }
            if (this.gni != null) {
                aVar.e(3, this.gni);
            }
            aVar.ab(4, this.gnj);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.gng) + 0;
            if (this.gnh != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnh);
            }
            if (this.gni != null) {
                r0 += a.a.a.b.b.a.f(3, this.gni);
            }
            return r0 + (a.a.a.b.b.a.cw(4) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gni != null) {
                return 0;
            }
            throw new b("Not all required fields were included: MediaURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bd bdVar = (bd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdVar.gng = aVar3.pMj.mH();
                    return 0;
                case 2:
                    bdVar.gnh = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bdVar.gni = aVar3.pMj.readString();
                    return 0;
                case 4:
                    bdVar.gnj = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
