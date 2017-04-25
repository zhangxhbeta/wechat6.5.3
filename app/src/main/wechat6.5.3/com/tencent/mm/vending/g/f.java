package com.tencent.mm.vending.g;

final class f {
    private static f phT;
    ThreadLocal<c> phU = new ThreadLocal();

    private f() {
    }

    static {
        phT = null;
        phT = new f();
    }

    public static f bKN() {
        return phT;
    }
}
