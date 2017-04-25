package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.t.a.a;

public final class c extends a<c> {
    public int[] pAj;

    public final /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        int length = this.pAj.length;
        int length2 = cVar.pAj.length;
        if (length != length2) {
            return com.tencent.tinker.a.a.b.c.dK(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.pAj[length2] != cVar.pAj[length2]) {
                return com.tencent.tinker.a.a.b.c.dK(this.pAj[length2], cVar.pAj[length2]);
            }
        }
        return 0;
    }

    public c(int i, int[] iArr) {
        super(i);
        this.pAj = iArr;
    }
}
