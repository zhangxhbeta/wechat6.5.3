package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class ayf extends a {
    public String content;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.type == null) {
                throw new b("Not all required fields were included: type");
            }
            if (this.type != null) {
                aVar.e(1, this.type);
            }
            if (this.content == null) {
                return 0;
            }
            aVar.e(2, this.content);
            return 0;
        } else if (i == 1) {
            if (this.type != null) {
                r0 = a.a.a.b.b.a.f(1, this.type) + 0;
            } else {
                r0 = 0;
            }
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(2, this.content);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.type != null) {
                return 0;
            }
            throw new b("Not all required fields were included: type");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ayf com_tencent_mm_protocal_c_ayf = (ayf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ayf.type = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayf.content = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
