package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class b extends a {
    public int lXD;
    public LinkedList<a> lXE = new LinkedList();
    public int nettype;
    public int uin;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.uin);
            aVar.dV(2, this.lXD);
            aVar.d(3, 8, this.lXE);
            aVar.dV(4, this.nettype);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.dS(1, this.uin) + 0) + a.a.a.a.dS(2, this.lXD)) + a.a.a.a.c(3, 8, this.lXE)) + a.a.a.a.dS(4, this.nettype);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.lXE.clear();
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
                b bVar = (b) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bVar.uin = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        bVar.lXD = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            a aVar4 = new a();
                            a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                            }
                            bVar.lXE.add(aVar4);
                        }
                        return 0;
                    case 4:
                        bVar.nettype = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
