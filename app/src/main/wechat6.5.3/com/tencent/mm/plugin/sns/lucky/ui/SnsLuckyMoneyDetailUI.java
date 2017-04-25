package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.azr;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private String ftu;
    private ListView hdV;
    private List<avx> hen = new LinkedList();
    private String heq = "";
    private boolean her = false;
    OnScrollListener hes = new OnScrollListener(this) {
        private boolean het = false;
        private boolean heu;
        final /* synthetic */ SnsLuckyMoneyDetailUI jgt;

        {
            this.jgt = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        this.het = false;
                        return;
                    case 1:
                        this.het = true;
                        return;
                    default:
                        return;
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 0 && this.het) {
                if (i <= 0) {
                    int top;
                    View childAt = absListView.getChildAt(i);
                    if (childAt != null) {
                        top = 0 - childAt.getTop();
                    } else {
                        top = 0;
                    }
                    if (top <= 100) {
                        z = false;
                    }
                }
                if (this.heu != z) {
                    if (z) {
                        this.jgt.q(this.jgt.getResources().getDrawable(2131690032));
                    } else {
                        this.jgt.q(null);
                    }
                    this.heu = z;
                }
            }
        }
    };
    private final int hfg = 750;
    private final int hfh = 240;
    private k jaC;
    private String jgp;
    private awa jgq;
    private aib jgr;
    private c jgs;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        this.ftu = getIntent().getStringExtra("key_feedid");
        this.jaC = ad.aSE().dd(ad.aSE().Bq(this.ftu).field_snsId);
        if (this.jaC != null) {
            azr aUp = this.jaC.aUp();
            if (aUp != null) {
                List list = aUp.mWq.mom;
                if (list.size() > 0) {
                    aib com_tencent_mm_protocal_c_aib = (aib) list.get(0);
                    this.jgp = com_tencent_mm_protocal_c_aib.glb;
                    this.jgr = com_tencent_mm_protocal_c_aib;
                }
            }
            this.jgq = ah.n(this.jaC);
        }
        if (this.jgq != null) {
            awa com_tencent_mm_protocal_c_awa = this.jgq;
            if (!(com_tencent_mm_protocal_c_awa == null || com_tencent_mm_protocal_c_awa.mTz == null)) {
                int i = com_tencent_mm_protocal_c_awa.mTz.mTY;
                List list2 = com_tencent_mm_protocal_c_awa.mTz.mTZ;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        list2.get(i2);
                        this.hen.add(list2.get(i2));
                    }
                    c cVar = this.jgs;
                    List list3 = this.hen;
                    if (list3 == null) {
                        LinkedList linkedList = new LinkedList();
                    } else {
                        cVar.hen = list3;
                    }
                    cVar.notifyDataSetChanged();
                }
            }
        }
        bzU();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(2131690034));
        }
        NY(null);
    }

    protected final void NI() {
        q(getResources().getDrawable(2130838516));
        vD(2131235467);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyDetailUI jgt;

            {
                this.jgt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jgt.finish();
                return true;
            }
        });
        this.hdV = (ListView) findViewById(2131757838);
        this.jgs = new c(this.nDR.nEl);
        this.hdV.setAdapter(this.jgs);
        this.hdV.setOnScrollListener(this.hes);
        this.hdV.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyDetailUI jgt;

            {
                this.jgt = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904521;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
