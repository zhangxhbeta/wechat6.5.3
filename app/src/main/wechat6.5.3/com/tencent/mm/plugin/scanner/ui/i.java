package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public abstract class i {
    protected TextView dMQ;
    protected ProgressDialog dwR = null;
    protected boolean iAE = true;
    protected Rect iAF;
    protected com.tencent.mm.plugin.scanner.b.b iAG;
    protected Point iAH;
    protected int iAI;
    protected int iAJ;
    protected int iAK = 40;
    protected int iAL = 20;
    protected b iAM;
    protected int iAN;
    protected Point iAO;
    protected ac iAP = new ac(this) {
        final /* synthetic */ i iAQ;

        {
            this.iAQ = r1;
        }

        public final void handleMessage(Message message) {
            if (message != null && message.what == 1 && this.iAQ.dMQ != null) {
                this.iAQ.dMQ.setVisibility(0);
            }
        }
    };

    public interface a {
        void b(Activity activity, int i, int i2, Intent intent);
    }

    public interface b {
        void a(a aVar);

        void a(String str, int i, int i2, int i3, com.tencent.mm.plugin.scanner.b.e.a aVar);

        void aLl();

        void aLs();

        boolean aLt();

        void aLu();

        void aLv();

        Activity aLx();

        void b(int i, OnClickListener onClickListener);

        void cz(long j);

        void fh(boolean z);

        View findViewById(int i);

        void h(long j, boolean z);
    }

    protected abstract void aLa();

    protected abstract com.tencent.mm.plugin.scanner.b.b aLb();

    protected abstract int aLc();

    protected abstract int aLd();

    protected abstract void aLe();

    protected abstract boolean aLf();

    protected abstract boolean aLg();

    protected abstract void g(Rect rect);

    protected abstract void onResume();

    public final b aLH() {
        return this.iAM;
    }

    protected final void fj(boolean z) {
        if (this.dMQ != null) {
            if (z) {
                this.dMQ.setVisibility(4);
                this.iAP.sendEmptyMessageDelayed(1, 210);
                return;
            }
            this.iAP.removeMessages(1);
            this.dMQ.setVisibility(4);
        }
    }

    public i(b bVar, Point point) {
        this.iAM = bVar;
        this.iAH = point;
    }

    public i(b bVar, Point point, byte b) {
        this.iAM = bVar;
        this.iAH = point;
        this.iAK = 50;
    }

    protected void onPause() {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
    }

    protected void bX(View view) {
    }

    protected final double cj(int i, int i2) {
        Context aLx = this.iAM.aLx();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) aLx.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = ((double) displayMetrics.densityDpi) / 160.0d;
        v.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", new Object[]{Double.valueOf(d)});
        if (d > 1.2d) {
            if (this.iAH.x + this.iAH.y <= 3000 || d >= 2.4d) {
                this.iAI = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), (float) i);
                this.iAJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), (float) i2);
            } else {
                this.iAI = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i) * 1.6f);
                this.iAJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i2) * 1.6f);
            }
        } else if (this.iAH != null && this.iAH.x + this.iAH.y > 1560) {
            this.iAI = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i) * 1.7f);
            this.iAJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i2) * 1.7f);
        } else if (this.iAH == null || this.iAH.x + this.iAH.y <= 1460) {
            this.iAI = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i) / 1.1f);
            this.iAJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i2) / 1.1f);
        } else {
            this.iAI = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i) * 1.1f);
            this.iAJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), ((float) i2) * 1.1f);
        }
        if (this.iAI % 2 == 1) {
            this.iAI++;
        }
        if (this.iAJ % 2 == 1) {
            this.iAJ++;
        }
        v.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d", new Object[]{Integer.valueOf(this.iAI), Integer.valueOf(this.iAJ)});
        return d;
    }

    protected final Rect p(boolean z, boolean z2) {
        if (this.iAF == null || z) {
            int i;
            int i2;
            int i3;
            int i4 = this.iAH.x;
            int i5 = this.iAH.y;
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), (float) this.iAK);
            if (this.iAM.aLt()) {
                i = a;
            } else {
                i = 0;
            }
            if (z2) {
                if (i4 < i5) {
                    i2 = (i5 / 2) - (this.iAI / 2);
                    i3 = (this.iAI / 2) + (i5 / 2);
                    a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), (float) this.iAL);
                    i = this.iAJ + a;
                } else {
                    i2 = (i4 / 2) - (this.iAI / 2);
                    i3 = (this.iAI / 2) + (i4 / 2);
                    a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.iAM.aLx(), (float) this.iAL);
                    i = this.iAJ + a;
                }
            } else if (i4 < i5) {
                i2 = (i4 / 2) - (this.iAI / 2);
                i3 = (this.iAI / 2) + (i4 / 2);
                a = (i5 / 2) - (this.iAJ / 2);
                if (a - i > 0) {
                    a -= i;
                }
                i = this.iAJ + a;
            } else {
                i2 = (i5 / 2) - (this.iAI / 2);
                i3 = (this.iAI / 2) + (i5 / 2);
                a = (i4 / 2) - (this.iAJ / 2);
                if (a - i > 0) {
                    a -= i;
                }
                i = this.iAJ + a;
            }
            v.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(a), Integer.valueOf(i)});
            this.iAF = new Rect(i2, a, i3, i);
        }
        return this.iAF;
    }

    protected Rect fk(boolean z) {
        return p(true, z);
    }

    protected void c(Point point) {
        this.iAO = point;
    }

    public boolean oZ() {
        return false;
    }
}
