package com.tencent.mm.plugin.fps_lighter.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class c implements ActivityLifecycleCallbacks {
    private List<a> cJC;
    private boolean fUT;
    private Runnable fUU;
    private Activity fUV;
    private boolean foreground;
    private Handler handler;

    public interface a {
        void r(Activity activity);

        void s(Activity activity);

        void t(Activity activity);

        void u(Activity activity);
    }

    public final void onActivityResumed(final Activity activity) {
        this.fUT = false;
        final boolean z = !this.foreground;
        this.foreground = true;
        if (activity != this.fUV) {
            for (a u : this.cJC) {
                try {
                    u.u(activity);
                } catch (Exception e) {
                    v.e("MicroMsg.Foreground", "Listener threw exception!", new Object[]{e});
                }
            }
            this.fUV = activity;
        }
        Handler handler = this.handler;
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ c fUX;

            public final void run() {
                if (z) {
                    v.i("MicroMsg.Foreground", "went foreground");
                    for (a r : this.fUX.cJC) {
                        try {
                            r.r(activity);
                        } catch (Exception e) {
                            v.e("MicroMsg.Foreground", "Listener threw exception!", new Object[]{e});
                        }
                    }
                    return;
                }
                v.i("MicroMsg.Foreground", "still foreground");
            }
        };
        this.fUU = anonymousClass1;
        handler.postDelayed(anonymousClass1, 600);
    }

    public final void onActivityPaused(final Activity activity) {
        this.fUT = true;
        if (this.fUU != null) {
            this.handler.removeCallbacks(this.fUU);
        }
        Handler handler = this.handler;
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ c fUX;

            public final void run() {
                if (this.fUX.foreground && this.fUX.fUT) {
                    this.fUX.foreground = false;
                    v.i("MicroMsg.Foreground", "went background");
                    for (a s : this.fUX.cJC) {
                        try {
                            s.s(activity);
                        } catch (Exception e) {
                            v.e("MicroMsg.Foreground", "Listener threw exception!", new Object[]{e});
                        }
                    }
                    return;
                }
                v.i("MicroMsg.Foreground", "still foreground");
            }
        };
        this.fUU = anonymousClass2;
        handler.postDelayed(anonymousClass2, 600);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        v.i("MicroMsg.Foreground", "Activity:%s", new Object[]{activity.getClass().getName()});
        this.fUV = activity;
        for (a t : this.cJC) {
            try {
                t.t(activity);
            } catch (Exception e) {
                v.e("MicroMsg.Foreground", "Listener threw exception!", new Object[]{e});
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }
}
