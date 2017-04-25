package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.e.a.cb;
import com.tencent.mm.sdk.c.a;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private cb fcQ = new cb();
    public final Map<String, Integer> fcR = new HashMap();

    public final void d(String str, int i, int i2, String str2) {
        this.fcQ.aZC.aZD = str;
        this.fcQ.aZC.status = i;
        this.fcQ.aZC.progress = i2;
        this.fcQ.aZC.aZE = str2;
        a.nhr.z(this.fcQ);
        if (i != 6) {
            this.fcR.remove(str);
        } else if (i2 < 0 || i2 >= 100) {
            this.fcR.remove(str);
        } else {
            this.fcR.put(str, Integer.valueOf(i2));
        }
    }
}
