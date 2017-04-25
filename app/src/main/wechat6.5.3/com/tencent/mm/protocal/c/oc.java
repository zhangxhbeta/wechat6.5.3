package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class oc extends a {
    public int aRI;
    public String aXz;
    public String gkC;
    public String gnp;
    public String mdM;
    public ob mpS;
    public String mpU;
    public String mpV;
    public int mpW;
    public String mpX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpS == null) {
                throw new b("Not all required fields were included: BannerImg");
            }
            if (this.mpS != null) {
                aVar.dX(1, this.mpS.aHr());
                this.mpS.a(aVar);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            if (this.mpU != null) {
                aVar.e(3, this.mpU);
            }
            aVar.dV(4, this.aRI);
            if (this.mpV != null) {
                aVar.e(5, this.mpV);
            }
            aVar.dV(6, this.mpW);
            if (this.gnp != null) {
                aVar.e(7, this.gnp);
            }
            if (this.gkC != null) {
                aVar.e(8, this.gkC);
            }
            if (this.mdM != null) {
                aVar.e(9, this.mdM);
            }
            if (this.mpX == null) {
                return 0;
            }
            aVar.e(10, this.mpX);
            return 0;
        } else if (i == 1) {
            if (this.mpS != null) {
                r0 = a.a.a.a.dU(1, this.mpS.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.mpU != null) {
                r0 += a.a.a.b.b.a.f(3, this.mpU);
            }
            r0 += a.a.a.a.dS(4, this.aRI);
            if (this.mpV != null) {
                r0 += a.a.a.b.b.a.f(5, this.mpV);
            }
            r0 += a.a.a.a.dS(6, this.mpW);
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(7, this.gnp);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(8, this.gkC);
            }
            if (this.mdM != null) {
                r0 += a.a.a.b.b.a.f(9, this.mdM);
            }
            if (this.mpX != null) {
                r0 += a.a.a.b.b.a.f(10, this.mpX);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mpS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BannerImg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            oc ocVar = (oc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        ob obVar = new ob();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = obVar.a(aVar4, obVar, a.a(aVar4))) {
                        }
                        ocVar.mpS = obVar;
                    }
                    return 0;
                case 2:
                    ocVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ocVar.mpU = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ocVar.aRI = aVar3.pMj.mH();
                    return 0;
                case 5:
                    ocVar.mpV = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ocVar.mpW = aVar3.pMj.mH();
                    return 0;
                case 7:
                    ocVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ocVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 9:
                    ocVar.mdM = aVar3.pMj.readString();
                    return 0;
                case 10:
                    ocVar.mpX = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
