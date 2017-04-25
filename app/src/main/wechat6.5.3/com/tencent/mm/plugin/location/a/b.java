package com.tencent.mm.plugin.location.a;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> gRH = new LinkedList();
    public String gRI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.gRH);
            if (this.gRI != null) {
                aVar.e(2, this.gRI);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.gRH) + 0;
            if (this.gRI != null) {
                return r0 + a.a.a.b.b.a.f(2, this.gRI);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gRH.clear();
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a aVar4 = new a();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.gRH.add(aVar4);
                    }
                    return 0;
                case 2:
                    bVar.gRI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
