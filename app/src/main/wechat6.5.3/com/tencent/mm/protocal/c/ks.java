package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ks extends aqx {
    public int eeO;
    public bec mng;
    public bcq mnh;
    public aoo mni;
    public int mnj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mng == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.mnh == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.mni == null) {
                throw new b("Not all required fields were included: QueryCtx");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(2, this.eeO);
                if (this.mng != null) {
                    aVar.dX(3, this.mng.aHr());
                    this.mng.a(aVar);
                }
                if (this.mnh != null) {
                    aVar.dX(4, this.mnh.aHr());
                    this.mnh.a(aVar);
                }
                if (this.mni != null) {
                    aVar.dX(5, this.mni.aHr());
                    this.mni.a(aVar);
                }
                aVar.dV(6, this.mnj);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.eeO);
            if (this.mng != null) {
                r0 += a.a.a.a.dU(3, this.mng.aHr());
            }
            if (this.mnh != null) {
                r0 += a.a.a.a.dU(4, this.mnh.aHr());
            }
            if (this.mni != null) {
                r0 += a.a.a.a.dU(5, this.mni.aHr());
            }
            return r0 + a.a.a.a.dS(6, this.mnj);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mng == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.mnh == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.mni != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QueryCtx");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ks ksVar = (ks) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ksVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    ksVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new bec();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ksVar.mng = eoVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new bcq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ksVar.mnh = eoVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new aoo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ksVar.mni = eoVar;
                    }
                    return 0;
                case 6:
                    ksVar.mnj = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
