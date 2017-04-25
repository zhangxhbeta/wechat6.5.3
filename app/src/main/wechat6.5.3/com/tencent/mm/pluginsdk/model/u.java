package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.v;

public final class u extends FileObserver {
    private String iKg;
    private a lAa;

    public interface a {
        void aWB();
    }

    public u(String str, a aVar) {
        super(str);
        v.i("MicroMsg.ScreenshotObserver", "observer  " + str);
        this.lAa = aVar;
    }

    public final void onEvent(int i, String str) {
        if (str != null && i == 8) {
            if (this.iKg == null || !str.equalsIgnoreCase(this.iKg)) {
                this.iKg = str;
                this.lAa.aWB();
                v.i("MicroMsg.ScreenshotObserver", "Send event to listener. " + str);
            }
        }
    }

    public final void start() {
        super.startWatching();
    }

    public final void stop() {
        super.stopWatching();
    }
}
