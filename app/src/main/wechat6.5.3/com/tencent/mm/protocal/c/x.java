package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class x extends aqp {
    public String SSID;
    public String URL;
    public String lZj;
    public String lZk;
    public String lZl;
    public int lZm;
    public LinkedList<cc> lZn = new LinkedList();
    public int lZo;
    public String lZp;
    public int lZq;
    public String lZr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.URL != null) {
                aVar.e(2, this.URL);
            }
            if (this.SSID != null) {
                aVar.e(3, this.SSID);
            }
            if (this.lZj != null) {
                aVar.e(4, this.lZj);
            }
            if (this.lZk != null) {
                aVar.e(5, this.lZk);
            }
            if (this.lZl != null) {
                aVar.e(6, this.lZl);
            }
            aVar.dV(7, this.lZm);
            aVar.d(8, 8, this.lZn);
            aVar.dV(9, this.lZo);
            if (this.lZp != null) {
                aVar.e(10, this.lZp);
            }
            aVar.dV(11, this.lZq);
            if (this.lZr == null) {
                return 0;
            }
            aVar.e(12, this.lZr);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.URL != null) {
                r0 += a.a.a.b.b.a.f(2, this.URL);
            }
            if (this.SSID != null) {
                r0 += a.a.a.b.b.a.f(3, this.SSID);
            }
            if (this.lZj != null) {
                r0 += a.a.a.b.b.a.f(4, this.lZj);
            }
            if (this.lZk != null) {
                r0 += a.a.a.b.b.a.f(5, this.lZk);
            }
            if (this.lZl != null) {
                r0 += a.a.a.b.b.a.f(6, this.lZl);
            }
            r0 = ((r0 + a.a.a.a.dS(7, this.lZm)) + a.a.a.a.c(8, 8, this.lZn)) + a.a.a.a.dS(9, this.lZo);
            if (this.lZp != null) {
                r0 += a.a.a.b.b.a.f(10, this.lZp);
            }
            r0 += a.a.a.a.dS(11, this.lZq);
            if (this.lZr != null) {
                r0 += a.a.a.b.b.a.f(12, this.lZr);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lZn.clear();
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
            x xVar = (x) objArr[1];
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
                        xVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    xVar.URL = aVar3.pMj.readString();
                    return 0;
                case 3:
                    xVar.SSID = aVar3.pMj.readString();
                    return 0;
                case 4:
                    xVar.lZj = aVar3.pMj.readString();
                    return 0;
                case 5:
                    xVar.lZk = aVar3.pMj.readString();
                    return 0;
                case 6:
                    xVar.lZl = aVar3.pMj.readString();
                    return 0;
                case 7:
                    xVar.lZm = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        cc ccVar = new cc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ccVar.a(aVar4, ccVar, aqp.a(aVar4))) {
                        }
                        xVar.lZn.add(ccVar);
                    }
                    return 0;
                case 9:
                    xVar.lZo = aVar3.pMj.mH();
                    return 0;
                case 10:
                    xVar.lZp = aVar3.pMj.readString();
                    return 0;
                case 11:
                    xVar.lZq = aVar3.pMj.mH();
                    return 0;
                case 12:
                    xVar.lZr = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
