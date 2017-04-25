package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class e {
    private ac cnC;
    HandlerThread gdQ = new HandlerThread("galleryDecodeHanlderThread", 10);
    HandlerThread gdR;
    HandlerThread gdS;
    ac gdT = null;
    ac gdU;
    ac gdV;

    public e() {
        v.d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
        this.gdQ.start();
        this.gdR = new HandlerThread("galleryQueryHandlerThread", 1);
        this.gdU = null;
        this.gdR.start();
        this.gdS = new HandlerThread("galleryAfterTakePicThreadThread", 0);
        this.gdV = null;
        this.gdS.start();
    }

    public final ac aqy() {
        if (this.gdT == null && this.gdQ != null) {
            this.gdT = new ac(this.gdQ.getLooper());
        }
        return this.gdT;
    }

    public final void lg(int i) {
        try {
            Process.setThreadPriority(this.gdS.getThreadId(), i);
        } catch (Throwable e) {
            v.a("MicroMsg.GalleryHandlerThread", e, "", new Object[0]);
        }
    }

    public final ac aqz() {
        if (this.cnC == null) {
            this.cnC = new ac(Looper.getMainLooper());
        }
        return this.cnC;
    }

    public final void n(Runnable runnable) {
        ac aqy = aqy();
        if (aqy == null) {
            v.e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
        } else {
            aqy.post(runnable);
        }
    }

    public final void aqA() {
        ac aqy = aqy();
        if (aqy == null) {
            v.e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
        } else {
            aqy.removeCallbacksAndMessages(null);
        }
    }

    public final void o(Runnable runnable) {
        aqz().post(runnable);
    }
}
