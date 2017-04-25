package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class hp extends a {
    public String miv;
    public int miw;
    public String mix;
    public int miy;
    public LinkedList<gn> miz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.miv != null) {
                aVar.e(1, this.miv);
            }
            aVar.dV(2, this.miw);
            if (this.mix != null) {
                aVar.e(3, this.mix);
            }
            aVar.dV(4, this.miy);
            aVar.d(5, 8, this.miz);
            return 0;
        } else if (i == 1) {
            if (this.miv != null) {
                r0 = a.a.a.b.b.a.f(1, this.miv) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.miw);
            if (this.mix != null) {
                r0 += a.a.a.b.b.a.f(3, this.mix);
            }
            return (r0 + a.a.a.a.dS(4, this.miy)) + a.a.a.a.c(5, 8, this.miz);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.miz.clear();
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
            hp hpVar = (hp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hpVar.miv = aVar3.pMj.readString();
                    return 0;
                case 2:
                    hpVar.miw = aVar3.pMj.mH();
                    return 0;
                case 3:
                    hpVar.mix = aVar3.pMj.readString();
                    return 0;
                case 4:
                    hpVar.miy = aVar3.pMj.mH();
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a gnVar = new gn();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = gnVar.a(aVar4, gnVar, a.a(aVar4))) {
                        }
                        hpVar.miz.add(gnVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
