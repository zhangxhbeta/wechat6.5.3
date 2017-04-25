package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class fp extends a {
    public String eeA;
    public int mcj;
    public String mfU;
    public String mfZ;
    public ais mga;
    public abt mgb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            if (this.mfZ != null) {
                aVar.e(2, this.mfZ);
            }
            if (this.mga != null) {
                aVar.dX(3, this.mga.aHr());
                this.mga.a(aVar);
            }
            if (this.mfU != null) {
                aVar.e(4, this.mfU);
            }
            if (this.eeA != null) {
                aVar.e(5, this.eeA);
            }
            if (this.mgb != null) {
                aVar.dX(6, this.mgb.aHr());
                this.mgb.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.mfZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.mfZ);
            }
            if (this.mga != null) {
                r0 += a.a.a.a.dU(3, this.mga.aHr());
            }
            if (this.mfU != null) {
                r0 += a.a.a.b.b.a.f(4, this.mfU);
            }
            if (this.eeA != null) {
                r0 += a.a.a.b.b.a.f(5, this.eeA);
            }
            if (this.mgb != null) {
                return r0 + a.a.a.a.dU(6, this.mgb.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            fp fpVar = (fp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fpVar.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    fpVar.mfZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ais com_tencent_mm_protocal_c_ais = new ais();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ais.a(aVar4, com_tencent_mm_protocal_c_ais, a.a(aVar4))) {
                        }
                        fpVar.mga = com_tencent_mm_protocal_c_ais;
                    }
                    return 0;
                case 4:
                    fpVar.mfU = aVar3.pMj.readString();
                    return 0;
                case 5:
                    fpVar.eeA = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        abt com_tencent_mm_protocal_c_abt = new abt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_abt.a(aVar4, com_tencent_mm_protocal_c_abt, a.a(aVar4))) {
                        }
                        fpVar.mgb = com_tencent_mm_protocal_c_abt;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
