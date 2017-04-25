package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class jj extends a {
    public ji mlE;
    public ji mlF;
    public ji mlG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mlE != null) {
                aVar.dX(1, this.mlE.aHr());
                this.mlE.a(aVar);
            }
            if (this.mlF != null) {
                aVar.dX(2, this.mlF.aHr());
                this.mlF.a(aVar);
            }
            if (this.mlG == null) {
                return 0;
            }
            aVar.dX(3, this.mlG.aHr());
            this.mlG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mlE != null) {
                r0 = a.a.a.a.dU(1, this.mlE.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mlF != null) {
                r0 += a.a.a.a.dU(2, this.mlF.aHr());
            }
            if (this.mlG != null) {
                r0 += a.a.a.a.dU(3, this.mlG.aHr());
            }
            return r0;
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
            jj jjVar = (jj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            ji jiVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        jiVar = new ji();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jiVar.a(aVar4, jiVar, a.a(aVar4))) {
                        }
                        jjVar.mlE = jiVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        jiVar = new ji();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jiVar.a(aVar4, jiVar, a.a(aVar4))) {
                        }
                        jjVar.mlF = jiVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        jiVar = new ji();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jiVar.a(aVar4, jiVar, a.a(aVar4))) {
                        }
                        jjVar.mlG = jiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
