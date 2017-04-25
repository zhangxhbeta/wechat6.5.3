package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class auh extends aqx {
    public are mAm;
    public are mAn;
    public are mAo;
    public float mJX;
    public int mRR;
    public are mRS;
    public are mRT;
    public are mRU;
    public are mRV;
    public are mRW;
    public int mRX;
    public int mRY;
    public String mRZ;
    public int mfh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mRS == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.mRT == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.mAn == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.mAo == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.mRU == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.mRV == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.mRW == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.mAm == null) {
                throw new b("Not all required fields were included: SongLyric");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(2, this.mfh);
                aVar.dV(3, this.mRR);
                aVar.j(4, this.mJX);
                if (this.mRS != null) {
                    aVar.dX(5, this.mRS.aHr());
                    this.mRS.a(aVar);
                }
                if (this.mRT != null) {
                    aVar.dX(6, this.mRT.aHr());
                    this.mRT.a(aVar);
                }
                if (this.mAn != null) {
                    aVar.dX(7, this.mAn.aHr());
                    this.mAn.a(aVar);
                }
                if (this.mAo != null) {
                    aVar.dX(8, this.mAo.aHr());
                    this.mAo.a(aVar);
                }
                if (this.mRU != null) {
                    aVar.dX(9, this.mRU.aHr());
                    this.mRU.a(aVar);
                }
                if (this.mRV != null) {
                    aVar.dX(10, this.mRV.aHr());
                    this.mRV.a(aVar);
                }
                if (this.mRW != null) {
                    aVar.dX(11, this.mRW.aHr());
                    this.mRW.a(aVar);
                }
                if (this.mAm != null) {
                    aVar.dX(12, this.mAm.aHr());
                    this.mAm.a(aVar);
                }
                aVar.dV(13, this.mRX);
                aVar.dV(14, this.mRY);
                if (this.mRZ == null) {
                    return 0;
                }
                aVar.e(15, this.mRZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.dS(2, this.mfh)) + a.a.a.a.dS(3, this.mRR)) + (a.a.a.b.b.a.cw(4) + 4);
            if (this.mRS != null) {
                r0 += a.a.a.a.dU(5, this.mRS.aHr());
            }
            if (this.mRT != null) {
                r0 += a.a.a.a.dU(6, this.mRT.aHr());
            }
            if (this.mAn != null) {
                r0 += a.a.a.a.dU(7, this.mAn.aHr());
            }
            if (this.mAo != null) {
                r0 += a.a.a.a.dU(8, this.mAo.aHr());
            }
            if (this.mRU != null) {
                r0 += a.a.a.a.dU(9, this.mRU.aHr());
            }
            if (this.mRV != null) {
                r0 += a.a.a.a.dU(10, this.mRV.aHr());
            }
            if (this.mRW != null) {
                r0 += a.a.a.a.dU(11, this.mRW.aHr());
            }
            if (this.mAm != null) {
                r0 += a.a.a.a.dU(12, this.mAm.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(13, this.mRX)) + a.a.a.a.dS(14, this.mRY);
            if (this.mRZ != null) {
                r0 += a.a.a.b.b.a.f(15, this.mRZ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mRS == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.mRT == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.mAn == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.mAo == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.mRU == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.mRV == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.mRW == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.mAm != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SongLyric");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auh com_tencent_mm_protocal_c_auh = (auh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            are com_tencent_mm_protocal_c_are;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auh.mfh = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auh.mRR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auh.mJX = aVar3.pMj.readFloat();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mRS = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mRT = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mAn = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mAo = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mRU = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mRV = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mRW = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auh.mAm = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_auh.mRX = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_auh.mRY = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_auh.mRZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
