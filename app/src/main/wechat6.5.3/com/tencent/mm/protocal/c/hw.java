package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class hw extends a {
    public String aXz;
    public String gkC;
    public String hOx;
    public hz miL;
    public ia miM;
    public hv miN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.gkC == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.hOx == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.miL == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.miN == null) {
                throw new b("Not all required fields were included: ActionInfo");
            } else {
                if (this.aXz != null) {
                    aVar.e(1, this.aXz);
                }
                if (this.gkC != null) {
                    aVar.e(2, this.gkC);
                }
                if (this.hOx != null) {
                    aVar.e(3, this.hOx);
                }
                if (this.miL != null) {
                    aVar.dX(4, this.miL.aHr());
                    this.miL.a(aVar);
                }
                if (this.miM != null) {
                    aVar.dX(5, this.miM.aHr());
                    this.miM.a(aVar);
                }
                if (this.miN == null) {
                    return 0;
                }
                aVar.dX(6, this.miN.aHr());
                this.miN.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkC);
            }
            if (this.hOx != null) {
                r0 += a.a.a.b.b.a.f(3, this.hOx);
            }
            if (this.miL != null) {
                r0 += a.a.a.a.dU(4, this.miL.aHr());
            }
            if (this.miM != null) {
                r0 += a.a.a.a.dU(5, this.miM.aHr());
            }
            if (this.miN != null) {
                r0 += a.a.a.a.dU(6, this.miN.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.gkC == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.hOx == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.miL == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.miN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActionInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hw hwVar = (hw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hwVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    hwVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    hwVar.hOx = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        hz hzVar = new hz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hzVar.a(aVar4, hzVar, a.a(aVar4))) {
                        }
                        hwVar.miL = hzVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ia iaVar = new ia();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iaVar.a(aVar4, iaVar, a.a(aVar4))) {
                        }
                        hwVar.miM = iaVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        hv hvVar = new hv();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hvVar.a(aVar4, hvVar, a.a(aVar4))) {
                        }
                        hwVar.miN = hvVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
