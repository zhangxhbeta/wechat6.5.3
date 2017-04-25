package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.ap;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.y;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class GameCategoryUI extends MMActivity implements e {
    private Dialog dQN;
    private View dZM;
    private int gjl = 0;
    private int gjp = 0;
    private ListView gpG;
    private k gpH;
    private boolean gpI = false;
    private boolean gpJ = false;
    private int gpK;
    private String gpL;
    private j gpM = new j();
    private a gpN = new a(this) {
        final /* synthetic */ GameCategoryUI gpP;

        {
            this.gpP = r1;
        }

        public final void lw(int i) {
            int firstVisiblePosition = this.gpP.gpG.getFirstVisiblePosition();
            int lastVisiblePosition = this.gpP.gpG.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                this.gpP.gpH.u(this.gpP.gpG.getChildAt(i - firstVisiblePosition), i);
            }
        }
    };
    private OnScrollListener gpO = new OnScrollListener(this) {
        final /* synthetic */ GameCategoryUI gpP;

        {
            this.gpP = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.gpP.gpJ && !this.gpP.gpI) {
                this.gpP.dZM.setVisibility(0);
                this.gpP.asp();
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private int mType;

    static /* synthetic */ void a(GameCategoryUI gameCategoryUI, y yVar, boolean z) {
        gameCategoryUI.gpJ = yVar.gjn.gmt;
        if (z) {
            gameCategoryUI.gpH.H(yVar.gjo);
        } else {
            gameCategoryUI.gpH.I(yVar.gjo);
        }
    }

    static /* synthetic */ int j(GameCategoryUI gameCategoryUI) {
        int i = gameCategoryUI.gjp + 15;
        gameCategoryUI.gjp = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("extra_type", 0);
        this.gpK = getIntent().getIntExtra("extra_category_id", 0);
        this.gpL = getIntent().getStringExtra("extra_category_name");
        this.gjl = getIntent().getIntExtra("game_report_from_scene", 0);
        ak.vy().a(1220, this);
        Fd(this.gpL);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameCategoryUI gpP;

            {
                this.gpP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gpP.finish();
                return true;
            }
        });
        if (!be.kS(au.asa())) {
            a(0, 2131235684, 2131165207, new OnMenuItemClickListener(this) {
                final /* synthetic */ GameCategoryUI gpP;

                {
                    this.gpP = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.gpP, GameSearchUI.class);
                    switch (this.gpP.mType) {
                        case 1:
                            intent.putExtra("game_report_from_scene", 1602);
                            break;
                        case 2:
                            intent.putExtra("game_report_from_scene", 1502);
                            break;
                    }
                    this.gpP.startActivity(intent);
                    return true;
                }
            });
        }
        this.gpG = (ListView) findViewById(2131757194);
        this.gpG.setOnItemClickListener(this.gpM);
        this.gpM.lu(this.gjl);
        this.gpG.setOnScrollListener(this.gpO);
        this.gpH = new k(this);
        this.gpH.lu(this.gjl);
        this.gpH.a(this.gpN);
        this.dZM = ((LayoutInflater) this.nDR.nEl.getSystemService("layout_inflater")).inflate(2130903739, this.gpG, false);
        this.dZM.setVisibility(8);
        this.gpG.addFooterView(this.dZM);
        this.gpG.setAdapter(this.gpH);
        this.dQN = c.ca(this);
        this.dQN.show();
        asp();
    }

    public void onDestroy() {
        super.onDestroy();
        ak.vy().b(1220, this);
        this.gpH.clear();
    }

    protected final int getLayoutId() {
        return 2130903696;
    }

    private void asp() {
        ak.vy().a(new ap(this.gjp, this.mType, this.gpK), 0);
        this.gpI = true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            final com.tencent.mm.ba.a aVar = ((ap) kVar).fut.czl.czs;
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ GameCategoryUI gpP;

                public final void run() {
                    final y yVar = new y(aVar, this.gpP.mType, this.gpP.gjp);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 gpS;

                        public final void run() {
                            GameCategoryUI.a(this.gpS.gpP, yVar, this.gpS.gpP.gjp != 0);
                            this.gpS.gpP.gpI = false;
                            this.gpS.gpP.dZM.setVisibility(8);
                            GameCategoryUI.j(this.gpS.gpP);
                            if (this.gpS.gpP.dQN != null) {
                                this.gpS.gpP.dQN.dismiss();
                            }
                        }
                    });
                }
            });
            return;
        }
        v.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            v.e("MicroMsg.GameCategoryUI", "error request code");
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getStringExtra("game_app_id");
        }
        switch (i2) {
            case 2:
                if (!be.kS(str)) {
                    this.gpH.uo(str);
                    this.gpH.uq(str);
                    return;
                }
                return;
            case 3:
                if (!be.kS(str)) {
                    this.gpH.up(str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
