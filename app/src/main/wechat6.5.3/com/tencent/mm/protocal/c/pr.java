package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class pr extends aqp {
    public int lZm;
    public float mjM;
    public float mjN;
    public String mpB;
    public int mrA;
    public String mrB;
    public String mrC;
    public int mrD;
    public String mrz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.lZm);
            if (this.mrz != null) {
                aVar.e(3, this.mrz);
            }
            aVar.j(4, this.mjM);
            aVar.j(5, this.mjN);
            aVar.dV(6, this.mrA);
            if (this.mrB != null) {
                aVar.e(7, this.mrB);
            }
            if (this.mrC != null) {
                aVar.e(8, this.mrC);
            }
            aVar.dV(9, this.mrD);
            if (this.mpB == null) {
                return 0;
            }
            aVar.e(10, this.mpB);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.lZm);
            if (this.mrz != null) {
                r0 += a.a.a.b.b.a.f(3, this.mrz);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cw(4) + 4)) + (a.a.a.b.b.a.cw(5) + 4)) + a.a.a.a.dS(6, this.mrA);
            if (this.mrB != null) {
                r0 += a.a.a.b.b.a.f(7, this.mrB);
            }
            if (this.mrC != null) {
                r0 += a.a.a.b.b.a.f(8, this.mrC);
            }
            r0 += a.a.a.a.dS(9, this.mrD);
            if (this.mpB != null) {
                r0 += a.a.a.b.b.a.f(10, this.mpB);
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
            pr prVar = (pr) objArr[1];
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
                        prVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    prVar.lZm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    prVar.mrz = aVar3.pMj.readString();
                    return 0;
                case 4:
                    prVar.mjM = aVar3.pMj.readFloat();
                    return 0;
                case 5:
                    prVar.mjN = aVar3.pMj.readFloat();
                    return 0;
                case 6:
                    prVar.mrA = aVar3.pMj.mH();
                    return 0;
                case 7:
                    prVar.mrB = aVar3.pMj.readString();
                    return 0;
                case 8:
                    prVar.mrC = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    prVar.mrD = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    prVar.mpB = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
