package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ast extends aqp {
    public int mRn;
    public LinkedList<Integer> mRo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mRn);
            aVar.c(3, this.mRo);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.dS(2, this.mRn)) + a.a.a.a.b(3, this.mRo);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mRo.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ast com_tencent_mm_protocal_c_ast = (ast) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ast.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ast.mRn = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ast.mRo = new a.a.a.a.a(aVar3.bQK().lVU, unknownTagHandler).bQH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
