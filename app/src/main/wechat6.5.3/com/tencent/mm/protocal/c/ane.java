package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ane extends aqx {
    public String content;
    public boolean eDG;
    public String eDb;
    public String lZU;
    public String lZV;
    public String mNr;
    public int status;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            if (this.lZU != null) {
                aVar.e(2, this.lZU);
            }
            if (this.lZV != null) {
                aVar.e(3, this.lZV);
            }
            aVar.dV(4, this.status);
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            if (this.eDb != null) {
                aVar.e(6, this.eDb);
            }
            if (this.mNr != null) {
                aVar.e(7, this.mNr);
            }
            aVar.ab(8, this.eDG);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lZU != null) {
                r0 += a.a.a.b.b.a.f(2, this.lZU);
            }
            if (this.lZV != null) {
                r0 += a.a.a.b.b.a.f(3, this.lZV);
            }
            r0 += a.a.a.a.dS(4, this.status);
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(5, this.content);
            }
            if (this.eDb != null) {
                r0 += a.a.a.b.b.a.f(6, this.eDb);
            }
            if (this.mNr != null) {
                r0 += a.a.a.b.b.a.f(7, this.mNr);
            }
            return r0 + (a.a.a.b.b.a.cw(8) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ane com_tencent_mm_protocal_c_ane = (ane) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ane.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ane.lZU = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ane.lZV = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ane.status = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ane.content = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ane.eDb = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ane.mNr = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ane.eDG = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
