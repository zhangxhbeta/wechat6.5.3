package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletIbgAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(4);
        this.pjH.gQ(1564);
        p(new com.tencent.mm.plugin.wallet_core.b.a.a());
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a)) {
            int i3 = ((com.tencent.mm.plugin.wallet_core.b.a.a) kVar).kLI;
            String str2 = ((com.tencent.mm.plugin.wallet_core.b.a.a) kVar).jumpUrl;
            v.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[]{str2, Integer.valueOf(i3)});
            if (i3 == 1) {
                boolean z;
                v.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.model.v.a.bnd())});
                switch (com.tencent.mm.pluginsdk.model.v.a.bnd()) {
                    case 1:
                    case 4:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        ak.yW();
                        if (((Boolean) c.vf().get(t.a.nsv, Boolean.valueOf(false))).booleanValue()) {
                            Toast.makeText(this, getString(2131236619), 1).show();
                            com.tencent.mm.pluginsdk.model.v.a.dg(this);
                            finish();
                        } else {
                            bht();
                        }
                        z = false;
                        break;
                    default:
                        bht();
                        z = false;
                        break;
                }
                if (z) {
                    DA(str2);
                    finish();
                }
            } else {
                DA(str2);
                finish();
            }
        } else {
            com.tencent.mm.wallet_core.a.b(this, null, 0);
        }
        return false;
    }

    public void onDestroy() {
        this.pjH.gR(1564);
        super.onDestroy();
    }

    private void DA(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    private void bht() {
        ak.yW();
        c.vf().a(t.a.nsv, Boolean.valueOf(true));
        g.a(this, false, getString(2131236622), "", getString(2131236617), getString(2131236616), new OnClickListener(this) {
            final /* synthetic */ WalletIbgAdapterUI kWp;

            {
                this.kWp = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.pluginsdk.model.v.a.dg(this.kWp);
                Toast.makeText(this.kWp, this.kWp.getString(2131236618), 1).show();
                this.kWp.finish();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ WalletIbgAdapterUI kWp;

            {
                this.kWp = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.kWp.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return -1;
    }
}
