package com.tencent.mm.protocal.c;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;

public class alf extends a {
    public String cHd;
    public String cHe;
    public String gkB;
    public String mFI;
    public String mMa;
    public String mMb;
    public String mMc;
    public String mMd;
    public double mhY;
    public double mhZ;
    public String moE;
    public String moF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkB != null) {
                aVar.e(1, this.gkB);
            }
            if (this.mMa != null) {
                aVar.e(2, this.mMa);
            }
            aVar.a(3, this.mhY);
            aVar.a(4, this.mhZ);
            if (this.mMb != null) {
                aVar.e(5, this.mMb);
            }
            if (this.mFI != null) {
                aVar.e(6, this.mFI);
            }
            if (this.mMc != null) {
                aVar.e(7, this.mMc);
            }
            if (this.cHd != null) {
                aVar.e(8, this.cHd);
            }
            if (this.cHe != null) {
                aVar.e(9, this.cHe);
            }
            if (this.moE != null) {
                aVar.e(10, this.moE);
            }
            if (this.moF != null) {
                aVar.e(11, this.moF);
            }
            if (this.mMd == null) {
                return 0;
            }
            aVar.e(12, this.mMd);
            return 0;
        } else if (i == 1) {
            if (this.gkB != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkB) + 0;
            } else {
                r0 = 0;
            }
            if (this.mMa != null) {
                r0 += a.a.a.b.b.a.f(2, this.mMa);
            }
            r0 = (r0 + (a.a.a.b.b.a.cw(3) + 8)) + (a.a.a.b.b.a.cw(4) + 8);
            if (this.mMb != null) {
                r0 += a.a.a.b.b.a.f(5, this.mMb);
            }
            if (this.mFI != null) {
                r0 += a.a.a.b.b.a.f(6, this.mFI);
            }
            if (this.mMc != null) {
                r0 += a.a.a.b.b.a.f(7, this.mMc);
            }
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(8, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(9, this.cHe);
            }
            if (this.moE != null) {
                r0 += a.a.a.b.b.a.f(10, this.moE);
            }
            if (this.moF != null) {
                r0 += a.a.a.b.b.a.f(11, this.moF);
            }
            if (this.mMd != null) {
                r0 += a.a.a.b.b.a.f(12, this.mMd);
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
            alf com_tencent_mm_protocal_c_alf = (alf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_alf.gkB = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alf.mMa = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alf.mhY = aVar3.pMj.readDouble();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alf.mhZ = aVar3.pMj.readDouble();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alf.mMb = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alf.mFI = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_alf.mMc = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_alf.cHd = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_alf.cHe = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    com_tencent_mm_protocal_c_alf.moE = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_alf.moF = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_alf.mMd = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
