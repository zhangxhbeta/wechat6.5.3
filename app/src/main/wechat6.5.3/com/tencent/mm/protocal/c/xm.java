package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class xm extends aqx {
    public String glb;
    public int lZm;
    public int mzL;
    public LinkedList<alf> mzM = new LinkedList();
    public int mzN;
    public String mzO;
    public are mzn;
    public String mzt;

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
                aVar.dV(2, this.mzL);
                aVar.d(3, 8, this.mzM);
                aVar.dV(4, this.lZm);
                aVar.dV(5, this.mzN);
                if (this.mzn != null) {
                    aVar.dX(6, this.mzn.aHr());
                    this.mzn.a(aVar);
                }
                if (this.glb != null) {
                    aVar.e(7, this.glb);
                }
                if (this.mzt != null) {
                    aVar.e(8, this.mzt);
                }
                if (this.mzO == null) {
                    return 0;
                }
                aVar.e(9, this.mzO);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.dS(2, this.mzL)) + a.a.a.a.c(3, 8, this.mzM)) + a.a.a.a.dS(4, this.lZm)) + a.a.a.a.dS(5, this.mzN);
            if (this.mzn != null) {
                r0 += a.a.a.a.dU(6, this.mzn.aHr());
            }
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(7, this.glb);
            }
            if (this.mzt != null) {
                r0 += a.a.a.b.b.a.f(8, this.mzt);
            }
            if (this.mzO != null) {
                r0 += a.a.a.b.b.a.f(9, this.mzO);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mzM.clear();
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
            xm xmVar = (xm) objArr[1];
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
                        xmVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    xmVar.mzL = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        alf com_tencent_mm_protocal_c_alf = new alf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_alf.a(aVar4, com_tencent_mm_protocal_c_alf, aqx.a(aVar4))) {
                        }
                        xmVar.mzM.add(com_tencent_mm_protocal_c_alf);
                    }
                    return 0;
                case 4:
                    xmVar.lZm = aVar3.pMj.mH();
                    return 0;
                case 5:
                    xmVar.mzN = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        xmVar.mzn = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 7:
                    xmVar.glb = aVar3.pMj.readString();
                    return 0;
                case 8:
                    xmVar.mzt = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    xmVar.mzO = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
