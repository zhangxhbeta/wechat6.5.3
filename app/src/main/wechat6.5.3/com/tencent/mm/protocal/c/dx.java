package com.tencent.mm.protocal.c;

import a.a.a.b;
import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class dx extends a {
    public int efm;
    public int mbT;
    public arf mbU;
    public arf mbV;
    public arf mbW;
    public String mbZ;
    public String mcN;
    public long mcb;
    public int meO;
    public int meP;
    public int meQ;
    public LinkedList<arf> meR = new LinkedList();
    public LinkedList<arg> meS = new LinkedList();
    public are meT;
    public int meU;
    public int meV;
    public int meW;
    public long meX;
    public int meY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mbW == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.dV(1, this.efm);
                if (this.mcN != null) {
                    aVar.e(2, this.mcN);
                }
                if (this.mbU != null) {
                    aVar.dX(3, this.mbU.aHr());
                    this.mbU.a(aVar);
                }
                if (this.mbV != null) {
                    aVar.dX(4, this.mbV.aHr());
                    this.mbV.a(aVar);
                }
                if (this.mbW != null) {
                    aVar.dX(5, this.mbW.aHr());
                    this.mbW.a(aVar);
                }
                aVar.dV(6, this.meO);
                aVar.dV(7, this.meP);
                if (this.mbZ != null) {
                    aVar.e(8, this.mbZ);
                }
                aVar.dV(9, this.mbT);
                aVar.dV(10, this.meQ);
                aVar.d(11, 8, this.meR);
                aVar.d(12, 8, this.meS);
                if (this.meT != null) {
                    aVar.dX(13, this.meT.aHr());
                    this.meT.a(aVar);
                }
                aVar.dV(14, this.meU);
                aVar.dV(15, this.meV);
                aVar.C(16, this.mcb);
                aVar.dV(17, this.meW);
                aVar.C(18, this.meX);
                aVar.dV(19, this.meY);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(2, this.mcN);
            }
            if (this.mbU != null) {
                r0 += a.a.a.a.dU(3, this.mbU.aHr());
            }
            if (this.mbV != null) {
                r0 += a.a.a.a.dU(4, this.mbV.aHr());
            }
            if (this.mbW != null) {
                r0 += a.a.a.a.dU(5, this.mbW.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(6, this.meO)) + a.a.a.a.dS(7, this.meP);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(8, this.mbZ);
            }
            r0 = (((r0 + a.a.a.a.dS(9, this.mbT)) + a.a.a.a.dS(10, this.meQ)) + a.a.a.a.c(11, 8, this.meR)) + a.a.a.a.c(12, 8, this.meS);
            if (this.meT != null) {
                r0 += a.a.a.a.dU(13, this.meT.aHr());
            }
            return (((((r0 + a.a.a.a.dS(14, this.meU)) + a.a.a.a.dS(15, this.meV)) + a.a.a.a.B(16, this.mcb)) + a.a.a.a.dS(17, this.meW)) + a.a.a.a.B(18, this.meX)) + a.a.a.a.dS(19, this.meY);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.meR.clear();
            this.meS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mbW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dx dxVar = (dx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dxVar.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    dxVar.mcN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        dxVar.mbU = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        dxVar.mbV = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        dxVar.mbW = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 6:
                    dxVar.meO = aVar3.pMj.mH();
                    return 0;
                case 7:
                    dxVar.meP = aVar3.pMj.mH();
                    return 0;
                case 8:
                    dxVar.mbZ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    dxVar.mbT = aVar3.pMj.mH();
                    return 0;
                case 10:
                    dxVar.meQ = aVar3.pMj.mH();
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
                        dxVar.meR.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        dxVar.meS.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 13:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        dxVar.meT = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 14:
                    dxVar.meU = aVar3.pMj.mH();
                    return 0;
                case 15:
                    dxVar.meV = aVar3.pMj.mH();
                    return 0;
                case 16:
                    dxVar.mcb = aVar3.pMj.mI();
                    return 0;
                case 17:
                    dxVar.meW = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    dxVar.meX = aVar3.pMj.mI();
                    return 0;
                case 19:
                    dxVar.meY = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
