package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class gc extends aqp {
    public int meB;
    public int mgo;
    public String mgp;
    public String mgq;
    public String mgr;
    public String mgs;
    public String mgt;
    public String mgu;
    public String mgv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.meB);
            aVar.dV(3, this.mgo);
            if (this.mgp != null) {
                aVar.e(4, this.mgp);
            }
            if (this.mgq != null) {
                aVar.e(5, this.mgq);
            }
            if (this.mgr != null) {
                aVar.e(6, this.mgr);
            }
            if (this.mgs != null) {
                aVar.e(7, this.mgs);
            }
            if (this.mgt != null) {
                aVar.e(8, this.mgt);
            }
            if (this.mgu != null) {
                aVar.e(9, this.mgu);
            }
            if (this.mgv == null) {
                return 0;
            }
            aVar.e(10, this.mgv);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.meB)) + a.a.a.a.dS(3, this.mgo);
            if (this.mgp != null) {
                r0 += a.a.a.b.b.a.f(4, this.mgp);
            }
            if (this.mgq != null) {
                r0 += a.a.a.b.b.a.f(5, this.mgq);
            }
            if (this.mgr != null) {
                r0 += a.a.a.b.b.a.f(6, this.mgr);
            }
            if (this.mgs != null) {
                r0 += a.a.a.b.b.a.f(7, this.mgs);
            }
            if (this.mgt != null) {
                r0 += a.a.a.b.b.a.f(8, this.mgt);
            }
            if (this.mgu != null) {
                r0 += a.a.a.b.b.a.f(9, this.mgu);
            }
            if (this.mgv != null) {
                r0 += a.a.a.b.b.a.f(10, this.mgv);
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
            gc gcVar = (gc) objArr[1];
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
                        gcVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    gcVar.meB = aVar3.pMj.mH();
                    return 0;
                case 3:
                    gcVar.mgo = aVar3.pMj.mH();
                    return 0;
                case 4:
                    gcVar.mgp = aVar3.pMj.readString();
                    return 0;
                case 5:
                    gcVar.mgq = aVar3.pMj.readString();
                    return 0;
                case 6:
                    gcVar.mgr = aVar3.pMj.readString();
                    return 0;
                case 7:
                    gcVar.mgs = aVar3.pMj.readString();
                    return 0;
                case 8:
                    gcVar.mgt = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    gcVar.mgu = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    gcVar.mgv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
