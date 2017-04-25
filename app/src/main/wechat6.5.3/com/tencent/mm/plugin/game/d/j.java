package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class j extends a {
    public String gld;
    public String gle;
    public String glf;
    public ci glg;
    public int glh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gld == null) {
                throw new b("Not all required fields were included: DownloadURL");
            }
            if (this.gld != null) {
                aVar.e(1, this.gld);
            }
            if (this.gle != null) {
                aVar.e(2, this.gle);
            }
            if (this.glf != null) {
                aVar.e(4, this.glf);
            }
            if (this.glg != null) {
                aVar.dX(5, this.glg.aHr());
                this.glg.a(aVar);
            }
            aVar.dV(6, this.glh);
            return 0;
        } else if (i == 1) {
            if (this.gld != null) {
                r0 = a.a.a.b.b.a.f(1, this.gld) + 0;
            } else {
                r0 = 0;
            }
            if (this.gle != null) {
                r0 += a.a.a.b.b.a.f(2, this.gle);
            }
            if (this.glf != null) {
                r0 += a.a.a.b.b.a.f(4, this.glf);
            }
            if (this.glg != null) {
                r0 += a.a.a.a.dU(5, this.glg.aHr());
            }
            return r0 + a.a.a.a.dS(6, this.glh);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gld != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.gld = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jVar.gle = aVar3.pMj.readString();
                    return 0;
                case 4:
                    jVar.glf = aVar3.pMj.readString();
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        ci ciVar = new ci();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ciVar.a(aVar4, ciVar, a.a(aVar4))) {
                        }
                        jVar.glg = ciVar;
                    }
                    return 0;
                case 6:
                    jVar.glh = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
