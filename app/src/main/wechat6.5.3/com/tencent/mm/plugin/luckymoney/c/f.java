package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

public final class f {
    private Set<String> hbb = new HashSet();
    private Object lock = new Object();

    public final boolean vY(String str) {
        boolean z = false;
        synchronized (this.lock) {
            if (this.hbb.contains(str)) {
                v.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[]{str});
            } else {
                z = this.hbb.add(str);
            }
        }
        return z;
    }

    public final void vZ(String str) {
        synchronized (this.lock) {
            this.hbb.remove(str);
        }
    }
}
