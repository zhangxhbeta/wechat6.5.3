package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class acj extends a {
    public int mDs;
    public acm mDt;
    public acl mDu;
    public ack mDv;
    public aci mDw;
    public acn mDx;
    public aco mDy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mDs);
            if (this.mDt != null) {
                aVar.dX(2, this.mDt.aHr());
                this.mDt.a(aVar);
            }
            if (this.mDu != null) {
                aVar.dX(3, this.mDu.aHr());
                this.mDu.a(aVar);
            }
            if (this.mDv != null) {
                aVar.dX(4, this.mDv.aHr());
                this.mDv.a(aVar);
            }
            if (this.mDw != null) {
                aVar.dX(5, this.mDw.aHr());
                this.mDw.a(aVar);
            }
            if (this.mDx != null) {
                aVar.dX(6, this.mDx.aHr());
                this.mDx.a(aVar);
            }
            if (this.mDy != null) {
                aVar.dX(7, this.mDy.aHr());
                this.mDy.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mDs) + 0;
            if (this.mDt != null) {
                r0 += a.a.a.a.dU(2, this.mDt.aHr());
            }
            if (this.mDu != null) {
                r0 += a.a.a.a.dU(3, this.mDu.aHr());
            }
            if (this.mDv != null) {
                r0 += a.a.a.a.dU(4, this.mDv.aHr());
            }
            if (this.mDw != null) {
                r0 += a.a.a.a.dU(5, this.mDw.aHr());
            }
            if (this.mDx != null) {
                r0 += a.a.a.a.dU(6, this.mDx.aHr());
            }
            if (this.mDy != null) {
                return r0 + a.a.a.a.dU(7, this.mDy.aHr());
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
            acj com_tencent_mm_protocal_c_acj = (acj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_acj.mDs = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        acm com_tencent_mm_protocal_c_acm = new acm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_acm.a(aVar4, com_tencent_mm_protocal_c_acm, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acj.mDt = com_tencent_mm_protocal_c_acm;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        acl com_tencent_mm_protocal_c_acl = new acl();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_acl.a(aVar4, com_tencent_mm_protocal_c_acl, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acj.mDu = com_tencent_mm_protocal_c_acl;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ack com_tencent_mm_protocal_c_ack = new ack();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ack.a(aVar4, com_tencent_mm_protocal_c_ack, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acj.mDv = com_tencent_mm_protocal_c_ack;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aci com_tencent_mm_protocal_c_aci = new aci();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aci.a(aVar4, com_tencent_mm_protocal_c_aci, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acj.mDw = com_tencent_mm_protocal_c_aci;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        acn com_tencent_mm_protocal_c_acn = new acn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_acn.a(aVar4, com_tencent_mm_protocal_c_acn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acj.mDx = com_tencent_mm_protocal_c_acn;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aco com_tencent_mm_protocal_c_aco = new aco();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aco.a(aVar4, com_tencent_mm_protocal_c_aco, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acj.mDy = com_tencent_mm_protocal_c_aco;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
