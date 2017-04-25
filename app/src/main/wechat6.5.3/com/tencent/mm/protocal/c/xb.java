package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xb extends aqx {
    public int miR;
    public are mzn;
    public int mzp;
    public LinkedList<arf> mzq = new LinkedList();
    public int mzr;
    public LinkedList<aft> mzs = new LinkedList();
    public String mzt;
    public String mzu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mzn == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mzn != null) {
                    aVar.dX(2, this.mzn.aHr());
                    this.mzn.a(aVar);
                }
                aVar.dV(3, this.mzp);
                aVar.d(4, 8, this.mzq);
                aVar.dV(5, this.mzr);
                aVar.d(6, 8, this.mzs);
                aVar.dV(7, this.miR);
                if (this.mzt != null) {
                    aVar.e(8, this.mzt);
                }
                if (this.mzu == null) {
                    return 0;
                }
                aVar.e(9, this.mzu);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mzn != null) {
                r0 += a.a.a.a.dU(2, this.mzn.aHr());
            }
            r0 = ((((r0 + a.a.a.a.dS(3, this.mzp)) + a.a.a.a.c(4, 8, this.mzq)) + a.a.a.a.dS(5, this.mzr)) + a.a.a.a.c(6, 8, this.mzs)) + a.a.a.a.dS(7, this.miR);
            if (this.mzt != null) {
                r0 += a.a.a.b.b.a.f(8, this.mzt);
            }
            if (this.mzu != null) {
                r0 += a.a.a.b.b.a.f(9, this.mzu);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mzq.clear();
            this.mzs.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mzn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xb xbVar = (xb) objArr[1];
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
                        xbVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        xbVar.mzn = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    xbVar.mzp = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqx.a(aVar4))) {
                        }
                        xbVar.mzq.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 5:
                    xbVar.mzr = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aft com_tencent_mm_protocal_c_aft = new aft();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aft.a(aVar4, com_tencent_mm_protocal_c_aft, aqx.a(aVar4))) {
                        }
                        xbVar.mzs.add(com_tencent_mm_protocal_c_aft);
                    }
                    return 0;
                case 7:
                    xbVar.miR = aVar3.pMj.mH();
                    return 0;
                case 8:
                    xbVar.mzt = aVar3.pMj.readString();
                    return 0;
                case 9:
                    xbVar.mzu = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
