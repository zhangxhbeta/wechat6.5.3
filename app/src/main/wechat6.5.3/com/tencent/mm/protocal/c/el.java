package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class el extends a {
    public String hMt;
    public String hMu;
    public String kLp;
    public String kNS;
    public String mfr;
    public String mfs;
    public String mft;
    public String mfu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mfr != null) {
                aVar.e(1, this.mfr);
            }
            if (this.kLp != null) {
                aVar.e(2, this.kLp);
            }
            if (this.hMt != null) {
                aVar.e(3, this.hMt);
            }
            if (this.hMu != null) {
                aVar.e(4, this.hMu);
            }
            if (this.kNS != null) {
                aVar.e(5, this.kNS);
            }
            if (this.mfs != null) {
                aVar.e(6, this.mfs);
            }
            if (this.mft != null) {
                aVar.e(7, this.mft);
            }
            if (this.mfu == null) {
                return 0;
            }
            aVar.e(8, this.mfu);
            return 0;
        } else if (i == 1) {
            if (this.mfr != null) {
                r0 = a.a.a.b.b.a.f(1, this.mfr) + 0;
            } else {
                r0 = 0;
            }
            if (this.kLp != null) {
                r0 += a.a.a.b.b.a.f(2, this.kLp);
            }
            if (this.hMt != null) {
                r0 += a.a.a.b.b.a.f(3, this.hMt);
            }
            if (this.hMu != null) {
                r0 += a.a.a.b.b.a.f(4, this.hMu);
            }
            if (this.kNS != null) {
                r0 += a.a.a.b.b.a.f(5, this.kNS);
            }
            if (this.mfs != null) {
                r0 += a.a.a.b.b.a.f(6, this.mfs);
            }
            if (this.mft != null) {
                r0 += a.a.a.b.b.a.f(7, this.mft);
            }
            if (this.mfu != null) {
                r0 += a.a.a.b.b.a.f(8, this.mfu);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            el elVar = (el) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    elVar.mfr = aVar3.pMj.readString();
                    return 0;
                case 2:
                    elVar.kLp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    elVar.hMt = aVar3.pMj.readString();
                    return 0;
                case 4:
                    elVar.hMu = aVar3.pMj.readString();
                    return 0;
                case 5:
                    elVar.kNS = aVar3.pMj.readString();
                    return 0;
                case 6:
                    elVar.mfs = aVar3.pMj.readString();
                    return 0;
                case 7:
                    elVar.mft = aVar3.pMj.readString();
                    return 0;
                case 8:
                    elVar.mfu = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
