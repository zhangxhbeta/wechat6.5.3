package com.tencent.mm.plugin.luckymoney.sns.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;

public final class a {
    public static int axZ() {
        ak.yW();
        return ((Integer) c.vf().get(com.tencent.mm.storage.t.a.nsg, Integer.valueOf(0))).intValue();
    }

    public static void mz(int i) {
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nsg, Integer.valueOf(i));
        ak.yW();
        c.vf().iB(true);
    }

    public static String aya() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.nsl, "");
    }

    public static String ayb() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.nsm, "");
    }
}
