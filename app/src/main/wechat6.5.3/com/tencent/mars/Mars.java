package com.tencent.mars;

import android.content.Context;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Arrays;

public class Mars {
    private static volatile boolean hasInitialized = false;
    private static ArrayList<String[]> libModules = new ArrayList();

    public static void loadDefaultMarsLibrary() {
        try {
            System.loadLibrary("stlport_shared");
        } catch (Throwable th) {
        }
    }

    public static synchronized void checkLoadedModules(ArrayList<String> arrayList, String str) {
        synchronized (Mars.class) {
            if (arrayList != null) {
                Object obj = new String[0];
                v.i(str, "loaded modules: " + Arrays.toString(arrayList.toArray(obj)));
                Arrays.sort(obj);
                libModules.add(obj);
                int i = 0;
                Object obj2 = 1;
                while (i < libModules.size()) {
                    if (Arrays.equals((Object[]) libModules.get(i), (Object[]) libModules.get(0))) {
                        obj = obj2;
                    } else {
                        obj = null;
                    }
                    i++;
                    obj2 = obj;
                }
                if (obj2 == null) {
                    for (i = 0; i < libModules.size(); i++) {
                        for (int i2 = i + 1; i2 < libModules.size(); i2++) {
                            if (hasInterSection((String[]) libModules.get(i), (String[]) libModules.get(i2))) {
                                obj2 = null;
                            } else {
                                obj2 = 1;
                            }
                            if (obj2 == null) {
                                break;
                            }
                        }
                        if (obj2 == null) {
                            break;
                        }
                    }
                }
                if (obj2 == null) {
                    throw new IllegalStateException("mars lib module custom made error, pls check your *.so.");
                }
            }
        }
    }

    public static void init(Context context, ac acVar) {
        PlatformComm.init(context, acVar);
        hasInitialized = true;
    }

    public static void onCreate(boolean z) {
        if (z && hasInitialized) {
            BaseEvent.onCreate();
        } else if (z) {
            throw new IllegalStateException("function MarsCore.init must be executed before Mars.onCreate when application firststartup.");
        } else {
            BaseEvent.onCreate();
        }
    }

    public static void onDestroy() {
        BaseEvent.onDestroy();
    }

    private static boolean hasInterSection(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        for (Object add2 : strArr2) {
            if (arrayList.contains(add2)) {
                return true;
            }
        }
        return false;
    }
}
