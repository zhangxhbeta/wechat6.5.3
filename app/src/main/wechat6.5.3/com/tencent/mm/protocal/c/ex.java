package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ex extends a {
    public int mfJ;
    public int mfK;
    public LinkedList<String> mfL = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mfJ);
            aVar.dV(2, this.mfK);
            aVar.d(3, 1, this.mfL);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.mfJ) + 0) + a.a.a.a.dS(2, this.mfK)) + a.a.a.a.c(3, 1, this.mfL);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.mfL.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
                ex exVar = (ex) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        exVar.mfJ = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        exVar.mfK = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        exVar.mfL.add(aVar3.pMj.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
