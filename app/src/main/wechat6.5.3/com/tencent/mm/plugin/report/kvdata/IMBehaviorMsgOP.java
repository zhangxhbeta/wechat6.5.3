package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.ba.a;

public class IMBehaviorMsgOP extends a {
    public int appMsgInnerType;
    public int count;
    public int msgOpType;
    public int msgType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.msgType);
            aVar.dV(2, this.msgOpType);
            aVar.dV(3, this.appMsgInnerType);
            aVar.dV(4, this.count);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.dS(1, this.msgType) + 0) + a.a.a.a.dS(2, this.msgOpType)) + a.a.a.a.dS(3, this.appMsgInnerType)) + a.a.a.a.dS(4, this.count);
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
                IMBehaviorMsgOP iMBehaviorMsgOP = (IMBehaviorMsgOP) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iMBehaviorMsgOP.msgType = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        iMBehaviorMsgOP.msgOpType = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        iMBehaviorMsgOP.appMsgInnerType = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        iMBehaviorMsgOP.count = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
