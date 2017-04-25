package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.t.a;

public final class d {
    public static boolean atT() {
        if (!ak.uz()) {
            return false;
        }
        if (j.sU().getInt("WCOEntranceSwitch", 0) > 0) {
            ak.yW();
            c.vf().a(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(true));
            return true;
        }
        ak.yW();
        c.vf().a(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false));
        return false;
    }
}
