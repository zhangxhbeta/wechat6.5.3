package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qe extends a {
    public String bea;
    public String desc;
    public String info;
    public boolean mrL = false;
    public boolean mrM = false;
    public boolean mtM = false;
    public boolean mtN = false;
    public boolean mtO = false;
    public String title;
    public int type;

    public final qe Jg(String str) {
        this.title = str;
        this.mrL = true;
        return this;
    }

    public final qe Jh(String str) {
        this.desc = str;
        this.mrM = true;
        return this;
    }

    public final qe Ji(String str) {
        this.bea = str;
        this.mtM = true;
        return this;
    }

    public final qe Jj(String str) {
        this.info = str;
        this.mtN = true;
        return this;
    }

    public final qe uK(int i) {
        this.type = i;
        this.mtO = true;
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
            if (this.bea != null) {
                aVar.e(3, this.bea);
            }
            if (this.info != null) {
                aVar.e(4, this.info);
            }
            if (!this.mtO) {
                return 0;
            }
            aVar.dV(5, this.type);
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
            if (this.bea != null) {
                r0 += a.a.a.b.b.a.f(3, this.bea);
            }
            if (this.info != null) {
                r0 += a.a.a.b.b.a.f(4, this.info);
            }
            if (this.mtO) {
                r0 += a.a.a.a.dS(5, this.type);
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
            qe qeVar = (qe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qeVar.title = aVar3.pMj.readString();
                    qeVar.mrL = true;
                    return 0;
                case 2:
                    qeVar.desc = aVar3.pMj.readString();
                    qeVar.mrM = true;
                    return 0;
                case 3:
                    qeVar.bea = aVar3.pMj.readString();
                    qeVar.mtM = true;
                    return 0;
                case 4:
                    qeVar.info = aVar3.pMj.readString();
                    qeVar.mtN = true;
                    return 0;
                case 5:
                    qeVar.type = aVar3.pMj.mH();
                    qeVar.mtO = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
