package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class de extends a {
    public String aXz;
    public String gkB;
    public String mdI;
    public String mdJ;
    public df mdK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdK == null) {
                throw new b("Not all required fields were included: ArtisIcon");
            }
            if (this.gkB != null) {
                aVar.e(1, this.gkB);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            if (this.mdI != null) {
                aVar.e(3, this.mdI);
            }
            if (this.mdJ != null) {
                aVar.e(4, this.mdJ);
            }
            if (this.mdK == null) {
                return 0;
            }
            aVar.dX(5, this.mdK.aHr());
            this.mdK.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.gkB != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkB) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.mdI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mdI);
            }
            if (this.mdJ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mdJ);
            }
            if (this.mdK != null) {
                r0 += a.a.a.a.dU(5, this.mdK.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdK != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisIcon");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            de deVar = (de) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    deVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 2:
                    deVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    deVar.mdI = aVar3.pMj.readString();
                    return 0;
                case 4:
                    deVar.mdJ = aVar3.pMj.readString();
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        df dfVar = new df();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dfVar.a(aVar4, dfVar, a.a(aVar4))) {
                        }
                        deVar.mdK = dfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
