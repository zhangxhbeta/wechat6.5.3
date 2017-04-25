package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.util.LinkedList;

public final class bgv extends aqp {
    public int mfb;
    public String miU;
    public String mxU;
    public int ncj;
    public int nck = 2;
    public String ncl;
    public String ncm;
    public String pRw;
    public String pRx;
    public int pRy;
    public String pRz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mxU != null) {
                aVar.e(2, this.mxU);
            }
            aVar.dV(3, this.mfb);
            aVar.dV(4, this.ncj);
            if (this.miU != null) {
                aVar.e(5, this.miU);
            }
            aVar.dV(6, this.nck);
            if (this.ncl != null) {
                aVar.e(99, this.ncl);
            }
            if (this.ncm != null) {
                aVar.e(100, this.ncm);
            }
            if (this.pRw != null) {
                aVar.e(101, this.pRw);
            }
            if (this.pRx != null) {
                aVar.e(102, this.pRx);
            }
            aVar.dV(103, this.pRy);
            if (this.pRz == null) {
                return 0;
            }
            aVar.e(UpdateLogConst.ACTION_POP_INSTALL_DIALOG, this.pRz);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mxU != null) {
                r0 += a.a.a.b.b.a.f(2, this.mxU);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mfb)) + a.a.a.a.dS(4, this.ncj);
            if (this.miU != null) {
                r0 += a.a.a.b.b.a.f(5, this.miU);
            }
            r0 += a.a.a.a.dS(6, this.nck);
            if (this.ncl != null) {
                r0 += a.a.a.b.b.a.f(99, this.ncl);
            }
            if (this.ncm != null) {
                r0 += a.a.a.b.b.a.f(100, this.ncm);
            }
            if (this.pRw != null) {
                r0 += a.a.a.b.b.a.f(101, this.pRw);
            }
            if (this.pRx != null) {
                r0 += a.a.a.b.b.a.f(102, this.pRx);
            }
            r0 += a.a.a.a.dS(103, this.pRy);
            if (this.pRz != null) {
                r0 += a.a.a.b.b.a.f(UpdateLogConst.ACTION_POP_INSTALL_DIALOG, this.pRz);
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
            bgv com_tencent_mm_protocal_c_bgv = (bgv) objArr[1];
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
                        com_tencent_mm_protocal_c_bgv.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgv.mxU = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgv.mfb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bgv.ncj = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bgv.miU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bgv.nck = aVar3.pMj.mH();
                    return 0;
                case 99:
                    com_tencent_mm_protocal_c_bgv.ncl = aVar3.pMj.readString();
                    return 0;
                case 100:
                    com_tencent_mm_protocal_c_bgv.ncm = aVar3.pMj.readString();
                    return 0;
                case 101:
                    com_tencent_mm_protocal_c_bgv.pRw = aVar3.pMj.readString();
                    return 0;
                case 102:
                    com_tencent_mm_protocal_c_bgv.pRx = aVar3.pMj.readString();
                    return 0;
                case 103:
                    com_tencent_mm_protocal_c_bgv.pRy = aVar3.pMj.mH();
                    return 0;
                case UpdateLogConst.ACTION_POP_INSTALL_DIALOG /*104*/:
                    com_tencent_mm_protocal_c_bgv.pRz = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
