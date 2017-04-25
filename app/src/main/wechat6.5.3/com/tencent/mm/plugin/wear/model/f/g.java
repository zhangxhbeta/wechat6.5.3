package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.model.m;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.io.IOException;

public final class g extends b {
    private at bmk;

    public g(at atVar) {
        this.bmk = atVar;
    }

    protected final void send() {
        bhn com_tencent_mm_protocal_c_bhn = new bhn();
        String str = this.bmk.field_content;
        if (str != null) {
            a B = a.B(str, this.bmk.field_reserved);
            if (B.cpK.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                com_tencent_mm_protocal_c_bhn.ncz = this.bmk.field_msgId;
                com_tencent_mm_protocal_c_bhn.ncy = this.bmk.field_talker;
                str = this.bmk.field_isSend == 1 ? B.cpE : B.cpD;
                com_tencent_mm_protocal_c_bhn.aXz = h.DM(this.bmk.field_talker);
                if (m.dE(this.bmk.field_talker)) {
                    String c = b.c(this.bmk.field_talker, this.bmk);
                    com_tencent_mm_protocal_c_bhn.hQP = String.format(aa.getContext().getString(2131234089), new Object[]{h.DM(c), Character.valueOf('​'), str});
                } else {
                    com_tencent_mm_protocal_c_bhn.hQP = str;
                }
                try {
                    com.tencent.mm.plugin.wear.model.a.bhH();
                    r.a(20014, com_tencent_mm_protocal_c_bhn.toByteArray(), true);
                    com.tencent.mm.plugin.wear.model.c.a.cL(10, 0);
                    com.tencent.mm.plugin.wear.model.c.a.sy(10);
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            v.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
            return;
        }
        v.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
    }

    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
