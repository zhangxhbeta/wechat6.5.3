package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class lz extends aqx {
    public int eOX;
    public LinkedList<aig> mbB = new LinkedList();
    public arf mbC;
    public are mbY;
    public String mlY;
    public String mlZ;
    public arf moA;
    public arf moC;
    public arf moD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.moA == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.moC == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.moD == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.mbC == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.moA != null) {
                    aVar.dX(2, this.moA.aHr());
                    this.moA.a(aVar);
                }
                if (this.moC != null) {
                    aVar.dX(3, this.moC.aHr());
                    this.moC.a(aVar);
                }
                if (this.moD != null) {
                    aVar.dX(4, this.moD.aHr());
                    this.moD.a(aVar);
                }
                aVar.dV(5, this.eOX);
                aVar.d(6, 8, this.mbB);
                if (this.mbC != null) {
                    aVar.dX(7, this.mbC.aHr());
                    this.mbC.a(aVar);
                }
                if (this.mbY != null) {
                    aVar.dX(8, this.mbY.aHr());
                    this.mbY.a(aVar);
                }
                if (this.mlY != null) {
                    aVar.e(9, this.mlY);
                }
                if (this.mlZ == null) {
                    return 0;
                }
                aVar.e(10, this.mlZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.moA != null) {
                r0 += a.a.a.a.dU(2, this.moA.aHr());
            }
            if (this.moC != null) {
                r0 += a.a.a.a.dU(3, this.moC.aHr());
            }
            if (this.moD != null) {
                r0 += a.a.a.a.dU(4, this.moD.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(5, this.eOX)) + a.a.a.a.c(6, 8, this.mbB);
            if (this.mbC != null) {
                r0 += a.a.a.a.dU(7, this.mbC.aHr());
            }
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(8, this.mbY.aHr());
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(9, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(10, this.mlZ);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mbB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.moA == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.moC == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.moD == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.mbC == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.mbY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            lz lzVar = (lz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            arf com_tencent_mm_protocal_c_arf;
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
                        lzVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqx.a(aVar4))) {
                        }
                        lzVar.moA = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqx.a(aVar4))) {
                        }
                        lzVar.moC = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqx.a(aVar4))) {
                        }
                        lzVar.moD = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    lzVar.eOX = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aig com_tencent_mm_protocal_c_aig = new aig();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aig.a(aVar4, com_tencent_mm_protocal_c_aig, aqx.a(aVar4))) {
                        }
                        lzVar.mbB.add(com_tencent_mm_protocal_c_aig);
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqx.a(aVar4))) {
                        }
                        lzVar.mbC = com_tencent_mm_protocal_c_arf;
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
                        lzVar.mbY = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    lzVar.mlY = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    lzVar.mlZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
