package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class em extends a {
    public are mea;
    public are meb;
    public String meg;
    public are mfv;
    public bgl mfw;
    public biv mfx;
    public int mfy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mfv != null) {
                aVar.dX(1, this.mfv.aHr());
                this.mfv.a(aVar);
            }
            if (this.mfw != null) {
                aVar.dX(2, this.mfw.aHr());
                this.mfw.a(aVar);
            }
            if (this.mfx != null) {
                aVar.dX(3, this.mfx.aHr());
                this.mfx.a(aVar);
            }
            if (this.mea != null) {
                aVar.dX(4, this.mea.aHr());
                this.mea.a(aVar);
            }
            if (this.meb != null) {
                aVar.dX(5, this.meb.aHr());
                this.meb.a(aVar);
            }
            aVar.dV(6, this.mfy);
            if (this.meg == null) {
                return 0;
            }
            aVar.e(7, this.meg);
            return 0;
        } else if (i == 1) {
            if (this.mfv != null) {
                r0 = a.a.a.a.dU(1, this.mfv.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mfw != null) {
                r0 += a.a.a.a.dU(2, this.mfw.aHr());
            }
            if (this.mfx != null) {
                r0 += a.a.a.a.dU(3, this.mfx.aHr());
            }
            if (this.mea != null) {
                r0 += a.a.a.a.dU(4, this.mea.aHr());
            }
            if (this.meb != null) {
                r0 += a.a.a.a.dU(5, this.meb.aHr());
            }
            r0 += a.a.a.a.dS(6, this.mfy);
            if (this.meg != null) {
                r0 += a.a.a.b.b.a.f(7, this.meg);
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
            em emVar = (em) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        emVar.mfv = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new bgl();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        emVar.mfw = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new biv();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        emVar.mfx = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        emVar.mea = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        emVar.meb = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 6:
                    emVar.mfy = aVar3.pMj.mH();
                    return 0;
                case 7:
                    emVar.meg = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
