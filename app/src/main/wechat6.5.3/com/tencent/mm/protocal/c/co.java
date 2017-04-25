package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class co extends a {
    public int efm;
    public String glj;
    public String gom;
    public String gon;
    public int hNS;
    public String hQP;
    public String mbZ;
    public int mcM;
    public String mcN;
    public are mcO;
    public int mcP;
    public int mcQ;
    public String mcR;
    public String mcS;
    public String mcT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gon != null) {
                aVar.e(1, this.gon);
            }
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            aVar.dV(3, this.mcM);
            if (this.gom != null) {
                aVar.e(4, this.gom);
            }
            aVar.dV(5, this.efm);
            if (this.hQP != null) {
                aVar.e(6, this.hQP);
            }
            aVar.dV(7, this.hNS);
            if (this.mcN != null) {
                aVar.e(8, this.mcN);
            }
            if (this.mcO != null) {
                aVar.dX(9, this.mcO.aHr());
                this.mcO.a(aVar);
            }
            aVar.dV(10, this.mcP);
            aVar.dV(11, this.mcQ);
            if (this.mbZ != null) {
                aVar.e(12, this.mbZ);
            }
            if (this.mcR != null) {
                aVar.e(13, this.mcR);
            }
            if (this.mcS != null) {
                aVar.e(14, this.mcS);
            }
            if (this.mcT == null) {
                return 0;
            }
            aVar.e(15, this.mcT);
            return 0;
        } else if (i == 1) {
            if (this.gon != null) {
                r0 = a.a.a.b.b.a.f(1, this.gon) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            r0 += a.a.a.a.dS(3, this.mcM);
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(4, this.gom);
            }
            r0 += a.a.a.a.dS(5, this.efm);
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(6, this.hQP);
            }
            r0 += a.a.a.a.dS(7, this.hNS);
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(8, this.mcN);
            }
            if (this.mcO != null) {
                r0 += a.a.a.a.dU(9, this.mcO.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(10, this.mcP)) + a.a.a.a.dS(11, this.mcQ);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(12, this.mbZ);
            }
            if (this.mcR != null) {
                r0 += a.a.a.b.b.a.f(13, this.mcR);
            }
            if (this.mcS != null) {
                r0 += a.a.a.b.b.a.f(14, this.mcS);
            }
            if (this.mcT != null) {
                r0 += a.a.a.b.b.a.f(15, this.mcT);
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
            co coVar = (co) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    coVar.gon = aVar3.pMj.readString();
                    return 0;
                case 2:
                    coVar.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    coVar.mcM = aVar3.pMj.mH();
                    return 0;
                case 4:
                    coVar.gom = aVar3.pMj.readString();
                    return 0;
                case 5:
                    coVar.efm = aVar3.pMj.mH();
                    return 0;
                case 6:
                    coVar.hQP = aVar3.pMj.readString();
                    return 0;
                case 7:
                    coVar.hNS = aVar3.pMj.mH();
                    return 0;
                case 8:
                    coVar.mcN = aVar3.pMj.readString();
                    return 0;
                case 9:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        coVar.mcO = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 10:
                    coVar.mcP = aVar3.pMj.mH();
                    return 0;
                case 11:
                    coVar.mcQ = aVar3.pMj.mH();
                    return 0;
                case 12:
                    coVar.mbZ = aVar3.pMj.readString();
                    return 0;
                case 13:
                    coVar.mcR = aVar3.pMj.readString();
                    return 0;
                case 14:
                    coVar.mcS = aVar3.pMj.readString();
                    return 0;
                case 15:
                    coVar.mcT = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
