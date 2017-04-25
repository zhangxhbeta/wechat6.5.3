package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ajt extends a {
    public LinkedList<String> mKw = new LinkedList();
    public LinkedList<String> mKx = new LinkedList();
    public LinkedList<String> mKy = new LinkedList();
    public LinkedList<String> mKz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(5, 1, this.mKw);
            aVar.d(6, 1, this.mKx);
            aVar.d(7, 1, this.mKy);
            aVar.d(8, 1, this.mKz);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.c(5, 1, this.mKw) + 0) + a.a.a.a.c(6, 1, this.mKx)) + a.a.a.a.c(7, 1, this.mKy)) + a.a.a.a.c(8, 1, this.mKz);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.mKw.clear();
                this.mKx.clear();
                this.mKy.clear();
                this.mKz.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                ajt com_tencent_mm_protocal_c_ajt = (ajt) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 5:
                        com_tencent_mm_protocal_c_ajt.mKw.add(aVar3.pMj.readString());
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_ajt.mKx.add(aVar3.pMj.readString());
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_ajt.mKy.add(aVar3.pMj.readString());
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_ajt.mKz.add(aVar3.pMj.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
