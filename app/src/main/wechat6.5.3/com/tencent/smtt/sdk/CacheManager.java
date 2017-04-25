package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.n;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        y bNJ = y.bNJ();
        if (bNJ != null && bNJ.bNK()) {
            return ((Boolean) bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0])).booleanValue();
        }
        Object el = n.el("android.webkit.CacheManager", "cacheDisabled");
        return el == null ? false : ((Boolean) el).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            return null;
        }
        Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, new Object[]{str, Boolean.valueOf(z)});
        return invokeStaticMethod == null ? null : (InputStream) invokeStaticMethod;
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        y bNJ = y.bNJ();
        if (bNJ != null && bNJ.bNK()) {
            return bNJ.bNL().bNN();
        }
        try {
            return n.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[]{String.class, Map.class}, new Object[]{str, map});
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        y bNJ = y.bNJ();
        return (bNJ == null || !bNJ.bNK()) ? (File) n.el("android.webkit.CacheManager", "getCacheFileBaseDir") : (File) bNJ.bNL().bNN();
    }
}
