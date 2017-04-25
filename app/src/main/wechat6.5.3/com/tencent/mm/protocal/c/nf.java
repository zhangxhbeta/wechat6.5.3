package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class nf extends a {
    public String deviceBrand;
    public String deviceModel;
    public String mpf;
    public String osName;
    public String osVersion;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.deviceModel != null) {
                aVar.e(1, this.deviceModel);
            }
            if (this.deviceBrand != null) {
                aVar.e(2, this.deviceBrand);
            }
            if (this.osName != null) {
                aVar.e(3, this.osName);
            }
            if (this.osVersion != null) {
                aVar.e(4, this.osVersion);
            }
            if (this.mpf == null) {
                return 0;
            }
            aVar.e(5, this.mpf);
            return 0;
        } else if (i == 1) {
            if (this.deviceModel != null) {
                r0 = a.a.a.b.b.a.f(1, this.deviceModel) + 0;
            } else {
                r0 = 0;
            }
            if (this.deviceBrand != null) {
                r0 += a.a.a.b.b.a.f(2, this.deviceBrand);
            }
            if (this.osName != null) {
                r0 += a.a.a.b.b.a.f(3, this.osName);
            }
            if (this.osVersion != null) {
                r0 += a.a.a.b.b.a.f(4, this.osVersion);
            }
            if (this.mpf != null) {
                r0 += a.a.a.b.b.a.f(5, this.mpf);
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
            nf nfVar = (nf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nfVar.deviceModel = aVar3.pMj.readString();
                    return 0;
                case 2:
                    nfVar.deviceBrand = aVar3.pMj.readString();
                    return 0;
                case 3:
                    nfVar.osName = aVar3.pMj.readString();
                    return 0;
                case 4:
                    nfVar.osVersion = aVar3.pMj.readString();
                    return 0;
                case 5:
                    nfVar.mpf = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
