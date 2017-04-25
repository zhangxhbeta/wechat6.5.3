package com.tencent.mm.plugin.wallet_core.d;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;

public final class c {
    public static long kWX = 0;
    public static int kWY = 2;
    public static int kWZ = 1;
    public static int kXa = 2;

    public static void bhu() {
        kWX = System.currentTimeMillis();
    }

    public static int bhv() {
        return (int) ((System.currentTimeMillis() - kWX) / 1000);
    }

    public static void a(Activity activity, Bundle bundle, int i) {
        b ae = a.ae(activity);
        if (!k.bga().bgv() && ae != null && ae.bKW()) {
            Orders orders = (Orders) bundle.getParcelable("key_orders");
            if (((PayInfo) bundle.getParcelable("key_pay_info")) != null && orders != null) {
                g.iuh.h(10725, new Object[]{Integer.valueOf(i), Integer.valueOf(r0.bkq), Integer.valueOf((int) (orders.kOU * 100.0d)), orders.hNg});
            }
        } else if (!k.bga().bgv() && bundle != null && bundle.getBoolean("key_is_bind_reg_process", false)) {
            g.iuh.h(10932, new Object[]{Integer.valueOf(i), Integer.valueOf(bundle.getInt("key_bind_scene", 0))});
        }
    }

    public static void cK(int i, int i2) {
        g.iuh.h(10932, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    public static void b(PayInfo payInfo, Orders orders) {
        if (!k.bga().bgv() && payInfo != null && orders != null) {
            g.iuh.h(10725, new Object[]{Integer.valueOf(1), Integer.valueOf(payInfo.bkq), Integer.valueOf((int) (orders.kOU * 100.0d)), orders.hNg});
        }
    }
}
