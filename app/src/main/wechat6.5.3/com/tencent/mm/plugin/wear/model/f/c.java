package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.e.a.qx;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.v;

public abstract class c extends d {
    public abstract void send();

    protected final void execute() {
        if (a.bhH().laR.bhM()) {
            qx qxVar = new qx();
            qxVar.bsC.aYt = 11;
            com.tencent.mm.sdk.c.a.nhr.z(qxVar);
            send();
            return;
        }
        v.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
    }
}
