package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.eo;
import java.util.LinkedList;

public final class ca extends aqx {
    public String aXz;
    public boolean gkI;
    public String gkY;
    public h god;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.gkY == null) {
                throw new b("Not all required fields were included: Message");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.ab(2, this.gkI);
                if (this.aXz != null) {
                    aVar.e(3, this.aXz);
                }
                if (this.gkY != null) {
                    aVar.e(4, this.gkY);
                }
                if (this.god == null) {
                    return 0;
                }
                aVar.dX(5, this.god.aHr());
                this.god.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.b.b.a.cw(2) + 1;
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(3, this.aXz);
            }
            if (this.gkY != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkY);
            }
            if (this.god != null) {
                r0 += a.a.a.a.dU(5, this.god.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.gkY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Message");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ca caVar = (ca) objArr[1];
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
                        caVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    caVar.gkI = aVar3.bQJ();
                    return 0;
                case 3:
                    caVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 4:
                    caVar.gkY = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        h hVar = new h();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hVar.a(aVar4, hVar, aqx.a(aVar4))) {
                        }
                        caVar.god = hVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
