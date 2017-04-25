package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;

public class LogoWebViewWrapper extends LinearLayout {
    private Context context;
    WebView eQN;
    private int fGk;
    private int iD;
    FrameLayout lin;
    private boolean lio = false;
    private int lip;
    private int liq;
    private c lir;
    private int lis = 0;
    boolean lit = false;
    boolean liu = false;
    int liv = 0;
    a liw;
    b lix;
    private boolean liy = false;
    private int liz = -1;

    public interface a {
        void bjM();
    }

    public interface b {
        void P(int i, boolean z);
    }

    final class c implements Runnable {
        private final long dfS;
        final /* synthetic */ LogoWebViewWrapper liA;
        private final Interpolator liB;
        private final int liC;
        private final int liD;
        boolean liE = true;
        private int liF = -1;
        private long startTime = -1;

        public c(LogoWebViewWrapper logoWebViewWrapper, int i, int i2, long j) {
            this.liA = logoWebViewWrapper;
            this.liD = i;
            this.liC = i2;
            this.liB = logoWebViewWrapper.liu ? new AccelerateInterpolator() : new DecelerateInterpolator();
            this.dfS = j;
        }

        public final void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                long j = 500;
                if (this.dfS > 0) {
                    j = Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / this.dfS, 1000), 0);
                }
                this.liF = this.liD - Math.round(this.liB.getInterpolation(((float) j) / 1000.0f) * ((float) (this.liD - this.liC)));
                this.liA.sV(this.liF);
                if (this.liA.lix != null) {
                    this.liA.lix.P(this.liF, false);
                }
            }
            if (this.liE && this.liC != this.liF) {
                y.a(this.liA, this);
            }
        }
    }

    public LogoWebViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    @TargetApi(11)
    public LogoWebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        setOrientation(1);
        this.iD = ViewConfiguration.get(this.context).getScaledTouchSlop();
    }

    public final FrameLayout bjK() {
        if (this.lin == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getId() == 2131756751) {
                    this.lin = (FrameLayout) childAt;
                    break;
                }
            }
        }
        return this.lin;
    }

    public final void hx(boolean z) {
        this.lit = z;
        if (this.lit) {
            this.lio = false;
            this.lis = 0;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.lit && !this.liy) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.lio = false;
            this.lis = 0;
            return false;
        } else if (action == 2 && this.lio) {
            return true;
        } else {
            switch (action) {
                case 0:
                    if (bjL()) {
                        this.lip = (int) motionEvent.getY();
                        this.fGk = (int) motionEvent.getY();
                        this.liq = (int) motionEvent.getX();
                        this.lio = false;
                        this.lis = 0;
                        this.liy = true;
                        break;
                    }
                    break;
                case 2:
                    if (bjL()) {
                        int y = (int) motionEvent.getY();
                        action = (int) motionEvent.getX();
                        int i = y - this.lip;
                        int i2 = action - this.liq;
                        if (Math.abs(i) > this.iD && Math.abs(i) > Math.abs(i2) && i > 0) {
                            this.lip = y;
                            this.liq = action;
                            if (this.lis != 1) {
                                this.lis++;
                                break;
                            }
                            this.lio = true;
                            v.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
                            if (this.liw != null) {
                                this.liw.bjM();
                                break;
                            }
                        }
                    }
                    break;
            }
            return this.lio;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lit && !this.liy) {
            return false;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.liy = true;
                if (!bjL()) {
                    return false;
                }
                this.lip = (int) motionEvent.getY();
                this.fGk = (int) motionEvent.getY();
                this.liq = (int) motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.lio && !this.liy) {
                    return false;
                }
                this.lio = false;
                i = -this.liv;
                long abs = (long) Math.abs(getScrollY());
                long abs2 = Math.abs(abs - ((long) Math.abs(this.liv)));
                if (abs2 >= abs) {
                    abs = 300;
                } else {
                    abs = (long) ((((float) abs2) / ((float) abs)) * 300.0f);
                }
                y(i, abs);
                post(new Runnable(this) {
                    final /* synthetic */ LogoWebViewWrapper liA;

                    {
                        this.liA = r1;
                    }

                    public final void run() {
                        this.liA.liy = false;
                    }
                });
                return true;
            case 2:
                if (!this.lio) {
                    return false;
                }
                this.lip = (int) motionEvent.getY();
                this.liq = (int) motionEvent.getX();
                int min = Math.min(this.fGk - this.lip, 0) >> 1;
                int height = getHeight();
                if (this.liz < 0) {
                    this.liz = (int) TypedValue.applyDimension(1, 60.0f, this.context.getResources().getDisplayMetrics());
                }
                i = ((int) Math.sqrt((double) ((this.liz >> 1) * Math.abs(min)))) << 1;
                if (i <= Math.abs(min)) {
                    min = -i;
                } else if (Math.abs(min) > height) {
                    min = -height;
                }
                sV(min);
                if (this.lix != null) {
                    this.lix.P(min, true);
                }
                return true;
            default:
                return false;
        }
    }

    private boolean bjL() {
        return this.eQN.getView().getScrollY() == 0;
    }

    public final void sV(int i) {
        int height = getHeight();
        scrollTo(0, Math.min(height, Math.max(-height, i)));
    }

    public final void y(int i, long j) {
        if (this.lir != null) {
            Runnable runnable = this.lir;
            runnable.liE = false;
            runnable.liA.removeCallbacks(runnable);
        }
        int scrollY = getScrollY();
        v.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[]{Integer.valueOf(scrollY), Integer.valueOf(i)});
        if (scrollY != i) {
            this.lir = new c(this, scrollY, i, j);
            post(this.lir);
        }
    }
}
