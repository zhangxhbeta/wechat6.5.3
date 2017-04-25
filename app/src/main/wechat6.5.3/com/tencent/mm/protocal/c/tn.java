package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class tn extends aqp {
    public String bCj;
    public String eKz;
    public String kNT;
    public String mop;
    public String mwI;
    public String mwJ;
    public String mwK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mop == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.mwI == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.kNT == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.eKz == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.bCj == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.mwJ == null) {
                throw new b("Not all required fields were included: from_url");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mop != null) {
                    aVar.e(2, this.mop);
                }
                if (this.mwI != null) {
                    aVar.e(3, this.mwI);
                }
                if (this.kNT != null) {
                    aVar.e(4, this.kNT);
                }
                if (this.eKz != null) {
                    aVar.e(5, this.eKz);
                }
                if (this.bCj != null) {
                    aVar.e(6, this.bCj);
                }
                if (this.mwJ != null) {
                    aVar.e(7, this.mwJ);
                }
                if (this.mwK == null) {
                    return 0;
                }
                aVar.e(8, this.mwK);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mop != null) {
                r0 += a.a.a.b.b.a.f(2, this.mop);
            }
            if (this.mwI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mwI);
            }
            if (this.kNT != null) {
                r0 += a.a.a.b.b.a.f(4, this.kNT);
            }
            if (this.eKz != null) {
                r0 += a.a.a.b.b.a.f(5, this.eKz);
            }
            if (this.bCj != null) {
                r0 += a.a.a.b.b.a.f(6, this.bCj);
            }
            if (this.mwJ != null) {
                r0 += a.a.a.b.b.a.f(7, this.mwJ);
            }
            if (this.mwK != null) {
                r0 += a.a.a.b.b.a.f(8, this.mwK);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mop == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.mwI == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.kNT == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.eKz == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.bCj == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.mwJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: from_url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            tn tnVar = (tn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        tnVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    tnVar.mop = aVar3.pMj.readString();
                    return 0;
                case 3:
                    tnVar.mwI = aVar3.pMj.readString();
                    return 0;
                case 4:
                    tnVar.kNT = aVar3.pMj.readString();
                    return 0;
                case 5:
                    tnVar.eKz = aVar3.pMj.readString();
                    return 0;
                case 6:
                    tnVar.bCj = aVar3.pMj.readString();
                    return 0;
                case 7:
                    tnVar.mwJ = aVar3.pMj.readString();
                    return 0;
                case 8:
                    tnVar.mwK = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
