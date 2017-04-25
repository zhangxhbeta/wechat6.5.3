package com.tencent.tinker.lib.b;

import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class b {
    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str, boolean z) {
        boolean z2 = false;
        int i = 0;
        while (i < 2 && !z2) {
            i++;
            Closeable bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            a.i("Tinker.BasePatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                byte[] bArr = new byte[16384];
                for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                if (z) {
                    z2 = SharePatchFileUtil.d(file, str);
                } else {
                    z2 = SharePatchFileUtil.c(file, str);
                }
                a.i("Tinker.BasePatchInternal", "isExtractionSuccessful: %b", new Object[]{Boolean.valueOf(z2)});
                if (!z2) {
                    file.delete();
                    if (file.exists()) {
                        a.e("Tinker.BasePatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                    }
                }
            } finally {
                SharePatchFileUtil.c(bufferedOutputStream);
                SharePatchFileUtil.c(bufferedInputStream);
            }
        }
        return z2;
    }

    public static int zw(int i) {
        if (i == 3) {
            return -3;
        }
        if (i == 5) {
            return -4;
        }
        if (i == 6) {
            return -8;
        }
        return 0;
    }
}
