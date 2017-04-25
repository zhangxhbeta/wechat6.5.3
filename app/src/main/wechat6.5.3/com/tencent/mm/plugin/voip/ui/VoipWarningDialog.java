package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;

public class VoipWarningDialog extends MMBaseActivity {
    public static int kzL = 1234;
    private static a kzM;
    private h doc = null;

    public interface a {
        void a(VoipWarningDialog voipWarningDialog);

        void b(VoipWarningDialog voipWarningDialog);
    }

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
            v.e("MicroMsg.VoipWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            v.e("MicroMsg.VoipWarningDialog", "invalid params");
            return;
        }
        int i;
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
        aVar.Op(getString(2131235911));
        aVar.Oq(extras.getString("warning_content"));
        aVar.c(new OnCancelListener(this) {
            final /* synthetic */ VoipWarningDialog kzN;

            {
                this.kzN = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.kzN.finish();
            }
        });
        if (d.dW(23)) {
            i = 2131235910;
        } else {
            i = 2131235909;
        }
        aVar.wp(i).a(new OnClickListener(this) {
            final /* synthetic */ VoipWarningDialog kzN;

            {
                this.kzN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (d.dW(23)) {
                    try {
                        if (!be.kS((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                            this.kzN.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + aa.getPackageName())), VoipWarningDialog.kzL);
                            return;
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.VoipWarningDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[]{e.getMessage(), e.getClass().getCanonicalName()});
                    }
                }
                String string = this.kzN.getString(2131235912);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                c.b(this.kzN, "webview", ".ui.tools.WebViewUI", intent);
                this.kzN.finish();
            }
        });
        this.doc = aVar.RX();
        this.doc.setCanceledOnTouchOutside(false);
        this.doc.show();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (kzM != null) {
            if (i != kzL) {
                kzM.b(this);
            } else if (b.az(aa.getContext())) {
                kzM.a(this);
            } else {
                kzM.b(this);
            }
        }
    }

    public static void a(Context context, a aVar) {
        kzM = aVar;
        Intent intent = new Intent(context, VoipWarningDialog.class);
        intent.putExtra("warning_content", aa.getContext().getString(2131235908));
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
