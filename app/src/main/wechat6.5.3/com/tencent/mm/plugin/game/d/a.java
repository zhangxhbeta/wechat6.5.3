package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.ba.a {
    public d gkt;
    public String gku;
    public String gkv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gku == null) {
                throw new b("Not all required fields were included: AdURL");
            }
            if (this.gkt != null) {
                aVar.dX(1, this.gkt.aHr());
                this.gkt.a(aVar);
            }
            if (this.gku != null) {
                aVar.e(2, this.gku);
            }
            if (this.gkv == null) {
                return 0;
            }
            aVar.e(3, this.gkv);
            return 0;
        } else if (i == 1) {
            if (this.gkt != null) {
                r0 = a.a.a.a.dU(1, this.gkt.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gku != null) {
                r0 += a.a.a.b.b.a.f(2, this.gku);
            }
            if (this.gkv != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkv);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gku != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AdURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar5, dVar, com.tencent.mm.ba.a.a(aVar5))) {
                        }
                        aVar4.gkt = dVar;
                    }
                    return 0;
                case 2:
                    aVar4.gku = aVar3.pMj.readString();
                    return 0;
                case 3:
                    aVar4.gkv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
