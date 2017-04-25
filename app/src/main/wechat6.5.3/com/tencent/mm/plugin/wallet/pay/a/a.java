package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.d;
import com.tencent.mm.plugin.wallet.pay.a.a.e;
import com.tencent.mm.plugin.wallet.pay.a.a.f;
import com.tencent.mm.plugin.wallet.pay.a.a.g;
import com.tencent.mm.plugin.wallet.pay.a.c.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static b a(Authen authen, Orders orders, boolean z) {
        if (authen == null || orders == null) {
            v.i("MicroMsg.CgiManager", "empty authen or orders");
            return null;
        }
        PayInfo payInfo = authen.imN;
        String str = "";
        if (payInfo != null) {
            v.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.fTG;
        }
        if (be.kS(str) && orders != null) {
            v.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.fTG;
        }
        if (be.kS(str)) {
            v.i("MicroMsg.CgiManager", "empty reqKey!");
            return new b(authen, orders, z);
        }
        v.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[]{str});
        if (!(payInfo == null || orders == null)) {
            v.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fTG, orders.fTG});
        }
        if (!beR()) {
            return new b(authen, orders, z);
        }
        v.i("MicroMsg.CgiManager", "authen go new split cgi");
        if (str.startsWith("sns_aa_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, z);
        }
        if (str.startsWith("sns_tf_")) {
            return new g(authen, orders, z);
        }
        if (str.startsWith("sns_ff_")) {
            return new d(authen, orders, z);
        }
        if (str.startsWith("ts_")) {
            return new e(authen, orders, z);
        }
        if (str.startsWith("sns_")) {
            return new f(authen, orders, z);
        }
        return new b(authen, orders, z);
    }

    public static com.tencent.mm.plugin.wallet.pay.a.c.e a(l lVar, Orders orders) {
        if (lVar == null || orders == null) {
            v.e("MicroMsg.CgiManager", "empty verify or orders");
            return null;
        }
        PayInfo payInfo = lVar.imN;
        String str = "";
        if (payInfo != null) {
            v.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.fTG;
        }
        if (be.kS(str)) {
            v.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.fTG;
        }
        if (be.kS(str)) {
            v.i("MicroMsg.CgiManager", "empty reqKey!");
            return new com.tencent.mm.plugin.wallet.pay.a.c.e(lVar, orders);
        }
        if (payInfo != null) {
            v.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fTG, orders.fTG});
        }
        v.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[]{str});
        if (!beR()) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.e(lVar, orders);
        }
        v.i("MicroMsg.CgiManager", "verify go new split cgi");
        if (str.startsWith("sns_aa_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.a(lVar, orders);
        }
        if (str.startsWith("sns_tf_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.g(lVar, orders);
        }
        if (str.startsWith("sns_ff_")) {
            return new c(lVar, orders);
        }
        if (str.startsWith("ts_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.d(lVar, orders);
        }
        if (str.startsWith("sns_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.f(lVar, orders);
        }
        return new com.tencent.mm.plugin.wallet.pay.a.c.e(lVar, orders);
    }

    public static boolean beR() {
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100162");
        return Ls.isValid() && "1".equals(Ls.buX().get("UseNewPayCgi"));
    }
}
