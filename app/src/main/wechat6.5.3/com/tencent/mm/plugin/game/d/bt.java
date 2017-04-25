package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bt extends a {
    public String aXz;
    public String gkT;
    public d gkt;
    public String gnQ;
    public String gnp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkt != null) {
                aVar.dX(1, this.gkt.aHr());
                this.gkt.a(aVar);
            }
            if (this.gnQ != null) {
                aVar.e(2, this.gnQ);
            }
            if (this.gnp != null) {
                aVar.e(3, this.gnp);
            }
            if (this.aXz != null) {
                aVar.e(4, this.aXz);
            }
            if (this.gkT == null) {
                return 0;
            }
            aVar.e(5, this.gkT);
            return 0;
        } else if (i == 1) {
            if (this.gkt != null) {
                r0 = a.a.a.a.dU(1, this.gkt.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnQ);
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(3, this.gnp);
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(4, this.aXz);
            }
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkT);
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
            bt btVar = (bt) objArr[1];
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
                        btVar.gkt = dVar;
                    }
                    return 0;
                case 2:
                    btVar.gnQ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    btVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 4:
                    btVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 5:
                    btVar.gkT = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
