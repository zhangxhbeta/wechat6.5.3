package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class o extends aqx {
    public String blS;
    public int hKq = 268513600;
    public String hKr = "请求不成功，请稍候再试";
    public String hci;
    public String irw;
    public a lYN;
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
            if (this.hci != null) {
                aVar.e(4, this.hci);
            }
            if (this.blS != null) {
                aVar.e(5, this.blS);
            }
            if (this.irw != null) {
                aVar.e(7, this.irw);
            }
            if (this.lYy != null) {
                aVar.e(8, this.lYy);
            }
            if (this.lYN == null) {
                return 0;
            }
            aVar.dX(9, this.lYN.aHr());
            this.lYN.a(aVar);
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
            if (this.hci != null) {
                r0 += a.a.a.b.b.a.f(4, this.hci);
            }
            if (this.blS != null) {
                r0 += a.a.a.b.b.a.f(5, this.blS);
            }
            if (this.irw != null) {
                r0 += a.a.a.b.b.a.f(7, this.irw);
            }
            if (this.lYy != null) {
                r0 += a.a.a.b.b.a.f(8, this.lYy);
            }
            if (this.lYN != null) {
                r0 += a.a.a.a.dU(9, this.lYN.aHr());
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
            o oVar = (o) objArr[1];
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
                        oVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    oVar.hKq = aVar3.pMj.mH();
                    return 0;
                case 3:
                    oVar.hKr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    oVar.hci = aVar3.pMj.readString();
                    return 0;
                case 5:
                    oVar.blS = aVar3.pMj.readString();
                    return 0;
                case 7:
                    oVar.irw = aVar3.pMj.readString();
                    return 0;
                case 8:
                    oVar.lYy = aVar3.pMj.readString();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, aqx.a(aVar4))) {
                        }
                        oVar.lYN = aVar5;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
