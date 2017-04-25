package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class yw extends aqp {
    public String bol;
    public String code;
    public String eBK;
    public int scene;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.bol != null) {
                aVar.e(2, this.bol);
            }
            aVar.dV(3, this.scene);
            if (this.eBK != null) {
                aVar.e(4, this.eBK);
            }
            if (this.code == null) {
                return 0;
            }
            aVar.e(5, this.code);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.bol != null) {
                r0 += a.a.a.b.b.a.f(2, this.bol);
            }
            r0 += a.a.a.a.dS(3, this.scene);
            if (this.eBK != null) {
                r0 += a.a.a.b.b.a.f(4, this.eBK);
            }
            if (this.code != null) {
                r0 += a.a.a.b.b.a.f(5, this.code);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            yw ywVar = (yw) objArr[1];
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
                        ywVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    ywVar.bol = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ywVar.scene = aVar3.pMj.mH();
                    return 0;
                case 4:
                    ywVar.eBK = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ywVar.code = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
