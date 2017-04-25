package com.tencent.mm.pluginsdk.j;

import com.tencent.mm.sdk.b.b;
import java.util.concurrent.ConcurrentHashMap;

public final class m {
    public static m lCK = new m("default");
    private boolean gMt = false;
    private ConcurrentHashMap<String, Integer> lCH = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Long> lCI = new ConcurrentHashMap();
    private String lCJ = "";

    public m(String str) {
        if (b.bsI()) {
            this.gMt = true;
        }
        this.lCJ = str;
    }

    public final void GW(String str) {
        if (this.gMt) {
            int intValue;
            long longValue;
            if (this.lCH.containsKey(str)) {
                intValue = ((Integer) this.lCH.get(str)).intValue();
            } else {
                intValue = 0;
            }
            int i = intValue + 1;
            this.lCH.put(str, Integer.valueOf(i));
            if (this.lCI.containsKey(str)) {
                longValue = ((Long) this.lCI.get(str)).longValue();
            } else {
                longValue = 0;
            }
            if (System.currentTimeMillis() - longValue > 1000) {
                new StringBuilder().append(this.lCJ).append("user get fps ").append(i).append(" fpswraper: ").append(str);
                this.lCH.put(str, Integer.valueOf(0));
                this.lCI.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
