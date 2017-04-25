package com.tencent.mm.plugin.appbrand.k;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.smtt.sdk.u;

public final class c {

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context) {
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            ((Activity) this.val$context).finish();
        }
    }

    public interface a {
        void OK();

        void onSuccess();
    }

    public static void a(final Context context, b bVar, String str, final a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        bVar.evaluateJavascript(str + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[]{Long.valueOf(currentTimeMillis)}), new u<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                if (str == null || !str.contains(currentTimeMillis)) {
                    aVar.OK();
                    Context context = context;
                    if (context instanceof Activity) {
                        com.tencent.mm.plugin.appbrand.ui.a aVar = new com.tencent.mm.plugin.appbrand.ui.a(context);
                        aVar.Oq(context.getString(2131230945));
                        aVar.jk(false);
                        aVar.wp(2131230918).a(new AnonymousClass2(context));
                        aVar.RX().show();
                        return;
                    }
                    return;
                }
                aVar.onSuccess();
            }
        });
    }
}
