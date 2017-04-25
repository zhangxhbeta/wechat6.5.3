package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintEntranceUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        v.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
        if (e.anN()) {
            v.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
            v.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
            g.a(this, getResources().getString(2131235592), "", getResources().getString(a.lxX.anw() ? 2131231558 : 2131231107), getString(2131231010), true, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI fUH;

                {
                    this.fUH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
                    a.lxX.bK(this.fUH);
                    this.fUH.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI fUH;

                {
                    this.fUH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.fUH.finish();
                }
            });
            e.anI();
        } else if (e.anH()) {
            z = false;
        } else {
            v.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
            g.a(this, getResources().getString(2131235591), "", getResources().getString(2131231557), getString(2131231010), true, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI fUH;

                {
                    this.fUH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
                    c.w(this.fUH, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                    this.fUH.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI fUH;

                {
                    this.fUH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.fUH.finish();
                }
            });
            e.anG();
        }
        if (!z) {
            v.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
