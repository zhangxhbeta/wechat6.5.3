package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class qf extends a {
    public String desc;
    public String gxy;
    public boolean mrL = false;
    public boolean mrM = false;
    public qg mtP;
    public boolean mtQ = false;
    public LinkedList<pw> mtR = new LinkedList();
    public boolean mtS = false;
    public boolean mtT = false;
    public qc mta;
    public boolean mtb = false;
    public qp mtc;
    public boolean mtd = false;
    public qe mte;
    public boolean mtf = false;
    public qj mtg;
    public boolean mth = false;
    public boolean mti = false;
    public long mtj;
    public boolean mtk = false;
    public int mtl = -1;
    public boolean mtm = false;
    public long mtn;
    public boolean mto = false;
    public String title;
    public int version;

    public final qf a(qg qgVar) {
        this.mtP = qgVar;
        this.mtQ = true;
        return this;
    }

    public final qf ah(LinkedList<pw> linkedList) {
        this.mtR = linkedList;
        this.mtS = true;
        return this;
    }

    public final qf b(qc qcVar) {
        this.mta = qcVar;
        this.mtb = true;
        return this;
    }

    public final qf b(qp qpVar) {
        this.mtc = qpVar;
        this.mtd = true;
        return this;
    }

    public final qf Jk(String str) {
        this.gxy = str;
        this.mti = true;
        return this;
    }

    public final qf Jl(String str) {
        this.title = str;
        this.mrL = true;
        return this;
    }

    public final qf Jm(String str) {
        this.desc = str;
        this.mrM = true;
        return this;
    }

    public final qf dT(long j) {
        this.mtj = j;
        this.mtk = true;
        return this;
    }

    public final qf uL(int i) {
        this.mtl = i;
        this.mtm = true;
        return this;
    }

    public final qf b(qe qeVar) {
        this.mte = qeVar;
        this.mtf = true;
        return this;
    }

    public final qf dU(long j) {
        this.mtn = j;
        this.mto = true;
        return this;
    }

    public final qf b(qj qjVar) {
        this.mtg = qjVar;
        this.mth = true;
        return this;
    }

    public final qf uM(int i) {
        this.version = i;
        this.mtT = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtP != null) {
                aVar.dX(1, this.mtP.aHr());
                this.mtP.a(aVar);
            }
            aVar.d(2, 8, this.mtR);
            if (this.mta != null) {
                aVar.dX(3, this.mta.aHr());
                this.mta.a(aVar);
            }
            if (this.mtc != null) {
                aVar.dX(4, this.mtc.aHr());
                this.mtc.a(aVar);
            }
            if (this.gxy != null) {
                aVar.e(5, this.gxy);
            }
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            if (this.desc != null) {
                aVar.e(7, this.desc);
            }
            if (this.mtk) {
                aVar.C(8, this.mtj);
            }
            if (this.mtm) {
                aVar.dV(91, this.mtl);
            }
            if (this.mte != null) {
                aVar.dX(10, this.mte.aHr());
                this.mte.a(aVar);
            }
            if (this.mto) {
                aVar.C(11, this.mtn);
            }
            if (this.mtg != null) {
                aVar.dX(12, this.mtg.aHr());
                this.mtg.a(aVar);
            }
            if (!this.mtT) {
                return 0;
            }
            aVar.dV(13, this.version);
            return 0;
        } else if (i == 1) {
            if (this.mtP != null) {
                r0 = a.a.a.a.dU(1, this.mtP.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.mtR);
            if (this.mta != null) {
                r0 += a.a.a.a.dU(3, this.mta.aHr());
            }
            if (this.mtc != null) {
                r0 += a.a.a.a.dU(4, this.mtc.aHr());
            }
            if (this.gxy != null) {
                r0 += a.a.a.b.b.a.f(5, this.gxy);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(6, this.title);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(7, this.desc);
            }
            if (this.mtk) {
                r0 += a.a.a.a.B(8, this.mtj);
            }
            if (this.mtm) {
                r0 += a.a.a.a.dS(91, this.mtl);
            }
            if (this.mte != null) {
                r0 += a.a.a.a.dU(10, this.mte.aHr());
            }
            if (this.mto) {
                r0 += a.a.a.a.B(11, this.mtn);
            }
            if (this.mtg != null) {
                r0 += a.a.a.a.dU(12, this.mtg.aHr());
            }
            if (this.mtT) {
                r0 += a.a.a.a.dS(13, this.version);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mtR.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            qf qfVar = (qf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a qgVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qgVar = new qg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qgVar.a(aVar4, qgVar, a.a(aVar4))) {
                        }
                        qfVar.mtP = qgVar;
                    }
                    qfVar.mtQ = true;
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qgVar = new pw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qgVar.a(aVar4, qgVar, a.a(aVar4))) {
                        }
                        qfVar.mtR.add(qgVar);
                    }
                    qfVar.mtS = true;
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qgVar = new qc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qgVar.a(aVar4, qgVar, a.a(aVar4))) {
                        }
                        qfVar.mta = qgVar;
                    }
                    qfVar.mtb = true;
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qgVar = new qp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qgVar.a(aVar4, qgVar, a.a(aVar4))) {
                        }
                        qfVar.mtc = qgVar;
                    }
                    qfVar.mtd = true;
                    return 0;
                case 5:
                    qfVar.gxy = aVar3.pMj.readString();
                    qfVar.mti = true;
                    return 0;
                case 6:
                    qfVar.title = aVar3.pMj.readString();
                    qfVar.mrL = true;
                    return 0;
                case 7:
                    qfVar.desc = aVar3.pMj.readString();
                    qfVar.mrM = true;
                    return 0;
                case 8:
                    qfVar.mtj = aVar3.pMj.mI();
                    qfVar.mtk = true;
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qgVar = new qe();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qgVar.a(aVar4, qgVar, a.a(aVar4))) {
                        }
                        qfVar.mte = qgVar;
                    }
                    qfVar.mtf = true;
                    return 0;
                case 11:
                    qfVar.mtn = aVar3.pMj.mI();
                    qfVar.mto = true;
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qgVar = new qj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qgVar.a(aVar4, qgVar, a.a(aVar4))) {
                        }
                        qfVar.mtg = qgVar;
                    }
                    qfVar.mth = true;
                    return 0;
                case 13:
                    qfVar.version = aVar3.pMj.mH();
                    qfVar.mtT = true;
                    return 0;
                case 91:
                    qfVar.mtl = aVar3.pMj.mH();
                    qfVar.mtm = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
