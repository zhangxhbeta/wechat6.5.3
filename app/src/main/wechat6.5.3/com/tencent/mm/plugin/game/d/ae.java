package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.eo;
import java.util.LinkedList;

public final class ae extends aqx {
    public bb gmr;
    public LinkedList<b> gms = new LinkedList();
    public boolean gmt;
    public int gmu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            if (this.gmr != null) {
                aVar.dX(2, this.gmr.aHr());
                this.gmr.a(aVar);
            }
            aVar.d(3, 8, this.gms);
            aVar.ab(4, this.gmt);
            aVar.dV(5, this.gmu);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gmr != null) {
                r0 += a.a.a.a.dU(2, this.gmr.aHr());
            }
            return ((r0 + a.a.a.a.c(3, 8, this.gms)) + (a.a.a.b.b.a.cw(4) + 1)) + a.a.a.a.dS(5, this.gmu);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gms.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ae aeVar = (ae) objArr[1];
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
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        aeVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bb bbVar = new bb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bbVar.a(aVar4, bbVar, aqx.a(aVar4))) {
                        }
                        aeVar.gmr = bbVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        b bVar = new b();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, aqx.a(aVar4))) {
                        }
                        aeVar.gms.add(bVar);
                    }
                    return 0;
                case 4:
                    aeVar.gmt = aVar3.bQJ();
                    return 0;
                case 5:
                    aeVar.gmu = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
