package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
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

public final class TVHttpProxyLoadLibrary {
    public static final String ASSETS_LIBRARY_SRC_DIR = "libs/";
    private static Context mContext = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    private static class LibraryBrokenHandler implements UncaughtExceptionHandler {
        private UncaughtExceptionHandler mParent;

        public LibraryBrokenHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            Object obj = 1;
            if ((th instanceof UnsatisfiedLinkError) || ((th instanceof NoSuchMethodError) && th.getMessage().matches(".*sig(nature)?[=:].*"))) {
                int i = 1;
            } else {
                Object obj2 = null;
            }
            if (obj2 != null) {
                try {
                    TVHttpProxyLoadLibrary.extractAllLibraries(TVHttpProxyLoadLibrary.mContext);
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

    private TVHttpProxyLoadLibrary() {
    }

    public static String find(String str, Context context) {
        if (context == null) {
            return null;
        }
        String str2;
        try {
            ClassLoader classLoader = TVHttpProxyLoadLibrary.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        File file = new File(context.getDir("recover_lib", 0), "lib" + str + ".so");
        if (file.canRead()) {
            return file.getAbsolutePath();
        }
        return str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void load(java.lang.String r6, java.lang.ClassLoader r7, android.content.Context r8) {
        /*
        r2 = 0;
        if (r6 == 0) goto L_0x000b;
    L_0x0003:
        r0 = r6.length();
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        if (r7 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        mContext = r8;
        r1 = mLoadedLibs;
        monitor-enter(r1);
        r0 = mLoadedLibs;	 Catch:{ all -> 0x0027 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0027 }
        r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x0245;
    L_0x001b:
        r0 = r0.get();	 Catch:{ all -> 0x0027 }
        r0 = (java.lang.ClassLoader) r0;	 Catch:{ all -> 0x0027 }
    L_0x0021:
        if (r0 == 0) goto L_0x0047;
    L_0x0023:
        if (r0 != r7) goto L_0x002a;
    L_0x0025:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r0 = new java.lang.UnsatisfiedLinkError;	 Catch:{ all -> 0x0027 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0027 }
        r3 = "Library '";
        r2.<init>(r3);	 Catch:{ all -> 0x0027 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0027 }
        r3 = "' was loaded by a different ClassLoader.";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0027 }
        r2 = r2.toString();	 Catch:{ all -> 0x0027 }
        r0.<init>(r2);	 Catch:{ all -> 0x0027 }
        throw r0;	 Catch:{ all -> 0x0027 }
    L_0x0047:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        if (r8 != 0) goto L_0x009d;
    L_0x004a:
        reflectSystemLoadlibrary(r6, r7);	 Catch:{ InvocationTargetException -> 0x005f, Exception -> 0x0080 }
        r1 = mLoadedLibs;	 Catch:{ InvocationTargetException -> 0x005f, Exception -> 0x0080 }
        monitor-enter(r1);	 Catch:{ InvocationTargetException -> 0x005f, Exception -> 0x0080 }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x005c }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x005c }
        r2.<init>(r7);	 Catch:{ all -> 0x005c }
        r0.put(r6, r2);	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        goto L_0x000b;
    L_0x005c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        throw r0;	 Catch:{ InvocationTargetException -> 0x005f, Exception -> 0x0080 }
    L_0x005f:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed loading library: ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x0080:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed loading library: ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x009d:
        r0 = "recover_lib";
        r1 = 0;
        r0 = r8.getDir(r0, r1);
        r3 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r4 = "lib";
        r1.<init>(r4);
        r1 = r1.append(r6);
        r4 = ".so";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r3.<init>(r0, r1);
        r0 = r3.isFile();
        if (r0 == 0) goto L_0x0242;
    L_0x00c7:
        r0 = r3.getAbsolutePath();	 Catch:{ UnsatisfiedLinkError -> 0x00e1, InvocationTargetException -> 0x0141, Throwable -> 0x0171 }
        reflectSystemLoad(r0, r7);	 Catch:{ UnsatisfiedLinkError -> 0x00e1, InvocationTargetException -> 0x0141, Throwable -> 0x0171 }
        r1 = mLoadedLibs;	 Catch:{ UnsatisfiedLinkError -> 0x00e1, InvocationTargetException -> 0x0141, Throwable -> 0x0171 }
        monitor-enter(r1);	 Catch:{ UnsatisfiedLinkError -> 0x00e1, InvocationTargetException -> 0x0141, Throwable -> 0x0171 }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x00de }
        r4 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x00de }
        r4.<init>(r7);	 Catch:{ all -> 0x00de }
        r0.put(r6, r4);	 Catch:{ all -> 0x00de }
        monitor-exit(r1);	 Catch:{ all -> 0x00de }
        goto L_0x000b;
    L_0x00de:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00de }
        throw r0;	 Catch:{ UnsatisfiedLinkError -> 0x00e1, InvocationTargetException -> 0x0141, Throwable -> 0x0171 }
    L_0x00e1:
        r0 = move-exception;
    L_0x00e2:
        r3.delete();
        r1 = r0;
    L_0x00e6:
        reflectSystemLoadlibrary(r6, r7);	 Catch:{ UnsatisfiedLinkError -> 0x00fc, InvocationTargetException -> 0x018e, Throwable -> 0x01c1 }
        r4 = mLoadedLibs;	 Catch:{ UnsatisfiedLinkError -> 0x00fc, InvocationTargetException -> 0x018e, Throwable -> 0x01c1 }
        monitor-enter(r4);	 Catch:{ UnsatisfiedLinkError -> 0x00fc, InvocationTargetException -> 0x018e, Throwable -> 0x01c1 }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x00f9 }
        r5 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x00f9 }
        r5.<init>(r7);	 Catch:{ all -> 0x00f9 }
        r0.put(r6, r5);	 Catch:{ all -> 0x00f9 }
        monitor-exit(r4);	 Catch:{ all -> 0x00f9 }
        goto L_0x000b;
    L_0x00f9:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00f9 }
        throw r0;	 Catch:{ UnsatisfiedLinkError -> 0x00fc, InvocationTargetException -> 0x018e, Throwable -> 0x01c1 }
    L_0x00fc:
        r0 = move-exception;
        if (r1 != 0) goto L_0x023f;
    L_0x00ff:
        r1 = r8.getApplicationInfo();	 Catch:{ Exception -> 0x023b, all -> 0x0237 }
        r4 = r1.sourceDir;	 Catch:{ Exception -> 0x023b, all -> 0x0237 }
        r1 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x023b, all -> 0x0237 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x023b, all -> 0x0237 }
        r2 = generateAbiList();	 Catch:{ Exception -> 0x012a }
        r2 = extractLibrary(r1, r6, r2, r3);	 Catch:{ Exception -> 0x012a }
        if (r2 != 0) goto L_0x01de;
    L_0x0114:
        r0 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x012a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x012a }
        r3 = "Can't find recover library: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x012a }
        r2 = r2.append(r6);	 Catch:{ Exception -> 0x012a }
        r2 = r2.toString();	 Catch:{ Exception -> 0x012a }
        r0.<init>(r2);	 Catch:{ Exception -> 0x012a }
        throw r0;	 Catch:{ Exception -> 0x012a }
    L_0x012a:
        r0 = move-exception;
    L_0x012b:
        r2 = new java.lang.UnsatisfiedLinkError;	 Catch:{ all -> 0x013a }
        r3 = "Failed recovering native library.";
        r2.<init>(r3);	 Catch:{ all -> 0x013a }
        r0 = r2.initCause(r0);	 Catch:{ all -> 0x013a }
        r0 = (java.lang.UnsatisfiedLinkError) r0;	 Catch:{ all -> 0x013a }
        throw r0;	 Catch:{ all -> 0x013a }
    L_0x013a:
        r0 = move-exception;
    L_0x013b:
        if (r1 == 0) goto L_0x0140;
    L_0x013d:
        r1.close();	 Catch:{ IOException -> 0x0232 }
    L_0x0140:
        throw r0;
    L_0x0141:
        r0 = move-exception;
        r1 = r0.getCause();
        r1 = r1 instanceof java.lang.UnsatisfiedLinkError;
        if (r1 == 0) goto L_0x0151;
    L_0x014a:
        r0 = r0.getCause();
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        goto L_0x00e2;
    L_0x0151:
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x0171:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x018e:
        r0 = move-exception;
        r4 = r0.getCause();
        r4 = r4 instanceof java.lang.UnsatisfiedLinkError;
        if (r4 == 0) goto L_0x01a1;
    L_0x0197:
        if (r1 != 0) goto L_0x023f;
    L_0x0199:
        r0 = r0.getCause();
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        goto L_0x00ff;
    L_0x01a1:
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x01c1:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x01de:
        r1.close();	 Catch:{ IOException -> 0x0235 }
    L_0x01e1:
        r1 = r3.getAbsolutePath();	 Catch:{ InvocationTargetException -> 0x01fb, Exception -> 0x021f }
        reflectSystemLoad(r1, r7);	 Catch:{ InvocationTargetException -> 0x01fb, Exception -> 0x021f }
        r2 = mLoadedLibs;	 Catch:{ InvocationTargetException -> 0x01fb, Exception -> 0x021f }
        monitor-enter(r2);	 Catch:{ InvocationTargetException -> 0x01fb, Exception -> 0x021f }
        r1 = mLoadedLibs;	 Catch:{ all -> 0x01f8 }
        r3 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x01f8 }
        r3.<init>(r7);	 Catch:{ all -> 0x01f8 }
        r1.put(r6, r3);	 Catch:{ all -> 0x01f8 }
        monitor-exit(r2);	 Catch:{ all -> 0x01f8 }
        goto L_0x000b;
    L_0x01f8:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x01f8 }
        throw r1;	 Catch:{ InvocationTargetException -> 0x01fb, Exception -> 0x021f }
    L_0x01fb:
        r1 = move-exception;
        if (r0 != 0) goto L_0x021e;
    L_0x01fe:
        r0 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r0.<init>(r2);
        r1 = r1.getCause();
        r0 = r0.initCause(r1);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x021e:
        throw r0;
    L_0x021f:
        r1 = move-exception;
        if (r0 != 0) goto L_0x0231;
    L_0x0222:
        r0 = new java.lang.UnsatisfiedLinkError;
        r2 = "Failed recovering native library.";
        r0.<init>(r2);
        r0 = r0.initCause(r1);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x0231:
        throw r0;
    L_0x0232:
        r1 = move-exception;
        goto L_0x0140;
    L_0x0235:
        r1 = move-exception;
        goto L_0x01e1;
    L_0x0237:
        r0 = move-exception;
        r1 = r2;
        goto L_0x013b;
    L_0x023b:
        r0 = move-exception;
        r1 = r2;
        goto L_0x012b;
    L_0x023f:
        r0 = r1;
        goto L_0x00ff;
    L_0x0242:
        r1 = r2;
        goto L_0x00e6;
    L_0x0245:
        r0 = r2;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.load(java.lang.String, java.lang.ClassLoader, android.content.Context):void");
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
        Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
        String str = (String) method.invoke(null, new Object[]{"ro.product.cpu.abi"});
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        str = (String) method.invoke(null, new Object[]{"ro.product.cpu.abi2"});
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

    private static void extractAllLibraries(Context context) {
        if (context != null) {
            List generateAbiList = generateAbiList();
            File dir = context.getDir("recover_lib", 0);
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
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
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
    }
}
