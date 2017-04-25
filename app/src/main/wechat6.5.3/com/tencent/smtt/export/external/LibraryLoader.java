package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader {
    private static String[] sLibrarySearchPaths = null;

    public static String[] getLibrarySearchPaths(Context context) {
        if (sLibrarySearchPaths != null) {
            return sLibrarySearchPaths;
        }
        if (context == null) {
            return new String[]{"/system/lib"};
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getNativeLibraryDir(context));
        arrayList.add("/system/lib");
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        sLibrarySearchPaths = strArr;
        return strArr;
    }

    public static String getNativeLibraryDir(Context context) {
        int i = VERSION.SDK_INT;
        return i >= 9 ? context.getApplicationInfo().nativeLibraryDir : i >= 4 ? context.getApplicationInfo().dataDir + "/lib" : "/data/data/" + context.getPackageName() + "/lib";
    }

    public static void loadLibrary(Context context, String str) {
        String[] librarySearchPaths = getLibrarySearchPaths(context);
        String mapLibraryName = System.mapLibraryName(str);
        for (String str2 : librarySearchPaths) {
            String str22 = str22 + "/" + mapLibraryName;
            if (new File(str22).exists()) {
                try {
                    System.load(str22);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
        }
        try {
            System.loadLibrary(str);
        } catch (Exception e2) {
        }
    }
}
