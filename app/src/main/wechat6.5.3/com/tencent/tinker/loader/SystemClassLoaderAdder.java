package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

public class SystemClassLoaderAdder {
    private static int pGn = 0;

    private static final class V14 {
        private V14() {
        }

        static /* synthetic */ void a(ClassLoader classLoader, List list, File file) {
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList(list);
            ShareReflectUtil.b(obj, "dexElements", (Object[]) ShareReflectUtil.a(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file}));
        }
    }

    private static final class V19 {
        private V19() {
        }

        static /* synthetic */ void b(ClassLoader classLoader, List list, File file) {
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.b(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw ((IOException) it.next());
                }
            }
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method a;
            try {
                a = ShareReflectUtil.a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                try {
                    a = ShareReflectUtil.a(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    throw e2;
                }
            }
            return (Object[]) a.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class V23 {
        private V23() {
        }

        static /* synthetic */ void c(ClassLoader classLoader, List list, File file) {
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.b(obj, "dexElements", c(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw ((IOException) it.next());
                }
            }
        }

        private static Object[] c(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method a;
            try {
                a = ShareReflectUtil.a(obj, "makePathElements", List.class, File.class, List.class);
            } catch (NoSuchMethodException e) {
                try {
                    a = ShareReflectUtil.a(obj, "makePathElements", ArrayList.class, File.class, ArrayList.class);
                } catch (NoSuchMethodException e2) {
                    try {
                        return V19.a(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e3) {
                        throw e3;
                    }
                }
            }
            return (Object[]) a.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class V4 {
        private V4() {
        }

        static /* synthetic */ void d(ClassLoader classLoader, List list, File file) {
            int size = list.size();
            Field a = ShareReflectUtil.a((Object) classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) a.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file2 = (File) listIterator.next();
                String absolutePath = file2.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file2;
                zipFileArr[previousIndex] = new ZipFile(file2);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, SharePatchFileUtil.i(file2, file), 0);
            }
            a.set(classLoader, stringBuilder.toString());
            ShareReflectUtil.b(classLoader, "mPaths", strArr);
            ShareReflectUtil.b(classLoader, "mFiles", fileArr);
            ShareReflectUtil.b(classLoader, "mZips", zipFileArr);
            try {
                ShareReflectUtil.b(classLoader, "mDexs", dexFileArr);
            } catch (Exception e) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application, PathClassLoader pathClassLoader, File file, List<File> list) {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 24) {
                pathClassLoader = AndroidNClassLoader.a(pathClassLoader, application);
            }
            if (VERSION.SDK_INT >= 23) {
                V23.c(pathClassLoader, list, file);
            } else if (VERSION.SDK_INT >= 19) {
                V19.b(pathClassLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                V14.a(pathClassLoader, list, file);
            } else {
                V4.d(pathClassLoader, list, file);
            }
            pGn = list.size();
            new StringBuilder("after loaded classloader: ").append(pathClassLoader).append(", dex size:").append(pGn);
            if (!((Boolean) ShareReflectUtil.a(Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, pathClassLoader), "isPatch").get(null)).booleanValue()) {
                a(pathClassLoader);
                throw new TinkerRuntimeException("checkDexInstall failed");
            }
        }
    }

    public static void a(ClassLoader classLoader) {
        if (pGn > 0) {
            if (VERSION.SDK_INT >= 14) {
                ShareReflectUtil.a(ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader), "dexElements", pGn);
                return;
            }
            ShareReflectUtil.a((Object) classLoader, "mPaths", pGn);
            ShareReflectUtil.a((Object) classLoader, "mFiles", pGn);
            ShareReflectUtil.a((Object) classLoader, "mZips", pGn);
            try {
                ShareReflectUtil.a((Object) classLoader, "mDexs", pGn);
            } catch (Exception e) {
            }
        }
    }
}
