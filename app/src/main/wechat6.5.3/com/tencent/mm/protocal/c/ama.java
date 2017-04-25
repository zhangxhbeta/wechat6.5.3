package com.tencent.mm.protocal.c;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;

public final class ama extends a {
    public String cOb;
    public String hNg;
    public String irC;
    public int mMN;
    public String mMO;
    public String mMP;
    public int mMQ;
    public String mMR;
    public int mMS;
    public String mMT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mMN);
            if (this.mMO != null) {
                aVar.e(2, this.mMO);
            }
            if (this.mMP != null) {
                aVar.e(3, this.mMP);
            }
            aVar.dV(4, this.mMQ);
            if (this.hNg != null) {
                aVar.e(5, this.hNg);
            }
            if (this.mMR != null) {
                aVar.e(6, this.mMR);
            }
            if (this.irC != null) {
                aVar.e(7, this.irC);
            }
            aVar.dV(8, this.mMS);
            if (this.cOb != null) {
                aVar.e(9, this.cOb);
            }
            if (this.mMT != null) {
                aVar.e(10, this.mMT);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mMN) + 0;
            if (this.mMO != null) {
                r0 += a.a.a.b.b.a.f(2, this.mMO);
            }
            if (this.mMP != null) {
                r0 += a.a.a.b.b.a.f(3, this.mMP);
            }
            r0 += a.a.a.a.dS(4, this.mMQ);
            if (this.hNg != null) {
                r0 += a.a.a.b.b.a.f(5, this.hNg);
            }
            if (this.mMR != null) {
                r0 += a.a.a.b.b.a.f(6, this.mMR);
            }
            if (this.irC != null) {
                r0 += a.a.a.b.b.a.f(7, this.irC);
            }
            r0 += a.a.a.a.dS(8, this.mMS);
            if (this.cOb != null) {
                r0 += a.a.a.b.b.a.f(9, this.cOb);
            }
            if (this.mMT != null) {
                return r0 + a.a.a.b.b.a.f(10, this.mMT);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ama com_tencent_mm_protocal_c_ama = (ama) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ama.mMN = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ama.mMO = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ama.mMP = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ama.mMQ = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ama.hNg = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ama.mMR = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ama.irC = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ama.mMS = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_ama.cOb = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    com_tencent_mm_protocal_c_ama.mMT = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
