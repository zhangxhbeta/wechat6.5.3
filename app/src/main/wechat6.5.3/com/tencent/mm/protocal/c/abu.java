package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;

public final class abu extends a {
    public int bLg;
    public long bLh;
    public String bLi;
    public String bLj;
    public String bLk;
    public String bLl;
    public String cHh;
    public String gkT;
    public String gnp;
    public String mCM;
    public String mCN;
    public int mCO;
    public int mCP;
    public int mCQ;
    public int mCR;
    public String mCS;
    public String mCT;
    public String mCU;
    public String mCV;
    public int mCW;
    public String mec;
    public String mfU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mCM != null) {
                aVar.e(1, this.mCM);
            }
            if (this.mec != null) {
                aVar.e(2, this.mec);
            }
            if (this.mfU != null) {
                aVar.e(3, this.mfU);
            }
            if (this.mCN != null) {
                aVar.e(4, this.mCN);
            }
            aVar.dV(5, this.mCO);
            aVar.dV(6, this.mCP);
            aVar.dV(7, this.mCQ);
            aVar.dV(8, this.mCR);
            if (this.mCS != null) {
                aVar.e(9, this.mCS);
            }
            if (this.cHh != null) {
                aVar.e(10, this.cHh);
            }
            if (this.gnp != null) {
                aVar.e(11, this.gnp);
            }
            if (this.gkT != null) {
                aVar.e(12, this.gkT);
            }
            if (this.mCT != null) {
                aVar.e(13, this.mCT);
            }
            if (this.mCU != null) {
                aVar.e(14, this.mCU);
            }
            if (this.mCV != null) {
                aVar.e(15, this.mCV);
            }
            aVar.dV(16, this.mCW);
            aVar.dV(17, this.bLg);
            aVar.C(18, this.bLh);
            if (this.bLi != null) {
                aVar.e(19, this.bLi);
            }
            if (this.bLj != null) {
                aVar.e(20, this.bLj);
            }
            if (this.bLk != null) {
                aVar.e(21, this.bLk);
            }
            if (this.bLl == null) {
                return 0;
            }
            aVar.e(22, this.bLl);
            return 0;
        } else if (i == 1) {
            if (this.mCM != null) {
                r0 = a.a.a.b.b.a.f(1, this.mCM) + 0;
            } else {
                r0 = 0;
            }
            if (this.mec != null) {
                r0 += a.a.a.b.b.a.f(2, this.mec);
            }
            if (this.mfU != null) {
                r0 += a.a.a.b.b.a.f(3, this.mfU);
            }
            if (this.mCN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mCN);
            }
            r0 = (((r0 + a.a.a.a.dS(5, this.mCO)) + a.a.a.a.dS(6, this.mCP)) + a.a.a.a.dS(7, this.mCQ)) + a.a.a.a.dS(8, this.mCR);
            if (this.mCS != null) {
                r0 += a.a.a.b.b.a.f(9, this.mCS);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(10, this.cHh);
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(11, this.gnp);
            }
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(12, this.gkT);
            }
            if (this.mCT != null) {
                r0 += a.a.a.b.b.a.f(13, this.mCT);
            }
            if (this.mCU != null) {
                r0 += a.a.a.b.b.a.f(14, this.mCU);
            }
            if (this.mCV != null) {
                r0 += a.a.a.b.b.a.f(15, this.mCV);
            }
            r0 = ((r0 + a.a.a.a.dS(16, this.mCW)) + a.a.a.a.dS(17, this.bLg)) + a.a.a.a.B(18, this.bLh);
            if (this.bLi != null) {
                r0 += a.a.a.b.b.a.f(19, this.bLi);
            }
            if (this.bLj != null) {
                r0 += a.a.a.b.b.a.f(20, this.bLj);
            }
            if (this.bLk != null) {
                r0 += a.a.a.b.b.a.f(21, this.bLk);
            }
            if (this.bLl != null) {
                r0 += a.a.a.b.b.a.f(22, this.bLl);
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
            abu com_tencent_mm_protocal_c_abu = (abu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_abu.mCM = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_abu.mec = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_abu.mfU = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_abu.mCN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_abu.mCO = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_abu.mCP = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_abu.mCQ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_abu.mCR = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_abu.mCS = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_abu.cHh = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_abu.gnp = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_abu.gkT = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_abu.mCT = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_abu.mCU = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_abu.mCV = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_abu.mCW = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_abu.bLg = aVar3.pMj.mH();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_abu.bLh = aVar3.pMj.mI();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_abu.bLi = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_abu.bLj = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_abu.bLk = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    com_tencent_mm_protocal_c_abu.bLl = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
