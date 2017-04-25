package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bf extends a {
    public String glm;
    public bg gnl;
    public bg gnm;
    public bg gnn;
    public bg gno;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gnl != null) {
                aVar.dX(1, this.gnl.aHr());
                this.gnl.a(aVar);
            }
            if (this.gnm != null) {
                aVar.dX(2, this.gnm.aHr());
                this.gnm.a(aVar);
            }
            if (this.gnn != null) {
                aVar.dX(3, this.gnn.aHr());
                this.gnn.a(aVar);
            }
            if (this.gno != null) {
                aVar.dX(4, this.gno.aHr());
                this.gno.a(aVar);
            }
            if (this.glm == null) {
                return 0;
            }
            aVar.e(5, this.glm);
            return 0;
        } else if (i == 1) {
            if (this.gnl != null) {
                r0 = a.a.a.a.dU(1, this.gnl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnm != null) {
                r0 += a.a.a.a.dU(2, this.gnm.aHr());
            }
            if (this.gnn != null) {
                r0 += a.a.a.a.dU(3, this.gnn.aHr());
            }
            if (this.gno != null) {
                r0 += a.a.a.a.dU(4, this.gno.aHr());
            }
            if (this.glm != null) {
                r0 += a.a.a.b.b.a.f(5, this.glm);
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
            bf bfVar = (bf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            bg bgVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgVar = new bg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgVar.a(aVar4, bgVar, a.a(aVar4))) {
                        }
                        bfVar.gnl = bgVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgVar = new bg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgVar.a(aVar4, bgVar, a.a(aVar4))) {
                        }
                        bfVar.gnm = bgVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgVar = new bg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgVar.a(aVar4, bgVar, a.a(aVar4))) {
                        }
                        bfVar.gnn = bgVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgVar = new bg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgVar.a(aVar4, bgVar, a.a(aVar4))) {
                        }
                        bfVar.gno = bgVar;
                    }
                    return 0;
                case 5:
                    bfVar.glm = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
