package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class hu extends a {
    public int miG;
    public int miH;
    public int miI;
    public LinkedList<ht> miJ = new LinkedList();
    public LinkedList<ht> miK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.miG);
            aVar.dV(2, this.miH);
            aVar.dV(5, this.miI);
            aVar.d(3, 8, this.miJ);
            aVar.d(4, 8, this.miK);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.dS(1, this.miG) + 0) + a.a.a.a.dS(2, this.miH)) + a.a.a.a.dS(5, this.miI)) + a.a.a.a.c(3, 8, this.miJ)) + a.a.a.a.c(4, 8, this.miK);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.miJ.clear();
                this.miK.clear();
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
                hu huVar = (hu) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList zQ;
                int size;
                a htVar;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        huVar.miG = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        huVar.miH = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            htVar = new ht();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = htVar.a(aVar4, htVar, a.a(aVar4))) {
                            }
                            huVar.miJ.add(htVar);
                        }
                        return 0;
                    case 4:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            htVar = new ht();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = htVar.a(aVar4, htVar, a.a(aVar4))) {
                            }
                            huVar.miK.add(htVar);
                        }
                        return 0;
                    case 5:
                        huVar.miI = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
