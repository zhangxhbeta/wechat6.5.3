package com.tencent.mm.ag;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a implements e {
    public static int cQs = 0;
    public static int cQt = 1;
    public static int cQu = 2;
    private e cAR;
    public boolean cQo = true;
    public int cQp = 0;
    public d cQq;
    public boolean cQr = false;
    private int cQv;
    private int cQw;
    private String cQx;
    private k cQy;
    public int scene;
    public int status = cQs;

    public a(int i, e eVar) {
        this.scene = i;
        this.cAR = eVar;
        ak.vy().a(676, (e) this);
    }

    private void Hf() {
        if (this.cQo) {
            this.cQq = new d(this.scene, this.cQp);
            ak.vy().a(this.cQq, 0);
            this.status = cQt;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            this.cQo = ((d) kVar).hasNext();
            this.cQp = ((d) kVar).Hg();
        }
        v.i("MicroMsg.LinkedInFriendDataMgr", "onSceneEnd, errType:%d, errCode:%d, status:%d, hasNext:%b, uiWaiting:%b, nextPos:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.status), Boolean.valueOf(this.cQo), Boolean.valueOf(this.cQr), Integer.valueOf(this.cQp));
        if (this.cQr) {
            this.cAR.a(i, i2, str, kVar);
            this.cQr = false;
            if (i == 0 && i2 == 0) {
                Hf();
                return;
            }
            return;
        }
        this.cQv = i;
        this.cQw = i2;
        this.cQx = str;
        this.cQy = kVar;
        this.status = cQu;
    }
}
