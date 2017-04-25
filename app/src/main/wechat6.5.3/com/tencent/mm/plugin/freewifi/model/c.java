package com.tencent.mm.plugin.freewifi.model;

import android.os.HandlerThread;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class c {
    private HandlerThread fYE;
    private ac fYF;

    public final ac aoU() {
        if (this.fYE == null) {
            this.fYE = e.Lg("FreeWifiHandlerThread_handlerThread");
            this.fYE.start();
        }
        if (this.fYF == null) {
            this.fYF = new ac(this.fYE.getLooper());
        }
        return this.fYF;
    }

    public final void release() {
        if (this.fYE != null) {
            this.fYE.quit();
            this.fYE = null;
        }
        this.fYF = null;
    }
}
