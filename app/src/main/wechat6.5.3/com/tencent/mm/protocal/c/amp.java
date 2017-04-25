package com.tencent.mm.protocal.c;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;

public final class amp extends a {
    public String hNP;
    public String hNR;
    public int hNS;
    public String hNT;
    public int hNU;
    public String hNV;
    public int hNW;
    public int hNX;
    public String hNZ;
    public String hOa;
    public String hOb;
    public String hOc;
    public String hOd;
    public int mMU;
    public String mNh;
    public String mNi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hNP != null) {
                aVar.e(1, this.hNP);
            }
            aVar.dV(2, this.mMU);
            if (this.hNR != null) {
                aVar.e(3, this.hNR);
            }
            aVar.dV(4, this.hNS);
            if (this.hNT != null) {
                aVar.e(5, this.hNT);
            }
            aVar.dV(6, this.hNU);
            if (this.hNV != null) {
                aVar.e(7, this.hNV);
            }
            aVar.dV(8, this.hNW);
            aVar.dV(9, this.hNX);
            if (this.hNZ != null) {
                aVar.e(11, this.hNZ);
            }
            if (this.hOa != null) {
                aVar.e(12, this.hOa);
            }
            if (this.hOb != null) {
                aVar.e(13, this.hOb);
            }
            if (this.hOc != null) {
                aVar.e(14, this.hOc);
            }
            if (this.hOd != null) {
                aVar.e(15, this.hOd);
            }
            if (this.mNh != null) {
                aVar.e(18, this.mNh);
            }
            if (this.mNi == null) {
                return 0;
            }
            aVar.e(19, this.mNi);
            return 0;
        } else if (i == 1) {
            if (this.hNP != null) {
                r0 = a.a.a.b.b.a.f(1, this.hNP) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mMU);
            if (this.hNR != null) {
                r0 += a.a.a.b.b.a.f(3, this.hNR);
            }
            r0 += a.a.a.a.dS(4, this.hNS);
            if (this.hNT != null) {
                r0 += a.a.a.b.b.a.f(5, this.hNT);
            }
            r0 += a.a.a.a.dS(6, this.hNU);
            if (this.hNV != null) {
                r0 += a.a.a.b.b.a.f(7, this.hNV);
            }
            r0 = (r0 + a.a.a.a.dS(8, this.hNW)) + a.a.a.a.dS(9, this.hNX);
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(11, this.hNZ);
            }
            if (this.hOa != null) {
                r0 += a.a.a.b.b.a.f(12, this.hOa);
            }
            if (this.hOb != null) {
                r0 += a.a.a.b.b.a.f(13, this.hOb);
            }
            if (this.hOc != null) {
                r0 += a.a.a.b.b.a.f(14, this.hOc);
            }
            if (this.hOd != null) {
                r0 += a.a.a.b.b.a.f(15, this.hOd);
            }
            if (this.mNh != null) {
                r0 += a.a.a.b.b.a.f(18, this.mNh);
            }
            if (this.mNi != null) {
                r0 += a.a.a.b.b.a.f(19, this.mNi);
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
            amp com_tencent_mm_protocal_c_amp = (amp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_amp.hNP = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amp.mMU = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amp.hNR = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amp.hNS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_amp.hNT = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_amp.hNU = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_amp.hNV = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_amp.hNW = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_amp.hNX = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_amp.hNZ = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_amp.hOa = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_amp.hOb = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_amp.hOc = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_amp.hOd = aVar3.pMj.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_amp.mNh = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_amp.mNi = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
