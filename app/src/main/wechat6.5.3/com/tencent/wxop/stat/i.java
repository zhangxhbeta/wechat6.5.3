package com.tencent.wxop.stat;

final /* synthetic */ class i {
    static final /* synthetic */ int[] a = new int[c.values().length];

    static {
        try {
            a[c.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[c.PERIOD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[c.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[c.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[c.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[c.ONLY_WIFI.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[c.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
