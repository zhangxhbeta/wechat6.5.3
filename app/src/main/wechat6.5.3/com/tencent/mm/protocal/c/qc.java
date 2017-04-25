package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qc extends a {
    public int bhu;
    public String bkV;
    public String label;
    public double lat;
    public double lng;
    public boolean mtH = false;
    public boolean mtI = false;
    public boolean mtJ = false;
    public boolean mtK = false;
    public boolean mtL = false;

    public final qc j(double d) {
        this.lng = d;
        this.mtH = true;
        return this;
    }

    public final qc k(double d) {
        this.lat = d;
        this.mtI = true;
        return this;
    }

    public final qc uJ(int i) {
        this.bhu = i;
        this.mtJ = true;
        return this;
    }

    public final qc Je(String str) {
        this.label = str;
        this.mtK = true;
        return this;
    }

    public final qc Jf(String str) {
        this.bkV = str;
        this.mtL = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtH) {
                aVar.a(1, this.lng);
            }
            if (this.mtI) {
                aVar.a(2, this.lat);
            }
            if (this.mtJ) {
                aVar.dV(3, this.bhu);
            }
            if (this.label != null) {
                aVar.e(4, this.label);
            }
            if (this.bkV == null) {
                return 0;
            }
            aVar.e(5, this.bkV);
            return 0;
        } else if (i == 1) {
            if (this.mtH) {
                r0 = (a.a.a.b.b.a.cw(1) + 8) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtI) {
                r0 += a.a.a.b.b.a.cw(2) + 8;
            }
            if (this.mtJ) {
                r0 += a.a.a.a.dS(3, this.bhu);
            }
            if (this.label != null) {
                r0 += a.a.a.b.b.a.f(4, this.label);
            }
            if (this.bkV != null) {
                r0 += a.a.a.b.b.a.f(5, this.bkV);
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
            qc qcVar = (qc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qcVar.lng = aVar3.pMj.readDouble();
                    qcVar.mtH = true;
                    return 0;
                case 2:
                    qcVar.lat = aVar3.pMj.readDouble();
                    qcVar.mtI = true;
                    return 0;
                case 3:
                    qcVar.bhu = aVar3.pMj.mH();
                    qcVar.mtJ = true;
                    return 0;
                case 4:
                    qcVar.label = aVar3.pMj.readString();
                    qcVar.mtK = true;
                    return 0;
                case 5:
                    qcVar.bkV = aVar3.pMj.readString();
                    qcVar.mtL = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
