package com.tencent.mm.memory.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;

public class b extends BitmapDrawable implements i {
    i cnS;

    public b(Resources resources, n nVar) {
        super(resources, nVar == null ? null : nVar.wn());
        this.cnS = nVar;
    }

    public final void wi() {
        if (this.cnS != null) {
            this.cnS.wi();
        }
    }

    public final void wj() {
        if (this.cnS != null) {
            this.cnS.wj();
        }
    }
}
