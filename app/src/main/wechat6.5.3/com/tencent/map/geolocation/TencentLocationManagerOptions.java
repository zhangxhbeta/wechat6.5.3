package com.tencent.map.geolocation;

public class TencentLocationManagerOptions {
    private static boolean a = true;
    private static boolean b = true;

    public static void setLoadLibraryEnabled(boolean z) {
        a = z;
    }

    public static void setGpsFilterEnabled(boolean z) {
        b = z;
    }

    public static boolean isLoadLibraryEnabled() {
        return a;
    }

    public static boolean isGpsFilterEnabled() {
        return b;
    }
}
