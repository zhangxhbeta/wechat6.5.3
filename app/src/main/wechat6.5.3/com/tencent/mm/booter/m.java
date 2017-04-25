package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.v;

public final class m {
    public static void run() {
        int i = j.sU().getInt("EnableMMBitmapFactoryProb", 0);
        ak.yW();
        int aq = h.aq(c.ww(), 100);
        boolean z = b.bsI() || (i > 0 && aq >= 0 && aq <= i);
        MMBitmapFactory.setUseMMBitmapFactory(z);
        v.i("MicroMsg.PostTaskUpdateMMImgDecSwitch", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", Integer.valueOf(aq), Integer.valueOf(i), Boolean.valueOf(z));
    }
}
