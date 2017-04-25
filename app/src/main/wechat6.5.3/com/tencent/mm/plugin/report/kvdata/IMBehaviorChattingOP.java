package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.ba.a;

public class IMBehaviorChattingOP extends a {
    public int changeNotifyStatus;
    public int changeSaveAddress;
    public int changeTop;
    public int changeUnread;
    public int expose;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.changeUnread);
            aVar.dV(2, this.changeTop);
            aVar.dV(3, this.changeNotifyStatus);
            aVar.dV(4, this.changeSaveAddress);
            aVar.dV(5, this.expose);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.dS(1, this.changeUnread) + 0) + a.a.a.a.dS(2, this.changeTop)) + a.a.a.a.dS(3, this.changeNotifyStatus)) + a.a.a.a.dS(4, this.changeSaveAddress)) + a.a.a.a.dS(5, this.expose);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                IMBehaviorChattingOP iMBehaviorChattingOP = (IMBehaviorChattingOP) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iMBehaviorChattingOP.changeUnread = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        iMBehaviorChattingOP.changeTop = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        iMBehaviorChattingOP.changeNotifyStatus = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        iMBehaviorChattingOP.changeSaveAddress = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        iMBehaviorChattingOP.expose = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
