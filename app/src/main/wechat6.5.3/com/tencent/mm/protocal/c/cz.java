package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class cz extends a {
    public da mdr;
    public db mdx;
    public b mdy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdx == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.mdr == null) {
                throw new a.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.mdy == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.mdx != null) {
                    aVar.dX(1, this.mdx.aHr());
                    this.mdx.a(aVar);
                }
                if (this.mdr != null) {
                    aVar.dX(2, this.mdr.aHr());
                    this.mdr.a(aVar);
                }
                if (this.mdy == null) {
                    return 0;
                }
                aVar.b(3, this.mdy);
                return 0;
            }
        } else if (i == 1) {
            if (this.mdx != null) {
                r0 = a.a.a.a.dU(1, this.mdx.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mdr != null) {
                r0 += a.a.a.a.dU(2, this.mdr.aHr());
            }
            if (this.mdy != null) {
                r0 += a.a.a.a.a(3, this.mdy);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdx == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.mdr == null) {
                throw new a.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.mdy != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            cz czVar = (cz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a dbVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        dbVar = new db();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dbVar.a(aVar4, dbVar, a.a(aVar4))) {
                        }
                        czVar.mdx = dbVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        dbVar = new da();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dbVar.a(aVar4, dbVar, a.a(aVar4))) {
                        }
                        czVar.mdr = dbVar;
                    }
                    return 0;
                case 3:
                    czVar.mdy = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
