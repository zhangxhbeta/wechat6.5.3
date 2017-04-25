package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.os.Bundle;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.h;

public class WalletIbgOrderInfoUI extends WalletOrderInfoUI {
    private String dzg = null;
    private String kHq = null;
    private String kWq = null;
    private String kWr = null;
    private String kWs = null;
    private String kWt = null;
    private String mTimeStamp = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pjH.gQ(1565);
    }

    public final void done() {
        v.i("MicroMsg.WalletIbgOrderInfoUI", "hy: result is not set manly. set to OK");
        for (String str : this.kTZ) {
            if (!be.kS(str)) {
                v.d("MicroMsg.WalletIbgOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                ak.vy().a(new h(str), 0);
            }
        }
        setResult(-1);
        finish();
    }

    protected final void NH() {
        this.dzg = getIntent().getStringExtra("appId");
        this.kWq = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.kHq = getIntent().getStringExtra("packageExt");
        this.kWr = getIntent().getStringExtra("paySignature");
        this.kWs = getIntent().getStringExtra("signtype");
        this.kWt = getIntent().getStringExtra("url");
        p(new b(this.dzg, this.kWq, this.mTimeStamp, this.kHq, this.kWr, this.kWs, this.kWt));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof b)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            this.hdo = ((b) kVar).kLv;
            if (this.hdo != null) {
                this.kTW = this.hdo.kPm;
            }
            b(this.hdo);
            v.d("MicroMsg.WalletIbgOrderInfoUI", "Coomdity:" + this.kTW);
            if (!(this.kTW == null || this.kTW.size() == 0)) {
                Commodity commodity = (Commodity) this.kTW.get(0);
                v.d("MicroMsg.WalletIbgOrderInfoUI", "Coomdity:" + commodity.toString());
                ak.yW();
                u LX = c.wH().LX(commodity.hNh);
                if (LX == null || ((int) LX.chr) == 0) {
                    a.crZ.a(commodity.hNh, "", this.kUh);
                } else {
                    G(LX);
                }
            }
            this.kTX.notifyDataSetChanged();
            bhb();
            return true;
        }
        setResult(0);
        return false;
    }
}
