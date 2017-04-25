package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.util.LinkedList;

public final class px extends a {
    public String desc;
    public String gxy;
    public boolean mrL = false;
    public boolean mrM = false;
    public py msY;
    public boolean msZ = false;
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

    public final px c(py pyVar) {
        this.msY = pyVar;
        this.msZ = true;
        return this;
    }

    public final px a(qc qcVar) {
        this.mta = qcVar;
        this.mtb = true;
        return this;
    }

    public final px a(qp qpVar) {
        this.mtc = qpVar;
        this.mtd = true;
        return this;
    }

    public final px a(qe qeVar) {
        this.mte = qeVar;
        this.mtf = true;
        return this;
    }

    public final px a(qj qjVar) {
        this.mtg = qjVar;
        this.mth = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msY != null) {
                aVar.dX(1, this.msY.aHr());
                this.msY.a(aVar);
            }
            if (this.mta != null) {
                aVar.dX(2, this.mta.aHr());
                this.mta.a(aVar);
            }
            if (this.mtc != null) {
                aVar.dX(3, this.mtc.aHr());
                this.mtc.a(aVar);
            }
            if (this.mte != null) {
                aVar.dX(4, this.mte.aHr());
                this.mte.a(aVar);
            }
            if (this.mtg != null) {
                aVar.dX(5, this.mtg.aHr());
                this.mtg.a(aVar);
            }
            if (this.gxy != null) {
                aVar.e(6, this.gxy);
            }
            if (this.title != null) {
                aVar.e(7, this.title);
            }
            if (this.desc != null) {
                aVar.e(8, this.desc);
            }
            if (this.mtk) {
                aVar.C(9, this.mtj);
            }
            if (this.mtm) {
                aVar.dV(MMGIFException.D_GIF_ERR_OPEN_FAILED, this.mtl);
            }
            if (!this.mto) {
                return 0;
            }
            aVar.C(11, this.mtn);
            return 0;
        } else if (i == 1) {
            if (this.msY != null) {
                r0 = a.a.a.a.dU(1, this.msY.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mta != null) {
                r0 += a.a.a.a.dU(2, this.mta.aHr());
            }
            if (this.mtc != null) {
                r0 += a.a.a.a.dU(3, this.mtc.aHr());
            }
            if (this.mte != null) {
                r0 += a.a.a.a.dU(4, this.mte.aHr());
            }
            if (this.mtg != null) {
                r0 += a.a.a.a.dU(5, this.mtg.aHr());
            }
            if (this.gxy != null) {
                r0 += a.a.a.b.b.a.f(6, this.gxy);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(7, this.title);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(8, this.desc);
            }
            if (this.mtk) {
                r0 += a.a.a.a.B(9, this.mtj);
            }
            if (this.mtm) {
                r0 += a.a.a.a.dS(MMGIFException.D_GIF_ERR_OPEN_FAILED, this.mtl);
            }
            if (this.mto) {
                r0 += a.a.a.a.B(11, this.mtn);
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
            px pxVar = (px) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a pyVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        pyVar = new py();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pyVar.a(aVar4, pyVar, a.a(aVar4))) {
                        }
                        pxVar.msY = pyVar;
                    }
                    pxVar.msZ = true;
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        pyVar = new qc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pyVar.a(aVar4, pyVar, a.a(aVar4))) {
                        }
                        pxVar.mta = pyVar;
                    }
                    pxVar.mtb = true;
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        pyVar = new qp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pyVar.a(aVar4, pyVar, a.a(aVar4))) {
                        }
                        pxVar.mtc = pyVar;
                    }
                    pxVar.mtd = true;
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        pyVar = new qe();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pyVar.a(aVar4, pyVar, a.a(aVar4))) {
                        }
                        pxVar.mte = pyVar;
                    }
                    pxVar.mtf = true;
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        pyVar = new qj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pyVar.a(aVar4, pyVar, a.a(aVar4))) {
                        }
                        pxVar.mtg = pyVar;
                    }
                    pxVar.mth = true;
                    return 0;
                case 6:
                    pxVar.gxy = aVar3.pMj.readString();
                    pxVar.mti = true;
                    return 0;
                case 7:
                    pxVar.title = aVar3.pMj.readString();
                    pxVar.mrL = true;
                    return 0;
                case 8:
                    pxVar.desc = aVar3.pMj.readString();
                    pxVar.mrM = true;
                    return 0;
                case 9:
                    pxVar.mtj = aVar3.pMj.mI();
                    pxVar.mtk = true;
                    return 0;
                case 11:
                    pxVar.mtn = aVar3.pMj.mI();
                    pxVar.mto = true;
                    return 0;
                case MMGIFException.D_GIF_ERR_OPEN_FAILED /*101*/:
                    pxVar.mtl = aVar3.pMj.mH();
                    pxVar.mtm = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
