package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;

@a(3)
public class MMSuperAlert extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130904077);
        final int intExtra = getIntent().getIntExtra("MMSuperAlert_msg", 0);
        final int intExtra2 = getIntent().getIntExtra("MMSuperAlert_title", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ MMSuperAlert nYb;

            public final void run() {
                g.a(this.nYb, intExtra == 0 ? "" : this.nYb.getString(intExtra), intExtra2 == 0 ? "" : this.nYb.getString(intExtra2), booleanExtra, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 nYc;

                    {
                        this.nYc = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.nYc.nYb.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 nYc;

                    {
                        this.nYc = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.nYc.nYb.finish();
                    }
                });
            }
        }, 50);
    }

    public static void W(Context context, int i) {
        Intent intent = new Intent(context, MMSuperAlert.class);
        intent.putExtra("MMSuperAlert_title", 2131231164);
        intent.putExtra("MMSuperAlert_msg", i);
        intent.putExtra("MMSuperAlert_cancelable", false);
        context.startActivity(intent);
    }

    public Resources getResources() {
        if (getAssets() == null || aa.getResources() == null) {
            return super.getResources();
        }
        return aa.getResources();
    }
}
