package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class dc extends a {
    public String bax;
    public String cTj;
    public String mdG;
    public LinkedList<String> mdH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdG == null) {
                throw new b("Not all required fields were included: roomname");
            }
            if (this.mdG != null) {
                aVar.e(1, this.mdG);
            }
            if (this.bax != null) {
                aVar.e(2, this.bax);
            }
            if (this.cTj != null) {
                aVar.e(3, this.cTj);
            }
            aVar.d(4, 1, this.mdH);
            return 0;
        } else if (i == 1) {
            if (this.mdG != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdG) + 0;
            } else {
                r0 = 0;
            }
            if (this.bax != null) {
                r0 += a.a.a.b.b.a.f(2, this.bax);
            }
            if (this.cTj != null) {
                r0 += a.a.a.b.b.a.f(3, this.cTj);
            }
            return r0 + a.a.a.a.c(4, 1, this.mdH);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.mdH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: roomname");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dc dcVar = (dc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcVar.mdG = aVar3.pMj.readString();
                    return 0;
                case 2:
                    dcVar.bax = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dcVar.cTj = aVar3.pMj.readString();
                    return 0;
                case 4:
                    dcVar.mdH.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
