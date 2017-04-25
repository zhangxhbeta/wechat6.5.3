package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ce extends a {
    public String gkV;
    public d gkt;
    public String goi;
    public String goj;
    public String gok;
    public String gol;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkt == null) {
                throw new b("Not all required fields were included: AppItem");
            }
            if (this.gkt != null) {
                aVar.dX(1, this.gkt.aHr());
                this.gkt.a(aVar);
            }
            if (this.goi != null) {
                aVar.e(2, this.goi);
            }
            if (this.goj != null) {
                aVar.e(3, this.goj);
            }
            if (this.gok != null) {
                aVar.e(4, this.gok);
            }
            if (this.gol != null) {
                aVar.e(5, this.gol);
            }
            if (this.gkV == null) {
                return 0;
            }
            aVar.e(6, this.gkV);
            return 0;
        } else if (i == 1) {
            if (this.gkt != null) {
                r0 = a.a.a.a.dU(1, this.gkt.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.goi != null) {
                r0 += a.a.a.b.b.a.f(2, this.goi);
            }
            if (this.goj != null) {
                r0 += a.a.a.b.b.a.f(3, this.goj);
            }
            if (this.gok != null) {
                r0 += a.a.a.b.b.a.f(4, this.gok);
            }
            if (this.gol != null) {
                r0 += a.a.a.b.b.a.f(5, this.gol);
            }
            if (this.gkV != null) {
                r0 += a.a.a.b.b.a.f(6, this.gkV);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkt != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppItem");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ce ceVar = (ce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        ceVar.gkt = dVar;
                    }
                    return 0;
                case 2:
                    ceVar.goi = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ceVar.goj = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ceVar.gok = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ceVar.gol = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ceVar.gkV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
