package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.webwx.a.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            CharSequence stringExtra = getIntent().getStringExtra("deviceName");
            if (stringExtra != null) {
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(1);
                View inflate = View.inflate(this, 2130903578, null);
                TextView textView = (TextView) inflate.findViewById(2131756874);
                ((TextView) inflate.findViewById(2131756875)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebWXPopupUnlockUI ltm;

                    public final void onClick(View view) {
                        ak.vy().a(new a(2), 0);
                        v.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
                        com.tencent.mm.plugin.webwx.a.drq.cH(1);
                        v.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
                        dialog.dismiss();
                    }
                });
                dialog.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ WebWXPopupUnlockUI ltm;

                    {
                        this.ltm = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.ltm.finish();
                    }
                });
                textView.setText(stringExtra);
                dialog.setContentView(inflate);
                dialog.show();
                return;
            }
            v.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
        }
    }
}
