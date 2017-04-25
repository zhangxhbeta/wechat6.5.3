package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bw extends a {
    public String glC;
    public de mcr;
    public LinkedList<abp> mcs = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mcr == null) {
                throw new b("Not all required fields were included: ArtisAuthor");
            }
            if (this.mcr != null) {
                aVar.dX(1, this.mcr.aHr());
                this.mcr.a(aVar);
            }
            aVar.d(2, 8, this.mcs);
            if (this.glC == null) {
                return 0;
            }
            aVar.e(3, this.glC);
            return 0;
        } else if (i == 1) {
            if (this.mcr != null) {
                r0 = a.a.a.a.dU(1, this.mcr.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.mcs);
            if (this.glC != null) {
                r0 += a.a.a.b.b.a.f(3, this.glC);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mcs.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mcr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisAuthor");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bw bwVar = (bw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        de deVar = new de();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = deVar.a(aVar4, deVar, a.a(aVar4))) {
                        }
                        bwVar.mcr = deVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        abp com_tencent_mm_protocal_c_abp = new abp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_abp.a(aVar4, com_tencent_mm_protocal_c_abp, a.a(aVar4))) {
                        }
                        bwVar.mcs.add(com_tencent_mm_protocal_c_abp);
                    }
                    return 0;
                case 3:
                    bwVar.glC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
