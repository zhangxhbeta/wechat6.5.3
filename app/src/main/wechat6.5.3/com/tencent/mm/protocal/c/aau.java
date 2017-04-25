package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class aau extends aqx {
    public String aXz;
    public String gIE;
    public String gkC;
    public String mCd;
    public String mCe;
    public String mCf;
    public String mCg;
    public String mCh;
    public String mCi;
    public bgk mCj;
    public String mCk;
    public String mCl;
    public String mCm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            if (this.mCd != null) {
                aVar.e(2, this.mCd);
            }
            if (this.gIE != null) {
                aVar.e(3, this.gIE);
            }
            if (this.aXz != null) {
                aVar.e(4, this.aXz);
            }
            if (this.gkC != null) {
                aVar.e(5, this.gkC);
            }
            if (this.mCe != null) {
                aVar.e(6, this.mCe);
            }
            if (this.mCf != null) {
                aVar.e(7, this.mCf);
            }
            if (this.mCg != null) {
                aVar.e(8, this.mCg);
            }
            if (this.mCh != null) {
                aVar.e(9, this.mCh);
            }
            if (this.mCi != null) {
                aVar.e(10, this.mCi);
            }
            if (this.mCj != null) {
                aVar.dX(11, this.mCj.aHr());
                this.mCj.a(aVar);
            }
            if (this.mCk != null) {
                aVar.e(12, this.mCk);
            }
            if (this.mCl != null) {
                aVar.e(13, this.mCl);
            }
            if (this.mCm == null) {
                return 0;
            }
            aVar.e(14, this.mCm);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mCd != null) {
                r0 += a.a.a.b.b.a.f(2, this.mCd);
            }
            if (this.gIE != null) {
                r0 += a.a.a.b.b.a.f(3, this.gIE);
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(4, this.aXz);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkC);
            }
            if (this.mCe != null) {
                r0 += a.a.a.b.b.a.f(6, this.mCe);
            }
            if (this.mCf != null) {
                r0 += a.a.a.b.b.a.f(7, this.mCf);
            }
            if (this.mCg != null) {
                r0 += a.a.a.b.b.a.f(8, this.mCg);
            }
            if (this.mCh != null) {
                r0 += a.a.a.b.b.a.f(9, this.mCh);
            }
            if (this.mCi != null) {
                r0 += a.a.a.b.b.a.f(10, this.mCi);
            }
            if (this.mCj != null) {
                r0 += a.a.a.a.dU(11, this.mCj.aHr());
            }
            if (this.mCk != null) {
                r0 += a.a.a.b.b.a.f(12, this.mCk);
            }
            if (this.mCl != null) {
                r0 += a.a.a.b.b.a.f(13, this.mCl);
            }
            if (this.mCm != null) {
                r0 += a.a.a.b.b.a.f(14, this.mCm);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aau com_tencent_mm_protocal_c_aau = (aau) objArr[1];
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
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aau.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aau.mCd = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aau.gIE = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aau.aXz = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aau.gkC = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aau.mCe = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aau.mCf = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aau.mCg = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aau.mCh = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aau.mCi = aVar3.pMj.readString();
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bgk com_tencent_mm_protocal_c_bgk = new bgk();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bgk.a(aVar4, com_tencent_mm_protocal_c_bgk, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aau.mCj = com_tencent_mm_protocal_c_bgk;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aau.mCk = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_aau.mCl = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_aau.mCm = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
