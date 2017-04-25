package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class d extends a {
    public int eeO;
    public int efl;
    public String gkA;
    public String gkB;
    public String gkC;
    public String gkD;
    public String gkE;
    public int gkF;
    public j gkG;
    public int gkH;
    public boolean gkI;
    public LinkedList<String> gkJ = new LinkedList();
    public boolean gkK;
    public boolean gkL;
    public boolean gkM;
    public boolean gkN;
    public az gkO;
    public String gkv;
    public String gkx;
    public String gkz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkz == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.gkA == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                if (this.gkz != null) {
                    aVar.e(1, this.gkz);
                }
                if (this.gkA != null) {
                    aVar.e(2, this.gkA);
                }
                if (this.gkB != null) {
                    aVar.e(3, this.gkB);
                }
                if (this.gkC != null) {
                    aVar.e(4, this.gkC);
                }
                if (this.gkD != null) {
                    aVar.e(5, this.gkD);
                }
                if (this.gkv != null) {
                    aVar.e(6, this.gkv);
                }
                if (this.gkE != null) {
                    aVar.e(7, this.gkE);
                }
                aVar.dV(8, this.gkF);
                if (this.gkG != null) {
                    aVar.dX(9, this.gkG.aHr());
                    this.gkG.a(aVar);
                }
                aVar.dV(10, this.eeO);
                aVar.dV(11, this.gkH);
                if (this.gkx != null) {
                    aVar.e(12, this.gkx);
                }
                aVar.ab(13, this.gkI);
                aVar.d(14, 1, this.gkJ);
                aVar.ab(15, this.gkK);
                aVar.dV(16, this.efl);
                aVar.ab(17, this.gkL);
                aVar.ab(18, this.gkM);
                aVar.ab(19, this.gkN);
                if (this.gkO == null) {
                    return 0;
                }
                aVar.dX(20, this.gkO.aHr());
                this.gkO.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.gkz != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkz) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkA != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkA);
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkB);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkC);
            }
            if (this.gkD != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkD);
            }
            if (this.gkv != null) {
                r0 += a.a.a.b.b.a.f(6, this.gkv);
            }
            if (this.gkE != null) {
                r0 += a.a.a.b.b.a.f(7, this.gkE);
            }
            r0 += a.a.a.a.dS(8, this.gkF);
            if (this.gkG != null) {
                r0 += a.a.a.a.dU(9, this.gkG.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(10, this.eeO)) + a.a.a.a.dS(11, this.gkH);
            if (this.gkx != null) {
                r0 += a.a.a.b.b.a.f(12, this.gkx);
            }
            r0 = ((((((r0 + (a.a.a.b.b.a.cw(13) + 1)) + a.a.a.a.c(14, 1, this.gkJ)) + (a.a.a.b.b.a.cw(15) + 1)) + a.a.a.a.dS(16, this.efl)) + (a.a.a.b.b.a.cw(17) + 1)) + (a.a.a.b.b.a.cw(18) + 1)) + (a.a.a.b.b.a.cw(19) + 1);
            if (this.gkO != null) {
                r0 += a.a.a.a.dU(20, this.gkO.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gkJ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkz == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.gkA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dVar.gkz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    dVar.gkA = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    dVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    dVar.gkD = aVar3.pMj.readString();
                    return 0;
                case 6:
                    dVar.gkv = aVar3.pMj.readString();
                    return 0;
                case 7:
                    dVar.gkE = aVar3.pMj.readString();
                    return 0;
                case 8:
                    dVar.gkF = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        j jVar = new j();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jVar.a(aVar4, jVar, a.a(aVar4))) {
                        }
                        dVar.gkG = jVar;
                    }
                    return 0;
                case 10:
                    dVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 11:
                    dVar.gkH = aVar3.pMj.mH();
                    return 0;
                case 12:
                    dVar.gkx = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    dVar.gkI = aVar3.bQJ();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    dVar.gkJ.add(aVar3.pMj.readString());
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    dVar.gkK = aVar3.bQJ();
                    return 0;
                case 16:
                    dVar.efl = aVar3.pMj.mH();
                    return 0;
                case 17:
                    dVar.gkL = aVar3.bQJ();
                    return 0;
                case 18:
                    dVar.gkM = aVar3.bQJ();
                    return 0;
                case 19:
                    dVar.gkN = aVar3.bQJ();
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        az azVar = new az();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = azVar.a(aVar4, azVar, a.a(aVar4))) {
                        }
                        dVar.gkO = azVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
