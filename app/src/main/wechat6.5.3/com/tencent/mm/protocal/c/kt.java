package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class kt extends a {
    public int efp;
    public int fvo;
    public int mfB;
    public LinkedList<afe> miT = new LinkedList();
    public String mio;
    public String mip;
    public String miq;
    public String mir;
    public String mis;
    public int mnk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.fvo);
            if (this.miq != null) {
                aVar.e(7, this.miq);
            }
            aVar.dV(2, this.mfB);
            aVar.dV(3, this.mnk);
            aVar.d(4, 8, this.miT);
            if (this.mio != null) {
                aVar.e(5, this.mio);
            }
            if (this.mip != null) {
                aVar.e(6, this.mip);
            }
            if (this.mir != null) {
                aVar.e(8, this.mir);
            }
            if (this.mis != null) {
                aVar.e(9, this.mis);
            }
            aVar.dV(10, this.efp);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.fvo) + 0;
            if (this.miq != null) {
                r0 += a.a.a.b.b.a.f(7, this.miq);
            }
            r0 = ((r0 + a.a.a.a.dS(2, this.mfB)) + a.a.a.a.dS(3, this.mnk)) + a.a.a.a.c(4, 8, this.miT);
            if (this.mio != null) {
                r0 += a.a.a.b.b.a.f(5, this.mio);
            }
            if (this.mip != null) {
                r0 += a.a.a.b.b.a.f(6, this.mip);
            }
            if (this.mir != null) {
                r0 += a.a.a.b.b.a.f(8, this.mir);
            }
            if (this.mis != null) {
                r0 += a.a.a.b.b.a.f(9, this.mis);
            }
            return r0 + a.a.a.a.dS(10, this.efp);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.miT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            kt ktVar = (kt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ktVar.fvo = aVar3.pMj.mH();
                    return 0;
                case 2:
                    ktVar.mfB = aVar3.pMj.mH();
                    return 0;
                case 3:
                    ktVar.mnk = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_afe = new afe();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_afe.a(aVar4, com_tencent_mm_protocal_c_afe, a.a(aVar4))) {
                        }
                        ktVar.miT.add(com_tencent_mm_protocal_c_afe);
                    }
                    return 0;
                case 5:
                    ktVar.mio = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ktVar.mip = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ktVar.miq = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ktVar.mir = aVar3.pMj.readString();
                    return 0;
                case 9:
                    ktVar.mis = aVar3.pMj.readString();
                    return 0;
                case 10:
                    ktVar.efp = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
