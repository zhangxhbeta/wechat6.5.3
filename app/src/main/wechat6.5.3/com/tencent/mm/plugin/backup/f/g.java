package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ba.a;

public final class g extends a {
    public String bNv;
    public int ehM;
    public long ehN;
    public int ehy;
    public String mediaId;
    public String path;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.ehM);
            if (this.bNv != null) {
                aVar.e(2, this.bNv);
            }
            if (this.mediaId != null) {
                aVar.e(3, this.mediaId);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            aVar.dV(5, this.type);
            aVar.dV(6, this.ehy);
            aVar.C(7, this.ehN);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.ehM) + 0;
            if (this.bNv != null) {
                r0 += a.a.a.b.b.a.f(2, this.bNv);
            }
            if (this.mediaId != null) {
                r0 += a.a.a.b.b.a.f(3, this.mediaId);
            }
            if (this.path != null) {
                r0 += a.a.a.b.b.a.f(4, this.path);
            }
            return ((r0 + a.a.a.a.dS(5, this.type)) + a.a.a.a.dS(6, this.ehy)) + a.a.a.a.B(7, this.ehN);
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
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.ehM = aVar3.pMj.mH();
                    return 0;
                case 2:
                    gVar.bNv = aVar3.pMj.readString();
                    return 0;
                case 3:
                    gVar.mediaId = aVar3.pMj.readString();
                    return 0;
                case 4:
                    gVar.path = aVar3.pMj.readString();
                    return 0;
                case 5:
                    gVar.type = aVar3.pMj.mH();
                    return 0;
                case 6:
                    gVar.ehy = aVar3.pMj.mH();
                    return 0;
                case 7:
                    gVar.ehN = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
