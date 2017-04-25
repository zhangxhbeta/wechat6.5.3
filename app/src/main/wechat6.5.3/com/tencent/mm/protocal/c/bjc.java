package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bjc extends a {
    public String gkV;
    public String mbH;
    public LinkedList<jf> ndA = new LinkedList();
    public int ndt;
    public avc ndu;
    public cq ndv;
    public ajt ndw;
    public cf ndx;
    public cp ndy;
    public cj ndz;
    public String pRC;
    public String pRD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbH != null) {
                aVar.e(1, this.mbH);
            }
            aVar.dV(2, this.ndt);
            if (this.gkV != null) {
                aVar.e(3, this.gkV);
            }
            if (this.ndu != null) {
                aVar.dX(4, this.ndu.aHr());
                this.ndu.a(aVar);
            }
            if (this.ndv != null) {
                aVar.dX(5, this.ndv.aHr());
                this.ndv.a(aVar);
            }
            if (this.ndw != null) {
                aVar.dX(6, this.ndw.aHr());
                this.ndw.a(aVar);
            }
            if (this.ndx != null) {
                aVar.dX(7, this.ndx.aHr());
                this.ndx.a(aVar);
            }
            if (this.ndy != null) {
                aVar.dX(8, this.ndy.aHr());
                this.ndy.a(aVar);
            }
            if (this.ndz != null) {
                aVar.dX(11, this.ndz.aHr());
                this.ndz.a(aVar);
            }
            aVar.d(12, 8, this.ndA);
            if (this.pRC != null) {
                aVar.e(13, this.pRC);
            }
            if (this.pRD == null) {
                return 0;
            }
            aVar.e(14, this.pRD);
            return 0;
        } else if (i == 1) {
            if (this.mbH != null) {
                r0 = a.a.a.b.b.a.f(1, this.mbH) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.ndt);
            if (this.gkV != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkV);
            }
            if (this.ndu != null) {
                r0 += a.a.a.a.dU(4, this.ndu.aHr());
            }
            if (this.ndv != null) {
                r0 += a.a.a.a.dU(5, this.ndv.aHr());
            }
            if (this.ndw != null) {
                r0 += a.a.a.a.dU(6, this.ndw.aHr());
            }
            if (this.ndx != null) {
                r0 += a.a.a.a.dU(7, this.ndx.aHr());
            }
            if (this.ndy != null) {
                r0 += a.a.a.a.dU(8, this.ndy.aHr());
            }
            if (this.ndz != null) {
                r0 += a.a.a.a.dU(11, this.ndz.aHr());
            }
            r0 += a.a.a.a.c(12, 8, this.ndA);
            if (this.pRC != null) {
                r0 += a.a.a.b.b.a.f(13, this.pRC);
            }
            if (this.pRD != null) {
                r0 += a.a.a.b.b.a.f(14, this.pRD);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ndA.clear();
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
            bjc com_tencent_mm_protocal_c_bjc = (bjc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a com_tencent_mm_protocal_c_avc;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bjc.mbH = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjc.ndt = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjc.gkV = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avc = new avc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avc.a(aVar4, com_tencent_mm_protocal_c_avc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjc.ndu = com_tencent_mm_protocal_c_avc;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avc = new cq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avc.a(aVar4, com_tencent_mm_protocal_c_avc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjc.ndv = com_tencent_mm_protocal_c_avc;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avc = new ajt();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avc.a(aVar4, com_tencent_mm_protocal_c_avc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjc.ndw = com_tencent_mm_protocal_c_avc;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avc = new cf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avc.a(aVar4, com_tencent_mm_protocal_c_avc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjc.ndx = com_tencent_mm_protocal_c_avc;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avc = new cp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avc.a(aVar4, com_tencent_mm_protocal_c_avc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjc.ndy = com_tencent_mm_protocal_c_avc;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avc = new cj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avc.a(aVar4, com_tencent_mm_protocal_c_avc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjc.ndz = com_tencent_mm_protocal_c_avc;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avc = new jf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avc.a(aVar4, com_tencent_mm_protocal_c_avc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjc.ndA.add(com_tencent_mm_protocal_c_avc);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bjc.pRC = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bjc.pRD = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
