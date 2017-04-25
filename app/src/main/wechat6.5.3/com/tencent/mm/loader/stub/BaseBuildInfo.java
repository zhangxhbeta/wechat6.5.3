package com.tencent.mm.loader.stub;

import android.os.Build.VERSION;

public class BaseBuildInfo {
    private static String cmT = "true";
    public static String cmU = "d251b07e1b27e9ad27c6e8b98cac9640630b2dae";
    public static String cmV = "0x26050341";
    public static String cmW = ("android-" + VERSION.SDK_INT);
    public static String cmX = "2017-01-05 23:43:02";
    public static String cmY = "null";
    public static String cmZ = "MicroMessenger_Android_GIT_RELEASE_GRADLE #2223";
    public static String cna = "amm_code_helper";
    public static String cnb = "null";
    public static String cnc = "origin/RB-2016-OCT@git";
    public static String cnd = null;
    public static int cne = 7;

    public static String vX() {
        return cnd == null ? cmU : cmU + "." + cnd;
    }

    public static String vY() {
        return cmU;
    }

    public static boolean vZ() {
        return !"false".equalsIgnoreCase(cmT);
    }
}
