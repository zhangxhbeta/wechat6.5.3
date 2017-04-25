package com.tencent.mm.plugin.talkroom.a;

import a.a.a.b;
import com.tencent.mm.protocal.c.azi;
import java.util.LinkedList;

public final class a extends com.tencent.mm.ba.a {
    public LinkedList<azi> biC = new LinkedList();
    public int hGO;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.d(2, 8, this.biC);
            aVar.dV(3, this.hGO);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = a.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.c(2, 8, this.biC)) + a.a.a.a.dS(3, this.hGO);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.biC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.username = aVar3.pMj.readString();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        azi com_tencent_mm_protocal_c_azi = new azi();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_azi.a(aVar5, com_tencent_mm_protocal_c_azi, com.tencent.mm.ba.a.a(aVar5))) {
                        }
                        aVar4.biC.add(com_tencent_mm_protocal_c_azi);
                    }
                    return 0;
                case 3:
                    aVar4.hGO = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
