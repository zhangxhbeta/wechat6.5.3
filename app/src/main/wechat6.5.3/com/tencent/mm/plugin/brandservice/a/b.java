package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.storage.u;

public final class b extends a {
    public u euW;
    public BizInfo exj;
    public String userName;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.userName == null) {
                throw new a.a.a.b("Not all required fields were included: userName");
            } else if (this.userName == null) {
                return 0;
            } else {
                aVar.e(1, this.userName);
                return 0;
            }
        } else if (i == 1) {
            if (this.userName != null) {
                r0 = a.a.a.b.b.a.f(1, this.userName) + 0;
            } else {
                r0 = 0;
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.userName != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: userName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.userName = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
