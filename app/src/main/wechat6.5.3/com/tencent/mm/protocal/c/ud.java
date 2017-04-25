package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ud extends aqp {
    public String bol;
    public String bom;
    public int bon;
    public String eCB;
    public String lZL;
    public String lZM;
    public int lZN;
    public axv lZP;
    public String mxa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.bol == null) {
                throw new b("Not all required fields were included: card_id");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.bol != null) {
                aVar.e(2, this.bol);
            }
            aVar.dV(3, this.bon);
            if (this.eCB != null) {
                aVar.e(4, this.eCB);
            }
            if (this.bom != null) {
                aVar.e(5, this.bom);
            }
            if (this.lZL != null) {
                aVar.e(6, this.lZL);
            }
            if (this.lZM != null) {
                aVar.e(7, this.lZM);
            }
            aVar.dV(8, this.lZN);
            if (this.mxa != null) {
                aVar.e(9, this.mxa);
            }
            if (this.lZP == null) {
                return 0;
            }
            aVar.dX(10, this.lZP.aHr());
            this.lZP.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.bol != null) {
                r0 += a.a.a.b.b.a.f(2, this.bol);
            }
            r0 += a.a.a.a.dS(3, this.bon);
            if (this.eCB != null) {
                r0 += a.a.a.b.b.a.f(4, this.eCB);
            }
            if (this.bom != null) {
                r0 += a.a.a.b.b.a.f(5, this.bom);
            }
            if (this.lZL != null) {
                r0 += a.a.a.b.b.a.f(6, this.lZL);
            }
            if (this.lZM != null) {
                r0 += a.a.a.b.b.a.f(7, this.lZM);
            }
            r0 += a.a.a.a.dS(8, this.lZN);
            if (this.mxa != null) {
                r0 += a.a.a.b.b.a.f(9, this.mxa);
            }
            if (this.lZP != null) {
                r0 += a.a.a.a.dU(10, this.lZP.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.bol != null) {
                return 0;
            }
            throw new b("Not all required fields were included: card_id");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ud udVar = (ud) objArr[1];
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
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        udVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    udVar.bol = aVar3.pMj.readString();
                    return 0;
                case 3:
                    udVar.bon = aVar3.pMj.mH();
                    return 0;
                case 4:
                    udVar.eCB = aVar3.pMj.readString();
                    return 0;
                case 5:
                    udVar.bom = aVar3.pMj.readString();
                    return 0;
                case 6:
                    udVar.lZL = aVar3.pMj.readString();
                    return 0;
                case 7:
                    udVar.lZM = aVar3.pMj.readString();
                    return 0;
                case 8:
                    udVar.lZN = aVar3.pMj.mH();
                    return 0;
                case 9:
                    udVar.mxa = aVar3.pMj.readString();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        axv com_tencent_mm_protocal_c_axv = new axv();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axv.a(aVar4, com_tencent_mm_protocal_c_axv, aqp.a(aVar4))) {
                        }
                        udVar.lZP = com_tencent_mm_protocal_c_axv;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
