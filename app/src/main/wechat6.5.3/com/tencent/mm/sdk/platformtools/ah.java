package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;

public class ah extends ac {
    private static int niq;
    private final int nir;
    private final boolean nja;
    private long njb = 0;
    private boolean njc = false;
    private final a njd;

    public interface a {
        boolean oU();
    }

    public ah(a aVar, boolean z) {
        this.njd = aVar;
        this.nir = btB();
        this.nja = z;
        if (getLooper().getThread().getName().equals("initThread")) {
            v.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", be.bur());
        }
    }

    public ah(Looper looper, a aVar, boolean z) {
        super(looper);
        this.njd = aVar;
        this.nir = btB();
        this.nja = z;
        if (looper.getThread().getName().equals("initThread")) {
            v.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", be.bur());
        }
    }

    private static int btB() {
        if (niq >= 8192) {
            niq = 0;
        }
        int i = niq + 1;
        niq = i;
        return i;
    }

    protected void finalize() {
        QI();
        super.finalize();
    }

    public void handleMessage(Message message) {
        if (message.what == this.nir && this.njd != null && this.njd.oU() && this.nja && !this.njc) {
            sendEmptyMessageDelayed(this.nir, this.njb);
        }
    }

    public final void ea(long j) {
        this.njb = j;
        QI();
        this.njc = false;
        sendEmptyMessageDelayed(this.nir, j);
    }

    public final void QI() {
        removeMessages(this.nir);
        this.njc = true;
    }

    public final boolean btC() {
        return this.njc || !hasMessages(this.nir);
    }

    public String toString() {
        if (this.njd == null) {
            return "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
        }
        return "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.njd.getClass().getName() + "}";
    }
}
