package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aki extends a {
    public long lastUpdateTime;
    public LinkedList<it> mov = new LinkedList();
    public int mow;
    public int mox;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mov);
            aVar.dV(2, this.version);
            aVar.dV(3, this.mow);
            aVar.dV(4, this.mox);
            aVar.C(5, this.lastUpdateTime);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.c(1, 8, this.mov) + 0) + a.a.a.a.dS(2, this.version)) + a.a.a.a.dS(3, this.mow)) + a.a.a.a.dS(4, this.mox)) + a.a.a.a.B(5, this.lastUpdateTime);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mov.clear();
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
                aki com_tencent_mm_protocal_c_aki = (aki) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            it itVar = new it();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = itVar.a(aVar4, itVar, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_aki.mov.add(itVar);
                        }
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_aki.version = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_aki.mow = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_aki.mox = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_aki.lastUpdateTime = aVar3.pMj.mI();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
