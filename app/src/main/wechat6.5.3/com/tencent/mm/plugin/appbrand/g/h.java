package com.tencent.mm.plugin.appbrand.g;

import java.util.HashMap;

public final class h {
    public HashMap<String, f> dMl;

    private static class a {
        private static h dME = new h();
    }

    private h() {
        this.dMl = new HashMap();
    }

    public final f nO(String str) {
        if (this.dMl.containsKey(str)) {
            return (f) this.dMl.get(str);
        }
        return null;
    }
}
