package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class sp extends aqp {
    public String eBK;
    public String eBQ;
    public b eDH;
    public String eKA;
    public int eKw;
    public String eKx;
    public String eKy;
    public String eKz;
    public int mwo;
    public int time_stamp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.eBQ != null) {
                aVar.e(2, this.eBQ);
            }
            aVar.dV(3, this.eKw);
            if (this.eKx != null) {
                aVar.e(4, this.eKx);
            }
            if (this.eKy != null) {
                aVar.e(5, this.eKy);
            }
            aVar.dV(6, this.time_stamp);
            if (this.eKz != null) {
                aVar.e(7, this.eKz);
            }
            if (this.eBK != null) {
                aVar.e(8, this.eBK);
            }
            if (this.eKA != null) {
                aVar.e(9, this.eKA);
            }
            if (this.eDH != null) {
                aVar.b(10, this.eDH);
            }
            aVar.dV(11, this.mwo);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.eBQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.eBQ);
            }
            r0 += a.a.a.a.dS(3, this.eKw);
            if (this.eKx != null) {
                r0 += a.a.a.b.b.a.f(4, this.eKx);
            }
            if (this.eKy != null) {
                r0 += a.a.a.b.b.a.f(5, this.eKy);
            }
            r0 += a.a.a.a.dS(6, this.time_stamp);
            if (this.eKz != null) {
                r0 += a.a.a.b.b.a.f(7, this.eKz);
            }
            if (this.eBK != null) {
                r0 += a.a.a.b.b.a.f(8, this.eBK);
            }
            if (this.eKA != null) {
                r0 += a.a.a.b.b.a.f(9, this.eKA);
            }
            if (this.eDH != null) {
                r0 += a.a.a.a.a(10, this.eDH);
            }
            return r0 + a.a.a.a.dS(11, this.mwo);
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
            sp spVar = (sp) objArr[1];
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
                        spVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    spVar.eBQ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    spVar.eKw = aVar3.pMj.mH();
                    return 0;
                case 4:
                    spVar.eKx = aVar3.pMj.readString();
                    return 0;
                case 5:
                    spVar.eKy = aVar3.pMj.readString();
                    return 0;
                case 6:
                    spVar.time_stamp = aVar3.pMj.mH();
                    return 0;
                case 7:
                    spVar.eKz = aVar3.pMj.readString();
                    return 0;
                case 8:
                    spVar.eBK = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    spVar.eKA = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    spVar.eDH = aVar3.bQK();
                    return 0;
                case 11:
                    spVar.mwo = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
