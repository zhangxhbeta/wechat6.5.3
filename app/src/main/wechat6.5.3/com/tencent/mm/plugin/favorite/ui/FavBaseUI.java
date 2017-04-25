package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.ab;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.c;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public abstract class FavBaseUI extends MMActivity implements OnItemClickListener {
    protected ac cnC = new ac(Looper.getMainLooper());
    protected g fJV;
    private boolean fMQ = false;
    protected boolean fMR = false;
    private boolean fMS = false;
    private long fMT = 0;
    protected ListView fMU;
    protected TextView fMV;
    private HandlerThread fMW;
    protected ac fMX;
    protected View fMY;
    private View fMZ;
    protected c fNa;
    protected a fNb = null;
    private e fNc = new e(this) {
        final /* synthetic */ FavBaseUI fNi;

        {
            this.fNi = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
            if (((ab) kVar).fLV) {
                v.i("MicroMsg.FavoriteBaseUI", "need batch get return");
                return;
            }
            v.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
            if (this.fNi.fMS) {
                this.fNi.fMS = false;
            }
            this.fNi.cX(false);
            this.fNi.amv();
        }
    };
    private e fNd = new e(this) {
        final /* synthetic */ FavBaseUI fNi;

        {
            this.fNi = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FavoriteBaseUI", "on batch get end");
            if (this.fNi.fMS) {
                v.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
                this.fNi.fMS = false;
                this.fNi.cX(false);
            }
        }
    };
    private Runnable fNe = new Runnable(this) {
        final /* synthetic */ FavBaseUI fNi;

        {
            this.fNi = r1;
        }

        public final void run() {
            com.tencent.mm.plugin.favorite.ui.a.a amr = this.fNi.amr();
            amr.amN();
            amr.amO();
            this.fNi.amv();
        }
    };
    protected Runnable fNf = new Runnable(this) {
        final /* synthetic */ FavBaseUI fNi;

        {
            this.fNi = r1;
        }

        public final void run() {
            com.tencent.mm.plugin.favorite.ui.a.a amr = this.fNi.amr();
            if (amr.isEmpty() || SystemClock.elapsedRealtime() - this.fNi.fMT >= 1000) {
                this.fNi.fMQ = false;
                this.fNi.fMT = SystemClock.elapsedRealtime();
                v.v("MicroMsg.FavoriteBaseUI", "do refresh job");
                amr.notifyDataSetChanged();
                this.fNi.a(amr);
                if (this.fNi.fMR) {
                    v.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                    this.fNi.fMU.setSelection(0);
                    this.fNi.fMR = false;
                    return;
                }
                return;
            }
            v.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(this.fNi.fMT), Integer.valueOf(BaseReportManager.MAX_READ_COUNT)});
            this.fNi.cnC.postDelayed(this, 500);
        }
    };
    private Runnable fNg = new Runnable(this) {
        final /* synthetic */ FavBaseUI fNi;

        {
            this.fNi = r1;
        }

        public final void run() {
            this.fNi.ams();
            this.fNi.amr().amO();
            this.fNi.amv();
        }
    };
    private com.tencent.mm.sdk.h.g.a fNh = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ FavBaseUI fNi;
        long fNj = 0;
        long fNk = 1000;
        long fNl = 0;
        int fNm = 0;

        {
            this.fNi = r5;
        }

        public final void a(String str, i iVar) {
            if (be.az(this.fNl) < 1000) {
                this.fNm++;
            } else {
                this.fNm = 0;
                this.fNk = 1000;
            }
            v.d("MicroMsg.FavoriteBaseUI", "on fav item info storage changed, postDelay %d", new Object[]{Long.valueOf(this.fNk)});
            this.fNl = be.Nj();
            if (5 < this.fNm) {
                this.fNm = 0;
                this.fNk += 1000;
                this.fNk = Math.min(this.fNk, 5000);
            }
            this.fNi.fMX.removeCallbacks(this.fNi.fNg);
            if (be.az(this.fNj) > this.fNk) {
                this.fNj = be.Nj();
                this.fNi.fMX.post(this.fNi.fNg);
                return;
            }
            this.fNi.fMX.postDelayed(this.fNi.fNg, this.fNk);
        }
    };

    public abstract com.tencent.mm.plugin.favorite.ui.a.a amr();

    protected abstract void ams();

    protected abstract boolean amt();

    protected abstract void amu();

    static /* synthetic */ boolean a(FavBaseUI favBaseUI) {
        if (favBaseUI.fMU.getChildAt(favBaseUI.fMU.getChildCount() - 1) == null || favBaseUI.fMU.getLastVisiblePosition() != favBaseUI.fMU.getAdapter().getCount() - 1) {
            return false;
        }
        v.i("MicroMsg.FavoriteBaseUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ boolean b(FavBaseUI favBaseUI) {
        v.v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!h.alu().k(favBaseUI.amr().amL(), favBaseUI.amr().getType())) {
            if (com.tencent.mm.plugin.favorite.b.v.alT()) {
                v.w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.fMQ) {
                v.w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.fMQ = true;
                v.i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.fMX.removeCallbacks(favBaseUI.fNe);
                favBaseUI.fMX.post(favBaseUI.fNe);
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return 2130903622;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        ak.vy().a(new com.tencent.mm.plugin.favorite.b.ac(), 0);
        h.alu().c(this.fNh);
        ak.vy().a(400, this.fNc);
        ak.vy().a(402, this.fNd);
        this.fMW = com.tencent.mm.sdk.i.e.Lg(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.fMW.start();
        this.fMX = new ac(this.fMW.getLooper());
        this.fJV = new g(this.nDR.nEl, 64);
        NI();
        ak.yW();
        if (be.f((Integer) com.tencent.mm.model.c.vf().get(8217, null)) == 0) {
            v.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
            this.fMS = true;
            ak.vy().a(new ab(), 0);
            if (this.fMS) {
                v.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                if (amr() == null || amr().isEmpty()) {
                    cX(true);
                }
                cY(false);
            }
        } else {
            com.tencent.mm.plugin.favorite.b.v.startSync();
            if (amr().isEmpty()) {
                cX(true);
                cY(false);
                this.fMY.setVisibility(8);
            } else {
                cX(false);
                cY(false);
            }
        }
        h.alo().run();
        h.all().run();
        h.alk().run();
        h.alm().run();
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ FavBaseUI fNi;

            {
                this.fNi = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.favorite.b.v.alU();
            }
        });
        v.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected void onResume() {
        super.onResume();
        f.ux(5);
    }

    protected void onPause() {
        super.onPause();
        amr();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fJV.destory();
        this.fJV = null;
        this.fMW.quit();
        h.alu().d(this.fNh);
        ak.vy().b(400, this.fNc);
        ak.vy().b(402, this.fNd);
    }

    protected final void NI() {
        long currentTimeMillis = System.currentTimeMillis();
        this.fMU = (ListView) findViewById(2131756996);
        this.fMU.setDrawingCacheEnabled(false);
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ FavBaseUI fNi;

            {
                this.fNi = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.fNi.fMU);
            }
        };
        initHeaderView();
        this.fMY = q.em(this).inflate(2130903610, null);
        this.fMU.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ FavBaseUI fNi;

            {
                this.fNi = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    return;
                }
                if (h.alu().k(this.fNi.amr().amL(), this.fNi.amr().getType())) {
                    v.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
                } else if (FavBaseUI.a(this.fNi)) {
                    v.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
                    FavBaseUI.b(this.fNi);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fMU.setOnItemClickListener(this);
        this.fMU.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavBaseUI fNi;

            {
                this.fNi = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.fNi.axg();
                return false;
            }
        });
        this.fMU.setAdapter(amr());
        a(amr());
        v.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected final void cX(boolean z) {
        if (z) {
            if (this.fMZ == null) {
                this.fMZ = ((ViewStub) findViewById(2131756927)).inflate();
            }
            this.fMZ.setVisibility(0);
        } else if (this.fMZ != null) {
            this.fMZ.setVisibility(8);
        }
    }

    private void cY(boolean z) {
        if (z) {
            if (this.fMV == null) {
                this.fMV = (TextView) ((ViewStub) findViewById(2131756997)).inflate().findViewById(2131756757);
            }
            this.fMV.setVisibility(0);
        } else if (this.fMV != null) {
            this.fMV.setVisibility(8);
        }
    }

    protected void initHeaderView() {
        this.fNa = new c(this.nDR.nEl);
        this.fNa.fPT = this.fNb;
        this.fNa.da(false);
        this.fNa.fPR.setVisibility(8);
        this.fNa.fPS.setVisibility(8);
        v.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[]{Integer.valueOf(this.fNa.getPaddingTop()), Integer.valueOf(this.fNa.getPaddingBottom())});
        this.fMU.addHeaderView(this.fNa);
    }

    protected void amv() {
        v.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.cnC.removeCallbacks(this.fNf);
        this.cnC.post(this.fNf);
    }

    protected final void a(com.tencent.mm.plugin.favorite.ui.a.a aVar) {
        if (aVar == null) {
            v.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!aVar.isEmpty()) {
            cX(false);
            cY(false);
        } else if (amt()) {
            cX(true);
            cY(false);
        } else {
            cX(false);
            cY(true);
            amu();
        }
        if (aVar.isEmpty() || h.alu().k(aVar.amL(), aVar.getType())) {
            this.fMU.removeFooterView(this.fMY);
        } else if (this.fMU.getFooterViewsCount() == 0) {
            this.fMU.addFooterView(this.fMY);
        }
    }
}
