package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;

@com.tencent.mm.ui.base.a(19)
public class GameCenterUI extends MMBaseActivity {
    private int gjl;
    private boolean gqg = false;

    private class a implements Runnable {
        final /* synthetic */ GameCenterUI gqh;

        private a(GameCenterUI gameCenterUI) {
            this.gqh = gameCenterUI;
        }

        public final void run() {
            GameCenterUI.a(this.gqh);
        }
    }

    static /* synthetic */ void a(GameCenterUI gameCenterUI) {
        au.asd();
        n ars = q.ars();
        if (ars != null) {
            ars.arp();
            if (!be.kS(ars.giC)) {
                c.o(gameCenterUI.getBaseContext(), ars.giC, "game_center_h5_floatlayer");
                int i = ars.field_msgType;
                if (ars.field_msgType == 100) {
                    i = ars.giT;
                }
                af.a(gameCenterUI, 10, 1006, 1, 1, 0, ars.field_appId, gameCenterUI.gjl, i, ars.field_gameMsgId, ars.giU, null);
                ars.field_isRead = true;
                au.asc().a(ars, new String[0]);
            }
            au.asd();
            q.art();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gqg = getIntent().getBooleanExtra("from_find_more_friend", false);
        this.gjl = getIntent().getIntExtra("game_report_from_scene", 0);
        com.tencent.mm.plugin.game.c.a.a ara = com.tencent.mm.plugin.game.c.a.ara();
        if (ara.bkU == 2) {
            c.n(getBaseContext(), ara.url, "game_center_entrance");
            v.i("MicroMsg.GameCenterUI", "abtest");
            if (this.gqg) {
                new ac().postDelayed(new a(), 50);
                au.asd();
                q.arr();
                ak.yW();
                n bX = au.asc().bX(((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nra, Long.valueOf(0))).longValue());
                if (bX == null) {
                    af.a((Context) this, 9, 901, 1, 7, 0, af.bH("resource", "0"));
                } else {
                    bX.arp();
                    int i = bX.field_msgType;
                    if (bX.field_msgType == 100) {
                        i = bX.giT;
                    }
                    af.a(this, 9, 901, 1, 7, 0, bX.field_appId, 0, i, bX.field_gameMsgId, bX.giU, af.bH("resource", String.valueOf(bX.gin.gja)));
                }
            }
        } else {
            Intent intent = new Intent(this, GameCenterUI2.class);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            }
            startActivity(intent);
            overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.nFE, com.tencent.mm.ui.MMFragmentActivity.a.nFF);
        }
        finish();
    }
}
