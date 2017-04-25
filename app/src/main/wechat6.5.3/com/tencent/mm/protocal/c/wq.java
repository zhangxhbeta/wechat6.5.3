package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class wq extends aqp {
    public String fYL;
    public String fYM;
    public String fYN;
    public nf lZG;
    public String lZp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.fYL != null) {
                aVar.e(2, this.fYL);
            }
            if (this.fYM != null) {
                aVar.e(3, this.fYM);
            }
            if (this.fYN != null) {
                aVar.e(4, this.fYN);
            }
            if (this.lZp != null) {
                aVar.e(5, this.lZp);
            }
            if (this.lZG == null) {
                return 0;
            }
            aVar.dX(6, this.lZG.aHr());
            this.lZG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fYL != null) {
                r0 += a.a.a.b.b.a.f(2, this.fYL);
            }
            if (this.fYM != null) {
                r0 += a.a.a.b.b.a.f(3, this.fYM);
            }
            if (this.fYN != null) {
                r0 += a.a.a.b.b.a.f(4, this.fYN);
            }
            if (this.lZp != null) {
                r0 += a.a.a.b.b.a.f(5, this.lZp);
            }
            if (this.lZG != null) {
                r0 += a.a.a.a.dU(6, this.lZG.aHr());
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
            wq wqVar = (wq) objArr[1];
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
                        wqVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    wqVar.fYL = aVar3.pMj.readString();
                    return 0;
                case 3:
                    wqVar.fYM = aVar3.pMj.readString();
                    return 0;
                case 4:
                    wqVar.fYN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    wqVar.lZp = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nf nfVar = new nf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nfVar.a(aVar4, nfVar, aqp.a(aVar4))) {
                        }
                        wqVar.lZG = nfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
