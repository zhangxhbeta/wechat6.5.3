package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class bfx extends aqp {
    public int mUW;
    public int mUX;
    public int mUY;
    public int mUZ;
    public int mVa;
    public LinkedList<Integer> mVb = new LinkedList();
    public int mVc;
    public int mVd;
    public LinkedList<Integer> mVe = new LinkedList();
    public int mVf;
    public int mVg;
    public int mnk;
    public int mqS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mqS);
            aVar.dV(3, this.mUW);
            aVar.dV(4, this.mnk);
            aVar.dV(5, this.mUX);
            aVar.dV(6, this.mUY);
            aVar.dV(7, this.mUZ);
            aVar.dV(8, this.mVa);
            aVar.c(9, this.mVb);
            aVar.dV(10, this.mVc);
            aVar.dV(11, this.mVd);
            aVar.c(12, this.mVe);
            aVar.dV(13, this.mVf);
            aVar.dV(14, this.mVg);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return ((((((((((((r0 + a.a.a.a.dS(2, this.mqS)) + a.a.a.a.dS(3, this.mUW)) + a.a.a.a.dS(4, this.mnk)) + a.a.a.a.dS(5, this.mUX)) + a.a.a.a.dS(6, this.mUY)) + a.a.a.a.dS(7, this.mUZ)) + a.a.a.a.dS(8, this.mVa)) + a.a.a.a.b(9, this.mVb)) + a.a.a.a.dS(10, this.mVc)) + a.a.a.a.dS(11, this.mVd)) + a.a.a.a.b(12, this.mVe)) + a.a.a.a.dS(13, this.mVf)) + a.a.a.a.dS(14, this.mVg);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mVb.clear();
            this.mVe.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bfx com_tencent_mm_protocal_c_bfx = (bfx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfx.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfx.mqS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfx.mUW = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfx.mnk = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfx.mUX = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfx.mUY = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfx.mUZ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfx.mVa = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfx.mVb = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bfx.mVc = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bfx.mVd = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bfx.mVe = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_bfx.mVf = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_bfx.mVg = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
