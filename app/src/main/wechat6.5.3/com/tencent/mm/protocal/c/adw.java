package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class adw extends aqp {
    public String bCj;
    public String bmJ;
    public String fZV;
    public LinkedList<String> mEE = new LinkedList();
    public String mEs;
    public String mEt;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.bmJ != null) {
                aVar.e(3, this.bmJ);
            }
            aVar.d(4, 1, this.mEE);
            if (this.fZV != null) {
                aVar.e(5, this.fZV);
            }
            if (this.mEs != null) {
                aVar.e(6, this.mEs);
            }
            if (this.bCj != null) {
                aVar.e(7, this.bCj);
            }
            if (this.mEt == null) {
                return 0;
            }
            aVar.e(8, this.mEt);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.bmJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.bmJ);
            }
            r0 += a.a.a.a.c(4, 1, this.mEE);
            if (this.fZV != null) {
                r0 += a.a.a.b.b.a.f(5, this.fZV);
            }
            if (this.mEs != null) {
                r0 += a.a.a.b.b.a.f(6, this.mEs);
            }
            if (this.bCj != null) {
                r0 += a.a.a.b.b.a.f(7, this.bCj);
            }
            if (this.mEt != null) {
                r0 += a.a.a.b.b.a.f(8, this.mEt);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mEE.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            adw com_tencent_mm_protocal_c_adw = (adw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adw.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adw.url = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adw.bmJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adw.mEE.add(aVar3.pMj.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adw.fZV = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adw.mEs = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adw.bCj = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adw.mEt = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
