package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aci extends a {
    public int efj;
    public String gkB;
    public String glb;
    public String mjT;
    public String mjV;
    public String mpC;
    public String mqB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mqB != null) {
                aVar.e(1, this.mqB);
            }
            if (this.gkB != null) {
                aVar.e(2, this.gkB);
            }
            aVar.dV(3, this.efj);
            if (this.mpC != null) {
                aVar.e(4, this.mpC);
            }
            if (this.mjV != null) {
                aVar.e(5, this.mjV);
            }
            if (this.mjT != null) {
                aVar.e(6, this.mjT);
            }
            if (this.glb == null) {
                return 0;
            }
            aVar.e(7, this.glb);
            return 0;
        } else if (i == 1) {
            if (this.mqB != null) {
                r0 = a.a.a.b.b.a.f(1, this.mqB) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            r0 += a.a.a.a.dS(3, this.efj);
            if (this.mpC != null) {
                r0 += a.a.a.b.b.a.f(4, this.mpC);
            }
            if (this.mjV != null) {
                r0 += a.a.a.b.b.a.f(5, this.mjV);
            }
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(6, this.mjT);
            }
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(7, this.glb);
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
            aci com_tencent_mm_protocal_c_aci = (aci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aci.mqB = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aci.gkB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aci.efj = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aci.mpC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aci.mjV = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aci.mjT = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aci.glb = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
