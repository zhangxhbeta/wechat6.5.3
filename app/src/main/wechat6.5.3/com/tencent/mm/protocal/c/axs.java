package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class axs extends a {
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
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mqS);
            aVar.dV(2, this.mUW);
            aVar.dV(3, this.mnk);
            aVar.dV(4, this.mUX);
            aVar.dV(5, this.mUY);
            aVar.dV(6, this.mUZ);
            aVar.dV(7, this.mVa);
            aVar.d(8, 2, this.mVb);
            aVar.dV(9, this.mVc);
            aVar.dV(10, this.mVd);
            aVar.d(11, 2, this.mVe);
            aVar.dV(12, this.mVf);
            aVar.dV(13, this.mVg);
            return 0;
        } else if (i == 1) {
            return ((((((((((((a.a.a.a.dS(1, this.mqS) + 0) + a.a.a.a.dS(2, this.mUW)) + a.a.a.a.dS(3, this.mnk)) + a.a.a.a.dS(4, this.mUX)) + a.a.a.a.dS(5, this.mUY)) + a.a.a.a.dS(6, this.mUZ)) + a.a.a.a.dS(7, this.mVa)) + a.a.a.a.c(8, 2, this.mVb)) + a.a.a.a.dS(9, this.mVc)) + a.a.a.a.dS(10, this.mVd)) + a.a.a.a.c(11, 2, this.mVe)) + a.a.a.a.dS(12, this.mVf)) + a.a.a.a.dS(13, this.mVg);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.mVb.clear();
                this.mVe.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                axs com_tencent_mm_protocal_c_axs = (axs) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_axs.mqS = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_axs.mUW = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_axs.mnk = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_axs.mUX = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_axs.mUY = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_axs.mUZ = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_axs.mVa = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_axs.mVb.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    case 9:
                        com_tencent_mm_protocal_c_axs.mVc = aVar3.pMj.mH();
                        return 0;
                    case 10:
                        com_tencent_mm_protocal_c_axs.mVd = aVar3.pMj.mH();
                        return 0;
                    case 11:
                        com_tencent_mm_protocal_c_axs.mVe.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    case 12:
                        com_tencent_mm_protocal_c_axs.mVf = aVar3.pMj.mH();
                        return 0;
                    case as.CTRL_INDEX /*13*/:
                        com_tencent_mm_protocal_c_axs.mVg = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
