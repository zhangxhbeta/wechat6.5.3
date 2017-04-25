package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class uf extends aqp {
    public int bon;
    public String fZW;
    public String lZL;
    public String lZM;
    public int lZN;
    public LinkedList<iv> lZQ = new LinkedList();
    public String mct;
    public String mxa;
    public String mxb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.d(2, 8, this.lZQ);
            aVar.dV(3, this.bon);
            if (this.mxb != null) {
                aVar.e(4, this.mxb);
            }
            if (this.mct != null) {
                aVar.e(5, this.mct);
            }
            if (this.fZW != null) {
                aVar.e(6, this.fZW);
            }
            if (this.lZL != null) {
                aVar.e(7, this.lZL);
            }
            if (this.lZM != null) {
                aVar.e(8, this.lZM);
            }
            if (this.mxa != null) {
                aVar.e(9, this.mxa);
            }
            aVar.dV(10, this.lZN);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.c(2, 8, this.lZQ)) + a.a.a.a.dS(3, this.bon);
            if (this.mxb != null) {
                r0 += a.a.a.b.b.a.f(4, this.mxb);
            }
            if (this.mct != null) {
                r0 += a.a.a.b.b.a.f(5, this.mct);
            }
            if (this.fZW != null) {
                r0 += a.a.a.b.b.a.f(6, this.fZW);
            }
            if (this.lZL != null) {
                r0 += a.a.a.b.b.a.f(7, this.lZL);
            }
            if (this.lZM != null) {
                r0 += a.a.a.b.b.a.f(8, this.lZM);
            }
            if (this.mxa != null) {
                r0 += a.a.a.b.b.a.f(9, this.mxa);
            }
            return r0 + a.a.a.a.dS(10, this.lZN);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lZQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            uf ufVar = (uf) objArr[1];
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
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        ufVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        iv ivVar = new iv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ivVar.a(aVar4, ivVar, aqp.a(aVar4))) {
                        }
                        ufVar.lZQ.add(ivVar);
                    }
                    return 0;
                case 3:
                    ufVar.bon = aVar3.pMj.mH();
                    return 0;
                case 4:
                    ufVar.mxb = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ufVar.mct = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ufVar.fZW = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ufVar.lZL = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ufVar.lZM = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    ufVar.mxa = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    ufVar.lZN = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
