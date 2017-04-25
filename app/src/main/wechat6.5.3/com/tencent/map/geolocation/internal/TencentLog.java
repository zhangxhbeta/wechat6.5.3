package com.tencent.map.geolocation.internal;

import org.eclipse.jdt.annotation.NonNull;

public interface TencentLog {
    public static final String LOGNAME = "txwatchdog";
    public static final String PREFIX = "txwatchdog_";

    String getDirString();

    void println(String str, int i, @NonNull String str2);
}
