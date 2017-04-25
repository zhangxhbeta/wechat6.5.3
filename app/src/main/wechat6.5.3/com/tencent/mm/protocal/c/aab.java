package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import java.util.LinkedList;

public final class aab extends aqx {
    public String aHM;
    public String fwg;
    public boolean fwp;
    public String mBA;
    public String mBB;
    public LinkedList<ig> mBC = new LinkedList();
    public String mBv;
    public bjp mBw;
    public LinkedList<bjr> mBx = new LinkedList();
    public LinkedList<bjq> mBy = new LinkedList();
    public LinkedList<String> mBz = new LinkedList();
    public LinkedList<qs> mbS = new LinkedList();
    public LinkedList<ayh> mcq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mBv == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.fwg == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.mBw == null) {
                throw new b("Not all required fields were included: rankdesc");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mBv != null) {
                    aVar.e(2, this.mBv);
                }
                if (this.fwg != null) {
                    aVar.e(3, this.fwg);
                }
                if (this.mBw != null) {
                    aVar.dX(4, this.mBw.aHr());
                    this.mBw.a(aVar);
                }
                aVar.d(5, 8, this.mBx);
                aVar.d(6, 8, this.mBy);
                if (this.aHM != null) {
                    aVar.e(7, this.aHM);
                }
                aVar.d(8, 1, this.mBz);
                if (this.mBA != null) {
                    aVar.e(9, this.mBA);
                }
                if (this.mBB != null) {
                    aVar.e(10, this.mBB);
                }
                aVar.d(14, 8, this.mcq);
                aVar.d(15, 8, this.mbS);
                aVar.ab(16, this.fwp);
                aVar.d(17, 8, this.mBC);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mBv != null) {
                r0 += a.a.a.b.b.a.f(2, this.mBv);
            }
            if (this.fwg != null) {
                r0 += a.a.a.b.b.a.f(3, this.fwg);
            }
            if (this.mBw != null) {
                r0 += a.a.a.a.dU(4, this.mBw.aHr());
            }
            r0 = (r0 + a.a.a.a.c(5, 8, this.mBx)) + a.a.a.a.c(6, 8, this.mBy);
            if (this.aHM != null) {
                r0 += a.a.a.b.b.a.f(7, this.aHM);
            }
            r0 += a.a.a.a.c(8, 1, this.mBz);
            if (this.mBA != null) {
                r0 += a.a.a.b.b.a.f(9, this.mBA);
            }
            if (this.mBB != null) {
                r0 += a.a.a.b.b.a.f(10, this.mBB);
            }
            return (((r0 + a.a.a.a.c(14, 8, this.mcq)) + a.a.a.a.c(15, 8, this.mbS)) + (a.a.a.b.b.a.cw(16) + 1)) + a.a.a.a.c(17, 8, this.mBC);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mBx.clear();
            this.mBy.clear();
            this.mBz.clear();
            this.mcq.clear();
            this.mbS.clear();
            this.mBC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mBv == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.fwg == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.mBw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankdesc");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aab com_tencent_mm_protocal_c_aab = (aab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
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
                        com_tencent_mm_protocal_c_aab.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aab.mBv = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aab.fwg = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bjp com_tencent_mm_protocal_c_bjp = new bjp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bjp.a(aVar4, com_tencent_mm_protocal_c_bjp, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aab.mBw = com_tencent_mm_protocal_c_bjp;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bjr com_tencent_mm_protocal_c_bjr = new bjr();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bjr.a(aVar4, com_tencent_mm_protocal_c_bjr, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aab.mBx.add(com_tencent_mm_protocal_c_bjr);
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bjq com_tencent_mm_protocal_c_bjq = new bjq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bjq.a(aVar4, com_tencent_mm_protocal_c_bjq, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aab.mBy.add(com_tencent_mm_protocal_c_bjq);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aab.aHM = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aab.mBz.add(aVar3.pMj.readString());
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aab.mBA = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aab.mBB = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ayh com_tencent_mm_protocal_c_ayh = new ayh();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ayh.a(aVar4, com_tencent_mm_protocal_c_ayh, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aab.mcq.add(com_tencent_mm_protocal_c_ayh);
                    }
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qs qsVar = new qs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qsVar.a(aVar4, qsVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aab.mbS.add(qsVar);
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aab.fwp = aVar3.bQJ();
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ig igVar = new ig();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = igVar.a(aVar4, igVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aab.mBC.add(igVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
