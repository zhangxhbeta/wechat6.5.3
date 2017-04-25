package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class bw extends a {
    public int Height;
    public int Width;
    public int gnX;
    public String gnp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gnp != null) {
                aVar.e(1, this.gnp);
            }
            aVar.dV(2, this.gnX);
            aVar.dV(3, this.Width);
            aVar.dV(4, this.Height);
            return 0;
        } else if (i == 1) {
            if (this.gnp != null) {
                r0 = a.a.a.b.b.a.f(1, this.gnp) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.dS(2, this.gnX)) + a.a.a.a.dS(3, this.Width)) + a.a.a.a.dS(4, this.Height);
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
            bw bwVar = (bw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bwVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 2:
                    bwVar.gnX = aVar3.pMj.mH();
                    return 0;
                case 3:
                    bwVar.Width = aVar3.pMj.mH();
                    return 0;
                case 4:
                    bwVar.Height = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
