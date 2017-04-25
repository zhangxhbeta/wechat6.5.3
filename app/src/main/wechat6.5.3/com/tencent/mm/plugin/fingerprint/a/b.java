package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.e.a.bd;
import com.tencent.mm.e.a.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends c<bd> implements e {
    private bd fTw;
    private boolean fTx;

    public b() {
        this.fTx = false;
        this.nhz = bd.class.getName().hashCode();
    }

    private boolean a(bd bdVar) {
        if (ak.uz()) {
            this.fTx = false;
            if (!(bdVar instanceof bd)) {
                return false;
            }
            this.fTw = bdVar;
            v.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
            ak.vy().a(385, this);
            ak.vy().a(new d(), 0);
            return true;
        }
        v.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof d) {
            a aVar = new a();
            v.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                aVar.aYJ = 0;
            } else {
                v.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                aVar.aYJ = i2;
            }
            ak.vy().b(385, this);
            this.fTw.aYI = aVar;
            this.fTx = true;
            if (this.fTw.bpT != null) {
                this.fTw.bpT.run();
            }
            if (this.fTx) {
                this.fTw = null;
            }
        }
    }
}
