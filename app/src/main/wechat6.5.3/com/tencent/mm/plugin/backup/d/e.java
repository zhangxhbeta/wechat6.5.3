package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class e extends a {
    public LinkedList<String> eex = new LinkedList();
    public LinkedList<Long> eey = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.eex);
            aVar.d(2, 3, this.eey);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 1, this.eex) + 0) + a.a.a.a.c(2, 3, this.eey);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.eex.clear();
                this.eey.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                e eVar = (e) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        eVar.eex.add(aVar3.pMj.readString());
                        return 0;
                    case 2:
                        eVar.eey.add(Long.valueOf(aVar3.pMj.mI()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
