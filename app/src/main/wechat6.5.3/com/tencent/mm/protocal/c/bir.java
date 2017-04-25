package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class bir extends a {
    public azc ldc;
    public afv mGZ;
    public int mPQ;
    public LinkedList<bcy> mQM = new LinkedList();
    public int maG;
    public int mfb;
    public long miQ;
    public String miU;
    public String muW;
    public int ncj;
    public int nck = 2;
    public int nde;
    public String ndf;
    public String ndg;
    public int ndh;
    public LinkedList<String> ndi = new LinkedList();
    public LinkedList<le> ndj = new LinkedList();
    public LinkedList<akj> ndk = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.muW == null) {
                throw new b("Not all required fields were included: Keyword");
            }
            aVar.dV(1, this.mPQ);
            if (this.muW != null) {
                aVar.e(2, this.muW);
            }
            aVar.dV(3, this.mfb);
            aVar.C(4, this.miQ);
            aVar.dV(5, this.ncj);
            if (this.mGZ != null) {
                aVar.dX(6, this.mGZ.aHr());
                this.mGZ.a(aVar);
            }
            aVar.d(7, 8, this.mQM);
            aVar.dV(8, this.maG);
            if (this.miU != null) {
                aVar.e(9, this.miU);
            }
            aVar.dV(10, this.nde);
            if (this.ndf != null) {
                aVar.e(11, this.ndf);
            }
            if (this.ndg != null) {
                aVar.e(12, this.ndg);
            }
            aVar.dV(13, this.ndh);
            aVar.d(14, 1, this.ndi);
            aVar.dV(15, this.nck);
            if (this.ldc != null) {
                aVar.dX(16, this.ldc.aHr());
                this.ldc.a(aVar);
            }
            aVar.d(17, 8, this.ndj);
            aVar.d(18, 8, this.ndk);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mPQ) + 0;
            if (this.muW != null) {
                r0 += a.a.a.b.b.a.f(2, this.muW);
            }
            r0 = ((r0 + a.a.a.a.dS(3, this.mfb)) + a.a.a.a.B(4, this.miQ)) + a.a.a.a.dS(5, this.ncj);
            if (this.mGZ != null) {
                r0 += a.a.a.a.dU(6, this.mGZ.aHr());
            }
            r0 = (r0 + a.a.a.a.c(7, 8, this.mQM)) + a.a.a.a.dS(8, this.maG);
            if (this.miU != null) {
                r0 += a.a.a.b.b.a.f(9, this.miU);
            }
            r0 += a.a.a.a.dS(10, this.nde);
            if (this.ndf != null) {
                r0 += a.a.a.b.b.a.f(11, this.ndf);
            }
            if (this.ndg != null) {
                r0 += a.a.a.b.b.a.f(12, this.ndg);
            }
            r0 = ((r0 + a.a.a.a.dS(13, this.ndh)) + a.a.a.a.c(14, 1, this.ndi)) + a.a.a.a.dS(15, this.nck);
            if (this.ldc != null) {
                r0 += a.a.a.a.dU(16, this.ldc.aHr());
            }
            return (r0 + a.a.a.a.c(17, 8, this.ndj)) + a.a.a.a.c(18, 8, this.ndk);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mQM.clear();
            this.ndi.clear();
            this.ndj.clear();
            this.ndk.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.muW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Keyword");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bir com_tencent_mm_protocal_c_bir = (bir) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bir.mPQ = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bir.muW = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bir.mfb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bir.miQ = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bir.ncj = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        afv com_tencent_mm_protocal_c_afv = new afv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afv.a(aVar4, com_tencent_mm_protocal_c_afv, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bir.mGZ = com_tencent_mm_protocal_c_afv;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bcy com_tencent_mm_protocal_c_bcy = new bcy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcy.a(aVar4, com_tencent_mm_protocal_c_bcy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bir.mQM.add(com_tencent_mm_protocal_c_bcy);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bir.maG = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bir.miU = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bir.nde = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bir.ndf = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bir.ndg = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_bir.ndh = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_bir.ndi.add(aVar3.pMj.readString());
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_bir.nck = aVar3.pMj.mH();
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        azc com_tencent_mm_protocal_c_azc = new azc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_azc.a(aVar4, com_tencent_mm_protocal_c_azc, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bir.ldc = com_tencent_mm_protocal_c_azc;
                    }
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        le leVar = new le();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = leVar.a(aVar4, leVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bir.ndj.add(leVar);
                    }
                    return 0;
                case 18:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        akj com_tencent_mm_protocal_c_akj = new akj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_akj.a(aVar4, com_tencent_mm_protocal_c_akj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bir.ndk.add(com_tencent_mm_protocal_c_akj);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
