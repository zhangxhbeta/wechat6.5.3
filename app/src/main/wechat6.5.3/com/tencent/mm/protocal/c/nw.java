package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class nw extends a {
    public int efm;
    public String gom;
    public String mbZ;
    public int mdA;
    public int mdz;
    public String mpI;
    public are mpJ;
    public String mpK;
    public String mpL;
    public String mpM;
    public int mpN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpJ == null) {
                throw new b("Not all required fields were included: EmojiBuffer");
            }
            if (this.mpI != null) {
                aVar.e(1, this.mpI);
            }
            aVar.dV(2, this.mdA);
            aVar.dV(3, this.mdz);
            if (this.mpJ != null) {
                aVar.dX(4, this.mpJ.aHr());
                this.mpJ.a(aVar);
            }
            aVar.dV(5, this.efm);
            if (this.gom != null) {
                aVar.e(6, this.gom);
            }
            if (this.mpK != null) {
                aVar.e(7, this.mpK);
            }
            if (this.mpL != null) {
                aVar.e(8, this.mpL);
            }
            if (this.mpM != null) {
                aVar.e(9, this.mpM);
            }
            if (this.mbZ != null) {
                aVar.e(10, this.mbZ);
            }
            aVar.dV(11, this.mpN);
            return 0;
        } else if (i == 1) {
            if (this.mpI != null) {
                r0 = a.a.a.b.b.a.f(1, this.mpI) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mdA)) + a.a.a.a.dS(3, this.mdz);
            if (this.mpJ != null) {
                r0 += a.a.a.a.dU(4, this.mpJ.aHr());
            }
            r0 += a.a.a.a.dS(5, this.efm);
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(6, this.gom);
            }
            if (this.mpK != null) {
                r0 += a.a.a.b.b.a.f(7, this.mpK);
            }
            if (this.mpL != null) {
                r0 += a.a.a.b.b.a.f(8, this.mpL);
            }
            if (this.mpM != null) {
                r0 += a.a.a.b.b.a.f(9, this.mpM);
            }
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(10, this.mbZ);
            }
            return r0 + a.a.a.a.dS(11, this.mpN);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mpJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            nw nwVar = (nw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nwVar.mpI = aVar3.pMj.readString();
                    return 0;
                case 2:
                    nwVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    nwVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        nwVar.mpJ = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    nwVar.efm = aVar3.pMj.mH();
                    return 0;
                case 6:
                    nwVar.gom = aVar3.pMj.readString();
                    return 0;
                case 7:
                    nwVar.mpK = aVar3.pMj.readString();
                    return 0;
                case 8:
                    nwVar.mpL = aVar3.pMj.readString();
                    return 0;
                case 9:
                    nwVar.mpM = aVar3.pMj.readString();
                    return 0;
                case 10:
                    nwVar.mbZ = aVar3.pMj.readString();
                    return 0;
                case 11:
                    nwVar.mpN = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
