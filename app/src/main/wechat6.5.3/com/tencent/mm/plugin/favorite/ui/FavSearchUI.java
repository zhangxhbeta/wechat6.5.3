package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.l;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.o;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.base.FavSearchActionView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.plugin.favorite.ui.base.FavTypePanel;
import com.tencent.mm.plugin.favorite.ui.c.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.d;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@a(19)
public class FavSearchUI extends MMActivity {
    private String aUZ;
    private int dke;
    private ListView eyl;
    private String fNS;
    private Set<Integer> fNT;
    private v.a fNU;
    private c fNV;
    private FavSearchActionView fNW;
    private FavTypePanel fNX;
    private ListView fNY;
    private View fNZ;
    private g fNn;
    private b fNo;
    private Animation fOa;
    private Animation fOb;
    private List<Integer> fOc;
    private List<String> fOd;
    private List<String> fOe;
    private Set<String> fOf = new HashSet();
    private View fOg;
    private ImageButton fOh;
    private MenuItem fOi;
    private ac mHandler;

    static /* synthetic */ void a(FavSearchUI favSearchUI, List list, List list2, List list3) {
        if ((list == null || list.isEmpty()) && ((list2 == null || list2.isEmpty()) && (list3 == null || list3.isEmpty()))) {
            favSearchUI.fOh.setVisibility(8);
        } else {
            favSearchUI.fOh.setVisibility(0);
        }
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, boolean z) {
        favSearchUI.fNo.notifyDataSetChanged();
        if (8 != favSearchUI.fNY.getVisibility()) {
            favSearchUI.fNY.setVisibility(8);
            favSearchUI.fNY.startAnimation(favSearchUI.fOb);
        }
        if (favSearchUI.fNo.isEmpty()) {
            if (favSearchUI.fNZ.getVisibility() != 0) {
                favSearchUI.fNZ.setVisibility(0);
                favSearchUI.fNZ.startAnimation(favSearchUI.fOa);
            }
            if (8 != favSearchUI.eyl.getVisibility()) {
                favSearchUI.eyl.setVisibility(8);
                favSearchUI.eyl.startAnimation(favSearchUI.fOb);
            }
        } else {
            if (8 != favSearchUI.fNZ.getVisibility()) {
                favSearchUI.fNZ.setVisibility(8);
                favSearchUI.fNZ.startAnimation(favSearchUI.fOb);
            }
            if (favSearchUI.eyl.getVisibility() != 0) {
                favSearchUI.eyl.setVisibility(0);
                favSearchUI.eyl.startAnimation(favSearchUI.fOa);
            }
        }
        if (favSearchUI.fNo.isEmpty() && ((favSearchUI.fOd == null || favSearchUI.fOd.isEmpty()) && ((favSearchUI.fOc == null || favSearchUI.fOc.isEmpty()) && favSearchUI.fOe != null && favSearchUI.fOe.size() == 1))) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSearchUI", "need del tag %s", new Object[]{(String) favSearchUI.fOe.get(0)});
            favSearchUI.fOf.add(r0);
        }
        if (z) {
            favSearchUI.axg();
        }
    }

    static /* synthetic */ void c(FavSearchUI favSearchUI) {
        favSearchUI.fNV.notifyDataSetChanged();
        if (favSearchUI.fNY.getVisibility() != 0) {
            favSearchUI.fNY.setVisibility(0);
            favSearchUI.fNY.startAnimation(favSearchUI.fOa);
        }
        if (8 != favSearchUI.eyl.getVisibility()) {
            favSearchUI.eyl.setVisibility(8);
            favSearchUI.eyl.startAnimation(favSearchUI.fOb);
        }
        if (8 != favSearchUI.fNZ.getVisibility()) {
            favSearchUI.fNZ.setVisibility(8);
            favSearchUI.fNZ.startAnimation(favSearchUI.fOb);
        }
    }

    protected final int getLayoutId() {
        return 2130903615;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ac();
        Fd("");
        this.dke = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.dke) {
            this.aUZ = getIntent().getStringExtra("key_to_user");
            this.fNS = getIntent().getStringExtra("key_fav_item_id");
        }
        this.fNY = (ListView) findViewById(2131756986);
        this.eyl = (ListView) findViewById(2131756987);
        this.fNZ = findViewById(2131756988);
        this.fOa = AnimationUtils.loadAnimation(this.nDR.nEl, 2130968639);
        this.fOb = AnimationUtils.loadAnimation(this.nDR.nEl, 2130968640);
        amD();
        this.fNX = (FavTypePanel) View.inflate(this.nDR.nEl, 2130903620, null);
        this.fNX.fQq = new FavTypePanel.a(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final void A(int i, boolean z) {
                if (z) {
                    FavSearchActionView a = this.fOj.fNW;
                    a.fPq.add(Integer.valueOf(i));
                    if (a.fOC != null) {
                        a.amU();
                        FavTagPanel favTagPanel = a.fOC;
                        String w = v.w(a.getContext(), i);
                        if (be.kS(w)) {
                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
                        } else {
                            String trim = w.trim();
                            Iterator it = favTagPanel.fQf.iterator();
                            while (it.hasNext()) {
                                if (trim.equals(((d) it.next()).nYF)) {
                                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[]{trim});
                                    break;
                                }
                            }
                            d bCC = favTagPanel.bCC();
                            favTagPanel.fQf.add(bCC);
                            favTagPanel.a(bCC, trim, true);
                            bCC.nYG.setOnClickListener(favTagPanel.fQh);
                            favTagPanel.addView(bCC.nYG, favTagPanel.fQf.size() - 1);
                            favTagPanel.bCD();
                        }
                        if (a.fQa != null) {
                            a.tl(a.fOC.bCw());
                            a.fQa.a(a.fPq, a.fPZ, a.fPY, false);
                            com.tencent.mm.plugin.report.service.g.iuh.h(11126, new Object[]{Integer.valueOf(1)});
                            return;
                        }
                        return;
                    }
                    return;
                }
                FavSearchActionView a2 = this.fOj.fNW;
                a2.fPq.remove(Integer.valueOf(i));
                if (a2.fOC != null) {
                    a2.amU();
                    a2.fOC.to(v.w(a2.getContext(), i));
                    if (a2.fQa != null) {
                        a2.tl(a2.fOC.bCw());
                        a2.fQa.a(a2.fPq, a2.fPZ, a2.fPY, true);
                    }
                }
            }
        };
        this.fNV = new c(this, this.nDR.nEl) {
            final /* synthetic */ FavSearchUI fOj;

            protected final void th(String str) {
                FavSearchActionView a = this.fOj.fNW;
                a.fPY.add(str);
                if (a.fOC != null) {
                    a.fOC.Ou("");
                    a.fOC.aM(str, true);
                    if (a.fQa != null) {
                        a.tl(a.fOC.bCw());
                        a.fQa.a(a.fPq, a.fPZ, a.fPY, false);
                        com.tencent.mm.plugin.report.service.g.iuh.h(11126, new Object[]{Integer.valueOf(2)});
                    }
                }
            }

            protected final void ti(String str) {
                FavSearchActionView a = this.fOj.fNW;
                a.fPY.remove(str);
                if (a.fOC != null) {
                    if (a.fPY.isEmpty()) {
                        a.fOC.Ou(a.getResources().getString(2131231148));
                    }
                    a.fOC.removeTag(str);
                    if (a.fQa != null) {
                        a.tl(a.fOC.bCw());
                        a.fQa.a(a.fPq, a.fPZ, a.fPY, true);
                    }
                }
            }
        };
        this.fNY.addHeaderView(this.fNX);
        if (h.aln().alJ() > 0) {
            this.fNY.addHeaderView((TextView) View.inflate(this.nDR.nEl, 2130903617, null));
        }
        this.fNY.setAdapter(this.fNV);
        this.fNY.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.fOj.axg();
                        break;
                }
                return false;
            }
        });
        this.fNn = new g(this.nDR.nEl, 16);
        this.fNo = new b(this.fNn, false);
        if (1 == this.dke) {
            this.fNT = new HashSet();
            this.fNU = new o();
            if (!be.kS(this.fNS)) {
                for (String str : this.fNS.split(",")) {
                    int i = be.getInt(str, Integer.MAX_VALUE);
                    if (Integer.MAX_VALUE != i) {
                        this.fNT.add(Integer.valueOf(i));
                    }
                }
            }
            this.fNo.f(this.fNT);
            this.fNo.a(this.fNU);
        }
        this.eyl.setAdapter(this.fNo);
        this.eyl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final com.tencent.mm.plugin.favorite.ui.c.a.b bVar = (com.tencent.mm.plugin.favorite.ui.c.a.b) view.getTag();
                if (1 == this.fOj.dke) {
                    if (bVar == null) {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                    } else if (bVar.fLP == null) {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSearchUI", "on item click, info is null");
                    } else {
                        com.tencent.mm.pluginsdk.ui.applet.c.c cVar = new com.tencent.mm.pluginsdk.ui.applet.c.c(this.fOj.nDR.nEl);
                        cVar.ba(this.fOj.aUZ);
                        e.a(cVar, this.fOj.nDR.nEl, bVar.fLP);
                        cVar.d(Boolean.valueOf(true)).tS(2131231149).a(new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                            final /* synthetic */ AnonymousClass2 fOl;

                            public final void a(boolean z, String str, int i) {
                                this.fOl.fOj.axg();
                                if (z) {
                                    final p a = com.tencent.mm.ui.base.g.a(this.fOl.fOj.nDR.nEl, this.fOl.fOj.getString(2131232670), false, null);
                                    com.tencent.mm.plugin.favorite.b.p.a(this.fOl.fOj.nDR.nEl, this.fOl.fOj.aUZ, str, bVar.fLP, new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 fOm;

                                        public final void run() {
                                            if (a != null) {
                                                a.dismiss();
                                            }
                                            com.tencent.mm.ui.snackbar.a.f(this.fOm.fOl.fOj, this.fOm.fOl.fOj.getString(2131232839));
                                            ad.g(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 fOn;

                                                {
                                                    this.fOn = r1;
                                                }

                                                public final void run() {
                                                    this.fOn.fOm.fOl.fOj.finish();
                                                }
                                            }, 1800);
                                        }
                                    });
                                }
                            }
                        }).iji.show();
                    }
                } else if (2 != this.fOj.dke) {
                    this.fOj.fNo.onItemClick(adapterView, view, i, j);
                    if (bVar.fLP != null) {
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavSearchUI", "type %s", new Object[]{Integer.valueOf(bVar.fLP.field_type)});
                        com.tencent.mm.plugin.report.service.g.iuh.h(12746, new Object[]{Integer.valueOf(bVar.fLP.field_type)});
                    }
                } else if (bVar == null) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                } else if (bVar.fLP == null) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSearchUI", "on item click, info is null");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_result_local_id", bVar.fLP.field_localId);
                    this.fOj.setResult(-1, intent);
                    this.fOj.finish();
                }
            }
        });
        this.eyl.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.fOj.axg();
                        break;
                }
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fOj.finish();
                return true;
            }
        });
        h.aln().a(this.fNV);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fNn.destory();
        this.fNn = null;
        h.aln().a(this.fNV);
        h.aln().d(this.fOf);
        if (this.fNo != null) {
            this.fNo.finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavSearchUI", "on create options menu");
        amD();
        this.fOi = menu.add(0, 2131755061, 0, 2131231035);
        l.a(this.fOi, this.fNW);
        l.a(this.fOi, 9);
        this.fNW.post(new Runnable(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final void run() {
                FavSearchActionView a = this.fOj.fNW;
                if (a.fOC != null) {
                    a.fOC.bCz();
                }
                this.fOj.aJs();
            }
        });
        l.a(this.fOi, new l.e(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                this.fOj.finish();
                return true;
            }
        });
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ FavSearchUI fOj;

            {
                this.fOj = r1;
            }

            public final void run() {
                if (this.fOj.fOi != null) {
                    l.b(this.fOj.fOi);
                    LayoutParams layoutParams = (LayoutParams) this.fOj.fNW.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                        layoutParams.width = -1;
                    }
                    this.fOj.fNW.setLayoutParams(layoutParams);
                }
            }
        });
        return true;
    }

    private void amD() {
        if (this.fNW == null) {
            this.fNW = (FavSearchActionView) View.inflate(this.nDR.nEl, 2130903614, null);
            this.fOg = this.fNW.findViewById(2131755276);
            this.fOg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavSearchUI fOj;

                {
                    this.fOj = r1;
                }

                public final void onClick(View view) {
                    this.fOj.finish();
                }
            });
            this.fOh = (ImageButton) this.fNW.findViewById(2131756985);
            this.fOh.setVisibility(8);
            this.fNW.fQa = new FavSearchActionView.a(this) {
                final /* synthetic */ FavSearchUI fOj;

                {
                    this.fOj = r1;
                }

                public final void Og() {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
                    FavSearchUI.c(this.fOj);
                }

                public final void a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[]{list, list2, list3});
                    this.fOj.fOd = list2;
                    this.fOj.fOe = list3;
                    this.fOj.fOc = list;
                    this.fOj.fNV.au(list3);
                    this.fOj.fNX.aw(list);
                    if (z) {
                        FavSearchUI.c(this.fOj);
                        FavSearchUI.a(this.fOj, list, list2, list3);
                        return;
                    }
                    this.fOj.fNo.b(list, list2, list3);
                    FavSearchUI.a(this.fOj, true);
                    FavSearchUI.a(this.fOj, list, list2, list3);
                }

                public final void a(final List<Integer> list, final List<String> list2, final List<String> list3) {
                    this.fOj.fNW.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 fOr;

                        public final void run() {
                            FavSearchUI.a(this.fOr.fOj, list, list2, list3);
                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[]{list, list2, list3});
                            this.fOr.fOj.fOd = list2;
                            this.fOr.fOj.fOe = list3;
                            this.fOr.fOj.fOc = list;
                            this.fOr.fOj.fNV.au(list3);
                            this.fOr.fOj.fNX.aw(list);
                            this.fOr.fOj.fNo.b(list, list2, list3);
                            FavSearchUI.a(this.fOr.fOj, false);
                        }
                    });
                }
            };
        }
    }

    protected void onResume() {
        this.fNo.amO();
        this.fNo.notifyDataSetChanged();
        super.onResume();
    }
}
