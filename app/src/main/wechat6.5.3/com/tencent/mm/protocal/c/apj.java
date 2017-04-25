package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class apj extends a {
    public int id;
    public arf mOW;
    public arf mOX;
    public arf mOY;
    public arf mOZ;
    public arf mPa;
    public arf mPb;
    public arf mPc;
    public arf mPd;
    public arf mPe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mOX == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.mOY == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.mOZ == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.mPa == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.mPb == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.mPc == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.mPd == null) {
                throw new b("Not all required fields were included: phone");
            } else {
                aVar.dV(1, this.id);
                if (this.mOW != null) {
                    aVar.dX(2, this.mOW.aHr());
                    this.mOW.a(aVar);
                }
                if (this.mOX != null) {
                    aVar.dX(3, this.mOX.aHr());
                    this.mOX.a(aVar);
                }
                if (this.mOY != null) {
                    aVar.dX(4, this.mOY.aHr());
                    this.mOY.a(aVar);
                }
                if (this.mOZ != null) {
                    aVar.dX(5, this.mOZ.aHr());
                    this.mOZ.a(aVar);
                }
                if (this.mPa != null) {
                    aVar.dX(6, this.mPa.aHr());
                    this.mPa.a(aVar);
                }
                if (this.mPb != null) {
                    aVar.dX(7, this.mPb.aHr());
                    this.mPb.a(aVar);
                }
                if (this.mPc != null) {
                    aVar.dX(8, this.mPc.aHr());
                    this.mPc.a(aVar);
                }
                if (this.mPd != null) {
                    aVar.dX(9, this.mPd.aHr());
                    this.mPd.a(aVar);
                }
                if (this.mPe != null) {
                    aVar.dX(10, this.mPe.aHr());
                    this.mPe.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.id) + 0;
            if (this.mOW != null) {
                r0 += a.a.a.a.dU(2, this.mOW.aHr());
            }
            if (this.mOX != null) {
                r0 += a.a.a.a.dU(3, this.mOX.aHr());
            }
            if (this.mOY != null) {
                r0 += a.a.a.a.dU(4, this.mOY.aHr());
            }
            if (this.mOZ != null) {
                r0 += a.a.a.a.dU(5, this.mOZ.aHr());
            }
            if (this.mPa != null) {
                r0 += a.a.a.a.dU(6, this.mPa.aHr());
            }
            if (this.mPb != null) {
                r0 += a.a.a.a.dU(7, this.mPb.aHr());
            }
            if (this.mPc != null) {
                r0 += a.a.a.a.dU(8, this.mPc.aHr());
            }
            if (this.mPd != null) {
                r0 += a.a.a.a.dU(9, this.mPd.aHr());
            }
            if (this.mPe != null) {
                return r0 + a.a.a.a.dU(10, this.mPe.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mOX == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.mOY == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.mOZ == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.mPa == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.mPb == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.mPc == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.mPd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: phone");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            apj com_tencent_mm_protocal_c_apj = (apj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            arf com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_apj.id = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mOW = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mOX = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mOY = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mOZ = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mPa = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mPb = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mPc = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mPd = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apj.mPe = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
