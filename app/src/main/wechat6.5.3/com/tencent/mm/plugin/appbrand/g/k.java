package com.tencent.mm.plugin.appbrand.g;

import java.util.HashMap;

public final class k {
    public HashMap<String, j> dMl;

    private static class a {
        private static k dMK = new k();
    }

    private k() {
        this.dMl = new HashMap();
    }

    public final j nR(String str) {
        if (this.dMl.containsKey(str)) {
            return (j) this.dMl.get(str);
        }
        return null;
    }

    public final boolean nS(String str) {
        if (!this.dMl.containsKey(str)) {
            return false;
        }
        ((j) this.dMl.remove(str)).QS();
        return true;
    }
}
