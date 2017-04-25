package com.tencent.mm.plugin.backup.f;

public final class a extends com.tencent.mm.ba.a {
    public int djS;
    public int eha;
    public long ehb;
    public long ehc;
    public long ehd;
    public int ehe;
    public int ehf;
    public int ehg;
    public int ehh;
    public int ehi;
    public int ehj;
    public int networkType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.eha);
            aVar.dV(2, this.djS);
            aVar.C(3, this.ehb);
            aVar.C(4, this.ehc);
            aVar.C(5, this.ehd);
            aVar.dV(6, this.ehe);
            aVar.dV(7, this.networkType);
            aVar.dV(8, this.ehf);
            aVar.dV(9, this.ehg);
            aVar.dV(10, this.ehh);
            aVar.dV(11, this.ehi);
            aVar.dV(12, this.ehj);
            return 0;
        } else if (i == 1) {
            return (((((((((((a.a.a.a.dS(1, this.eha) + 0) + a.a.a.a.dS(2, this.djS)) + a.a.a.a.B(3, this.ehb)) + a.a.a.a.B(4, this.ehc)) + a.a.a.a.B(5, this.ehd)) + a.a.a.a.dS(6, this.ehe)) + a.a.a.a.dS(7, this.networkType)) + a.a.a.a.dS(8, this.ehf)) + a.a.a.a.dS(9, this.ehg)) + a.a.a.a.dS(10, this.ehh)) + a.a.a.a.dS(11, this.ehi)) + a.a.a.a.dS(12, this.ehj);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = com.tencent.mm.ba.a.a(aVar2); a > 0; a = com.tencent.mm.ba.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aVar4.eha = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        aVar4.djS = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        aVar4.ehb = aVar3.pMj.mI();
                        return 0;
                    case 4:
                        aVar4.ehc = aVar3.pMj.mI();
                        return 0;
                    case 5:
                        aVar4.ehd = aVar3.pMj.mI();
                        return 0;
                    case 6:
                        aVar4.ehe = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        aVar4.networkType = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        aVar4.ehf = aVar3.pMj.mH();
                        return 0;
                    case 9:
                        aVar4.ehg = aVar3.pMj.mH();
                        return 0;
                    case 10:
                        aVar4.ehh = aVar3.pMj.mH();
                        return 0;
                    case 11:
                        aVar4.ehi = aVar3.pMj.mH();
                        return 0;
                    case 12:
                        aVar4.ehj = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
