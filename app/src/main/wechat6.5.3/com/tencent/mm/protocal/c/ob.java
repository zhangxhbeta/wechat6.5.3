package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ob extends a {
    public int Height;
    public int Width;
    public String gmz;
    public String mpT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gmz != null) {
                aVar.e(1, this.gmz);
            }
            aVar.dV(2, this.Width);
            aVar.dV(3, this.Height);
            if (this.mpT == null) {
                return 0;
            }
            aVar.e(4, this.mpT);
            return 0;
        } else if (i == 1) {
            if (this.gmz != null) {
                r0 = a.a.a.b.b.a.f(1, this.gmz) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.Width)) + a.a.a.a.dS(3, this.Height);
            if (this.mpT != null) {
                r0 += a.a.a.b.b.a.f(4, this.mpT);
            }
            return r0;
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
            ob obVar = (ob) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    obVar.gmz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    obVar.Width = aVar3.pMj.mH();
                    return 0;
                case 3:
                    obVar.Height = aVar3.pMj.mH();
                    return 0;
                case 4:
                    obVar.mpT = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
