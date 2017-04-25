package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class rd extends a {
    public String gkB;
    public String gkD;
    public String glj;
    public String gnp;
    public String mnX;
    public rm muT;
    public int muU;
    public String muV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.glj == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.gkB == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.mnX == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.gnp == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.muT == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else {
                if (this.glj != null) {
                    aVar.e(1, this.glj);
                }
                if (this.gkB != null) {
                    aVar.e(2, this.gkB);
                }
                if (this.mnX != null) {
                    aVar.e(3, this.mnX);
                }
                if (this.gnp != null) {
                    aVar.e(4, this.gnp);
                }
                if (this.gkD != null) {
                    aVar.e(5, this.gkD);
                }
                if (this.muT != null) {
                    aVar.dX(6, this.muT.aHr());
                    this.muT.a(aVar);
                }
                aVar.dV(7, this.muU);
                if (this.muV == null) {
                    return 0;
                }
                aVar.e(8, this.muV);
                return 0;
            }
        } else if (i == 1) {
            if (this.glj != null) {
                r0 = a.a.a.b.b.a.f(1, this.glj) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            if (this.mnX != null) {
                r0 += a.a.a.b.b.a.f(3, this.mnX);
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(4, this.gnp);
            }
            if (this.gkD != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkD);
            }
            if (this.muT != null) {
                r0 += a.a.a.a.dU(6, this.muT.aHr());
            }
            r0 += a.a.a.a.dS(7, this.muU);
            if (this.muV != null) {
                r0 += a.a.a.b.b.a.f(8, this.muV);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.glj == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.gkB == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.mnX == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.gnp == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.muT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            rd rdVar = (rd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rdVar.glj = aVar3.pMj.readString();
                    return 0;
                case 2:
                    rdVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    rdVar.mnX = aVar3.pMj.readString();
                    return 0;
                case 4:
                    rdVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 5:
                    rdVar.gkD = aVar3.pMj.readString();
                    return 0;
                case 6:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        rm rmVar = new rm();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = rmVar.a(aVar4, rmVar, a.a(aVar4))) {
                        }
                        rdVar.muT = rmVar;
                    }
                    return 0;
                case 7:
                    rdVar.muU = aVar3.pMj.mH();
                    return 0;
                case 8:
                    rdVar.muV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
