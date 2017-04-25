package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.o;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String grv = "gameDetailRankDataKey";
    private String appId;
    private ListView grs;
    private GameRankHeadView grt;
    private h gru;

    public static class a {
        public String grx;
        public String gry;
        c grz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b fy = o.yx().fy(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (fy == null) {
            finish();
            return;
        }
        a aVar = (a) fy.get(grv);
        this.grs = (ListView) findViewById(2131757277);
        if (!(be.kS(aVar.grx) || be.kS(aVar.gry))) {
            View inflate = ((LayoutInflater) this.nDR.nEl.getSystemService("layout_inflater")).inflate(2130903717, this.grs, false);
            this.grt = (GameRankHeadView) inflate.findViewById(2131757293);
            this.grs.addHeaderView(inflate);
            GameRankHeadView gameRankHeadView = this.grt;
            gameRankHeadView.dID.setText(aVar.grx);
            gameRankHeadView.gwJ.setText(aVar.gry);
            gameRankHeadView.gwI = aVar.grz;
            gameRankHeadView.gwI.bmG = 1203;
            gameRankHeadView.gwI.position = 2;
            if (gameRankHeadView.grG == null) {
                gameRankHeadView.grG = new j(gameRankHeadView.gwI);
            }
            gameRankHeadView.grG.bW(gameRankHeadView.getContext());
            gameRankHeadView.grG.arm();
            gameRankHeadView.asB();
            if (gameRankHeadView.grE != null) {
                i.a(gameRankHeadView.grE);
            } else {
                gameRankHeadView.grE = new i.b(gameRankHeadView) {
                    final /* synthetic */ GameRankHeadView gwL;

                    {
                        this.gwL = r1;
                    }

                    public final void g(int i, String str, boolean z) {
                        if (this.gwL.gwI != null) {
                            this.gwL.grG.bW(this.gwL.getContext());
                            this.gwL.grG.arm();
                            if (z) {
                                this.gwL.asB();
                            }
                        }
                    }
                };
                i.a(gameRankHeadView.grE);
            }
            gameRankHeadView.grc.setOnClickListener(gameRankHeadView);
        }
        this.gru = new h(this);
        this.gru.CC = 2130903711;
        this.grs.setAdapter(this.gru);
        this.appId = aVar.grz.field_appId;
        if (be.kS(this.appId)) {
            finish();
            return;
        }
        NI();
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ GameDetailRankUI grw;

            {
                this.grw = r1;
            }

            public final void run() {
                this.grw.gru.a(new aa(this.grw.appId));
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        i.b(this.grt.grE);
    }

    protected final int getLayoutId() {
        return 2130903710;
    }

    protected final void NI() {
        Fd(g.n(this.nDR.nEl, this.appId));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameDetailRankUI grw;

            {
                this.grw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.grw.finish();
                return true;
            }
        });
    }
}
