package com.tencent.mm.plugin.qqmail.b;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class d extends a {
    public String content;
    public int iap;
    public String iaq;
    public LinkedList<i> iar = new LinkedList();
    public LinkedList<i> ias = new LinkedList();
    public LinkedList<i> iat = new LinkedList();
    public LinkedList<z> iau = new LinkedList();
    public String iav;
    public int iaw = 5;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.content == null) {
                throw new b("Not all required fields were included: content");
            }
            aVar.dV(1, this.iap);
            if (this.iaq != null) {
                aVar.e(2, this.iaq);
            }
            aVar.d(3, 8, this.iar);
            aVar.d(4, 8, this.ias);
            aVar.d(5, 8, this.iat);
            aVar.d(6, 8, this.iau);
            if (this.iav != null) {
                aVar.e(7, this.iav);
            }
            if (this.content != null) {
                aVar.e(8, this.content);
            }
            aVar.dV(9, this.iaw);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.iap) + 0;
            if (this.iaq != null) {
                r0 += a.a.a.b.b.a.f(2, this.iaq);
            }
            r0 = (((r0 + a.a.a.a.c(3, 8, this.iar)) + a.a.a.a.c(4, 8, this.ias)) + a.a.a.a.c(5, 8, this.iat)) + a.a.a.a.c(6, 8, this.iau);
            if (this.iav != null) {
                r0 += a.a.a.b.b.a.f(7, this.iav);
            }
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(8, this.content);
            }
            return r0 + a.a.a.a.dS(9, this.iaw);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.iar.clear();
            this.ias.clear();
            this.iat.clear();
            this.iau.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.content != null) {
                return 0;
            }
            throw new b("Not all required fields were included: content");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            i iVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dVar.iap = aVar3.pMj.mH();
                    return 0;
                case 2:
                    dVar.iaq = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        iVar = new i();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.iar.add(iVar);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        iVar = new i();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ias.add(iVar);
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        iVar = new i();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.iat.add(iVar);
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        z zVar = new z();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = zVar.a(aVar4, zVar, a.a(aVar4))) {
                        }
                        dVar.iau.add(zVar);
                    }
                    return 0;
                case 7:
                    dVar.iav = aVar3.pMj.readString();
                    return 0;
                case 8:
                    dVar.content = aVar3.pMj.readString();
                    return 0;
                case 9:
                    dVar.iaw = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
