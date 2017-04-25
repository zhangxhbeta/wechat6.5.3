package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class rp extends aqp {
    public String glj;
    public String gor;
    public int lZo;
    public String mgs;
    public am mkb;
    public String mmT;
    public String mmU;
    public String mmV;
    public String mmW;
    public String mmu;
    public String mvq;
    public String mvr;
    public String mvs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            if (this.mmT != null) {
                aVar.e(3, this.mmT);
            }
            if (this.mgs != null) {
                aVar.e(4, this.mgs);
            }
            if (this.mmU != null) {
                aVar.e(5, this.mmU);
            }
            if (this.mmV != null) {
                aVar.e(6, this.mmV);
            }
            if (this.mmW != null) {
                aVar.e(7, this.mmW);
            }
            if (this.mmu != null) {
                aVar.e(8, this.mmu);
            }
            if (this.mvq != null) {
                aVar.e(9, this.mvq);
            }
            aVar.dV(10, this.lZo);
            if (this.gor != null) {
                aVar.e(11, this.gor);
            }
            if (this.mvr != null) {
                aVar.e(12, this.mvr);
            }
            if (this.mvs != null) {
                aVar.e(13, this.mvs);
            }
            if (this.mkb == null) {
                return 0;
            }
            aVar.dX(14, this.mkb.aHr());
            this.mkb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            if (this.mmT != null) {
                r0 += a.a.a.b.b.a.f(3, this.mmT);
            }
            if (this.mgs != null) {
                r0 += a.a.a.b.b.a.f(4, this.mgs);
            }
            if (this.mmU != null) {
                r0 += a.a.a.b.b.a.f(5, this.mmU);
            }
            if (this.mmV != null) {
                r0 += a.a.a.b.b.a.f(6, this.mmV);
            }
            if (this.mmW != null) {
                r0 += a.a.a.b.b.a.f(7, this.mmW);
            }
            if (this.mmu != null) {
                r0 += a.a.a.b.b.a.f(8, this.mmu);
            }
            if (this.mvq != null) {
                r0 += a.a.a.b.b.a.f(9, this.mvq);
            }
            r0 += a.a.a.a.dS(10, this.lZo);
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(11, this.gor);
            }
            if (this.mvr != null) {
                r0 += a.a.a.b.b.a.f(12, this.mvr);
            }
            if (this.mvs != null) {
                r0 += a.a.a.b.b.a.f(13, this.mvs);
            }
            if (this.mkb != null) {
                r0 += a.a.a.a.dU(14, this.mkb.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            rp rpVar = (rp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        rpVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    rpVar.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    rpVar.mmT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    rpVar.mgs = aVar3.pMj.readString();
                    return 0;
                case 5:
                    rpVar.mmU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    rpVar.mmV = aVar3.pMj.readString();
                    return 0;
                case 7:
                    rpVar.mmW = aVar3.pMj.readString();
                    return 0;
                case 8:
                    rpVar.mmu = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    rpVar.mvq = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    rpVar.lZo = aVar3.pMj.mH();
                    return 0;
                case 11:
                    rpVar.gor = aVar3.pMj.readString();
                    return 0;
                case 12:
                    rpVar.mvr = aVar3.pMj.readString();
                    return 0;
                case 13:
                    rpVar.mvs = aVar3.pMj.readString();
                    return 0;
                case 14:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        am amVar = new am();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amVar.a(aVar4, amVar, aqp.a(aVar4))) {
                        }
                        rpVar.mkb = amVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
