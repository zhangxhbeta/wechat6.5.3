package com.tencent.mm.compatible.util;

import android.content.Intent;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.compatible.d.z;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class k {
    private static String cgC = null;
    private static boolean cgD = false;
    private static HashMap<String, String> cgE = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    private static class a implements UncaughtExceptionHandler {
        private UncaughtExceptionHandler mParent;

        public a(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            Object obj = 1;
            Object obj2 = ((th instanceof UnsatisfiedLinkError) || ((th instanceof NoSuchMethodError) && th.getMessage().matches(".*sig(nature)?[=:].*"))) ? 1 : null;
            if (obj2 != null) {
                try {
                    k.sq();
                } catch (Exception e) {
                }
                if (obj != null) {
                    th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
                }
                this.mParent.uncaughtException(thread, th);
            }
            obj = null;
            if (obj != null) {
                th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
            }
            this.mParent.uncaughtException(thread, th);
        }
    }

    static /* synthetic */ void sq() {
        List generateAbiList = generateAbiList();
        File dir = aa.getContext().getDir("recover_lib", 0);
        ZipFile zipFile = new ZipFile(aa.getContext().getApplicationInfo().sourceDir);
        try {
            HashSet hashSet = new HashSet();
            Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                Matcher matcher = compile.matcher(((ZipEntry) entries.nextElement()).getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (!hashSet.contains(group)) {
                        extractLibrary(zipFile, group, generateAbiList, new File(dir, "lib" + group + ".so"));
                        hashSet.add(group);
                    }
                }
            }
        } finally {
            zipFile.close();
        }
    }

    private k() {
    }

    public static boolean du(String str) {
        boolean containsKey;
        synchronized (mLoadedLibs) {
            containsKey = mLoadedLibs.containsKey(str);
        }
        return containsKey;
    }

    public static String dv(String str) {
        String str2;
        try {
            ClassLoader classLoader = k.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        File file = new File(aa.getContext().getDir("recover_lib", 0), "lib" + str + ".so");
        if (file.canRead()) {
            return file.getAbsolutePath();
        }
        return str2;
    }

    private static boolean a(String str, ClassLoader classLoader) {
        if (!BaseBuildInfo.vZ()) {
            return false;
        }
        ApplicationLike tinkerApplicationLike;
        String c;
        if (!cgD) {
            tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
            if (tinkerApplicationLike == null) {
                throw new RuntimeException("tinker application is null when try to load from patch libs");
            }
            cgD = true;
            if (tinkerApplicationLike == null || tinkerApplicationLike.getApplication() == null) {
                throw new TinkerRuntimeException("tinkerApplication is null");
            }
            Intent tinkerResultIntent = tinkerApplicationLike.getTinkerResultIntent();
            HashMap ag = (tinkerResultIntent == null || ShareIntentUtil.ac(tinkerResultIntent) != 0) ? null : ShareIntentUtil.ag(tinkerResultIntent);
            cgE = ag;
            c = b.c(tinkerApplicationLike);
            if (ShareTinkerInternals.kS(c)) {
                cgC = null;
            } else {
                cgC = new File(SharePatchFileUtil.go(tinkerApplicationLike.getApplication()).getAbsolutePath() + "/" + SharePatchFileUtil.Qz(c)).getAbsolutePath() + "/lib";
            }
        }
        if (!str.startsWith("lib")) {
            str = "lib" + str;
        }
        if (!str.endsWith(".so")) {
            str = str + ".so";
        }
        String str2 = "lib/armeabi/" + str;
        tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
        if (tinkerApplicationLike == null || tinkerApplicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        if (ShareTinkerInternals.zz(tinkerApplicationLike.getTinkerFlags()) && b.b(tinkerApplicationLike) && cgE != null) {
            for (String c2 : cgE.keySet()) {
                if (c2.equals(str2)) {
                    String str3 = cgC + "/" + c2;
                    File file = new File(str3);
                    if (!file.exists()) {
                        continue;
                    } else if (!tinkerApplicationLike.getTinkerLoadVerifyFlag() || SharePatchFileUtil.c(file, (String) cgE.get(c2))) {
                        try {
                            v.w("MicroMsg.LoadLibrary", "succ load from patch path: %s", str3);
                            reflectSystemLoad(str3, classLoader);
                            synchronized (mLoadedLibs) {
                                mLoadedLibs.put(str, new WeakReference(classLoader));
                            }
                            return true;
                        } catch (InvocationTargetException e) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e.getCause()));
                        } catch (Throwable e2) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e2));
                        }
                    } else {
                        v.e("MicroMsg.LoadLibrary", "loadLibraryFromTinker md5mismatch fail: %s", str3);
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r7, java.lang.ClassLoader r8) {
        /*
        r1 = 0;
        r2 = 0;
        r3 = "libName or callerClassLoader is null";
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        if (r8 != 0) goto L_0x002a;
    L_0x000d:
        r0 = 1;
    L_0x000e:
        junit.framework.Assert.assertFalse(r3, r0);
        r3 = mLoadedLibs;
        monitor-enter(r3);
        r0 = mLoadedLibs;	 Catch:{ all -> 0x0049 }
        r0 = r0.get(r7);	 Catch:{ all -> 0x0049 }
        r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0272;
    L_0x001e:
        r0 = r0.get();	 Catch:{ all -> 0x0049 }
        r0 = (java.lang.ClassLoader) r0;	 Catch:{ all -> 0x0049 }
    L_0x0024:
        if (r0 == 0) goto L_0x004c;
    L_0x0026:
        if (r0 != r8) goto L_0x002c;
    L_0x0028:
        monitor-exit(r3);	 Catch:{ all -> 0x0049 }
    L_0x0029:
        return;
    L_0x002a:
        r0 = r1;
        goto L_0x000e;
    L_0x002c:
        r0 = new java.lang.UnsatisfiedLinkError;	 Catch:{ all -> 0x0049 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0049 }
        r2 = "Library '";
        r1.<init>(r2);	 Catch:{ all -> 0x0049 }
        r1 = r1.append(r7);	 Catch:{ all -> 0x0049 }
        r2 = "' was loaded by a different ClassLoader.";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0049 }
        r1 = r1.toString();	 Catch:{ all -> 0x0049 }
        r0.<init>(r1);	 Catch:{ all -> 0x0049 }
        throw r0;	 Catch:{ all -> 0x0049 }
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0049 }
        throw r0;
    L_0x004c:
        monitor-exit(r3);	 Catch:{ all -> 0x0049 }
        r0 = "MicroMsg.LoadLibrary";
        r3 = new java.lang.StringBuilder;
        r4 = "try load library:";
        r3.<init>(r4);
        r3 = r3.append(r7);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        r0 = a(r7, r8);
        if (r0 != 0) goto L_0x0029;
    L_0x0069:
        r3 = com.tencent.mm.sdk.platformtools.aa.getContext();
        if (r3 == 0) goto L_0x0075;
    L_0x006f:
        r0 = com.tencent.mm.sdk.b.b.bsI();
        if (r0 == 0) goto L_0x00c8;
    L_0x0075:
        reflectSystemLoadlibrary(r7, r8);	 Catch:{ InvocationTargetException -> 0x008a, Exception -> 0x00ab }
        r1 = mLoadedLibs;	 Catch:{ InvocationTargetException -> 0x008a, Exception -> 0x00ab }
        monitor-enter(r1);	 Catch:{ InvocationTargetException -> 0x008a, Exception -> 0x00ab }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x0087 }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0087 }
        r2.<init>(r8);	 Catch:{ all -> 0x0087 }
        r0.put(r7, r2);	 Catch:{ all -> 0x0087 }
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        goto L_0x0029;
    L_0x0087:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        throw r0;	 Catch:{ InvocationTargetException -> 0x008a, Exception -> 0x00ab }
    L_0x008a:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed loading library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x00ab:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed loading library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x00c8:
        r0 = "recover_lib";
        r0 = r3.getDir(r0, r1);
        r4 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r5 = "lib";
        r1.<init>(r5);
        r1 = r1.append(r7);
        r5 = ".so";
        r1 = r1.append(r5);
        r1 = r1.toString();
        r4.<init>(r0, r1);
        r0 = r4.isFile();
        if (r0 == 0) goto L_0x026f;
    L_0x00f1:
        r0 = r4.getAbsolutePath();	 Catch:{ UnsatisfiedLinkError -> 0x010b, InvocationTargetException -> 0x016b, Throwable -> 0x019b }
        reflectSystemLoad(r0, r8);	 Catch:{ UnsatisfiedLinkError -> 0x010b, InvocationTargetException -> 0x016b, Throwable -> 0x019b }
        r1 = mLoadedLibs;	 Catch:{ UnsatisfiedLinkError -> 0x010b, InvocationTargetException -> 0x016b, Throwable -> 0x019b }
        monitor-enter(r1);	 Catch:{ UnsatisfiedLinkError -> 0x010b, InvocationTargetException -> 0x016b, Throwable -> 0x019b }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x0108 }
        r5 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0108 }
        r5.<init>(r8);	 Catch:{ all -> 0x0108 }
        r0.put(r7, r5);	 Catch:{ all -> 0x0108 }
        monitor-exit(r1);	 Catch:{ all -> 0x0108 }
        goto L_0x0029;
    L_0x0108:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0108 }
        throw r0;	 Catch:{ UnsatisfiedLinkError -> 0x010b, InvocationTargetException -> 0x016b, Throwable -> 0x019b }
    L_0x010b:
        r0 = move-exception;
    L_0x010c:
        r4.delete();
        r1 = r0;
    L_0x0110:
        reflectSystemLoadlibrary(r7, r8);	 Catch:{ UnsatisfiedLinkError -> 0x0126, InvocationTargetException -> 0x01b8, Throwable -> 0x01ee }
        r5 = mLoadedLibs;	 Catch:{ UnsatisfiedLinkError -> 0x0126, InvocationTargetException -> 0x01b8, Throwable -> 0x01ee }
        monitor-enter(r5);	 Catch:{ UnsatisfiedLinkError -> 0x0126, InvocationTargetException -> 0x01b8, Throwable -> 0x01ee }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x0123 }
        r6 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0123 }
        r6.<init>(r8);	 Catch:{ all -> 0x0123 }
        r0.put(r7, r6);	 Catch:{ all -> 0x0123 }
        monitor-exit(r5);	 Catch:{ all -> 0x0123 }
        goto L_0x0029;
    L_0x0123:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0123 }
        throw r0;	 Catch:{ UnsatisfiedLinkError -> 0x0126, InvocationTargetException -> 0x01b8, Throwable -> 0x01ee }
    L_0x0126:
        r0 = move-exception;
        if (r1 != 0) goto L_0x026c;
    L_0x0129:
        r1 = r3.getApplicationInfo();	 Catch:{ Exception -> 0x0268, all -> 0x0264 }
        r3 = r1.sourceDir;	 Catch:{ Exception -> 0x0268, all -> 0x0264 }
        r1 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x0268, all -> 0x0264 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0268, all -> 0x0264 }
        r2 = generateAbiList();	 Catch:{ Exception -> 0x0154 }
        r2 = extractLibrary(r1, r7, r2, r4);	 Catch:{ Exception -> 0x0154 }
        if (r2 != 0) goto L_0x020b;
    L_0x013e:
        r0 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x0154 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0154 }
        r3 = "Can't find recover library: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0154 }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x0154 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0154 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0154 }
        throw r0;	 Catch:{ Exception -> 0x0154 }
    L_0x0154:
        r0 = move-exception;
    L_0x0155:
        r2 = new java.lang.UnsatisfiedLinkError;	 Catch:{ all -> 0x0164 }
        r3 = "Failed recovering native library.";
        r2.<init>(r3);	 Catch:{ all -> 0x0164 }
        r0 = r2.initCause(r0);	 Catch:{ all -> 0x0164 }
        r0 = (java.lang.UnsatisfiedLinkError) r0;	 Catch:{ all -> 0x0164 }
        throw r0;	 Catch:{ all -> 0x0164 }
    L_0x0164:
        r0 = move-exception;
    L_0x0165:
        if (r1 == 0) goto L_0x016a;
    L_0x0167:
        r1.close();	 Catch:{ IOException -> 0x0261 }
    L_0x016a:
        throw r0;
    L_0x016b:
        r0 = move-exception;
        r1 = r0.getCause();
        r1 = r1 instanceof java.lang.UnsatisfiedLinkError;
        if (r1 == 0) goto L_0x017b;
    L_0x0174:
        r0 = r0.getCause();
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        goto L_0x010c;
    L_0x017b:
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x019b:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x01b8:
        r0 = move-exception;
        r5 = r0.getCause();
        r5 = r5 instanceof java.lang.UnsatisfiedLinkError;
        if (r5 == 0) goto L_0x01cb;
    L_0x01c1:
        if (r1 != 0) goto L_0x01eb;
    L_0x01c3:
        r0 = r0.getCause();
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        goto L_0x0129;
    L_0x01cb:
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x01eb:
        r0 = r1;
        goto L_0x0129;
    L_0x01ee:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x020b:
        r1.close();	 Catch:{ IOException -> 0x025f }
    L_0x020e:
        r1 = r4.getAbsolutePath();	 Catch:{ InvocationTargetException -> 0x0228, Exception -> 0x024c }
        reflectSystemLoad(r1, r8);	 Catch:{ InvocationTargetException -> 0x0228, Exception -> 0x024c }
        r2 = mLoadedLibs;	 Catch:{ InvocationTargetException -> 0x0228, Exception -> 0x024c }
        monitor-enter(r2);	 Catch:{ InvocationTargetException -> 0x0228, Exception -> 0x024c }
        r1 = mLoadedLibs;	 Catch:{ all -> 0x0225 }
        r3 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0225 }
        r3.<init>(r8);	 Catch:{ all -> 0x0225 }
        r1.put(r7, r3);	 Catch:{ all -> 0x0225 }
        monitor-exit(r2);	 Catch:{ all -> 0x0225 }
        goto L_0x0029;
    L_0x0225:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0225 }
        throw r1;	 Catch:{ InvocationTargetException -> 0x0228, Exception -> 0x024c }
    L_0x0228:
        r1 = move-exception;
        if (r0 != 0) goto L_0x024b;
    L_0x022b:
        r0 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r0.<init>(r2);
        r1 = r1.getCause();
        r0 = r0.initCause(r1);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x024b:
        throw r0;
    L_0x024c:
        r1 = move-exception;
        if (r0 != 0) goto L_0x025e;
    L_0x024f:
        r0 = new java.lang.UnsatisfiedLinkError;
        r2 = "Failed recovering native library.";
        r0.<init>(r2);
        r0 = r0.initCause(r1);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x025e:
        throw r0;
    L_0x025f:
        r1 = move-exception;
        goto L_0x020e;
    L_0x0261:
        r1 = move-exception;
        goto L_0x016a;
    L_0x0264:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0165;
    L_0x0268:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0155;
    L_0x026c:
        r0 = r1;
        goto L_0x0129;
    L_0x026f:
        r1 = r2;
        goto L_0x0110;
    L_0x0272:
        r0 = r2;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.util.k.b(java.lang.String, java.lang.ClassLoader):void");
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    private static void reflectSystemLoadlibrary(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    private static List<String> generateAbiList() {
        List arrayList = new ArrayList(3);
        String str = z.get("ro.product.cpu.abi");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        str = z.get("ro.product.cpu.abi2");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        if (file.isFile()) {
            return true;
        }
        for (String str2 : list) {
            ZipEntry entry = zipFile.getEntry("lib/" + str2 + "/lib" + str + ".so");
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } finally {
                        inputStream.close();
                        fileOutputStream.close();
                    }
                }
                file.setReadOnly();
                return true;
            }
        }
        return false;
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
    }
}
