package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class b extends a<b> {
    public int[] pAi;

    public final /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        int length = this.pAi.length;
        int length2 = bVar.pAi.length;
        if (length != length2) {
            return c.dK(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.pAi[length2] != bVar.pAi[length2]) {
                return c.dK(this.pAi[length2], bVar.pAi[length2]);
            }
        }
        return 0;
    }

    public b(int i, int[] iArr) {
        super(i);
        this.pAi = iArr;
    }
}
