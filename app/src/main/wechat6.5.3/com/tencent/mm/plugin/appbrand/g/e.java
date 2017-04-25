package com.tencent.mm.plugin.appbrand.g;

import java.util.HashMap;

public final class e {
    public HashMap<String, c> dMl;

    private static class a {
        private static e dMx = new e();
    }

    private e() {
        this.dMl = new HashMap();
    }

    public final c nN(String str) {
        if (this.dMl.containsKey(str)) {
            return (c) this.dMl.get(str);
        }
        return null;
    }
}
