package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.plugin.report.kvdata.log_13888;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.v;

public final class t {
    public static void a(PayInfo payInfo, Orders orders) {
        double d = 0.0d;
        log_13888 com_tencent_mm_plugin_report_kvdata_log_13888 = new log_13888();
        com_tencent_mm_plugin_report_kvdata_log_13888.aid_ = payInfo == null ? "" : payInfo.appId;
        com_tencent_mm_plugin_report_kvdata_log_13888.f_ = (int) (orders == null ? 0.0d : orders.kOU * 100.0d);
        com_tencent_mm_plugin_report_kvdata_log_13888.tsf_ = 0;
        if (orders != null) {
            d = orders.iro * 100.0d;
        }
        com_tencent_mm_plugin_report_kvdata_log_13888.ff_ = (int) d;
        com_tencent_mm_plugin_report_kvdata_log_13888.sid_ = "";
        if (!(orders == null || orders.kPm == null || orders.kPm.isEmpty())) {
            com_tencent_mm_plugin_report_kvdata_log_13888.sid_ = ((Commodity) orders.kPm.get(0)).hMU;
        }
        com_tencent_mm_plugin_report_kvdata_log_13888.ps_ = payInfo == null ? 0 : payInfo.bkq;
        v.i("MicroMsg.WalletPayUtil", "oreh aid:%s, fee:%d, def:%d, ff:%d, sid:%s, ps:%d", new Object[]{com_tencent_mm_plugin_report_kvdata_log_13888.aid_, Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.f_), Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.tsf_), Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.ff_), com_tencent_mm_plugin_report_kvdata_log_13888.sid_, Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.ps_)});
        g.iuh.a(13888, com_tencent_mm_plugin_report_kvdata_log_13888);
    }
}
