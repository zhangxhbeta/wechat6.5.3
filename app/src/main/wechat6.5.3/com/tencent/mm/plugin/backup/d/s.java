package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class s extends a {
    public String eer;
    public LinkedList<String> efg = new LinkedList();
    public long efv;
    public long efw;
    public String efx;
    public String efy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eer == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.efx == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.efy == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.eer != null) {
                    aVar.e(1, this.eer);
                }
                aVar.C(2, this.efv);
                aVar.C(3, this.efw);
                if (this.efx != null) {
                    aVar.e(4, this.efx);
                }
                if (this.efy != null) {
                    aVar.e(5, this.efy);
                }
                aVar.d(6, 1, this.efg);
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
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(5, this.efy);
            }
            return r0 + a.a.a.a.c(6, 1, this.efg);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.efg.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.eer == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.efx == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.efy != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sVar.eer = aVar3.pMj.readString();
                    return 0;
                case 2:
                    sVar.efv = aVar3.pMj.mI();
                    return 0;
                case 3:
                    sVar.efw = aVar3.pMj.mI();
                    return 0;
                case 4:
                    sVar.efx = aVar3.pMj.readString();
                    return 0;
                case 5:
                    sVar.efy = aVar3.pMj.readString();
                    return 0;
                case 6:
                    sVar.efg.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
