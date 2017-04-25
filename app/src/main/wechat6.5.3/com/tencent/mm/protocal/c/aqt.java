package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class aqt extends a {
    public String glb;
    public int mQe;
    public int mQf;
    public LinkedList<auz> mQg = new LinkedList();
    public b mQh;
    public String mQi;
    public int moo;
    public String mpI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpI == null) {
                throw new a.a.a.b("Not all required fields were included: MD5");
            } else if (this.glb == null) {
                throw new a.a.a.b("Not all required fields were included: Url");
            } else if (this.mQi == null) {
                throw new a.a.a.b("Not all required fields were included: OriginalMD5");
            } else {
                if (this.mpI != null) {
                    aVar.e(1, this.mpI);
                }
                aVar.dV(2, this.mQe);
                if (this.glb != null) {
                    aVar.e(3, this.glb);
                }
                aVar.dV(4, this.mQf);
                aVar.d(5, 8, this.mQg);
                if (this.mQh != null) {
                    aVar.b(6, this.mQh);
                }
                if (this.mQi != null) {
                    aVar.e(7, this.mQi);
                }
                aVar.dV(8, this.moo);
                return 0;
            }
        } else if (i == 1) {
            if (this.mpI != null) {
                r0 = a.a.a.b.b.a.f(1, this.mpI) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mQe);
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(3, this.glb);
            }
            r0 = (r0 + a.a.a.a.dS(4, this.mQf)) + a.a.a.a.c(5, 8, this.mQg);
            if (this.mQh != null) {
                r0 += a.a.a.a.a(6, this.mQh);
            }
            if (this.mQi != null) {
                r0 += a.a.a.b.b.a.f(7, this.mQi);
            }
            return r0 + a.a.a.a.dS(8, this.moo);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mQg.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mpI == null) {
                throw new a.a.a.b("Not all required fields were included: MD5");
            } else if (this.glb == null) {
                throw new a.a.a.b("Not all required fields were included: Url");
            } else if (this.mQi != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: OriginalMD5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aqt com_tencent_mm_protocal_c_aqt = (aqt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aqt.mpI = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqt.mQe = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqt.glb = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqt.mQf = aVar3.pMj.mH();
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_auz = new auz();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_auz.a(aVar4, com_tencent_mm_protocal_c_auz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqt.mQg.add(com_tencent_mm_protocal_c_auz);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqt.mQh = aVar3.bQK();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqt.mQi = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqt.moo = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
