package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameDetailUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("game_app_id");
        com.tencent.mm.plugin.game.c.a.a uc = com.tencent.mm.plugin.game.c.a.uc(stringExtra);
        if (uc.bkU != 2 || be.kS(uc.url)) {
            int bU = e.bU(aa.getContext());
            if (bU == 2) {
                c.X(this, stringExtra);
            } else if (bU == 1) {
                c.b(this, getIntent().getExtras());
            } else {
                String buo = be.buo();
                if (be.kS(buo) || buo.toLowerCase().equals("cn")) {
                    c.X(this, stringExtra);
                } else {
                    c.b(this, getIntent().getExtras());
                }
            }
        } else {
            c.n(getBaseContext(), uc.url, "game_center_detail");
        }
        finish();
    }
}
