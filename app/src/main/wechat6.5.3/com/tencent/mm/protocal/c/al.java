package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class al extends a {
    public int efm;
    public String glb;
    public int maG;
    public String maH;
    public String maI;
    public String maJ;
    public aj maK;
    public String maL;
    public ce maM;
    public cn maN;
    public cm maO;
    public cm maP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            if (this.glb != null) {
                aVar.e(2, this.glb);
            }
            aVar.dV(3, this.maG);
            if (this.maH != null) {
                aVar.e(4, this.maH);
            }
            if (this.maI != null) {
                aVar.e(5, this.maI);
            }
            if (this.maJ != null) {
                aVar.e(6, this.maJ);
            }
            if (this.maK != null) {
                aVar.dX(7, this.maK.aHr());
                this.maK.a(aVar);
            }
            if (this.maL != null) {
                aVar.e(8, this.maL);
            }
            if (this.maM != null) {
                aVar.dX(9, this.maM.aHr());
                this.maM.a(aVar);
            }
            if (this.maN != null) {
                aVar.dX(10, this.maN.aHr());
                this.maN.a(aVar);
            }
            if (this.maO != null) {
                aVar.dX(11, this.maO.aHr());
                this.maO.a(aVar);
            }
            if (this.maP != null) {
                aVar.dX(12, this.maP.aHr());
                this.maP.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(2, this.glb);
            }
            r0 += a.a.a.a.dS(3, this.maG);
            if (this.maH != null) {
                r0 += a.a.a.b.b.a.f(4, this.maH);
            }
            if (this.maI != null) {
                r0 += a.a.a.b.b.a.f(5, this.maI);
            }
            if (this.maJ != null) {
                r0 += a.a.a.b.b.a.f(6, this.maJ);
            }
            if (this.maK != null) {
                r0 += a.a.a.a.dU(7, this.maK.aHr());
            }
            if (this.maL != null) {
                r0 += a.a.a.b.b.a.f(8, this.maL);
            }
            if (this.maM != null) {
                r0 += a.a.a.a.dU(9, this.maM.aHr());
            }
            if (this.maN != null) {
                r0 += a.a.a.a.dU(10, this.maN.aHr());
            }
            if (this.maO != null) {
                r0 += a.a.a.a.dU(11, this.maO.aHr());
            }
            if (this.maP != null) {
                return r0 + a.a.a.a.dU(12, this.maP.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            al alVar = (al) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a ajVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    alVar.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    alVar.glb = aVar3.pMj.readString();
                    return 0;
                case 3:
                    alVar.maG = aVar3.pMj.mH();
                    return 0;
                case 4:
                    alVar.maH = aVar3.pMj.readString();
                    return 0;
                case 5:
                    alVar.maI = aVar3.pMj.readString();
                    return 0;
                case 6:
                    alVar.maJ = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ajVar = new aj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.a(aVar4, ajVar, a.a(aVar4))) {
                        }
                        alVar.maK = ajVar;
                    }
                    return 0;
                case 8:
                    alVar.maL = aVar3.pMj.readString();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ajVar = new ce();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.a(aVar4, ajVar, a.a(aVar4))) {
                        }
                        alVar.maM = ajVar;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ajVar = new cn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.a(aVar4, ajVar, a.a(aVar4))) {
                        }
                        alVar.maN = ajVar;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ajVar = new cm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.a(aVar4, ajVar, a.a(aVar4))) {
                        }
                        alVar.maO = ajVar;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ajVar = new cm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.a(aVar4, ajVar, a.a(aVar4))) {
                        }
                        alVar.maP = ajVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
