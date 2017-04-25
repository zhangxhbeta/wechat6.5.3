package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class all extends aqp {
    public String gkE;
    public String glj;
    public String hNZ;
    public String mMo;
    public String mMp;
    public String mMq;
    public String mMr;
    public String mMs;
    public am mkb;
    public String mmT;
    public String mmU;
    public String mmV;
    public String mmW;
    public String mvt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            if (this.mMo != null) {
                aVar.e(3, this.mMo);
            }
            if (this.mvt != null) {
                aVar.e(4, this.mvt);
            }
            if (this.mmT != null) {
                aVar.e(5, this.mmT);
            }
            if (this.mMp != null) {
                aVar.e(6, this.mMp);
            }
            if (this.mmU != null) {
                aVar.e(7, this.mmU);
            }
            if (this.mmV != null) {
                aVar.e(8, this.mmV);
            }
            if (this.mmW != null) {
                aVar.e(9, this.mmW);
            }
            if (this.mMq != null) {
                aVar.e(10, this.mMq);
            }
            if (this.mkb != null) {
                aVar.dX(11, this.mkb.aHr());
                this.mkb.a(aVar);
            }
            if (this.mMr != null) {
                aVar.e(12, this.mMr);
            }
            if (this.gkE != null) {
                aVar.e(13, this.gkE);
            }
            if (this.hNZ != null) {
                aVar.e(14, this.hNZ);
            }
            if (this.mMs == null) {
                return 0;
            }
            aVar.e(15, this.mMs);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            if (this.mMo != null) {
                r0 += a.a.a.b.b.a.f(3, this.mMo);
            }
            if (this.mvt != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvt);
            }
            if (this.mmT != null) {
                r0 += a.a.a.b.b.a.f(5, this.mmT);
            }
            if (this.mMp != null) {
                r0 += a.a.a.b.b.a.f(6, this.mMp);
            }
            if (this.mmU != null) {
                r0 += a.a.a.b.b.a.f(7, this.mmU);
            }
            if (this.mmV != null) {
                r0 += a.a.a.b.b.a.f(8, this.mmV);
            }
            if (this.mmW != null) {
                r0 += a.a.a.b.b.a.f(9, this.mmW);
            }
            if (this.mMq != null) {
                r0 += a.a.a.b.b.a.f(10, this.mMq);
            }
            if (this.mkb != null) {
                r0 += a.a.a.a.dU(11, this.mkb.aHr());
            }
            if (this.mMr != null) {
                r0 += a.a.a.b.b.a.f(12, this.mMr);
            }
            if (this.gkE != null) {
                r0 += a.a.a.b.b.a.f(13, this.gkE);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(14, this.hNZ);
            }
            if (this.mMs != null) {
                r0 += a.a.a.b.b.a.f(15, this.mMs);
            }
            return r0;
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
            all com_tencent_mm_protocal_c_all = (all) objArr[1];
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
                        com_tencent_mm_protocal_c_all.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_all.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_all.mMo = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_all.mvt = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_all.mmT = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_all.mMp = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_all.mmU = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_all.mmV = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_all.mmW = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    com_tencent_mm_protocal_c_all.mMq = aVar3.pMj.readString();
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        am amVar = new am();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amVar.a(aVar4, amVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_all.mkb = amVar;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_all.mMr = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_all.gkE = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_all.hNZ = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_all.mMs = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
