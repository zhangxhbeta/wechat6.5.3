package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class y extends a {
    public String eer;
    public LinkedList<Long> efG = new LinkedList();
    public LinkedList<String> efH = new LinkedList();
    public LinkedList<String> efI = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eer == null) {
                throw new b("Not all required fields were included: BakChatName");
            }
            aVar.d(1, 3, this.efG);
            aVar.d(2, 1, this.efH);
            aVar.d(3, 1, this.efI);
            if (this.eer != null) {
                aVar.e(4, this.eer);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.c(1, 3, this.efG) + 0) + a.a.a.a.c(2, 1, this.efH)) + a.a.a.a.c(3, 1, this.efI);
            if (this.eer != null) {
                return r0 + a.a.a.b.b.a.f(4, this.eer);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.efG.clear();
            this.efH.clear();
            this.efI.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.eer != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BakChatName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.efG.add(Long.valueOf(aVar3.pMj.mI()));
                    return 0;
                case 2:
                    yVar.efH.add(aVar3.pMj.readString());
                    return 0;
                case 3:
                    yVar.efI.add(aVar3.pMj.readString());
                    return 0;
                case 4:
                    yVar.eer = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
