package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends OrientationEventListener {
    public int hmn = -1;
    public int hmo = -1;
    private long hmp = 0;
    private long hmq = 0;
    public a hmr;
    public int orientation = -1;

    public interface a {
        void mW(int i);
    }

    public b(Context context) {
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        if (!g.hnq) {
            return;
        }
        if (be.az(this.hmq) < 2000) {
            v.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            return;
        }
        int i2;
        if (i > 70) {
            if (i > 70 && i < 120) {
                i2 = 90;
                if (Math.abs(this.hmn - i) < 30) {
                }
                v.i("MicroMsg.DeviceOrientationListener", "onOrientationChanged update: %s, after align: %s, lastOrientation: %s, lastRawOrientation: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hmo), Integer.valueOf(this.hmn)});
                this.hmo = this.orientation;
                this.orientation = i2;
                this.hmn = i;
                this.hmp = be.Nj();
                if (this.hmr == null) {
                    this.hmr.mW(this.orientation);
                }
            } else if (i >= 120 && i < 240) {
                i2 = 180;
                if (Math.abs(this.hmn - i) < 30) {
                }
                v.i("MicroMsg.DeviceOrientationListener", "onOrientationChanged update: %s, after align: %s, lastOrientation: %s, lastRawOrientation: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hmo), Integer.valueOf(this.hmn)});
                this.hmo = this.orientation;
                this.orientation = i2;
                this.hmn = i;
                this.hmp = be.Nj();
                if (this.hmr == null) {
                    this.hmr.mW(this.orientation);
                }
            } else if (i >= 240 && i < 290) {
                i2 = 270;
                if (Math.abs(this.hmn - i) < 30 || this.hmn < 0 || this.hmo < 0 || be.az(this.hmp) >= 300) {
                    v.i("MicroMsg.DeviceOrientationListener", "onOrientationChanged update: %s, after align: %s, lastOrientation: %s, lastRawOrientation: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hmo), Integer.valueOf(this.hmn)});
                    this.hmo = this.orientation;
                    this.orientation = i2;
                    this.hmn = i;
                    this.hmp = be.Nj();
                    if (this.hmr == null) {
                        this.hmr.mW(this.orientation);
                    }
                }
                return;
            }
        }
        i2 = 0;
        if (Math.abs(this.hmn - i) < 30) {
        }
        v.i("MicroMsg.DeviceOrientationListener", "onOrientationChanged update: %s, after align: %s, lastOrientation: %s, lastRawOrientation: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hmo), Integer.valueOf(this.hmn)});
        this.hmo = this.orientation;
        this.orientation = i2;
        this.hmn = i;
        this.hmp = be.Nj();
        if (this.hmr == null) {
            this.hmr.mW(this.orientation);
        }
    }

    public final void enable() {
        v.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[]{Boolean.valueOf(g.hnq)});
        if (g.hnq) {
            super.enable();
            this.hmq = be.Nj();
        }
    }

    public final int getOrientation() {
        if (g.hnq) {
            return this.orientation;
        }
        return 0;
    }

    public final boolean azQ() {
        if (!g.hnq) {
            return false;
        }
        v.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[]{Long.valueOf(be.az(this.hmq)), Integer.valueOf(this.orientation)});
        if (be.az(this.hmq) < 2000 || this.orientation < 0) {
            return false;
        }
        if (this.orientation == 90 || this.orientation == 270) {
            return true;
        }
        return false;
    }
}
