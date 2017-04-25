package com.tencent.mm.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.w;

public class PermissionWarningDialog extends MMBaseActivity {
    private h doc = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        MS();
    }

    protected void onResume() {
        super.onResume();
        w.a(true, null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.doc != null) {
            this.doc.dismiss();
            this.doc = null;
        }
        MS();
    }

    protected void onPause() {
        super.onPause();
        w.a(false, null);
    }

    private void MS() {
        if (getIntent() == null) {
            v.e("MicroMsg.PermissionWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            v.e("MicroMsg.PermissionWarningDialog", "invalid params");
            return;
        }
        int i = extras.getInt("warning_type", 0);
        a aVar;
        if (1 == i) {
            aVar = new a(this);
            aVar.Op(extras.getString("warning_title"));
            aVar.Oq(extras.getString("warning_content"));
            aVar.wp(2131231075).a(new OnClickListener(this) {
                final /* synthetic */ PermissionWarningDialog doF;

                {
                    this.doF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.doF.finish();
                }
            });
            this.doc = aVar.RX();
            this.doc.setCanceledOnTouchOutside(false);
            this.doc.show();
        } else if (2 == i) {
            aVar = new a(this);
            final boolean z = extras.getBoolean("warning_filter", false);
            final boolean z2 = extras.getBoolean("warning_due2Exception", false);
            aVar.wm(2131231121);
            aVar.Oq(getString(2131231116));
            aVar.wq(2131231010).b(new OnClickListener(this) {
                final /* synthetic */ PermissionWarningDialog doF;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.bo(z2);
                    this.doF.finish();
                }
            });
            aVar.wp(2131231110).a(new OnClickListener(this) {
                final /* synthetic */ PermissionWarningDialog doF;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.f(z, z2);
                    this.doF.finish();
                }
            });
            this.doc = aVar.RX();
            this.doc.setCanceledOnTouchOutside(false);
            this.doc.show();
        }
    }

    public static void i(Context context, String str, String str2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 1);
        intent.putExtra("warning_title", str);
        intent.putExtra("warning_content", str2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
