package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ih extends a {
    public int fvo;
    public int mjA;
    public LinkedList<arf> mjB = new LinkedList();
    public LinkedList<ii> mjC = new LinkedList();
    public LinkedList<ii> mjD = new LinkedList();
    public int mjE;
    public int mjF;
    public int mjs;
    public int mjt;
    public int mju;
    public int mjv;
    public LinkedList<arf> mjw = new LinkedList();
    public String mjx;
    public are mjy;
    public int mjz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mjy == null) {
                throw new b("Not all required fields were included: AuthKey");
            }
            aVar.dV(1, this.mjs);
            aVar.dV(2, this.fvo);
            aVar.dV(3, this.mjt);
            aVar.dV(4, this.mju);
            aVar.dV(5, this.mjv);
            aVar.d(6, 8, this.mjw);
            if (this.mjx != null) {
                aVar.e(7, this.mjx);
            }
            if (this.mjy != null) {
                aVar.dX(8, this.mjy.aHr());
                this.mjy.a(aVar);
            }
            aVar.dV(9, this.mjz);
            aVar.dV(10, this.mjA);
            aVar.d(11, 8, this.mjB);
            aVar.d(12, 8, this.mjC);
            aVar.d(13, 8, this.mjD);
            aVar.dV(14, this.mjE);
            aVar.dV(15, this.mjF);
            return 0;
        } else if (i == 1) {
            r0 = (((((a.a.a.a.dS(1, this.mjs) + 0) + a.a.a.a.dS(2, this.fvo)) + a.a.a.a.dS(3, this.mjt)) + a.a.a.a.dS(4, this.mju)) + a.a.a.a.dS(5, this.mjv)) + a.a.a.a.c(6, 8, this.mjw);
            if (this.mjx != null) {
                r0 += a.a.a.b.b.a.f(7, this.mjx);
            }
            if (this.mjy != null) {
                r0 += a.a.a.a.dU(8, this.mjy.aHr());
            }
            return ((((((r0 + a.a.a.a.dS(9, this.mjz)) + a.a.a.a.dS(10, this.mjA)) + a.a.a.a.c(11, 8, this.mjB)) + a.a.a.a.c(12, 8, this.mjC)) + a.a.a.a.c(13, 8, this.mjD)) + a.a.a.a.dS(14, this.mjE)) + a.a.a.a.dS(15, this.mjF);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mjw.clear();
            this.mjB.clear();
            this.mjC.clear();
            this.mjD.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mjy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ih ihVar = (ih) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ihVar.mjs = aVar3.pMj.mH();
                    return 0;
                case 2:
                    ihVar.fvo = aVar3.pMj.mH();
                    return 0;
                case 3:
                    ihVar.mjt = aVar3.pMj.mH();
                    return 0;
                case 4:
                    ihVar.mju = aVar3.pMj.mH();
                    return 0;
                case 5:
                    ihVar.mjv = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        ihVar.mjw.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 7:
                    ihVar.mjx = aVar3.pMj.readString();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        ihVar.mjy = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 9:
                    ihVar.mjz = aVar3.pMj.mH();
                    return 0;
                case 10:
                    ihVar.mjA = aVar3.pMj.mH();
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        ihVar.mjB.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new ii();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        ihVar.mjC.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 13:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new ii();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        ihVar.mjD.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 14:
                    ihVar.mjE = aVar3.pMj.mH();
                    return 0;
                case 15:
                    ihVar.mjF = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
