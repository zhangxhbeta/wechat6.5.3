package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class ll extends a {
    public int cHc;
    public String cHh;
    public String efy;
    public String gln;
    public String gor;
    public are mbY;
    public String mnT;
    public String mnU;
    public int mnV;
    public int mnW;
    public String mnX;
    public int mnY;
    public String mnZ;
    public String moa;
    public int mob;
    public int moc;
    public LinkedList<ard> mod = new LinkedList();
    public String moe;
    public int mof;
    public int mog;
    public int moh;
    public int moi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            }
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            if (this.mnT != null) {
                aVar.e(3, this.mnT);
            }
            if (this.mnU != null) {
                aVar.e(4, this.mnU);
            }
            aVar.dV(5, this.cHc);
            if (this.mbY != null) {
                aVar.dX(6, this.mbY.aHr());
                this.mbY.a(aVar);
            }
            aVar.dV(7, this.mnV);
            aVar.dV(8, this.mnW);
            if (this.mnX != null) {
                aVar.e(9, this.mnX);
            }
            aVar.dV(10, this.mnY);
            if (this.mnZ != null) {
                aVar.e(11, this.mnZ);
            }
            if (this.moa != null) {
                aVar.e(12, this.moa);
            }
            aVar.dV(13, this.mob);
            aVar.dV(14, this.moc);
            aVar.d(15, 8, this.mod);
            if (this.moe != null) {
                aVar.e(16, this.moe);
            }
            aVar.dV(17, this.mof);
            aVar.dV(18, this.mog);
            if (this.gor != null) {
                aVar.e(19, this.gor);
            }
            aVar.dV(20, this.moh);
            aVar.dV(21, this.moi);
            if (this.cHh == null) {
                return 0;
            }
            aVar.e(22, this.cHh);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            if (this.mnT != null) {
                r0 += a.a.a.b.b.a.f(3, this.mnT);
            }
            if (this.mnU != null) {
                r0 += a.a.a.b.b.a.f(4, this.mnU);
            }
            r0 += a.a.a.a.dS(5, this.cHc);
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(6, this.mbY.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(7, this.mnV)) + a.a.a.a.dS(8, this.mnW);
            if (this.mnX != null) {
                r0 += a.a.a.b.b.a.f(9, this.mnX);
            }
            r0 += a.a.a.a.dS(10, this.mnY);
            if (this.mnZ != null) {
                r0 += a.a.a.b.b.a.f(11, this.mnZ);
            }
            if (this.moa != null) {
                r0 += a.a.a.b.b.a.f(12, this.moa);
            }
            r0 = ((r0 + a.a.a.a.dS(13, this.mob)) + a.a.a.a.dS(14, this.moc)) + a.a.a.a.c(15, 8, this.mod);
            if (this.moe != null) {
                r0 += a.a.a.b.b.a.f(16, this.moe);
            }
            r0 = (r0 + a.a.a.a.dS(17, this.mof)) + a.a.a.a.dS(18, this.mog);
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(19, this.gor);
            }
            r0 = (r0 + a.a.a.a.dS(20, this.moh)) + a.a.a.a.dS(21, this.moi);
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(22, this.cHh);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mod.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuf");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ll llVar = (ll) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    llVar.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    llVar.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    llVar.mnT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    llVar.mnU = aVar3.pMj.readString();
                    return 0;
                case 5:
                    llVar.cHc = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        llVar.mbY = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 7:
                    llVar.mnV = aVar3.pMj.mH();
                    return 0;
                case 8:
                    llVar.mnW = aVar3.pMj.mH();
                    return 0;
                case 9:
                    llVar.mnX = aVar3.pMj.readString();
                    return 0;
                case 10:
                    llVar.mnY = aVar3.pMj.mH();
                    return 0;
                case 11:
                    llVar.mnZ = aVar3.pMj.readString();
                    return 0;
                case 12:
                    llVar.moa = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    llVar.mob = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    llVar.moc = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ard com_tencent_mm_protocal_c_ard = new ard();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ard.a(aVar4, com_tencent_mm_protocal_c_ard, a.a(aVar4))) {
                        }
                        llVar.mod.add(com_tencent_mm_protocal_c_ard);
                    }
                    return 0;
                case 16:
                    llVar.moe = aVar3.pMj.readString();
                    return 0;
                case 17:
                    llVar.mof = aVar3.pMj.mH();
                    return 0;
                case 18:
                    llVar.mog = aVar3.pMj.mH();
                    return 0;
                case 19:
                    llVar.gor = aVar3.pMj.readString();
                    return 0;
                case 20:
                    llVar.moh = aVar3.pMj.mH();
                    return 0;
                case 21:
                    llVar.moi = aVar3.pMj.mH();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    llVar.cHh = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
