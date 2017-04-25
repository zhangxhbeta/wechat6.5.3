package com.tencent.mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class XLogSetup {
    public static Boolean appendIsSync;
    public static String cachePath;
    public static boolean hasInit = false;
    public static Boolean isLogcatOpen;
    public static String logPath;
    public static String nameprefix;
    private static boolean setup = false;
    public static Integer toolsLevel;
    public static Xlog xlog = new Xlog();

    public static void realSetupXlog() {
        keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
    }

    public static void keep_setupXLog(boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3) {
        if (!hasInit) {
            PlatformComm.init(aa.getContext(), new ac(Looper.getMainLooper()));
            hasInit = true;
        }
        cachePath = str;
        logPath = str2;
        toolsLevel = num;
        appendIsSync = bool;
        isLogcatOpen = bool2;
        nameprefix = str3;
        if (z && !setup) {
            setup = true;
            k.b(a.nhg, XLogSetup.class.getClassLoader());
            v.a(xlog);
            appendIsSync.booleanValue();
            Xlog.setConsoleLogOpen(isLogcatOpen.booleanValue());
            if (toolsLevel == null) {
                Xlog.appenderOpen(2, 0, cachePath, logPath, nameprefix);
                LogLogic.initIPxxLogInfo();
                return;
            }
            Xlog.appenderOpen(toolsLevel.intValue(), 1, cachePath, logPath, nameprefix);
        }
    }
}
