package com.tencent.mm.protocal.c;

import a.a.a.b;
import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class dl extends a {
    public int fvo;
    public String maC;
    public nr mdT;
    public are mdU;
    public are mdV;
    public int mdW;
    public are mdX;
    public bgm mdY;
    public biw mdZ;
    public are mea;
    public are meb;
    public String mec;
    public are med;
    public String mee;
    public aux mef;
    public String meg;
    public int meh;
    public int mei;
    public int mej;
    public int mek;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdT == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.mdU == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.mdV == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else {
                aVar.dV(1, this.fvo);
                if (this.mdT != null) {
                    aVar.dX(2, this.mdT.aHr());
                    this.mdT.a(aVar);
                }
                if (this.mdU != null) {
                    aVar.dX(3, this.mdU.aHr());
                    this.mdU.a(aVar);
                }
                if (this.mdV != null) {
                    aVar.dX(4, this.mdV.aHr());
                    this.mdV.a(aVar);
                }
                aVar.dV(5, this.mdW);
                if (this.mdX != null) {
                    aVar.dX(6, this.mdX.aHr());
                    this.mdX.a(aVar);
                }
                if (this.mdY != null) {
                    aVar.dX(7, this.mdY.aHr());
                    this.mdY.a(aVar);
                }
                if (this.mdZ != null) {
                    aVar.dX(8, this.mdZ.aHr());
                    this.mdZ.a(aVar);
                }
                if (this.mea != null) {
                    aVar.dX(9, this.mea.aHr());
                    this.mea.a(aVar);
                }
                if (this.meb != null) {
                    aVar.dX(10, this.meb.aHr());
                    this.meb.a(aVar);
                }
                if (this.mec != null) {
                    aVar.e(11, this.mec);
                }
                if (this.med != null) {
                    aVar.dX(12, this.med.aHr());
                    this.med.a(aVar);
                }
                if (this.mee != null) {
                    aVar.e(14, this.mee);
                }
                if (this.mef != null) {
                    aVar.dX(15, this.mef.aHr());
                    this.mef.a(aVar);
                }
                if (this.meg != null) {
                    aVar.e(16, this.meg);
                }
                aVar.dV(17, this.meh);
                aVar.dV(18, this.mei);
                aVar.dV(19, this.mej);
                if (this.maC != null) {
                    aVar.e(20, this.maC);
                }
                aVar.dV(21, this.mek);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.fvo) + 0;
            if (this.mdT != null) {
                r0 += a.a.a.a.dU(2, this.mdT.aHr());
            }
            if (this.mdU != null) {
                r0 += a.a.a.a.dU(3, this.mdU.aHr());
            }
            if (this.mdV != null) {
                r0 += a.a.a.a.dU(4, this.mdV.aHr());
            }
            r0 += a.a.a.a.dS(5, this.mdW);
            if (this.mdX != null) {
                r0 += a.a.a.a.dU(6, this.mdX.aHr());
            }
            if (this.mdY != null) {
                r0 += a.a.a.a.dU(7, this.mdY.aHr());
            }
            if (this.mdZ != null) {
                r0 += a.a.a.a.dU(8, this.mdZ.aHr());
            }
            if (this.mea != null) {
                r0 += a.a.a.a.dU(9, this.mea.aHr());
            }
            if (this.meb != null) {
                r0 += a.a.a.a.dU(10, this.meb.aHr());
            }
            if (this.mec != null) {
                r0 += a.a.a.b.b.a.f(11, this.mec);
            }
            if (this.med != null) {
                r0 += a.a.a.a.dU(12, this.med.aHr());
            }
            if (this.mee != null) {
                r0 += a.a.a.b.b.a.f(14, this.mee);
            }
            if (this.mef != null) {
                r0 += a.a.a.a.dU(15, this.mef.aHr());
            }
            if (this.meg != null) {
                r0 += a.a.a.b.b.a.f(16, this.meg);
            }
            r0 = ((r0 + a.a.a.a.dS(17, this.meh)) + a.a.a.a.dS(18, this.mei)) + a.a.a.a.dS(19, this.mej);
            if (this.maC != null) {
                r0 += a.a.a.b.b.a.f(20, this.maC);
            }
            return r0 + a.a.a.a.dS(21, this.mek);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdT == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.mdU == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.mdV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dl dlVar = (dl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a nrVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dlVar.fvo = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new nr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mdT = nrVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mdU = nrVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mdV = nrVar;
                    }
                    return 0;
                case 5:
                    dlVar.mdW = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mdX = nrVar;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new bgm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mdY = nrVar;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new biw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mdZ = nrVar;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mea = nrVar;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.meb = nrVar;
                    }
                    return 0;
                case 11:
                    dlVar.mec = aVar3.pMj.readString();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.med = nrVar;
                    }
                    return 0;
                case 14:
                    dlVar.mee = aVar3.pMj.readString();
                    return 0;
                case 15:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        nrVar = new aux();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.a(aVar4, nrVar, a.a(aVar4))) {
                        }
                        dlVar.mef = nrVar;
                    }
                    return 0;
                case 16:
                    dlVar.meg = aVar3.pMj.readString();
                    return 0;
                case 17:
                    dlVar.meh = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    dlVar.mei = aVar3.pMj.mH();
                    return 0;
                case 19:
                    dlVar.mej = aVar3.pMj.mH();
                    return 0;
                case 20:
                    dlVar.maC = aVar3.pMj.readString();
                    return 0;
                case 21:
                    dlVar.mek = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
