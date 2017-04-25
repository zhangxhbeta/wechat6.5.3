package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.sdk.platformtools.aa;
import java.io.IOException;

public final class e extends c {
    protected final void send() {
        int size = ((d) g.f(d.class)).azI().bwW().size();
        bhf com_tencent_mm_protocal_c_bhf = new bhf();
        com_tencent_mm_protocal_c_bhf.gof = a.bhH().laT.DH(k.xF()).id;
        com_tencent_mm_protocal_c_bhf.aXz = aa.getContext().getString(2131230720);
        com_tencent_mm_protocal_c_bhf.hQP = aa.getContext().getString(2131234067, new Object[]{Integer.valueOf(size)});
        try {
            a.bhH();
            r.a(20005, com_tencent_mm_protocal_c_bhf.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
