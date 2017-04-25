package com.tencent.mm.compatible.util;

import android.os.SystemClock;

public final class g {

    public static class a {
        public long cgu = SystemClock.elapsedRealtime();

        public final long sn() {
            return SystemClock.elapsedRealtime() - this.cgu;
        }
    }

    public static int sk() {
        return new Throwable().getStackTrace()[1].getLineNumber();
    }

    public static String sl() {
        return new Throwable().getStackTrace()[1].toString();
    }

    public static String sm() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }
}
