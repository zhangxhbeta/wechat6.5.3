package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class a extends i {
    public String eeA;
    public b fvs;
    public int fvt;
    public int fvu;
    public int fvv;
    public b fvw;
    public b fvx;
    public String fvy;
    public String fvz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fvS != null) {
                aVar.dX(1, this.fvS.aHr());
                this.fvS.a(aVar);
            }
            if (this.fvs != null) {
                aVar.b(2, this.fvs);
            }
            aVar.dV(3, this.fvt);
            aVar.dV(4, this.fvu);
            aVar.dV(5, this.fvv);
            if (this.fvw != null) {
                aVar.b(6, this.fvw);
            }
            if (this.fvx != null) {
                aVar.b(7, this.fvx);
            }
            if (this.fvy != null) {
                aVar.e(10, this.fvy);
            }
            if (this.fvz != null) {
                aVar.e(11, this.fvz);
            }
            if (this.eeA == null) {
                return 0;
            }
            aVar.e(12, this.eeA);
            return 0;
        } else if (i == 1) {
            if (this.fvS != null) {
                r0 = a.a.a.a.dU(1, this.fvS.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fvs != null) {
                r0 += a.a.a.a.a(2, this.fvs);
            }
            r0 = ((r0 + a.a.a.a.dS(3, this.fvt)) + a.a.a.a.dS(4, this.fvu)) + a.a.a.a.dS(5, this.fvv);
            if (this.fvw != null) {
                r0 += a.a.a.a.a(6, this.fvw);
            }
            if (this.fvx != null) {
                r0 += a.a.a.a.a(7, this.fvx);
            }
            if (this.fvy != null) {
                r0 += a.a.a.b.b.a.f(10, this.fvy);
            }
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(11, this.fvz);
            }
            if (this.eeA != null) {
                r0 += a.a.a.b.b.a.f(12, this.eeA);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = i.a(aVar2); r0 > 0; r0 = i.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar5, dVar, i.a(aVar5))) {
                        }
                        aVar4.fvS = dVar;
                    }
                    return 0;
                case 2:
                    aVar4.fvs = aVar3.bQK();
                    return 0;
                case 3:
                    aVar4.fvt = aVar3.pMj.mH();
                    return 0;
                case 4:
                    aVar4.fvu = aVar3.pMj.mH();
                    return 0;
                case 5:
                    aVar4.fvv = aVar3.pMj.mH();
                    return 0;
                case 6:
                    aVar4.fvw = aVar3.bQK();
                    return 0;
                case 7:
                    aVar4.fvx = aVar3.bQK();
                    return 0;
                case 10:
                    aVar4.fvy = aVar3.pMj.readString();
                    return 0;
                case 11:
                    aVar4.fvz = aVar3.pMj.readString();
                    return 0;
                case 12:
                    aVar4.eeA = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
