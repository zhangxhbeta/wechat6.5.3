package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class amy extends a {
    public int mNn;
    public float mjM;
    public float mjN;
    public int mrA;
    public String mrB;
    public String mrC;
    public int mrD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.j(1, this.mjM);
            aVar.j(2, this.mjN);
            aVar.dV(3, this.mrA);
            if (this.mrB != null) {
                aVar.e(4, this.mrB);
            }
            if (this.mrC != null) {
                aVar.e(5, this.mrC);
            }
            aVar.dV(6, this.mrD);
            aVar.dV(7, this.mNn);
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.b.b.a.cw(1) + 4) + 0) + (a.a.a.b.b.a.cw(2) + 4)) + a.a.a.a.dS(3, this.mrA);
            if (this.mrB != null) {
                r0 += a.a.a.b.b.a.f(4, this.mrB);
            }
            if (this.mrC != null) {
                r0 += a.a.a.b.b.a.f(5, this.mrC);
            }
            return (r0 + a.a.a.a.dS(6, this.mrD)) + a.a.a.a.dS(7, this.mNn);
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
            amy com_tencent_mm_protocal_c_amy = (amy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_amy.mjM = aVar3.pMj.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amy.mjN = aVar3.pMj.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amy.mrA = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amy.mrB = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_amy.mrC = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_amy.mrD = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_amy.mNn = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
