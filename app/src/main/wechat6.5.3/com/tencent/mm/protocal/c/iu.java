package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class iu extends a {
    public String code;
    public String mkA;
    public int mkg;
    public int mkh;
    public LinkedList<jg> mki = new LinkedList();
    public LinkedList<jg> mkj = new LinkedList();
    public LinkedList<jg> mkk = new LinkedList();
    public LinkedList<String> mkl = new LinkedList();
    public int mkm;
    public int mkn;
    public LinkedList<ld> mko = new LinkedList();
    public long mkp;
    public int mkq;
    public String mkr;
    public ld mks;
    public LinkedList<an> mkt = new LinkedList();
    public ld mku;
    public ld mkv;
    public ld mkw;
    public ne mkx;
    public String mky;
    public ld mkz;
    public int status;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.status);
            aVar.dV(2, this.mkg);
            aVar.dV(3, this.mkh);
            aVar.d(4, 8, this.mki);
            aVar.d(5, 8, this.mkj);
            aVar.d(6, 8, this.mkk);
            aVar.d(7, 1, this.mkl);
            aVar.dV(8, this.mkm);
            if (this.code != null) {
                aVar.e(9, this.code);
            }
            aVar.dV(10, this.mkn);
            aVar.d(11, 8, this.mko);
            aVar.C(12, this.mkp);
            aVar.dV(13, this.mkq);
            if (this.mkr != null) {
                aVar.e(14, this.mkr);
            }
            if (this.mks != null) {
                aVar.dX(15, this.mks.aHr());
                this.mks.a(aVar);
            }
            aVar.d(16, 8, this.mkt);
            if (this.mku != null) {
                aVar.dX(17, this.mku.aHr());
                this.mku.a(aVar);
            }
            if (this.mkv != null) {
                aVar.dX(18, this.mkv.aHr());
                this.mkv.a(aVar);
            }
            if (this.mkw != null) {
                aVar.dX(19, this.mkw.aHr());
                this.mkw.a(aVar);
            }
            if (this.mkx != null) {
                aVar.dX(20, this.mkx.aHr());
                this.mkx.a(aVar);
            }
            if (this.mky != null) {
                aVar.e(21, this.mky);
            }
            if (this.mkz != null) {
                aVar.dX(22, this.mkz.aHr());
                this.mkz.a(aVar);
            }
            if (this.mkA != null) {
                aVar.e(23, this.mkA);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((((a.a.a.a.dS(1, this.status) + 0) + a.a.a.a.dS(2, this.mkg)) + a.a.a.a.dS(3, this.mkh)) + a.a.a.a.c(4, 8, this.mki)) + a.a.a.a.c(5, 8, this.mkj)) + a.a.a.a.c(6, 8, this.mkk)) + a.a.a.a.c(7, 1, this.mkl)) + a.a.a.a.dS(8, this.mkm);
            if (this.code != null) {
                r0 += a.a.a.b.b.a.f(9, this.code);
            }
            r0 = (((r0 + a.a.a.a.dS(10, this.mkn)) + a.a.a.a.c(11, 8, this.mko)) + a.a.a.a.B(12, this.mkp)) + a.a.a.a.dS(13, this.mkq);
            if (this.mkr != null) {
                r0 += a.a.a.b.b.a.f(14, this.mkr);
            }
            if (this.mks != null) {
                r0 += a.a.a.a.dU(15, this.mks.aHr());
            }
            r0 += a.a.a.a.c(16, 8, this.mkt);
            if (this.mku != null) {
                r0 += a.a.a.a.dU(17, this.mku.aHr());
            }
            if (this.mkv != null) {
                r0 += a.a.a.a.dU(18, this.mkv.aHr());
            }
            if (this.mkw != null) {
                r0 += a.a.a.a.dU(19, this.mkw.aHr());
            }
            if (this.mkx != null) {
                r0 += a.a.a.a.dU(20, this.mkx.aHr());
            }
            if (this.mky != null) {
                r0 += a.a.a.b.b.a.f(21, this.mky);
            }
            if (this.mkz != null) {
                r0 += a.a.a.a.dU(22, this.mkz.aHr());
            }
            if (this.mkA != null) {
                return r0 + a.a.a.b.b.a.f(23, this.mkA);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mki.clear();
            this.mkj.clear();
            this.mkk.clear();
            this.mkl.clear();
            this.mko.clear();
            this.mkt.clear();
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
            iu iuVar = (iu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            jg jgVar;
            a.a.a.a.a aVar4;
            boolean z;
            ld ldVar;
            switch (intValue) {
                case 1:
                    iuVar.status = aVar3.pMj.mH();
                    return 0;
                case 2:
                    iuVar.mkg = aVar3.pMj.mH();
                    return 0;
                case 3:
                    iuVar.mkh = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        jgVar = new jg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        iuVar.mki.add(jgVar);
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        jgVar = new jg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        iuVar.mkj.add(jgVar);
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        jgVar = new jg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        iuVar.mkk.add(jgVar);
                    }
                    return 0;
                case 7:
                    iuVar.mkl.add(aVar3.pMj.readString());
                    return 0;
                case 8:
                    iuVar.mkm = aVar3.pMj.mH();
                    return 0;
                case 9:
                    iuVar.code = aVar3.pMj.readString();
                    return 0;
                case 10:
                    iuVar.mkn = aVar3.pMj.mH();
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        iuVar.mko.add(ldVar);
                    }
                    return 0;
                case 12:
                    iuVar.mkp = aVar3.pMj.mI();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    iuVar.mkq = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    iuVar.mkr = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        iuVar.mks = ldVar;
                    }
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        an anVar = new an();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = anVar.a(aVar4, anVar, a.a(aVar4))) {
                        }
                        iuVar.mkt.add(anVar);
                    }
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        iuVar.mku = ldVar;
                    }
                    return 0;
                case 18:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        iuVar.mkv = ldVar;
                    }
                    return 0;
                case 19:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        iuVar.mkw = ldVar;
                    }
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ne neVar = new ne();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = neVar.a(aVar4, neVar, a.a(aVar4))) {
                        }
                        iuVar.mkx = neVar;
                    }
                    return 0;
                case 21:
                    iuVar.mky = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        iuVar.mkz = ldVar;
                    }
                    return 0;
                case 23:
                    iuVar.mkA = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
