package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.a;

@a(19)
public final class AppBrand404PageUI extends b {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String dLm = null;
        final /* synthetic */ String dQt;

        AnonymousClass1(String str, String str2) {
            this.dQt = str;
        }

        public final void run() {
            aa.getContext().startActivity(new Intent(aa.getContext(), AppBrand404PageUI.class).putExtra("key_wording", this.dQt).putExtra("key_icon_url", this.dLm).addFlags(268435456));
        }
    }

    public static void os(String str) {
        ad.o(new AnonymousClass1(str, null));
    }

    public static void show(int i) {
        os(aa.getContext().getString(i));
    }

    protected final int getLayoutId() {
        return 2130903098;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131230938);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrand404PageUI dQu;

            {
                this.dQu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dQu.finish();
                return true;
            }
        });
        TextView textView = (TextView) findViewById(2131755349);
        CharSequence stringExtra = getIntent().getStringExtra("key_wording");
        be.kS(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
    }

    public final void finish() {
        super.finish();
    }

    protected final void onDestroy() {
        super.onDestroy();
    }
}
