package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;

public final class j {
    public static void run() {
        int i = com.tencent.mm.h.j.sU().getInt("EnableForgroundService", 0);
        ak.yW();
        int aq = h.aq(c.ww(), MMGIFException.D_GIF_ERR_OPEN_FAILED);
        boolean z = b.bsI() || (i > 0 && aq >= 0 && aq <= i);
        if (!z) {
            z = d.lWk;
        }
        if (!z) {
            z = b.bsI();
        }
        if (f.aPW == 1) {
            z = false;
        }
        aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", z).commit();
        v.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", Integer.valueOf(aq), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(d.lWk), Integer.valueOf(f.aPW));
    }
}
