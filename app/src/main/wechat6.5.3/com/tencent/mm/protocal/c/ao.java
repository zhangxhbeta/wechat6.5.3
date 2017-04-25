package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ao extends a {
    public String gkz;
    public String gle;
    public String hNZ;
    public String maT;
    public String maU;
    public String maV;
    public String maW;
    public String maX;
    public String maY;
    public bjk maZ;
    public String mba;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkz != null) {
                aVar.e(1, this.gkz);
            }
            if (this.maT != null) {
                aVar.e(2, this.maT);
            }
            if (this.maU != null) {
                aVar.e(3, this.maU);
            }
            if (this.gle != null) {
                aVar.e(4, this.gle);
            }
            if (this.hNZ != null) {
                aVar.e(5, this.hNZ);
            }
            if (this.maV != null) {
                aVar.e(6, this.maV);
            }
            if (this.maW != null) {
                aVar.e(7, this.maW);
            }
            if (this.maX != null) {
                aVar.e(8, this.maX);
            }
            if (this.maY != null) {
                aVar.e(9, this.maY);
            }
            if (this.maZ != null) {
                aVar.dX(10, this.maZ.aHr());
                this.maZ.a(aVar);
            }
            if (this.mba == null) {
                return 0;
            }
            aVar.e(11, this.mba);
            return 0;
        } else if (i == 1) {
            if (this.gkz != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkz) + 0;
            } else {
                r0 = 0;
            }
            if (this.maT != null) {
                r0 += a.a.a.b.b.a.f(2, this.maT);
            }
            if (this.maU != null) {
                r0 += a.a.a.b.b.a.f(3, this.maU);
            }
            if (this.gle != null) {
                r0 += a.a.a.b.b.a.f(4, this.gle);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.hNZ);
            }
            if (this.maV != null) {
                r0 += a.a.a.b.b.a.f(6, this.maV);
            }
            if (this.maW != null) {
                r0 += a.a.a.b.b.a.f(7, this.maW);
            }
            if (this.maX != null) {
                r0 += a.a.a.b.b.a.f(8, this.maX);
            }
            if (this.maY != null) {
                r0 += a.a.a.b.b.a.f(9, this.maY);
            }
            if (this.maZ != null) {
                r0 += a.a.a.a.dU(10, this.maZ.aHr());
            }
            if (this.mba != null) {
                r0 += a.a.a.b.b.a.f(11, this.mba);
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
            ao aoVar = (ao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aoVar.gkz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    aoVar.maT = aVar3.pMj.readString();
                    return 0;
                case 3:
                    aoVar.maU = aVar3.pMj.readString();
                    return 0;
                case 4:
                    aoVar.gle = aVar3.pMj.readString();
                    return 0;
                case 5:
                    aoVar.hNZ = aVar3.pMj.readString();
                    return 0;
                case 6:
                    aoVar.maV = aVar3.pMj.readString();
                    return 0;
                case 7:
                    aoVar.maW = aVar3.pMj.readString();
                    return 0;
                case 8:
                    aoVar.maX = aVar3.pMj.readString();
                    return 0;
                case 9:
                    aoVar.maY = aVar3.pMj.readString();
                    return 0;
                case 10:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_bjk = new bjk();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bjk.a(aVar4, com_tencent_mm_protocal_c_bjk, a.a(aVar4))) {
                        }
                        aoVar.maZ = com_tencent_mm_protocal_c_bjk;
                    }
                    return 0;
                case 11:
                    aoVar.mba = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
