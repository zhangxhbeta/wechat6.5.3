package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class oa extends a {
    public ol mpR;
    public ob mpS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpR == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.mpS == null) {
                throw new b("Not all required fields were included: BannerImg");
            } else {
                if (this.mpR != null) {
                    aVar.dX(1, this.mpR.aHr());
                    this.mpR.a(aVar);
                }
                if (this.mpS == null) {
                    return 0;
                }
                aVar.dX(2, this.mpS.aHr());
                this.mpS.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mpR != null) {
                r0 = a.a.a.a.dU(1, this.mpR.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mpS != null) {
                r0 += a.a.a.a.dU(2, this.mpS.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mpR == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.mpS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BannerImg");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            oa oaVar = (oa) objArr[1];
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
                        ol olVar = new ol();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = olVar.a(aVar4, olVar, a.a(aVar4))) {
                        }
                        oaVar.mpR = olVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ob obVar = new ob();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = obVar.a(aVar4, obVar, a.a(aVar4))) {
                        }
                        oaVar.mpS = obVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
