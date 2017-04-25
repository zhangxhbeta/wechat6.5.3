package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ano extends aqp {
    public String mNR;
    public String mNS;
    public String mNT;
    public String mNU;
    public String mNV;
    public int mNW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mNR != null) {
                aVar.e(2, this.mNR);
            }
            if (this.mNS != null) {
                aVar.e(3, this.mNS);
            }
            if (this.mNT != null) {
                aVar.e(4, this.mNT);
            }
            if (this.mNU != null) {
                aVar.e(5, this.mNU);
            }
            if (this.mNV != null) {
                aVar.e(6, this.mNV);
            }
            aVar.dV(7, this.mNW);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mNR != null) {
                r0 += a.a.a.b.b.a.f(2, this.mNR);
            }
            if (this.mNS != null) {
                r0 += a.a.a.b.b.a.f(3, this.mNS);
            }
            if (this.mNT != null) {
                r0 += a.a.a.b.b.a.f(4, this.mNT);
            }
            if (this.mNU != null) {
                r0 += a.a.a.b.b.a.f(5, this.mNU);
            }
            if (this.mNV != null) {
                r0 += a.a.a.b.b.a.f(6, this.mNV);
            }
            return r0 + a.a.a.a.dS(7, this.mNW);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ano com_tencent_mm_protocal_c_ano = (ano) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ano.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ano.mNR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ano.mNS = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ano.mNT = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ano.mNU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ano.mNV = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ano.mNW = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
