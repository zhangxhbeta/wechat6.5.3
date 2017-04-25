package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ea extends aqx {
    public String mcN;
    public int mdz;
    public String meZ;
    public int mfa;
    public int mfb;
    public int mfd;
    public int mff;
    public are mfg;
    public int mfh;
    public int mfi;
    public int mfj;
    public String mfk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.meZ != null) {
                    aVar.e(2, this.meZ);
                }
                aVar.dV(3, this.mfa);
                if (this.mcN != null) {
                    aVar.e(4, this.mcN);
                }
                aVar.dV(5, this.mfb);
                aVar.dV(6, this.mff);
                if (this.mfg != null) {
                    aVar.dX(7, this.mfg.aHr());
                    this.mfg.a(aVar);
                }
                aVar.dV(8, this.mfh);
                aVar.dV(9, this.mfd);
                aVar.dV(10, this.mdz);
                aVar.dV(11, this.mfi);
                aVar.dV(12, this.mfj);
                if (this.mfk == null) {
                    return 0;
                }
                aVar.e(13, this.mfk);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
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
            r0 = (r0 + a.a.a.a.dS(5, this.mfb)) + a.a.a.a.dS(6, this.mff);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(7, this.mfg.aHr());
            }
            r0 = ((((r0 + a.a.a.a.dS(8, this.mfh)) + a.a.a.a.dS(9, this.mfd)) + a.a.a.a.dS(10, this.mdz)) + a.a.a.a.dS(11, this.mfi)) + a.a.a.a.dS(12, this.mfj);
            if (this.mfk != null) {
                r0 += a.a.a.b.b.a.f(13, this.mfk);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mfg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ea eaVar = (ea) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        eaVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    eaVar.meZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    eaVar.mfa = aVar3.pMj.mH();
                    return 0;
                case 4:
                    eaVar.mcN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    eaVar.mfb = aVar3.pMj.mH();
                    return 0;
                case 6:
                    eaVar.mff = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        eaVar.mfg = eoVar;
                    }
                    return 0;
                case 8:
                    eaVar.mfh = aVar3.pMj.mH();
                    return 0;
                case 9:
                    eaVar.mfd = aVar3.pMj.mH();
                    return 0;
                case 10:
                    eaVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 11:
                    eaVar.mfi = aVar3.pMj.mH();
                    return 0;
                case 12:
                    eaVar.mfj = aVar3.pMj.mH();
                    return 0;
                case 13:
                    eaVar.mfk = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
