package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class asz extends a {
    public String aZy;
    public int con;
    public int coo;
    public String cop;
    public int dgF;
    public int dhK;
    public String jqw;
    public LinkedList<azt> mRt = new LinkedList();
    public int mRu;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jqw == null) {
                throw new b("Not all required fields were included: clientID");
            }
            aVar.d(1, 8, this.mRt);
            if (this.jqw != null) {
                aVar.e(2, this.jqw);
            }
            if (this.aZy != null) {
                aVar.e(3, this.aZy);
            }
            if (this.cop != null) {
                aVar.e(4, this.cop);
            }
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.dV(6, this.dhK);
            aVar.dV(7, this.dgF);
            aVar.dV(8, this.mRu);
            aVar.dV(9, this.con);
            aVar.dV(10, this.coo);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.mRt) + 0;
            if (this.jqw != null) {
                r0 += a.a.a.b.b.a.f(2, this.jqw);
            }
            if (this.aZy != null) {
                r0 += a.a.a.b.b.a.f(3, this.aZy);
            }
            if (this.cop != null) {
                r0 += a.a.a.b.b.a.f(4, this.cop);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(5, this.url);
            }
            return ((((r0 + a.a.a.a.dS(6, this.dhK)) + a.a.a.a.dS(7, this.dgF)) + a.a.a.a.dS(8, this.mRu)) + a.a.a.a.dS(9, this.con)) + a.a.a.a.dS(10, this.coo);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mRt.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.jqw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: clientID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            asz com_tencent_mm_protocal_c_asz = (asz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_azt = new azt();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_azt.a(aVar4, com_tencent_mm_protocal_c_azt, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asz.mRt.add(com_tencent_mm_protocal_c_azt);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asz.jqw = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asz.aZy = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asz.cop = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asz.url = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asz.dhK = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asz.dgF = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_asz.mRu = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_asz.con = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_asz.coo = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
