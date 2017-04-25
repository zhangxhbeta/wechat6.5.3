package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.j;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BaseConversationUI extends MMFragmentActivity {
    private ActionBar FG;
    com.tencent.mm.ui.b fnr;
    private long nBE = 0;
    private String nBT;
    private int nBV = -1;
    private View nCb;
    private View nCc;
    private com.tencent.mm.ui.chatting.ChattingUI.a nCd;
    private TestTimeForChatting nCe;
    private OnLayoutChangedLinearLayout nCf;
    private com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a nCg = new com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a(this) {
        final /* synthetic */ BaseConversationUI oJQ;

        {
            this.oJQ = r1;
        }

        public final void bzP() {
            if (this.oJQ.nCn == null) {
                this.oJQ.nCn = AnimationUtils.loadAnimation(this.oJQ, com.tencent.mm.ui.MMFragmentActivity.a.nFE);
                this.oJQ.nCn.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass4 oJR;

                    {
                        this.oJR = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        v.i("MicroMsg.BaseConversationUI", "klem onAnimationStart");
                        this.oJR.oJQ.nCe.clU = 0;
                        BaseConversationUI.a(this.oJR.oJQ, false);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        v.i("MicroMsg.BaseConversationUI", "klem animationEnd");
                        ad.o(new Runnable(this.oJR.oJQ) {
                            final /* synthetic */ BaseConversationUI oJQ;

                            {
                                this.oJQ = r1;
                            }

                            public final void run() {
                                ak.vA().btw();
                                ad.va(0);
                                if (!(this.oJQ.nCe == null || this.oJQ.nCd == null)) {
                                    this.oJQ.nCe.bJw();
                                    this.oJQ.nCd.gYg = true;
                                    this.oJQ.nCd.bFj();
                                    this.oJQ.nCd.jL(false);
                                }
                                this.oJQ.bzL();
                            }

                            public final String toString() {
                                return super.toString() + "|chattingView_onAnimationEnd";
                            }
                        });
                        this.oJR.oJQ.I(1.0f);
                    }
                });
            }
            if (this.oJQ.nCm) {
                this.oJQ.nCd.mView.startAnimation(this.oJQ.nCn);
                this.oJQ.nCm = false;
            } else {
                this.oJQ.nCe.clU = 0;
                ad.o(/* anonymous class already generated */);
            }
            this.oJQ.nCf.obu = null;
            v.i("MicroMsg.BaseConversationUI", "klem CHATTING ONLAYOUT ");
        }
    };
    String nCh;
    Bundle nCi;
    Runnable nCj = new Runnable(this) {
        final /* synthetic */ BaseConversationUI oJQ;

        {
            this.oJQ = r1;
        }

        public final void run() {
            this.oJQ.nCo = false;
            if (!this.oJQ.isFinishing()) {
                String str = "MicroMsg.BaseConversationUI";
                String str2 = "ashutest::startChatting, ishow:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(this.oJQ.nCe == null ? false : this.oJQ.nCe.isShown());
                v.i(str, str2, objArr);
                Intent putExtra = new Intent().putExtra("Chat_User", this.oJQ.nCh);
                if (this.oJQ.nCi != null) {
                    putExtra.putExtras(this.oJQ.nCi);
                }
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                BaseConversationUI.a(this.oJQ, putExtra);
                this.oJQ.nCf.obu = this.oJQ.nCg;
                this.oJQ.nCe.setVisibility(0);
                BaseConversationUI baseConversationUI = this.oJQ;
                if (!(baseConversationUI.oJN == null || baseConversationUI.oJN.bAm())) {
                    baseConversationUI.oJN.iU(false);
                }
                if (this.oJQ.nCd.bAm()) {
                    j.a(this.oJQ);
                }
                d.a(4, this.oJQ.getLocalClassName(), this.oJQ.hashCode());
                d.a(3, "ChattingUI" + this.oJQ.nCd.bFo(), this.oJQ.nCd.hashCode());
                this.oJQ.nBE = be.Nh();
            }
        }

        public final String toString() {
            return super.toString() + "|startChattingRunnable";
        }
    };
    private Animation nCl;
    private boolean nCm = false;
    private Animation nCn;
    public boolean nCo = true;
    public b oJN;
    private a oJO = a.ACTIVITY_CREATE;
    private c oJP = new c();
    private long ovB = 0;
    private boolean ovz = false;
    String title;

    private enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE
    }

    private class c implements Runnable {
        int aKK;
        int aZt;
        Intent aZu;
        int nCM;
        final /* synthetic */ BaseConversationUI oJQ;

        private c(BaseConversationUI baseConversationUI) {
            this.oJQ = baseConversationUI;
            this.nCM = 0;
        }

        public final void run() {
            if (ak.uz()) {
                v.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.nCM));
                this.oJQ.a(this.oJQ.nBT, null, false);
                ad.o(new Runnable(this) {
                    final /* synthetic */ c oJZ;

                    {
                        this.oJZ = r1;
                    }

                    public final void run() {
                        boolean z = true;
                        String str = "MicroMsg.BaseConversationUI";
                        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                        Object[] objArr = new Object[1];
                        if (this.oJZ.oJQ.nCd != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        v.d(str, str2, objArr);
                        if (this.oJZ.oJQ.nCd != null) {
                            v.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. do post activity result");
                            this.oJZ.oJQ.nCd.onActivityResult(this.oJZ.aZt & 65535, this.oJZ.aKK, this.oJZ.aZu);
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|PostSelectImageJob_onActivityResult";
                    }
                });
            } else if (this.nCM >= 3) {
                v.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
            } else {
                v.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", Integer.valueOf(this.nCM));
                this.nCM++;
                ad.g(this, 300);
            }
        }

        public final String toString() {
            return super.toString() + "|PostSelectImageJob";
        }
    }

    public static class b extends p {
        public BaseConversationUI oJX;
        private a oJY = a.ACTIVITY_CREATE;

        public int getLayoutId() {
            return 0;
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.oJY = a.ACTIVITY_CREATE;
            this.oJX = (BaseConversationUI) bzo();
            View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            aI();
            return inflate;
        }

        public final void Fd(String str) {
            if (this.oJX != null) {
                BaseConversationUI baseConversationUI = this.oJX;
                baseConversationUI.title = str;
                if (baseConversationUI.fnr != null) {
                    baseConversationUI.adg();
                }
            }
        }

        public final void finish() {
            bzo().finish();
        }

        public void onResume() {
            super.onResume();
            this.oJY = a.ACTIVITY_RESUME;
        }

        public void onPause() {
            super.onPause();
            this.oJY = a.ACTIVITY_PAUSE;
        }

        public void onDestroy() {
            if (this.oJY != a.ACTIVITY_PAUSE) {
                v.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
                onPause();
            }
            super.onDestroy();
        }

        public String getUserName() {
            return null;
        }
    }

    static /* synthetic */ void a(BaseConversationUI baseConversationUI, Intent intent) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (baseConversationUI.nCd == null) {
            baseConversationUI.nCd = baseConversationUI.bHZ();
            baseConversationUI.nCd.d(baseConversationUI.nCb, baseConversationUI.nCc);
            baseConversationUI.nCb = null;
            baseConversationUI.nCc = null;
            z = true;
        } else {
            z = false;
        }
        final int[] iArr;
        View bIb;
        if (baseConversationUI.nCe == null) {
            if (baseConversationUI.nCd.bAm()) {
                iArr = new int[2];
                baseConversationUI.cU().cV().getCustomView().getLocationInWindow(iArr);
                View testTimeForChatting = new TestTimeForChatting(baseConversationUI);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(2131755024);
                baseConversationUI.nBV = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final View fitSystemWindowLayoutView = new FitSystemWindowLayoutView(baseConversationUI);
                fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                bIb = baseConversationUI.bIb();
                if (bIb == null) {
                    bIb = ((ViewGroup) baseConversationUI.getWindow().getDecorView()).getChildAt(0);
                }
                final ViewGroup viewGroup = bIb instanceof SwipeBackLayout ? (ViewGroup) ((ViewGroup) bIb).getChildAt(0) : (ViewGroup) bIb;
                ((ViewGroup) baseConversationUI.getWindow().getDecorView()).removeView(bIb);
                bIb.setId(2131755055);
                fitSystemWindowLayoutView.addView(bIb);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) baseConversationUI.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                baseConversationUI.getWindow().getDecorView().requestFitSystemWindows();
                int i = iArr[1];
                if (i > 0) {
                    baseConversationUI.a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    baseConversationUI.cU().cV().getCustomView().post(new Runnable(baseConversationUI) {
                        final /* synthetic */ BaseConversationUI oJQ;

                        public final void run() {
                            this.oJQ.cU().cV().getCustomView().getLocationInWindow(iArr);
                            int i = iArr[1];
                            if (i > 0) {
                                this.oJQ.a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                            } else if (com.tencent.mm.compatible.util.d.dW(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                                    final /* synthetic */ AnonymousClass5 oJS;

                                    {
                                        this.oJS = r1;
                                    }

                                    @TargetApi(20)
                                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                        if (windowInsets != null) {
                                            v.i("MicroMsg.BaseConversationUI", "OnApplyWindowInsetsListener %s", windowInsets);
                                            windowInsets.consumeSystemWindowInsets();
                                            this.oJS.oJQ.a(fitSystemWindowLayoutView, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                        }
                                        return windowInsets;
                                    }
                                });
                            }
                        }
                    });
                }
                baseConversationUI.nCe = (TestTimeForChatting) baseConversationUI.findViewById(baseConversationUI.nBV);
                v.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr[1]));
            } else {
                baseConversationUI.nCe = (TestTimeForChatting) baseConversationUI.findViewById(2131755642);
                baseConversationUI.nBV = baseConversationUI.nCe.getId();
            }
        } else if (baseConversationUI.nCd.bAm()) {
            iArr = new int[2];
            baseConversationUI.nCe.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                ViewGroup viewGroup2 = (ViewGroup) baseConversationUI.getWindow().getDecorView();
                for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    bIb = ((ViewGroup) baseConversationUI.getWindow().getDecorView()).getChildAt(i2);
                    if (bIb instanceof FitSystemWindowLayoutView) {
                        baseConversationUI.cU().cV().getCustomView().getLocationInWindow(iArr);
                        ((FitSystemWindowLayoutView) bIb).fitSystemWindows(new Rect(0, iArr[1], 0, 0));
                        v.i("MicroMsg.BaseConversationUI", "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr[1]));
                        break;
                    }
                    v.e("MicroMsg.BaseConversationUI", "on position %d, rootLayout not found!", Integer.valueOf(i2));
                }
            }
            v.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
        }
        if (z) {
            baseConversationUI.nCd.cSL = true;
            baseConversationUI.nCd.gYg = false;
            baseConversationUI.nCd.setArguments(r.T(intent));
            baseConversationUI.aS().aW().a(baseConversationUI.nBV, baseConversationUI.nCd).commitAllowingStateLoss();
            baseConversationUI.aS().executePendingTransactions();
            baseConversationUI.nCf = (OnLayoutChangedLinearLayout) baseConversationUI.nCd.mView.findViewById(2131755468);
            baseConversationUI.nCd.jL(true);
        } else {
            baseConversationUI.nCd.cSL = true;
            baseConversationUI.nCd.gYg = false;
            baseConversationUI.nCd.oJ.putAll(r.T(intent));
            baseConversationUI.nCd.bDK();
            baseConversationUI.nCd.onResume();
            baseConversationUI.nCd.jL(true);
        }
        if (baseConversationUI.nCd.bAm()) {
            baseConversationUI.nCd.nFw.pew = false;
        }
        v.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z), intent);
    }

    static /* synthetic */ void a(BaseConversationUI baseConversationUI, boolean z) {
        if (a.ACTIVITY_RESUME == baseConversationUI.oJO) {
            baseConversationUI.c(z, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        e.N(this);
        super.onCreate(bundle);
        getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
        this.FG = cU().cV();
        bAr();
    }

    protected void onNewIntent(Intent intent) {
        v.i("MicroMsg.BaseConversationUI", "onNewIntent");
        setIntent(intent);
    }

    protected void onResume() {
        super.onResume();
        j.b(this);
        I(1.0f);
        this.oJO = a.ACTIVITY_RESUME;
        boolean z = this.nCe != null && this.nCe.isShown();
        if (z) {
            d.a(3, "ChattingUI" + this.nCd.bFo(), this.nCd.hashCode());
        } else {
            d.a(3, getLocalClassName(), hashCode());
            this.nBE = be.Nh();
        }
        if (com.tencent.mm.compatible.util.d.dW(19) && com.tencent.mm.compatible.h.a.sh()) {
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ BaseConversationUI oJQ;

                {
                    this.oJQ = r1;
                }

                public final boolean queueIdle() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oJQ.nCe == null) {
                        if (this.oJQ.nCb == null) {
                            this.oJQ.nCb = q.em(this.oJQ).inflate(2130903279, null);
                        }
                        if (this.oJQ.nCc == null) {
                            this.oJQ.nCc = q.em(this.oJQ).inflate(2130903073, null);
                        }
                    }
                    v.d("MicroMsg.BaseConversationUI", "prepare chattingUI view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            });
            if (this.nCd != null && this.nCd.bAm()) {
                this.nCd.nFw.hVC = true;
            }
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ BaseConversationUI oJQ;

                {
                    this.oJQ = r1;
                }

                public final boolean queueIdle() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oJQ.nCe == null) {
                        String xF;
                        if (this.oJQ.oJN == null || be.kS(this.oJQ.oJN.getUserName())) {
                            xF = k.xF();
                        } else {
                            xF = this.oJQ.oJN.getUserName();
                        }
                        BaseConversationUI.a(this.oJQ, new Intent().putExtra("Chat_User", xF));
                        this.oJQ.nCd.gYg = true;
                        this.oJQ.nCd.bFj();
                        this.oJQ.nCe.setVisibility(8);
                        this.oJQ.nCd.nFv = true;
                        this.oJQ.nCd.onPause();
                        this.oJQ.nCd.bFg();
                        this.oJQ.nCd.cSL = false;
                        this.oJQ.bIc();
                    }
                    this.oJQ.nCb = null;
                    this.oJQ.nCc = null;
                    v.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            });
        }
        bzI();
        this.FG.show();
    }

    protected void onPause() {
        v.i("MicroMsg.BaseConversationUI", "on pause");
        super.onPause();
        if (!isFinishing()) {
            j.a(this);
        }
        this.oJO = a.ACTIVITY_PAUSE;
        boolean z = this.nCe != null && this.nCe.isShown();
        if (z) {
            d.a(4, "ChattingUI" + this.nCd.bFo(), this.nCd.hashCode());
            d.d("ChattingUI" + this.nCd.bFo(), this.nBE, t.Nh());
        } else {
            d.a(4, getLocalClassName(), hashCode());
        }
        if (this.nCd != null && this.nCd.bAm()) {
            this.nCd.nFw.hVC = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.nCd = null;
        this.nCf = null;
        this.nCe = null;
        this.oJN = null;
        this.fnr = null;
        this.nCn = null;
        this.nCl = null;
    }

    public final void I(float f) {
        v.v("MicroMsg.BaseConversationUI", "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f), Long.valueOf(240), this.oJO);
        if (com.tencent.mm.compatible.util.d.dW(19) && com.tencent.mm.compatible.h.a.sh()) {
            if (a.ACTIVITY_RESUME != this.oJO) {
                super.I(f);
                if (Float.compare(1.0f, f) > 0) {
                    return;
                }
            }
            View findViewById = findViewById(2131755055);
            if (Float.compare(1.0f, f) <= 0) {
                com.tencent.mm.ui.tools.j.m(findViewById, 0.0f);
            } else {
                com.tencent.mm.ui.tools.j.m(findViewById, (((float) (findViewById.getWidth() / 4)) * (1.0f - f)) * -1.0f);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 1;
        super.onActivityResult(i, i2, intent);
        if (this.oJN != null) {
            this.oJN.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN && this.nCd != null) {
                this.nCd.onActivityResult(i, i2, intent);
            }
            v.w("MicroMsg.BaseConversationUI", "check request code %d", Integer.valueOf(65535 & i));
            switch (65535 & i) {
                case 217:
                case 218:
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0 && this.nCd == null) {
                v.i("MicroMsg.BaseConversationUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
                ad.B(this.oJP);
                this.oJP.nCM = 0;
                this.oJP.aZt = i;
                this.oJP.aKK = i2;
                this.oJP.aZu = intent;
                ad.o(this.oJP);
            }
        }
    }

    private void bzL() {
        boolean z = true;
        if (com.tencent.mm.compatible.util.d.dW(19) && com.tencent.mm.compatible.h.a.sh()) {
            String str = "MicroMsg.BaseConversationUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.nCd != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.i(str, str2, objArr);
            if (this.nCd != null) {
                this.nCd.nFw.paQ = false;
            }
        }
    }

    public final void a(String str, Bundle bundle, boolean z) {
        String str2 = "MicroMsg.BaseConversationUI";
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.nCe == null ? false : this.nCe.isShown());
        v.i(str2, str3, objArr);
        this.nCi = bundle;
        this.nCh = str;
        this.nCm = z;
        ak.vA().btt();
        ad.va(-8);
        ad.o(this.nCj);
    }

    private void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = cU().cV().getCustomView().getBottom();
        if (this.oJN == null || this.oJN.mView == null) {
            i2 = 0;
        } else {
            i2 = bottom - ((i + bottom2) + this.oJN.mView.getBottom());
        }
        v.i("MicroMsg.BaseConversationUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2));
        fitSystemWindowLayoutView.nCL = viewGroup;
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    private ViewGroup bIb() {
        ViewParent parent = this.FG.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            ViewParent viewParent3 = parent;
            parent = parent.getParent();
            viewParent = viewParent3;
        }
        return (ViewGroup) viewParent;
    }

    public final void bIc() {
        if (this.oJN != null) {
            this.oJN.onResume();
            if (!this.oJN.bAm()) {
                this.oJN.iU(true);
            }
        }
    }

    public final void iP(boolean z) {
        String str = "MicroMsg.BaseConversationUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.nCe == null ? false : this.nCe.isShown());
        v.i(str, str2, objArr);
        if (this.nCd != null && this.nCd.bAm()) {
            j.b(this);
        }
        if (this.nCe != null && this.nCe.getVisibility() != 8 && this.nCd != null) {
            v.i("MicroMsg.BaseConversationUI", "closeChatting");
            this.nCe.setVisibility(8);
            this.nCo = true;
            if (this.nCl == null) {
                this.nCl = AnimationUtils.loadAnimation(this, com.tencent.mm.ui.MMFragmentActivity.a.nFH);
                this.nCl.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ BaseConversationUI oJQ;

                    {
                        this.oJQ = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        ak.vA().btt();
                        ad.va(-8);
                        v.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
                        BaseConversationUI.a(this.oJQ, true);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        ak.vA().btw();
                        ad.va(0);
                        this.oJQ.bzL();
                        v.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
                    }
                });
            }
            this.nCd.onPause();
            this.nCd.bFg();
            this.nCd.cSL = false;
            if (z) {
                this.nCe.startAnimation(this.nCl);
            } else {
                I(1.0f);
                bzL();
            }
            if (!this.nCd.bAm()) {
                bzI();
            }
            aR();
            bIc();
            d.a(4, "ChattingUI" + this.nCd.bFo(), this.nCd.hashCode());
            d.d("ChattingUI" + this.nCd.bFo(), this.nBE, t.Nh());
            d.a(3, getLocalClassName(), hashCode());
        }
    }

    private void bzI() {
        if (this.nCd == null || !this.nCd.cSL) {
            View inflate = q.em(this).inflate(2130903073, null);
            this.fnr = new com.tencent.mm.ui.b(inflate);
            this.FG.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.FG.cQ();
            this.FG.setDisplayHomeAsUpEnabled(false);
            this.FG.cP();
            this.FG.cR();
            this.FG.setCustomView(inflate);
            adg();
            this.fnr.i(new OnClickListener(this) {
                final /* synthetic */ BaseConversationUI oJQ;

                {
                    this.oJQ = r1;
                }

                public final void onClick(View view) {
                    this.oJQ.finish();
                }
            });
        }
    }

    public final void adg() {
        if (this.fnr != null) {
            this.fnr.setTitle(l.er(this.title));
        }
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        if (this.nCd == null || this.nCd.ouT == null || !this.nCd.bAm()) {
            return super.onWindowStartingActionMode(callback);
        }
        if (com.tencent.mm.compatible.util.d.dY(22)) {
            return super.onWindowStartingActionMode(callback);
        }
        ActionMode startActionMode = this.nCd.ouT.startActionMode(callback);
        if (startActionMode == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return startActionMode;
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.nBT = bundle.getString("last_restore_talker");
        v.d("MicroMsg.BaseConversationUI", "onRestoreInstantceState:%s", this.nBT);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.nCd != null && !be.kS(this.nCd.bEn())) {
            v.d("MicroMsg.BaseConversationUI", "onSaveInstanceState:%s", this.nCd.bEn());
            bundle.putString("last_restore_talker", this.nCd.bEn());
        }
    }

    public final void c(boolean z, int i) {
        long j = 120;
        v.v("MicroMsg.BaseConversationUI", "ashutest: on settle %B, speed %d, status %s", Boolean.valueOf(z), Integer.valueOf(i), this.oJO);
        if (!com.tencent.mm.compatible.util.d.dW(19) || !com.tencent.mm.compatible.h.a.sh()) {
            return;
        }
        if (a.ACTIVITY_RESUME != this.oJO) {
            super.c(z, i);
            return;
        }
        View findViewById = findViewById(2131755055);
        if (z) {
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(findViewById, j, 0.0f, 0.125f);
            return;
        }
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), 0.75f);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Object[] objArr;
        int i = 1;
        v.i("MicroMsg.BaseConversationUI", "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ad.B(this.nCj);
        }
        if (this.nCd == null || !this.nCd.cSL || this.nCd.ovA) {
            if (keyEvent.getKeyCode() == 4) {
                if (keyEvent.getAction() == 0) {
                    this.ovz = i;
                    this.ovB = System.currentTimeMillis();
                }
                if (keyEvent.getAction() != i) {
                    return i;
                }
                v.d("MicroMsg.BaseConversationUI", "hasBack %B, %d", Boolean.valueOf(this.ovz), Long.valueOf(System.currentTimeMillis() - this.ovB));
                if (!this.ovz || System.currentTimeMillis() - this.ovB > 30000) {
                    return i;
                }
                finish();
                return i;
            }
            try {
                return super.dispatchKeyEvent(keyEvent);
            } catch (Throwable e) {
                objArr = new Object[i];
                objArr[0] = e.getMessage();
                v.w("MicroMsg.BaseConversationUI", "dispatch key event catch exception %s", objArr);
                v.a("MicroMsg.BaseConversationUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return 0;
            }
        } else if (this.nCd.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return i;
        } else {
            try {
                return super.dispatchKeyEvent(keyEvent);
            } catch (Throwable e2) {
                objArr = new Object[i];
                objArr[0] = e2.getMessage();
                v.w("MicroMsg.BaseConversationUI", "dispatch key event catch exception %s", objArr);
                v.a("MicroMsg.BaseConversationUI", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                return 0;
            }
        }
    }

    protected com.tencent.mm.ui.chatting.ChattingUI.a bHZ() {
        return com.tencent.mm.ui.chatting.ChattingUI.a.bEW();
    }
}
