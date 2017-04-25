package com.tencent.mm.app;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.eg;

public final class g {
    private static g aQH;
    private FrameLayout aQI;
    private WindowManager aQJ;
    private LayoutParams aQK;
    private ViewGroup.LayoutParams aQL;
    public boolean aQM;
    public BitmapDrawable aQN = null;
    @Deprecated
    public Boolean aQO = Boolean.valueOf(false);
    private final int aQP = 5;
    protected Object mLock = new Object();
    private View mView;

    public interface a {
        void op();
    }

    class AnonymousClass1 implements eg {
        final /* synthetic */ a aQQ;
        final /* synthetic */ g aQR;

        public AnonymousClass1(g gVar, a aVar) {
            this.aQR = gVar;
            this.aQQ = aVar;
        }

        public final void oo() {
            v.i("MicroMsg.INIT", "start time check WorkerProfile.getInstance().hasCreate:%b, onviewDrawed time: %d", Boolean.valueOf(WorkerProfile.oE().oF()), Long.valueOf(System.currentTimeMillis() - LauncherUI.nBA));
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 aQS;

                {
                    this.aQS = r1;
                }

                public final void run() {
                    v.i("MicroMsg.INIT", "start time check post run: " + (System.currentTimeMillis() - LauncherUI.nBA));
                    com.tencent.mm.kernel.g.vx().a(new e(this) {
                        final /* synthetic */ AnonymousClass1 aQT;

                        {
                            this.aQT = r1;
                        }

                        public final void ok() {
                            this.aQT.aQS.aQQ.op();
                            v.i("MicroMsg.INIT", "start time check notifyALLinit  hascreate: " + (System.currentTimeMillis() - LauncherUI.nBA));
                            com.tencent.mm.kernel.g.vx().b((e) this);
                        }

                        public final void ah(boolean z) {
                        }
                    });
                }
            });
        }
    }

    public static g om() {
        if (aQH == null) {
            aQH = new g();
        }
        return aQH;
    }

    public final void a(Activity activity, View view) {
        if (activity instanceof Activity) {
            activity.setContentView(view);
        } else if (this.aQI == null || this.aQJ == null) {
            this.aQK = new LayoutParams();
            this.aQK.height = -1;
            this.aQK.width = -1;
            this.aQJ = (WindowManager) activity.getSystemService("window");
            this.aQK.x = 0;
            this.aQK.y = 0;
            this.aQK.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
            this.mView = view;
            this.aQK.gravity = 51;
            this.aQK.format = 1;
            this.aQI = new FrameLayout(activity);
            this.aQI.setPadding(0, 0, 0, 0);
            this.aQL = new ViewGroup.LayoutParams(-1, -1);
            this.aQI.addView(this.mView, this.aQL);
            this.aQJ.addView(this.aQI, this.aQK);
            this.aQM = true;
        }
    }

    public final void on() {
        try {
            synchronized (this.mLock) {
                if (this.aQJ != null) {
                    if (this.aQI != null) {
                        this.aQJ.removeView(this.aQI);
                    }
                    this.aQJ = null;
                }
                if (this.aQI != null) {
                    this.aQI.removeAllViews();
                    this.aQI = null;
                }
                this.mView = null;
                this.aQM = false;
            }
        } catch (Exception e) {
        }
        this.aQM = false;
    }
}
