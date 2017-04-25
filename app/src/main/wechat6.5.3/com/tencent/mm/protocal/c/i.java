package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class i extends aqx {
    public int hKq = 268513600;
    public String hKr = "请求不成功，请稍候再试";
    public w lYD;
    public String lYw;
    public String lYy;

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
            aVar.dV(2, this.hKq);
            if (this.hKr != null) {
                aVar.e(3, this.hKr);
            }
            if (this.lYw != null) {
                aVar.e(4, this.lYw);
            }
            if (this.lYy != null) {
                aVar.e(6, this.lYy);
            }
            if (this.lYD == null) {
                return 0;
            }
            aVar.dX(7, this.lYD.aHr());
            this.lYD.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.hKq);
            if (this.hKr != null) {
                r0 += a.a.a.b.b.a.f(3, this.hKr);
            }
            if (this.lYw != null) {
                r0 += a.a.a.b.b.a.f(4, this.lYw);
            }
            if (this.lYy != null) {
                r0 += a.a.a.b.b.a.f(6, this.lYy);
            }
            if (this.lYD != null) {
                r0 += a.a.a.a.dU(7, this.lYD.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        iVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    iVar.hKq = aVar3.pMj.mH();
                    return 0;
                case 3:
                    iVar.hKr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    iVar.lYw = aVar3.pMj.readString();
                    return 0;
                case 6:
                    iVar.lYy = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        w wVar = new w();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wVar.a(aVar4, wVar, aqx.a(aVar4))) {
                        }
                        iVar.lYD = wVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
