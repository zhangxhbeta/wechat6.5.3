package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class k extends a {
    public String eeB;
    public String eeV;
    public String eeW;
    public String eeX;
    public String eeY;
    public long eeZ;
    public long efa;
    public String efb;
    public String efc;
    public b efd;
    public b efe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eeV == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.eeW == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.eeX == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.eeY == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.efb == null) {
                throw new a.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.eeB == null) {
                throw new a.a.a.b("Not all required fields were included: Model");
            } else if (this.efc == null) {
                throw new a.a.a.b("Not all required fields were included: Version");
            } else {
                if (this.eeV != null) {
                    aVar.e(1, this.eeV);
                }
                if (this.eeW != null) {
                    aVar.e(2, this.eeW);
                }
                if (this.eeX != null) {
                    aVar.e(3, this.eeX);
                }
                if (this.eeY != null) {
                    aVar.e(4, this.eeY);
                }
                aVar.C(5, this.eeZ);
                aVar.C(6, this.efa);
                if (this.efb != null) {
                    aVar.e(7, this.efb);
                }
                if (this.eeB != null) {
                    aVar.e(8, this.eeB);
                }
                if (this.efc != null) {
                    aVar.e(9, this.efc);
                }
                if (this.efd != null) {
                    aVar.b(10, this.efd);
                }
                if (this.efe == null) {
                    return 0;
                }
                aVar.b(11, this.efe);
                return 0;
            }
        } else if (i == 1) {
            if (this.eeV != null) {
                r0 = a.a.a.b.b.a.f(1, this.eeV) + 0;
            } else {
                r0 = 0;
            }
            if (this.eeW != null) {
                r0 += a.a.a.b.b.a.f(2, this.eeW);
            }
            if (this.eeX != null) {
                r0 += a.a.a.b.b.a.f(3, this.eeX);
            }
            if (this.eeY != null) {
                r0 += a.a.a.b.b.a.f(4, this.eeY);
            }
            r0 = (r0 + a.a.a.a.B(5, this.eeZ)) + a.a.a.a.B(6, this.efa);
            if (this.efb != null) {
                r0 += a.a.a.b.b.a.f(7, this.efb);
            }
            if (this.eeB != null) {
                r0 += a.a.a.b.b.a.f(8, this.eeB);
            }
            if (this.efc != null) {
                r0 += a.a.a.b.b.a.f(9, this.efc);
            }
            if (this.efd != null) {
                r0 += a.a.a.a.a(10, this.efd);
            }
            if (this.efe != null) {
                r0 += a.a.a.a.a(11, this.efe);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.eeV == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.eeW == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.eeX == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.eeY == null) {
                throw new a.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.efb == null) {
                throw new a.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.eeB == null) {
                throw new a.a.a.b("Not all required fields were included: Model");
            } else if (this.efc != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Version");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.eeV = aVar3.pMj.readString();
                    return 0;
                case 2:
                    kVar.eeW = aVar3.pMj.readString();
                    return 0;
                case 3:
                    kVar.eeX = aVar3.pMj.readString();
                    return 0;
                case 4:
                    kVar.eeY = aVar3.pMj.readString();
                    return 0;
                case 5:
                    kVar.eeZ = aVar3.pMj.mI();
                    return 0;
                case 6:
                    kVar.efa = aVar3.pMj.mI();
                    return 0;
                case 7:
                    kVar.efb = aVar3.pMj.readString();
                    return 0;
                case 8:
                    kVar.eeB = aVar3.pMj.readString();
                    return 0;
                case 9:
                    kVar.efc = aVar3.pMj.readString();
                    return 0;
                case 10:
                    kVar.efd = aVar3.bQK();
                    return 0;
                case 11:
                    kVar.efe = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
