package com.tencent.mars.xlog;

public class LogLogic {
    public static native int getAppenderModeFromCfg();

    public static native int getIPxxLogLevel();

    public static native int getLogLevelFromCfg();

    public static native void initIPxxLogInfo();

    public static native void setIPxxLogML(int i, int i2);
}
