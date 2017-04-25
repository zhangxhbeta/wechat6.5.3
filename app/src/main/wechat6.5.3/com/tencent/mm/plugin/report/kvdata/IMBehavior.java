package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public class IMBehavior extends a {
    public IMBehaviorChattingOP chattingOp;
    public IMBehaviorMsgOP msgOp;
    public int opType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.opType);
            if (this.chattingOp != null) {
                aVar.dX(2, this.chattingOp.aHr());
                this.chattingOp.a(aVar);
            }
            if (this.msgOp != null) {
                aVar.dX(3, this.msgOp.aHr());
                this.msgOp.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.opType) + 0;
            if (this.chattingOp != null) {
                r0 += a.a.a.a.dU(2, this.chattingOp.aHr());
            }
            if (this.msgOp != null) {
                return r0 + a.a.a.a.dU(3, this.msgOp.aHr());
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
            IMBehavior iMBehavior = (IMBehavior) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a iMBehaviorChattingOP;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iMBehavior.opType = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        iMBehaviorChattingOP = new IMBehaviorChattingOP();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.a(aVar4, iMBehaviorChattingOP, a.a(aVar4))) {
                        }
                        iMBehavior.chattingOp = iMBehaviorChattingOP;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        iMBehaviorChattingOP = new IMBehaviorMsgOP();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.a(aVar4, iMBehaviorChattingOP, a.a(aVar4))) {
                        }
                        iMBehavior.msgOp = iMBehaviorChattingOP;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
