package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.ArrayList;

public final class i extends c {
    private ArrayList<Integer> lcq;
    private boolean sI = true;

    public i(ArrayList<Integer> arrayList) {
        this.lcq = arrayList;
    }

    public final String getName() {
        return "WearCancelNotificationTask";
    }

    protected final void send() {
        v.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[]{this.lcq});
        bhv com_tencent_mm_protocal_c_bhv = new bhv();
        if (this.lcq != null) {
            com_tencent_mm_protocal_c_bhv.ncI.addAll(this.lcq);
        }
        com_tencent_mm_protocal_c_bhv.ncJ = this.sI;
        try {
            a.bhH();
            r.a(20004, com_tencent_mm_protocal_c_bhv.toByteArray(), false);
        } catch (IOException e) {
        }
    }
}
