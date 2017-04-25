package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.u;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;

@a(3)
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI oQp = null;

    static /* synthetic */ void a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        accountDeletedAlphaAlertUI.finish();
        d.aY(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.nDR.nEl, LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        accountDeletedAlphaAlertUI.nDR.nEl.startActivity(intent);
    }

    public static AccountDeletedAlphaAlertUI bIQ() {
        return oQp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oQp = this;
        com.tencent.mm.sdk.c.a.nhr.z(new u());
        ak.hold();
        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(getIntent().getStringExtra("errmsg"));
        if (dm != null) {
            dm.a(this, new OnClickListener(this) {
                final /* synthetic */ AccountDeletedAlphaAlertUI oQq;

                {
                    this.oQq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AccountDeletedAlphaAlertUI.a(this.oQq);
                }
            }, null);
        } else {
            g.a((Context) this, getString(2131233715), null, false, new OnClickListener(this) {
                final /* synthetic */ AccountDeletedAlphaAlertUI oQq;

                {
                    this.oQq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AccountDeletedAlphaAlertUI.a(this.oQq);
                }
            });
        }
    }

    public void onDestroy() {
        if (equals(oQp)) {
            oQp = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
