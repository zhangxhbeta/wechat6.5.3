package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class axr extends a {
    public int mUJ;
    public int mUK;
    public int mUL;
    public beg mUM;
    public int mUN;
    public int mUO;
    public int mUP;
    public int mUQ;
    public LinkedList<Integer> mUR = new LinkedList();
    public int mUS;
    public LinkedList<Integer> mUT = new LinkedList();
    public int mUU;
    public LinkedList<Integer> mUV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mUM == null) {
                throw new b("Not all required fields were included: Addr");
            }
            aVar.dV(1, this.mUJ);
            aVar.dV(2, this.mUK);
            aVar.dV(3, this.mUL);
            if (this.mUM != null) {
                aVar.dX(4, this.mUM.aHr());
                this.mUM.a(aVar);
            }
            aVar.dV(5, this.mUN);
            aVar.dV(6, this.mUO);
            aVar.dV(7, this.mUP);
            aVar.dV(8, this.mUQ);
            aVar.c(9, this.mUR);
            aVar.dV(10, this.mUS);
            aVar.c(11, this.mUT);
            aVar.dV(12, this.mUU);
            aVar.c(13, this.mUV);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mUJ) + 0) + a.a.a.a.dS(2, this.mUK)) + a.a.a.a.dS(3, this.mUL);
            if (this.mUM != null) {
                r0 += a.a.a.a.dU(4, this.mUM.aHr());
            }
            return ((((((((r0 + a.a.a.a.dS(5, this.mUN)) + a.a.a.a.dS(6, this.mUO)) + a.a.a.a.dS(7, this.mUP)) + a.a.a.a.dS(8, this.mUQ)) + a.a.a.a.b(9, this.mUR)) + a.a.a.a.dS(10, this.mUS)) + a.a.a.a.b(11, this.mUT)) + a.a.a.a.dS(12, this.mUU)) + a.a.a.a.b(13, this.mUV);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mUR.clear();
            this.mUT.clear();
            this.mUV.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mUM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axr com_tencent_mm_protocal_c_axr = (axr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_axr.mUJ = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axr.mUK = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axr.mUL = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        beg com_tencent_mm_protocal_c_beg = new beg();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_beg.a(aVar4, com_tencent_mm_protocal_c_beg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axr.mUM = com_tencent_mm_protocal_c_beg;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axr.mUN = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axr.mUO = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axr.mUP = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axr.mUQ = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axr.mUR = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axr.mUS = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_axr.mUT = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_axr.mUU = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_axr.mUV = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
