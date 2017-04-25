package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class hs extends a {
    public String mhJ;
    public LinkedList<String> miD = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhJ == null) {
                throw new b("Not all required fields were included: brand_user_name");
            }
            if (this.mhJ != null) {
                aVar.e(2, this.mhJ);
            }
            aVar.d(3, 1, this.miD);
            return 0;
        } else if (i == 1) {
            if (this.mhJ != null) {
                r0 = a.a.a.b.b.a.f(2, this.mhJ) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(3, 1, this.miD);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.miD.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mhJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: brand_user_name");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hs hsVar = (hs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    hsVar.mhJ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    hsVar.miD.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
