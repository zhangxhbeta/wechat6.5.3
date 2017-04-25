package com.tencent.mars.xlog;

import com.tencent.mm.sdk.platformtools.v.a;
import com.tencent.mm.sdk.platformtools.w;

public class Xlog implements a {
    public static final int AppednerModeAsync = 0;
    public static final int AppednerModeSync = 1;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    public static w logDecryptor;

    static class XLoggerInfo {
        public String filename;
        public String funcname;
        public int level;
        public int line;
        public long maintid;
        public long pid;
        public String tag;
        public long tid;

        XLoggerInfo() {
        }
    }

    public static native void appenderOpen(int i, int i2, String str, String str2, String str3);

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static native void logWrite2(int i, String str, String str2, String str3, int i2, int i3, long j, long j2, String str4);

    public static native void setAppenderMode(int i);

    public static native void setConsoleLogOpen(boolean z);

    public static native void setLogLevel(int i);

    public native void appenderClose();

    public native void appenderFlush(boolean z);

    public native int getLogLevel();

    public static void open(boolean z, int i, int i2, String str, String str2, String str3) {
        if (z) {
            System.loadLibrary("tencentxlog");
        }
        appenderOpen(i, i2, str, str2, str3);
    }

    private static String decryptTag(String str) {
        if (logDecryptor == null) {
            return str;
        }
        w wVar = logDecryptor;
        switch (str.charAt(0) ^ 56506) {
            case 9030:
                return wVar.bF(str, str.length());
            case 56475:
                return wVar.nip.decryptTag(str);
            default:
                return str;
        }
    }

    public void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(0, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }

    public void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(1, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }

    public void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(2, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }

    public void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(3, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }

    public void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(4, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }

    public void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(5, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }
}
