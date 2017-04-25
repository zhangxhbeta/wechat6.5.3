package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class py extends a {
    public String aWH;
    public int aYX;
    public String appId;
    public String bhM;
    public String blm;
    public String bqi;
    public boolean cLO = false;
    public String cZp;
    public long dhH;
    public String mtA;
    public boolean mtB = false;
    public boolean mtC = false;
    public boolean mtp = false;
    public boolean mtq = false;
    public boolean mtr = false;
    public String mts;
    public boolean mtt = false;
    public String mtu;
    public boolean mtv = false;
    public boolean mtw = false;
    public boolean mtx = false;
    public boolean mty = false;
    public boolean mtz = false;
    public String toUser;

    public final py uI(int i) {
        this.aYX = i;
        this.mtp = true;
        return this;
    }

    public final py IW(String str) {
        this.bhM = str;
        this.mtq = true;
        return this;
    }

    public final py IX(String str) {
        this.toUser = str;
        this.mtr = true;
        return this;
    }

    public final py IY(String str) {
        this.mts = str;
        this.mtt = true;
        return this;
    }

    public final py IZ(String str) {
        this.mtu = str;
        this.mtv = true;
        return this;
    }

    public final py dS(long j) {
        this.dhH = j;
        this.cLO = true;
        return this;
    }

    public final py Ja(String str) {
        this.blm = str;
        this.mtw = true;
        return this;
    }

    public final py Jb(String str) {
        this.appId = str;
        this.mty = true;
        return this;
    }

    public final py Jc(String str) {
        this.cZp = str;
        this.mtz = true;
        return this;
    }

    public final py Jd(String str) {
        this.aWH = str;
        this.mtC = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtp) {
                if (this.mtp) {
                    aVar.dV(1, this.aYX);
                }
                if (this.bhM != null) {
                    aVar.e(2, this.bhM);
                }
                if (this.toUser != null) {
                    aVar.e(3, this.toUser);
                }
                if (this.mts != null) {
                    aVar.e(4, this.mts);
                }
                if (this.mtu != null) {
                    aVar.e(5, this.mtu);
                }
                if (this.cLO) {
                    aVar.C(6, this.dhH);
                }
                if (this.blm != null) {
                    aVar.e(7, this.blm);
                }
                if (this.bqi != null) {
                    aVar.e(8, this.bqi);
                }
                if (this.appId != null) {
                    aVar.e(9, this.appId);
                }
                if (this.cZp != null) {
                    aVar.e(10, this.cZp);
                }
                if (this.mtA != null) {
                    aVar.e(11, this.mtA);
                }
                if (this.aWH == null) {
                    return 0;
                }
                aVar.e(12, this.aWH);
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i == 1) {
            if (this.mtp) {
                r0 = a.a.a.a.dS(1, this.aYX) + 0;
            } else {
                r0 = 0;
            }
            if (this.bhM != null) {
                r0 += a.a.a.b.b.a.f(2, this.bhM);
            }
            if (this.toUser != null) {
                r0 += a.a.a.b.b.a.f(3, this.toUser);
            }
            if (this.mts != null) {
                r0 += a.a.a.b.b.a.f(4, this.mts);
            }
            if (this.mtu != null) {
                r0 += a.a.a.b.b.a.f(5, this.mtu);
            }
            if (this.cLO) {
                r0 += a.a.a.a.B(6, this.dhH);
            }
            if (this.blm != null) {
                r0 += a.a.a.b.b.a.f(7, this.blm);
            }
            if (this.bqi != null) {
                r0 += a.a.a.b.b.a.f(8, this.bqi);
            }
            if (this.appId != null) {
                r0 += a.a.a.b.b.a.f(9, this.appId);
            }
            if (this.cZp != null) {
                r0 += a.a.a.b.b.a.f(10, this.cZp);
            }
            if (this.mtA != null) {
                r0 += a.a.a.b.b.a.f(11, this.mtA);
            }
            if (this.aWH != null) {
                r0 += a.a.a.b.b.a.f(12, this.aWH);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mtp) {
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            py pyVar = (py) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pyVar.aYX = aVar3.pMj.mH();
                    pyVar.mtp = true;
                    return 0;
                case 2:
                    pyVar.bhM = aVar3.pMj.readString();
                    pyVar.mtq = true;
                    return 0;
                case 3:
                    pyVar.toUser = aVar3.pMj.readString();
                    pyVar.mtr = true;
                    return 0;
                case 4:
                    pyVar.mts = aVar3.pMj.readString();
                    pyVar.mtt = true;
                    return 0;
                case 5:
                    pyVar.mtu = aVar3.pMj.readString();
                    pyVar.mtv = true;
                    return 0;
                case 6:
                    pyVar.dhH = aVar3.pMj.mI();
                    pyVar.cLO = true;
                    return 0;
                case 7:
                    pyVar.blm = aVar3.pMj.readString();
                    pyVar.mtw = true;
                    return 0;
                case 8:
                    pyVar.bqi = aVar3.pMj.readString();
                    pyVar.mtx = true;
                    return 0;
                case 9:
                    pyVar.appId = aVar3.pMj.readString();
                    pyVar.mty = true;
                    return 0;
                case 10:
                    pyVar.cZp = aVar3.pMj.readString();
                    pyVar.mtz = true;
                    return 0;
                case 11:
                    pyVar.mtA = aVar3.pMj.readString();
                    pyVar.mtB = true;
                    return 0;
                case 12:
                    pyVar.aWH = aVar3.pMj.readString();
                    pyVar.mtC = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
