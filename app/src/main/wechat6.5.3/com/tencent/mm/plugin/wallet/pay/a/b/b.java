package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class b extends d {
    public b(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int zg() {
        return 1543;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_ff_qrcodeusebindquery";
    }
}
