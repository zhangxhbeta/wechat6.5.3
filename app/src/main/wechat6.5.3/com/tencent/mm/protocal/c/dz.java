package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class dz extends aqp {
    public int efm;
    public String mcN;
    public String meZ;
    public int mfa;
    public int mfb;
    public int mfc;
    public int mfd;
    public int mfe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.meZ != null) {
                aVar.e(2, this.meZ);
            }
            aVar.dV(3, this.mfa);
            if (this.mcN != null) {
                aVar.e(4, this.mcN);
            }
            aVar.dV(5, this.mfb);
            aVar.dV(6, this.mfc);
            aVar.dV(7, this.mfd);
            aVar.dV(8, this.efm);
            aVar.dV(9, this.mfe);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.meZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.meZ);
            }
            r0 += a.a.a.a.dS(3, this.mfa);
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mcN);
            }
            return ((((r0 + a.a.a.a.dS(5, this.mfb)) + a.a.a.a.dS(6, this.mfc)) + a.a.a.a.dS(7, this.mfd)) + a.a.a.a.dS(8, this.efm)) + a.a.a.a.dS(9, this.mfe);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dz dzVar = (dz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        dzVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    dzVar.meZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dzVar.mfa = aVar3.pMj.mH();
                    return 0;
                case 4:
                    dzVar.mcN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    dzVar.mfb = aVar3.pMj.mH();
                    return 0;
                case 6:
                    dzVar.mfc = aVar3.pMj.mH();
                    return 0;
                case 7:
                    dzVar.mfd = aVar3.pMj.mH();
                    return 0;
                case 8:
                    dzVar.efm = aVar3.pMj.mH();
                    return 0;
                case 9:
                    dzVar.mfe = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
