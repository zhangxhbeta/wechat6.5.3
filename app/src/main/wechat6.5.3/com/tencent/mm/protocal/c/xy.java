package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xy extends aqx {
    public String gkB;
    public String gkC;
    public are mcz;
    public LinkedList<nu> mfM = new LinkedList();
    public String mfT;
    public String mqz;
    public LinkedList<ol> myi = new LinkedList();
    public String mzX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mzX == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.gkB == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.gkC == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.mqz == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.mfT == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.mcz == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mzX != null) {
                    aVar.e(2, this.mzX);
                }
                if (this.gkB != null) {
                    aVar.e(3, this.gkB);
                }
                if (this.gkC != null) {
                    aVar.e(4, this.gkC);
                }
                if (this.mqz != null) {
                    aVar.e(5, this.mqz);
                }
                if (this.mfT != null) {
                    aVar.e(6, this.mfT);
                }
                aVar.d(7, 8, this.myi);
                if (this.mcz != null) {
                    aVar.dX(8, this.mcz.aHr());
                    this.mcz.a(aVar);
                }
                aVar.d(9, 8, this.mfM);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mzX != null) {
                r0 += a.a.a.b.b.a.f(2, this.mzX);
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkB);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkC);
            }
            if (this.mqz != null) {
                r0 += a.a.a.b.b.a.f(5, this.mqz);
            }
            if (this.mfT != null) {
                r0 += a.a.a.b.b.a.f(6, this.mfT);
            }
            r0 += a.a.a.a.c(7, 8, this.myi);
            if (this.mcz != null) {
                r0 += a.a.a.a.dU(8, this.mcz.aHr());
            }
            return r0 + a.a.a.a.c(9, 8, this.mfM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.myi.clear();
            this.mfM.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mzX == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.gkB == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.gkC == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.mqz == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.mfT == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.mcz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xy xyVar = (xy) objArr[1];
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
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        xyVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    xyVar.mzX = aVar3.pMj.readString();
                    return 0;
                case 3:
                    xyVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    xyVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    xyVar.mqz = aVar3.pMj.readString();
                    return 0;
                case 6:
                    xyVar.mfT = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ol olVar = new ol();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = olVar.a(aVar4, olVar, aqx.a(aVar4))) {
                        }
                        xyVar.myi.add(olVar);
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        xyVar.mcz = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        nu nuVar = new nu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nuVar.a(aVar4, nuVar, aqx.a(aVar4))) {
                        }
                        xyVar.mfM.add(nuVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
