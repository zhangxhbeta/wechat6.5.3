package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qp extends a {
    public String bea;
    public String canvasPageXml;
    public int cog;
    public String desc;
    public boolean mrL = false;
    public boolean mrM = false;
    public boolean msX = false;
    public boolean mtM = false;
    public String mur;
    public boolean mus = false;
    public int mut;
    public boolean muu = false;
    public boolean muv = false;
    public String title;

    public final qp JA(String str) {
        this.title = str;
        this.mrL = true;
        return this;
    }

    public final qp JB(String str) {
        this.desc = str;
        this.mrM = true;
        return this;
    }

    public final qp JC(String str) {
        this.mur = str;
        this.mus = true;
        return this;
    }

    public final qp JD(String str) {
        this.bea = str;
        this.mtM = true;
        return this;
    }

    public final qp uO(int i) {
        this.mut = i;
        this.muu = true;
        return this;
    }

    public final qp uP(int i) {
        this.cog = i;
        this.muv = true;
        return this;
    }

    public final qp JE(String str) {
        this.canvasPageXml = str;
        this.msX = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.mur != null) {
                aVar.e(3, this.mur);
            }
            if (this.bea != null) {
                aVar.e(4, this.bea);
            }
            if (this.muu) {
                aVar.dV(5, this.mut);
            }
            if (this.muv) {
                aVar.dV(6, this.cog);
            }
            if (this.canvasPageXml == null) {
                return 0;
            }
            aVar.e(7, this.canvasPageXml);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            if (this.mur != null) {
                r0 += a.a.a.b.b.a.f(3, this.mur);
            }
            if (this.bea != null) {
                r0 += a.a.a.b.b.a.f(4, this.bea);
            }
            if (this.muu) {
                r0 += a.a.a.a.dS(5, this.mut);
            }
            if (this.muv) {
                r0 += a.a.a.a.dS(6, this.cog);
            }
            if (this.canvasPageXml != null) {
                r0 += a.a.a.b.b.a.f(7, this.canvasPageXml);
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
            qp qpVar = (qp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qpVar.title = aVar3.pMj.readString();
                    qpVar.mrL = true;
                    return 0;
                case 2:
                    qpVar.desc = aVar3.pMj.readString();
                    qpVar.mrM = true;
                    return 0;
                case 3:
                    qpVar.mur = aVar3.pMj.readString();
                    qpVar.mus = true;
                    return 0;
                case 4:
                    qpVar.bea = aVar3.pMj.readString();
                    qpVar.mtM = true;
                    return 0;
                case 5:
                    qpVar.mut = aVar3.pMj.mH();
                    qpVar.muu = true;
                    return 0;
                case 6:
                    qpVar.cog = aVar3.pMj.mH();
                    qpVar.muv = true;
                    return 0;
                case 7:
                    qpVar.canvasPageXml = aVar3.pMj.readString();
                    qpVar.msX = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
