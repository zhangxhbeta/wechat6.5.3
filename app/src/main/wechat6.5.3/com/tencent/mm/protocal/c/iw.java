package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class iw extends a {
    public int iOT;
    public int mkB;
    public String mkC;
    public String text;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.type);
            if (this.text != null) {
                aVar.e(2, this.text);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.dV(4, this.iOT);
            aVar.dV(5, this.mkB);
            if (this.mkC != null) {
                aVar.e(6, this.mkC);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.type) + 0;
            if (this.text != null) {
                r0 += a.a.a.b.b.a.f(2, this.text);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(3, this.url);
            }
            r0 = (r0 + a.a.a.a.dS(4, this.iOT)) + a.a.a.a.dS(5, this.mkB);
            if (this.mkC != null) {
                return r0 + a.a.a.b.b.a.f(6, this.mkC);
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
            iw iwVar = (iw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iwVar.type = aVar3.pMj.mH();
                    return 0;
                case 2:
                    iwVar.text = aVar3.pMj.readString();
                    return 0;
                case 3:
                    iwVar.url = aVar3.pMj.readString();
                    return 0;
                case 4:
                    iwVar.iOT = aVar3.pMj.mH();
                    return 0;
                case 5:
                    iwVar.mkB = aVar3.pMj.mH();
                    return 0;
                case 6:
                    iwVar.mkC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
