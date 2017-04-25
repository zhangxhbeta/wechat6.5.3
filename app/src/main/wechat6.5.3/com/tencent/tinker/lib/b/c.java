package com.tencent.tinker.lib.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class c extends b {
    static boolean a(Context context, String str, String str2, File file) {
        Closeable closeable;
        Closeable closeable2;
        Throwable th;
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.i(str2, arrayList);
        if (arrayList.isEmpty()) {
            a.w("Tinker.BsDiffPatchInternal", "extract patch list is empty! type:%s:", new Object[]{ShareTinkerInternals.zB(5)});
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        com.tencent.tinker.lib.d.a gh = com.tencent.tinker.lib.d.a.gh(context);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            a.w("Tinker.BsDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
            return false;
        }
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3;
        ZipFile zipFile4;
        try {
            zipFile3 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile4 = new ZipFile(file);
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3;
                        ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (shareBsDiffPatchInfo.path.equals("")) {
                            str3 = shareBsDiffPatchInfo.name;
                        } else {
                            str3 = shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name;
                        }
                        String str4 = shareBsDiffPatchInfo.aZy;
                        if (SharePatchFileUtil.QB(str4)) {
                            File file3 = new File(str + (shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name));
                            if (!file3.exists()) {
                                file3.getParentFile().mkdirs();
                            } else if (str4.equals(SharePatchFileUtil.Q(file3))) {
                                a.w("Tinker.BsDiffPatchInternal", "bsdiff file %s is already exist, and md5 match, just continue", new Object[]{file3.getPath()});
                            } else {
                                a.w("Tinker.BsDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                file3.delete();
                            }
                            String str5 = shareBsDiffPatchInfo.aQp;
                            ZipEntry entry = zipFile4.getEntry(str3);
                            if (entry == null) {
                                a.w("Tinker.BsDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                gh.pFM.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            } else if (str5.equals("0")) {
                                if (!b.a(zipFile4, entry, file3, str4, false)) {
                                    a.w("Tinker.BsDiffPatchInternal", "Failed to extract file " + file3.getPath(), new Object[0]);
                                    gh.pFM.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                            } else if (SharePatchFileUtil.QB(str5)) {
                                ZipEntry entry2 = zipFile3.getEntry(str3);
                                if (entry2 == null) {
                                    a.w("Tinker.BsDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                    gh.pFM.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                                str5 = shareBsDiffPatchInfo.pGH;
                                if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                    closeable = null;
                                    closeable2 = null;
                                    closeable = zipFile3.getInputStream(entry2);
                                    closeable2 = zipFile4.getInputStream(entry);
                                    com.tencent.tinker.b.a.a(closeable, closeable2, file3);
                                    SharePatchFileUtil.c(closeable);
                                    SharePatchFileUtil.c(closeable2);
                                    if (SharePatchFileUtil.c(file3, str4)) {
                                        a.w("Tinker.BsDiffPatchInternal", "success recover bsdiff file: %s, use time: %d", new Object[]{file3.getPath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    } else {
                                        a.w("Tinker.BsDiffPatchInternal", "Failed to recover diff file " + file3.getPath(), new Object[0]);
                                        gh.pFM.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                        SharePatchFileUtil.P(file3);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile4);
                                        return false;
                                    }
                                }
                                a.e("Tinker.BsDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                gh.pFM.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            } else {
                                a.w("Tinker.BsDiffPatchInternal", "meta file md5 mismatch, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.zB(5), shareBsDiffPatchInfo.name, str5});
                                gh.pFM.d(file, b.zw(5));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                        }
                        a.w("Tinker.BsDiffPatchInternal", "meta file md5 mismatch, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.zB(5), shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.aZy});
                        gh.pFM.d(file, b.zw(5));
                        SharePatchFileUtil.a(zipFile3);
                        SharePatchFileUtil.a(zipFile4);
                        return false;
                    }
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(zipFile4);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile4 = null;
                SharePatchFileUtil.a(zipFile3);
                SharePatchFileUtil.a(zipFile4);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.a(zipFile3);
            SharePatchFileUtil.a(zipFile4);
            throw th;
        }
    }
}
