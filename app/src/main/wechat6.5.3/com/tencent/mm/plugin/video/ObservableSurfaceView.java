package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.sdk.platformtools.v;

public class ObservableSurfaceView extends SurfaceView implements Callback {
    protected SurfaceHolder kob;
    private a koc = null;
    protected boolean kod = false;
    protected boolean koe = false;
    protected boolean kof = false;

    public ObservableSurfaceView(Context context) {
        super(context);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.kob = getHolder();
        this.kob.addCallback(this);
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.kob;
    }

    public final void baP() {
        this.kof = true;
        if (this.kof) {
            this.kob.setType(3);
        }
    }

    public final void a(a aVar) {
        this.koc = aVar;
        if (this.kof) {
            this.kob.setType(3);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.kod = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        v.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.koe = true;
        try {
            this.kob.removeCallback(this);
        } catch (Exception e) {
        }
        this.kob = surfaceHolder;
        this.kob.addCallback(this);
        if (this.koc != null) {
            this.koc.b(this.kob);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.kod = false;
        this.koe = false;
    }

    public final boolean baQ() {
        return this.kod;
    }
}
