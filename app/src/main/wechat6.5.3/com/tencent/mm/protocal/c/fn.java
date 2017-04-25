package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class fn extends a {
    public LinkedList<fm> mfV = new LinkedList();
    public fl mfW;
    public int mfX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mfV);
            if (this.mfW != null) {
                aVar.dX(2, this.mfW.aHr());
                this.mfW.a(aVar);
            }
            aVar.dV(3, this.mfX);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.mfV) + 0;
            if (this.mfW != null) {
                r0 += a.a.a.a.dU(2, this.mfW.aHr());
            }
            return r0 + a.a.a.a.dS(3, this.mfX);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mfV.clear();
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
            fn fnVar = (fn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        fm fmVar = new fm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fmVar.a(aVar4, fmVar, a.a(aVar4))) {
                        }
                        fnVar.mfV.add(fmVar);
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, a.a(aVar4))) {
                        }
                        fnVar.mfW = flVar;
                    }
                    return 0;
                case 3:
                    fnVar.mfX = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
