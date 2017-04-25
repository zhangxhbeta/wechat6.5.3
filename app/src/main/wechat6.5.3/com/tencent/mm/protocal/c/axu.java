package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class axu extends a {
    public int aMN;
    public String appName;
    public String mVk;
    public boolean mVl;
    public boolean mVm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mVk != null) {
                aVar.e(1, this.mVk);
            }
            if (this.appName != null) {
                aVar.e(2, this.appName);
            }
            aVar.dV(3, this.aMN);
            aVar.ab(4, this.mVl);
            aVar.ab(5, this.mVm);
            return 0;
        } else if (i == 1) {
            if (this.mVk != null) {
                r0 = a.a.a.b.b.a.f(1, this.mVk) + 0;
            } else {
                r0 = 0;
            }
            if (this.appName != null) {
                r0 += a.a.a.b.b.a.f(2, this.appName);
            }
            return ((r0 + a.a.a.a.dS(3, this.aMN)) + (a.a.a.b.b.a.cw(4) + 1)) + (a.a.a.b.b.a.cw(5) + 1);
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
            axu com_tencent_mm_protocal_c_axu = (axu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_axu.mVk = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axu.appName = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axu.aMN = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axu.mVl = aVar3.bQJ();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axu.mVm = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
