package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.ab;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.base.a;
import com.tencent.mm.plugin.favorite.ui.c.a.c;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavCleanUI extends MMActivity implements c {
    protected ac cnC = new ac(Looper.getMainLooper());
    private boolean fMQ = false;
    protected boolean fMR = false;
    private long fMT = 0;
    private HandlerThread fMW;
    protected ac fMX;
    protected View fMY;
    private View fMZ;
    private e fNc = new e(this) {
        final /* synthetic */ FavCleanUI fNt;

        {
            this.fNt = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FavCleanUI", "on fav sync end");
            if (((ab) kVar).fLV) {
                v.i("MicroMsg.FavCleanUI", "need batch get return");
                return;
            }
            v.i("MicroMsg.FavCleanUI", "dismiss loading dialog");
            if (this.fNt.fNr) {
                this.fNt.amy();
                this.fNt.fNr = false;
            }
            this.fNt.amz();
            this.fNt.amx();
            this.fNt.amw();
            this.fNt.b(this.fNt.fNo);
        }
    };
    private e fNd = new e(this) {
        final /* synthetic */ FavCleanUI fNt;

        {
            this.fNt = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FavCleanUI", "on batch get end");
        }
    };
    private Runnable fNe = new Runnable(this) {
        final /* synthetic */ FavCleanUI fNt;

        {
            this.fNt = r1;
        }

        public final void run() {
            if (this.fNt.fNo != null) {
                this.fNt.fNo.amN();
            }
            this.fNt.amv();
        }
    };
    protected Runnable fNf = new Runnable(this) {
        final /* synthetic */ FavCleanUI fNt;

        {
            this.fNt = r1;
        }

        public final void run() {
            if (this.fNt.fNo != null) {
                if (this.fNt.fNo.isEmpty() || SystemClock.elapsedRealtime() - this.fNt.fMT >= 1000) {
                    this.fNt.fMQ = false;
                    this.fNt.fMT = SystemClock.elapsedRealtime();
                    v.v("MicroMsg.FavCleanUI", "do refresh job");
                    this.fNt.fNo.notifyDataSetChanged();
                    this.fNt.b(this.fNt.fNo);
                    if (this.fNt.fMR) {
                        v.v("MicroMsg.FavCleanUI", "do scroll to first");
                        this.fNt.fNp.setSelection(0);
                        this.fNt.fMR = false;
                        return;
                    }
                    return;
                }
                v.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(this.fNt.fMT), Integer.valueOf(BaseReportManager.MAX_READ_COUNT)});
                this.fNt.cnC.postDelayed(this, 500);
            }
        }
    };
    private g fNn;
    private b fNo;
    private ListView fNp;
    private a fNq;
    private boolean fNr = false;
    private e fNs = new e(this) {
        final /* synthetic */ FavCleanUI fNt;

        {
            this.fNt = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
            if (this.fNt.fNq != null) {
                this.fNt.fNq.fPI = com.tencent.mm.plugin.favorite.b.v.alW();
            }
        }
    };

    static /* synthetic */ boolean a(FavCleanUI favCleanUI) {
        if (favCleanUI.fNp.getChildAt(favCleanUI.fNp.getChildCount() - 1) == null || favCleanUI.fNp.getLastVisiblePosition() != favCleanUI.fNp.getAdapter().getCount() - 1) {
            return false;
        }
        v.i("MicroMsg.FavCleanUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ void b(FavCleanUI favCleanUI) {
        v.v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.fNo.fPx) {
            v.i("MicroMsg.FavCleanUI", "has shown all, do not load data");
        } else if (com.tencent.mm.plugin.favorite.b.v.alT()) {
            v.w("MicroMsg.FavCleanUI", "doing batchget, do not load data");
        } else if (favCleanUI.fMQ) {
            v.w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
        } else {
            favCleanUI.fMQ = true;
            v.i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.fMX.removeCallbacks(favCleanUI.fNe);
            favCleanUI.fMX.post(favCleanUI.fNe);
        }
    }

    protected final int getLayoutId() {
        return 2130903591;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fMW = com.tencent.mm.sdk.i.e.Lg(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.fMW.start();
        this.fMX = new ac(this.fMW.getLooper());
        this.fNp = (ListView) findViewById(2131756926);
        vD(2131232636);
        this.fNr = true;
        ak.vy().a(new com.tencent.mm.plugin.favorite.b.ac(), 0);
        ak.vy().a(402, this.fNd);
        ak.vy().a(438, this.fNs);
        cX(true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavCleanUI fNt;

            {
                this.fNt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fNt.finish();
                return true;
            }
        });
        this.fMY = q.em(this).inflate(2130903610, null);
        this.fNp.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ FavCleanUI fNt;

            {
                this.fNt = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && FavCleanUI.a(this.fNt)) {
                    v.i("MicroMsg.FavCleanUI", "force bottom load data");
                    FavCleanUI.b(this.fNt);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.fNr) {
            amy();
            this.fNr = false;
        }
        amz();
        amx();
        amw();
        b(this.fNo);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fNn != null) {
            this.fNn.destory();
            this.fNn = null;
        }
        if (this.fNo != null) {
            this.fNo.finish();
        }
        this.fMW.quit();
        ak.vy().b(402, this.fNd);
        ak.vy().b(438, this.fNs);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        v.d("MicroMsg.FavCleanUI", "on create options menu");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    private void amw() {
        this.fNo.notifyDataSetChanged();
        if (this.fNo.isEmpty()) {
            cX(true);
            if (8 != this.fNp.getVisibility()) {
                this.fNp.setVisibility(8);
                return;
            }
            return;
        }
        cX(false);
        if (this.fNp.getVisibility() != 0) {
            this.fNp.setVisibility(0);
        }
    }

    private void amx() {
        this.fNn = new g(aa.getContext(), 16);
        this.fNo = new b(this.fNn, true);
        this.fNo.fPv = this;
        this.fNp.setAdapter(this.fNo);
        this.fNp.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FavCleanUI fNt;

            {
                this.fNt = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.fNt.fNo != null) {
                    this.fNt.fNo.onItemClick(adapterView, view, i, j);
                }
            }
        });
        this.fNp.setOnTouchListener(null);
    }

    protected final void amy() {
        this.fNq = new a();
        a aVar = this.fNq;
        View findViewById = findViewById(2131756923);
        aVar.fPG = false;
        aVar.fPH = findViewById;
        this.fNq.fPJ = new a.a(this) {
            final /* synthetic */ FavCleanUI fNt;

            {
                this.fNt = r1;
            }

            public final void amA() {
                com.tencent.mm.ui.base.g.a(this.fNt.nDR.nEl, this.fNt.getString(2131232633), "", new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 fNu;

                    {
                        this.fNu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        long amR = this.fNu.fNt.fNo.amR();
                        final List cZ = this.fNu.fNt.fNo.cZ(true);
                        a d = this.fNu.fNt.fNq;
                        d.fPI += amR;
                        com.tencent.mm.plugin.favorite.b.v.bI(com.tencent.mm.plugin.favorite.b.v.alY() - amR);
                        if (!cZ.isEmpty()) {
                            final p a = com.tencent.mm.ui.base.g.a(this.fNu.fNt.nDR.nEl, this.fNu.fNt.getString(2131232642), false, null);
                            ak.vA().x(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 fNx;

                                public final void run() {
                                    com.tencent.mm.plugin.favorite.b.v.as(cZ);
                                    ad.o(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 fNy;

                                        {
                                            this.fNy = r1;
                                        }

                                        public final void run() {
                                            b c = this.fNy.fNx.fNu.fNt.fNo;
                                            List<i> list = cZ;
                                            if (c.fPl != null) {
                                                List arrayList = new ArrayList();
                                                for (i iVar : c.fPl) {
                                                    if (iVar != null) {
                                                        Object obj;
                                                        for (i iVar2 : list) {
                                                            if (iVar2 != null && iVar.field_localId == iVar2.field_localId) {
                                                                obj = 1;
                                                                break;
                                                            }
                                                        }
                                                        obj = null;
                                                        if (obj == null) {
                                                            arrayList.add(iVar);
                                                        }
                                                    }
                                                }
                                                c.fPl = arrayList;
                                            }
                                            this.fNy.fNx.fNu.fNt.fNo.notifyDataSetChanged();
                                            this.fNy.fNx.fNu.fNt.fNq.amS();
                                            a.dismiss();
                                        }

                                        public final String toString() {
                                            return super.toString() + "|batchDelFavItems";
                                        }
                                    });
                                }
                            });
                            com.tencent.mm.plugin.report.service.g.iuh.h(11125, new Object[]{Integer.valueOf(cZ.size()), Integer.valueOf(3)});
                        }
                    }
                }, null);
            }
        };
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void amz() {
        this.fNp.setOnItemLongClickListener(null);
        this.fNq.show();
    }

    protected final void amv() {
        v.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.cnC.removeCallbacks(this.fNf);
        this.cnC.post(this.fNf);
    }

    protected final void b(com.tencent.mm.plugin.favorite.ui.a.a aVar) {
        if (aVar == null) {
            v.w("MicroMsg.FavCleanUI", "handle empty view fail, adapter is null");
            return;
        }
        if (aVar.isEmpty()) {
            cX(true);
        } else {
            cX(false);
            if (this.fNp.getVisibility() != 0) {
                this.fNp.setVisibility(0);
            }
        }
        if (this.fNo.fPx) {
            this.fNp.removeFooterView(this.fMY);
        } else if (this.fNp.getFooterViewsCount() == 0) {
            this.fNp.addFooterView(this.fMY);
        }
    }

    private void cX(boolean z) {
        if (z) {
            if (this.fMZ == null) {
                this.fMZ = ((ViewStub) findViewById(2131756927)).inflate();
            }
            this.fMZ.setVisibility(0);
            this.fNp.removeFooterView(this.fMY);
            if (this.fNq != null) {
                a aVar = this.fNq;
                if (aVar.fPG && aVar.fPH.getVisibility() != 8) {
                    aVar.fPH.setVisibility(8);
                    aVar.fPH.startAnimation(AnimationUtils.loadAnimation(aVar.fPH.getContext(), 2130968623));
                    return;
                }
                return;
            }
            return;
        }
        if (this.fMZ != null) {
            this.fMZ.setVisibility(8);
        }
        if (this.fNp.getFooterViewsCount() == 0) {
            this.fNp.addFooterView(this.fMY);
        }
        if (this.fNq != null) {
            this.fNq.show();
        }
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public final void bO(long j) {
        i bB = h.alu().bB(j);
        if (!(bB == null || bB.field_favProto == null || bB.field_favProto.mtR.size() == 0)) {
            Iterator it = bB.field_favProto.mtR.iterator();
            while (it.hasNext()) {
                long j2 = ((pw) it.next()).msn;
            }
        }
        if (this.fNo.fPw) {
            boolean z;
            a aVar = this.fNq;
            if (this.fNo.amQ() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.fPG) {
                aVar.eVF.setEnabled(z);
            }
            a aVar2 = this.fNq;
            List cZ = this.fNo.cZ(false);
            j2 = this.fNo.amR();
            if (cZ.size() == 0 || j2 <= 0) {
                aVar2.amS();
                return;
            }
            aVar2.eVL.setText(aVar2.eVL.getContext().getString(2131232632, new Object[]{com.tencent.mm.plugin.favorite.c.bx(j2)}));
            aVar2.eVF.setEnabled(true);
        }
    }
}
