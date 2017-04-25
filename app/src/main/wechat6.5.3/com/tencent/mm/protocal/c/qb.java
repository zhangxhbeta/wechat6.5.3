package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class qb extends a {
    public String aWH;
    public String appId;
    public String bhM;
    public qf bmi;
    public String desc;
    public String mtF;
    public LinkedList<String> mtG = new LinkedList();
    public String title;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.bhM != null) {
                aVar.e(3, this.bhM);
            }
            if (this.mtF != null) {
                aVar.e(4, this.mtF);
            }
            if (this.appId != null) {
                aVar.e(5, this.appId);
            }
            if (this.aWH != null) {
                aVar.e(6, this.aWH);
            }
            aVar.d(7, 1, this.mtG);
            aVar.dV(8, this.type);
            if (this.bmi == null) {
                return 0;
            }
            aVar.dX(9, this.bmi.aHr());
            this.bmi.a(aVar);
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
            if (this.bhM != null) {
                r0 += a.a.a.b.b.a.f(3, this.bhM);
            }
            if (this.mtF != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtF);
            }
            if (this.appId != null) {
                r0 += a.a.a.b.b.a.f(5, this.appId);
            }
            if (this.aWH != null) {
                r0 += a.a.a.b.b.a.f(6, this.aWH);
            }
            r0 = (r0 + a.a.a.a.c(7, 1, this.mtG)) + a.a.a.a.dS(8, this.type);
            if (this.bmi != null) {
                r0 += a.a.a.a.dU(9, this.bmi.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mtG.clear();
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
            qb qbVar = (qb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qbVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    qbVar.desc = aVar3.pMj.readString();
                    return 0;
                case 3:
                    qbVar.bhM = aVar3.pMj.readString();
                    return 0;
                case 4:
                    qbVar.mtF = aVar3.pMj.readString();
                    return 0;
                case 5:
                    qbVar.appId = aVar3.pMj.readString();
                    return 0;
                case 6:
                    qbVar.aWH = aVar3.pMj.readString();
                    return 0;
                case 7:
                    qbVar.mtG.add(aVar3.pMj.readString());
                    return 0;
                case 8:
                    qbVar.type = aVar3.pMj.mH();
                    return 0;
                case 9:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a qfVar = new qf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = qfVar.a(aVar4, qfVar, a.a(aVar4))) {
                        }
                        qbVar.bmi = qfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
