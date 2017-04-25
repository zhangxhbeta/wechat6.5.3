package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsearch.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.p;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI extends MMActivity implements OnItemClickListener, a, b, c, VerticalScrollBar.a, l, p.b {
    public p eSv;
    public MultiSelectContactView hkH;
    private View iWo;
    public ListView ieb;
    private AlphabetScrollBar oHb;
    n oHc;
    public p oHd;
    private o oHe;
    private View oHf;
    private View oHg;
    private TextView oHh;
    private LabelContainerView oHi;
    private TextView oHj;
    private MMTagPanel oHk;
    private boolean oHl = true;
    private List<String> oHm = new ArrayList();
    public int scene;

    public abstract boolean NJ();

    public abstract String NK();

    public abstract n NL();

    public abstract p NM();

    static /* synthetic */ void b(MMBaseSelectContactUI mMBaseSelectContactUI) {
        mMBaseSelectContactUI.bHL();
        mMBaseSelectContactUI.oHg.setVisibility(0);
        if (!be.kS(mMBaseSelectContactUI.bHI()) && mMBaseSelectContactUI.oHh != null) {
            mMBaseSelectContactUI.oHh.setText(h.m(mMBaseSelectContactUI.getString(2131234830), mMBaseSelectContactUI.getString(2131234829), mMBaseSelectContactUI.bHI()));
        }
    }

    static /* synthetic */ void c(MMBaseSelectContactUI mMBaseSelectContactUI) {
        v.i("MicroMsg.MMBaseSelectContactUI", "setSearchStatus");
        mMBaseSelectContactUI.a(mMBaseSelectContactUI.ieb, 8);
        mMBaseSelectContactUI.ieb.setAdapter(mMBaseSelectContactUI.oHd);
        mMBaseSelectContactUI.oHd.notifyDataSetChanged();
        if (mMBaseSelectContactUI.NJ() && mMBaseSelectContactUI.oHb != null) {
            mMBaseSelectContactUI.oHb.setVisibility(8);
        }
        mMBaseSelectContactUI.oHg.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
        if (ak.uz()) {
            NH();
            NI();
            return;
        }
        v.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
        v.btb();
        finish();
    }

    public final m bHH() {
        if (this.ieb.getHeaderViewsCount() > 0) {
            return (m) ((HeaderViewListAdapter) this.ieb.getAdapter()).getWrappedAdapter();
        }
        return (m) this.ieb.getAdapter();
    }

    public final ListView aQr() {
        return this.ieb;
    }

    public void NH() {
        this.scene = getIntent().getIntExtra("scene", 0);
    }

    public void NI() {
        Fd(NK());
        this.ieb = (ListView) findViewById(2131755207);
        this.oHc = NL();
        this.oHd = NM();
        this.iWo = findViewById(2131755209);
        if (this.oHd != null) {
            this.oHg = findViewById(2131755213);
            this.oHh = (TextView) findViewById(2131755214);
            this.oHg.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ MMBaseSelectContactUI oHn;

                {
                    this.oHn = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.oHn.bHL();
                    this.oHn.bHM();
                    this.oHn.bHN();
                    return false;
                }
            });
            this.hkH = (MultiSelectContactView) findViewById(2131755208);
            this.hkH.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            this.hkH.lHj = this;
            this.hkH.lHk = this;
            this.hkH.lHi = this;
            this.hkH.setVisibility(0);
            this.oHf = new View(this.nDR.nEl);
            this.oHf.setLayoutParams(new LayoutParams(-1, this.hkH.getMeasuredHeight()));
            this.oHf.setVisibility(4);
            this.ieb.addHeaderView(this.oHf);
            findViewById(2131755206).setVisibility(0);
        }
        a(this.ieb, 0);
        this.ieb.setAdapter(this.oHc);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MMBaseSelectContactUI oHn;

            {
                this.oHn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oHn.ayE();
                return true;
            }
        });
        if (this.oHd != null) {
            this.oHd.a(new p.a(this) {
                final /* synthetic */ MMBaseSelectContactUI oHn;

                {
                    this.oHn = r1;
                }

                public final void n(String str, int i, boolean z) {
                    v.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", Integer.valueOf(i));
                    if (!z || i != 0) {
                        MMBaseSelectContactUI.c(this.oHn);
                    } else if (be.kS(str)) {
                        this.oHn.bHL();
                    } else {
                        MMBaseSelectContactUI.b(this.oHn);
                    }
                }
            });
        }
        this.ieb.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MMBaseSelectContactUI oHn;

            {
                this.oHn = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    this.oHn.axg();
                    this.oHn.bHN();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (this.oHn.hkH != null) {
                    View childAt = this.oHn.ieb.getChildAt(this.oHn.ieb.getFirstVisiblePosition());
                    if (childAt == null || childAt.getTop() != 0) {
                        this.oHn.iWo.setVisibility(0);
                    } else {
                        this.oHn.iWo.setVisibility(8);
                    }
                }
                if (i >= 2) {
                    ak.yW();
                    if (!be.c((Boolean) com.tencent.mm.model.c.vf().get(12296, null))) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(12296, Boolean.valueOf(true));
                        if (this.oHn.oHe != null) {
                            this.oHn.oHe.dismiss();
                        }
                        this.oHn.oHe = s.a(this.oHn, this.oHn.getString(2131233726), 4000);
                    }
                }
            }
        });
        this.ieb.setOnItemClickListener(this);
        if (NJ()) {
            this.oHb = (AlphabetScrollBar) findViewById(2131755210);
            this.oHb.setVisibility(0);
            this.oHb.obP = this;
        }
        if (azF()) {
            this.oHi = (LabelContainerView) findViewById(2131755211);
            this.oHj = (TextView) this.oHi.findViewById(16908310);
            this.oHj.setText(2131233467);
            this.oHk = (MMTagPanel) this.oHi.findViewById(2131755212);
            this.oHk.gMg = 2130839272;
            this.oHk.gMh = 2131689909;
            this.oHi.oGY = new LabelContainerView.a(this) {
                final /* synthetic */ MMBaseSelectContactUI oHn;

                {
                    this.oHn = r1;
                }

                public final void aig() {
                    if (this.oHn.hkH != null) {
                        this.oHn.hkH.clearFocus();
                    }
                    if (this.oHn.eSv != null) {
                        this.oHn.eSv.clearFocus();
                        this.oHn.eSv.bJs();
                    }
                    this.oHn.oHi.requestFocus();
                    this.oHn.oHi.setVisibility(8);
                }

                public final void aih() {
                    this.oHn.axg();
                }
            };
            this.oHk.nYp = new MMTagPanel.a(this) {
                final /* synthetic */ MMBaseSelectContactUI oHn;

                {
                    this.oHn = r1;
                }

                public final void rS(String str) {
                }

                public final void rT(String str) {
                    this.oHn.wt(str);
                }

                public final void rU(String str) {
                }

                public final void f(boolean z, int i) {
                }

                public final void aii() {
                }

                public final void rV(String str) {
                }

                public final void rW(String str) {
                }
            };
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.ieb.getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            t.a xS = bHH().xS(headerViewsCount);
            xS.NE().NG();
            if (xS.bHV()) {
                int f = j.f(xS.bHS(), xS.bHT(), xS.aMM());
                headerViewsCount = 0;
                switch (xS.bHS()) {
                    case 65536:
                        headerViewsCount = 5;
                        break;
                    case 131072:
                        headerViewsCount = 2;
                        break;
                    case 131075:
                        headerViewsCount = 3;
                        break;
                    case 131076:
                        headerViewsCount = 4;
                        break;
                }
                if (xS.bHU()) {
                    headerViewsCount = 1;
                }
                v.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{xS.getQuery(), Integer.valueOf(xS.bwF()), Integer.valueOf(headerViewsCount), Integer.valueOf(xS.bHR()), Integer.valueOf(f)}));
                g.iuh.Y(13234, r0);
            }
        }
        if (!bHH().xT(i)) {
            gJ(i);
        }
    }

    public void gJ(int i) {
    }

    private String bHI() {
        if (this.eSv != null) {
            return this.eSv.boJ();
        }
        if (this.hkH != null) {
            return this.hkH.boJ();
        }
        return SQLiteDatabase.KeyEmpty;
    }

    private void bHJ() {
        boolean bIT = this.eSv != null ? this.eSv.bIT() : this.hkH != null ? this.hkH.hasFocus() : false;
        if (bIT && be.kS(bHI())) {
            if (this.oHm == null || this.oHm.size() <= 0) {
                this.oHi.setVisibility(8);
                return;
            }
            this.oHi.setVisibility(0);
            this.oHk.a(null, this.oHm);
        } else if (this.oHi != null) {
            this.oHi.setVisibility(8);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.oHe != null) {
            this.oHe.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        if (azF() && this.oHl) {
            this.oHl = false;
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ MMBaseSelectContactUI oHn;

                {
                    this.oHn = r1;
                }

                public final void run() {
                    this.oHn.oHm = com.tencent.mm.pluginsdk.j.a.bmu().avG();
                    this.oHn.oHl = true;
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 oHo;

                        {
                            this.oHo = r1;
                        }

                        public final void run() {
                            this.oHo.oHn.bHJ();
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|updateLabelList";
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.oHb != null) {
            this.oHb.obP = null;
        }
        if (this.oHc != null) {
            this.oHc.finish();
        }
        if (this.oHd != null) {
            this.oHd.finish();
        }
        if (this.oHe != null) {
            this.oHe.dismiss();
        }
    }

    public int getLayoutId() {
        return 2130904074;
    }

    public final void Ht(String str) {
        v.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", str);
        if (azF()) {
            bHJ();
        }
        if (be.kS(str)) {
            this.oHd.NH();
            this.oHd.notifyDataSetChanged();
            bHL();
            return;
        }
        this.oHd.a(str, ayD(), bHK());
    }

    public final void boK() {
        if (azF()) {
            bHJ();
        }
    }

    public int[] ayD() {
        return new int[]{131072, 131075};
    }

    public void a(ListView listView, int i) {
    }

    public void ayE() {
        axg();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            ayE();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void pC(String str) {
        if (this.oHc != null) {
            int Pd = this.oHc.Pd(str);
            if (Pd == 0) {
                this.ieb.setSelection(0);
            } else if (Pd <= 0) {
                v.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", Integer.valueOf(Pd), str);
            } else if (this.hkH != null) {
                this.ieb.setSelectionFromTop(Pd, this.hkH.getMeasuredHeight());
            }
        }
    }

    public final boolean mk(String str) {
        return false;
    }

    public final void ml(String str) {
        v.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", str);
        if (azF()) {
            if (this.eSv != null) {
                this.eSv.bIU();
            }
            bHJ();
        }
        if (be.kS(str)) {
            this.oHd.NH();
            this.oHd.notifyDataSetChanged();
            bHL();
            return;
        }
        this.oHd.a(str, ayD(), bHK());
    }

    public boolean bHK() {
        return false;
    }

    public final void Of() {
        bHL();
        if (azF()) {
            bHJ();
        }
    }

    public final void Og() {
    }

    private void bHL() {
        v.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
        a(this.ieb, 0);
        this.ieb.setAdapter(this.oHc);
        this.oHc.notifyDataSetChanged();
        if (NJ() && this.oHb != null) {
            this.oHb.setVisibility(0);
        }
        this.oHg.setVisibility(8);
    }

    public void mf(String str) {
    }

    public boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public final Activity getActivity() {
        return this;
    }

    public boolean azF() {
        return false;
    }

    public void wt(String str) {
        v.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", str);
    }

    public final void bHM() {
        if (this.eSv != null) {
            if (!be.kS(this.eSv.boJ())) {
                p pVar = this.eSv;
                if (pVar.oUr != null) {
                    pVar.oUr.kg(true);
                }
            }
        } else if (this.hkH != null && !be.kS(this.hkH.boJ())) {
            this.hkH.lHd.setText(SQLiteDatabase.KeyEmpty);
        }
    }

    public final void bHN() {
        if (this.eSv != null) {
            if (this.eSv.bIT()) {
                this.eSv.clearFocus();
            }
        } else if (this.hkH != null && this.hkH.hasFocus()) {
            this.hkH.clearFocus();
        }
    }

    public final void Oh() {
    }
}
