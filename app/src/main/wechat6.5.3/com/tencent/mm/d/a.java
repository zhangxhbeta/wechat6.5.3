package com.tencent.mm.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import dalvik.system.PathClassLoader;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static boolean aWb = false;
    private static String aWc;
    private static String aWd;
    private static String aWe;
    private static Set<a> aWf;
    private static final boolean aWg = bB(System.getProperty("java.vm.version"));

    private static class a {
        String aWh;
        String aWi;
        String aWj;

        public a(String str, String str2, String str3) {
            this.aWh = str;
            this.aWi = str2;
            this.aWj = str3;
        }
    }

    private static final class b {
        static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method b;
            try {
                b = a.a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                v.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    b = a.a(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    v.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    try {
                        b = a.a(obj, "makePathElements", List.class, File.class, List.class);
                    } catch (NoSuchMethodException e3) {
                        v.e("MicroMsg.MultiDex", "NoSuchMethodException: makePathElements(List,File,List) failure");
                        throw e3;
                    }
                }
            }
            return (Object[]) b.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static /* synthetic */ void a(Object obj, String str, Object[] objArr) {
        Field a = a(obj, str);
        Object[] objArr2 = (Object[]) a.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        a.set(obj, objArr3);
    }

    public static boolean b(Context context, boolean z) {
        v.i("MicroMsg.MultiDex", "install multidex hasinit: %b, force: %b", Boolean.valueOf(aWb), Boolean.valueOf(z));
        if (aWg) {
            v.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return true;
        } else if (aWb) {
            return true;
        } else {
            if (context.getClassLoader() != null) {
                v.i("MicroMsg.MultiDex", "classloader: " + context.getClassLoader().toString());
            } else {
                v.e("MicroMsg.MultiDex", "classloader is null");
            }
            long currentTimeMillis = System.currentTimeMillis();
            an(context);
            if (aWf == null || aWf.size() <= 0) {
                return false;
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo == null) {
                    return false;
                }
                aWc = context.getDir("cache", 0).getAbsolutePath();
                aWd = context.getDir("dex", 0).getAbsolutePath();
                aWe = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
                File file = new File(aWd);
                if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                    int size = aWf.size();
                    File file2 = new File(aWc);
                    if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                        v.i("MicroMsg.MultiDex", "install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                        if (z || (file.list().length >= size && file2.list().length >= size)) {
                            ZipFile zipFile = new ZipFile(applicationInfo.sourceDir);
                            for (a aVar : aWf) {
                                v.i("MicroMsg.MultiDex", "prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.aWh, aVar.aWi, aVar.aWj);
                                if (a(aVar)) {
                                    v.i("MicroMsg.MultiDex", "verify dex for check md5: targetFilePath: [%s] time: %d", aVar.aWh, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                } else if (!z) {
                                    v.e("MicroMsg.MultiDex", "non-force and targetDexFile md5 mismatch: %s", aVar.aWh);
                                    return false;
                                } else if (!a(zipFile, aVar)) {
                                    throw new Exception("overwriteLocalSecondaryDexFromApk fail");
                                }
                            }
                            List arrayList = new ArrayList(aWf.size());
                            for (a aVar2 : aWf) {
                                arrayList.add(new File(aWd + "/" + aVar2.aWh));
                            }
                            a(context, aWc, arrayList);
                            aWb = true;
                            v.i("MicroMsg.MultiDex", "install done");
                            return true;
                        }
                        v.w("MicroMsg.MultiDex", "just return load later force:%b", Boolean.valueOf(z));
                        return false;
                    }
                    v.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dexopt directory failed");
                    return false;
                }
                v.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dex directory failed");
                return false;
            } catch (Throwable th) {
                Throwable th2 = th;
                v.e("MicroMsg.MultiDex", "Multidex installation failure", th2);
                v.a("MicroMsg.MultiDex", th2, "Multidex installation failure", new Object[0]);
                long j = 0;
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
                    currentTimeMillis = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
                } catch (Exception e) {
                    currentTimeMillis = 0;
                    v.e("MicroMsg.MultiDex", "get db spare space error");
                }
                v.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(j), Long.valueOf(currentTimeMillis));
                if (currentTimeMillis != 0 && j < 31457280) {
                    String p = d.p(context, Process.myPid());
                    v.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", p, Long.valueOf(j), Long.valueOf(31457280));
                    if (!(p.equals(SQLiteDatabase.KeyEmpty) || p.endsWith(":nospace"))) {
                        Intent intent = new Intent();
                        intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        context.startActivity(intent);
                        int myPid = Process.myPid();
                        com.tencent.recovery.b.yH(13);
                        Process.killProcess(myPid);
                    }
                }
                RuntimeException runtimeException = new RuntimeException("Multi dex installation failed (" + th2.getMessage() + ").", th2);
            }
        }
    }

    private static boolean a(ZipFile zipFile, a aVar) {
        File file = new File(aWe);
        String str = aWd + "/" + aVar.aWh;
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            shareFileLockHelper = ShareFileLockHelper.M(file);
            v.i("MicroMsg.MultiDex", "extract dex waiting for write lock cost %dms on file: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), aWe);
            Closeable inputStream = zipFile.getInputStream(zipFile.getEntry(aVar.aWh));
            BufferedOutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.close();
                c(inputStream);
                v.i("MicroMsg.MultiDex", "extract dex from apk done: %s", aWe);
                try {
                    shareFileLockHelper.close();
                    return true;
                } catch (Throwable e) {
                    v.a("MicroMsg.MultiDex", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return true;
                }
            } catch (Throwable th) {
                c(inputStream);
            }
        } catch (Throwable e2) {
            try {
                v.a("MicroMsg.MultiDex", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.MultiDex", "overwrite local secondary dex failed, cannot lock file: %s", file.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.MultiDex", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e3) {
                        v.a("MicroMsg.MultiDex", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
        }
    }

    private static boolean bB(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        v.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static boolean a(a aVar) {
        ShareFileLockHelper M;
        Closeable fileInputStream;
        Throwable e;
        ShareFileLockHelper shareFileLockHelper = null;
        String str = aWd + "/" + aVar.aWh;
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            File file2 = new File(aWe);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                M = ShareFileLockHelper.M(file2);
                try {
                    v.i("MicroMsg.MultiDex", "extract dex waiting for verify lock cost %dms on file: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), aWe);
                    fileInputStream = new FileInputStream(str);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                    shareFileLockHelper = M;
                    try {
                        v.a("MicroMsg.MultiDex", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                        if (shareFileLockHelper != null) {
                            try {
                                shareFileLockHelper.close();
                            } catch (Exception e3) {
                                v.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        c(fileInputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        M = shareFileLockHelper;
                        if (M != null) {
                            try {
                                M.close();
                            } catch (Exception e4) {
                                v.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        c(fileInputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (M != null) {
                        M.close();
                    }
                    c(fileInputStream);
                    throw e;
                }
                try {
                    str = g.a(fileInputStream, 102400);
                    if (str == null || !str.equalsIgnoreCase(aVar.aWi)) {
                        try {
                            M.close();
                        } catch (Exception e5) {
                            v.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                        c(fileInputStream);
                        return false;
                    }
                    try {
                        M.close();
                    } catch (Exception e6) {
                        v.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                    }
                    c(fileInputStream);
                    return true;
                } catch (IOException e7) {
                    e = e7;
                    shareFileLockHelper = M;
                    v.a("MicroMsg.MultiDex", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                    if (shareFileLockHelper != null) {
                        shareFileLockHelper.close();
                    }
                    c(fileInputStream);
                    return false;
                } catch (Throwable th3) {
                    e = th3;
                    if (M != null) {
                        M.close();
                    }
                    c(fileInputStream);
                    throw e;
                }
            } catch (IOException e8) {
                e = e8;
                fileInputStream = null;
                v.a("MicroMsg.MultiDex", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    shareFileLockHelper.close();
                }
                c(fileInputStream);
                return false;
            } catch (Throwable th4) {
                e = th4;
                fileInputStream = null;
                M = null;
                if (M != null) {
                    M.close();
                }
                c(fileInputStream);
                throw e;
            }
        }
        v.i("MicroMsg.MultiDex", "dex file not exist: %s", str);
        return false;
    }

    private static void a(Context context, String str, List<File> list) {
        Object obj = (PathClassLoader) context.getClassLoader();
        v.i("MicroMsg.MultiDex", "before reflectPathClassLoader for debug: ClassLoader " + obj);
        Collections.sort(list, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file == null || file2 == null) {
                    return 0;
                }
                String name = file.getName();
                String name2 = file2.getName();
                return (name.contains("classes") && name2.contains("classes")) ? name.charAt(7) - name2.charAt(7) : 0;
            }
        });
        for (File name : list) {
            v.i("MicroMsg.MultiDex", "real reflectPathClassLoader dexname: " + name.getName());
        }
        File name2 = new File(str);
        if (!list.isEmpty()) {
            Object obj2;
            if (VERSION.SDK_INT >= 19) {
                obj2 = a(obj, "pathList").get(obj);
                ArrayList arrayList = new ArrayList();
                a(obj2, "dexElements", b.a(obj2, new ArrayList(list), name2, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        v.w("MicroMsg.MultiDex", "Exception in makeDexElement", (IOException) it.next());
                        throw ((IOException) it.next());
                    }
                }
            }
            obj2 = a(obj, "pathList").get(obj);
            ArrayList arrayList2 = new ArrayList(list);
            a(obj2, "dexElements", (Object[]) a(obj2, "makeDexElements", ArrayList.class, File.class).invoke(obj2, new Object[]{arrayList2, name2}));
        }
        v.i("MicroMsg.MultiDex", "after reflectPathClassloader for debug: ClassLoader " + obj);
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                v.w("MicroMsg.MultiDex", "Failed to close resource", e);
            }
        }
    }

    private static int an(Context context) {
        if (aWf != null) {
            v.w("MicroMsg.MultiDex", "preloaded dex files not empty, skipped preloading");
            return 1;
        }
        try {
            Set set;
            String e = d.e(context.getAssets().open("secondary-program-dex-jars/metadata.txt"));
            if (e == null || e.length() <= 0) {
                set = null;
            } else {
                set = new HashSet();
                for (String str : e.split("\n")) {
                    if (str != null && str.length() > 0) {
                        String[] split = str.split(" ", 3);
                        if (split != null && split.length >= 3) {
                            String trim = split[0].trim();
                            v.i("MicroMsg.MultiDex", "try parse dexname: %s, dexmd5:%s, classname:%s", trim, split[1].trim(), split[2].trim());
                            if (trim != null && trim.length() > 0) {
                                set.add(new a(trim, r7, str));
                            }
                        }
                    }
                }
            }
            aWf = set;
        } catch (Throwable e2) {
            v.e("MicroMsg.MultiDex", "load preload libraries failed");
            v.a("MicroMsg.MultiDex", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return 0;
    }

    private static Field a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method a(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }
}
