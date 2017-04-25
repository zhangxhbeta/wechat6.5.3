package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class ant extends aqx {
    public int gFM;
    public String gFN;
    public int gFS;
    public int gFY;
    public int gFZ;
    public int gGa;
    public b gGb;
    public int gGd;
    public int gGg;
    public long mNQ;
    public int mNZ;
    public int mOa;
    public LinkedList<anl> mOb = new LinkedList();
    public String mOc;
    public b mOd;
    public int mOe;
    public LinkedList<anl> meE = new LinkedList();
    public int mqS;
    public long mqT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.mqS);
            aVar.C(3, this.mqT);
            aVar.dV(4, this.mNZ);
            aVar.d(5, 8, this.meE);
            aVar.dV(6, this.mOa);
            aVar.dV(7, this.gFY);
            aVar.dV(8, this.gFZ);
            aVar.C(9, this.mNQ);
            aVar.dV(10, this.gGa);
            if (this.gGb != null) {
                aVar.b(11, this.gGb);
            }
            aVar.dV(12, this.gFS);
            aVar.dV(13, this.gFM);
            if (this.gFN != null) {
                aVar.e(14, this.gFN);
            }
            aVar.dV(15, this.gGd);
            aVar.d(16, 8, this.mOb);
            aVar.dV(17, this.gGg);
            if (this.mOc != null) {
                aVar.e(18, this.mOc);
            }
            if (this.mOd != null) {
                aVar.b(19, this.mOd);
            }
            aVar.dV(20, this.mOe);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((((r0 + a.a.a.a.dS(2, this.mqS)) + a.a.a.a.B(3, this.mqT)) + a.a.a.a.dS(4, this.mNZ)) + a.a.a.a.c(5, 8, this.meE)) + a.a.a.a.dS(6, this.mOa)) + a.a.a.a.dS(7, this.gFY)) + a.a.a.a.dS(8, this.gFZ)) + a.a.a.a.B(9, this.mNQ)) + a.a.a.a.dS(10, this.gGa);
            if (this.gGb != null) {
                r0 += a.a.a.a.a(11, this.gGb);
            }
            r0 = (r0 + a.a.a.a.dS(12, this.gFS)) + a.a.a.a.dS(13, this.gFM);
            if (this.gFN != null) {
                r0 += a.a.a.b.b.a.f(14, this.gFN);
            }
            r0 = ((r0 + a.a.a.a.dS(15, this.gGd)) + a.a.a.a.c(16, 8, this.mOb)) + a.a.a.a.dS(17, this.gGg);
            if (this.mOc != null) {
                r0 += a.a.a.b.b.a.f(18, this.mOc);
            }
            if (this.mOd != null) {
                r0 += a.a.a.a.a(19, this.mOd);
            }
            return r0 + a.a.a.a.dS(20, this.mOe);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.meE.clear();
            this.mOb.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ant com_tencent_mm_protocal_c_ant = (ant) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            anl com_tencent_mm_protocal_c_anl;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ant.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ant.mqS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ant.mqT = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ant.mNZ = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_anl = new anl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_anl.a(aVar4, com_tencent_mm_protocal_c_anl, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ant.meE.add(com_tencent_mm_protocal_c_anl);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ant.mOa = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ant.gFY = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ant.gFZ = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ant.mNQ = aVar3.pMj.mI();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ant.gGa = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ant.gGb = aVar3.bQK();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ant.gFS = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_ant.gFM = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_ant.gFN = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_ant.gGd = aVar3.pMj.mH();
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_anl = new anl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_anl.a(aVar4, com_tencent_mm_protocal_c_anl, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ant.mOb.add(com_tencent_mm_protocal_c_anl);
                    }
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ant.gGg = aVar3.pMj.mH();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ant.mOc = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ant.mOd = aVar3.bQK();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ant.mOe = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
