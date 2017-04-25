package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import java.lang.ref.WeakReference;

public final class i implements c {
    private WeakReference<c> ppN;

    public i(c cVar) {
        this.ppN = new WeakReference(cVar);
    }

    public final void m(int i, byte[] bArr) {
        if (this.ppN == null || this.ppN.get() == null) {
            c.i("OnRespForLongAIDLImpl fail", "callback is null, errCode=" + i);
            return;
        }
        ((c) this.ppN.get()).m(i, bArr);
    }
}
