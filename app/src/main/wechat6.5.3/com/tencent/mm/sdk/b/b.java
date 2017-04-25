package com.tencent.mm.sdk.b;

public final class b {
    public static boolean foreground = false;
    public static String nhm = "unknow";
    private static c nhn = null;
    private static boolean nho = false;
    private static String nhp = null;
    private static boolean nhq = false;

    public static void a(c cVar) {
        nhn = cVar;
    }

    public static void r(String str, String str2) {
        if (nhn != null) {
            nhn.r(str, str2);
        }
    }

    public static void h(int i, String str) {
        if (nhn != null) {
            nhn.h(i, str);
        }
    }

    public static void aR(boolean z) {
        foreground = z;
    }

    public static void JO(String str) {
        nhm = str;
    }

    public static void a(a aVar) {
        if (nhn != null) {
            nhn.a(aVar);
        }
    }

    public static void iu(boolean z) {
        nhq = z;
    }

    public static boolean bsG() {
        return nhq;
    }

    public static void bsH() {
        nho = true;
    }

    public static boolean bsI() {
        return nho;
    }

    public static void JP(String str) {
        nhp = str;
    }

    public static String bsJ() {
        return nhp;
    }
}
