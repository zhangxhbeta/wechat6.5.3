package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.ay.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.e;

public final class b {

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ String hLq;
        final /* synthetic */ Activity nw;

        AnonymousClass2(String str, Activity activity) {
            this.hLq = str;
            this.nw = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.hLq);
            c.b(this.nw, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            e.yD(3);
            dialogInterface.dismiss();
        }
    }

    static class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ Activity nw;

        AnonymousClass4(Activity activity) {
            this.nw = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.nw.finish();
        }
    }

    public static void a(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(2131236492);
        }
        g.a(activity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
}
