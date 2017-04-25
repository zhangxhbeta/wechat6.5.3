package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public abstract class a implements e {
    protected int errCode = 0;
    protected int errType = 0;
    public a gFC;
    public c gFa;

    public interface a {
        void a(int i, Object obj, int i2, int i3);

        void b(int i, Object obj, int i2, int i3);
    }

    public abstract int CV();

    public abstract int[] aux();

    public abstract void b(c cVar);

    public abstract void onDestroy();

    public abstract void op();

    public void init() {
        for (int a : aux()) {
            ak.vy().a(a, this);
        }
        op();
    }

    public void destroy() {
        for (int b : aux()) {
            ak.vy().b(b, this);
        }
        this.gFC = null;
        onDestroy();
    }

    public void a(c cVar) {
        v.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[]{Integer.valueOf(CV())});
        this.gFa = cVar;
        b(this.gFa);
    }

    public void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()), Integer.valueOf(CV())});
        this.errType = i;
        this.errCode = i2;
        if (i == 0 && i2 == 0) {
            if (this.gFC != null) {
                this.gFC.a(CV(), kVar, i, i2);
            }
        } else if (this.gFC != null) {
            this.gFC.b(CV(), kVar, i, i2);
        }
    }
}
