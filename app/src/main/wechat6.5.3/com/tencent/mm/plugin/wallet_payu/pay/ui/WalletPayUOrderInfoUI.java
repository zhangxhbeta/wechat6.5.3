package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.b.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_payu.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.h;
import java.util.ArrayList;

public class WalletPayUOrderInfoUI extends WalletOrderInfoUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gQ(1554);
    }

    protected final void bha() {
        j(new a());
    }

    protected final void Dt(String str) {
        j(new c(str, 1));
    }

    public void onDestroy() {
        gR(1554);
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
            return true;
        }
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (cVar.ith.kPm == null || cVar.ith.kPm.size() <= 0) {
                v.w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
                g.a(this, 2131236384, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ WalletPayUOrderInfoUI kZR;

                    {
                        this.kZR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.b(this.kZR, this.kZR.uA, 0);
                    }
                });
            } else {
                Commodity commodity = (Commodity) cVar.ith.kPm.get(0);
                v.d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:" + commodity);
                d.bhD().kZn = null;
                if (commodity != null) {
                    this.kTW = new ArrayList();
                    this.kTW.add(commodity);
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(commodity.hNh);
                    if (LX == null || ((int) LX.chr) == 0) {
                        ab.a.crZ.a(commodity.hNh, "", this.kUh);
                    } else {
                        G(LX);
                    }
                    this.kTX.notifyDataSetChanged();
                    bhb();
                }
            }
        }
        return super.d(i, i2, str, kVar);
    }

    public final void done() {
        bhc();
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.uA.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.uA.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.uA.getBoolean("intent_pay_end"));
        v.i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + this.uA.getInt("intent_pay_end_errcode"));
        for (String str : this.kTZ) {
            String str2;
            if (!be.kS(str2)) {
                v.d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str2});
                b(new h(str2), false);
            }
        }
        com.tencent.mm.wallet_core.a.k(this, bundle);
        if (this.hdo != null && !be.kS(this.hdo.fwh)) {
            str2 = this.hdo.kPm.size() > 0 ? ((Commodity) this.hdo.kPm.get(0)).eWA : "";
            str2 = String.format("%sreqkey=%s&transid=%s", new Object[]{this.hdo.fwh, this.hdo.fTG, str2});
            v.d("MicroMsg.WalletPayUOrderInfoUI", "url = " + str2);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", com.tencent.mm.model.k.xF());
            com.tencent.mm.ay.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
