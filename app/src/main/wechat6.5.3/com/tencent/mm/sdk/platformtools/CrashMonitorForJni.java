package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.sdk.b.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map.Entry;

public class CrashMonitorForJni {
    private static final String TAG = "MicroMsg.CrashMonitorForJni";

    public static native void setClientVersionMsg(String str);

    private static void OnCrash(int i, int i2, String str) {
        new StringBuilder("OnCrash sig:").append(i).append("  stack:").append(str);
        b.h(i, str);
    }

    private static CharSequence getAllThreadJavaStack() {
        CharSequence stringBuilder = new StringBuilder(8192);
        CharSequence stringBuilder2 = new StringBuilder(2048);
        for (Entry entry : Thread.getAllStackTraces().entrySet()) {
            Thread thread = (Thread) entry.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
            stringBuilder2.setLength(0);
            stringBuilder2.append("\n (").append(thread.getId()).append(") [").append(thread.getName()).append("] ************\n");
            int i = 0;
            for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
                if (stackTraceElementArr[i2].toString().startsWith("com.tencent.mm.")) {
                    i = 1;
                }
                stringBuilder2.append("\tat ").append(stackTraceElementArr[i2].toString()).append("\n");
            }
            if (i != 0) {
                stringBuilder.append(stringBuilder2);
            }
        }
        return stringBuilder;
    }

    public static String getCrashThreadJavaStack() {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Throwable th = new Throwable("\n******* Java stack for JNI crash *******");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length > 1) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length - 1)];
            for (int i = 0; i < stackTraceElementArr.length; i++) {
                stackTraceElementArr[i] = stackTrace[i + 1];
            }
            th.setStackTrace(stackTraceElementArr);
        }
        th.printStackTrace(printWriter);
        printWriter.append(getAllThreadJavaStack());
        printWriter.append('\n');
        return stringWriter.toString();
    }
}
