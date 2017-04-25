package com.tencent.mm.plugin.report.service;

import java.util.LinkedList;

public final class a extends com.tencent.mm.ba.a {
    public int eet;
    public LinkedList<b> itG = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.eet);
            aVar.d(2, 8, this.itG);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.dS(1, this.eet) + 0) + a.a.a.a.c(2, 8, this.itG);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.itG.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = com.tencent.mm.ba.a.a(aVar2); a > 0; a = com.tencent.mm.ba.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        aVar4.eet = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            com.tencent.mm.ba.a bVar = new b();
                            a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.ba.a.a(aVar5))) {
                            }
                            aVar4.itG.add(bVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
