package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class cb extends a {
    public String glo;
    public LinkedList<String> goe = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.goe);
            if (this.glo != null) {
                aVar.e(2, this.glo);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 1, this.goe) + 0;
            if (this.glo != null) {
                return r0 + a.a.a.b.b.a.f(2, this.glo);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.goe.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            cb cbVar = (cb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbVar.goe.add(aVar3.pMj.readString());
                    return 0;
                case 2:
                    cbVar.glo = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
