package com.tencent.mm.plugin.game.d;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class p extends aqp {
    public String gkz;
    public String glp;
    public b glq;
    public b glr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.gkz == null) {
                throw new a.a.a.b("Not all required fields were included: AppID");
            } else if (this.glp == null) {
                throw new a.a.a.b("Not all required fields were included: GroupID");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.gkz != null) {
                    aVar.e(2, this.gkz);
                }
                if (this.glp != null) {
                    aVar.e(3, this.glp);
                }
                if (this.glq != null) {
                    aVar.b(4, this.glq);
                }
                if (this.glr == null) {
                    return 0;
                }
                aVar.b(5, this.glr);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkz != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkz);
            }
            if (this.glp != null) {
                r0 += a.a.a.b.b.a.f(3, this.glp);
            }
            if (this.glq != null) {
                r0 += a.a.a.a.a(4, this.glq);
            }
            if (this.glr != null) {
                r0 += a.a.a.a.a(5, this.glr);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkz == null) {
                throw new a.a.a.b("Not all required fields were included: AppID");
            } else if (this.glp != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: GroupID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
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
                        pVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    pVar.gkz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    pVar.glp = aVar3.pMj.readString();
                    return 0;
                case 4:
                    pVar.glq = aVar3.bQK();
                    return 0;
                case 5:
                    pVar.glr = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
