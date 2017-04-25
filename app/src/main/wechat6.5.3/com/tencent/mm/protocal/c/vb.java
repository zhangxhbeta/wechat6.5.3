package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class vb extends aqx {
    public String ID;
    public long eeK;
    public int efm;
    public int maG;
    public int meD;
    public LinkedList<li> meE = new LinkedList();
    public String meF;
    public String meG;
    public String meH;
    public int meL;
    public String meM;
    public String meN;
    public are mes;
    public String mxJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mes == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.ID != null) {
                    aVar.e(2, this.ID);
                }
                if (this.mes != null) {
                    aVar.dX(3, this.mes.aHr());
                    this.mes.a(aVar);
                }
                if (this.meM != null) {
                    aVar.e(4, this.meM);
                }
                if (this.meN != null) {
                    aVar.e(5, this.meN);
                }
                aVar.dV(6, this.efm);
                aVar.dV(7, this.meD);
                aVar.d(8, 8, this.meE);
                if (this.mxJ != null) {
                    aVar.e(9, this.mxJ);
                }
                if (this.meF != null) {
                    aVar.e(10, this.meF);
                }
                if (this.meG != null) {
                    aVar.e(11, this.meG);
                }
                aVar.dV(12, this.meL);
                aVar.dV(13, this.maG);
                aVar.C(14, this.eeK);
                if (this.meH == null) {
                    return 0;
                }
                aVar.e(15, this.meH);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ID != null) {
                r0 += a.a.a.b.b.a.f(2, this.ID);
            }
            if (this.mes != null) {
                r0 += a.a.a.a.dU(3, this.mes.aHr());
            }
            if (this.meM != null) {
                r0 += a.a.a.b.b.a.f(4, this.meM);
            }
            if (this.meN != null) {
                r0 += a.a.a.b.b.a.f(5, this.meN);
            }
            r0 = ((r0 + a.a.a.a.dS(6, this.efm)) + a.a.a.a.dS(7, this.meD)) + a.a.a.a.c(8, 8, this.meE);
            if (this.mxJ != null) {
                r0 += a.a.a.b.b.a.f(9, this.mxJ);
            }
            if (this.meF != null) {
                r0 += a.a.a.b.b.a.f(10, this.meF);
            }
            if (this.meG != null) {
                r0 += a.a.a.b.b.a.f(11, this.meG);
            }
            r0 = ((r0 + a.a.a.a.dS(12, this.meL)) + a.a.a.a.dS(13, this.maG)) + a.a.a.a.B(14, this.eeK);
            if (this.meH != null) {
                r0 += a.a.a.b.b.a.f(15, this.meH);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.meE.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mes != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            vb vbVar = (vb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        vbVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    vbVar.ID = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        vbVar.mes = eoVar;
                    }
                    return 0;
                case 4:
                    vbVar.meM = aVar3.pMj.readString();
                    return 0;
                case 5:
                    vbVar.meN = aVar3.pMj.readString();
                    return 0;
                case 6:
                    vbVar.efm = aVar3.pMj.mH();
                    return 0;
                case 7:
                    vbVar.meD = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new li();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        vbVar.meE.add(eoVar);
                    }
                    return 0;
                case 9:
                    vbVar.mxJ = aVar3.pMj.readString();
                    return 0;
                case 10:
                    vbVar.meF = aVar3.pMj.readString();
                    return 0;
                case 11:
                    vbVar.meG = aVar3.pMj.readString();
                    return 0;
                case 12:
                    vbVar.meL = aVar3.pMj.mH();
                    return 0;
                case 13:
                    vbVar.maG = aVar3.pMj.mH();
                    return 0;
                case 14:
                    vbVar.eeK = aVar3.pMj.mI();
                    return 0;
                case 15:
                    vbVar.meH = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
