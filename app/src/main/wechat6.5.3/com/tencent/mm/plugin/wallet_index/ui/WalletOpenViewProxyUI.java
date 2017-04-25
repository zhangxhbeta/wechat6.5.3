package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletOpenViewProxyUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(8);
        gQ(580);
        if (getIntent() == null) {
            setResult(0);
            finish();
            return;
        }
        p(new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 4));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            setResult(0);
            finish();
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a)) {
            return false;
        } else {
            String stringExtra = getIntent().getStringExtra("packageExt");
            if (!be.kS(stringExtra)) {
                Map hashMap = new HashMap();
                if (!be.kS(stringExtra)) {
                    String[] split = stringExtra.split("&");
                    if (split != null && split.length > 0) {
                        for (int i3 = 0; i3 < split.length; i3++) {
                            if (!be.kS(split[i3])) {
                                String[] split2 = split[i3].split("=");
                                if (split2.length == 2 && !be.kS(split2[0])) {
                                    hashMap.put(split2[0], split2[1]);
                                }
                            }
                        }
                    }
                }
                stringExtra = (String) hashMap.get("openview");
                if ("open_wcpay_biz_view".equals(stringExtra)) {
                    c.w(this.nDR.nEl, "mall", ".ui.MallIndexUI");
                } else if ("open_wcpay_balance_view".equals(stringExtra)) {
                    e.L(this.nDR.nEl, 0);
                } else if ("open_wcpay_order_detail_view".equals(stringExtra)) {
                    Intent intent = new Intent();
                    intent.putExtra("trans_id", (String) hashMap.get("trans_id"));
                    intent.putExtra("scene", 1);
                    if (hashMap.containsKey("bill_id")) {
                        intent.putExtra("bill_id", (String) hashMap.get("bill_id"));
                    }
                    c.b(this.nDR.nEl, "order", ".ui.MallOrderTransactionInfoUI", intent);
                }
            }
            setResult(-1);
            finish();
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        gR(580);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
