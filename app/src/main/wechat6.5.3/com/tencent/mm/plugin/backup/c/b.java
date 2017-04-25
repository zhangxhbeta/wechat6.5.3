package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class b extends a {
    public String ID;
    public d eeh;
    public int eei;
    public int eej;
    public int eek;
    public int eel;
    public int eem;
    public int een;
    public int eeo;
    public int eep;
    public int eeq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new a.a.a.b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            if (this.eeh != null) {
                aVar.dX(2, this.eeh.aHr());
                this.eeh.a(aVar);
            }
            aVar.dV(3, this.eei);
            aVar.dV(4, this.eej);
            aVar.dV(5, this.eek);
            aVar.dV(6, this.eel);
            aVar.dV(7, this.eem);
            aVar.dV(8, this.een);
            aVar.dV(9, this.eeo);
            aVar.dV(10, this.eep);
            aVar.dV(11, this.eeq);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            if (this.eeh != null) {
                r0 += a.a.a.a.dU(2, this.eeh.aHr());
            }
            return ((((((((r0 + a.a.a.a.dS(3, this.eei)) + a.a.a.a.dS(4, this.eej)) + a.a.a.a.dS(5, this.eek)) + a.a.a.a.dS(6, this.eel)) + a.a.a.a.dS(7, this.eem)) + a.a.a.a.dS(8, this.een)) + a.a.a.a.dS(9, this.eeo)) + a.a.a.a.dS(10, this.eep)) + a.a.a.a.dS(11, this.eeq);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.ID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a dVar = new d();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        bVar.eeh = dVar;
                    }
                    return 0;
                case 3:
                    bVar.eei = aVar3.pMj.mH();
                    return 0;
                case 4:
                    bVar.eej = aVar3.pMj.mH();
                    return 0;
                case 5:
                    bVar.eek = aVar3.pMj.mH();
                    return 0;
                case 6:
                    bVar.eel = aVar3.pMj.mH();
                    return 0;
                case 7:
                    bVar.eem = aVar3.pMj.mH();
                    return 0;
                case 8:
                    bVar.een = aVar3.pMj.mH();
                    return 0;
                case 9:
                    bVar.eeo = aVar3.pMj.mH();
                    return 0;
                case 10:
                    bVar.eep = aVar3.pMj.mH();
                    return 0;
                case 11:
                    bVar.eeq = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
