package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class auk extends aqp {
    public int mRO;
    public float mRP;
    public float mRQ;
    public int mcM;
    public are mfg;
    public int mfh;
    public float mjN;
    public int mnk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mfg != null) {
                aVar.dX(2, this.mfg.aHr());
                this.mfg.a(aVar);
            }
            aVar.dV(3, this.mRO);
            aVar.dV(4, this.mfh);
            aVar.j(5, this.mRP);
            aVar.dV(6, this.mnk);
            aVar.dV(7, this.mcM);
            aVar.j(8, this.mRQ);
            aVar.j(9, this.mjN);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(2, this.mfg.aHr());
            }
            return ((((((r0 + a.a.a.a.dS(3, this.mRO)) + a.a.a.a.dS(4, this.mfh)) + (a.a.a.b.b.a.cw(5) + 4)) + a.a.a.a.dS(6, this.mnk)) + a.a.a.a.dS(7, this.mcM)) + (a.a.a.b.b.a.cw(8) + 4)) + (a.a.a.b.b.a.cw(9) + 4);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mfg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auk com_tencent_mm_protocal_c_auk = (auk) objArr[1];
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
                        com_tencent_mm_protocal_c_auk.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auk.mfg = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auk.mRO = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auk.mfh = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auk.mRP = aVar3.pMj.readFloat();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_auk.mnk = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_auk.mcM = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_auk.mRQ = aVar3.pMj.readFloat();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_auk.mjN = aVar3.pMj.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
