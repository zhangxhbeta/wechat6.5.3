package com.tencent.mm.pluginsdk.downloader;

import com.tencent.mm.pluginsdk.downloader.a.a;

public final class b extends a {
    private static b lyt = null;
    public final a lyu = new a();
    private long lyv = 0;

    private b() {
    }

    public static b bmF() {
        if (lyt == null) {
            synchronized (b.class) {
                lyt = new b();
            }
        }
        return lyt;
    }
}
