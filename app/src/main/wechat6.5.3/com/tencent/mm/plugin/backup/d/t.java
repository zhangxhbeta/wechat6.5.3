package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class t extends a {
    public String eer;
    public long efv;
    public long efw;
    public String efx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eer == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.efx == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else {
                if (this.eer != null) {
                    aVar.e(1, this.eer);
                }
                aVar.C(2, this.efv);
                aVar.C(3, this.efw);
                if (this.efx == null) {
                    return 0;
                }
                aVar.e(4, this.efx);
                return 0;
            }
        } else if (i == 1) {
            if (this.eer != null) {
                r0 = a.a.a.b.b.a.f(1, this.eer) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.B(2, this.efv)) + a.a.a.a.B(3, this.efw);
            if (this.efx != null) {
                r0 += a.a.a.b.b.a.f(4, this.efx);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.eer == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.efx != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MsgDataID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.eer = aVar3.pMj.readString();
                    return 0;
                case 2:
                    tVar.efv = aVar3.pMj.mI();
                    return 0;
                case 3:
                    tVar.efw = aVar3.pMj.mI();
                    return 0;
                case 4:
                    tVar.efx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
