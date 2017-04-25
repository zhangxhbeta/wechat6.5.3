package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.aa.a.a.g;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.vending.g.b;

public final class d implements e {
    private static int dse = 20;
    private static int dsf = 20;
    private static int dsg = 20;
    private static long dsh = 4000000;
    private static long dsi = 200000;
    b dsa;
    public String dsj = "";
    public String dsk = "";

    private d(String str, String str2) {
        this.dsj = str;
        this.dsk = str2;
    }

    public static int Nt() {
        ak.yW();
        return ((Integer) c.vf().get(a.ntr, Integer.valueOf(dse))).intValue();
    }

    public static int Nu() {
        ak.yW();
        return ((Integer) c.vf().get(a.ntt, Integer.valueOf(dsg))).intValue();
    }

    public static long Nv() {
        ak.yW();
        return ((Long) c.vf().get(a.ntv, Long.valueOf(dsi))).longValue();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            m mVar = ((g) kVar).dsS;
            v.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[]{Integer.valueOf(mVar.hKq), mVar.hKr, Integer.valueOf(mVar.lYH), Integer.valueOf(mVar.lYI), Integer.valueOf(mVar.lYJ), Long.valueOf(mVar.lYK), Long.valueOf(mVar.lYL), mVar.hbX, mVar.irN});
            if (mVar.hKq == 0) {
                ak.yW();
                c.vf().a(a.ntr, Integer.valueOf(mVar.lYH));
                ak.yW();
                c.vf().a(a.nts, Integer.valueOf(mVar.lYI));
                ak.yW();
                c.vf().a(a.ntt, Integer.valueOf(mVar.lYJ));
                ak.yW();
                c.vf().a(a.ntu, Long.valueOf(mVar.lYK));
                ak.yW();
                c.vf().a(a.ntv, Long.valueOf(mVar.lYL));
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 33, 1, false);
                com.tencent.mm.vending.g.g.a(this.dsa, new Object[]{new d(mVar.irN, mVar.hbX)});
                return;
            }
            com.tencent.mm.vending.g.g.bKJ().bo(Boolean.valueOf(false));
            com.tencent.mm.plugin.report.service.g.iuh.a(407, 35, 1, false);
            return;
        }
        com.tencent.mm.vending.g.g.bKJ().bo(Boolean.valueOf(false));
        com.tencent.mm.plugin.report.service.g.iuh.a(407, 34, 1, false);
    }
}
