package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class azr extends a {
    public int cog;
    public String gID;
    public String gln;
    public int hNS;
    public String jGu;
    public String jYp;
    public al joj;
    public String lJi;
    public String lJj;
    public int mHR;
    public String mWn;
    public agp mWo;
    public cl mWp;
    public lo mWq;
    public String mWr;
    public int mWs;
    public int mWt;
    public String mWu;
    public ayj mWv;
    public bgx mWw;
    public int mWx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gID != null) {
                aVar.e(1, this.gID);
            }
            if (this.gln != null) {
                aVar.e(2, this.gln);
            }
            aVar.dV(3, this.mHR);
            aVar.dV(4, this.hNS);
            if (this.mWn != null) {
                aVar.e(5, this.mWn);
            }
            if (this.mWo != null) {
                aVar.dX(6, this.mWo.aHr());
                this.mWo.a(aVar);
            }
            if (this.mWp != null) {
                aVar.dX(7, this.mWp.aHr());
                this.mWp.a(aVar);
            }
            if (this.mWq != null) {
                aVar.dX(8, this.mWq.aHr());
                this.mWq.a(aVar);
            }
            if (this.lJi != null) {
                aVar.e(9, this.lJi);
            }
            if (this.lJj != null) {
                aVar.e(10, this.lJj);
            }
            if (this.mWr != null) {
                aVar.e(11, this.mWr);
            }
            aVar.dV(12, this.mWs);
            aVar.dV(13, this.mWt);
            if (this.mWu != null) {
                aVar.e(14, this.mWu);
            }
            if (this.joj != null) {
                aVar.dX(15, this.joj.aHr());
                this.joj.a(aVar);
            }
            aVar.dV(16, this.cog);
            if (this.mWv != null) {
                aVar.dX(17, this.mWv.aHr());
                this.mWv.a(aVar);
            }
            if (this.jGu != null) {
                aVar.e(18, this.jGu);
            }
            if (this.jYp != null) {
                aVar.e(19, this.jYp);
            }
            if (this.mWw != null) {
                aVar.dX(20, this.mWw.aHr());
                this.mWw.a(aVar);
            }
            aVar.dV(21, this.mWx);
            return 0;
        } else if (i == 1) {
            if (this.gID != null) {
                r0 = a.a.a.b.b.a.f(1, this.gID) + 0;
            } else {
                r0 = 0;
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mHR)) + a.a.a.a.dS(4, this.hNS);
            if (this.mWn != null) {
                r0 += a.a.a.b.b.a.f(5, this.mWn);
            }
            if (this.mWo != null) {
                r0 += a.a.a.a.dU(6, this.mWo.aHr());
            }
            if (this.mWp != null) {
                r0 += a.a.a.a.dU(7, this.mWp.aHr());
            }
            if (this.mWq != null) {
                r0 += a.a.a.a.dU(8, this.mWq.aHr());
            }
            if (this.lJi != null) {
                r0 += a.a.a.b.b.a.f(9, this.lJi);
            }
            if (this.lJj != null) {
                r0 += a.a.a.b.b.a.f(10, this.lJj);
            }
            if (this.mWr != null) {
                r0 += a.a.a.b.b.a.f(11, this.mWr);
            }
            r0 = (r0 + a.a.a.a.dS(12, this.mWs)) + a.a.a.a.dS(13, this.mWt);
            if (this.mWu != null) {
                r0 += a.a.a.b.b.a.f(14, this.mWu);
            }
            if (this.joj != null) {
                r0 += a.a.a.a.dU(15, this.joj.aHr());
            }
            r0 += a.a.a.a.dS(16, this.cog);
            if (this.mWv != null) {
                r0 += a.a.a.a.dU(17, this.mWv.aHr());
            }
            if (this.jGu != null) {
                r0 += a.a.a.b.b.a.f(18, this.jGu);
            }
            if (this.jYp != null) {
                r0 += a.a.a.b.b.a.f(19, this.jYp);
            }
            if (this.mWw != null) {
                r0 += a.a.a.a.dU(20, this.mWw.aHr());
            }
            return r0 + a.a.a.a.dS(21, this.mWx);
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
            azr com_tencent_mm_protocal_c_azr = (azr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_agp;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_azr.gID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azr.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azr.mHR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azr.hNS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azr.mWn = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_agp = new agp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_agp.a(aVar4, com_tencent_mm_protocal_c_agp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azr.mWo = com_tencent_mm_protocal_c_agp;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_agp = new cl();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_agp.a(aVar4, com_tencent_mm_protocal_c_agp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azr.mWp = com_tencent_mm_protocal_c_agp;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_agp = new lo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_agp.a(aVar4, com_tencent_mm_protocal_c_agp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azr.mWq = com_tencent_mm_protocal_c_agp;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_azr.lJi = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_azr.lJj = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_azr.mWr = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_azr.mWs = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_azr.mWt = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_azr.mWu = aVar3.pMj.readString();
                    return 0;
                case 15:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_agp = new al();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_agp.a(aVar4, com_tencent_mm_protocal_c_agp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azr.joj = com_tencent_mm_protocal_c_agp;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_azr.cog = aVar3.pMj.mH();
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_agp = new ayj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_agp.a(aVar4, com_tencent_mm_protocal_c_agp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azr.mWv = com_tencent_mm_protocal_c_agp;
                    }
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_azr.jGu = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_azr.jYp = aVar3.pMj.readString();
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_agp = new bgx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_agp.a(aVar4, com_tencent_mm_protocal_c_agp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azr.mWw = com_tencent_mm_protocal_c_agp;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_azr.mWx = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
