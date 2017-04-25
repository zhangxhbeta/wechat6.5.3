package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.v;

public final class n {
    public static void run() {
        int i = j.sU().getInt("EnableFlockMultiProcSPProb", 0);
        ak.yW();
        int aq = h.aq(c.ww(), MMGIFException.D_GIF_ERR_OPEN_FAILED);
        boolean z = b.bsI() || (i > 0 && aq >= 0 && aq <= i);
        a.setValue(a.njG, z);
        v.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", Integer.valueOf(aq), Integer.valueOf(i), Boolean.valueOf(z));
    }
}
