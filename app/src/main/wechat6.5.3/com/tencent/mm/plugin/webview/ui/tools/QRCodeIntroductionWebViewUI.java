package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;

public class QRCodeIntroductionWebViewUI extends WebViewUI {
    static /* synthetic */ void a(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        Context context = qRCodeIntroductionWebViewUI;
        g.a(context, "", new String[]{qRCodeIntroductionWebViewUI.getString(2131235509), qRCodeIntroductionWebViewUI.getString(2131234274)}, "", false, new c(qRCodeIntroductionWebViewUI) {
            final /* synthetic */ QRCodeIntroductionWebViewUI ljh;

            {
                this.ljh = r1;
            }

            public final void gT(int i) {
                switch (i) {
                    case 0:
                        this.ljh.lkl.blg();
                        return;
                    case 1:
                        this.ljh.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.ljh.bkm())));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ QRCodeIntroductionWebViewUI ljh;

            {
                this.ljh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                QRCodeIntroductionWebViewUI.a(this.ljh);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ QRCodeIntroductionWebViewUI ljh;

            {
                this.ljh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ljh.finish();
                return true;
            }
        });
    }
}
