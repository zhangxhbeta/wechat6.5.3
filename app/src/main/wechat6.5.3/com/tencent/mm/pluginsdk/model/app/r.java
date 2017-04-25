package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;

final class r implements Runnable {
    private String appId = null;
    private int cYK = 0;
    private ac handler = null;
    private String url = null;

    public r(ac acVar, String str, int i, String str2) {
        this.handler = acVar;
        this.appId = str;
        this.cYK = i;
        this.url = str2;
    }

    public final void run() {
        if (this.appId != null && this.appId.length() != 0 && this.url != null && this.url.length() != 0) {
            t tVar = new t(this.appId, this.cYK, be.KO(this.url));
            Message obtain = Message.obtain();
            obtain.obj = tVar;
            this.handler.sendMessage(obtain);
        }
    }
}
