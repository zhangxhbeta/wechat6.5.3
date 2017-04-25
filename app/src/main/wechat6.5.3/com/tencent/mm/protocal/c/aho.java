package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import android.support.v7.a.a.k;
import java.util.LinkedList;

public final class aho extends aqp {
    public String cHf;
    public String eeA;
    public String fvy;
    public String fvz;
    public int glx;
    public int lZo;
    public String mHg;
    public String mHh;
    public String mHi;
    public int mHj;
    public em mel;
    public String mem;
    public String men;
    public int meo;
    public String mep;
    public String meq;
    public String mio;
    public String mip;
    public String mpz;
    public String mvD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mel != null) {
                aVar.dX(2, this.mel.aHr());
                this.mel.a(aVar);
            }
            if (this.mem != null) {
                aVar.e(3, this.mem);
            }
            if (this.men != null) {
                aVar.e(4, this.men);
            }
            aVar.dV(5, this.meo);
            if (this.mep != null) {
                aVar.e(6, this.mep);
            }
            if (this.cHf != null) {
                aVar.e(7, this.cHf);
            }
            if (this.eeA != null) {
                aVar.e(8, this.eeA);
            }
            if (this.meq != null) {
                aVar.e(9, this.meq);
            }
            if (this.fvz != null) {
                aVar.e(10, this.fvz);
            }
            if (this.fvy != null) {
                aVar.e(11, this.fvy);
            }
            aVar.dV(13, this.lZo);
            aVar.dV(14, this.glx);
            if (this.mip != null) {
                aVar.e(15, this.mip);
            }
            if (this.mio != null) {
                aVar.e(16, this.mio);
            }
            if (this.mHg != null) {
                aVar.e(17, this.mHg);
            }
            if (this.mpz != null) {
                aVar.e(18, this.mpz);
            }
            if (this.mvD != null) {
                aVar.e(19, this.mvD);
            }
            if (this.mHh != null) {
                aVar.e(20, this.mHh);
            }
            if (this.mHi != null) {
                aVar.e(21, this.mHi);
            }
            aVar.dV(22, this.mHj);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mel != null) {
                r0 += a.a.a.a.dU(2, this.mel.aHr());
            }
            if (this.mem != null) {
                r0 += a.a.a.b.b.a.f(3, this.mem);
            }
            if (this.men != null) {
                r0 += a.a.a.b.b.a.f(4, this.men);
            }
            r0 += a.a.a.a.dS(5, this.meo);
            if (this.mep != null) {
                r0 += a.a.a.b.b.a.f(6, this.mep);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(7, this.cHf);
            }
            if (this.eeA != null) {
                r0 += a.a.a.b.b.a.f(8, this.eeA);
            }
            if (this.meq != null) {
                r0 += a.a.a.b.b.a.f(9, this.meq);
            }
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(10, this.fvz);
            }
            if (this.fvy != null) {
                r0 += a.a.a.b.b.a.f(11, this.fvy);
            }
            r0 = (r0 + a.a.a.a.dS(13, this.lZo)) + a.a.a.a.dS(14, this.glx);
            if (this.mip != null) {
                r0 += a.a.a.b.b.a.f(15, this.mip);
            }
            if (this.mio != null) {
                r0 += a.a.a.b.b.a.f(16, this.mio);
            }
            if (this.mHg != null) {
                r0 += a.a.a.b.b.a.f(17, this.mHg);
            }
            if (this.mpz != null) {
                r0 += a.a.a.b.b.a.f(18, this.mpz);
            }
            if (this.mvD != null) {
                r0 += a.a.a.b.b.a.f(19, this.mvD);
            }
            if (this.mHh != null) {
                r0 += a.a.a.b.b.a.f(20, this.mHh);
            }
            if (this.mHi != null) {
                r0 += a.a.a.b.b.a.f(21, this.mHi);
            }
            return r0 + a.a.a.a.dS(22, this.mHj);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aho com_tencent_mm_protocal_c_aho = (aho) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aho.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aho.mel = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aho.mem = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aho.men = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aho.meo = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aho.mep = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aho.cHf = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aho.eeA = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aho.meq = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aho.fvz = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aho.fvy = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aho.lZo = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aho.glx = aVar3.pMj.mH();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aho.mip = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aho.mio = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aho.mHg = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_aho.mpz = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aho.mvD = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aho.mHh = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aho.mHi = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_aho.mHj = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
