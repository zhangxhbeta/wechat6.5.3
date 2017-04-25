package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import com.tencent.mm.network.h.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class ab extends a {
    private ah cxS = new ah(new ah.a(this) {
        final /* synthetic */ ab dmK;

        {
            this.dmK = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.NetworkEvent", "listeners ct : %d", Integer.valueOf(this.dmK.dmJ.beginBroadcast()));
            for (int i = r0 - 1; i >= 0; i--) {
                try {
                    ((m) this.dmK.dmJ.getBroadcastItem(i)).cI(this.dmK.dmG);
                } catch (Throwable e) {
                    v.e("MicroMsg.NetworkEvent", "exception:%s", be.e(e));
                }
            }
            this.dmK.dmJ.finishBroadcast();
            return false;
        }
    }, false);
    private int dmG = 4;
    private long dmH;
    private int dmI = 0;
    private final RemoteCallbackList<m> dmJ = new RemoteCallbackList();

    public final int Mb() {
        v.i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(0 > be.ax(this.dmH) ? 5 : this.dmG));
        return 0 > be.ax(this.dmH) ? 5 : this.dmG;
    }

    public final boolean c(m mVar) {
        try {
            this.dmJ.register(mVar);
        } catch (Throwable e) {
            v.e("MicroMsg.NetworkEvent", "addListener %s", e);
            v.e("MicroMsg.NetworkEvent", "exception:%s", be.e(e));
        }
        return true;
    }

    public final boolean d(m mVar) {
        boolean z = false;
        try {
            z = this.dmJ.unregister(mVar);
        } catch (Throwable e) {
            v.e("MicroMsg.NetworkEvent", "removeListener %s", e);
            v.e("MicroMsg.NetworkEvent", "exception:%s", be.e(e));
        }
        return z;
    }

    public final void Mc() {
        this.dmJ.kill();
    }

    public final void gE(int i) {
        int i2 = 0;
        v.i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i));
        if (i != this.dmG) {
            if (3 != i) {
                if (2 == i) {
                    if (!(this.dmG == 0 || this.dmG == 1)) {
                        this.dmI++;
                        if (this.dmI > 0) {
                            this.dmG = 2;
                            i2 = 1;
                        }
                    }
                } else if (4 == i) {
                    this.dmI = 0;
                    this.dmG = 4;
                    i2 = 1;
                }
                this.dmG = i;
                i2 = 1;
            } else if (this.dmG == 2) {
                this.dmG = i;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            if (i == 0 || i == 6) {
                this.cxS.ea(1000);
            }
        }
    }

    public final long Md() {
        return this.dmH;
    }
}
