package com.tencent.wxop.stat;

public enum c {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int a;

    private c(int i) {
        this.a = i;
    }

    public static c zO(int i) {
        for (c cVar : values()) {
            if (i == cVar.a) {
                return cVar;
            }
        }
        return null;
    }
}
