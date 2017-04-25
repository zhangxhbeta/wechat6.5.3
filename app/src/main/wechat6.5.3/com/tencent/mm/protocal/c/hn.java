package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class hn extends aqp {
    public int count;
    public int itQ;
    public String ivN;
    public String ivO;
    public String mio;
    public String mip;
    public String miq;
    public String mir;
    public String mis;
    public String mit;
    public int miu;
    public int type;
    public String value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mio != null) {
                aVar.e(2, this.mio);
            }
            if (this.mip != null) {
                aVar.e(3, this.mip);
            }
            if (this.miq != null) {
                aVar.e(4, this.miq);
            }
            if (this.mir != null) {
                aVar.e(5, this.mir);
            }
            if (this.mis != null) {
                aVar.e(6, this.mis);
            }
            aVar.dV(7, this.itQ);
            if (this.mit != null) {
                aVar.e(8, this.mit);
            }
            if (this.ivO != null) {
                aVar.e(9, this.ivO);
            }
            if (this.ivN != null) {
                aVar.e(10, this.ivN);
            }
            aVar.dV(11, this.type);
            if (this.value != null) {
                aVar.e(12, this.value);
            }
            aVar.dV(13, this.count);
            aVar.dV(14, this.miu);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mio != null) {
                r0 += a.a.a.b.b.a.f(2, this.mio);
            }
            if (this.mip != null) {
                r0 += a.a.a.b.b.a.f(3, this.mip);
            }
            if (this.miq != null) {
                r0 += a.a.a.b.b.a.f(4, this.miq);
            }
            if (this.mir != null) {
                r0 += a.a.a.b.b.a.f(5, this.mir);
            }
            if (this.mis != null) {
                r0 += a.a.a.b.b.a.f(6, this.mis);
            }
            r0 += a.a.a.a.dS(7, this.itQ);
            if (this.mit != null) {
                r0 += a.a.a.b.b.a.f(8, this.mit);
            }
            if (this.ivO != null) {
                r0 += a.a.a.b.b.a.f(9, this.ivO);
            }
            if (this.ivN != null) {
                r0 += a.a.a.b.b.a.f(10, this.ivN);
            }
            r0 += a.a.a.a.dS(11, this.type);
            if (this.value != null) {
                r0 += a.a.a.b.b.a.f(12, this.value);
            }
            return (r0 + a.a.a.a.dS(13, this.count)) + a.a.a.a.dS(14, this.miu);
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
            hn hnVar = (hn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        hnVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    hnVar.mio = aVar3.pMj.readString();
                    return 0;
                case 3:
                    hnVar.mip = aVar3.pMj.readString();
                    return 0;
                case 4:
                    hnVar.miq = aVar3.pMj.readString();
                    return 0;
                case 5:
                    hnVar.mir = aVar3.pMj.readString();
                    return 0;
                case 6:
                    hnVar.mis = aVar3.pMj.readString();
                    return 0;
                case 7:
                    hnVar.itQ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    hnVar.mit = aVar3.pMj.readString();
                    return 0;
                case 9:
                    hnVar.ivO = aVar3.pMj.readString();
                    return 0;
                case 10:
                    hnVar.ivN = aVar3.pMj.readString();
                    return 0;
                case 11:
                    hnVar.type = aVar3.pMj.mH();
                    return 0;
                case 12:
                    hnVar.value = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    hnVar.count = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    hnVar.miu = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
