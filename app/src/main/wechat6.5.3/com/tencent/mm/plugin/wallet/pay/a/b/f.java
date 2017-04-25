package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class f extends d {
    public f(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int zg() {
        return 1688;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_tf_qrcodeusebindquery";
    }
}
