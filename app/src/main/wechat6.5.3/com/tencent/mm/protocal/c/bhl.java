package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bhl extends a {
    public String bLk;
    public String eeB;
    public int mcM;
    public String mnR;
    public String ncr;
    public String ncs;
    public String nct;
    public String ncu;
    public String ncv;
    public String ncw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncr == null) {
                throw new b("Not all required fields were included: LocalNodeId");
            }
            if (this.ncr != null) {
                aVar.e(1, this.ncr);
            }
            if (this.eeB != null) {
                aVar.e(2, this.eeB);
            }
            if (this.ncs != null) {
                aVar.e(3, this.ncs);
            }
            if (this.bLk != null) {
                aVar.e(4, this.bLk);
            }
            if (this.nct != null) {
                aVar.e(5, this.nct);
            }
            if (this.mnR != null) {
                aVar.e(6, this.mnR);
            }
            if (this.ncu != null) {
                aVar.e(7, this.ncu);
            }
            if (this.ncv != null) {
                aVar.e(8, this.ncv);
            }
            if (this.ncw != null) {
                aVar.e(9, this.ncw);
            }
            aVar.dV(10, this.mcM);
            return 0;
        } else if (i == 1) {
            if (this.ncr != null) {
                r0 = a.a.a.b.b.a.f(1, this.ncr) + 0;
            } else {
                r0 = 0;
            }
            if (this.eeB != null) {
                r0 += a.a.a.b.b.a.f(2, this.eeB);
            }
            if (this.ncs != null) {
                r0 += a.a.a.b.b.a.f(3, this.ncs);
            }
            if (this.bLk != null) {
                r0 += a.a.a.b.b.a.f(4, this.bLk);
            }
            if (this.nct != null) {
                r0 += a.a.a.b.b.a.f(5, this.nct);
            }
            if (this.mnR != null) {
                r0 += a.a.a.b.b.a.f(6, this.mnR);
            }
            if (this.ncu != null) {
                r0 += a.a.a.b.b.a.f(7, this.ncu);
            }
            if (this.ncv != null) {
                r0 += a.a.a.b.b.a.f(8, this.ncv);
            }
            if (this.ncw != null) {
                r0 += a.a.a.b.b.a.f(9, this.ncw);
            }
            return r0 + a.a.a.a.dS(10, this.mcM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LocalNodeId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhl com_tencent_mm_protocal_c_bhl = (bhl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bhl.ncr = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhl.eeB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhl.ncs = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhl.bLk = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhl.nct = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhl.mnR = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhl.ncu = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhl.ncv = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhl.ncw = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bhl.mcM = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
