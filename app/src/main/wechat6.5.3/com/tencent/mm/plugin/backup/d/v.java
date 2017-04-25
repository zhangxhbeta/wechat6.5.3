package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class v extends a {
    public int eeO;
    public int eev;
    public k efC;
    public j efD;
    public l efE;
    public m efF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.eev);
            aVar.dV(2, this.eeO);
            if (this.efC != null) {
                aVar.dX(3, this.efC.aHr());
                this.efC.a(aVar);
            }
            if (this.efD != null) {
                aVar.dX(4, this.efD.aHr());
                this.efD.a(aVar);
            }
            if (this.efE != null) {
                aVar.dX(5, this.efE.aHr());
                this.efE.a(aVar);
            }
            if (this.efF != null) {
                aVar.dX(6, this.efF.aHr());
                this.efF.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.eev) + 0) + a.a.a.a.dS(2, this.eeO);
            if (this.efC != null) {
                r0 += a.a.a.a.dU(3, this.efC.aHr());
            }
            if (this.efD != null) {
                r0 += a.a.a.a.dU(4, this.efD.aHr());
            }
            if (this.efE != null) {
                r0 += a.a.a.a.dU(5, this.efE.aHr());
            }
            if (this.efF != null) {
                return r0 + a.a.a.a.dU(6, this.efF.aHr());
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
            v vVar = (v) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a kVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    vVar.eev = aVar3.pMj.mH();
                    return 0;
                case 2:
                    vVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        kVar = new k();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        vVar.efC = kVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        kVar = new j();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        vVar.efD = kVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        kVar = new l();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        vVar.efE = kVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        kVar = new m();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        vVar.efF = kVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
