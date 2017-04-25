package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class rf extends aqx {
    public String aXz;
    public LinkedList<String> muY = new LinkedList();
    public String muZ;
    public LinkedList<String> mva = new LinkedList();
    public LinkedList<String> mvb = new LinkedList();
    public LinkedList<rg> mvc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.muZ == null) {
                throw new b("Not all required fields were included: JsonData");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.aXz != null) {
                    aVar.e(2, this.aXz);
                }
                aVar.d(3, 1, this.muY);
                if (this.muZ != null) {
                    aVar.e(4, this.muZ);
                }
                aVar.d(5, 1, this.mva);
                aVar.d(6, 1, this.mvb);
                aVar.d(7, 8, this.mvc);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            r0 += a.a.a.a.c(3, 1, this.muY);
            if (this.muZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.muZ);
            }
            return ((r0 + a.a.a.a.c(5, 1, this.mva)) + a.a.a.a.c(6, 1, this.mvb)) + a.a.a.a.c(7, 8, this.mvc);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.muY.clear();
            this.mva.clear();
            this.mvb.clear();
            this.mvc.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.muZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: JsonData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            rf rfVar = (rf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        rfVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    rfVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    rfVar.muY.add(aVar3.pMj.readString());
                    return 0;
                case 4:
                    rfVar.muZ = aVar3.pMj.readString();
                    return 0;
                case 5:
                    rfVar.mva.add(aVar3.pMj.readString());
                    return 0;
                case 6:
                    rfVar.mvb.add(aVar3.pMj.readString());
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        rg rgVar = new rg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rgVar.a(aVar4, rgVar, aqx.a(aVar4))) {
                        }
                        rfVar.mvc.add(rgVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
