package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.c;
import com.tencent.mm.pluginsdk.ui.applet.c.a;
import com.tencent.mm.sdk.platformtools.v;

public class GameChattingRoomWebViewUI extends WebViewUI {
    private String jumpUrl = "";
    private int lnR = 4;
    private int lnS = 5;
    final a lnT = new a(this) {
        final /* synthetic */ GameChattingRoomWebViewUI lnV;

        {
            this.lnV = r1;
        }

        public final void a(boolean z, String str, int i) {
            this.lnV.setResult(this.lnV.lnR, new Intent());
            this.lnV.finish();
        }
    };
    final a lnU = new a(this) {
        final /* synthetic */ GameChattingRoomWebViewUI lnV;

        {
            this.lnV = r1;
        }

        public final void a(boolean z, String str, int i) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.lnV.jumpUrl);
            this.lnV.setResult(this.lnV.lnS, intent);
            this.lnV.finish();
        }
    };

    protected final boolean Fj(String str) {
        return true;
    }

    protected final void Fi(String str) {
        v.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[]{str});
        this.jumpUrl = str;
        String stringExtra = getIntent().getStringExtra("action");
        if (stringExtra != null) {
            String string;
            if (getIntent().getStringExtra("app_name") == null) {
                string = getString(2131230906);
            } else {
                string = getString(2131231974, new Object[]{getIntent().getStringExtra("app_name")});
            }
            String string2 = getString(2131231981);
            if (stringExtra.equals("action_create")) {
                c.a(this.nDR, getString(2131232241), string, string2, this.lnT, this.lnU);
            } else if (stringExtra.equals("action_join")) {
                c.a(this.nDR, getString(2131233446), string, string2, this.lnT, this.lnU);
            }
        }
    }
}
