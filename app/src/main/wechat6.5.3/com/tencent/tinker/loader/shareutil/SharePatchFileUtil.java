package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SharePatchFileUtil {
    public static File go(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker");
    }

    public static File gp(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker_temp");
    }

    public static File gq(Context context) {
        File gp = gp(context);
        if (gp == null) {
            return null;
        }
        return new File(gp, "tinker_last_crash");
    }

    public static File Qx(String str) {
        return new File(str + "/patch.info");
    }

    public static File Qy(String str) {
        return new File(str + "/info.lock");
    }

    public static String Qz(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return "patch-" + str.substring(0, 8);
    }

    public static String QA(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return Qz(str) + ".apk";
    }

    public static boolean QB(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static String gr(Context context) {
        Closeable bufferedReader;
        Object e;
        Throwable th;
        File gq = gq(context);
        if (!N(gq)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(gq)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } else {
                        c(bufferedReader);
                        return stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            try {
                new StringBuilder("checkTinkerLastUncaughtCrash exception: ").append(e);
                c(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                c(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            c(bufferedReader);
            throw th;
        }
    }

    public static final boolean N(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static long O(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j += O(file2);
            } else {
                j += file2.length();
            }
        }
        return j;
    }

    public static final boolean P(File file) {
        boolean z = true;
        if (file != null) {
            new StringBuilder("safeDeleteFile, try to delete path: ").append(file.getPath());
            if (file.exists()) {
                z = file.delete();
                if (!z) {
                    new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(file.getPath());
                    file.deleteOnExit();
                }
            }
        }
        return z;
    }

    public static final boolean QC(String str) {
        if (str == null) {
            return false;
        }
        return e(new File(str));
    }

    public static final boolean e(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            P(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    e(listFiles[i]);
                    i++;
                }
                P(file);
            }
        }
        return true;
    }

    public static boolean c(File file, String str) {
        if (str == null) {
            return false;
        }
        String Q = Q(file);
        if (Q != null) {
            return str.equals(Q);
        }
        return false;
    }

    public static boolean QD(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".dex");
    }

    public static boolean d(File file, String str) {
        ZipFile zipFile;
        Throwable th;
        boolean z = false;
        if (file == null || str == null) {
            return z;
        }
        Object Q;
        if (QD(file.getName())) {
            Q = Q(file);
        } else {
            try {
                zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry("classes.dex");
                    if (entry == null) {
                        new StringBuilder("There's no entry named: classes.dex in ").append(file.getAbsolutePath());
                        try {
                            zipFile.close();
                            return z;
                        } catch (Throwable th2) {
                            return z;
                        }
                    }
                    Q = q(zipFile.getInputStream(entry));
                    try {
                        zipFile.close();
                    } catch (Throwable th3) {
                    }
                } catch (Throwable th4) {
                    try {
                        new StringBuilder("Bad dex jar file: ").append(file.getAbsolutePath());
                        if (zipFile != null) {
                            return z;
                        }
                        try {
                            zipFile.close();
                            return z;
                        } catch (Throwable th5) {
                            return z;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable th7) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                zipFile = null;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        }
        return str.equals(Q);
    }

    public static void h(File file, File file2) {
        Closeable fileOutputStream;
        Throwable th;
        Closeable closeable = null;
        File parentFile = file2.getParentFile();
        if (!(parentFile == null || parentFile.exists())) {
            parentFile.mkdirs();
        }
        try {
            Closeable fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2, false);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                closeable = fileInputStream;
                c(closeable);
                c(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        c(fileInputStream);
                        c(fileOutputStream);
                        return;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = fileInputStream;
                c(closeable);
                c(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            c(closeable);
            c(fileOutputStream);
            throw th;
        }
    }

    public static String a(JarFile jarFile, JarEntry jarEntry) {
        Closeable bufferedInputStream;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        c(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            c(bufferedInputStream);
            throw th;
        }
    }

    private static String q(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder stringBuilder = new StringBuilder(32);
                byte[] bArr = new byte[102400];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                for (byte b : digest) {
                    stringBuilder.append(Integer.toString((b & WebView.NORMAL_MODE_ALPHA) + FileUtils.S_IRUSR, 16).substring(1));
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String Q(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        if (file == null || !file.exists()) {
            return null;
        }
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                String q = q(fileInputStream2);
                fileInputStream2.close();
                try {
                    fileInputStream2.close();
                    return q;
                } catch (IOException e) {
                    return q;
                }
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static String i(File file, File file2) {
        String name = file.getName();
        if (!name.endsWith(".dex")) {
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf < 0) {
                name = name + ".dex";
            } else {
                StringBuilder stringBuilder = new StringBuilder(lastIndexOf + 4);
                stringBuilder.append(name, 0, lastIndexOf);
                stringBuilder.append(".dex");
                name = stringBuilder.toString();
            }
        }
        return new File(file2, name).getPath();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean e(File file, String str) {
        Throwable th;
        Throwable th2;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("resources.arsc");
                if (entry == null) {
                    a(zipFile2);
                    return false;
                }
                Closeable inputStream = zipFile2.getInputStream(entry);
                String q = q(inputStream);
                if (q == null || !q.equals(str)) {
                    c(inputStream);
                    a(zipFile2);
                    return false;
                }
                c(inputStream);
                a(zipFile2);
                return true;
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = zipFile2;
                a(zipFile);
                throw th2;
            }
        } catch (Throwable th4) {
            th = th4;
            new StringBuilder("checkResourceArscMd5 throwable:").append(th.getMessage());
            a(zipFile);
            return false;
        }
    }

    public static void R(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }
}
