package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class c extends a {
    public int eha;
    public int eho;
    public String ehp;
    public int ehq;
    public int ehr;
    public LinkedList<String> ehs = new LinkedList();
    public LinkedList<String> eht = new LinkedList();
    public int ehu;
    public int ehv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.eho);
            if (this.ehp != null) {
                aVar.e(2, this.ehp);
            }
            aVar.dV(3, this.ehq);
            aVar.dV(4, this.ehr);
            aVar.d(5, 1, this.ehs);
            aVar.d(6, 1, this.eht);
            aVar.dV(7, this.ehu);
            aVar.dV(8, this.eha);
            aVar.dV(9, this.ehv);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.eho) + 0;
            if (this.ehp != null) {
                r0 += a.a.a.b.b.a.f(2, this.ehp);
            }
            return ((((((r0 + a.a.a.a.dS(3, this.ehq)) + a.a.a.a.dS(4, this.ehr)) + a.a.a.a.c(5, 1, this.ehs)) + a.a.a.a.c(6, 1, this.eht)) + a.a.a.a.dS(7, this.ehu)) + a.a.a.a.dS(8, this.eha)) + a.a.a.a.dS(9, this.ehv);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.ehs.clear();
            this.eht.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.eho = aVar3.pMj.mH();
                    return 0;
                case 2:
                    cVar.ehp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    cVar.ehq = aVar3.pMj.mH();
                    return 0;
                case 4:
                    cVar.ehr = aVar3.pMj.mH();
                    return 0;
                case 5:
                    cVar.ehs.add(aVar3.pMj.readString());
                    return 0;
                case 6:
                    cVar.eht.add(aVar3.pMj.readString());
                    return 0;
                case 7:
                    cVar.ehu = aVar3.pMj.mH();
                    return 0;
                case 8:
                    cVar.eha = aVar3.pMj.mH();
                    return 0;
                case 9:
                    cVar.ehv = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
