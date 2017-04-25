package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class z extends aqp {
    public String cHl;
    public String gkz;
    public String glC;
    public boolean glD;
    public boolean glE;
    public boolean glF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.glC == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.gkz == null) {
                throw new b("Not all required fields were included: AppID");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.glC != null) {
                    aVar.e(2, this.glC);
                }
                if (this.gkz != null) {
                    aVar.e(3, this.gkz);
                }
                aVar.ab(4, this.glD);
                if (this.cHl != null) {
                    aVar.e(5, this.cHl);
                }
                aVar.ab(6, this.glE);
                aVar.ab(7, this.glF);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glC != null) {
                r0 += a.a.a.b.b.a.f(2, this.glC);
            }
            if (this.gkz != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkz);
            }
            r0 += a.a.a.b.b.a.cw(4) + 1;
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(5, this.cHl);
            }
            return (r0 + (a.a.a.b.b.a.cw(6) + 1)) + (a.a.a.b.b.a.cw(7) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.glC == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.gkz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        zVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zVar.glC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zVar.gkz = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zVar.glD = aVar3.bQJ();
                    return 0;
                case 5:
                    zVar.cHl = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zVar.glE = aVar3.bQJ();
                    return 0;
                case 7:
                    zVar.glF = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
