package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class e extends a {
    public int lXD;
    public LinkedList<d> lXE = new LinkedList();
    public String lXN;
    public String lXO;
    public String lXP;
    public String lXQ;
    public String lXR;
    public int lXS;
    public int nettype;
    public int uin;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.uin);
            aVar.dV(2, this.lXD);
            aVar.dV(3, this.nettype);
            aVar.d(4, 8, this.lXE);
            if (this.lXN != null) {
                aVar.e(5, this.lXN);
            }
            if (this.lXO != null) {
                aVar.e(6, this.lXO);
            }
            if (this.lXP != null) {
                aVar.e(7, this.lXP);
            }
            if (this.lXQ != null) {
                aVar.e(8, this.lXQ);
            }
            if (this.lXR != null) {
                aVar.e(9, this.lXR);
            }
            aVar.dV(10, this.lXS);
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.dS(1, this.uin) + 0) + a.a.a.a.dS(2, this.lXD)) + a.a.a.a.dS(3, this.nettype)) + a.a.a.a.c(4, 8, this.lXE);
            if (this.lXN != null) {
                r0 += a.a.a.b.b.a.f(5, this.lXN);
            }
            if (this.lXO != null) {
                r0 += a.a.a.b.b.a.f(6, this.lXO);
            }
            if (this.lXP != null) {
                r0 += a.a.a.b.b.a.f(7, this.lXP);
            }
            if (this.lXQ != null) {
                r0 += a.a.a.b.b.a.f(8, this.lXQ);
            }
            if (this.lXR != null) {
                r0 += a.a.a.b.b.a.f(9, this.lXR);
            }
            return r0 + a.a.a.a.dS(10, this.lXS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lXE.clear();
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
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.uin = aVar3.pMj.mH();
                    return 0;
                case 2:
                    eVar.lXD = aVar3.pMj.mH();
                    return 0;
                case 3:
                    eVar.nettype = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a dVar = new d();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        eVar.lXE.add(dVar);
                    }
                    return 0;
                case 5:
                    eVar.lXN = aVar3.pMj.readString();
                    return 0;
                case 6:
                    eVar.lXO = aVar3.pMj.readString();
                    return 0;
                case 7:
                    eVar.lXP = aVar3.pMj.readString();
                    return 0;
                case 8:
                    eVar.lXQ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    eVar.lXR = aVar3.pMj.readString();
                    return 0;
                case 10:
                    eVar.lXS = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
