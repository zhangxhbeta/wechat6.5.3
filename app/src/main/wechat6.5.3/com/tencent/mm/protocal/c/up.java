package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class up extends a {
    public String mxe;
    public jj mxh;
    public String mxi;
    public boolean mxj;
    public int mxk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mxh != null) {
                aVar.dX(1, this.mxh.aHr());
                this.mxh.a(aVar);
            }
            if (this.mxe != null) {
                aVar.e(2, this.mxe);
            }
            if (this.mxi != null) {
                aVar.e(3, this.mxi);
            }
            aVar.ab(4, this.mxj);
            aVar.dV(5, this.mxk);
            return 0;
        } else if (i == 1) {
            if (this.mxh != null) {
                r0 = a.a.a.a.dU(1, this.mxh.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mxe != null) {
                r0 += a.a.a.b.b.a.f(2, this.mxe);
            }
            if (this.mxi != null) {
                r0 += a.a.a.b.b.a.f(3, this.mxi);
            }
            return (r0 + (a.a.a.b.b.a.cw(4) + 1)) + a.a.a.a.dS(5, this.mxk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            up upVar = (up) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        jj jjVar = new jj();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jjVar.a(aVar4, jjVar, a.a(aVar4))) {
                        }
                        upVar.mxh = jjVar;
                    }
                    return 0;
                case 2:
                    upVar.mxe = aVar3.pMj.readString();
                    return 0;
                case 3:
                    upVar.mxi = aVar3.pMj.readString();
                    return 0;
                case 4:
                    upVar.mxj = aVar3.bQJ();
                    return 0;
                case 5:
                    upVar.mxk = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
