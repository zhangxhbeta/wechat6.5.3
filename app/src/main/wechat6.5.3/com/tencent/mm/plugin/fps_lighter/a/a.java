package com.tencent.mm.plugin.fps_lighter.a;

import android.app.Activity;
import android.view.Choreographer.FrameCallback;

public final class a implements FrameCallback {
    protected Activity aXH;
    protected String brI;
    protected boolean enabled;
    protected boolean fUL;
    protected long fUM;
    protected boolean fUN;
    protected long fUO;

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void di(boolean z) {
        this.fUL = z;
        this.fUO = 0;
        if (z) {
            this.fUM = 0;
        }
    }

    public final void setActivity(Activity activity) {
        this.aXH = activity;
        this.brI = activity.getClass().getSimpleName();
    }

    public final void anX() {
        this.fUN = true;
    }

    public final void doFrame(long j) {
    }
}
