package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;

public final class m extends a {
    public long eeK;
    public long efh;
    public long efi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.eeK);
            aVar.C(2, this.efh);
            aVar.C(3, this.efi);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.B(1, this.eeK) + 0) + a.a.a.a.B(2, this.efh)) + a.a.a.a.B(3, this.efi);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
                m mVar = (m) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        mVar.eeK = aVar3.pMj.mI();
                        return 0;
                    case 2:
                        mVar.efh = aVar3.pMj.mI();
                        return 0;
                    case 3:
                        mVar.efi = aVar3.pMj.mI();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
