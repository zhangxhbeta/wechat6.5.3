package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bjk extends a {
    public String gop;
    public String gor;
    public String gos;
    public int got;
    public String mhw;
    public int ndR;
    public String ndS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.ndR);
            if (this.mhw != null) {
                aVar.e(2, this.mhw);
            }
            if (this.gop != null) {
                aVar.e(3, this.gop);
            }
            if (this.ndS != null) {
                aVar.e(4, this.ndS);
            }
            if (this.gor != null) {
                aVar.e(5, this.gor);
            }
            if (this.gos != null) {
                aVar.e(6, this.gos);
            }
            aVar.dV(7, this.got);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.ndR) + 0;
            if (this.mhw != null) {
                r0 += a.a.a.b.b.a.f(2, this.mhw);
            }
            if (this.gop != null) {
                r0 += a.a.a.b.b.a.f(3, this.gop);
            }
            if (this.ndS != null) {
                r0 += a.a.a.b.b.a.f(4, this.ndS);
            }
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(5, this.gor);
            }
            if (this.gos != null) {
                r0 += a.a.a.b.b.a.f(6, this.gos);
            }
            return r0 + a.a.a.a.dS(7, this.got);
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
            bjk com_tencent_mm_protocal_c_bjk = (bjk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bjk.ndR = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjk.mhw = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjk.gop = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjk.ndS = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjk.gor = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjk.gos = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjk.got = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
