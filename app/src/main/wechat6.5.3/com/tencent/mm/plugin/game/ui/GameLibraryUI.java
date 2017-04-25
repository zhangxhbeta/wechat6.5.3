package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.ab;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.ao;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.x;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI extends MMActivity implements e {
    private View dZM;
    private int gjl = 0;
    private int gjp = 0;
    private ListView gpG;
    private k gpH;
    private boolean gpI = false;
    private boolean gpJ = true;
    private j gpM = new j();
    private a gpN = new a(this) {
        final /* synthetic */ GameLibraryUI guT;

        {
            this.guT = r1;
        }

        public final void lw(int i) {
            int firstVisiblePosition = this.guT.gpG.getFirstVisiblePosition() - this.guT.guQ;
            int lastVisiblePosition = this.guT.gpG.getLastVisiblePosition() - this.guT.guQ;
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                this.guT.gpH.u(this.guT.gpG.getChildAt(i - firstVisiblePosition), i);
            }
        }
    };
    private OnScrollListener gpO = new OnScrollListener(this) {
        final /* synthetic */ GameLibraryUI guT;

        {
            this.guT = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.guT.gpJ && !this.guT.gpI) {
                this.guT.dZM.setVisibility(0);
                this.guT.asu();
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private OnClickListener gqH = new OnClickListener(this) {
        final /* synthetic */ GameLibraryUI guT;

        {
            this.guT = r1;
        }

        public final void onClick(View view) {
            int i = 6;
            if (view.getTag() instanceof String) {
                c.a(view, this.guT);
                i = 7;
            } else {
                Intent intent = new Intent(this.guT, GameCategoryUI.class);
                intent.putExtra("extra_type", 2);
                intent.putExtra("extra_category_name", this.guT.getString(2131233091));
                intent.putExtra("game_report_from_scene", 1113);
                this.guT.startActivity(intent);
            }
            af.a(this.guT, 11, 1113, 1, i, this.guT.gjl, null);
        }
    };
    private Dialog gqy;
    private boolean gqz = true;
    private GameBannerView guD;
    private GameLibraryCategoriesView guE;
    private View guF;
    private TextView guG;
    private View guH;
    private GameDropdownView guI;
    private HashMap<Integer, String> guJ;
    private int guK = 0;
    private boolean guL = false;
    private View guM;
    private Button guN;
    private boolean guO = false;
    private int guP = 990;
    private int guQ = 0;
    private OnClickListener guR = new OnClickListener(this) {
        final /* synthetic */ GameLibraryUI guT;

        {
            this.guT = r1;
        }

        public final void onClick(View view) {
            c.a(view, this.guT);
            af.a(this.guT, 11, 1110, 999, 7, this.guT.gjl, null);
        }
    };
    private GameDropdownView.a guS = new GameDropdownView.a(this) {
        final /* synthetic */ GameLibraryUI guT;

        {
            this.guT = r1;
        }

        public final void lA(int i) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.guT.guJ.keySet());
            if (i <= linkedList.size() - 1) {
                this.guT.guK = ((Integer) linkedList.get(i)).intValue();
                v.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[]{Integer.valueOf(this.guT.guK)});
                this.guT.gjp = 0;
                this.guT.asu();
                af.a(this.guT, 11, 1111, this.guT.guK + this.guT.guP, 2, this.guT.gjl, null);
            }
        }
    };

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI, ab abVar, boolean z) {
        Pair pair = null;
        gameLibraryUI.gpJ = abVar.gjz.gmt;
        LinkedList linkedList;
        if (z) {
            gameLibraryUI.gpH.H(abVar.gjB);
            v.i("MicroMsg.GameLibraryUI", "Appending list size: %d", new Object[]{Integer.valueOf(linkedList.size())});
        } else {
            LinkedList linkedList2;
            GameBannerView gameBannerView = gameLibraryUI.guD;
            if (abVar.gjz.gmr == null || abVar.gjz.gmr.gmZ == null) {
                v.e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                linkedList2 = new LinkedList();
                for (int i = 0; i < abVar.gjz.gmr.gmZ.size(); i++) {
                    GameBannerView.a aVar = new GameBannerView.a();
                    com.tencent.mm.plugin.game.d.a aVar2 = (com.tencent.mm.plugin.game.d.a) abVar.gjz.gmr.gmZ.get(i);
                    com.tencent.mm.plugin.game.c.c a = x.a(aVar2.gkt);
                    if (a != null) {
                        d.b(a);
                        aVar.index = i;
                        aVar.gpF = a;
                        aVar.cxy = aVar2.gku;
                        aVar.ghp = aVar2.gkv;
                        linkedList2.add(aVar);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.J(linkedList);
            gameLibraryUI.guE.B(abVar.arO());
            gameLibraryUI.guE.gjl = gameLibraryUI.gjl;
            linkedList = new LinkedList();
            linkedList2 = abVar.gjA;
            Object obj = abVar.gjB;
            linkedList.addAll(linkedList2);
            linkedList.addAll(obj);
            gameLibraryUI.gpH.I(linkedList);
            v.i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(obj.size())});
            gameLibraryUI.guJ = abVar.arN();
            linkedList = new LinkedList();
            linkedList.addAll(gameLibraryUI.guJ.values());
            GameDropdownView gameDropdownView = gameLibraryUI.guI;
            LinkedList linkedList3 = new LinkedList();
            linkedList3.addAll(gameLibraryUI.guJ.keySet());
            gameDropdownView.b(linkedList, linkedList3.indexOf(Integer.valueOf(gameLibraryUI.guK)));
            Pair pair2 = (abVar.gjz.gmr == null || abVar.gjz.gmr.gna == null) ? null : new Pair(abVar.gjz.gmr.gna.gnr, abVar.gjz.gmr.gna.gmE);
            if (pair2 == null || be.kS((String) pair2.first) || be.kS((String) pair2.second)) {
                gameLibraryUI.guF.setTag(null);
                gameLibraryUI.guG.setVisibility(8);
            } else {
                gameLibraryUI.guF.setTag(pair2.second);
                gameLibraryUI.guG.setVisibility(0);
                gameLibraryUI.guG.setText((CharSequence) pair2.first);
            }
            SparseArray sparseArray = new SparseArray();
            if (linkedList2.size() != 0) {
                sparseArray.put(0, gameLibraryUI.guF);
            }
            sparseArray.put(linkedList2.size(), gameLibraryUI.guH);
            gameLibraryUI.gpH.b(sparseArray);
            if (!(abVar.gjz.gmr == null || abVar.gjz.gmr.gnc == null)) {
                pair = new Pair(abVar.gjz.gmr.gnc.gnk, abVar.gjz.gmr.gnc.gkv);
            }
            if (pair != null) {
                gameLibraryUI.guN.setText((CharSequence) pair.first);
                gameLibraryUI.guN.setTag(pair.second);
                gameLibraryUI.guO = true;
            }
        }
        if (!gameLibraryUI.gpJ && gameLibraryUI.guO) {
            gameLibraryUI.guM.setVisibility(0);
        }
    }

    static /* synthetic */ int r(GameLibraryUI gameLibraryUI) {
        int i = gameLibraryUI.gjp + 15;
        gameLibraryUI.gjp = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ak.uz()) {
            int i;
            this.gjl = getIntent().getIntExtra("game_report_from_scene", 0);
            ak.vy().a(1218, this);
            NI();
            final byte[] uf = au.asg().uf("pb_library");
            if (uf == null) {
                v.i("MicroMsg.GameLibraryUI", "No cache found");
                i = 0;
            } else {
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ GameLibraryUI guT;

                    public final void run() {
                        final ab abVar = new ab(uf);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 guV;

                            public final void run() {
                                GameLibraryUI.a(this.guV.guT, abVar, false);
                            }
                        });
                    }
                });
                i = 1;
            }
            if (i == 0) {
                this.gqy = c.ca(this);
                this.gqy.show();
            }
            asu();
            af.a((Context) this, 11, 1100, 0, 1, this.gjl, null);
            return;
        }
        v.e("MicroMsg.GameLibraryUI", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (ak.uz()) {
            this.gpH.refresh();
            if (!(this.gqz || this.guD == null)) {
                GameBannerView gameBannerView = this.guD;
                if (gameBannerView.gpC != null && gameBannerView.gpC.btC() && gameBannerView.gpB.size() > 1) {
                    gameBannerView.gpC.ea(5000);
                    v.i("MicroMsg.GameBannerView", "Auto scroll restarted");
                }
            }
            if (this.gqz) {
                this.gqz = false;
                return;
            }
            return;
        }
        v.e("MicroMsg.GameLibraryUI", "account not ready");
    }

    protected void onPause() {
        super.onPause();
        if (this.guD != null) {
            GameBannerView gameBannerView = this.guD;
            if (gameBannerView.gpC != null) {
                gameBannerView.gpC.QI();
                v.i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
    }

    protected void onDestroy() {
        v.i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        ak.vy().b(1218, this);
        this.gpH.clear();
        if (this.guD != null) {
            this.guD.gpC.QI();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected final int getLayoutId() {
        return 2130903730;
    }

    protected final int NO() {
        return 1;
    }

    protected final void NI() {
        vD(2131233089);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameLibraryUI guT;

            {
                this.guT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.guT.goBack();
                return true;
            }
        });
        if (!be.kS(au.asa())) {
            a(0, 2131235684, 2131165207, new OnMenuItemClickListener(this) {
                final /* synthetic */ GameLibraryUI guT;

                {
                    this.guT = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.guT, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1109);
                    this.guT.startActivity(intent);
                    return true;
                }
            });
        }
        this.gpG = (ListView) findViewById(2131757326);
        this.gpG.setOnItemClickListener(this.gpM);
        this.gpM.lu(this.gjl);
        this.gpG.setOnScrollListener(this.gpO);
        this.gpH = new k(this);
        this.gpH.lu(this.gjl);
        this.gpH.a(this.gpN);
        LayoutInflater layoutInflater = (LayoutInflater) this.nDR.nEl.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(2130903737, this.gpG, false);
        this.guD = (GameBannerView) inflate.findViewById(2131757334);
        this.guD.gjl = this.gjl;
        this.gpG.addHeaderView(inflate);
        this.guQ++;
        this.guE = (GameLibraryCategoriesView) layoutInflater.inflate(2130903732, this.gpG, false);
        View linearLayout = new LinearLayout(this);
        linearLayout.addView(this.guE);
        this.gpG.addHeaderView(linearLayout);
        this.guQ++;
        this.guF = layoutInflater.inflate(2130903736, this.gpG, false);
        this.guF.setOnClickListener(this.guR);
        this.guG = (TextView) this.guF.findViewById(2131757333);
        this.guH = layoutInflater.inflate(2130903731, this.gpG, false);
        this.guH.setOnClickListener(null);
        this.guI = (GameDropdownView) this.guH.findViewById(2131757328);
        this.guI.gsJ = this.guH;
        this.guI.gsI = this.guS;
        this.dZM = layoutInflater.inflate(2130903739, this.gpG, false);
        this.dZM.setVisibility(8);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(this.dZM);
        this.gpG.addFooterView(linearLayout);
        this.guM = layoutInflater.inflate(2130903735, this.gpG, false);
        this.guM.setVisibility(8);
        this.guN = (Button) this.guM.findViewById(2131757331);
        this.guN.setOnClickListener(this.gqH);
        this.gpG.addFooterView(this.guM);
        this.gpG.setAdapter(this.gpH);
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!be.kS(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        finish();
    }

    private void asu() {
        ak.vy().a(new ao(this.gjp, com.tencent.mm.plugin.game.c.e.arh(), this.guK, this.gjp == 0), 0);
        this.gpI = true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1218:
                    final com.tencent.mm.ba.a aVar = ((ao) kVar).fut.czl.czs;
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ GameLibraryUI guT;

                        public final void run() {
                            com.tencent.mm.ba.a aVar = aVar;
                            boolean z = this.guT.gjp == 0 && !this.guT.guL;
                            final ab abVar = new ab(aVar, z, this.guT.gjp);
                            this.guT.guL = true;
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass9 guW;

                                public final void run() {
                                    GameLibraryUI.a(this.guW.guT, abVar, this.guW.guT.gjp != 0);
                                    this.guW.guT.gpI = false;
                                    this.guW.guT.dZM.setVisibility(8);
                                    GameLibraryUI.r(this.guW.guT);
                                    if (this.guW.guT.gqy != null) {
                                        this.guW.guT.gqy.dismiss();
                                    }
                                }
                            });
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.a.a.drq.a(this, i, i2, str)) {
            Toast.makeText(this, getString(2131233099, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.gqy != null) {
            this.gqy.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            v.e("MicroMsg.GameLibraryUI", "error request code");
        }
    }
}
