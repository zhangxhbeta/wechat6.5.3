package com.tencent.tinker.lib.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.lib.d.a;
import com.tencent.tinker.loader.TinkerParallelDexOptimizer;
import com.tencent.tinker.loader.TinkerParallelDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import dalvik.system.DexFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class d extends b {
    static boolean b(Context context, String str, String str2, File file) {
        String str3 = str + "/dex/";
        if (c(context, str3, str2, file)) {
            final a gh = a.gh(context);
            File[] listFiles = new File(str3).listFiles();
            if (listFiles == null) {
                return true;
            }
            final String str4 = str + "/odex/";
            File file2 = new File(str4);
            if (file2.exists() || file2.mkdirs()) {
                com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d", new Object[]{Integer.valueOf(listFiles.length)});
                final File file3 = file;
                boolean a = TinkerParallelDexOptimizer.a(listFiles, file2, new ResultCallback() {
                    long startTime;

                    public final void J(File file) {
                        this.startTime = System.currentTimeMillis();
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "start to optimize dex %s", new Object[]{file.getPath()});
                    }

                    public final void K(File file) {
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "success to optimize dex %s use time %d", new Object[]{file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                    }

                    public final void b(File file, Throwable th) {
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "fail to optimize dex %s use time %d", new Object[]{file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                        SharePatchFileUtil.P(file);
                        gh.pFM.a(file3, file, str4, file.getName(), th);
                    }
                });
                if (!a) {
                    return a;
                }
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file4 = listFiles[i];
                    try {
                        if (SharePatchFileUtil.N(file4)) {
                            String i2 = SharePatchFileUtil.i(file4, file2);
                            File file5 = new File(i2);
                            if (!SharePatchFileUtil.N(file5)) {
                                com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s fail, optimize again", new Object[]{i2});
                                long currentTimeMillis = System.currentTimeMillis();
                                DexFile.loadDex(file4.getAbsolutePath(), i2, 0);
                                com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "success single dex optimize file, path: %s, use time: %d", new Object[]{file4.getPath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                if (!SharePatchFileUtil.N(file5)) {
                                    gh.pFM.a(file, file4, str4, file4.getName(), new TinkerRuntimeException("dexOpt file:" + i2 + " is not exist"));
                                    return false;
                                }
                            }
                            i++;
                        } else {
                            com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "single dex optimizer file %s is not exist, just return false", new Object[]{file4});
                            return false;
                        }
                    } catch (Throwable th) {
                        com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "dex optimize or load failed, path:" + file4.getPath(), new Object[0]);
                        SharePatchFileUtil.P(file4);
                        gh.pFM.a(file, file4, str4, file4.getName(), th);
                        return false;
                    }
                }
                return a;
            }
            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
            return false;
        }
        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
        return false;
    }

    private static boolean c(Context context, String str, String str2, File file) {
        Throwable th;
        ZipFile zipFile;
        Throwable th2;
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.j(str2, arrayList);
        if (arrayList.isEmpty()) {
            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", new Object[]{ShareTinkerInternals.zB(3)});
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        a gh = a.gh(context);
        ZipFile zipFile2;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                SharePatchFileUtil.a(null);
                SharePatchFileUtil.a(null);
                return false;
            }
            ZipFile zipFile3 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile2 = new ZipFile(file);
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3;
                        ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (shareDexDiffPatchInfo.path.equals("")) {
                            str3 = shareDexDiffPatchInfo.pGI;
                        } else {
                            str3 = shareDexDiffPatchInfo.path + "/" + shareDexDiffPatchInfo.pGI;
                        }
                        String str4 = shareDexDiffPatchInfo.pGM;
                        String str5 = shareDexDiffPatchInfo.pGL;
                        if (ShareTinkerInternals.bPb() || !shareDexDiffPatchInfo.pGJ.equals("0")) {
                            String str6 = ShareTinkerInternals.bPb() ? shareDexDiffPatchInfo.pGK : shareDexDiffPatchInfo.pGJ;
                            if (SharePatchFileUtil.QB(str6)) {
                                File file3 = new File(str + shareDexDiffPatchInfo.cGS);
                                if (!file3.exists()) {
                                    file3.getParentFile().mkdirs();
                                } else if (SharePatchFileUtil.d(file3, str6)) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", new Object[]{file3.getPath()});
                                } else {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                    file3.delete();
                                }
                                ZipEntry entry = zipFile2.getEntry(str3);
                                ZipEntry entry2 = zipFile3.getEntry(str3);
                                if (str5.equals("0")) {
                                    if (entry == null) {
                                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                        gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile2);
                                        return false;
                                    } else if (!a(zipFile2, entry, file3, shareDexDiffPatchInfo)) {
                                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                        gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile2);
                                        return false;
                                    }
                                } else if (str4.equals("0")) {
                                    if (!ShareTinkerInternals.bPb()) {
                                        continue;
                                    } else if (entry2 == null) {
                                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                        gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile2);
                                        return false;
                                    } else {
                                        if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                            a(zipFile3, entry2, file3, shareDexDiffPatchInfo);
                                            if (!SharePatchFileUtil.d(file3, str6)) {
                                                com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                                SharePatchFileUtil.P(file3);
                                                SharePatchFileUtil.a(zipFile3);
                                                SharePatchFileUtil.a(zipFile2);
                                                return false;
                                            }
                                        } else {
                                            com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                            gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                            SharePatchFileUtil.a(zipFile3);
                                            SharePatchFileUtil.a(zipFile2);
                                            return false;
                                        }
                                    }
                                } else if (entry == null) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                    gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                } else if (!SharePatchFileUtil.QB(str4)) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.zB(3), shareDexDiffPatchInfo.pGI, str4});
                                    gh.pFM.d(file, b.zw(3));
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                } else if (entry2 == null) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                    gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                } else {
                                    if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                        a(zipFile3, zipFile2, entry2, entry, shareDexDiffPatchInfo, file3);
                                        if (SharePatchFileUtil.d(file3, str6)) {
                                            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, use time: %d", new Object[]{file3.getPath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                        } else {
                                            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                            gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                            SharePatchFileUtil.P(file3);
                                            SharePatchFileUtil.a(zipFile3);
                                            SharePatchFileUtil.a(zipFile2);
                                            return false;
                                        }
                                    }
                                    com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                    gh.pFM.a(file, file3, shareDexDiffPatchInfo.pGI, 3);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                }
                            }
                            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.zB(3), shareDexDiffPatchInfo.pGI, str6});
                            gh.pFM.d(file, b.zw(3));
                            SharePatchFileUtil.a(zipFile3);
                            SharePatchFileUtil.a(zipFile2);
                            return false;
                        }
                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", new Object[]{str3});
                    }
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(zipFile2);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    zipFile = zipFile3;
                    th2 = th;
                }
            } catch (Throwable th4) {
                th = th4;
                zipFile2 = null;
                zipFile = zipFile3;
                th2 = th;
                SharePatchFileUtil.a(zipFile);
                SharePatchFileUtil.a(zipFile2);
                throw th2;
            }
        } catch (Throwable th5) {
            th2 = th5;
            zipFile = null;
            zipFile2 = null;
            SharePatchFileUtil.a(zipFile);
            SharePatchFileUtil.a(zipFile2);
            throw th2;
        }
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Closeable bufferedInputStream;
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        int i = 0;
        while (i < 2 && !z) {
            int i2 = i + 1;
            OutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                Closeable zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[16384];
                        zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                        for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.closeEntry();
                        SharePatchFileUtil.c(bufferedInputStream);
                        SharePatchFileUtil.c(zipOutputStream);
                        z = SharePatchFileUtil.d(file, str);
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", new Object[]{Boolean.valueOf(z)});
                        if (!z) {
                            file.delete();
                            if (file.exists()) {
                                com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                            }
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = zipOutputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                    closeable = zipOutputStream;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        }
        return z;
        SharePatchFileUtil.c(bufferedInputStream);
        SharePatchFileUtil.c(closeable);
        throw th;
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        String str = ShareTinkerInternals.bPb() ? shareDexDiffPatchInfo.pGK : shareDexDiffPatchInfo.pGJ;
        String str2 = shareDexDiffPatchInfo.pGI;
        boolean z = shareDexDiffPatchInfo.pGO;
        if (SharePatchFileUtil.QD(str2) && z) {
            return a(zipFile, zipEntry, file, str);
        }
        return b.a(zipFile, zipEntry, file, str, true);
    }

    private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
        Throwable th;
        Closeable closeable;
        OutputStream outputStream = null;
        Closeable closeable2;
        try {
            Closeable bufferedInputStream;
            Closeable bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            if (zipEntry2 != null) {
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = bufferedInputStream2;
                    SharePatchFileUtil.c(closeable2);
                    SharePatchFileUtil.c(closeable);
                    throw th;
                }
            }
            bufferedInputStream = null;
            try {
                boolean QD = SharePatchFileUtil.QD(shareDexDiffPatchInfo.pGI);
                if (!QD || shareDexDiffPatchInfo.pGO) {
                    try {
                        Closeable zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                            if (QD) {
                                new com.tencent.tinker.c.a.a(bufferedInputStream2, (int) zipEntry.getSize(), bufferedInputStream).b(zipOutputStream);
                            } else {
                                try {
                                    ZipEntry nextEntry;
                                    closeable2 = new ZipInputStream(bufferedInputStream2);
                                    do {
                                        try {
                                            nextEntry = closeable2.getNextEntry();
                                            if (nextEntry == null) {
                                                break;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    } while (!"classes.dex".equals(nextEntry.getName()));
                                    if (nextEntry == null) {
                                        throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                    }
                                    new com.tencent.tinker.c.a.a(closeable2, (int) nextEntry.getSize(), bufferedInputStream).b(zipOutputStream);
                                    SharePatchFileUtil.c(closeable2);
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable2 = null;
                                    SharePatchFileUtil.c(closeable2);
                                    throw th;
                                }
                            }
                            zipOutputStream.closeEntry();
                            SharePatchFileUtil.c(zipOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = zipOutputStream;
                            SharePatchFileUtil.c(closeable);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        SharePatchFileUtil.c(closeable);
                        throw th;
                    }
                }
                com.tencent.tinker.c.a.a aVar = new com.tencent.tinker.c.a.a(bufferedInputStream2, (int) zipEntry.getSize(), bufferedInputStream);
                try {
                    OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        aVar.b(bufferedOutputStream);
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        outputStream = bufferedOutputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
                SharePatchFileUtil.c(bufferedInputStream2);
                SharePatchFileUtil.c(bufferedInputStream);
            } catch (Throwable th9) {
                th = th9;
                closeable = bufferedInputStream;
                closeable2 = bufferedInputStream2;
            }
        } catch (Throwable th10) {
            th = th10;
            closeable2 = null;
            SharePatchFileUtil.c(closeable2);
            SharePatchFileUtil.c(closeable);
            throw th;
        }
    }
}
