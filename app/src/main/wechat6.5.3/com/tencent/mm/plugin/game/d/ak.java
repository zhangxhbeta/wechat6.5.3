package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ak extends a {
    public String desc;
    public LinkedList<as> eEK = new LinkedList();
    public String gmB;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gmB != null) {
                aVar.e(1, this.gmB);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.d(3, 8, this.eEK);
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.title == null) {
                return 0;
            }
            aVar.e(5, this.title);
            return 0;
        } else if (i == 1) {
            if (this.gmB != null) {
                r0 = a.a.a.b.b.a.f(1, this.gmB) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            r0 += a.a.a.a.c(3, 8, this.eEK);
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(4, this.url);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(5, this.title);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.eEK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            ak akVar = (ak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    akVar.gmB = aVar3.pMj.readString();
                    return 0;
                case 2:
                    akVar.desc = aVar3.pMj.readString();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        as asVar = new as();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = asVar.a(aVar4, asVar, a.a(aVar4))) {
                        }
                        akVar.eEK.add(asVar);
                    }
                    return 0;
                case 4:
                    akVar.url = aVar3.pMj.readString();
                    return 0;
                case 5:
                    akVar.title = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
