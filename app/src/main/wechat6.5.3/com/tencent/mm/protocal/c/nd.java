package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class nd extends a {
    public String desc;
    public String hQW;
    public LinkedList<String> mpb = new LinkedList();
    public String mpc;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.d(4, 1, this.mpb);
            if (this.hQW != null) {
                aVar.e(5, this.hQW);
            }
            if (this.mpc == null) {
                return 0;
            }
            aVar.e(6, this.mpc);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(3, this.desc);
            }
            r0 += a.a.a.a.c(4, 1, this.mpb);
            if (this.hQW != null) {
                r0 += a.a.a.b.b.a.f(5, this.hQW);
            }
            if (this.mpc != null) {
                r0 += a.a.a.b.b.a.f(6, this.mpc);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.mpb.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            nd ndVar = (nd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ndVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ndVar.url = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ndVar.desc = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ndVar.mpb.add(aVar3.pMj.readString());
                    return 0;
                case 5:
                    ndVar.hQW = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ndVar.mpc = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
